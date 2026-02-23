package D5;

import L4.a;
import M4.L2;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzjb;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements a.a {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j) {
        if (this.a.a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            zzjb zzjbVar = b.a;
            String a = L2.a(str2);
            if (a != null) {
                str2 = a;
            }
            bundle2.putString("events", str2);
            d.a(this.a).a(2, bundle2);
        }
    }
}
