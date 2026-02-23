package Y6;

import android.content.DialogInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class g implements DialogInterface.OnCancelListener {
    public final /* synthetic */ com.journeyapps.barcodescanner.b a;

    public /* synthetic */ g(com.journeyapps.barcodescanner.b bVar) {
        this.a = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        com.journeyapps.barcodescanner.b.b(this.a, dialogInterface);
    }
}
