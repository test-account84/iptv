package K0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends N {

    public class a extends m {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        public void c(l lVar) {
            A.g(this.a, 1.0f);
            A.a(this.a);
            lVar.Q(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {
        public final View a;
        public boolean c = false;

        public b(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            A.g(this.a, 1.0f);
            if (this.c) {
                this.a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (P.L.S(this.a) && this.a.getLayerType() == 0) {
                this.c = true;
                this.a.setLayerType(2, (Paint) null);
            }
        }
    }

    public d() {
    }

    public static float l0(s sVar, float f) {
        Float f2;
        return (sVar == null || (f2 = (Float) sVar.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    public Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float l0 = l0(sVar, 0.0f);
        return k0(view, l0 != 1.0f ? l0 : 0.0f, 1.0f);
    }

    public Animator i0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        A.e(view);
        return k0(view, l0(sVar, 1.0f), 0.0f);
    }

    public void j(s sVar) {
        super.j(sVar);
        sVar.a.put("android:fade:transitionAlpha", Float.valueOf(A.c(sVar.b)));
    }

    public final Animator k0(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        A.g(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, A.b, new float[]{f2});
        ofFloat.addListener(new b(view));
        b(new a(view));
        return ofFloat;
    }

    public d(int i) {
        j0(i);
    }
}
