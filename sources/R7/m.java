package r7;

import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class m implements DialogInterface.OnDismissListener {
    public final /* synthetic */ NSTEXOPlayerSkyActivity a;

    public /* synthetic */ m(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        this.a = nSTEXOPlayerSkyActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        NSTEXOPlayerSkyActivity.u1(this.a, dialogInterface);
    }
}
