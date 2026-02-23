package p7;

import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class h0 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ NewDashboardActivity.x a;

    public /* synthetic */ h0(NewDashboardActivity.x xVar) {
        this.a = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        NewDashboardActivity.x.a(this.a, dialogInterface);
    }
}
