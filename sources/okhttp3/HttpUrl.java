package okhttp3;

import B8.h;
import E8.e;
import E8.n;
import E8.o;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import l8.E;
import l8.k;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class HttpUrl {

    @NotNull
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET = "";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";

    @NotNull
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";

    @NotNull
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";

    @NotNull
    public static final String QUERY_ENCODE_SET = " \"'<>#";

    @NotNull
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @Nullable
    private final String fragment;

    @NotNull
    private final String host;
    private final boolean isHttps;

    @NotNull
    private final String password;

    @NotNull
    private final List pathSegments;
    private final int port;
    private final List queryNamesAndValues;

    @NotNull
    private final String scheme;
    private final String url;

    @NotNull
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final class Builder {
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final String INVALID_HOST = "Invalid URL host";

        @Nullable
        private String encodedFragment;

        @NotNull
        private final List encodedPathSegments;

        @Nullable
        private List encodedQueryNamesAndValues;

        @Nullable
        private String host;

        @Nullable
        private String scheme;

        @NotNull
        private String encodedUsername = "";

        @NotNull
        private String encodedPassword = "";
        private int port = -1;

        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ int access$parsePort(Companion companion, String str, int i, int i2) {
                return companion.parsePort(str, i, i2);
            }

            public static final /* synthetic */ int access$portColonOffset(Companion companion, String str, int i, int i2) {
                return companion.portColonOffset(str, i, i2);
            }

            public static final /* synthetic */ int access$schemeDelimiterOffset(Companion companion, String str, int i, int i2) {
                return companion.schemeDelimiterOffset(str, i, i2);
            }

            public static final /* synthetic */ int access$slashCount(Companion companion, String str, int i, int i2) {
                return companion.slashCount(str, i, i2);
            }

            private final int parsePort(String str, int i, int i2) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i, i2, "", false, false, false, false, null, 248, null));
                    if (1 <= parseInt && 65535 >= parseInt) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            private final int portColonOffset(String str, int i, int i2) {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt == ':') {
                        return i;
                    }
                    if (charAt == '[') {
                        do {
                            i++;
                            if (i < i2) {
                            }
                        } while (str.charAt(i) != ']');
                    }
                    i++;
                }
                return i2;
            }

            private final int schemeDelimiterOffset(String str, int i, int i2) {
                if (i2 - i < 2) {
                    return -1;
                }
                char charAt = str.charAt(i);
                if ((l.f(charAt, 97) < 0 || l.f(charAt, 122) > 0) && (l.f(charAt, 65) < 0 || l.f(charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i2) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i);
                    if ('a' > charAt2 || 'z' < charAt2) {
                        if ('A' > charAt2 || 'Z' < charAt2) {
                            if ('0' > charAt2 || '9' < charAt2) {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            private final int slashCount(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            l.b(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return l.a(str, ".") || n.o(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return l.a(str, "..") || n.o(str, "%2e.", true) || n.o(str, ".%2e", true) || n.o(str, "%2e%2e", true);
        }

        private final void pop() {
            if (((String) this.encodedPathSegments.remove(r0.size() - 1)).length() != 0 || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(r0.size() - 1, "");
            }
        }

        private final void push(String str, int i, int i2, boolean z, boolean z2) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            if (((CharSequence) this.encodedPathSegments.get(r2.size() - 1)).length() == 0) {
                this.encodedPathSegments.set(r2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List list = this.encodedQueryNamesAndValues;
            l.b(list);
            B8.a l = h.l(h.j(list.size() - 2, 0), 2);
            int d = l.d();
            int f = l.f();
            int g = l.g();
            if (g >= 0) {
                if (d > f) {
                    return;
                }
            } else if (d < f) {
                return;
            }
            while (true) {
                List list2 = this.encodedQueryNamesAndValues;
                l.b(list2);
                if (l.a(str, (String) list2.get(d))) {
                    List list3 = this.encodedQueryNamesAndValues;
                    l.b(list3);
                    list3.remove(d + 1);
                    List list4 = this.encodedQueryNamesAndValues;
                    l.b(list4);
                    list4.remove(d);
                    List list5 = this.encodedQueryNamesAndValues;
                    l.b(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (d == f) {
                    return;
                } else {
                    d += g;
                }
            }
        }

        private final void resolvePath(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i++;
            } else {
                List list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = Util.delimiterOffset(str, "/\\", i3, i2);
                boolean z = i < i2;
                push(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        @NotNull
        public final Builder addEncodedPathSegment(@NotNull String encodedPathSegment) {
            l.e(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        @NotNull
        public final Builder addEncodedPathSegments(@NotNull String encodedPathSegments) {
            l.e(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        @NotNull
        public final Builder addEncodedQueryParameter(@NotNull String encodedName, @Nullable String str) {
            l.e(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List list = this.encodedQueryNamesAndValues;
            l.b(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            List list2 = this.encodedQueryNamesAndValues;
            l.b(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null) : null);
            return this;
        }

        @NotNull
        public final Builder addPathSegment(@NotNull String pathSegment) {
            l.e(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        @NotNull
        public final Builder addPathSegments(@NotNull String pathSegments) {
            l.e(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        @NotNull
        public final Builder addQueryParameter(@NotNull String name, @Nullable String str) {
            l.e(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List list = this.encodedQueryNamesAndValues;
            l.b(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List list2 = this.encodedQueryNamesAndValues;
            l.b(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null) : null);
            return this;
        }

        @NotNull
        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.Companion;
            String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
            String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int effectivePort = effectivePort();
            Iterable iterable = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(l8.l.o(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0, false, 7, null));
            }
            Iterable iterable2 = this.encodedQueryNamesAndValues;
            if (iterable2 != null) {
                Iterable<String> iterable3 = iterable2;
                arrayList = new ArrayList(l8.l.o(iterable3, 10));
                for (String str3 : iterable3) {
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, arrayList2, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, null) : null, toString());
        }

        @NotNull
        public final Builder encodedFragment(@Nullable String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null) : null;
            return this;
        }

        @NotNull
        public final Builder encodedPassword(@NotNull String encodedPassword) {
            l.e(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @NotNull
        public final Builder encodedPath(@NotNull String encodedPath) {
            l.e(encodedPath, "encodedPath");
            if (n.B(encodedPath, "/", false, 2, null)) {
                resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.HttpUrl.Builder encodedQuery(@org.jetbrains.annotations.Nullable java.lang.String r14) {
            /*
                r13 = this;
                if (r14 == 0) goto L1d
                okhttp3.HttpUrl$Companion r12 = okhttp3.HttpUrl.Companion
                r10 = 211(0xd3, float:2.96E-43)
                r11 = 0
                r2 = 0
                r3 = 0
                java.lang.String r4 = " \"'<>#"
                r5 = 1
                r6 = 0
                r7 = 1
                r8 = 0
                r9 = 0
                r0 = r12
                r1 = r14
                java.lang.String r14 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r14 == 0) goto L1d
                java.util.List r14 = r12.toQueryNamesAndValues$okhttp(r14)
                goto L1e
            L1d:
                r14 = 0
            L1e:
                r13.encodedQueryNamesAndValues = r14
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.encodedQuery(java.lang.String):okhttp3.HttpUrl$Builder");
        }

        @NotNull
        public final Builder encodedUsername(@NotNull String encodedUsername) {
            l.e(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @NotNull
        public final Builder fragment(@Nullable String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, 187, null) : null;
            return this;
        }

        @Nullable
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        @NotNull
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        @NotNull
        public final List getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @Nullable
        public final List getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @NotNull
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        @Nullable
        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        @Nullable
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        @NotNull
        public final Builder host(@NotNull String host) {
            l.e(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        @NotNull
        public final Builder parse$okhttp(@Nullable HttpUrl httpUrl, @NotNull String input) {
            int delimiterOffset;
            int i;
            int i2;
            int i3;
            String str;
            int i4;
            boolean z;
            boolean z2;
            l.e(input, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int access$schemeDelimiterOffset = Companion.access$schemeDelimiterOffset(companion, input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            String str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            char c = 65535;
            if (access$schemeDelimiterOffset != -1) {
                if (n.y(input, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!n.y(input, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input.substring(0, access$schemeDelimiterOffset);
                        l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(substring);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme();
            }
            int access$slashCount = Companion.access$slashCount(companion, input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c2 = '?';
            char c3 = '#';
            if (access$slashCount >= 2 || httpUrl == null || (!l.a(httpUrl.scheme(), this.scheme))) {
                int i5 = indexOfFirstNonAsciiWhitespace$default + access$slashCount;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(input, "@/\\?#", i5, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? input.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == c || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt != '@') {
                        i3 = indexOfLastNonAsciiWhitespace$default;
                        str = str2;
                    } else {
                        if (z3) {
                            i3 = indexOfLastNonAsciiWhitespace$default;
                            str = str2;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            i4 = delimiterOffset;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, i5, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb2.toString();
                            z = z4;
                        } else {
                            int delimiterOffset2 = Util.delimiterOffset(input, ':', i5, delimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            i3 = indexOfLastNonAsciiWhitespace$default;
                            str = str2;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i5, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z4) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            i4 = delimiterOffset;
                            if (delimiterOffset2 != i4) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, input, delimiterOffset2 + 1, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z2 = true;
                            } else {
                                z2 = z3;
                            }
                            z3 = z2;
                            z = true;
                        }
                        i5 = i4 + 1;
                        z4 = z;
                    }
                    str2 = str;
                    indexOfLastNonAsciiWhitespace$default = i3;
                    c3 = '#';
                    c2 = '?';
                    c = 65535;
                }
                i = indexOfLastNonAsciiWhitespace$default;
                String str3 = str2;
                Companion companion3 = Companion;
                int access$portColonOffset = Companion.access$portColonOffset(companion3, input, i5, delimiterOffset);
                int i6 = access$portColonOffset + 1;
                if (i6 < delimiterOffset) {
                    i2 = i5;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, i5, access$portColonOffset, false, 4, null));
                    int access$parsePort = Companion.access$parsePort(companion3, input, i6, delimiterOffset);
                    this.port = access$parsePort;
                    if (!(access$parsePort != -1)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = input.substring(i6, delimiterOffset);
                        l.d(substring2, str3);
                        sb3.append(substring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    i2 = i5;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, input, i2, access$portColonOffset, false, 4, null));
                    String str4 = this.scheme;
                    l.b(str4);
                    this.port = companion4.defaultPort(str4);
                }
                if (!(this.host != null)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = input.substring(i2, access$portColonOffset);
                    l.d(substring3, str3);
                    sb4.append(substring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i = indexOfLastNonAsciiWhitespace$default;
            }
            int i7 = i;
            int delimiterOffset3 = Util.delimiterOffset(input, "?#", indexOfFirstNonAsciiWhitespace$default, i7);
            resolvePath(input, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i7 && input.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(input, '#', delimiterOffset3, i7);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i7 && input.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, delimiterOffset3 + 1, i7, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        @NotNull
        public final Builder password(@NotNull String password) {
            l.e(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        @NotNull
        public final Builder port(int i) {
            if (1 <= i && 65535 >= i) {
                this.port = i;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i).toString());
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.HttpUrl.Builder query(@org.jetbrains.annotations.Nullable java.lang.String r14) {
            /*
                r13 = this;
                if (r14 == 0) goto L1d
                okhttp3.HttpUrl$Companion r12 = okhttp3.HttpUrl.Companion
                r10 = 219(0xdb, float:3.07E-43)
                r11 = 0
                r2 = 0
                r3 = 0
                java.lang.String r4 = " \"'<>#"
                r5 = 0
                r6 = 0
                r7 = 1
                r8 = 0
                r9 = 0
                r0 = r12
                r1 = r14
                java.lang.String r14 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r14 == 0) goto L1d
                java.util.List r14 = r12.toQueryNamesAndValues$okhttp(r14)
                goto L1e
            L1d:
                r14 = 0
            L1e:
                r13.encodedQueryNamesAndValues = r14
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.query(java.lang.String):okhttp3.HttpUrl$Builder");
        }

        @NotNull
        public final Builder reencodeForUri$okhttp() {
            CharSequence charSequence = this.host;
            this.host = charSequence != null ? new e("[\"<>^`{|}]").b(charSequence, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                List list = this.encodedPathSegments;
                list.set(i, Companion.canonicalize$okhttp$default(HttpUrl.Companion, (String) list.get(i), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) list2.get(i2);
                    list2.set(i2, str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null) : null);
                }
            }
            String str2 = this.encodedFragment;
            this.encodedFragment = str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null;
            return this;
        }

        @NotNull
        public final Builder removeAllEncodedQueryParameters(@NotNull String encodedName) {
            l.e(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            return this;
        }

        @NotNull
        public final Builder removeAllQueryParameters(@NotNull String name) {
            l.e(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            return this;
        }

        @NotNull
        public final Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        @NotNull
        public final Builder scheme(@NotNull String scheme) {
            l.e(scheme, "scheme");
            String str = "http";
            if (!n.o(scheme, "http", true)) {
                str = "https";
                if (!n.o(scheme, "https", true)) {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
            }
            this.scheme = str;
            return this;
        }

        public final void setEncodedFragment$okhttp(@Nullable String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(@NotNull String str) {
            l.e(str, "<set-?>");
            this.encodedPassword = str;
        }

        @NotNull
        public final Builder setEncodedPathSegment(int i, @NotNull String encodedPathSegment) {
            l.e(encodedPathSegment, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, " \"<>^`{}|/\\?#", true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i, canonicalize$okhttp$default);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@Nullable List list) {
            this.encodedQueryNamesAndValues = list;
        }

        @NotNull
        public final Builder setEncodedQueryParameter(@NotNull String encodedName, @Nullable String str) {
            l.e(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(@NotNull String str) {
            l.e(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(@Nullable String str) {
            this.host = str;
        }

        @NotNull
        public final Builder setPathSegment(int i, @NotNull String pathSegment) {
            l.e(pathSegment, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, " \"<>^`{}|/\\?#", false, false, false, false, null, 251, null);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                this.encodedPathSegments.set(i, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        @NotNull
        public final Builder setQueryParameter(@NotNull String name, @Nullable String str) {
            l.e(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(@Nullable String str) {
            this.scheme = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
            Le:
                r0.append(r1)
                goto L15
            L12:
                java.lang.String r1 = "//"
                goto Le
            L15:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 58
                if (r1 <= 0) goto L20
                goto L28
            L20:
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L42
            L28:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L3d
                r0.append(r2)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L3d:
                r1 = 64
                r0.append(r1)
            L42:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L67
                kotlin.jvm.internal.l.b(r1)
                r3 = 2
                r4 = 0
                r5 = 0
                boolean r1 = E8.o.F(r1, r2, r5, r3, r4)
                if (r1 == 0) goto L62
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L67
            L62:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L67:
                int r1 = r6.port
                r3 = -1
                if (r1 != r3) goto L70
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L89
            L70:
                int r1 = r6.effectivePort()
                java.lang.String r3 = r6.scheme
                if (r3 == 0) goto L83
                okhttp3.HttpUrl$Companion r4 = okhttp3.HttpUrl.Companion
                kotlin.jvm.internal.l.b(r3)
                int r3 = r4.defaultPort(r3)
                if (r1 == r3) goto L89
            L83:
                r0.append(r2)
                r0.append(r1)
            L89:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List r2 = r6.encodedPathSegments
                r1.toPathString$okhttp(r2, r0)
                java.util.List r2 = r6.encodedQueryNamesAndValues
                if (r2 == 0) goto La1
                r2 = 63
                r0.append(r2)
                java.util.List r2 = r6.encodedQueryNamesAndValues
                kotlin.jvm.internal.l.b(r2)
                r1.toQueryString$okhttp(r2, r0)
            La1:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto Laf
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            Laf:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.l.d(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        @NotNull
        public final Builder username(@NotNull String username) {
            l.e(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z) {
            int i = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i, str.length());
                push(str, i, delimiterOffset, delimiterOffset < str.length(), z);
                i = delimiterOffset + 1;
            } while (i <= str.length());
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return companion.canonicalize$okhttp(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util.parseHexDigit(str.charAt(i + 1)) != -1 && Util.parseHexDigit(str.charAt(i3)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i, i2, z);
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void writeCanonicalized(okio.Buffer r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                Method dump skipped, instructions count: 202
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(okio.Buffer, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void writePercentDecoded(okio.Buffer r6, java.lang.String r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
            L0:
                if (r8 >= r9) goto L52
                if (r7 == 0) goto L4a
                int r0 = r7.codePointAt(r8)
                r1 = 37
                if (r0 != r1) goto L33
                int r1 = r8 + 2
                if (r1 >= r9) goto L33
                int r2 = r8 + 1
                char r2 = r7.charAt(r2)
                int r2 = okhttp3.internal.Util.parseHexDigit(r2)
                char r3 = r7.charAt(r1)
                int r3 = okhttp3.internal.Util.parseHexDigit(r3)
                r4 = -1
                if (r2 == r4) goto L41
                if (r3 == r4) goto L41
                int r8 = r2 << 4
                int r8 = r8 + r3
                r6.writeByte(r8)
                int r8 = java.lang.Character.charCount(r0)
                int r8 = r8 + r1
                goto L0
            L33:
                r1 = 43
                if (r0 != r1) goto L41
                if (r10 == 0) goto L41
                r0 = 32
                r6.writeByte(r0)
                int r8 = r8 + 1
                goto L0
            L41:
                r6.writeUtf8CodePoint(r0)
                int r0 = java.lang.Character.charCount(r0)
                int r8 = r8 + r0
                goto L0
            L4a:
                java.lang.NullPointerException r6 = new java.lang.NullPointerException
                java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
                r6.<init>(r7)
                throw r6
            L52:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writePercentDecoded(okio.Buffer, java.lang.String, int, int, boolean):void");
        }

        @NotNull
        public final HttpUrl -deprecated_get(@NotNull String url) {
            l.e(url, "url");
            return get(url);
        }

        @Nullable
        public final HttpUrl -deprecated_parse(@NotNull String url) {
            l.e(url, "url");
            return parse(url);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0041  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String canonicalize$okhttp(@org.jetbrains.annotations.NotNull java.lang.String r14, int r15, int r16, @org.jetbrains.annotations.NotNull java.lang.String r17, boolean r18, boolean r19, boolean r20, boolean r21, @org.jetbrains.annotations.Nullable java.nio.charset.Charset r22) {
            /*
                r13 = this;
                r2 = r14
                r4 = r16
                r5 = r17
                java.lang.String r0 = "$this$canonicalize"
                kotlin.jvm.internal.l.e(r14, r0)
                java.lang.String r0 = "encodeSet"
                kotlin.jvm.internal.l.e(r5, r0)
                r3 = r15
            L10:
                if (r3 >= r4) goto L71
                int r0 = r14.codePointAt(r3)
                r1 = 32
                if (r0 < r1) goto L25
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 == r1) goto L25
                r1 = 128(0x80, float:1.794E-43)
                if (r0 < r1) goto L27
                if (r21 == 0) goto L25
                goto L27
            L25:
                r11 = r13
                goto L4f
            L27:
                char r1 = (char) r0
                r6 = 2
                r7 = 0
                r8 = 0
                boolean r1 = E8.o.F(r5, r1, r8, r6, r7)
                if (r1 != 0) goto L25
                r1 = 37
                if (r0 != r1) goto L41
                if (r18 == 0) goto L25
                if (r19 == 0) goto L41
                r11 = r13
                boolean r1 = r13.isPercentEncoded(r14, r3, r4)
                if (r1 == 0) goto L4f
                goto L42
            L41:
                r11 = r13
            L42:
                r1 = 43
                if (r0 != r1) goto L49
                if (r20 == 0) goto L49
                goto L4f
            L49:
                int r0 = java.lang.Character.charCount(r0)
                int r3 = r3 + r0
                goto L10
            L4f:
                okio.Buffer r12 = new okio.Buffer
                r12.<init>()
                r0 = r15
                r12.writeUtf8(r14, r15, r3)
                r0 = r13
                r1 = r12
                r2 = r14
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r10 = r22
                r0.writeCanonicalized(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                java.lang.String r0 = r12.readUtf8()
                return r0
            L71:
                r11 = r13
                r0 = r15
                java.lang.String r0 = r14.substring(r15, r16)
                java.lang.String r1 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.jvm.internal.l.d(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.canonicalize$okhttp(java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):java.lang.String");
        }

        public final int defaultPort(@NotNull String scheme) {
            l.e(scheme, "scheme");
            int hashCode = scheme.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    return 443;
                }
            } else if (scheme.equals("http")) {
                return 80;
            }
            return -1;
        }

        @NotNull
        public final HttpUrl get(@NotNull String toHttpUrl) {
            l.e(toHttpUrl, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, toHttpUrl).build();
        }

        @Nullable
        public final HttpUrl parse(@NotNull String toHttpUrlOrNull) {
            l.e(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return get(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @NotNull
        public final String percentDecode$okhttp(@NotNull String percentDecode, int i, int i2, boolean z) {
            l.e(percentDecode, "$this$percentDecode");
            for (int i3 = i; i3 < i2; i3++) {
                char charAt = percentDecode.charAt(i3);
                if (charAt == '%' || (charAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(percentDecode, i, i3);
                    writePercentDecoded(buffer, percentDecode, i3, i2, z);
                    return buffer.readUtf8();
                }
            }
            String substring = percentDecode.substring(i, i2);
            l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(@NotNull List toPathString, @NotNull StringBuilder out) {
            l.e(toPathString, "$this$toPathString");
            l.e(out, "out");
            int size = toPathString.size();
            for (int i = 0; i < size; i++) {
                out.append('/');
                out.append((String) toPathString.get(i));
            }
        }

        @NotNull
        public final List toQueryNamesAndValues$okhttp(@NotNull String toQueryNamesAndValues) {
            String str;
            l.e(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= toQueryNamesAndValues.length()) {
                int Q = o.Q(toQueryNamesAndValues, '&', i, false, 4, null);
                if (Q == -1) {
                    Q = toQueryNamesAndValues.length();
                }
                int i2 = Q;
                int Q2 = o.Q(toQueryNamesAndValues, '=', i, false, 4, null);
                if (Q2 == -1 || Q2 > i2) {
                    String substring = toQueryNamesAndValues.substring(i, i2);
                    l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    str = null;
                } else {
                    String substring2 = toQueryNamesAndValues.substring(i, Q2);
                    l.d(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    str = toQueryNamesAndValues.substring(Q2 + 1, i2);
                    l.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(str);
                i = i2 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(@NotNull List toQueryString, @NotNull StringBuilder out) {
            l.e(toQueryString, "$this$toQueryString");
            l.e(out, "out");
            B8.a l = h.l(h.m(0, toQueryString.size()), 2);
            int d = l.d();
            int f = l.f();
            int g = l.g();
            if (g >= 0) {
                if (d > f) {
                    return;
                }
            } else if (d < f) {
                return;
            }
            while (true) {
                String str = (String) toQueryString.get(d);
                String str2 = (String) toQueryString.get(d + 1);
                if (d > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (d == f) {
                    return;
                } else {
                    d += g;
                }
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @Nullable
        public final HttpUrl -deprecated_get(@NotNull URI uri) {
            l.e(uri, "uri");
            return get(uri);
        }

        @Nullable
        public final HttpUrl get(@NotNull URI toHttpUrlOrNull) {
            l.e(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String uri = toHttpUrlOrNull.toString();
            l.d(uri, "toString()");
            return parse(uri);
        }

        @Nullable
        public final HttpUrl -deprecated_get(@NotNull URL url) {
            l.e(url, "url");
            return get(url);
        }

        @Nullable
        public final HttpUrl get(@NotNull URL toHttpUrlOrNull) {
            l.e(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String url = toHttpUrlOrNull.toString();
            l.d(url, "toString()");
            return parse(url);
        }
    }

    public HttpUrl(@NotNull String scheme, @NotNull String username, @NotNull String password, @NotNull String host, int i, @NotNull List pathSegments, @Nullable List list, @Nullable String str, @NotNull String url) {
        l.e(scheme, "scheme");
        l.e(username, "username");
        l.e(password, "password");
        l.e(host, "host");
        l.e(pathSegments, "pathSegments");
        l.e(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = l.a(scheme, "https");
    }

    public static final /* synthetic */ char[] access$getHEX_DIGITS$cp() {
        return HEX_DIGITS;
    }

    public static final int defaultPort(@NotNull String str) {
        return Companion.defaultPort(str);
    }

    @NotNull
    public static final HttpUrl get(@NotNull String str) {
        return Companion.get(str);
    }

    @Nullable
    public static final HttpUrl parse(@NotNull String str) {
        return Companion.parse(str);
    }

    @Nullable
    public final String -deprecated_encodedFragment() {
        return encodedFragment();
    }

    @NotNull
    public final String -deprecated_encodedPassword() {
        return encodedPassword();
    }

    @NotNull
    public final String -deprecated_encodedPath() {
        return encodedPath();
    }

    @NotNull
    public final List -deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Nullable
    public final String -deprecated_encodedQuery() {
        return encodedQuery();
    }

    @NotNull
    public final String -deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Nullable
    public final String -deprecated_fragment() {
        return this.fragment;
    }

    @NotNull
    public final String -deprecated_host() {
        return this.host;
    }

    @NotNull
    public final String -deprecated_password() {
        return this.password;
    }

    @NotNull
    public final List -deprecated_pathSegments() {
        return this.pathSegments;
    }

    public final int -deprecated_pathSize() {
        return pathSize();
    }

    public final int -deprecated_port() {
        return this.port;
    }

    @Nullable
    public final String -deprecated_query() {
        return query();
    }

    @NotNull
    public final Set -deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    public final int -deprecated_querySize() {
        return querySize();
    }

    @NotNull
    public final String -deprecated_scheme() {
        return this.scheme;
    }

    @NotNull
    public final URI -deprecated_uri() {
        return uri();
    }

    @NotNull
    public final URL -deprecated_url() {
        return url();
    }

    @NotNull
    public final String -deprecated_username() {
        return this.username;
    }

    @Nullable
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int Q = o.Q(this.url, '#', 0, false, 6, null) + 1;
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(Q);
        l.d(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int Q = o.Q(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1;
        int Q2 = o.Q(this.url, '@', 0, false, 6, null);
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(Q, Q2);
        l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public final String encodedPath() {
        int Q = o.Q(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", Q, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(Q, delimiterOffset);
        l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public final List encodedPathSegments() {
        int Q = o.Q(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", Q, str.length());
        ArrayList arrayList = new ArrayList();
        while (Q < delimiterOffset) {
            int i = Q + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i, delimiterOffset);
            String str2 = this.url;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = str2.substring(i, delimiterOffset2);
            l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(substring);
            Q = delimiterOffset2;
        }
        return arrayList;
    }

    @Nullable
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int Q = o.Q(this.url, '?', 0, false, 6, null) + 1;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, '#', Q, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(Q, delimiterOffset);
        l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(length, delimiterOffset);
        l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && l.a(((HttpUrl) obj).url, this.url);
    }

    @Nullable
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    @NotNull
    public final String password() {
        return this.password;
    }

    @NotNull
    public final List pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    @Nullable
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    @Nullable
    public final String queryParameter(@NotNull String name) {
        l.e(name, "name");
        List list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        B8.a l = h.l(h.m(0, list.size()), 2);
        int d = l.d();
        int f = l.f();
        int g = l.g();
        if (g < 0 ? d >= f : d <= f) {
            while (!l.a(name, (String) this.queryNamesAndValues.get(d))) {
                if (d != f) {
                    d += g;
                }
            }
            return (String) this.queryNamesAndValues.get(d + 1);
        }
        return null;
    }

    @NotNull
    public final String queryParameterName(int i) {
        List list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        Object obj = list.get(i * 2);
        l.b(obj);
        return (String) obj;
    }

    @NotNull
    public final Set queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return E.b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        B8.a l = h.l(h.m(0, this.queryNamesAndValues.size()), 2);
        int d = l.d();
        int f = l.f();
        int g = l.g();
        if (g < 0 ? d >= f : d <= f) {
            while (true) {
                Object obj = this.queryNamesAndValues.get(d);
                l.b(obj);
                linkedHashSet.add(obj);
                if (d == f) {
                    break;
                }
                d += g;
            }
        }
        Set unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        l.d(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @Nullable
    public final String queryParameterValue(int i) {
        List list = this.queryNamesAndValues;
        if (list != null) {
            return (String) list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @NotNull
    public final List queryParameterValues(@NotNull String name) {
        l.e(name, "name");
        if (this.queryNamesAndValues == null) {
            return k.f();
        }
        ArrayList arrayList = new ArrayList();
        B8.a l = h.l(h.m(0, this.queryNamesAndValues.size()), 2);
        int d = l.d();
        int f = l.f();
        int g = l.g();
        if (g < 0 ? d >= f : d <= f) {
            while (true) {
                if (l.a(name, (String) this.queryNamesAndValues.get(d))) {
                    arrayList.add(this.queryNamesAndValues.get(d + 1));
                }
                if (d == f) {
                    break;
                }
                d += g;
            }
        }
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        l.d(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int querySize() {
        List list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @NotNull
    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        l.b(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    @Nullable
    public final HttpUrl resolve(@NotNull String link) {
        l.e(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    public String toString() {
        return this.url;
    }

    @Nullable
    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @NotNull
    public final URI uri() {
        CharSequence builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new e("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").b(builder, ""));
                l.d(create, "try {\n        val stripp…e) // Unexpected!\n      }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    @NotNull
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public final String username() {
        return this.username;
    }

    @Nullable
    public static final HttpUrl get(@NotNull URI uri) {
        return Companion.get(uri);
    }

    @Nullable
    public final Builder newBuilder(@NotNull String link) {
        l.e(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    public static final HttpUrl get(@NotNull URL url) {
        return Companion.get(url);
    }
}
