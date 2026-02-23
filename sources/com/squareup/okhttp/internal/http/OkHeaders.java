package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class OkHeaders {
    private static final Comparator FIELD_NAME_COMPARATOR = new 1();
    static final String PREFIX;
    public static final String RECEIVED_MILLIS;
    public static final String RESPONSE_SOURCE;
    public static final String SELECTED_PROTOCOL;
    public static final String SENT_MILLIS;

    public static class 1 implements Comparator {
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    static {
        String prefix = Platform.get().getPrefix();
        PREFIX = prefix;
        SENT_MILLIS = prefix + "-Sent-Millis";
        RECEIVED_MILLIS = prefix + "-Received-Millis";
        SELECTED_PROTOCOL = prefix + "-Selected-Protocol";
        RESPONSE_SOURCE = prefix + "-Response-Source";
    }

    private OkHeaders() {
    }

    public static void addCookies(Request.Builder builder, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if ("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) {
                if (!((List) entry.getValue()).isEmpty()) {
                    builder.addHeader(str, buildCookieHeader((List) entry.getValue()));
                }
            }
        }
    }

    private static String buildCookieHeader(List list) {
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            sb.append((String) list.get(i));
        }
        return sb.toString();
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    public static boolean isEndToEnd(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static List parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                int i2 = 0;
                while (i2 < value.length()) {
                    int skipUntil = HeaderParser.skipUntil(value, i2, " ");
                    String trim = value.substring(i2, skipUntil).trim();
                    int skipWhitespace = HeaderParser.skipWhitespace(value, skipUntil);
                    if (!value.regionMatches(true, skipWhitespace, "realm=\"", 0, 7)) {
                        break;
                    }
                    int i3 = skipWhitespace + 7;
                    int skipUntil2 = HeaderParser.skipUntil(value, i3, "\"");
                    String substring = value.substring(i3, skipUntil2);
                    i2 = HeaderParser.skipWhitespace(value, HeaderParser.skipUntil(value, skipUntil2 + 1, ",") + 1);
                    arrayList.add(new Challenge(trim, substring));
                }
            }
        }
        return arrayList;
    }

    public static Request processAuthHeader(Authenticator authenticator, Response response, Proxy proxy) throws IOException {
        return response.code() == 407 ? authenticator.authenticateProxy(proxy, response) : authenticator.authenticate(proxy, response);
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Map toMultimap(Headers headers, String str) {
        TreeMap treeMap = new TreeMap(FIELD_NAME_COMPARATOR);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(name);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(value);
            treeMap.put(name, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put((Object) null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static Set varyFields(Headers headers) {
        TreeSet emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : value.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static long contentLength(Request request) {
        return contentLength(request.headers());
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    private static Set varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }
}
