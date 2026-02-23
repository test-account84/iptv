package androidx.leanback.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MediaNowPlayingView extends LinearLayout {
    public final ImageView a;
    public final ImageView c;
    public final ImageView d;
    public final ObjectAnimator e;
    public final ObjectAnimator f;
    public final ObjectAnimator g;
    public final LinearInterpolator h;

    public MediaNowPlayingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.h = linearInterpolator;
        LayoutInflater.from(context).inflate(g0.h.f, this, true);
        ImageView findViewById = findViewById(g0.f.a);
        this.a = findViewById;
        ImageView findViewById2 = findViewById(g0.f.b);
        this.c = findViewById2;
        ImageView findViewById3 = findViewById(g0.f.c);
        this.d = findViewById3;
        findViewById.setPivotY(findViewById.getDrawable().getIntrinsicHeight());
        findViewById2.setPivotY(findViewById2.getDrawable().getIntrinsicHeight());
        findViewById3.setPivotY(findViewById3.getDrawable().getIntrinsicHeight());
        setDropScale(findViewById);
        setDropScale(findViewById2);
        setDropScale(findViewById3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, "scaleY", new float[]{0.41666666f, 0.25f, 0.41666666f, 0.5833333f, 0.75f, 0.8333333f, 0.9166667f, 1.0f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.5f, 0.33333334f, 0.16666667f, 0.33333334f, 0.5f, 0.5833333f, 0.75f, 0.9166667f, 0.75f, 0.5833333f, 0.41666666f, 0.25f, 0.41666666f, 0.6666667f, 0.41666666f, 0.25f, 0.33333334f, 0.41666666f});
        this.e = ofFloat;
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(2320L);
        ofFloat.setInterpolator(linearInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findViewById2, "scaleY", new float[]{1.0f, 0.9166667f, 0.8333333f, 0.9166667f, 1.0f, 0.9166667f, 0.75f, 0.5833333f, 0.75f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.8333333f, 1.0f, 0.9166667f, 0.75f, 0.41666666f, 0.25f, 0.41666666f, 0.6666667f, 0.8333333f, 1.0f, 0.8333333f, 0.75f, 0.6666667f, 1.0f});
        this.f = ofFloat2;
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setDuration(2080L);
        ofFloat2.setInterpolator(linearInterpolator);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(findViewById3, "scaleY", new float[]{0.6666667f, 0.75f, 0.8333333f, 1.0f, 0.9166667f, 0.75f, 0.5833333f, 0.41666666f, 0.5833333f, 0.6666667f, 0.75f, 1.0f, 0.9166667f, 1.0f, 0.75f, 0.5833333f, 0.75f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.75f, 0.5833333f, 0.41666666f, 0.25f, 0.6666667f});
        this.g = ofFloat3;
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setDuration(2000L);
        ofFloat3.setInterpolator(linearInterpolator);
    }

    public static void setDropScale(View view) {
        view.setScaleY(0.083333336f);
    }

    public final void a() {
        b(this.e);
        b(this.f);
        b(this.g);
        this.a.setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
    }

    public final void b(Animator animator) {
        if (animator.isStarted()) {
            return;
        }
        animator.start();
    }

    public final void c() {
        d(this.e, this.a);
        d(this.f, this.c);
        d(this.g, this.d);
        this.a.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    public final void d(Animator animator, View view) {
        if (animator.isStarted()) {
            animator.cancel();
            setDropScale(view);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            a();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8) {
            c();
        } else {
            a();
        }
    }
}
