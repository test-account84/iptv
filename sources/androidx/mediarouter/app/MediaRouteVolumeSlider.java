package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import k.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class MediaRouteVolumeSlider extends u {
    public final float c;
    public boolean d;
    public Drawable e;
    public int f;
    public int g;

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.L);
    }

    public void a(int i) {
        b(i, i);
    }

    public void b(int i, int i2) {
        if (this.f != i) {
            if (Color.alpha(i) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider progress and thumb color cannot be translucent: #" + Integer.toHexString(i));
            }
            this.f = i;
        }
        if (this.g != i2) {
            if (Color.alpha(i2) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider background color cannot be translucent: #" + Integer.toHexString(i2));
            }
            this.g = i2;
        }
    }

    public void c(boolean z) {
        if (this.d == z) {
            return;
        }
        this.d = z;
        super.setThumb(z ? null : this.e);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int i = isEnabled() ? 255 : (int) (this.c * 255.0f);
        Drawable drawable = this.e;
        int i2 = this.f;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        drawable.setColorFilter(i2, mode);
        this.e.setAlpha(i);
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable progressDrawable2 = getProgressDrawable();
            Drawable findDrawableByLayerId = progressDrawable2.findDrawableByLayerId(16908301);
            progressDrawable2.findDrawableByLayerId(16908288).setColorFilter(this.g, mode);
            progressDrawable = findDrawableByLayerId;
        }
        progressDrawable.setColorFilter(this.f, mode);
        progressDrawable.setAlpha(i);
    }

    public void setThumb(Drawable drawable) {
        this.e = drawable;
        if (this.d) {
            drawable = null;
        }
        super.setThumb(drawable);
    }

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = i.h(context);
    }
}
