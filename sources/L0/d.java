package L0;

import F.k;
import G.e;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d {

    public static class a implements TypeEvaluator {
        public e.b[] a;

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.b[] evaluate(float f, e.b[] bVarArr, e.b[] bVarArr2) {
            if (!G.e.b(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!G.e.b(this.a, bVarArr)) {
                this.a = G.e.f(bVarArr);
            }
            for (int i = 0; i < bVarArr.length; i++) {
                this.a[i].d(bVarArr[i], bVarArr2[i], f);
            }
            return this.a;
        }
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.animation.Animator b(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.d.b(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static Keyframe c(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    public static void d(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    public static PropertyValuesHolder e(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder ofFloat;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i5 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((z && h(i4)) || (z2 && h(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i != 2) {
            e a2 = i == 3 ? e.a() : null;
            if (z3) {
                if (z) {
                    float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                    if (z2) {
                        ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f)});
                    } else {
                        ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension});
                    }
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f)});
                }
                propertyValuesHolder = ofFloat;
            } else if (z) {
                int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : h(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
                if (z2) {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : h(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0)});
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{dimension2});
                }
            } else if (z2) {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : h(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0)});
            }
            if (propertyValuesHolder == null || a2 == null) {
                return propertyValuesHolder;
            }
            propertyValuesHolder.setEvaluator(a2);
            return propertyValuesHolder;
        }
        String string = typedArray.getString(i2);
        String string2 = typedArray.getString(i3);
        e.b[] d = G.e.d(string);
        e.b[] d2 = G.e.d(string2);
        if (d == null && d2 == null) {
            return null;
        }
        if (d == null) {
            if (d2 != null) {
                return PropertyValuesHolder.ofObject(str, new a(), new Object[]{d2});
            }
            return null;
        }
        a aVar = new a();
        if (d2 == null) {
            ofObject = PropertyValuesHolder.ofObject(str, aVar, new Object[]{d});
        } else {
            if (!G.e.b(d, d2)) {
                throw new InflateException(" Can't morph from " + string + " to " + string2);
            }
            ofObject = PropertyValuesHolder.ofObject(str, aVar, new Object[]{d, d2});
        }
        return ofObject;
    }

    public static int f(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = peekValue != null;
        int i3 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        boolean z2 = peekValue2 != null;
        return ((z && h(i3)) || (z2 && h(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    public static int g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray s = k.s(resources, theme, attributeSet, L0.a.j);
        int i = 0;
        TypedValue t = k.t(s, xmlPullParser, "value", 0);
        if (t != null && h(t.type)) {
            i = 3;
        }
        s.recycle();
        return i;
    }

    public static boolean h(int i) {
        return i >= 28 && i <= 31;
    }

    public static Animator i(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : j(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i) {
        return k(context, resources, theme, i, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i, float f) {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i);
                    return a(context, resources, theme, xmlResourceParser, f);
                } catch (IOException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray s = k.s(resources, theme, attributeSet, L0.a.g);
        TypedArray s2 = k.s(resources, theme, attributeSet, L0.a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        q(valueAnimator, s, s2, f, xmlPullParser);
        int l = k.l(s, xmlPullParser, "interpolator", 0, 0);
        if (l > 0) {
            valueAnimator.setInterpolator(c.a(context, l));
        }
        s.recycle();
        if (s2 != null) {
            s2.recycle();
        }
        return valueAnimator;
    }

    public static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        TypedArray s = k.s(resources, theme, attributeSet, L0.a.j);
        float j = k.j(s, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue t = k.t(s, xmlPullParser, "value", 0);
        boolean z = t != null;
        if (i == 4) {
            i = (z && h(t.type)) ? 3 : 0;
        }
        Keyframe ofInt = z ? i != 0 ? (i == 1 || i == 3) ? Keyframe.ofInt(j, k.k(s, xmlPullParser, "value", 0, 0)) : null : Keyframe.ofFloat(j, k.j(s, xmlPullParser, "value", 0, 0.0f)) : i == 0 ? Keyframe.ofFloat(j) : Keyframe.ofInt(j);
        int l = k.l(s, xmlPullParser, "interpolator", 1, 0);
        if (l > 0) {
            ofInt.setInterpolator(c.a(context, l));
        }
        s.recycle();
        return ofInt;
    }

    public static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        l(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    public static PropertyValuesHolder o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i == 4) {
                    i = g(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe m = m(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i, xmlPullParser);
                if (m != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(m);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), c(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, c(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            d(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i == 3) {
                propertyValuesHolder.setEvaluator(e.a());
            }
        }
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder[] p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType == 2 && xmlPullParser.getName().equals("propertyValuesHolder")) {
                TypedArray s = k.s(resources, theme, attributeSet, L0.a.i);
                String m = k.m(s, xmlPullParser, "propertyName", 3);
                int k = k.k(s, xmlPullParser, "valueType", 2, 4);
                PropertyValuesHolder o = o(context, resources, theme, xmlPullParser, m, k);
                if (o == null) {
                    o = e(s, k, 0, 1, m);
                }
                if (o != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(o);
                }
                s.recycle();
            }
            xmlPullParser.next();
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    public static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long k = k.k(typedArray, xmlPullParser, "duration", 1, 300);
        long k2 = k.k(typedArray, xmlPullParser, "startOffset", 2, 0);
        int k3 = k.k(typedArray, xmlPullParser, "valueType", 7, 4);
        if (k.r(xmlPullParser, "valueFrom") && k.r(xmlPullParser, "valueTo")) {
            if (k3 == 4) {
                k3 = f(typedArray, 5, 6);
            }
            PropertyValuesHolder e = e(typedArray, k3, 5, 6, "");
            if (e != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{e});
            }
        }
        valueAnimator.setDuration(k);
        valueAnimator.setStartDelay(k2);
        valueAnimator.setRepeatCount(k.k(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(k.k(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            r(valueAnimator, typedArray2, k3, f, xmlPullParser);
        }
    }

    public static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String m = k.m(typedArray, xmlPullParser, "pathData", 1);
        if (m == null) {
            objectAnimator.setPropertyName(k.m(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String m2 = k.m(typedArray, xmlPullParser, "propertyXName", 2);
        String m3 = k.m(typedArray, xmlPullParser, "propertyYName", 3);
        if (i != 2) {
        }
        if (m2 != null || m3 != null) {
            s(G.e.e(m), objectAnimator, f * 0.5f, m2, m3);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    public static void s(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        int i = 1;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f2 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f3 = 0.0f;
        do {
            f3 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f3 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f4 = f3 / (min - 1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f2 - ((Float) arrayList.get(i3)).floatValue(), fArr3, (float[]) null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f2 += f4;
            int i4 = i3 + 1;
            if (i4 < arrayList.size() && f2 > ((Float) arrayList.get(i4)).floatValue()) {
                pathMeasure2.nextContour();
                i3 = i4;
            }
            i = 1;
            i2++;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[i];
            propertyValuesHolderArr[0] = ofFloat2;
            objectAnimator.setValues(propertyValuesHolderArr);
        } else if (ofFloat2 == null) {
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[i];
            propertyValuesHolderArr2[0] = ofFloat;
            objectAnimator.setValues(propertyValuesHolderArr2);
        } else {
            PropertyValuesHolder[] propertyValuesHolderArr3 = new PropertyValuesHolder[2];
            propertyValuesHolderArr3[0] = ofFloat;
            propertyValuesHolderArr3[i] = ofFloat2;
            objectAnimator.setValues(propertyValuesHolderArr3);
        }
    }
}
