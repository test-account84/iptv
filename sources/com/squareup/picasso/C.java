package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.NetworkInfo;
import com.squareup.picasso.j;
import com.squareup.picasso.r;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class c implements Runnable {
    public static final Object u = new Object();
    public static final ThreadLocal v = new a();
    public static final AtomicInteger w = new AtomicInteger();
    public static final y x = new b();
    public final int a = w.incrementAndGet();
    public final t c;
    public final i d;
    public final d e;
    public final A f;
    public final String g;
    public final w h;
    public final int i;
    public int j;
    public final y k;
    public com.squareup.picasso.a l;
    public List m;
    public Bitmap n;
    public Future o;
    public t.e p;
    public Exception q;
    public int r;
    public int s;
    public t.f t;

    public static class a extends ThreadLocal {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    public static class b extends y {
        public boolean c(w wVar) {
            return true;
        }

        public y.a f(w wVar, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + wVar);
        }
    }

    public static class c implements Runnable {
        public final /* synthetic */ RuntimeException a;

        public c(E e, RuntimeException runtimeException) {
            this.a = runtimeException;
        }

        public void run() {
            new StringBuilder().append("Transformation ");
            throw null;
        }
    }

    public c(t tVar, i iVar, d dVar, A a2, com.squareup.picasso.a aVar, y yVar) {
        this.c = tVar;
        this.d = iVar;
        this.e = dVar;
        this.f = a2;
        this.l = aVar;
        this.g = aVar.d();
        this.h = aVar.i();
        this.t = aVar.h();
        this.i = aVar.e();
        this.j = aVar.f();
        this.k = yVar;
        this.s = yVar.e();
    }

    public static Bitmap a(List list, Bitmap bitmap) {
        if (list.size() <= 0) {
            return bitmap;
        }
        d.D.a(list.get(0));
        try {
            throw null;
        } catch (RuntimeException e) {
            t.p.post(new c(null, e));
            return null;
        }
    }

    public static Bitmap e(InputStream inputStream, w wVar) {
        n nVar = new n(inputStream);
        long c2 = nVar.c(65536);
        BitmapFactory.Options d = y.d(wVar);
        boolean g = y.g(d);
        boolean t = G.t(nVar);
        nVar.a(c2);
        if (t) {
            byte[] x2 = G.x(nVar);
            if (g) {
                BitmapFactory.decodeByteArray(x2, 0, x2.length, d);
                y.b(wVar.h, wVar.i, d, wVar);
            }
            return BitmapFactory.decodeByteArray(x2, 0, x2.length, d);
        }
        if (g) {
            BitmapFactory.decodeStream(nVar, (Rect) null, d);
            y.b(wVar.h, wVar.i, d, wVar);
            nVar.a(c2);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(nVar, (Rect) null, d);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public static c g(t tVar, i iVar, d dVar, A a2, com.squareup.picasso.a aVar) {
        w i = aVar.i();
        List i2 = tVar.i();
        int size = i2.size();
        for (int i3 = 0; i3 < size; i3++) {
            y yVar = (y) i2.get(i3);
            if (yVar.c(i)) {
                return new c(tVar, iVar, dVar, a2, aVar, yVar);
            }
        }
        return new c(tVar, iVar, dVar, a2, aVar, x);
    }

    public static boolean t(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    public static Bitmap w(w wVar, Bitmap bitmap, int i) {
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int i5;
        int i6;
        int i7;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = wVar.l;
        Matrix matrix = new Matrix();
        int i8 = 0;
        if (wVar.e()) {
            int i9 = wVar.h;
            int i10 = wVar.i;
            float f6 = wVar.m;
            if (f6 != 0.0f) {
                if (wVar.p) {
                    matrix.setRotate(f6, wVar.n, wVar.o);
                } else {
                    matrix.setRotate(f6);
                }
            }
            if (wVar.j) {
                float f7 = i9;
                float f8 = f7 / width;
                float f9 = i10;
                float f10 = f9 / height;
                if (f8 > f10) {
                    i5 = (int) Math.ceil(r10 * (f10 / f8));
                    i7 = (height - i5) / 2;
                    f10 = f9 / i5;
                    f5 = f8;
                    i6 = width;
                } else {
                    int ceil = (int) Math.ceil(r6 * (f8 / f10));
                    f5 = f7 / ceil;
                    i5 = height;
                    i8 = (width - ceil) / 2;
                    i6 = ceil;
                    i7 = 0;
                }
                if (t(z, width, height, i9, i10)) {
                    matrix.preScale(f5, f10);
                }
                i4 = i7;
                i2 = i6;
                i3 = i5;
            } else {
                if (wVar.k) {
                    float f11 = i9 / width;
                    float f12 = i10 / height;
                    if (f11 >= f12) {
                        f11 = f12;
                    }
                    if (t(z, width, height, i9, i10)) {
                        matrix.preScale(f11, f11);
                    }
                } else if ((i9 != 0 || i10 != 0) && (i9 != width || i10 != height)) {
                    if (i9 != 0) {
                        f = i9;
                        f2 = width;
                    } else {
                        f = i10;
                        f2 = height;
                    }
                    float f13 = f / f2;
                    if (i10 != 0) {
                        f3 = i10;
                        f4 = height;
                    } else {
                        f3 = i9;
                        f4 = width;
                    }
                    float f14 = f3 / f4;
                    if (t(z, width, height, i9, i10)) {
                        matrix.preScale(f13, f14);
                    }
                }
                i2 = width;
                i3 = height;
                i4 = 0;
            }
        } else {
            i2 = width;
            i3 = height;
            i4 = 0;
        }
        if (i != 0) {
            matrix.preRotate(i);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i8, i4, i2, i3, matrix, true);
        if (createBitmap == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    public static void x(w wVar) {
        String a2 = wVar.a();
        StringBuilder sb = (StringBuilder) v.get();
        sb.ensureCapacity(a2.length() + 8);
        sb.replace(8, sb.length(), a2);
        Thread.currentThread().setName(sb.toString());
    }

    public void b(com.squareup.picasso.a aVar) {
        String d;
        String str;
        boolean z = this.c.n;
        w wVar = aVar.b;
        if (this.l != null) {
            if (this.m == null) {
                this.m = new ArrayList(3);
            }
            this.m.add(aVar);
            if (z) {
                G.v("Hunter", "joined", wVar.d(), G.m(this, "to "));
            }
            t.f h = aVar.h();
            if (h.ordinal() > this.t.ordinal()) {
                this.t = h;
                return;
            }
            return;
        }
        this.l = aVar;
        if (z) {
            List list = this.m;
            if (list == null || list.isEmpty()) {
                d = wVar.d();
                str = "to empty hunter";
            } else {
                d = wVar.d();
                str = G.m(this, "to ");
            }
            G.v("Hunter", "joined", d, str);
        }
    }

    public boolean c() {
        Future future;
        if (this.l != null) {
            return false;
        }
        List list = this.m;
        return (list == null || list.isEmpty()) && (future = this.o) != null && future.cancel(false);
    }

    public final t.f d() {
        t.f fVar = t.f.LOW;
        List list = this.m;
        boolean z = (list == null || list.isEmpty()) ? false : true;
        com.squareup.picasso.a aVar = this.l;
        if (aVar == null && !z) {
            return fVar;
        }
        if (aVar != null) {
            fVar = aVar.h();
        }
        if (z) {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                t.f h = ((com.squareup.picasso.a) this.m.get(i)).h();
                if (h.ordinal() > fVar.ordinal()) {
                    fVar = h;
                }
            }
        }
        return fVar;
    }

    public void f(com.squareup.picasso.a aVar) {
        boolean remove;
        if (this.l == aVar) {
            this.l = null;
            remove = true;
        } else {
            List list = this.m;
            remove = list != null ? list.remove(aVar) : false;
        }
        if (remove && aVar.h() == this.t) {
            this.t = d();
        }
        if (this.c.n) {
            G.v("Hunter", "removed", aVar.b.d(), G.m(this, "from "));
        }
    }

    public com.squareup.picasso.a h() {
        return this.l;
    }

    public List i() {
        return this.m;
    }

    public w j() {
        return this.h;
    }

    public Exception k() {
        return this.q;
    }

    public String l() {
        return this.g;
    }

    public t.e m() {
        return this.p;
    }

    public int n() {
        return this.i;
    }

    public t o() {
        return this.c;
    }

    public t.f p() {
        return this.t;
    }

    public Bitmap q() {
        return this.n;
    }

    public Bitmap r() {
        Bitmap bitmap;
        if (p.shouldReadFromMemoryCache(this.i)) {
            bitmap = this.e.get(this.g);
            if (bitmap != null) {
                this.f.d();
                this.p = t.e.MEMORY;
                if (this.c.n) {
                    G.v("Hunter", "decoded", this.h.d(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        w wVar = this.h;
        wVar.c = this.s == 0 ? q.OFFLINE.index : this.j;
        y.a f = this.k.f(wVar, this.j);
        if (f != null) {
            this.p = f.c();
            this.r = f.b();
            bitmap = f.a();
            if (bitmap == null) {
                InputStream d = f.d();
                try {
                    Bitmap e = e(d, this.h);
                    G.e(d);
                    bitmap = e;
                } catch (Throwable th) {
                    G.e(d);
                    throw th;
                }
            }
        }
        if (bitmap != null) {
            if (this.c.n) {
                G.u("Hunter", "decoded", this.h.d());
            }
            this.f.b(bitmap);
            if (this.h.f() || this.r != 0) {
                synchronized (u) {
                    try {
                        if (this.h.e() || this.r != 0) {
                            bitmap = w(this.h, bitmap, this.r);
                            if (this.c.n) {
                                G.u("Hunter", "transformed", this.h.d());
                            }
                        }
                        if (this.h.b()) {
                            bitmap = a(this.h.g, bitmap);
                            if (this.c.n) {
                                G.v("Hunter", "transformed", this.h.d(), "from custom transformations");
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (bitmap != null) {
                    this.f.c(bitmap);
                }
            }
        }
        return bitmap;
    }

    public void run() {
        i iVar;
        i iVar2;
        try {
            try {
                try {
                    try {
                        x(this.h);
                        if (this.c.n) {
                            G.u("Hunter", "executing", G.l(this));
                        }
                        Bitmap r = r();
                        this.n = r;
                        if (r == null) {
                            this.d.e(this);
                        } else {
                            this.d.d(this);
                        }
                    } catch (IOException e) {
                        this.q = e;
                        iVar2 = this.d;
                        iVar2.g(this);
                        Thread.currentThread().setName("Picasso-Idle");
                    }
                } catch (j.b e2) {
                    if (!e2.a || e2.c != 504) {
                        this.q = e2;
                    }
                    iVar = this.d;
                    iVar.e(this);
                    Thread.currentThread().setName("Picasso-Idle");
                } catch (Exception e3) {
                    this.q = e3;
                    iVar = this.d;
                    iVar.e(this);
                    Thread.currentThread().setName("Picasso-Idle");
                }
            } catch (r.a e4) {
                this.q = e4;
                iVar2 = this.d;
                iVar2.g(this);
                Thread.currentThread().setName("Picasso-Idle");
            } catch (OutOfMemoryError e5) {
                StringWriter stringWriter = new StringWriter();
                this.f.a().a(new PrintWriter(stringWriter));
                this.q = new RuntimeException(stringWriter.toString(), e5);
                iVar = this.d;
                iVar.e(this);
                Thread.currentThread().setName("Picasso-Idle");
            }
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
    }

    public boolean s() {
        Future future = this.o;
        return future != null && future.isCancelled();
    }

    public boolean u(boolean z, NetworkInfo networkInfo) {
        int i = this.s;
        if (i <= 0) {
            return false;
        }
        this.s = i - 1;
        return this.k.h(z, networkInfo);
    }

    public boolean v() {
        return this.k.i();
    }
}
