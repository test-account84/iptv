package g2;

import Q1.a;
import U1.l;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j implements S1.f {
    public static final a d = new a();
    public final a.a a;
    public final V1.b b;
    public final a c;

    public static class a {
        public Q1.a a(a.a aVar) {
            return new Q1.a(aVar);
        }

        public R1.a b() {
            return new R1.a();
        }

        public l c(Bitmap bitmap, V1.b bVar) {
            return new d2.c(bitmap, bVar);
        }

        public Q1.d d() {
            return new Q1.d();
        }
    }

    public j(V1.b bVar) {
        this(bVar, d);
    }

    public final Q1.a b(byte[] bArr) {
        Q1.d d2 = this.c.d();
        d2.o(bArr);
        Q1.c c = d2.c();
        Q1.a a2 = this.c.a(this.a);
        a2.n(c, bArr);
        a2.a();
        return a2;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(l lVar, OutputStream outputStream) {
        long b = q2.d.b();
        b bVar = (b) lVar.get();
        S1.g g = bVar.g();
        if (g instanceof c2.d) {
            return e(bVar.d(), outputStream);
        }
        Q1.a b2 = b(bVar.d());
        R1.a b3 = this.c.b();
        if (!b3.h(outputStream)) {
            return false;
        }
        for (int i = 0; i < b2.f(); i++) {
            l d2 = d(b2.i(), g, bVar);
            try {
                if (!b3.a((Bitmap) d2.get())) {
                    return false;
                }
                b3.f(b2.e(b2.d()));
                b2.a();
                d2.b();
            } finally {
                d2.b();
            }
        }
        boolean d3 = b3.d();
        if (Log.isLoggable("GifEncoder", 2)) {
            Log.v("GifEncoder", "Encoded gif with " + b2.f() + " frames and " + bVar.d().length + " bytes in " + q2.d.a(b) + " ms");
        }
        return d3;
    }

    public final l d(Bitmap bitmap, S1.g gVar, b bVar) {
        l c = this.c.c(bitmap, this.b);
        l a2 = gVar.a(c, bVar.getIntrinsicWidth(), bVar.getIntrinsicHeight());
        if (!c.equals(a2)) {
            c.b();
        }
        return a2;
    }

    public final boolean e(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    public String getId() {
        return "";
    }

    public j(V1.b bVar, a aVar) {
        this.b = bVar;
        this.a = new g2.a(bVar);
        this.c = aVar;
    }
}
