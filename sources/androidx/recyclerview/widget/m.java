package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class m {
    public static int a(RecyclerView.A a, j jVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.h0() == 0 || a.c() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.B0(view) - oVar.B0(view2)) + 1;
        }
        return Math.min(jVar.n(), jVar.d(view2) - jVar.g(view));
    }

    public static int b(RecyclerView.A a, j jVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.h0() == 0 || a.c() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (a.c() - Math.max(oVar.B0(view), oVar.B0(view2))) - 1) : Math.max(0, Math.min(oVar.B0(view), oVar.B0(view2)));
        if (z) {
            return Math.round((max * (Math.abs(jVar.d(view2) - jVar.g(view)) / (Math.abs(oVar.B0(view) - oVar.B0(view2)) + 1))) + (jVar.m() - jVar.g(view)));
        }
        return max;
    }

    public static int c(RecyclerView.A a, j jVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.h0() == 0 || a.c() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a.c();
        }
        return (int) (((jVar.d(view2) - jVar.g(view)) / (Math.abs(oVar.B0(view) - oVar.B0(view2)) + 1)) * a.c());
    }
}
