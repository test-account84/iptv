package com.nst.iptvsmarterstvbox.view.utility;

import a7.e;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LoadingGearSpinner extends ImageView {
    public static final int a = e.d0;

    public LoadingGearSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        clearAnimation();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(-1);
        startAnimation(rotateAnimation);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        setImageResource(a);
        a();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            a();
        } else {
            clearAnimation();
        }
        super.setVisibility(i);
    }
}
