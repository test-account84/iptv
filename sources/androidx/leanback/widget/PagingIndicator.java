package androidx.leanback.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PagingIndicator extends View {
    public static final TimeInterpolator B = new DecelerateInterpolator();
    public static final Property C = new a(Float.class, "alpha");
    public static final Property D = new b(Float.class, "diameter");
    public static final Property E = new c(Float.class, "translation_x");
    public final float A;
    public boolean a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public d[] j;
    public int[] k;
    public int[] l;
    public int[] m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public final Paint s;
    public final Paint t;
    public final AnimatorSet u;
    public final AnimatorSet v;
    public final AnimatorSet w;
    public Bitmap x;
    public Paint y;
    public final Rect z;

    public static class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.d());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f) {
            dVar.i(f.floatValue());
        }
    }

    public static class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.e());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f) {
            dVar.j(f.floatValue());
        }
    }

    public static class c extends Property {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.f());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f) {
            dVar.k(f.floatValue());
        }
    }

    public class d {
        public float a;
        public int b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h = 1.0f;
        public float i;

        public d() {
            this.i = PagingIndicator.this.a ? 1.0f : -1.0f;
        }

        public void a() {
            this.b = Color.argb(Math.round(this.a * 255.0f), Color.red(PagingIndicator.this.r), Color.green(PagingIndicator.this.r), Color.blue(PagingIndicator.this.r));
        }

        public void b() {
            this.c = 0.0f;
            this.d = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.e = pagingIndicator.c;
            float f = pagingIndicator.d;
            this.f = f;
            this.g = f * pagingIndicator.A;
            this.a = 0.0f;
            a();
        }

        public void c(Canvas canvas) {
            float f = this.d + this.c;
            canvas.drawCircle(f, r1.n, this.f, PagingIndicator.this.s);
            if (this.a > 0.0f) {
                PagingIndicator.this.t.setColor(this.b);
                canvas.drawCircle(f, r1.n, this.f, PagingIndicator.this.t);
                PagingIndicator pagingIndicator = PagingIndicator.this;
                Bitmap bitmap = pagingIndicator.x;
                Rect rect = pagingIndicator.z;
                float f2 = this.g;
                int i = PagingIndicator.this.n;
                canvas.drawBitmap(bitmap, rect, new Rect((int) (f - f2), (int) (i - f2), (int) (f + f2), (int) (i + f2)), PagingIndicator.this.y);
            }
        }

        public float d() {
            return this.a;
        }

        public float e() {
            return this.e;
        }

        public float f() {
            return this.c;
        }

        public void g() {
            this.i = PagingIndicator.this.a ? 1.0f : -1.0f;
        }

        public void h() {
            this.c = 0.0f;
            this.d = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.e = pagingIndicator.f;
            float f = pagingIndicator.g;
            this.f = f;
            this.g = f * pagingIndicator.A;
            this.a = 1.0f;
            a();
        }

        public void i(float f) {
            this.a = f;
            a();
            PagingIndicator.this.invalidate();
        }

        public void j(float f) {
            this.e = f;
            float f2 = f / 2.0f;
            this.f = f2;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.g = f2 * pagingIndicator.A;
            pagingIndicator.invalidate();
        }

        public void k(float f) {
            this.c = f * this.h * this.i;
            PagingIndicator.this.invalidate();
        }
    }

    public PagingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getDesiredHeight() {
        return getPaddingTop() + this.f + getPaddingBottom() + this.i;
    }

    private int getDesiredWidth() {
        return getPaddingLeft() + getRequiredWidth() + getPaddingRight();
    }

    private int getRequiredWidth() {
        return (this.d * 2) + (this.h * 2) + ((this.o - 3) * this.e);
    }

    private void setSelectedPage(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        a();
    }

    public final void a() {
        int i;
        int i2 = 0;
        while (true) {
            i = this.p;
            if (i2 >= i) {
                break;
            }
            this.j[i2].b();
            d dVar = this.j[i2];
            if (i2 != this.q) {
                r2 = 1.0f;
            }
            dVar.h = r2;
            dVar.d = this.l[i2];
            i2++;
        }
        this.j[i].h();
        d[] dVarArr = this.j;
        int i3 = this.p;
        d dVar2 = dVarArr[i3];
        dVar2.h = this.q >= i3 ? 1.0f : -1.0f;
        int i4 = this.k[i3];
        while (true) {
            dVar2.d = i4;
            i3++;
            if (i3 >= this.o) {
                return;
            }
            this.j[i3].b();
            dVar2 = this.j[i3];
            dVar2.h = 1.0f;
            i4 = this.m[i3];
        }
    }

    public final void b() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int requiredWidth = getRequiredWidth();
        int i = (paddingLeft + width) / 2;
        int i2 = this.o;
        int[] iArr = new int[i2];
        this.k = iArr;
        int[] iArr2 = new int[i2];
        this.l = iArr2;
        int[] iArr3 = new int[i2];
        this.m = iArr3;
        int i3 = 1;
        int i4 = requiredWidth / 2;
        if (this.a) {
            int i5 = i - i4;
            int i6 = this.d;
            int i7 = this.e;
            int i8 = this.h;
            iArr[0] = ((i5 + i6) - i7) + i8;
            iArr2[0] = i5 + i6;
            iArr3[0] = ((i5 + i6) - (i7 * 2)) + (i8 * 2);
            while (i3 < this.o) {
                int[] iArr4 = this.k;
                int[] iArr5 = this.l;
                int i9 = i3 - 1;
                int i10 = iArr5[i9];
                int i11 = this.h;
                iArr4[i3] = i10 + i11;
                iArr5[i3] = iArr5[i9] + this.e;
                this.m[i3] = iArr4[i9] + i11;
                i3++;
            }
        } else {
            int i12 = i + i4;
            int i13 = this.d;
            int i14 = this.e;
            int i15 = this.h;
            iArr[0] = ((i12 - i13) + i14) - i15;
            iArr2[0] = i12 - i13;
            iArr3[0] = ((i12 - i13) + (i14 * 2)) - (i15 * 2);
            while (i3 < this.o) {
                int[] iArr6 = this.k;
                int[] iArr7 = this.l;
                int i16 = i3 - 1;
                int i17 = iArr7[i16];
                int i18 = this.h;
                iArr6[i3] = i17 - i18;
                iArr7[i3] = iArr7[i16] - this.e;
                this.m[i3] = iArr6[i16] - i18;
                i3++;
            }
        }
        this.n = paddingTop + this.g;
        a();
    }

    public final Animator c(float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, C, new float[]{f, f2});
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(B);
        return ofFloat;
    }

    public final Animator d(float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, D, new float[]{f, f2});
        ofFloat.setDuration(417L);
        ofFloat.setInterpolator(B);
        return ofFloat;
    }

    public final Animator e() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, E, new float[]{(-this.h) + this.e, 0.0f});
        ofFloat.setDuration(417L);
        ofFloat.setInterpolator(B);
        return ofFloat;
    }

    public final int f(TypedArray typedArray, int i, int i2) {
        return typedArray.getColor(i, getResources().getColor(i2));
    }

    public final int g(TypedArray typedArray, int i, int i2) {
        return typedArray.getDimensionPixelOffset(i, getResources().getDimensionPixelOffset(i2));
    }

    public int[] getDotSelectedLeftX() {
        return this.l;
    }

    public int[] getDotSelectedRightX() {
        return this.m;
    }

    public int[] getDotSelectedX() {
        return this.k;
    }

    public int getPageCount() {
        return this.o;
    }

    public final Bitmap h() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), g0.d.b);
        if (this.a) {
            return decodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, false);
    }

    public void onDraw(Canvas canvas) {
        for (int i = 0; i < this.o; i++) {
            this.j[i].c(canvas);
        }
    }

    public void onMeasure(int i, int i2) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i2));
        } else if (mode == 1073741824) {
            desiredHeight = View.MeasureSpec.getSize(i2);
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode2 == Integer.MIN_VALUE) {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i));
        } else if (mode2 == 1073741824) {
            desiredWidth = View.MeasureSpec.getSize(i);
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 0;
        if (this.a != z) {
            this.a = z;
            this.x = h();
            d[] dVarArr = this.j;
            if (dVarArr != null) {
                for (d dVar : dVarArr) {
                    dVar.g();
                }
            }
            b();
            invalidate();
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        setMeasuredDimension(i, i2);
        b();
    }

    public void setArrowBackgroundColor(int i) {
        this.r = i;
    }

    public void setArrowColor(int i) {
        if (this.y == null) {
            this.y = new Paint();
        }
        this.y.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
    }

    public void setDotBackgroundColor(int i) {
        this.s.setColor(i);
    }

    public void setPageCount(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The page count should be a positive integer");
        }
        this.o = i;
        this.j = new d[i];
        for (int i2 = 0; i2 < this.o; i2++) {
            this.j[i2] = new d();
        }
        b();
        setSelectedPage(0);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AnimatorSet animatorSet = new AnimatorSet();
        this.w = animatorSet;
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0.l.p, i, 0);
        int g = g(obtainStyledAttributes, g0.l.w, g0.c.k);
        this.d = g;
        this.c = g * 2;
        int g2 = g(obtainStyledAttributes, g0.l.s, g0.c.g);
        this.g = g2;
        int i2 = g2 * 2;
        this.f = i2;
        this.e = g(obtainStyledAttributes, g0.l.v, g0.c.j);
        this.h = g(obtainStyledAttributes, g0.l.u, g0.c.f);
        int f = f(obtainStyledAttributes, g0.l.t, g0.b.d);
        Paint paint = new Paint(1);
        this.s = paint;
        paint.setColor(f);
        this.r = f(obtainStyledAttributes, g0.l.q, g0.b.b);
        if (this.y == null && obtainStyledAttributes.hasValue(g0.l.r)) {
            setArrowColor(obtainStyledAttributes.getColor(g0.l.r, 0));
        }
        obtainStyledAttributes.recycle();
        this.a = resources.getConfiguration().getLayoutDirection() == 0;
        int color = resources.getColor(g0.b.c);
        int dimensionPixelSize = resources.getDimensionPixelSize(g0.c.i);
        this.i = dimensionPixelSize;
        Paint paint2 = new Paint(1);
        this.t = paint2;
        float dimensionPixelSize2 = resources.getDimensionPixelSize(g0.c.h);
        paint2.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, color);
        this.x = h();
        this.z = new Rect(0, 0, this.x.getWidth(), this.x.getHeight());
        this.A = this.x.getWidth() / i2;
        Animator animatorSet2 = new AnimatorSet();
        this.u = animatorSet2;
        animatorSet2.playTogether(new Animator[]{c(0.0f, 1.0f), d(g * 2, g2 * 2), e()});
        Animator animatorSet3 = new AnimatorSet();
        this.v = animatorSet3;
        animatorSet3.playTogether(new Animator[]{c(1.0f, 0.0f), d(g2 * 2, g * 2), e()});
        animatorSet.playTogether(new Animator[]{animatorSet2, animatorSet3});
        setLayerType(1, (Paint) null);
    }
}
