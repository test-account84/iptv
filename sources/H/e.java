package H;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends d {
    public static Method i;

    public e(f fVar, Resources resources) {
        super(fVar, resources);
        g();
    }

    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.g;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final void g() {
        if (i == null) {
            try {
                i = Drawable.class.getDeclaredMethod("isProjected", (Class[]) null);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    public Rect getDirtyBounds() {
        return this.g.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.g.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.g;
        if (drawable == null || (method = i) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            return false;
        }
    }

    public void setHotspot(float f, float f2) {
        this.g.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.g.setHotspotBounds(i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i2) {
        if (c()) {
            super.setTint(i2);
        } else {
            this.g.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.g.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.g.setTintMode(mode);
        }
    }

    public e(Drawable drawable) {
        super(drawable);
        g();
    }
}
