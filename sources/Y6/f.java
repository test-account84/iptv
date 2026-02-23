package Y6;

import android.content.DialogInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ com.journeyapps.barcodescanner.b a;

    public /* synthetic */ f(com.journeyapps.barcodescanner.b bVar) {
        this.a = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        com.journeyapps.barcodescanner.b.a(this.a, dialogInterface, i);
    }
}
