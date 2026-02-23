package M4;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b2 implements zzo {
    public final /* synthetic */ String a;
    public final /* synthetic */ c2 b;

    public b2(c2 c2Var, String str) {
        this.b = c2Var;
        this.a = str;
    }

    public final String zza(String str) {
        Map map = (Map) c2.x(this.b).get(this.a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
