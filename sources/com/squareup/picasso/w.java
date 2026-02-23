package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.t;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class w {
    public static final long s = TimeUnit.SECONDS.toNanos(5);
    public int a;
    public long b;
    public int c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;
    public final Bitmap.Config q;
    public final t.f r;

    public static final class b {
        public Uri a;
        public int b;
        public String c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public float i;
        public float j;
        public float k;
        public boolean l;
        public List m;
        public Bitmap.Config n;
        public t.f o;

        public b(Uri uri, int i, Bitmap.Config config) {
            this.a = uri;
            this.b = i;
            this.n = config;
        }

        public w a() {
            boolean z = this.g;
            if (z && this.f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f && this.d == 0 && this.e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (z && this.d == 0 && this.e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.o == null) {
                this.o = t.f.NORMAL;
            }
            return new w(this.a, this.b, this.c, this.m, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, null);
        }

        public b b() {
            if (this.g) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f = true;
            return this;
        }

        public b c() {
            if (this.f) {
                throw new IllegalStateException("Center inside can not be used after calling centerCrop");
            }
            this.g = true;
            return this;
        }

        public boolean d() {
            return (this.a == null && this.b == 0) ? false : true;
        }

        public boolean e() {
            return (this.d == 0 && this.e == 0) ? false : true;
        }

        public b f(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.d = i;
            this.e = i2;
            return this;
        }
    }

    public w(Uri uri, int i, String str, List list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Bitmap.Config config, t.f fVar) {
        this.d = uri;
        this.e = i;
        this.f = str;
        this.g = list == null ? null : Collections.unmodifiableList(list);
        this.h = i2;
        this.i = i3;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = f;
        this.n = f2;
        this.o = f3;
        this.p = z4;
        this.q = config;
        this.r = fVar;
    }

    public String a() {
        Uri uri = this.d;
        return uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(this.e);
    }

    public boolean b() {
        return this.g != null;
    }

    public boolean c() {
        return (this.h == 0 && this.i == 0) ? false : true;
    }

    public String d() {
        StringBuilder sb;
        long nanoTime = System.nanoTime() - this.b;
        if (nanoTime > s) {
            sb = new StringBuilder();
            sb.append(g());
            sb.append('+');
            sb.append(TimeUnit.NANOSECONDS.toSeconds(nanoTime));
            sb.append('s');
        } else {
            sb = new StringBuilder();
            sb.append(g());
            sb.append('+');
            sb.append(TimeUnit.NANOSECONDS.toMillis(nanoTime));
            sb.append("ms");
        }
        return sb.toString();
    }

    public boolean e() {
        return c() || this.m != 0.0f;
    }

    public boolean f() {
        return e() || b();
    }

    public String g() {
        return "[R" + this.a + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i = this.e;
        if (i > 0) {
            sb.append(i);
        } else {
            sb.append(this.d);
        }
        List list = this.g;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.g.iterator();
            if (it.hasNext()) {
                d.D.a(it.next());
                sb.append(' ');
                throw null;
            }
        }
        if (this.f != null) {
            sb.append(" stableKey(");
            sb.append(this.f);
            sb.append(')');
        }
        if (this.h > 0) {
            sb.append(" resize(");
            sb.append(this.h);
            sb.append(',');
            sb.append(this.i);
            sb.append(')');
        }
        if (this.j) {
            sb.append(" centerCrop");
        }
        if (this.k) {
            sb.append(" centerInside");
        }
        if (this.m != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.m);
            if (this.p) {
                sb.append(" @ ");
                sb.append(this.n);
                sb.append(',');
                sb.append(this.o);
            }
            sb.append(')');
        }
        if (this.q != null) {
            sb.append(' ');
            sb.append(this.q);
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ w(Uri uri, int i, String str, List list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Bitmap.Config config, t.f fVar, a aVar) {
        this(uri, i, str, list, i2, i3, z, z2, z3, f, f2, f3, z4, config, fVar);
    }
}
