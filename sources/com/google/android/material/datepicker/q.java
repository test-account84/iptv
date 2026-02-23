package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class q extends LinearLayoutManager {

    public class a extends androidx.recyclerview.widget.h {
        public a(Context context) {
            super(context);
        }

        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public q(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public void g2(RecyclerView recyclerView, RecyclerView.A a2, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i);
        h2(aVar);
    }
}
