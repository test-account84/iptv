package p7;

import com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ ExoPlayerMoviesSeries.g a;
    public final /* synthetic */ ArrayList c;

    public /* synthetic */ x(ExoPlayerMoviesSeries.g gVar, ArrayList arrayList) {
        this.a = gVar;
        this.c = arrayList;
    }

    public final void run() {
        ExoPlayerMoviesSeries.g.e(this.a, this.c);
    }
}
