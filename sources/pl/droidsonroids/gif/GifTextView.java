package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import java.io.IOException;
import pl.droidsonroids.gif.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class GifTextView extends TextView {
    public e.b a;

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet, 0, 0);
    }

    public static void d(Drawable[] drawableArr, boolean z) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(z, false);
            }
        }
    }

    private void setCompoundDrawablesVisible(boolean z) {
        d(getCompoundDrawables(), z);
        d(getCompoundDrawablesRelative(), z);
    }

    public final void a() {
        if (this.a.b < 0) {
            return;
        }
        for (Drawable drawable : getCompoundDrawables()) {
            e.a(this.a.b, drawable);
        }
        for (Drawable drawable2 : getCompoundDrawablesRelative()) {
            e.a(this.a.b, drawable2);
        }
        e.a(this.a.b, getBackground());
    }

    public final Drawable b(int i) {
        if (i == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i);
        if (!isInEditMode() && e.a.contains(resourceTypeName)) {
            try {
                return new a(resources, i);
            } catch (IOException | Resources.NotFoundException unused) {
            }
        }
        return resources.getDrawable(i, getContext().getTheme());
    }

    public final void c(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            Drawable b = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable b2 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable b3 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable b4 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable b5 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable b6 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (b5 != null) {
                    b = b5;
                }
                if (b6 == null) {
                    b6 = b3;
                }
            } else {
                if (b5 != null) {
                    b3 = b5;
                }
                if (b6 == null) {
                    b6 = b;
                }
                b = b3;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(b, b2, b6, b4);
            setBackground(b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            this.a = new e.b(this, attributeSet, i, i2);
            a();
        }
        this.a = new e.b();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        dVar.a(compoundDrawables[0], 0);
        dVar.a(compoundDrawables[1], 1);
        dVar.a(compoundDrawables[2], 2);
        dVar.a(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        dVar.a(compoundDrawablesRelative[0], 4);
        dVar.a(compoundDrawablesRelative[2], 5);
        dVar.a(getBackground(), 6);
    }

    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.a.a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            drawableArr[4] = compoundDrawablesRelative[0];
            drawableArr[5] = compoundDrawablesRelative[2];
            drawableArr[6] = getBackground();
        }
        return new d(super.onSaveInstanceState(), drawableArr);
    }

    public void setBackgroundResource(int i) {
        setBackground(b(i));
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(b(i), b(i2), b(i3), b(i4));
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesWithIntrinsicBounds(b(i), b(i2), b(i3), b(i4));
    }

    public void setFreezesAnimation(boolean z) {
        this.a.a = z;
    }
}
