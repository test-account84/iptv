package com.github.ybq.android.spinkit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import u2.a;
import u2.b;
import u2.c;
import u2.d;
import u2.e;
import x2.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SpinKitView extends ProgressBar {
    public e a;
    public int c;
    public f d;

    public SpinKitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a);
    }

    public final void a() {
        f a = d.a(this.a);
        a.u(this.c);
        setIndeterminateDrawable(a);
    }

    public void onScreenStateChanged(int i) {
        f fVar;
        super.onScreenStateChanged(i);
        if (i != 0 || (fVar = this.d) == null) {
            return;
        }
        fVar.stop();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.d != null && getVisibility() == 0) {
            this.d.start();
        }
    }

    public void setColor(int i) {
        this.c = i;
        f fVar = this.d;
        if (fVar != null) {
            fVar.u(i);
        }
        invalidate();
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (!(drawable instanceof f)) {
            throw new IllegalArgumentException("this d must be instanceof Sprite");
        }
        setIndeterminateDrawable((f) drawable);
    }

    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable instanceof f) {
            ((f) drawable).stop();
        }
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, b.a);
    }

    public f getIndeterminateDrawable() {
        return this.d;
    }

    public void setIndeterminateDrawable(f fVar) {
        super.setIndeterminateDrawable(fVar);
        this.d = fVar;
        if (fVar.c() == 0) {
            this.d.u(this.c);
        }
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() == 0) {
            this.d.start();
        }
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a, i, i2);
        this.a = e.values()[obtainStyledAttributes.getInt(c.c, 0)];
        this.c = obtainStyledAttributes.getColor(c.b, -1);
        obtainStyledAttributes.recycle();
        a();
        setIndeterminate(true);
    }
}
