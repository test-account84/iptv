package P3;

import O2.n;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements O2.n {
    public final CharSequence a;
    public final Layout.Alignment c;
    public final Layout.Alignment d;
    public final Bitmap e;
    public final float f;
    public final int g;
    public final int h;
    public final float i;
    public final int j;
    public final float k;
    public final float l;
    public final boolean m;
    public final int n;
    public final int o;
    public final float p;
    public final int q;
    public final float r;
    public static final b s = new b().o("").a();
    public static final String t = k0.A0(0);
    public static final String u = k0.A0(1);
    public static final String v = k0.A0(2);
    public static final String w = k0.A0(3);
    public static final String x = k0.A0(4);
    public static final String y = k0.A0(5);
    public static final String z = k0.A0(6);
    public static final String A = k0.A0(7);
    public static final String B = k0.A0(8);
    public static final String C = k0.A0(9);
    public static final String D = k0.A0(10);
    public static final String E = k0.A0(11);
    public static final String F = k0.A0(12);
    public static final String G = k0.A0(13);
    public static final String H = k0.A0(14);
    public static final String I = k0.A0(15);
    public static final String J = k0.A0(16);
    public static final n.a K = new P3.a();

    public static final class b {
        public CharSequence a;
        public Bitmap b;
        public Layout.Alignment c;
        public Layout.Alignment d;
        public float e;
        public int f;
        public int g;
        public float h;
        public int i;
        public int j;
        public float k;
        public float l;
        public float m;
        public boolean n;
        public int o;
        public int p;
        public float q;

        public b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = -3.4028235E38f;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = Integer.MIN_VALUE;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = -16777216;
            this.p = Integer.MIN_VALUE;
        }

        public b a() {
            return new b(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, null);
        }

        public b b() {
            this.n = false;
            return this;
        }

        public int c() {
            return this.g;
        }

        public int d() {
            return this.i;
        }

        public CharSequence e() {
            return this.a;
        }

        public b f(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public b g(float f) {
            this.m = f;
            return this;
        }

        public b h(float f, int i) {
            this.e = f;
            this.f = i;
            return this;
        }

        public b i(int i) {
            this.g = i;
            return this;
        }

        public b j(Layout.Alignment alignment) {
            this.d = alignment;
            return this;
        }

        public b k(float f) {
            this.h = f;
            return this;
        }

        public b l(int i) {
            this.i = i;
            return this;
        }

        public b m(float f) {
            this.q = f;
            return this;
        }

        public b n(float f) {
            this.l = f;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public b p(Layout.Alignment alignment) {
            this.c = alignment;
            return this;
        }

        public b q(float f, int i) {
            this.k = f;
            this.j = i;
            return this;
        }

        public b r(int i) {
            this.p = i;
            return this;
        }

        public b s(int i) {
            this.o = i;
            this.n = true;
            return this;
        }

        public b(b bVar) {
            this.a = bVar.a;
            this.b = bVar.e;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.f;
            this.f = bVar.g;
            this.g = bVar.h;
            this.h = bVar.i;
            this.i = bVar.j;
            this.j = bVar.o;
            this.k = bVar.p;
            this.l = bVar.k;
            this.m = bVar.l;
            this.n = bVar.m;
            this.o = bVar.n;
            this.p = bVar.q;
            this.q = bVar.r;
        }

        public /* synthetic */ b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6) {
        if (charSequence == null) {
            d4.a.e(bitmap);
        } else {
            d4.a.a(bitmap == null);
        }
        this.a = charSequence instanceof Spanned ? SpannedString.valueOf(charSequence) : charSequence != null ? charSequence.toString() : null;
        this.c = alignment;
        this.d = alignment2;
        this.e = bitmap;
        this.f = f;
        this.g = i;
        this.h = i2;
        this.i = f2;
        this.j = i3;
        this.k = f4;
        this.l = f5;
        this.m = z2;
        this.n = i5;
        this.o = i4;
        this.p = f3;
        this.q = i6;
        this.r = f6;
    }

    public static /* synthetic */ b a(Bundle bundle) {
        return c(bundle);
    }

    public static final b c(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(t);
        if (charSequence != null) {
            bVar.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(u);
        if (alignment != null) {
            bVar.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(v);
        if (alignment2 != null) {
            bVar.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(w);
        if (bitmap != null) {
            bVar.f(bitmap);
        }
        String str = x;
        if (bundle.containsKey(str)) {
            String str2 = y;
            if (bundle.containsKey(str2)) {
                bVar.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = z;
        if (bundle.containsKey(str3)) {
            bVar.i(bundle.getInt(str3));
        }
        String str4 = A;
        if (bundle.containsKey(str4)) {
            bVar.k(bundle.getFloat(str4));
        }
        String str5 = B;
        if (bundle.containsKey(str5)) {
            bVar.l(bundle.getInt(str5));
        }
        String str6 = D;
        if (bundle.containsKey(str6)) {
            String str7 = C;
            if (bundle.containsKey(str7)) {
                bVar.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = E;
        if (bundle.containsKey(str8)) {
            bVar.n(bundle.getFloat(str8));
        }
        String str9 = F;
        if (bundle.containsKey(str9)) {
            bVar.g(bundle.getFloat(str9));
        }
        String str10 = G;
        if (bundle.containsKey(str10)) {
            bVar.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(H, false)) {
            bVar.b();
        }
        String str11 = I;
        if (bundle.containsKey(str11)) {
            bVar.r(bundle.getInt(str11));
        }
        String str12 = J;
        if (bundle.containsKey(str12)) {
            bVar.m(bundle.getFloat(str12));
        }
        return bVar.a();
    }

    public b b() {
        return new b(this, null);
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.a, bVar.a) && this.c == bVar.c && this.d == bVar.d && ((bitmap = this.e) != null ? !((bitmap2 = bVar.e) == null || !bitmap.sameAs(bitmap2)) : bVar.e == null) && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h && this.i == bVar.i && this.j == bVar.j && this.k == bVar.k && this.l == bVar.l && this.m == bVar.m && this.n == bVar.n && this.o == bVar.o && this.p == bVar.p && this.q == bVar.q && this.r == bVar.r;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(t, this.a);
        bundle.putSerializable(u, this.c);
        bundle.putSerializable(v, this.d);
        bundle.putParcelable(w, this.e);
        bundle.putFloat(x, this.f);
        bundle.putInt(y, this.g);
        bundle.putInt(z, this.h);
        bundle.putFloat(A, this.i);
        bundle.putInt(B, this.j);
        bundle.putInt(C, this.o);
        bundle.putFloat(D, this.p);
        bundle.putFloat(E, this.k);
        bundle.putFloat(F, this.l);
        bundle.putBoolean(H, this.m);
        bundle.putInt(G, this.n);
        bundle.putInt(I, this.q);
        bundle.putFloat(J, this.r);
        return bundle;
    }

    public int hashCode() {
        return r5.j.b(this.a, this.c, this.d, this.e, Float.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Float.valueOf(this.i), Integer.valueOf(this.j), Float.valueOf(this.k), Float.valueOf(this.l), Boolean.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o), Float.valueOf(this.p), Integer.valueOf(this.q), Float.valueOf(this.r));
    }

    public /* synthetic */ b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6, a aVar) {
        this(charSequence, alignment, alignment2, bitmap, f, i, i2, f2, i3, i4, f3, f4, f5, z2, i5, i6, f6);
    }
}
