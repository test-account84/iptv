package H;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d extends Drawable implements Drawable.Callback, c, b {
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public int a;
    public PorterDuff.Mode c;
    public boolean d;
    public f e;
    public boolean f;
    public Drawable g;

    public d(f fVar, Resources resources) {
        this.e = fVar;
        e(resources);
    }

    public final Drawable a() {
        return this.g;
    }

    public final void b(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.e;
            if (fVar != null) {
                fVar.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public abstract boolean c();

    public final f d() {
        return new f(this.e);
    }

    public void draw(Canvas canvas) {
        this.g.draw(canvas);
    }

    public final void e(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.e;
        if (fVar == null || (constantState = fVar.b) == null) {
            return;
        }
        b(constantState.newDrawable(resources));
    }

    public final boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.e;
        ColorStateList colorStateList = fVar.c;
        PorterDuff.Mode mode = fVar.d;
        if (colorStateList == null || mode == null) {
            this.d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.d || colorForState != this.a || mode != this.c) {
                setColorFilter(colorForState, mode);
                this.a = colorForState;
                this.c = mode;
                this.d = true;
                return true;
            }
        }
        return false;
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.e;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.g.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        f fVar = this.e;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.e.a = getChangingConfigurations();
        return this.e;
    }

    public Drawable getCurrent() {
        return this.g.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.g.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.g.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return a.f(this.g);
    }

    public int getMinimumHeight() {
        return this.g.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.g.getMinimumWidth();
    }

    public int getOpacity() {
        return this.g.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.g.getPadding(rect);
    }

    public int[] getState() {
        return this.g.getState();
    }

    public Region getTransparentRegion() {
        return this.g.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.h(this.g);
    }

    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!c() || (fVar = this.e) == null) ? null : fVar.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.g.isStateful();
    }

    public void jumpToCurrentState() {
        this.g.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.e = d();
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.e;
            if (fVar != null) {
                Drawable drawable2 = this.g;
                fVar.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        return a.m(this.g, i);
    }

    public boolean onLevelChange(int i) {
        return this.g.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.g.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        a.j(this.g, z);
    }

    public void setChangingConfigurations(int i) {
        this.g.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.g.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.g.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return f(iArr) || this.g.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.e.c = colorStateList;
        f(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.e.d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.g.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public d(Drawable drawable) {
        this.e = d();
        b(drawable);
    }
}
