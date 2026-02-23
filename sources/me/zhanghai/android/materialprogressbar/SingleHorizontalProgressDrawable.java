package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class SingleHorizontalProgressDrawable extends BaseSingleHorizontalProgressDrawable implements ShowBackgroundDrawable {
    private static final int LEVEL_MAX = 10000;
    private boolean mShowBackground;

    public SingleHorizontalProgressDrawable(Context context) {
        super(context);
    }

    public boolean getShowBackground() {
        return this.mShowBackground;
    }

    public void onDrawRect(Canvas canvas, Paint paint) {
        int level = getLevel();
        if (level == 0) {
            return;
        }
        int save = canvas.save();
        canvas.scale(level / 10000.0f, 1.0f, BaseSingleHorizontalProgressDrawable.RECT_BOUND.left, 0.0f);
        super.onDrawRect(canvas, paint);
        if (this.mShowBackground) {
            super.onDrawRect(canvas, paint);
        }
        canvas.restoreToCount(save);
    }

    public boolean onLevelChange(int i) {
        invalidateSelf();
        return true;
    }

    public void setShowBackground(boolean z) {
        if (this.mShowBackground != z) {
            this.mShowBackground = z;
            invalidateSelf();
        }
    }
}
