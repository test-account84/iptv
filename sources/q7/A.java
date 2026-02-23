package Q7;

import com.onesignal.l1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a {
    public static a b;
    public b a;

    public a(l1 l1Var) {
        b = this;
        if (l1Var.d(l1Var.i(), "PREFS_OS_LANGUAGE", null) != null) {
            this.a = new c(l1Var);
        } else {
            this.a = new d();
        }
    }

    public static a a() {
        return b;
    }

    public String b() {
        return this.a.getLanguage();
    }
}
