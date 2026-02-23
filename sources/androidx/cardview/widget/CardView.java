package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import q.d;
import r.b;
import r.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CardView extends FrameLayout {
    public static final int[] i = {16842801};
    public static final c j;
    public boolean a;
    public boolean c;
    public int d;
    public int e;
    public final Rect f;
    public final Rect g;
    public final b h;

    public class a implements b {
        public Drawable a;

        public a() {
        }

        public void a(int i, int i2, int i3, int i4) {
            CardView.this.g.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.f;
            CardView.a(cardView, i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }

        public void b(Drawable drawable) {
            this.a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public boolean c() {
            return CardView.this.getUseCompatPadding();
        }

        public Drawable d() {
            return this.a;
        }

        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        public View f() {
            return CardView.this;
        }
    }

    static {
        r.a aVar = new r.a();
        j = aVar;
        aVar.l();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(CardView cardView, int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
    }

    public ColorStateList getCardBackgroundColor() {
        return j.g(this.h);
    }

    public float getCardElevation() {
        return j.h(this.h);
    }

    public int getContentPaddingBottom() {
        return this.f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f.left;
    }

    public int getContentPaddingRight() {
        return this.f.right;
    }

    public int getContentPaddingTop() {
        return this.f.top;
    }

    public float getMaxCardElevation() {
        return j.i(this.h);
    }

    public boolean getPreventCornerOverlap() {
        return this.c;
    }

    public float getRadius() {
        return j.k(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.a;
    }

    public void onMeasure(int i2, int i3) {
        if (!(j instanceof r.a)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.j(this.h)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.b(this.h)), View.MeasureSpec.getSize(i3)), mode2);
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        j.n(this.h, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f) {
        j.c(this.h, f);
    }

    public void setMaxCardElevation(float f) {
        j.m(this.h, f);
    }

    public void setMinimumHeight(int i2) {
        this.e = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.d = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.c) {
            this.c = z;
            j.d(this.h);
        }
    }

    public void setRadius(float f) {
        j.f(this.h, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.a != z) {
            this.a = z;
            j.e(this.h);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, q.a.a);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        j.n(this.h, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        Resources resources;
        int i3;
        ColorStateList valueOf;
        super(context, attributeSet, i2);
        Rect rect = new Rect();
        this.f = rect;
        this.g = new Rect();
        a aVar = new a();
        this.h = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a, i2, q.c.a);
        if (obtainStyledAttributes.hasValue(d.d)) {
            valueOf = obtainStyledAttributes.getColorStateList(d.d);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(i);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i3 = q.b.b;
            } else {
                resources = getResources();
                i3 = q.b.a;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i3));
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(d.e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.g, 0.0f);
        this.a = obtainStyledAttributes.getBoolean(d.i, false);
        this.c = obtainStyledAttributes.getBoolean(d.h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(d.l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(d.n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(d.m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(d.k, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.d = obtainStyledAttributes.getDimensionPixelSize(d.b, 0);
        this.e = obtainStyledAttributes.getDimensionPixelSize(d.c, 0);
        obtainStyledAttributes.recycle();
        j.a(aVar, context, colorStateList, dimension, dimension2, f);
    }
}
