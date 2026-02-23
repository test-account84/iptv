package me.zhanghai.android.materialprogressbar;

import G.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class BaseProgressLayerDrawable extends LayerDrawable implements IntrinsicPaddingDrawable, MaterialProgressDrawable, ShowBackgroundDrawable, TintableDrawable {
    private float mBackgroundAlpha;
    private IntrinsicPaddingDrawable mBackgroundDrawable;
    private IntrinsicPaddingDrawable mProgressDrawable;
    private IntrinsicPaddingDrawable mSecondaryProgressDrawable;

    public BaseProgressLayerDrawable(Drawable[] drawableArr, Context context) {
        super(drawableArr);
        this.mBackgroundAlpha = ThemeUtils.getFloatFromAttrRes(16842803, 0.0f, context);
        setId(0, 16908288);
        this.mBackgroundDrawable = getDrawable(0);
        setId(1, 16908303);
        this.mSecondaryProgressDrawable = getDrawable(1);
        setId(2, 16908301);
        this.mProgressDrawable = getDrawable(2);
        setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, -16777216, context));
    }

    public boolean getShowBackground() {
        return ((ShowBackgroundDrawable) this.mBackgroundDrawable).getShowBackground();
    }

    public boolean getUseIntrinsicPadding() {
        return this.mBackgroundDrawable.getUseIntrinsicPadding();
    }

    public void setShowBackground(boolean z) {
        if (((ShowBackgroundDrawable) this.mBackgroundDrawable).getShowBackground() != z) {
            ((ShowBackgroundDrawable) this.mBackgroundDrawable).setShowBackground(z);
            ((ShowBackgroundDrawable) this.mSecondaryProgressDrawable).setShowBackground(!z);
        }
    }

    @SuppressLint({"NewApi"})
    public void setTint(int i) {
        int o = a.o(i, Math.round(Color.alpha(i) * this.mBackgroundAlpha));
        ((TintableDrawable) this.mBackgroundDrawable).setTint(o);
        ((TintableDrawable) this.mSecondaryProgressDrawable).setTint(o);
        ((TintableDrawable) this.mProgressDrawable).setTint(i);
    }

    @SuppressLint({"NewApi"})
    public void setTintList(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (colorStateList != null) {
            if (!colorStateList.isOpaque()) {
                Log.w(getClass().getSimpleName(), "setTintList() called with a non-opaque ColorStateList, its original alpha will be discarded");
            }
            colorStateList2 = colorStateList.withAlpha(Math.round(this.mBackgroundAlpha * 255.0f));
        } else {
            colorStateList2 = null;
        }
        ((TintableDrawable) this.mBackgroundDrawable).setTintList(colorStateList2);
        ((TintableDrawable) this.mSecondaryProgressDrawable).setTintList(colorStateList2);
        ((TintableDrawable) this.mProgressDrawable).setTintList(colorStateList);
    }

    @SuppressLint({"NewApi"})
    public void setTintMode(PorterDuff.Mode mode) {
        ((TintableDrawable) this.mBackgroundDrawable).setTintMode(mode);
        ((TintableDrawable) this.mSecondaryProgressDrawable).setTintMode(mode);
        ((TintableDrawable) this.mProgressDrawable).setTintMode(mode);
    }

    public void setUseIntrinsicPadding(boolean z) {
        this.mBackgroundDrawable.setUseIntrinsicPadding(z);
        this.mSecondaryProgressDrawable.setUseIntrinsicPadding(z);
        this.mProgressDrawable.setUseIntrinsicPadding(z);
    }
}
