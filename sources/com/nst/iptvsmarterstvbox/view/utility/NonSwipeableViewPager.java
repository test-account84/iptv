package com.nst.iptvsmarterstvbox.view.utility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NonSwipeableViewPager extends ViewPager {

    public class a extends Scroller {
        public a(Context context) {
            super(context, new DecelerateInterpolator());
        }

        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, 350);
        }
    }

    public NonSwipeableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        R();
    }

    public final void R() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("k");
            declaredField.setAccessible(true);
            declaredField.set(this, new a(getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean o(KeyEvent keyEvent) {
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
