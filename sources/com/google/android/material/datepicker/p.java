package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class p extends Fragment {
    public final LinkedHashSet a = new LinkedHashSet();

    public boolean x(o oVar) {
        return this.a.add(oVar);
    }

    public void z() {
        this.a.clear();
    }
}
