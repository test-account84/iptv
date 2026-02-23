package r7;

import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class p implements DialogInterface.OnDismissListener {
    public final /* synthetic */ NSTEXOPlayerSkyTvActivity a;

    public /* synthetic */ p(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        this.a = nSTEXOPlayerSkyTvActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        NSTEXOPlayerSkyTvActivity.u1(this.a, dialogInterface);
    }
}
