package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class x extends LinearLayout {
    public Drawable a;
    public boolean c;
    public final Rect d;

    public x(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Rect();
        if (context.getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843017});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                a(drawable);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            k.b(this, drawable);
            return;
        }
        if (this.a != drawable) {
            this.a = drawable;
            this.c = true;
            setWillNotDraw(false);
            this.a.setCallback(this);
            if (this.a.isStateful()) {
                this.a.setState(getDrawableState());
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.a;
        if (drawable != null) {
            if (this.c) {
                this.c = false;
                Rect rect = this.d;
                rect.set(0, 0, getRight() - getLeft(), getBottom() - getTop());
                drawable.setBounds(rect);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.a;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.a.setState(getDrawableState());
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = z | this.c;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.a;
    }
}
