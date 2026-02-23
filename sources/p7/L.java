package p7;

import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.activity.CheckAppupdateActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class l implements DialogInterface.OnCancelListener {
    public final /* synthetic */ CheckAppupdateActivity.d a;

    public /* synthetic */ l(CheckAppupdateActivity.d dVar) {
        this.a = dVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        CheckAppupdateActivity.d.a(this.a, dialogInterface);
    }
}
