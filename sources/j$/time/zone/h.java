package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class h implements PrivilegedAction {
    final /* synthetic */ List a;

    h(ArrayList arrayList) {
        this.a = arrayList;
    }

    public final Object run() {
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property == null) {
            j.d(new i());
            return null;
        }
        try {
            j jVar = (j) j.class.cast(Class.forName(property, true, j.class.getClassLoader()).newInstance());
            j.d(jVar);
            this.a.add(jVar);
            return null;
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
