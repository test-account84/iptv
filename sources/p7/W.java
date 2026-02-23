package p7;

import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class w implements DialogInterface.OnDismissListener {
    public final /* synthetic */ ExoPlayerMoviesSeries a;

    public /* synthetic */ w(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        this.a = exoPlayerMoviesSeries;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ExoPlayerMoviesSeries.u1(this.a, dialogInterface);
    }
}
