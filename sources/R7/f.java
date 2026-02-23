package r7;

import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class f implements DialogInterface.OnDismissListener {
    public final /* synthetic */ ExoDownloadedPlayerTwo a;

    public /* synthetic */ f(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        this.a = exoDownloadedPlayerTwo;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ExoDownloadedPlayerTwo.u1(this.a, dialogInterface);
    }
}
