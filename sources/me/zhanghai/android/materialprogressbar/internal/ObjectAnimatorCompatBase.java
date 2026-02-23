package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Property;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ObjectAnimatorCompatBase {
    private static final int NUM_POINTS = 201;

    private ObjectAnimatorCompatBase() {
    }

    private static void calculateXYValues(Path path, float[] fArr, float[] fArr2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        float[] fArr3 = new float[2];
        for (int i = 0; i < 201; i++) {
            pathMeasure.getPosTan((i * length) / 200.0f, fArr3, (float[]) null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
        }
    }

    public static ObjectAnimator ofArgb(Object obj, Property property, int... iArr) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(obj, property, iArr);
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    public static ObjectAnimator ofFloat(Object obj, Property property, Property property2, Path path) {
        float[] fArr = new float[201];
        float[] fArr2 = new float[201];
        calculateXYValues(path, fArr, fArr2);
        return ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(property, fArr), PropertyValuesHolder.ofFloat(property2, fArr2)});
    }

    public static ObjectAnimator ofInt(Object obj, Property property, Property property2, Path path) {
        int[] iArr = new int[201];
        int[] iArr2 = new int[201];
        calculateXYValues(path, iArr, iArr2);
        return ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[]{PropertyValuesHolder.ofInt(property, iArr), PropertyValuesHolder.ofInt(property2, iArr2)});
    }

    private static void calculateXYValues(Path path, int[] iArr, int[] iArr2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        float[] fArr = new float[2];
        for (int i = 0; i < 201; i++) {
            pathMeasure.getPosTan((i * length) / 200.0f, fArr, (float[]) null);
            iArr[i] = Math.round(fArr[0]);
            iArr2[i] = Math.round(fArr[1]);
        }
    }

    public static ObjectAnimator ofArgb(Object obj, String str, int... iArr) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(obj, str, iArr);
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    public static ObjectAnimator ofFloat(Object obj, String str, String str2, Path path) {
        float[] fArr = new float[201];
        float[] fArr2 = new float[201];
        calculateXYValues(path, fArr, fArr2);
        return ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(str, fArr), PropertyValuesHolder.ofFloat(str2, fArr2)});
    }

    public static ObjectAnimator ofInt(Object obj, String str, String str2, Path path) {
        int[] iArr = new int[201];
        int[] iArr2 = new int[201];
        calculateXYValues(path, iArr, iArr2);
        return ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[]{PropertyValuesHolder.ofInt(str, iArr), PropertyValuesHolder.ofInt(str2, iArr2)});
    }
}
