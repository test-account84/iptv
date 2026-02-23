package c4;

import b4.m;
import c4.a;
import d4.B;
import d4.k0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements b4.m {
    public final c4.a a;
    public final long b;
    public final int c;
    public b4.s d;
    public long e;
    public File f;
    public OutputStream g;
    public long h;
    public long i;
    public s j;

    public static final class a extends a.a {
        public a(IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public static final class b implements m.a {
        public c4.a a;
        public long b = 5242880;
        public int c = 20480;

        public b4.m a() {
            return new b((c4.a) d4.a.e(this.a), this.b, this.c);
        }

        public b b(c4.a aVar) {
            this.a = aVar;
            return this;
        }
    }

    public b(c4.a aVar, long j, int i) {
        d4.a.h(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < 2097152) {
            B.j("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.a = (c4.a) d4.a.e(aVar);
        this.b = j == -1 ? Long.MAX_VALUE : j;
        this.c = i;
    }

    public void a(b4.s sVar) {
        d4.a.e(sVar.i);
        if (sVar.h == -1 && sVar.d(2)) {
            this.d = null;
            return;
        }
        this.d = sVar;
        this.e = sVar.d(4) ? this.b : Long.MAX_VALUE;
        this.i = 0L;
        try {
            c(sVar);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    public final void b() {
        OutputStream outputStream = this.g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            k0.o(this.g);
            this.g = null;
            File file = (File) k0.j(this.f);
            this.f = null;
            this.a.i(file, this.h);
        } catch (Throwable th) {
            k0.o(this.g);
            this.g = null;
            File file2 = (File) k0.j(this.f);
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    public final void c(b4.s sVar) {
        long j = sVar.h;
        this.f = this.a.a((String) k0.j(sVar.i), sVar.g + this.i, j != -1 ? Math.min(j - this.i, this.e) : -1L);
        s fileOutputStream = new FileOutputStream(this.f);
        if (this.c > 0) {
            s sVar2 = this.j;
            if (sVar2 == null) {
                this.j = new s(fileOutputStream, this.c);
            } else {
                sVar2.a(fileOutputStream);
            }
            fileOutputStream = this.j;
        }
        this.g = fileOutputStream;
        this.h = 0L;
    }

    public void close() {
        if (this.d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        b4.s sVar = this.d;
        if (sVar == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.h == this.e) {
                    b();
                    c(sVar);
                }
                int min = (int) Math.min(i2 - i3, this.e - this.h);
                ((OutputStream) k0.j(this.g)).write(bArr, i + i3, min);
                i3 += min;
                long j = min;
                this.h += j;
                this.i += j;
            } catch (IOException e) {
                throw new a(e);
            }
        }
    }
}
