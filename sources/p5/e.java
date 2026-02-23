package P5;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class e implements Closeable {
    public static final Logger h = Logger.getLogger(e.class.getName());
    public final RandomAccessFile a;
    public int c;
    public int d;
    public b e;
    public b f;
    public final byte[] g = new byte[16];

    public class a implements d {
        public boolean a = true;
        public final /* synthetic */ StringBuilder b;

        public a(StringBuilder sb) {
            this.b = sb;
        }

        public void a(InputStream inputStream, int i) {
            if (this.a) {
                this.a = false;
            } else {
                this.b.append(", ");
            }
            this.b.append(i);
        }
    }

    public static class b {
        public static final b c = new b(0, 0);
        public final int a;
        public final int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.a + ", length = " + this.b + "]";
        }
    }

    public final class c extends InputStream {
        public int a;
        public int c;

        public c(b bVar) {
            this.a = e.a(e.this, bVar.a + 4);
            this.c = bVar.b;
        }

        public int read() {
            if (this.c == 0) {
                return -1;
            }
            e.e(e.this).seek(this.a);
            int read = e.e(e.this).read();
            this.a = e.a(e.this, this.a + 1);
            this.c--;
            return read;
        }

        public /* synthetic */ c(e eVar, b bVar, a aVar) {
            this(bVar);
        }

        public int read(byte[] bArr, int i, int i2) {
            e.c(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.c;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            e.d(e.this, this.a, bArr, i, i2);
            this.a = e.a(e.this, this.a + i2);
            this.c -= i2;
            return i2;
        }
    }

    public interface d {
        void a(InputStream inputStream, int i);
    }

    public e(File file) {
        if (!file.exists()) {
            l(file);
        }
        this.a = o(file);
        q();
    }

    public static /* synthetic */ int a(e eVar, int i) {
        return eVar.Y(i);
    }

    public static /* synthetic */ Object c(Object obj, String str) {
        return n(obj, str);
    }

    public static void c0(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public static /* synthetic */ void d(e eVar, int i, byte[] bArr, int i2, int i3) {
        eVar.v(i, bArr, i2, i3);
    }

    public static void d0(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            c0(bArr, i, i2);
            i += 4;
        }
    }

    public static /* synthetic */ RandomAccessFile e(e eVar) {
        return eVar.a;
    }

    public static void l(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile o = o(file2);
        try {
            o.setLength(4096L);
            o.seek(0L);
            byte[] bArr = new byte[16];
            d0(bArr, 4096, 0, 0, 0);
            o.write(bArr);
            o.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            o.close();
            throw th;
        }
    }

    public static Object n(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static RandomAccessFile o(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    public static int r(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public final void T(int i) {
        this.a.setLength(i);
        this.a.getChannel().force(true);
    }

    public int V() {
        if (this.d == 0) {
            return 16;
        }
        b bVar = this.f;
        int i = bVar.a;
        int i2 = this.e.a;
        return i >= i2 ? (i - i2) + 4 + bVar.b + 16 : (((i + 4) + bVar.b) + this.c) - i2;
    }

    public final int Y(int i) {
        int i2 = this.c;
        return i < i2 ? i : (i + 16) - i2;
    }

    public final void b0(int i, int i2, int i3, int i4) {
        d0(this.g, i, i2, i3, i4);
        this.a.seek(0L);
        this.a.write(this.g);
    }

    public synchronized void close() {
        this.a.close();
    }

    public void g(byte[] bArr) {
        h(bArr, 0, bArr.length);
    }

    public synchronized void h(byte[] bArr, int i, int i2) {
        int Y;
        try {
            n(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            j(i2);
            boolean m = m();
            if (m) {
                Y = 16;
            } else {
                b bVar = this.f;
                Y = Y(bVar.a + 4 + bVar.b);
            }
            b bVar2 = new b(Y, i2);
            c0(this.g, 0, i2);
            w(bVar2.a, this.g, 0, 4);
            w(bVar2.a + 4, bArr, i, i2);
            b0(this.c, this.d + 1, m ? bVar2.a : this.e.a, bVar2.a);
            this.f = bVar2;
            this.d++;
            if (m) {
                this.e = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i() {
        try {
            b0(4096, 0, 0, 0);
            this.d = 0;
            b bVar = b.c;
            this.e = bVar;
            this.f = bVar;
            if (this.c > 4096) {
                T(4096);
            }
            this.c = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void j(int i) {
        int i2 = i + 4;
        int s = s();
        if (s >= i2) {
            return;
        }
        int i3 = this.c;
        do {
            s += i3;
            i3 <<= 1;
        } while (s < i2);
        T(i3);
        b bVar = this.f;
        int Y = Y(bVar.a + 4 + bVar.b);
        if (Y < this.e.a) {
            FileChannel channel = this.a.getChannel();
            channel.position(this.c);
            long j = Y - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i4 = this.f.a;
        int i5 = this.e.a;
        if (i4 < i5) {
            int i6 = (this.c + i4) - 16;
            b0(i3, this.d, i5, i6);
            this.f = new b(i6, this.f.b);
        } else {
            b0(i3, this.d, i5, i4);
        }
        this.c = i3;
    }

    public synchronized void k(d dVar) {
        int i = this.e.a;
        for (int i2 = 0; i2 < this.d; i2++) {
            b p = p(i);
            dVar.a(new c(this, p, null), p.b);
            i = Y(p.a + 4 + p.b);
        }
    }

    public synchronized boolean m() {
        return this.d == 0;
    }

    public final b p(int i) {
        if (i == 0) {
            return b.c;
        }
        this.a.seek(i);
        return new b(i, this.a.readInt());
    }

    public final void q() {
        this.a.seek(0L);
        this.a.readFully(this.g);
        int r = r(this.g, 0);
        this.c = r;
        if (r <= this.a.length()) {
            this.d = r(this.g, 4);
            int r2 = r(this.g, 8);
            int r3 = r(this.g, 12);
            this.e = p(r2);
            this.f = p(r3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.c + ", Actual length: " + this.a.length());
    }

    public final int s() {
        return this.c - V();
    }

    public synchronized void t() {
        try {
            if (m()) {
                throw new NoSuchElementException();
            }
            if (this.d == 1) {
                i();
            } else {
                b bVar = this.e;
                int Y = Y(bVar.a + 4 + bVar.b);
                v(Y, this.g, 0, 4);
                int r = r(this.g, 0);
                b0(this.c, this.d - 1, Y, this.f.a);
                this.d--;
                this.e = new b(Y, r);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.c);
        sb.append(", size=");
        sb.append(this.d);
        sb.append(", first=");
        sb.append(this.e);
        sb.append(", last=");
        sb.append(this.f);
        sb.append(", element lengths=[");
        try {
            k(new a(sb));
        } catch (IOException e) {
            h.log(Level.WARNING, "read error", e);
        }
        sb.append("]]");
        return sb.toString();
    }

    public final void v(int i, byte[] bArr, int i2, int i3) {
        RandomAccessFile randomAccessFile;
        int Y = Y(i);
        int i4 = Y + i3;
        int i5 = this.c;
        if (i4 <= i5) {
            this.a.seek(Y);
            randomAccessFile = this.a;
        } else {
            int i6 = i5 - Y;
            this.a.seek(Y);
            this.a.readFully(bArr, i2, i6);
            this.a.seek(16L);
            randomAccessFile = this.a;
            i2 += i6;
            i3 -= i6;
        }
        randomAccessFile.readFully(bArr, i2, i3);
    }

    public final void w(int i, byte[] bArr, int i2, int i3) {
        RandomAccessFile randomAccessFile;
        int Y = Y(i);
        int i4 = Y + i3;
        int i5 = this.c;
        if (i4 <= i5) {
            this.a.seek(Y);
            randomAccessFile = this.a;
        } else {
            int i6 = i5 - Y;
            this.a.seek(Y);
            this.a.write(bArr, i2, i6);
            this.a.seek(16L);
            randomAccessFile = this.a;
            i2 += i6;
            i3 -= i6;
        }
        randomAccessFile.write(bArr, i2, i3);
    }
}
