package r7;

import Z3.z;
import android.content.DialogInterface;
import com.nst.iptvsmarterstvbox.view.demo.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class w implements DialogInterface.OnClickListener {
    public final /* synthetic */ z a;
    public final /* synthetic */ com.nst.iptvsmarterstvbox.view.demo.b c;
    public final /* synthetic */ b.b d;

    public /* synthetic */ w(z zVar, com.nst.iptvsmarterstvbox.view.demo.b bVar, b.b bVar2) {
        this.a = zVar;
        this.c = bVar;
        this.d = bVar2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        com.nst.iptvsmarterstvbox.view.demo.b.D(this.a, this.c, this.d, dialogInterface, i);
    }
}
