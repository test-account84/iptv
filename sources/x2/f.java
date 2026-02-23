package x2;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {
    public float e;
    public float f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public ValueAnimator o;
    public static final Rect t = new Rect();
    public static final Property u = new c("rotateX");
    public static final Property v = new d("rotate");
    public static final Property w = new e("rotateY");
    public static final Property x = new f("translateX");
    public static final Property y = new g("translateY");
    public static final Property z = new h("translateXPercentage");
    public static final Property A = new i("translateYPercentage");
    public static final Property B = new j("scaleX");
    public static final Property C = new k("scaleY");
    public static final Property D = new a("scale");
    public static final Property E = new b("alpha");
    public float a = 1.0f;
    public float c = 1.0f;
    public float d = 1.0f;
    public int p = 255;
    public Rect q = t;
    public Camera r = new Camera();
    public Matrix s = new Matrix();

    public static class a extends v2.b {
        public a(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.j());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, float f) {
            fVar.C(f);
        }
    }

    public static class b extends v2.c {
        public b(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getAlpha());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, int i) {
            fVar.setAlpha(i);
        }
    }

    public static class c extends v2.c {
        public c(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.h());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, int i) {
            fVar.A(i);
        }
    }

    public static class d extends v2.c {
        public d(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.g());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, int i) {
            fVar.z(i);
        }
    }

    public static class e extends v2.c {
        public e(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.i());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, int i) {
            fVar.B(i);
        }
    }

    public static class f extends v2.c {
        public f(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.m());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, int i) {
            fVar.F(i);
        }
    }

    public static class g extends v2.c {
        public g(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.o());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, int i) {
            fVar.H(i);
        }
    }

    public static class h extends v2.b {
        public h(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.n());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, float f) {
            fVar.G(f);
        }
    }

    public static class i extends v2.b {
        public i(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.p());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, float f) {
            fVar.I(f);
        }
    }

    public static class j extends v2.b {
        public j(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.k());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, float f) {
            fVar.D(f);
        }
    }

    public static class k extends v2.b {
        public k(String str) {
            super(str);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.l());
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, float f) {
            fVar.E(f);
        }
    }

    public void A(int i2) {
        this.h = i2;
    }

    public void B(int i2) {
        this.i = i2;
    }

    public void C(float f2) {
        this.a = f2;
        D(f2);
        E(f2);
    }

    public void D(float f2) {
        this.c = f2;
    }

    public void E(float f2) {
        this.d = f2;
    }

    public void F(int i2) {
        this.j = i2;
    }

    public void G(float f2) {
        this.m = f2;
    }

    public void H(int i2) {
        this.k = i2;
    }

    public void I(float f2) {
        this.n = f2;
    }

    public Rect a(Rect rect) {
        int min = Math.min(rect.width(), rect.height());
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i2 = min / 2;
        return new Rect(centerX - i2, centerY - i2, centerX + i2, centerY + i2);
    }

    public abstract void b(Canvas canvas);

    public abstract int c();

    public Rect d() {
        return this.q;
    }

    public void draw(Canvas canvas) {
        int m = m();
        if (m == 0) {
            m = (int) (getBounds().width() * n());
        }
        int o = o();
        if (o == 0) {
            o = (int) (getBounds().height() * p());
        }
        canvas.translate(m, o);
        canvas.scale(k(), l(), e(), f());
        canvas.rotate(g(), e(), f());
        if (h() != 0 || i() != 0) {
            this.r.save();
            this.r.rotateX(h());
            this.r.rotateY(i());
            this.r.getMatrix(this.s);
            this.s.preTranslate(-e(), -f());
            this.s.postTranslate(e(), f());
            this.r.restore();
            canvas.concat(this.s);
        }
        b(canvas);
    }

    public float e() {
        return this.e;
    }

    public float f() {
        return this.f;
    }

    public int g() {
        return this.l;
    }

    public int getAlpha() {
        return this.p;
    }

    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isRunning() {
        return v2.a.a(this.o);
    }

    public float j() {
        return this.a;
    }

    public float k() {
        return this.c;
    }

    public float l() {
        return this.d;
    }

    public int m() {
        return this.j;
    }

    public float n() {
        return this.m;
    }

    public int o() {
        return this.k;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        w(rect);
    }

    public float p() {
        return this.n;
    }

    public ValueAnimator q() {
        if (this.o == null) {
            this.o = r();
        }
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(this);
            this.o.setStartDelay(this.g);
        }
        return this.o;
    }

    public abstract ValueAnimator r();

    public void s() {
        this.a = 1.0f;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0.0f;
        this.n = 0.0f;
    }

    public void setAlpha(int i2) {
        this.p = i2;
    }

    public void start() {
        if (v2.a.c(this.o)) {
            return;
        }
        ValueAnimator q = q();
        this.o = q;
        if (q == null) {
            return;
        }
        v2.a.d(q);
        invalidateSelf();
    }

    public void stop() {
        if (v2.a.c(this.o)) {
            this.o.removeAllUpdateListeners();
            this.o.end();
            s();
        }
    }

    public f t(int i2) {
        this.g = i2;
        return this;
    }

    public abstract void u(int i2);

    public void v(int i2, int i3, int i4, int i5) {
        this.q = new Rect(i2, i3, i4, i5);
        x(d().centerX());
        y(d().centerY());
    }

    public void w(Rect rect) {
        v(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void x(float f2) {
        this.e = f2;
    }

    public void y(float f2) {
        this.f = f2;
    }

    public void z(int i2) {
        this.l = i2;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
    }
}
