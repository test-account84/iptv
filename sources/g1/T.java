package g1;

import com.google.android.gms.internal.play_billing.zzai;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class t implements Callable {
    public final /* synthetic */ String a;
    public final /* synthetic */ i b;
    public final /* synthetic */ d c;

    public t(d dVar, String str, i iVar) {
        this.a = str;
        this.b = iVar;
        this.c = dVar;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        P G = d.G(this.c, this.a, 9);
        if (G.b() != null) {
            this.b.a(G.a(), G.b());
            return null;
        }
        this.b.a(G.a(), zzai.zzk());
        return null;
    }
}
