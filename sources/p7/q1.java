package p7;

import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class q1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ViewDetailsActivity a;

    public /* synthetic */ q1(ViewDetailsActivity viewDetailsActivity) {
        this.a = viewDetailsActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ViewDetailsActivity.w1(this.a, dialogInterface, i);
    }
}
