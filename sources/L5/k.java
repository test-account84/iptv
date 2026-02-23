package l5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class k {
    public static final l5.c m = new i(0.5f);
    public d a;
    public d b;
    public d c;
    public d d;
    public l5.c e;
    public l5.c f;
    public l5.c g;
    public l5.c h;
    public f i;
    public f j;
    public f k;
    public f l;

    public static final class b {
        public d a;
        public d b;
        public d c;
        public d d;
        public l5.c e;
        public l5.c f;
        public l5.c g;
        public l5.c h;
        public f i;
        public f j;
        public f k;
        public f l;

        public b() {
            this.a = h.b();
            this.b = h.b();
            this.c = h.b();
            this.d = h.b();
            this.e = new l5.a(0.0f);
            this.f = new l5.a(0.0f);
            this.g = new l5.a(0.0f);
            this.h = new l5.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
        }

        public static /* synthetic */ d a(b bVar) {
            return bVar.a;
        }

        public static /* synthetic */ f b(b bVar) {
            return bVar.j;
        }

        public static /* synthetic */ f c(b bVar) {
            return bVar.k;
        }

        public static /* synthetic */ f d(b bVar) {
            return bVar.l;
        }

        public static /* synthetic */ d e(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ d f(b bVar) {
            return bVar.c;
        }

        public static /* synthetic */ d g(b bVar) {
            return bVar.d;
        }

        public static /* synthetic */ l5.c h(b bVar) {
            return bVar.e;
        }

        public static /* synthetic */ l5.c i(b bVar) {
            return bVar.f;
        }

        public static /* synthetic */ l5.c j(b bVar) {
            return bVar.g;
        }

        public static /* synthetic */ l5.c k(b bVar) {
            return bVar.h;
        }

        public static /* synthetic */ f l(b bVar) {
            return bVar.i;
        }

        public static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).a;
            }
            return -1.0f;
        }

        public b A(float f) {
            this.e = new l5.a(f);
            return this;
        }

        public b B(l5.c cVar) {
            this.e = cVar;
            return this;
        }

        public b C(int i, l5.c cVar) {
            return D(h.a(i)).F(cVar);
        }

        public b D(d dVar) {
            this.b = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                E(n);
            }
            return this;
        }

        public b E(float f) {
            this.f = new l5.a(f);
            return this;
        }

        public b F(l5.c cVar) {
            this.f = cVar;
            return this;
        }

        public k m() {
            return new k(this, null);
        }

        public b o(float f) {
            return A(f).E(f).w(f).s(f);
        }

        public b p(l5.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        public b q(int i, l5.c cVar) {
            return r(h.a(i)).t(cVar);
        }

        public b r(d dVar) {
            this.d = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                s(n);
            }
            return this;
        }

        public b s(float f) {
            this.h = new l5.a(f);
            return this;
        }

        public b t(l5.c cVar) {
            this.h = cVar;
            return this;
        }

        public b u(int i, l5.c cVar) {
            return v(h.a(i)).x(cVar);
        }

        public b v(d dVar) {
            this.c = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                w(n);
            }
            return this;
        }

        public b w(float f) {
            this.g = new l5.a(f);
            return this;
        }

        public b x(l5.c cVar) {
            this.g = cVar;
            return this;
        }

        public b y(int i, l5.c cVar) {
            return z(h.a(i)).B(cVar);
        }

        public b z(d dVar) {
            this.a = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                A(n);
            }
            return this;
        }

        public b(k kVar) {
            this.a = h.b();
            this.b = h.b();
            this.c = h.b();
            this.d = h.b();
            this.e = new l5.a(0.0f);
            this.f = new l5.a(0.0f);
            this.g = new l5.a(0.0f);
            this.h = new l5.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
            this.a = kVar.a;
            this.b = kVar.b;
            this.c = kVar.c;
            this.d = kVar.d;
            this.e = kVar.e;
            this.f = kVar.f;
            this.g = kVar.g;
            this.h = kVar.h;
            this.i = kVar.i;
            this.j = kVar.j;
            this.k = kVar.k;
            this.l = kVar.l;
        }
    }

    public interface c {
        l5.c a(l5.c cVar);
    }

    public k() {
        this.a = h.b();
        this.b = h.b();
        this.c = h.b();
        this.d = h.b();
        this.e = new l5.a(0.0f);
        this.f = new l5.a(0.0f);
        this.g = new l5.a(0.0f);
        this.h = new l5.a(0.0f);
        this.i = h.c();
        this.j = h.c();
        this.k = h.c();
        this.l = h.c();
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i, int i2) {
        return c(context, i, i2, 0);
    }

    public static b c(Context context, int i, int i2, int i3) {
        return d(context, i, i2, new l5.a(i3));
    }

    public static b d(Context context, int i, int i2, l5.c cVar) {
        if (i2 != 0) {
            Context contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R4.l.F4);
        try {
            int i3 = obtainStyledAttributes.getInt(R4.l.G4, 0);
            int i4 = obtainStyledAttributes.getInt(R4.l.J4, i3);
            int i5 = obtainStyledAttributes.getInt(R4.l.K4, i3);
            int i6 = obtainStyledAttributes.getInt(R4.l.I4, i3);
            int i7 = obtainStyledAttributes.getInt(R4.l.H4, i3);
            l5.c m2 = m(obtainStyledAttributes, R4.l.L4, cVar);
            l5.c m3 = m(obtainStyledAttributes, R4.l.O4, m2);
            l5.c m4 = m(obtainStyledAttributes, R4.l.P4, m2);
            l5.c m5 = m(obtainStyledAttributes, R4.l.N4, m2);
            return new b().y(i4, m3).C(i5, m4).u(i6, m5).q(i7, m(obtainStyledAttributes, R4.l.M4, m2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i, int i2) {
        return f(context, attributeSet, i, i2, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return g(context, attributeSet, i, i2, new l5.a(i3));
    }

    public static b g(Context context, AttributeSet attributeSet, int i, int i2, l5.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R4.l.M3, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(R4.l.N3, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R4.l.O3, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    public static l5.c m(TypedArray typedArray, int i, l5.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cVar;
        }
        int i2 = peekValue.type;
        return i2 == 5 ? new l5.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.k;
    }

    public d i() {
        return this.d;
    }

    public l5.c j() {
        return this.h;
    }

    public d k() {
        return this.c;
    }

    public l5.c l() {
        return this.g;
    }

    public f n() {
        return this.l;
    }

    public f o() {
        return this.j;
    }

    public f p() {
        return this.i;
    }

    public d q() {
        return this.a;
    }

    public l5.c r() {
        return this.e;
    }

    public d s() {
        return this.b;
    }

    public l5.c t() {
        return this.f;
    }

    public boolean u(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float a2 = this.e.a(rectF);
        return z && ((this.f.a(rectF) > a2 ? 1 : (this.f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.h.a(rectF) > a2 ? 1 : (this.h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.g.a(rectF) > a2 ? 1 : (this.g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof j) && (this.a instanceof j) && (this.c instanceof j) && (this.d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f) {
        return v().o(f).m();
    }

    public k x(l5.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    public k(b bVar) {
        this.a = b.a(bVar);
        this.b = b.e(bVar);
        this.c = b.f(bVar);
        this.d = b.g(bVar);
        this.e = b.h(bVar);
        this.f = b.i(bVar);
        this.g = b.j(bVar);
        this.h = b.k(bVar);
        this.i = b.l(bVar);
        this.j = b.b(bVar);
        this.k = b.c(bVar);
        this.l = b.d(bVar);
    }

    public /* synthetic */ k(b bVar, a aVar) {
        this(bVar);
    }
}
