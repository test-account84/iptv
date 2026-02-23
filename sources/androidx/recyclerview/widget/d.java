package androidx.recyclerview.widget;

import P.L;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends RecyclerView.n implements RecyclerView.s {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.t C;
    public final int a;
    public final int b;
    public final StateListDrawable c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final StateListDrawable g;
    public final Drawable h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public float p;
    public RecyclerView s;
    public final ValueAnimator z;
    public int q = 0;
    public int r = 0;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d.this.s(500);
        }
    }

    public class b extends RecyclerView.t {
        public b() {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
            d.this.D(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    public class c extends AnimatorListenerAdapter {
        public boolean a = false;

        public c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                this.a = false;
                return;
            }
            if (((Float) d.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.A(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.x();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.c.setAlpha(floatValue);
            d.this.d.setAlpha(floatValue);
            d.this.x();
        }
    }

    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i, drawable.getIntrinsicWidth());
        this.i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i, drawable2.getIntrinsicWidth());
        this.a = i2;
        this.b = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        l(recyclerView);
    }

    public void A(int i) {
        int i2;
        if (i == 2 && this.v != 2) {
            this.c.setState(D);
            m();
        }
        if (i == 0) {
            x();
        } else {
            C();
        }
        if (this.v != 2 || i == 2) {
            i2 = i == 1 ? 1500 : 1200;
            this.v = i;
        }
        this.c.setState(E);
        y(i2);
        this.v = i;
    }

    public final void B() {
        this.s.h(this);
        this.s.k(this);
        this.s.l(this.C);
    }

    public void C() {
        int i = this.A;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.z.setDuration(500L);
        this.z.setStartDelay(0L);
        this.z.start();
    }

    public void D(int i, int i2) {
        int computeVerticalScrollRange = this.s.computeVerticalScrollRange();
        int i3 = this.r;
        this.t = computeVerticalScrollRange - i3 > 0 && i3 >= this.a;
        int computeHorizontalScrollRange = this.s.computeHorizontalScrollRange();
        int i4 = this.q;
        boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= this.a;
        this.u = z;
        boolean z2 = this.t;
        if (!z2 && !z) {
            if (this.v != 0) {
                A(0);
                return;
            }
            return;
        }
        if (z2) {
            float f = i3;
            this.l = (int) ((f * (i2 + (f / 2.0f))) / computeVerticalScrollRange);
            this.k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (this.u) {
            float f2 = i4;
            this.o = (int) ((f2 * (i + (f2 / 2.0f))) / computeHorizontalScrollRange);
            this.n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
        }
        int i5 = this.v;
        if (i5 == 0 || i5 == 1) {
            A(1);
        }
    }

    public final void E(float f) {
        int[] r = r();
        float max = Math.max(r[0], Math.min(r[1], f));
        if (Math.abs(this.l - max) < 2.0f) {
            return;
        }
        int z = z(this.m, max, r, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
        if (z != 0) {
            this.s.scrollBy(0, z);
        }
        this.m = max;
    }

    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean w = w(motionEvent.getX(), motionEvent.getY());
            boolean v = v(motionEvent.getX(), motionEvent.getY());
            if (w || v) {
                if (v) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (w) {
                    this.w = 2;
                    this.m = (int) motionEvent.getY();
                }
                A(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.v == 2) {
            this.m = 0.0f;
            this.p = 0.0f;
            A(1);
            this.w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.v == 2) {
            C();
            if (this.w == 1) {
                t(motionEvent.getX());
            }
            if (this.w == 2) {
                E(motionEvent.getY());
            }
        }
    }

    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.v;
        if (i == 1) {
            boolean w = w(motionEvent.getX(), motionEvent.getY());
            boolean v = v(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!w && !v) {
                return false;
            }
            if (v) {
                this.w = 1;
                this.p = (int) motionEvent.getX();
            } else if (w) {
                this.w = 2;
                this.m = (int) motionEvent.getY();
            }
            A(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    public void e(boolean z) {
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.A a2) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            A(0);
        } else if (this.A != 0) {
            if (this.t) {
                p(canvas);
            }
            if (this.u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.s = recyclerView;
        if (recyclerView != null) {
            B();
        }
    }

    public final void m() {
        this.s.removeCallbacks(this.B);
    }

    public final void n() {
        this.s.a1(this);
        this.s.c1(this);
        this.s.d1(this.C);
        m();
    }

    public final void o(Canvas canvas) {
        int i = this.r;
        int i2 = this.i;
        int i3 = this.o;
        int i4 = this.n;
        this.g.setBounds(0, 0, i4, i2);
        this.h.setBounds(0, 0, this.q, this.j);
        canvas.translate(0.0f, i - i2);
        this.h.draw(canvas);
        canvas.translate(i3 - (i4 / 2), 0.0f);
        this.g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void p(Canvas canvas) {
        int i = this.q;
        int i2 = this.e;
        int i3 = i - i2;
        int i4 = this.l;
        int i5 = this.k;
        int i6 = i4 - (i5 / 2);
        this.c.setBounds(0, 0, i2, i5);
        this.d.setBounds(0, 0, this.f, this.r);
        if (u()) {
            this.d.draw(canvas);
            canvas.translate(this.e, i6);
            canvas.scale(-1.0f, 1.0f);
            this.c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            i3 = this.e;
        } else {
            canvas.translate(i3, 0.0f);
            this.d.draw(canvas);
            canvas.translate(0.0f, i6);
            this.c.draw(canvas);
        }
        canvas.translate(-i3, -i6);
    }

    public final int[] q() {
        int[] iArr = this.y;
        int i = this.b;
        iArr[0] = i;
        iArr[1] = this.q - i;
        return iArr;
    }

    public final int[] r() {
        int[] iArr = this.x;
        int i = this.b;
        iArr[0] = i;
        iArr[1] = this.r - i;
        return iArr;
    }

    public void s(int i) {
        int i2 = this.A;
        if (i2 == 1) {
            this.z.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.z.setDuration(i);
        this.z.start();
    }

    public final void t(float f) {
        int[] q = q();
        float max = Math.max(q[0], Math.min(q[1], f));
        if (Math.abs(this.o - max) < 2.0f) {
            return;
        }
        int z = z(this.p, max, q, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
        if (z != 0) {
            this.s.scrollBy(z, 0);
        }
        this.p = max;
    }

    public final boolean u() {
        return L.E(this.s) == 1;
    }

    public boolean v(float f, float f2) {
        if (f2 >= this.r - this.i) {
            int i = this.o;
            int i2 = this.n;
            if (f >= i - (i2 / 2) && f <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean w(float f, float f2) {
        if (!u() ? f >= this.q - this.e : f <= this.e / 2) {
            int i = this.l;
            int i2 = this.k;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    public void x() {
        this.s.invalidate();
    }

    public final void y(int i) {
        m();
        this.s.postDelayed(this.B, i);
    }

    public final int z(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }
}
