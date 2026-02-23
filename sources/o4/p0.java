package o4;

import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p0 {
    public static final t4.b b = new t4.b("DiscoveryManager");
    public final G a;

    public p0(G g) {
        this.a = g;
    }

    public final F4.a a() {
        try {
            return this.a.zze();
        } catch (RemoteException e) {
            b.b(e, "Unable to call %s on %s.", "getWrappedThis", G.class.getSimpleName());
            return null;
        }
    }
}
