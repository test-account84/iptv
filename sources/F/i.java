package F;

import F.h;
import android.graphics.Typeface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ h.e a;
    public final /* synthetic */ Typeface c;

    public /* synthetic */ i(h.e eVar, Typeface typeface) {
        this.a = eVar;
        this.c = typeface;
    }

    public final void run() {
        h.e.a(this.a, this.c);
    }
}
