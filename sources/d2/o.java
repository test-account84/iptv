package d2;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o extends FilterInputStream {
    public volatile byte[] a;
    public int c;
    public int d;
    public int e;
    public int f;

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public o(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.e = -1;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.a = bArr;
    }

    public static IOException d() {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) {
        int i = this.e;
        if (i != -1) {
            int i2 = this.f - i;
            int i3 = this.d;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.c == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    if (Log.isLoggable("BufferedIs", 3)) {
                        Log.d("BufferedIs", "allocate buffer of length: " + i3);
                    }
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.f - this.e;
                this.f = i4;
                this.e = 0;
                this.c = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.f;
                if (read > 0) {
                    i5 += read;
                }
                this.c = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.e = -1;
            this.f = 0;
            this.c = read2;
        }
        return read2;
    }

    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.a == null || inputStream == null) {
            throw d();
        }
        return (this.c - this.f) + inputStream.available();
    }

    public synchronized void c() {
        this.d = this.a.length;
    }

    public void close() {
        this.a = null;
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i) {
        this.d = Math.max(this.d, i);
        this.e = this.f;
    }

    public boolean markSupported() {
        return true;
    }

    public synchronized int read() {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw d();
        }
        if (this.f >= this.c && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.a && (bArr = this.a) == null) {
            throw d();
        }
        int i = this.c;
        int i2 = this.f;
        if (i - i2 <= 0) {
            return -1;
        }
        this.f = i2 + 1;
        return bArr[i2] & 255;
    }

    public synchronized void reset() {
        if (this.a == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.e;
        if (-1 == i) {
            throw new a("Mark has been invalidated");
        }
        this.f = i;
    }

    public synchronized long skip(long j) {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null) {
            throw d();
        }
        if (j < 1) {
            return 0L;
        }
        if (inputStream == null) {
            throw d();
        }
        int i = this.c;
        int i2 = this.f;
        if (i - i2 >= j) {
            this.f = (int) (i2 + j);
            return j;
        }
        long j2 = i - i2;
        this.f = i;
        if (this.e == -1 || j > this.d) {
            return j2 + inputStream.skip(j - j2);
        }
        if (a(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.c;
        int i4 = this.f;
        long j3 = j - j2;
        if (i3 - i4 >= j3) {
            this.f = (int) (i4 + j3);
            return j;
        }
        long j4 = (j2 + i3) - i4;
        this.f = i3;
        return j4;
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            throw d();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw d();
        }
        int i5 = this.f;
        int i6 = this.c;
        if (i5 < i6) {
            int i7 = i6 - i5 >= i2 ? i2 : i6 - i5;
            System.arraycopy(bArr2, i5, bArr, i, i7);
            this.f += i7;
            if (i7 == i2 || inputStream.available() == 0) {
                return i7;
            }
            i += i7;
            i3 = i2 - i7;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.e == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else {
                if (a(inputStream, bArr2) == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
                if (bArr2 != this.a && (bArr2 = this.a) == null) {
                    throw d();
                }
                int i8 = this.c;
                int i9 = this.f;
                i4 = i8 - i9 >= i3 ? i3 : i8 - i9;
                System.arraycopy(bArr2, i9, bArr, i, i4);
                this.f += i4;
            }
            i3 -= i4;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += i4;
        }
    }
}
