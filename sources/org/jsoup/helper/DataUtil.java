package org.jsoup.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DataUtil {
    private static final int UNICODE_BOM = 65279;
    static final int boundaryLength = 32;
    private static final int bufferSize = 131072;
    static final String defaultCharset = "UTF-8";
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");
    private static final char[] mimeBoundaryChars = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private DataUtil() {
    }

    public static void crossStreams(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[131072];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static ByteBuffer emptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }

    public static String getCharsetFromContentType(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = charsetPattern.matcher(str);
        if (matcher.find()) {
            String replace = matcher.group(1).trim().replace("charset=", "");
            if (replace.length() == 0) {
                return null;
            }
            try {
                if (Charset.isSupported(replace)) {
                    return replace;
                }
                String upperCase = replace.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    public static Document load(File file, String str, String str2) throws IOException {
        return parseByteData(readFileToByteBuffer(file), str, str2, Parser.htmlParser());
    }

    public static String mimeBoundary() {
        StringBuilder sb = new StringBuilder(32);
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char[] cArr = mimeBoundaryChars;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.jsoup.nodes.Document parseByteData(java.nio.ByteBuffer r8, java.lang.String r9, java.lang.String r10, org.jsoup.parser.Parser r11) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            if (r9 != 0) goto L6e
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r0)
            java.nio.CharBuffer r2 = r2.decode(r8)
            java.lang.String r2 = r2.toString()
            org.jsoup.nodes.Document r3 = r11.parseInput(r2, r10)
            java.lang.String r4 = "meta[http-equiv=content-type], meta[charset]"
            org.jsoup.select.Elements r4 = r3.select(r4)
            org.jsoup.nodes.Element r4 = r4.first()
            if (r4 == 0) goto L80
            java.lang.String r5 = "http-equiv"
            boolean r5 = r4.hasAttr(r5)
            if (r5 == 0) goto L34
            java.lang.String r5 = "content"
            java.lang.String r5 = r4.attr(r5)
            java.lang.String r5 = getCharsetFromContentType(r5)
            goto L35
        L34:
            r5 = r1
        L35:
            if (r5 != 0) goto L50
            java.lang.String r6 = "charset"
            boolean r7 = r4.hasAttr(r6)
            if (r7 == 0) goto L50
            java.lang.String r7 = r4.attr(r6)     // Catch: java.nio.charset.IllegalCharsetNameException -> L4e
            boolean r7 = java.nio.charset.Charset.isSupported(r7)     // Catch: java.nio.charset.IllegalCharsetNameException -> L4e
            if (r7 == 0) goto L50
            java.lang.String r5 = r4.attr(r6)     // Catch: java.nio.charset.IllegalCharsetNameException -> L4e
            goto L50
        L4e:
            r5 = r1
        L50:
            if (r5 == 0) goto L80
            int r4 = r5.length()
            if (r4 == 0) goto L80
            boolean r4 = r5.equals(r0)
            if (r4 != 0) goto L80
            java.lang.String r9 = r5.trim()
            java.lang.String r2 = "[\"']"
            java.lang.String r3 = ""
            java.lang.String r9 = r9.replaceAll(r2, r3)
            r8.rewind()
            goto L73
        L6e:
            java.lang.String r2 = "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML"
            org.jsoup.helper.Validate.notEmpty(r9, r2)
        L73:
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r9)
            java.nio.CharBuffer r2 = r2.decode(r8)
            java.lang.String r2 = r2.toString()
            r3 = r1
        L80:
            int r4 = r2.length()
            if (r4 <= 0) goto La5
            r4 = 0
            char r4 = r2.charAt(r4)
            r5 = 65279(0xfeff, float:9.1475E-41)
            if (r4 != r5) goto La5
            r8.rewind()
            java.nio.charset.Charset r9 = java.nio.charset.Charset.forName(r0)
            java.nio.CharBuffer r8 = r9.decode(r8)
            java.lang.String r8 = r8.toString()
            r9 = 1
            java.lang.String r2 = r8.substring(r9)
            goto La7
        La5:
            r0 = r9
            r1 = r3
        La7:
            if (r1 != 0) goto Lb4
            org.jsoup.nodes.Document r1 = r11.parseInput(r2, r10)
            org.jsoup.nodes.Document$OutputSettings r8 = r1.outputSettings()
            r8.charset(r0)
        Lb4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.DataUtil.parseByteData(java.nio.ByteBuffer, java.lang.String, java.lang.String, org.jsoup.parser.Parser):org.jsoup.nodes.Document");
    }

    public static ByteBuffer readFileToByteBuffer(File file) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[(int) randomAccessFile2.length()];
                randomAccessFile2.readFully(bArr);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                randomAccessFile2.close();
                return wrap;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream) throws IOException {
        return readToByteBuffer(inputStream, 0);
    }

    public static Document load(InputStream inputStream, String str, String str2) throws IOException {
        return parseByteData(readToByteBuffer(inputStream), str, str2, Parser.htmlParser());
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i) throws IOException {
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z = i > 0;
        byte[] bArr = new byte[131072];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(131072);
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            if (z) {
                if (read > i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public static Document load(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return parseByteData(readToByteBuffer(inputStream), str, str2, parser);
    }
}
