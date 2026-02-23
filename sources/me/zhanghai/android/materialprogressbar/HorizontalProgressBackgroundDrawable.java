package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class HorizontalProgressBackgroundDrawable extends BaseSingleHorizontalProgressDrawable implements ShowBackgroundDrawable {
    private boolean mShow;

    public HorizontalProgressBackgroundDrawable(Context context) {
        super(context);
        this.mShow = true;
    }

    public void draw(Canvas canvas) {
        if (this.mShow) {
            super.draw(canvas);
        }
    }

    public boolean getShowBackground() {
        return this.mShow;
    }

    public void setShowBackground(boolean z) {
        if (this.mShow != z) {
            this.mShow = z;
            invalidateSelf();
        }
    }
}
