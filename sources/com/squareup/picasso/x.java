package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.t;
import com.squareup.picasso.w;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class x {
    public static final AtomicInteger m = new AtomicInteger();
    public final t a;
    public final w.b b;
    public boolean c;
    public boolean d;
    public boolean e = true;
    public int f;
    public int g;
    public int h;
    public int i;
    public Drawable j;
    public Drawable k;
    public Object l;

    public x(t tVar, Uri uri, int i) {
        if (tVar.o) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.a = tVar;
        this.b = new w.b(uri, i, tVar.l);
    }

    public x a() {
        this.b.b();
        return this;
    }

    public x b() {
        this.b.c();
        return this;
    }

    public final w c(long j) {
        int andIncrement = m.getAndIncrement();
        w a = this.b.a();
        a.a = andIncrement;
        a.b = j;
        boolean z = this.a.n;
        if (z) {
            G.v("Main", "created", a.g(), a.toString());
        }
        w p = this.a.p(a);
        if (p != a) {
            p.a = andIncrement;
            p.b = j;
            if (z) {
                G.v("Main", "changed", p.d(), "into " + p);
            }
        }
        return p;
    }

    public x d(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        }
        if (this.k != null) {
            throw new IllegalStateException("Error image already set.");
        }
        this.g = i;
        return this;
    }

    public x e() {
        this.d = true;
        return this;
    }

    public final Drawable f() {
        return this.f != 0 ? this.a.e.getResources().getDrawable(this.f) : this.j;
    }

    public void g(ImageView imageView) {
        h(imageView, null);
    }

    public void h(ImageView imageView, e eVar) {
        Bitmap m2;
        long nanoTime = System.nanoTime();
        G.c();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (!this.b.d()) {
            this.a.c(imageView);
            if (this.e) {
                u.d(imageView, f());
                return;
            }
            return;
        }
        if (this.d) {
            if (this.b.e()) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                if (this.e) {
                    u.d(imageView, f());
                }
                this.a.f(imageView, new h(this, imageView, eVar));
                return;
            }
            this.b.f(width, height);
        }
        w c = c(nanoTime);
        String h = G.h(c);
        if (!p.shouldReadFromMemoryCache(this.h) || (m2 = this.a.m(h)) == null) {
            if (this.e) {
                u.d(imageView, f());
            }
            this.a.h(new l(this.a, imageView, c, this.h, this.i, this.g, this.k, h, this.l, eVar, this.c));
            return;
        }
        this.a.c(imageView);
        t tVar = this.a;
        Context context = tVar.e;
        t.e eVar2 = t.e.MEMORY;
        u.c(imageView, context, m2, eVar2, this.c, tVar.m);
        if (this.a.n) {
            G.v("Main", "completed", c.g(), "from " + eVar2);
        }
        if (eVar != null) {
            eVar.onSuccess();
        }
    }

    public void i(C c) {
        Bitmap m2;
        long nanoTime = System.nanoTime();
        G.c();
        if (c == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (this.d) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        if (!this.b.d()) {
            this.a.d(c);
            c.c(this.e ? f() : null);
            return;
        }
        w c2 = c(nanoTime);
        String h = G.h(c2);
        if (!p.shouldReadFromMemoryCache(this.h) || (m2 = this.a.m(h)) == null) {
            c.c(this.e ? f() : null);
            this.a.h(new D(this.a, c, c2, this.h, this.i, this.k, h, this.l, this.g));
        } else {
            this.a.d(c);
            c.b(m2, t.e.MEMORY);
        }
    }

    public x j(int i) {
        if (!this.e) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        }
        if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        }
        if (this.j != null) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.f = i;
        return this;
    }

    public x k(int i, int i2) {
        this.b.f(i, i2);
        return this;
    }

    public x l() {
        this.d = false;
        return this;
    }
}
