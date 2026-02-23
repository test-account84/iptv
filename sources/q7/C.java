package Q7;

import com.onesignal.l1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class c implements b {
    public final l1 a;

    public c(l1 l1Var) {
        this.a = l1Var;
    }

    public String getLanguage() {
        l1 l1Var = this.a;
        return l1Var.d(l1Var.i(), "PREFS_OS_LANGUAGE", "en");
    }
}
