package H5;

import com.google.android.gms.internal.firebase-auth-api.zzxw;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class v {
    public static final A4.a a = new A4.a("GetTokenResultFactory", new String[0]);

    public static G5.w a(String str) {
        Map hashMap;
        try {
            hashMap = x.b(str);
        } catch (zzxw e) {
            a.b("Error parsing token claims", e, new Object[0]);
            hashMap = new HashMap();
        }
        return new G5.w(str, hashMap);
    }
}
