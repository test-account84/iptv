package K5;

import C5.a;
import android.os.Bundle;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class e implements a.b {
    public M5.b a;
    public M5.b b;

    public static void b(M5.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.onEvent(str, bundle);
    }

    public void a(int i, Bundle bundle) {
        String string;
        L5.f.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", new Object[]{Integer.valueOf(i), bundle}));
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        c(string, bundle2);
    }

    public final void c(String str, Bundle bundle) {
        b("clx".equals(bundle.getString("_o")) ? this.a : this.b, str, bundle);
    }

    public void d(M5.b bVar) {
        this.b = bVar;
    }

    public void e(M5.b bVar) {
        this.a = bVar;
    }
}
