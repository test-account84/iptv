package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class HorizontalGridView extends b {
    public boolean T0;
    public boolean U0;
    public Paint V0;
    public Bitmap W0;
    public LinearGradient X0;
    public int Y0;
    public int Z0;
    public Bitmap a1;
    public LinearGradient b1;
    public int c1;
    public int d1;
    public Rect e1;

    public HorizontalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Bitmap getTempBitmapHigh() {
        Bitmap bitmap = this.a1;
        if (bitmap == null || bitmap.getWidth() != this.c1 || this.a1.getHeight() != getHeight()) {
            this.a1 = Bitmap.createBitmap(this.c1, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.a1;
    }

    private Bitmap getTempBitmapLow() {
        Bitmap bitmap = this.W0;
        if (bitmap == null || bitmap.getWidth() != this.Y0 || this.W0.getHeight() != getHeight()) {
            this.W0 = Bitmap.createBitmap(this.Y0, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.W0;
    }

    public void F1(Context context, AttributeSet attributeSet) {
        D1(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0.l.O);
        setRowHeight(obtainStyledAttributes);
        setNumRows(obtainStyledAttributes.getInt(g0.l.P, 1));
        obtainStyledAttributes.recycle();
        I1();
        Paint paint = new Paint();
        this.V0 = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final boolean G1() {
        if (!this.U0) {
            return false;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (this.M0.O2(getChildAt(childCount)) > (getWidth() - getPaddingRight()) + this.d1) {
                return true;
            }
        }
        return false;
    }

    public final boolean H1() {
        if (!this.T0) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.M0.N2(getChildAt(i)) < getPaddingLeft() - this.Z0) {
                return true;
            }
        }
        return false;
    }

    public final void I1() {
        if (this.T0 || this.U0) {
            setLayerType(2, (Paint) null);
            setWillNotDraw(false);
        } else {
            setLayerType(0, (Paint) null);
            setWillNotDraw(true);
        }
    }

    public void draw(Canvas canvas) {
        boolean H1 = H1();
        boolean G1 = G1();
        if (!H1) {
            this.W0 = null;
        }
        if (!G1) {
            this.a1 = null;
        }
        if (!H1 && !G1) {
            super.draw(canvas);
            return;
        }
        int paddingLeft = this.T0 ? (getPaddingLeft() - this.Z0) - this.Y0 : 0;
        int width = this.U0 ? (getWidth() - getPaddingRight()) + this.d1 + this.c1 : getWidth();
        int save = canvas.save();
        canvas.clipRect((this.T0 ? this.Y0 : 0) + paddingLeft, 0, width - (this.U0 ? this.c1 : 0), getHeight());
        super.draw(canvas);
        canvas.restoreToCount(save);
        Canvas canvas2 = new Canvas();
        Rect rect = this.e1;
        rect.top = 0;
        rect.bottom = getHeight();
        if (H1 && this.Y0 > 0) {
            Bitmap tempBitmapLow = getTempBitmapLow();
            tempBitmapLow.eraseColor(0);
            canvas2.setBitmap(tempBitmapLow);
            int save2 = canvas2.save();
            canvas2.clipRect(0, 0, this.Y0, getHeight());
            float f = -paddingLeft;
            canvas2.translate(f, 0.0f);
            super.draw(canvas2);
            canvas2.restoreToCount(save2);
            this.V0.setShader(this.X0);
            canvas2.drawRect(0.0f, 0.0f, this.Y0, getHeight(), this.V0);
            Rect rect2 = this.e1;
            rect2.left = 0;
            rect2.right = this.Y0;
            canvas.translate(paddingLeft, 0.0f);
            Rect rect3 = this.e1;
            canvas.drawBitmap(tempBitmapLow, rect3, rect3, (Paint) null);
            canvas.translate(f, 0.0f);
        }
        if (!G1 || this.c1 <= 0) {
            return;
        }
        Bitmap tempBitmapHigh = getTempBitmapHigh();
        tempBitmapHigh.eraseColor(0);
        canvas2.setBitmap(tempBitmapHigh);
        int save3 = canvas2.save();
        canvas2.clipRect(0, 0, this.c1, getHeight());
        canvas2.translate(-(width - this.c1), 0.0f);
        super.draw(canvas2);
        canvas2.restoreToCount(save3);
        this.V0.setShader(this.b1);
        canvas2.drawRect(0.0f, 0.0f, this.c1, getHeight(), this.V0);
        Rect rect4 = this.e1;
        rect4.left = 0;
        rect4.right = this.c1;
        canvas.translate(width - r5, 0.0f);
        Rect rect5 = this.e1;
        canvas.drawBitmap(tempBitmapHigh, rect5, rect5, (Paint) null);
        canvas.translate(-(width - this.c1), 0.0f);
    }

    public final boolean getFadingLeftEdge() {
        return this.T0;
    }

    public final int getFadingLeftEdgeLength() {
        return this.Y0;
    }

    public final int getFadingLeftEdgeOffset() {
        return this.Z0;
    }

    public final boolean getFadingRightEdge() {
        return this.U0;
    }

    public final int getFadingRightEdgeLength() {
        return this.c1;
    }

    public final int getFadingRightEdgeOffset() {
        return this.d1;
    }

    public final void setFadingLeftEdge(boolean z) {
        if (this.T0 != z) {
            this.T0 = z;
            if (!z) {
                this.W0 = null;
            }
            invalidate();
            I1();
        }
    }

    public final void setFadingLeftEdgeLength(int i) {
        if (this.Y0 != i) {
            this.Y0 = i;
            this.X0 = i != 0 ? new LinearGradient(0.0f, 0.0f, this.Y0, 0.0f, 0, -16777216, Shader.TileMode.CLAMP) : null;
            invalidate();
        }
    }

    public final void setFadingLeftEdgeOffset(int i) {
        if (this.Z0 != i) {
            this.Z0 = i;
            invalidate();
        }
    }

    public final void setFadingRightEdge(boolean z) {
        if (this.U0 != z) {
            this.U0 = z;
            if (!z) {
                this.a1 = null;
            }
            invalidate();
            I1();
        }
    }

    public final void setFadingRightEdgeLength(int i) {
        if (this.c1 != i) {
            this.c1 = i;
            this.b1 = i != 0 ? new LinearGradient(0.0f, 0.0f, this.c1, 0.0f, -16777216, 0, Shader.TileMode.CLAMP) : null;
            invalidate();
        }
    }

    public final void setFadingRightEdgeOffset(int i) {
        if (this.d1 != i) {
            this.d1 = i;
            invalidate();
        }
    }

    public void setNumRows(int i) {
        this.M0.m4(i);
        requestLayout();
    }

    public void setRowHeight(int i) {
        this.M0.s4(i);
        requestLayout();
    }

    public HorizontalGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V0 = new Paint();
        this.e1 = new Rect();
        this.M0.q4(0);
        F1(context, attributeSet);
    }

    public void setRowHeight(TypedArray typedArray) {
        if (typedArray.peekValue(g0.l.Q) != null) {
            setRowHeight(typedArray.getLayoutDimension(g0.l.Q, 0));
        }
    }
}
