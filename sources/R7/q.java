package r7;

import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.demo.PlayerActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class q implements DialogInterface.OnDismissListener {
    public final /* synthetic */ PlayerActivity a;

    public /* synthetic */ q(PlayerActivity playerActivity) {
        this.a = playerActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        PlayerActivity.u1(this.a, dialogInterface);
    }
}
