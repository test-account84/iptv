package g1;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class r implements Callable {
    public final /* synthetic */ d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ f e;
    public final /* synthetic */ Bundle f;

    public /* synthetic */ r(d dVar, int i, String str, String str2, f fVar, Bundle bundle) {
        this.a = dVar;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = fVar;
        this.f = bundle;
    }

    public final Object call() {
        return this.a.T(this.b, this.c, this.d, this.e, this.f);
    }
}
