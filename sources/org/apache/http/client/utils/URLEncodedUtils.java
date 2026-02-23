package org.apache.http.client.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final char QP_SEP_A = '&';
    private static final char QP_SEP_S = ';';
    private static final int RADIX = 16;
    private static final BitSet UNRESERVED = new BitSet(256);
    private static final BitSet PUNCT = new BitSet(256);
    private static final BitSet USERINFO = new BitSet(256);
    private static final BitSet PATHSAFE = new BitSet(256);
    private static final BitSet URIC = new BitSet(256);
    private static final BitSet RESERVED = new BitSet(256);
    private static final BitSet URLENCODER = new BitSet(256);

    static {
        for (int i = 97; i <= 122; i++) {
            UNRESERVED.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            UNRESERVED.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            UNRESERVED.set(i3);
        }
        BitSet bitSet = UNRESERVED;
        bitSet.set(95);
        bitSet.set(45);
        bitSet.set(46);
        bitSet.set(42);
        URLENCODER.or(bitSet);
        bitSet.set(33);
        bitSet.set(126);
        bitSet.set(39);
        bitSet.set(40);
        bitSet.set(41);
        BitSet bitSet2 = PUNCT;
        bitSet2.set(44);
        bitSet2.set(59);
        bitSet2.set(58);
        bitSet2.set(36);
        bitSet2.set(38);
        bitSet2.set(43);
        bitSet2.set(61);
        BitSet bitSet3 = USERINFO;
        bitSet3.or(bitSet);
        bitSet3.or(bitSet2);
        BitSet bitSet4 = PATHSAFE;
        bitSet4.or(bitSet);
        bitSet4.set(47);
        bitSet4.set(59);
        bitSet4.set(58);
        bitSet4.set(64);
        bitSet4.set(38);
        bitSet4.set(61);
        bitSet4.set(43);
        bitSet4.set(36);
        bitSet4.set(44);
        BitSet bitSet5 = RESERVED;
        bitSet5.set(59);
        bitSet5.set(47);
        bitSet5.set(63);
        bitSet5.set(58);
        bitSet5.set(64);
        bitSet5.set(38);
        bitSet5.set(61);
        bitSet5.set(43);
        bitSet5.set(36);
        bitSet5.set(44);
        bitSet5.set(91);
        bitSet5.set(93);
        BitSet bitSet6 = URIC;
        bitSet6.or(bitSet5);
        bitSet6.or(bitSet);
    }

    private static List createEmptyList() {
        return new ArrayList(0);
    }

    private static String decodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        return urlDecode(str, str2 != null ? Charset.forName(str2) : Consts.UTF_8, true);
    }

    public static String encPath(String str, Charset charset) {
        return urlEncode(str, charset, PATHSAFE, false);
    }

    public static String encUric(String str, Charset charset) {
        return urlEncode(str, charset, URIC, false);
    }

    public static String encUserInfo(String str, Charset charset) {
        return urlEncode(str, charset, USERINFO, false);
    }

    private static String encodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        return urlEncode(str, str2 != null ? Charset.forName(str2) : Consts.UTF_8, URLENCODER, true);
    }

    public static String format(Iterable iterable, char c, Charset charset) {
        Args.notNull(iterable, "Parameters");
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            NameValuePair nameValuePair = (NameValuePair) it.next();
            String encodeFormFields = encodeFormFields(nameValuePair.getName(), charset);
            String encodeFormFields2 = encodeFormFields(nameValuePair.getValue(), charset);
            if (sb.length() > 0) {
                sb.append(c);
            }
            sb.append(encodeFormFields);
            if (encodeFormFields2 != null) {
                sb.append("=");
                sb.append(encodeFormFields2);
            }
        }
        return sb.toString();
    }

    public static boolean isEncoded(HttpEntity httpEntity) {
        Args.notNull(httpEntity, "HTTP entity");
        Header contentType = httpEntity.getContentType();
        if (contentType != null) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return elements[0].getName().equalsIgnoreCase("application/x-www-form-urlencoded");
            }
        }
        return false;
    }

    public static List parse(String str, Charset charset) {
        if (str == null) {
            return createEmptyList();
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return parse(charArrayBuffer, charset, '&', ';');
    }

    private static String urlDecode(String str, Charset charset, boolean z) {
        byte b;
        if (str == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(str.length());
        CharBuffer wrap = CharBuffer.wrap(str);
        while (wrap.hasRemaining()) {
            int i = wrap.get();
            if (i != 37 || wrap.remaining() < 2) {
                b = (z && i == 43) ? (byte) 32 : (byte) i;
            } else {
                char c = wrap.get();
                char c2 = wrap.get();
                int digit = Character.digit(c, 16);
                int digit2 = Character.digit(c2, 16);
                if (digit == -1 || digit2 == -1) {
                    allocate.put((byte) 37);
                    allocate.put((byte) c);
                    b = (byte) c2;
                } else {
                    i = (digit << 4) + digit2;
                }
            }
            allocate.put(b);
        }
        allocate.flip();
        return charset.decode(allocate).toString();
    }

    private static String urlEncode(String str, Charset charset, BitSet bitSet, boolean z) {
        char upperCase;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b = encode.get();
            int i = b & 255;
            if (bitSet.get(i)) {
                upperCase = (char) i;
            } else if (z && i == 32) {
                upperCase = '+';
            } else {
                sb.append("%");
                char upperCase2 = Character.toUpperCase(Character.forDigit((i >> 4) & 15, 16));
                upperCase = Character.toUpperCase(Character.forDigit(b & 15, 16));
                sb.append(upperCase2);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    private static String decodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return urlDecode(str, charset, true);
    }

    private static String encodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return urlEncode(str, charset, URLENCODER, true);
    }

    public static String format(Iterable iterable, Charset charset) {
        return format(iterable, '&', charset);
    }

    public static List parse(String str, Charset charset, char... cArr) {
        if (str == null) {
            return createEmptyList();
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return parse(charArrayBuffer, charset, cArr);
    }

    public static String format(List list, char c, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NameValuePair nameValuePair = (NameValuePair) it.next();
            String encodeFormFields = encodeFormFields(nameValuePair.getName(), str);
            String encodeFormFields2 = encodeFormFields(nameValuePair.getValue(), str);
            if (sb.length() > 0) {
                sb.append(c);
            }
            sb.append(encodeFormFields);
            if (encodeFormFields2 != null) {
                sb.append("=");
                sb.append(encodeFormFields2);
            }
        }
        return sb.toString();
    }

    public static List parse(URI uri, String str) {
        return parse(uri, str != null ? Charset.forName(str) : null);
    }

    public static String format(List list, String str) {
        return format(list, '&', str);
    }

    public static List parse(URI uri, Charset charset) {
        Args.notNull(uri, "URI");
        String rawQuery = uri.getRawQuery();
        return (rawQuery == null || rawQuery.isEmpty()) ? createEmptyList() : parse(rawQuery, charset);
    }

    public static List parse(HttpEntity httpEntity) throws IOException {
        Args.notNull(httpEntity, "HTTP entity");
        ContentType contentType = ContentType.get(httpEntity);
        if (contentType == null || !contentType.getMimeType().equalsIgnoreCase("application/x-www-form-urlencoded")) {
            return createEmptyList();
        }
        long contentLength = httpEntity.getContentLength();
        Args.check(contentLength <= 2147483647L, "HTTP entity is too large");
        Charset charset = contentType.getCharset() != null ? contentType.getCharset() : HTTP.DEF_CONTENT_CHARSET;
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return createEmptyList();
        }
        try {
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(contentLength > 0 ? (int) contentLength : 1024);
            InputStreamReader inputStreamReader = new InputStreamReader(content, charset);
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                charArrayBuffer.append(cArr, 0, read);
            }
            content.close();
            return charArrayBuffer.length() == 0 ? createEmptyList() : parse(charArrayBuffer, charset, '&');
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List parse(org.apache.http.util.CharArrayBuffer r7, java.nio.charset.Charset r8, char... r9) {
        /*
            java.lang.String r0 = "Char array buffer"
            org.apache.http.util.Args.notNull(r7, r0)
            org.apache.http.message.TokenParser r0 = org.apache.http.message.TokenParser.INSTANCE
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            int r2 = r9.length
            r3 = 0
            r4 = 0
        Lf:
            if (r4 >= r2) goto L19
            char r5 = r9[r4]
            r1.set(r5)
            int r4 = r4 + 1
            goto Lf
        L19:
            org.apache.http.message.ParserCursor r9 = new org.apache.http.message.ParserCursor
            int r2 = r7.length()
            r9.<init>(r3, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L27:
            boolean r3 = r9.atEnd()
            if (r3 != 0) goto L7e
            r3 = 61
            r1.set(r3)
            java.lang.String r4 = r0.parseToken(r7, r9, r1)
            boolean r5 = r9.atEnd()
            if (r5 != 0) goto L66
            int r5 = r9.getPos()
            char r5 = r7.charAt(r5)
            int r6 = r9.getPos()
            int r6 = r6 + 1
            r9.updatePos(r6)
            if (r5 != r3) goto L66
            r1.clear(r3)
            java.lang.String r3 = r0.parseValue(r7, r9, r1)
            boolean r5 = r9.atEnd()
            if (r5 != 0) goto L67
            int r5 = r9.getPos()
            int r5 = r5 + 1
            r9.updatePos(r5)
            goto L67
        L66:
            r3 = 0
        L67:
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L27
            org.apache.http.message.BasicNameValuePair r5 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r4 = decodeFormFields(r4, r8)
            java.lang.String r3 = decodeFormFields(r3, r8)
            r5.<init>(r4, r3)
            r2.add(r5)
            goto L27
        L7e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.client.utils.URLEncodedUtils.parse(org.apache.http.util.CharArrayBuffer, java.nio.charset.Charset, char[]):java.util.List");
    }

    @Deprecated
    public static void parse(List list, Scanner scanner, String str) {
        parse(list, scanner, "[&;]", str);
    }

    @Deprecated
    public static void parse(List list, Scanner scanner, String str, String str2) {
        String decodeFormFields;
        String str3;
        scanner.useDelimiter(str);
        while (scanner.hasNext()) {
            String next = scanner.next();
            int indexOf = next.indexOf("=");
            if (indexOf != -1) {
                decodeFormFields = decodeFormFields(next.substring(0, indexOf).trim(), str2);
                str3 = decodeFormFields(next.substring(indexOf + 1).trim(), str2);
            } else {
                decodeFormFields = decodeFormFields(next.trim(), str2);
                str3 = null;
            }
            list.add(new BasicNameValuePair(decodeFormFields, str3));
        }
    }
}
