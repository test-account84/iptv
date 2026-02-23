package com.google.android.material.transformation;

import P.L;
import S4.c;
import S4.f;
import S4.g;
import S4.h;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;
    public final RectF d;
    public final RectF e;
    public final int[] f;
    public float g;
    public float h;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;

        public a(boolean z, View view, View view2) {
            this.a = z;
            this.c = view;
            this.d = view2;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.c.setVisibility(4);
            this.d.setAlpha(1.0f);
            this.d.setVisibility(0);
        }

        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.c.setVisibility(0);
                this.d.setAlpha(0.0f);
                this.d.setVisibility(4);
            }
        }
    }

    public static class b {
        public f a;
        public h b;
    }

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    public AnimatorSet J(View view, View view2, boolean z, boolean z2) {
        b Z = Z(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        V(view, view2, z, z2, Z, arrayList, arrayList2);
        RectF rectF = this.d;
        Y(view, view2, z, z2, Z, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        U(view, view2, z, Z, arrayList);
        X(view, view2, z, z2, Z, arrayList, arrayList2);
        W(view, view2, z, z2, Z, width, height, arrayList, arrayList2);
        T(view, view2, z, z2, Z, arrayList, arrayList2);
        S(view, view2, z, z2, Z, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        S4.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    public final ViewGroup K(View view) {
        View findViewById = view.findViewById(R4.f.A);
        return findViewById != null ? a0(findViewById) : a0(view);
    }

    public final void L(View view, b bVar, g gVar, g gVar2, float f, float f2, float f3, float f4, RectF rectF) {
        float Q = Q(bVar, gVar, f, f3);
        float Q2 = Q(bVar, gVar2, f2, f4);
        Rect rect = this.c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.d;
        rectF2.set(rect);
        RectF rectF3 = this.e;
        R(view, rectF3);
        rectF3.offset(Q, Q2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final void M(View view, RectF rectF) {
        R(view, rectF);
        rectF.offset(this.g, this.h);
    }

    public final Pair N(float f, float f2, boolean z, b bVar) {
        g e;
        f fVar;
        String str;
        if (f == 0.0f || f2 == 0.0f) {
            e = bVar.a.e("translationXLinear");
            fVar = bVar.a;
            str = "translationYLinear";
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            e = bVar.a.e("translationXCurveDownwards");
            fVar = bVar.a;
            str = "translationYCurveDownwards";
        } else {
            e = bVar.a.e("translationXCurveUpwards");
            fVar = bVar.a;
            str = "translationYCurveUpwards";
        }
        return new Pair(e, fVar.e(str));
    }

    public final float O(View view, View view2, h hVar) {
        float centerX;
        float centerX2;
        float f;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        M(view, rectF);
        R(view2, rectF2);
        int i = hVar.a & 7;
        if (i == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else {
            if (i != 5) {
                f = 0.0f;
                return f + hVar.b;
            }
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f = centerX - centerX2;
        return f + hVar.b;
    }

    public final float P(View view, View view2, h hVar) {
        float centerY;
        float centerY2;
        float f;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        M(view, rectF);
        R(view2, rectF2);
        int i = hVar.a & 112;
        if (i == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else {
            if (i != 80) {
                f = 0.0f;
                return f + hVar.c;
            }
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f = centerY - centerY2;
        return f + hVar.c;
    }

    public final float Q(b bVar, g gVar, float f, float f2) {
        long c = gVar.c();
        long d = gVar.d();
        g e = bVar.a.e("expansion");
        return S4.a.a(f, f2, gVar.e().getInterpolation((((e.c() + e.d()) + 17) - c) / d));
    }

    public final void R(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void S(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2) {
        ViewGroup K;
        ObjectAnimator ofFloat;
        if ((view2 instanceof ViewGroup) && (K = K(view2)) != null) {
            if (z) {
                if (!z2) {
                    c.a.set(K, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(K, c.a, new float[]{1.0f});
            } else {
                ofFloat = ObjectAnimator.ofFloat(K, c.a, new float[]{0.0f});
            }
            bVar.a.e("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    public final void T(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2) {
    }

    public final void U(View view, View view2, boolean z, b bVar, List list) {
        float O = O(view, view2, bVar.b);
        float P = P(view, view2, bVar.b);
        Pair N = N(O, P, z, bVar);
        g gVar = (g) N.first;
        g gVar2 = (g) N.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            O = this.g;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, new float[]{O});
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            P = this.h;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, new float[]{P});
        gVar.a(ofFloat);
        gVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public final void V(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2) {
        ObjectAnimator ofFloat;
        float y = L.y(view2) - L.y(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-y);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-y});
        }
        bVar.a.e("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    public final void W(View view, View view2, boolean z, boolean z2, b bVar, float f, float f2, List list, List list2) {
    }

    public final void X(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2) {
    }

    public final void Y(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float O = O(view, view2, bVar.b);
        float P = P(view, view2, bVar.b);
        Pair N = N(O, P, z, bVar);
        g gVar = (g) N.first;
        g gVar2 = (g) N.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-O);
                view2.setTranslationY(-P);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{0.0f});
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f});
            L(view2, bVar, gVar, gVar2, -O, -P, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{-O});
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{-P});
        }
        gVar.a(ofFloat);
        gVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public abstract b Z(Context context, boolean z);

    public final ViewGroup a0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    public void g(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }
}
