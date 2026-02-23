package com.nst.iptvsmarterstvbox.miscelleneious;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SpeedyGridLayoutManager extends GridLayoutManager {

    public class a extends h {
        public a(Context context) {
            super(context);
        }

        public PointF a(int i) {
            return super.a(i);
        }

        public float v(DisplayMetrics displayMetrics) {
            return 150.0f / displayMetrics.densityDpi;
        }
    }

    public SpeedyGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void g2(RecyclerView recyclerView, RecyclerView.A a2, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i);
        h2(aVar);
    }
}
