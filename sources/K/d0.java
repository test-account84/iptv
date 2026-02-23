package k;

import F.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d0 {
    public final Context a;
    public final TypedArray b;
    public TypedValue c;

    public d0(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public static d0 t(Context context, int i, int[] iArr) {
        return new d0(context, context.obtainStyledAttributes(i, iArr));
    }

    public static d0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new d0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static d0 v(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new d0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList a;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0 || (a = e.a.a(this.a, resourceId)) == null) ? this.b.getColorStateList(i) : a;
    }

    public float d(int i, float f) {
        return this.b.getDimension(i, f);
    }

    public int e(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) ? this.b.getDrawable(i) : e.a.b(this.a, resourceId);
    }

    public Drawable h(int i) {
        int resourceId;
        if (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return i.b().d(this.a, resourceId, true);
    }

    public float i(int i, float f) {
        return this.b.getFloat(i, f);
    }

    public Typeface j(int i, int i2, h.e eVar) {
        int resourceId = this.b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return F.h.i(this.a, resourceId, this.c, i2, eVar);
    }

    public int k(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public int l(int i, int i2) {
        return this.b.getInteger(i, i2);
    }

    public int m(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public int n(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    public String o(int i) {
        return this.b.getString(i);
    }

    public CharSequence p(int i) {
        return this.b.getText(i);
    }

    public CharSequence[] q(int i) {
        return this.b.getTextArray(i);
    }

    public TypedArray r() {
        return this.b;
    }

    public boolean s(int i) {
        return this.b.hasValue(i);
    }

    public void w() {
        this.b.recycle();
    }
}
