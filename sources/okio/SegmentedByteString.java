package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.l;
import l8.g;
import okio.internal.SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class SegmentedByteString extends ByteString {

    @NotNull
    private final transient int[] directory;

    @NotNull
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] segments, @NotNull int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        l.e(segments, "segments");
        l.e(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        if (byteString != null) {
            return byteString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        l.d(asReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        l.e(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            messageDigest.update(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digest = messageDigest.digest();
        l.d(digest, "digest.digest()");
        return new ByteString(digest);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @NotNull
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            byte[] bArr = getSegments$okio()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        setHashCode$okio(i2);
        return i2;
    }

    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        l.e(algorithm, "algorithm");
        l.e(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = getDirectory$okio()[length + i];
                int i4 = getDirectory$okio()[i];
                mac.update(getSegments$okio()[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            byte[] doFinal = mac.doFinal();
            l.d(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int indexOf(@NotNull byte[] other, int i) {
        l.e(other, "other");
        return toByteString().indexOf(other, i);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    public byte internalGet$okio(int i) {
        -Util.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i, 1L);
        int segment = SegmentedByteStringKt.segment(this, i);
        return getSegments$okio()[segment][(i - (segment == 0 ? 0 : getDirectory$okio()[segment - 1])) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    public int lastIndexOf(@NotNull byte[] other, int i) {
        l.e(other, "other");
        return toByteString().lastIndexOf(other, i);
    }

    public boolean rangeEquals(int i, @NotNull ByteString other, int i2, int i3) {
        l.e(other, "other");
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = SegmentedByteStringKt.segment(this, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i6 = getDirectory$okio()[segment] - i5;
            int i7 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i;
            if (!other.rangeEquals(i2, getSegments$okio()[segment], i7 + (i - i5), min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        l.e(charset, "charset");
        return toByteString().string(charset);
    }

    @NotNull
    public ByteString substring(int i, int i2) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (!(i2 <= size())) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " > length(" + size() + ')').toString());
        }
        int i3 = i2 - i;
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " < beginIndex=" + i).toString());
        }
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i == i2) {
            return ByteString.EMPTY;
        }
        int segment = SegmentedByteStringKt.segment(this, i);
        int segment2 = SegmentedByteStringKt.segment(this, i2 - 1);
        byte[][] bArr = (byte[][]) g.h(getSegments$okio(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i4 = segment;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(getDirectory$okio()[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i4];
                if (i4 == segment2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = segment != 0 ? getDirectory$okio()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i - i7);
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            int i6 = i5 - i2;
            g.c(getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    public void write(@NotNull OutputStream out) throws IOException {
        l.e(out, "out");
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            out.write(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    public void write$okio(@NotNull Buffer buffer, int i, int i2) {
        l.e(buffer, "buffer");
        int i3 = i2 + i;
        int segment = SegmentedByteStringKt.segment(this, i);
        while (i < i3) {
            int i4 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i5 = getDirectory$okio()[segment] - i4;
            int i6 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            Segment segment2 = new Segment(getSegments$okio()[segment], i7, i7 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                l.b(segment3);
                Segment segment4 = segment3.prev;
                l.b(segment4);
                segment4.push(segment2);
            }
            i += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + size());
    }

    public boolean rangeEquals(int i, @NotNull byte[] other, int i2, int i3) {
        l.e(other, "other");
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = SegmentedByteStringKt.segment(this, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i6 = getDirectory$okio()[segment] - i5;
            int i7 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i;
            if (!-Util.arrayRangeEquals(getSegments$okio()[segment], i7 + (i - i5), other, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }
}
