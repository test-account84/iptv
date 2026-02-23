package okio;

import E8.c;
import E8.n;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ByteString implements Serializable, Comparable {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @NotNull
    private final byte[] data;
    private transient int hashCode;

    @Nullable
    private transient String utf8;

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = c.b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            return companion.of(bArr, i, i2);
        }

        @Nullable
        public final ByteString -deprecated_decodeBase64(@NotNull String string) {
            l.e(string, "string");
            return decodeBase64(string);
        }

        @NotNull
        public final ByteString -deprecated_decodeHex(@NotNull String string) {
            l.e(string, "string");
            return decodeHex(string);
        }

        @NotNull
        public final ByteString -deprecated_encodeString(@NotNull String string, @NotNull Charset charset) {
            l.e(string, "string");
            l.e(charset, "charset");
            return encodeString(string, charset);
        }

        @NotNull
        public final ByteString -deprecated_encodeUtf8(@NotNull String string) {
            l.e(string, "string");
            return encodeUtf8(string);
        }

        @NotNull
        public final ByteString -deprecated_of(@NotNull ByteBuffer buffer) {
            l.e(buffer, "buffer");
            return of(buffer);
        }

        @NotNull
        public final ByteString -deprecated_read(@NotNull InputStream inputstream, int i) {
            l.e(inputstream, "inputstream");
            return read(inputstream, i);
        }

        @Nullable
        public final ByteString decodeBase64(@NotNull String decodeBase64) {
            l.e(decodeBase64, "$this$decodeBase64");
            byte[] decodeBase64ToArray = -Base64.decodeBase64ToArray(decodeBase64);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @NotNull
        public final ByteString decodeHex(@NotNull String decodeHex) {
            l.e(decodeHex, "$this$decodeHex");
            if (!(decodeHex.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
            }
            int length = decodeHex.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((ByteStringKt.access$decodeHexDigit(decodeHex.charAt(i2)) << 4) + ByteStringKt.access$decodeHexDigit(decodeHex.charAt(i2 + 1)));
            }
            return new ByteString(bArr);
        }

        @NotNull
        public final ByteString encodeString(@NotNull String encode, @NotNull Charset charset) {
            l.e(encode, "$this$encode");
            l.e(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            l.d(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @NotNull
        public final ByteString encodeUtf8(@NotNull String encodeUtf8) {
            l.e(encodeUtf8, "$this$encodeUtf8");
            ByteString byteString = new ByteString(-Platform.asUtf8ToByteArray(encodeUtf8));
            byteString.setUtf8$okio(encodeUtf8);
            return byteString;
        }

        @NotNull
        public final ByteString of(@NotNull ByteBuffer toByteString) {
            l.e(toByteString, "$this$toByteString");
            byte[] bArr = new byte[toByteString.remaining()];
            toByteString.get(bArr);
            return new ByteString(bArr);
        }

        @NotNull
        public final ByteString read(@NotNull InputStream readByteString, int i) throws IOException {
            l.e(readByteString, "$this$readByteString");
            int i2 = 0;
            if (!(i >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i).toString());
            }
            byte[] bArr = new byte[i];
            while (i2 < i) {
                int read = readByteString.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new ByteString(bArr);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @NotNull
        public final ByteString -deprecated_of(@NotNull byte[] array, int i, int i2) {
            l.e(array, "array");
            return of(array, i, i2);
        }

        @NotNull
        public final ByteString of(@NotNull byte... data) {
            l.e(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            l.d(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @NotNull
        public final ByteString of(@NotNull byte[] toByteString, int i, int i2) {
            l.e(toByteString, "$this$toByteString");
            -Util.checkOffsetAndCount(toByteString.length, i, i2);
            return new ByteString(l8.g.g(toByteString, i, i2 + i));
        }
    }

    public ByteString(@NotNull byte[] data) {
        l.e(data, "data");
        this.data = data;
    }

    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return Companion.decodeBase64(str);
    }

    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return Companion.decodeHex(str);
    }

    @NotNull
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(byteString2, i);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i);
    }

    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream, int i) throws IOException {
        return Companion.read(inputStream, i);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field field = ByteString.class.getDeclaredField("data");
        l.d(field, "field");
        field.setAccessible(true);
        field.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.substring(i, i2);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public final byte -deprecated_getByte(int i) {
        return getByte(i);
    }

    public final int -deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        l.d(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return -Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return -Base64.encodeBase64(getData$okio(), -Base64.getBASE64_URL_SAFE());
    }

    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        l.e(algorithm, "algorithm");
        byte[] digest = MessageDigest.getInstance(algorithm).digest(this.data);
        l.d(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(@NotNull ByteString suffix) {
        l.e(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i) {
        return internalGet$okio(i);
    }

    @NotNull
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @Nullable
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i = 0;
        for (byte b : getData$okio()) {
            int i2 = i + 1;
            cArr[i] = ByteStringKt.getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = ByteStringKt.getHEX_DIGIT_CHARS()[b & 15];
        }
        return new String(cArr);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        l.e(algorithm, "algorithm");
        l.e(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            l.d(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString key) {
        l.e(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString key) {
        l.e(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString key) {
        l.e(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public final int indexOf(@NotNull ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i) {
        return getData$okio()[i];
    }

    public final int lastIndexOf(@NotNull ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i, @NotNull ByteString other, int i2, int i3) {
        l.e(other, "other");
        return other.rangeEquals(i2, getData$okio(), i, i3);
    }

    public final void setHashCode$okio(int i) {
        this.hashCode = i;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.utf8 = str;
    }

    @NotNull
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @NotNull
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString prefix) {
        l.e(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        l.e(charset, "charset");
        return new String(this.data, charset);
    }

    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        byte b;
        for (int i = 0; i < getData$okio().length; i++) {
            byte b2 = getData$okio()[i];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                l.d(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        byte b;
        for (int i = 0; i < getData$okio().length; i++) {
            byte b2 = getData$okio()[i];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                l.d(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        l.d(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = utf8();
            if (utf8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String x = n.x(n.x(n.x(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (access$codePointIndexToCharIndex < utf8.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(getData$okio().length);
                sb.append(" text=");
                sb.append(x);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(x);
                sb.append(']');
            }
        } else if (getData$okio().length <= 64) {
            sb = new StringBuilder();
            sb.append("[hex=");
            sb.append(hex());
            sb.append(']');
        } else {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(getData$okio().length);
            sb.append(" hex=");
            if (!(64 <= getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
            sb.append((64 == getData$okio().length ? this : new ByteString(l8.g.g(getData$okio(), 0, 64))).hex());
            sb.append("…]");
        }
        return sb.toString();
    }

    @NotNull
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = -Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@NotNull OutputStream out) throws IOException {
        l.e(out, "out");
        out.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer, int i, int i2) {
        l.e(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, i, i2);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(bArr, i);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i);
    }

    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return Companion.of(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(@org.jetbrains.annotations.NotNull okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.l.e(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = -1
            goto L34
        L2c:
            r3 = 1
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@NotNull byte[] suffix) {
        l.e(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public final int indexOf(@NotNull ByteString other, int i) {
        l.e(other, "other");
        return indexOf(other.internalArray$okio(), i);
    }

    public final int lastIndexOf(@NotNull ByteString other, int i) {
        l.e(other, "other");
        return lastIndexOf(other.internalArray$okio(), i);
    }

    public boolean rangeEquals(int i, @NotNull byte[] other, int i2, int i3) {
        l.e(other, "other");
        return i >= 0 && i <= getData$okio().length - i3 && i2 >= 0 && i2 <= other.length - i3 && -Util.arrayRangeEquals(getData$okio(), i, other, i2, i3);
    }

    public final boolean startsWith(@NotNull byte[] prefix) {
        l.e(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    @NotNull
    public final ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    @NotNull
    public static final ByteString of(@NotNull byte[] bArr, int i, int i2) {
        return Companion.of(bArr, i, i2);
    }

    public final int indexOf(@NotNull byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final int lastIndexOf(@NotNull byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString substring(int i, int i2) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i2 <= getData$okio().length) {
            if (i2 - i >= 0) {
                return (i == 0 && i2 == getData$okio().length) ? this : new ByteString(l8.g.g(getData$okio(), i, i2));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    }

    public int indexOf(@NotNull byte[] other, int i) {
        l.e(other, "other");
        int length = getData$okio().length - other.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!-Util.arrayRangeEquals(getData$okio(), max, other, 0, other.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public int lastIndexOf(@NotNull byte[] other, int i) {
        l.e(other, "other");
        for (int min = Math.min(i, getData$okio().length - other.length); min >= 0; min--) {
            if (-Util.arrayRangeEquals(getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }
}
