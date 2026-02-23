package com.google.android.material.floatingactionbutton;

import P.L;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import l5.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    public static final TimeInterpolator D = S4.a.c;
    public static final int[] E = {16842919, 16842910};
    public static final int[] F = {16843623, 16842908, 16842910};
    public static final int[] G = {16842908, 16842910};
    public static final int[] H = {16843623, 16842910};
    public static final int[] I = {16842910};
    public static final int[] J = new int[0];
    public ViewTreeObserver.OnPreDrawListener C;
    public l5.k a;
    public l5.g b;
    public Drawable c;
    public e5.a d;
    public Drawable e;
    public boolean f;
    public float h;
    public float i;
    public float j;
    public int k;
    public final f5.i l;
    public Animator m;
    public S4.f n;
    public S4.f o;
    public float p;
    public int r;
    public ArrayList t;
    public ArrayList u;
    public ArrayList v;
    public final FloatingActionButton w;
    public final k5.b x;
    public boolean g = true;
    public float q = 1.0f;
    public int s = 0;
    public final Rect y = new Rect();
    public final RectF z = new RectF();
    public final RectF A = new RectF();
    public final Matrix B = new Matrix();

    public class a extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ k d;

        public a(boolean z, k kVar) {
            this.c = z;
        }

        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        public void onAnimationEnd(Animator animator) {
            a.a(a.this, 0);
            a.b(a.this, null);
            if (this.a) {
                return;
            }
            FloatingActionButton floatingActionButton = a.this.w;
            boolean z = this.c;
            floatingActionButton.b(z ? 8 : 4, z);
            k kVar = this.d;
            if (kVar != null) {
                kVar.b();
            }
        }

        public void onAnimationStart(Animator animator) {
            a.this.w.b(0, this.c);
            a.a(a.this, 1);
            a.b(a.this, animator);
            this.a = false;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ k c;

        public b(boolean z, k kVar) {
            this.a = z;
        }

        public void onAnimationEnd(Animator animator) {
            a.a(a.this, 0);
            a.b(a.this, null);
            k kVar = this.c;
            if (kVar != null) {
                kVar.a();
            }
        }

        public void onAnimationStart(Animator animator) {
            a.this.w.b(0, this.a);
            a.a(a.this, 2);
            a.b(a.this, animator);
        }
    }

    public class c extends S4.e {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            a.c(a.this, f);
            return super.a(f, matrix, matrix2);
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float a;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ float f;
        public final /* synthetic */ float g;
        public final /* synthetic */ float h;
        public final /* synthetic */ Matrix i;

        public d(float f, float f2, float f3, float f4, float f5, float f6, float f7, Matrix matrix) {
            this.a = f;
            this.c = f2;
            this.d = f3;
            this.e = f4;
            this.f = f5;
            this.g = f6;
            this.h = f7;
            this.i = matrix;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.w.setAlpha(S4.a.b(this.a, this.c, 0.0f, 0.2f, floatValue));
            a.this.w.setScaleX(S4.a.a(this.d, this.e, floatValue));
            a.this.w.setScaleY(S4.a.a(this.f, this.e, floatValue));
            a.c(a.this, S4.a.a(this.g, this.h, floatValue));
            a.d(a.this, S4.a.a(this.g, this.h, floatValue), this.i);
            a.this.w.setImageMatrix(this.i);
        }
    }

    public class e implements TypeEvaluator {
        public FloatEvaluator a = new FloatEvaluator();

        public e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f, Float f2, Float f3) {
            float floatValue = this.a.evaluate(f, f2, f3).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    public class f implements ViewTreeObserver.OnPreDrawListener {
        public f() {
        }

        public boolean onPreDraw() {
            a.this.D();
            return true;
        }
    }

    public class g extends m {
        public g() {
            super(a.this, null);
        }

        public float a() {
            return 0.0f;
        }
    }

    public class h extends m {
        public h() {
            super(a.this, null);
        }

        public float a() {
            a aVar = a.this;
            return aVar.h + aVar.i;
        }
    }

    public class i extends m {
        public i() {
            super(a.this, null);
        }

        public float a() {
            a aVar = a.this;
            return aVar.h + aVar.j;
        }
    }

    public interface j {
        void a();

        void b();
    }

    public interface k {
        void a();

        void b();
    }

    public class l extends m {
        public l() {
            super(a.this, null);
        }

        public float a() {
            return a.this.h;
        }
    }

    public abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public boolean a;
        public float c;
        public float d;

        public m() {
        }

        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            a.this.c0((int) this.d);
            this.a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                l5.g gVar = a.this.b;
                this.c = gVar == null ? 0.0f : gVar.w();
                this.d = a();
                this.a = true;
            }
            a aVar = a.this;
            float f = this.c;
            aVar.c0((int) (f + ((this.d - f) * valueAnimator.getAnimatedFraction())));
        }

        public /* synthetic */ m(a aVar, a aVar2) {
            this();
        }
    }

    public a(FloatingActionButton floatingActionButton, k5.b bVar) {
        this.w = floatingActionButton;
        this.x = bVar;
        f5.i iVar = new f5.i();
        this.l = iVar;
        iVar.a(E, h(new i()));
        iVar.a(F, h(new h()));
        iVar.a(G, h(new h()));
        iVar.a(H, h(new h()));
        iVar.a(I, h(new l()));
        iVar.a(J, h(new g()));
        this.p = floatingActionButton.getRotation();
    }

    public static /* synthetic */ int a(a aVar, int i2) {
        aVar.s = i2;
        return i2;
    }

    public static /* synthetic */ Animator b(a aVar, Animator animator) {
        aVar.m = animator;
        return animator;
    }

    public static /* synthetic */ float c(a aVar, float f2) {
        aVar.q = f2;
        return f2;
    }

    public static /* synthetic */ void d(a aVar, float f2, Matrix matrix) {
        aVar.e(f2, matrix);
    }

    public abstract void A(int[] iArr);

    public abstract void B(float f2, float f3, float f4);

    public void C(Rect rect) {
        k5.b bVar;
        InsetDrawable insetDrawable;
        O.h.g(this.e, "Didn't initialize content background");
        if (V()) {
            insetDrawable = new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom);
            bVar = this.x;
        } else {
            bVar = this.x;
            insetDrawable = this.e;
        }
        bVar.b(insetDrawable);
    }

    public void D() {
        float rotation = this.w.getRotation();
        if (this.p != rotation) {
            this.p = rotation;
            Z();
        }
    }

    public void E() {
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).b();
            }
        }
    }

    public void F() {
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a();
            }
        }
    }

    public abstract boolean G();

    public void H(ColorStateList colorStateList) {
        l5.g gVar = this.b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
        e5.a aVar = this.d;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    public void I(PorterDuff.Mode mode) {
        l5.g gVar = this.b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    public final void J(float f2) {
        if (this.h != f2) {
            this.h = f2;
            B(f2, this.i, this.j);
        }
    }

    public void K(boolean z) {
        this.f = z;
    }

    public final void L(S4.f fVar) {
        this.o = fVar;
    }

    public final void M(float f2) {
        if (this.i != f2) {
            this.i = f2;
            B(this.h, f2, this.j);
        }
    }

    public final void N(float f2) {
        this.q = f2;
        Matrix matrix = this.B;
        e(f2, matrix);
        this.w.setImageMatrix(matrix);
    }

    public final void O(int i2) {
        if (this.r != i2) {
            this.r = i2;
            a0();
        }
    }

    public void P(int i2) {
        this.k = i2;
    }

    public final void Q(float f2) {
        if (this.j != f2) {
            this.j = f2;
            B(this.h, this.i, f2);
        }
    }

    public void R(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable != null) {
            H.a.o(drawable, j5.b.d(colorStateList));
        }
    }

    public void S(boolean z) {
        this.g = z;
        b0();
    }

    public final void T(l5.k kVar) {
        this.a = kVar;
        l5.g gVar = this.b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        n nVar = this.c;
        if (nVar instanceof n) {
            nVar.setShapeAppearanceModel(kVar);
        }
        e5.a aVar = this.d;
        if (aVar != null) {
            aVar.f(kVar);
        }
    }

    public final void U(S4.f fVar) {
        this.n = fVar;
    }

    public abstract boolean V();

    public final boolean W() {
        return L.W(this.w) && !this.w.isInEditMode();
    }

    public final boolean X() {
        return !this.f || this.w.getSizeDimension() >= this.k;
    }

    public void Y(k kVar, boolean z) {
        if (v()) {
            return;
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = this.n == null;
        if (!W()) {
            this.w.b(0, z);
            this.w.setAlpha(1.0f);
            this.w.setScaleY(1.0f);
            this.w.setScaleX(1.0f);
            N(1.0f);
            if (kVar != null) {
                kVar.a();
                return;
            }
            return;
        }
        if (this.w.getVisibility() != 0) {
            this.w.setAlpha(0.0f);
            this.w.setScaleY(z2 ? 0.4f : 0.0f);
            this.w.setScaleX(z2 ? 0.4f : 0.0f);
            N(z2 ? 0.4f : 0.0f);
        }
        S4.f fVar = this.n;
        AnimatorSet f2 = fVar != null ? f(fVar, 1.0f, 1.0f, 1.0f) : g(1.0f, 1.0f, 1.0f);
        f2.addListener(new b(z, kVar));
        ArrayList arrayList = this.t;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f2.addListener((Animator.AnimatorListener) it.next());
            }
        }
        f2.start();
    }

    public abstract void Z();

    public final void a0() {
        N(this.q);
    }

    public final void b0() {
        Rect rect = this.y;
        o(rect);
        C(rect);
        this.x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void c0(float f2) {
        l5.g gVar = this.b;
        if (gVar != null) {
            gVar.V(f2);
        }
    }

    public final void d0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    public final void e(float f2, Matrix matrix) {
        matrix.reset();
        if (this.w.getDrawable() == null || this.r == 0) {
            return;
        }
        RectF rectF = this.z;
        RectF rectF2 = this.A;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i2 = this.r;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.r;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    public final AnimatorSet f(S4.f fVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.w, View.ALPHA, new float[]{f2});
        fVar.e("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w, View.SCALE_X, new float[]{f3});
        fVar.e("scale").a(ofFloat2);
        d0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w, View.SCALE_Y, new float[]{f3});
        fVar.e("scale").a(ofFloat3);
        d0(ofFloat3);
        arrayList.add(ofFloat3);
        e(f4, this.B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.w, new S4.d(), new c(), new Matrix[]{new Matrix(this.B)});
        fVar.e("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        S4.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet g(float f2, float f3, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new d(this.w.getAlpha(), f2, this.w.getScaleX(), f3, this.w.getScaleY(), this.q, f4, new Matrix(this.B)));
        arrayList.add(ofFloat);
        S4.b.a(animatorSet, arrayList);
        animatorSet.setDuration(g5.a.d(this.w.getContext(), R4.b.y, this.w.getContext().getResources().getInteger(R4.g.b)));
        animatorSet.setInterpolator(g5.a.e(this.w.getContext(), R4.b.z, S4.a.b));
        return animatorSet;
    }

    public final ValueAnimator h(m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    public final Drawable i() {
        return this.e;
    }

    public abstract float j();

    public boolean k() {
        return this.f;
    }

    public final S4.f l() {
        return this.o;
    }

    public float m() {
        return this.i;
    }

    public final ViewTreeObserver.OnPreDrawListener n() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    public void o(Rect rect) {
        int sizeDimension = this.f ? (this.k - this.w.getSizeDimension()) / 2 : 0;
        int max = Math.max(sizeDimension, (int) Math.ceil(this.g ? j() + this.j : 0.0f));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public float p() {
        return this.j;
    }

    public final l5.k q() {
        return this.a;
    }

    public final S4.f r() {
        return this.n;
    }

    public void s(k kVar, boolean z) {
        if (u()) {
            return;
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        if (!W()) {
            this.w.b(z ? 8 : 4, z);
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        S4.f fVar = this.o;
        AnimatorSet f2 = fVar != null ? f(fVar, 0.0f, 0.0f, 0.0f) : g(0.0f, 0.4f, 0.4f);
        f2.addListener(new a(z, kVar));
        ArrayList arrayList = this.u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f2.addListener((Animator.AnimatorListener) it.next());
            }
        }
        f2.start();
    }

    public abstract void t(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2);

    public boolean u() {
        return this.w.getVisibility() == 0 ? this.s == 1 : this.s != 2;
    }

    public boolean v() {
        return this.w.getVisibility() != 0 ? this.s == 2 : this.s != 1;
    }

    public abstract void w();

    public void x() {
        l5.g gVar = this.b;
        if (gVar != null) {
            l5.h.f(this.w, gVar);
        }
        if (G()) {
            this.w.getViewTreeObserver().addOnPreDrawListener(n());
        }
    }

    public abstract void y();

    public void z() {
        ViewTreeObserver viewTreeObserver = this.w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }
}
