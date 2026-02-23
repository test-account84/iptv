package androidx.recyclerview.widget;

import P.L;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends RecyclerView.n implements RecyclerView.q {
    public f A;
    public Rect C;
    public long D;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public e m;
    public int o;
    public int q;
    public RecyclerView r;
    public VelocityTracker t;
    public List u;
    public List v;
    public RecyclerView.j w;
    public P.o z;
    public final List a = new ArrayList();
    public final float[] b = new float[2];
    public RecyclerView.D c = null;
    public int l = -1;
    public int n = 0;
    public List p = new ArrayList();
    public final Runnable s = new a();
    public View x = null;
    public int y = -1;
    public final RecyclerView.s B = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            f fVar = f.this;
            if (fVar.c == null || !fVar.E()) {
                return;
            }
            f fVar2 = f.this;
            RecyclerView.D d = fVar2.c;
            if (d != null) {
                fVar2.z(d);
            }
            f fVar3 = f.this;
            fVar3.r.removeCallbacks(fVar3.s);
            L.k0(f.this.r, this);
        }
    }

    public class b implements RecyclerView.s {
        public b() {
        }

        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            f.this.z.a(motionEvent);
            VelocityTracker velocityTracker = f.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (f.this.l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(f.this.l);
            if (findPointerIndex >= 0) {
                f.this.o(actionMasked, motionEvent, findPointerIndex);
            }
            f fVar = f.this;
            RecyclerView.D d = fVar.c;
            if (d == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (findPointerIndex >= 0) {
                        fVar.L(motionEvent, fVar.o, findPointerIndex);
                        f.this.z(d);
                        f fVar2 = f.this;
                        fVar2.r.removeCallbacks(fVar2.s);
                        f.this.s.run();
                        f.this.r.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    f fVar3 = f.this;
                    if (pointerId == fVar3.l) {
                        fVar3.l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        f fVar4 = f.this;
                        fVar4.L(motionEvent, fVar4.o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = fVar.t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            f.this.F(null, 0);
            f.this.l = -1;
        }

        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            g s;
            f.this.z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                f.this.l = motionEvent.getPointerId(0);
                f.this.d = motionEvent.getX();
                f.this.e = motionEvent.getY();
                f.this.A();
                f fVar = f.this;
                if (fVar.c == null && (s = fVar.s(motionEvent)) != null) {
                    f fVar2 = f.this;
                    fVar2.d -= s.k;
                    fVar2.e -= s.l;
                    fVar2.r(s.f, true);
                    if (f.this.a.remove(s.f.a)) {
                        f fVar3 = f.this;
                        fVar3.m.c(fVar3.r, s.f);
                    }
                    f.this.F(s.f, s.g);
                    f fVar4 = f.this;
                    fVar4.L(motionEvent, fVar4.o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                f fVar5 = f.this;
                fVar5.l = -1;
                fVar5.F(null, 0);
            } else {
                int i = f.this.l;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                    f.this.o(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = f.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return f.this.c != null;
        }

        public void e(boolean z) {
            if (z) {
                f.this.F(null, 0);
            }
        }
    }

    public class c extends g {
        public final /* synthetic */ int p;
        public final /* synthetic */ RecyclerView.D q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RecyclerView.D d, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView.D d2) {
            super(d, i, i2, f, f2, f3, f4);
            this.p = i3;
            this.q = d2;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.m) {
                return;
            }
            if (this.p <= 0) {
                f fVar = f.this;
                fVar.m.c(fVar.r, this.q);
            } else {
                f.this.a.add(this.q.a);
                this.j = true;
                int i = this.p;
                if (i > 0) {
                    f.this.B(this, i);
                }
            }
            f fVar2 = f.this;
            View view = fVar2.x;
            View view2 = this.q.a;
            if (view == view2) {
                fVar2.D(view2);
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ int c;

        public d(g gVar, int i) {
            this.a = gVar;
            this.c = i;
        }

        public void run() {
            RecyclerView recyclerView = f.this.r;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            g gVar = this.a;
            if (gVar.m || gVar.f.m() == -1) {
                return;
            }
            RecyclerView.l itemAnimator = f.this.r.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.q(null)) && !f.this.x()) {
                f.this.m.B(this.a.f, this.c);
            } else {
                f.this.r.post(this);
            }
        }
    }

    public static abstract class e {
        public static final Interpolator b = new a();
        public static final Interpolator c = new b();
        public int a = -1;

        public static class a implements Interpolator {
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        }

        public static class b implements Interpolator {
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }

        public static int e(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (~i4);
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        public static int s(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int t(int i, int i2) {
            return s(2, i) | s(1, i2) | s(0, i2 | i);
        }

        public void A(RecyclerView.D d, int i) {
            if (d != null) {
                B0.b.a.b(d.a);
            }
        }

        public abstract void B(RecyclerView.D d, int i);

        public boolean a(RecyclerView recyclerView, RecyclerView.D d, RecyclerView.D d2) {
            return true;
        }

        public RecyclerView.D b(RecyclerView.D d, List list, int i, int i2) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i + d.a.getWidth();
            int height = i2 + d.a.getHeight();
            int left2 = i - d.a.getLeft();
            int top2 = i2 - d.a.getTop();
            int size = list.size();
            RecyclerView.D d2 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.D d3 = (RecyclerView.D) list.get(i4);
                if (left2 > 0 && (right = d3.a.getRight() - width) < 0 && d3.a.getRight() > d.a.getRight() && (abs4 = Math.abs(right)) > i3) {
                    d2 = d3;
                    i3 = abs4;
                }
                if (left2 < 0 && (left = d3.a.getLeft() - i) > 0 && d3.a.getLeft() < d.a.getLeft() && (abs3 = Math.abs(left)) > i3) {
                    d2 = d3;
                    i3 = abs3;
                }
                if (top2 < 0 && (top = d3.a.getTop() - i2) > 0 && d3.a.getTop() < d.a.getTop() && (abs2 = Math.abs(top)) > i3) {
                    d2 = d3;
                    i3 = abs2;
                }
                if (top2 > 0 && (bottom = d3.a.getBottom() - height) < 0 && d3.a.getBottom() > d.a.getBottom() && (abs = Math.abs(bottom)) > i3) {
                    d2 = d3;
                    i3 = abs;
                }
            }
            return d2;
        }

        public void c(RecyclerView recyclerView, RecyclerView.D d) {
            B0.b.a.a(d.a);
        }

        public int d(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (~i4);
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public final int f(RecyclerView recyclerView, RecyclerView.D d) {
            return d(k(recyclerView, d), L.E(recyclerView));
        }

        public long g(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.n() : itemAnimator.o();
        }

        public int h() {
            return 0;
        }

        public final int i(RecyclerView recyclerView) {
            if (this.a == -1) {
                this.a = recyclerView.getResources().getDimensionPixelSize(A0.b.d);
            }
            return this.a;
        }

        public float j(RecyclerView.D d) {
            return 0.5f;
        }

        public abstract int k(RecyclerView recyclerView, RecyclerView.D d);

        public float l(float f) {
            return f;
        }

        public float m(RecyclerView.D d) {
            return 0.5f;
        }

        public float n(float f) {
            return f;
        }

        public boolean o(RecyclerView recyclerView, RecyclerView.D d) {
            return (f(recyclerView, d) & 16711680) != 0;
        }

        public int p(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int signum = (int) (((int) (((int) Math.signum(i2)) * i(recyclerView) * c.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))) * b.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f));
            return signum == 0 ? i2 > 0 ? 1 : -1 : signum;
        }

        public abstract boolean q();

        public abstract boolean r();

        public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.D d, float f, float f2, int i, boolean z) {
            B0.b.a.c(canvas, recyclerView, d.a, f, f2, i, z);
        }

        public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.D d, float f, float f2, int i, boolean z) {
            B0.b.a.d(canvas, recyclerView, d.a, f, f2, i, z);
        }

        public void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.D d, List list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) list.get(i2);
                gVar.e();
                int save = canvas.save();
                u(canvas, recyclerView, gVar.f, gVar.k, gVar.l, gVar.g, false);
                canvas.restoreToCount(save);
            }
            if (d != null) {
                int save2 = canvas.save();
                u(canvas, recyclerView, d, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        public void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.D d, List list, int i, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) list.get(i2);
                int save = canvas.save();
                v(canvas, recyclerView, gVar.f, gVar.k, gVar.l, gVar.g, false);
                canvas.restoreToCount(save);
            }
            if (d != null) {
                int save2 = canvas.save();
                v(canvas, recyclerView, d, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                g gVar2 = (g) list.get(i3);
                boolean z2 = gVar2.n;
                if (z2 && !gVar2.j) {
                    list.remove(i3);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(RecyclerView recyclerView, RecyclerView.D d, RecyclerView.D d2);

        /* JADX WARN: Multi-variable type inference failed */
        public void z(RecyclerView recyclerView, RecyclerView.D d, int i, RecyclerView.D d2, int i2, int i3, int i4) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof h) {
                ((h) layoutManager).j(d.a, d2.a, i3, i4);
                return;
            }
            if (layoutManager.H()) {
                if (layoutManager.o0(d2.a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.m1(i2);
                }
                if (layoutManager.r0(d2.a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.m1(i2);
                }
            }
            if (layoutManager.I()) {
                if (layoutManager.s0(d2.a) <= recyclerView.getPaddingTop()) {
                    recyclerView.m1(i2);
                }
                if (layoutManager.m0(d2.a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.m1(i2);
                }
            }
        }
    }

    public class f extends GestureDetector.SimpleOnGestureListener {
        public boolean a = true;

        public f() {
        }

        public void a() {
            this.a = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View t;
            RecyclerView.D i0;
            if (!this.a || (t = f.this.t(motionEvent)) == null || (i0 = f.this.r.i0(t)) == null) {
                return;
            }
            f fVar = f.this;
            if (fVar.m.o(fVar.r, i0)) {
                int pointerId = motionEvent.getPointerId(0);
                int i = f.this.l;
                if (pointerId == i) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    f fVar2 = f.this;
                    fVar2.d = x;
                    fVar2.e = y;
                    fVar2.i = 0.0f;
                    fVar2.h = 0.0f;
                    if (fVar2.m.r()) {
                        f.this.F(i0, 2);
                    }
                }
            }
        }
    }

    public static class g implements Animator.AnimatorListener {
        public final float a;
        public final float c;
        public final float d;
        public final float e;
        public final RecyclerView.D f;
        public final int g;
        public final ValueAnimator h;
        public final int i;
        public boolean j;
        public float k;
        public float l;
        public boolean m = false;
        public boolean n = false;
        public float o;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        public g(RecyclerView.D d, int i, int i2, float f, float f2, float f3, float f4) {
            this.g = i2;
            this.i = i;
            this.f = d;
            this.a = f;
            this.c = f2;
            this.d = f3;
            this.e = f4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.h = ofFloat;
            ofFloat.addUpdateListener(new a());
            ofFloat.setTarget(d.a);
            ofFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.h.cancel();
        }

        public void b(long j) {
            this.h.setDuration(j);
        }

        public void c(float f) {
            this.o = f;
        }

        public void d() {
            this.f.J(false);
            this.h.start();
        }

        public void e() {
            float f = this.a;
            float f2 = this.d;
            this.k = f == f2 ? this.f.a.getTranslationX() : f + (this.o * (f2 - f));
            float f3 = this.c;
            float f4 = this.e;
            this.l = f3 == f4 ? this.f.a.getTranslationY() : f3 + (this.o * (f4 - f3));
        }

        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.n) {
                this.f.J(true);
            }
            this.n = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface h {
        void j(View view, View view2, int i, int i2);
    }

    public f(e eVar) {
        this.m = eVar;
    }

    private void G() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.h(this);
        this.r.k(this.B);
        this.r.j(this);
        I();
    }

    private void q() {
        this.r.a1(this);
        this.r.c1(this.B);
        this.r.b1(this);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            this.m.c(this.r, ((g) this.p.get(0)).f);
        }
        this.p.clear();
        this.x = null;
        this.y = -1;
        C();
        J();
    }

    public static boolean y(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    public void A() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    public void B(g gVar, int i) {
        this.r.post(new d(gVar, i));
    }

    public final void C() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    public void D(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean E() {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.E():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void F(androidx.recyclerview.widget.RecyclerView.D r24, int r25) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.F(androidx.recyclerview.widget.RecyclerView$D, int):void");
    }

    public void H(RecyclerView.D d2) {
        if (!this.m.o(this.r, d2)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (d2.a.getParent() != this.r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        A();
        this.i = 0.0f;
        this.h = 0.0f;
        F(d2, 2);
    }

    public final void I() {
        this.A = new f();
        this.z = new P.o(this.r.getContext(), this.A);
    }

    public final void J() {
        f fVar = this.A;
        if (fVar != null) {
            fVar.a();
            this.A = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    public final int K(RecyclerView.D d2) {
        if (this.n == 2) {
            return 0;
        }
        int k = this.m.k(this.r, d2);
        int d3 = (this.m.d(k, L.E(this.r)) & 65280) >> 8;
        if (d3 == 0) {
            return 0;
        }
        int i = (k & 65280) >> 8;
        if (Math.abs(this.h) > Math.abs(this.i)) {
            int n = n(d2, d3);
            if (n > 0) {
                return (i & n) == 0 ? e.e(n, L.E(this.r)) : n;
            }
            int p = p(d2, d3);
            if (p > 0) {
                return p;
            }
        } else {
            int p2 = p(d2, d3);
            if (p2 > 0) {
                return p2;
            }
            int n2 = n(d2, d3);
            if (n2 > 0) {
                return (i & n2) == 0 ? e.e(n2, L.E(this.r)) : n2;
            }
        }
        return 0;
    }

    public void L(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f2 = x - this.d;
        this.h = f2;
        this.i = y - this.e;
        if ((i & 4) == 0) {
            this.h = Math.max(0.0f, f2);
        }
        if ((i & 8) == 0) {
            this.h = Math.min(0.0f, this.h);
        }
        if ((i & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((i & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }

    public void b(View view) {
        D(view);
        RecyclerView.D i0 = this.r.i0(view);
        if (i0 == null) {
            return;
        }
        RecyclerView.D d2 = this.c;
        if (d2 != null && i0 == d2) {
            F(null, 0);
            return;
        }
        r(i0, false);
        if (this.a.remove(i0.a)) {
            this.m.c(this.r, i0);
        }
    }

    public void d(View view) {
    }

    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.A a2) {
        rect.setEmpty();
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.A a2) {
        float f2;
        float f3;
        this.y = -1;
        if (this.c != null) {
            w(this.b);
            float[] fArr = this.b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.m.w(canvas, recyclerView, this.c, this.p, this.n, f2, f3);
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.A a2) {
        float f2;
        float f3;
        if (this.c != null) {
            w(this.b);
            float[] fArr = this.b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.m.x(canvas, recyclerView, this.c, this.p, this.n, f2, f3);
    }

    public final void l() {
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            q();
        }
        this.r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f = resources.getDimension(A0.b.f);
            this.g = resources.getDimension(A0.b.e);
            G();
        }
    }

    public final int n(RecyclerView.D d2, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.m.n(this.g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = xVelocity > 0.0f ? 8 : 4;
            float abs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && abs >= this.m.l(this.f) && abs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = this.r.getWidth() * this.m.m(d2);
        if ((i & i2) == 0 || Math.abs(this.h) <= width) {
            return 0;
        }
        return i2;
    }

    public void o(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.D v;
        int f2;
        if (this.c != null || i != 2 || this.n == 2 || !this.m.q() || this.r.getScrollState() == 1 || (v = v(motionEvent)) == null || (f2 = (this.m.f(this.r, v) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f3 = x - this.d;
        float f4 = y - this.e;
        float abs = Math.abs(f3);
        float abs2 = Math.abs(f4);
        int i3 = this.q;
        if (abs >= i3 || abs2 >= i3) {
            if (abs > abs2) {
                if (f3 < 0.0f && (f2 & 4) == 0) {
                    return;
                }
                if (f3 > 0.0f && (f2 & 8) == 0) {
                    return;
                }
            } else {
                if (f4 < 0.0f && (f2 & 1) == 0) {
                    return;
                }
                if (f4 > 0.0f && (f2 & 2) == 0) {
                    return;
                }
            }
            this.i = 0.0f;
            this.h = 0.0f;
            this.l = motionEvent.getPointerId(0);
            F(v, 1);
        }
    }

    public final int p(RecyclerView.D d2, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.m.n(this.g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = yVelocity > 0.0f ? 2 : 1;
            float abs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && abs >= this.m.l(this.f) && abs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = this.r.getHeight() * this.m.m(d2);
        if ((i & i2) == 0 || Math.abs(this.i) <= height) {
            return 0;
        }
        return i2;
    }

    public void r(RecyclerView.D d2, boolean z) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.p.get(size);
            if (gVar.f == d2) {
                gVar.m |= z;
                if (!gVar.n) {
                    gVar.a();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    public g s(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        View t = t(motionEvent);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.p.get(size);
            if (gVar.f.a == t) {
                return gVar;
            }
        }
        return null;
    }

    public View t(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.D d2 = this.c;
        if (d2 != null) {
            View view = d2.a;
            if (y(view, x, y, this.j + this.h, this.k + this.i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.p.get(size);
            View view2 = gVar.f.a;
            if (y(view2, x, y, gVar.k, gVar.l)) {
                return view2;
            }
        }
        return this.r.S(x, y);
    }

    public final List u(RecyclerView.D d2) {
        RecyclerView.D d3 = d2;
        List list = this.u;
        if (list == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            list.clear();
            this.v.clear();
        }
        int h2 = this.m.h();
        int round = Math.round(this.j + this.h) - h2;
        int round2 = Math.round(this.k + this.i) - h2;
        int i = h2 * 2;
        int width = d3.a.getWidth() + round + i;
        int height = d3.a.getHeight() + round2 + i;
        int i2 = (round + width) / 2;
        int i3 = (round2 + height) / 2;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int h0 = layoutManager.h0();
        int i4 = 0;
        while (i4 < h0) {
            View g0 = layoutManager.g0(i4);
            if (g0 != d3.a && g0.getBottom() >= round2 && g0.getTop() <= height && g0.getRight() >= round && g0.getLeft() <= width) {
                RecyclerView.D i0 = this.r.i0(g0);
                if (this.m.a(this.r, this.c, i0)) {
                    int abs = Math.abs(i2 - ((g0.getLeft() + g0.getRight()) / 2));
                    int abs2 = Math.abs(i3 - ((g0.getTop() + g0.getBottom()) / 2));
                    int i5 = (abs * abs) + (abs2 * abs2);
                    int size = this.u.size();
                    int i6 = 0;
                    for (int i7 = 0; i7 < size && i5 > ((Integer) this.v.get(i7)).intValue(); i7++) {
                        i6++;
                    }
                    this.u.add(i6, i0);
                    this.v.add(i6, Integer.valueOf(i5));
                }
            }
            i4++;
            d3 = d2;
        }
        return this.u;
    }

    public final RecyclerView.D v(MotionEvent motionEvent) {
        View t;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int i = this.l;
        if (i == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(findPointerIndex) - this.d;
        float y = motionEvent.getY(findPointerIndex) - this.e;
        float abs = Math.abs(x);
        float abs2 = Math.abs(y);
        int i2 = this.q;
        if (abs < i2 && abs2 < i2) {
            return null;
        }
        if (abs > abs2 && layoutManager.H()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.I()) && (t = t(motionEvent)) != null) {
            return this.r.i0(t);
        }
        return null;
    }

    public final void w(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.h) - this.c.a.getLeft();
        } else {
            fArr[0] = this.c.a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - this.c.a.getTop();
        } else {
            fArr[1] = this.c.a.getTranslationY();
        }
    }

    public boolean x() {
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            if (!((g) this.p.get(i)).n) {
                return true;
            }
        }
        return false;
    }

    public void z(RecyclerView.D d2) {
        if (!this.r.isLayoutRequested() && this.n == 2) {
            float j = this.m.j(d2);
            int i = (int) (this.j + this.h);
            int i2 = (int) (this.k + this.i);
            if (Math.abs(i2 - d2.a.getTop()) >= d2.a.getHeight() * j || Math.abs(i - d2.a.getLeft()) >= d2.a.getWidth() * j) {
                List u = u(d2);
                if (u.size() == 0) {
                    return;
                }
                RecyclerView.D b2 = this.m.b(d2, u, i, i2);
                if (b2 == null) {
                    this.u.clear();
                    this.v.clear();
                    return;
                }
                int m = b2.m();
                int m2 = d2.m();
                if (this.m.y(this.r, d2, b2)) {
                    this.m.z(this.r, d2, m2, b2, m, i, i2);
                }
            }
        }
    }
}
