package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.j;
import androidx.lifecycle.n;
import androidx.lifecycle.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class FragmentStateAdapter$5 implements n {
    public final /* synthetic */ Handler a;
    public final /* synthetic */ Runnable c;

    public void b(p pVar, j.b bVar) {
        if (bVar == j.b.ON_DESTROY) {
            this.a.removeCallbacks(this.c);
            pVar.getLifecycle().c(this);
        }
    }
}
