package com.amazonaws.mobile.auth.core.signin.ui;

import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.DisplayMetrics;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DisplayUtils {
    private static int dpMultiplier;
    private static final DisplayMetrics metrics;

    static {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        metrics = displayMetrics;
        dpMultiplier = displayMetrics.densityDpi / 160;
    }

    public static int dp(int i) {
        return i * dpMultiplier;
    }

    public static ShapeDrawable getRoundedRectangleBackground(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(getRoundedRectangleShape(i));
        shapeDrawable.getPaint().setColor(i2);
        return shapeDrawable;
    }

    public static Shape getRoundedRectangleShape(int i) {
        float f = i;
        return new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, (RectF) null, (float[]) null);
    }
}
