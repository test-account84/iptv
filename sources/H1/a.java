package h1;

import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends u {
    public Intent d;

    public a(k kVar) {
        super(kVar);
    }

    public String getMessage() {
        return this.d != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
