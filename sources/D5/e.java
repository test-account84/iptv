package D5;

import L4.a;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements a.a {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j) {
        if (str == null || !b.c(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle("params", bundle);
        f.a(this.a).a(3, bundle2);
    }
}
