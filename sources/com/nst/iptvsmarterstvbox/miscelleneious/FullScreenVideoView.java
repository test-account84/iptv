package com.nst.iptvsmarterstvbox.miscelleneious;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FullScreenVideoView extends VideoView {
    public FullScreenVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(i, i2);
    }
}
