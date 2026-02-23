package mbanje.kurt.fabbutton;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a {

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ View c;

        public a(g gVar, View view) {
            this.a = gVar;
            this.c = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(-1.0f, -1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue(), -1.0f);
            this.c.invalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ View c;

        public b(g gVar, View view) {
            this.a = gVar;
            this.c = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(-1.0f, -1.0f, -1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.c.invalidate();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ View c;

        public c(g gVar, View view) {
            this.a = gVar;
            this.c = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), -1.0f, -1.0f, -1.0f);
            this.c.invalidate();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ g a;

        public d(g gVar) {
            this.a = gVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(-1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue(), -1.0f, -1.0f);
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float a;
        public final /* synthetic */ g c;
        public final /* synthetic */ View d;

        public e(float f, g gVar, View view) {
            this.a = f;
            this.c = gVar;
            this.d = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.c.a((285.0f - floatValue) + this.a, -1.0f, floatValue, -1.0f);
            this.d.invalidate();
        }
    }

    public class f implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ g a;

        public f(g gVar) {
            this.a = gVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(-1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue(), -1.0f, -1.0f);
        }
    }

    public interface g {
        void a(float f, float f2, float f3, float f4);
    }

    public static AnimatorSet a(View view, float f2, int i, g gVar) {
        float f3 = (270.0f * f2) - 90.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{15.0f, 285.0f});
        long j = (i / 4) / 2;
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.0f));
        ofFloat.addUpdateListener(new c(gVar, view));
        float f4 = ((f2 + 0.5f) * 720.0f) / 4.0f;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(f2 * 720.0f) / 4.0f, f4});
        ofFloat2.setDuration(j);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new d(gVar));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{f3, (285.0f + f3) - 15.0f});
        ofFloat3.setDuration(j);
        ofFloat3.setInterpolator(new DecelerateInterpolator(1.0f));
        ofFloat3.addUpdateListener(new e(f3, gVar, view));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{f4, ((f2 + 1.0f) * 720.0f) / 4.0f});
        ofFloat4.setDuration(j);
        ofFloat4.setInterpolator(new LinearInterpolator());
        ofFloat4.addUpdateListener(new f(gVar));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat3).with(ofFloat4).after(ofFloat2);
        return animatorSet;
    }

    public static ValueAnimator b(View view, float f2, float f3, g gVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, f3});
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new b(gVar, view));
        return ofFloat;
    }

    public static ValueAnimator c(View view, float f2, float f3, g gVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, f3});
        ofFloat.setDuration(5000L);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat.addUpdateListener(new a(gVar, view));
        return ofFloat;
    }
}
