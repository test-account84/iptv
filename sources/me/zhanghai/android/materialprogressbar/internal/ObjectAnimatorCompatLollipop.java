package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.util.Property;

@TargetApi(21)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ObjectAnimatorCompatLollipop {
    private ObjectAnimatorCompatLollipop() {
    }

    public static ObjectAnimator ofArgb(Object obj, Property property, int... iArr) {
        return ObjectAnimator.ofArgb(obj, property, iArr);
    }

    public static ObjectAnimator ofFloat(Object obj, Property property, Property property2, Path path) {
        return ObjectAnimator.ofFloat(obj, property, property2, path);
    }

    public static ObjectAnimator ofInt(Object obj, Property property, Property property2, Path path) {
        return ObjectAnimator.ofInt(obj, property, property2, path);
    }

    public static ObjectAnimator ofArgb(Object obj, String str, int... iArr) {
        return ObjectAnimator.ofArgb(obj, str, iArr);
    }

    public static ObjectAnimator ofFloat(Object obj, String str, String str2, Path path) {
        return ObjectAnimator.ofFloat(obj, str, str2, path);
    }

    public static ObjectAnimator ofInt(Object obj, String str, String str2, Path path) {
        return ObjectAnimator.ofInt(obj, str, str2, path);
    }
}
