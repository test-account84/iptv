package o4;

import android.os.RemoteException;
import n4.C0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o0 extends C0 {
    public final /* synthetic */ e a;

    public /* synthetic */ o0(e eVar, n0 n0Var) {
        this.a = eVar;
    }

    public final void a() {
        e eVar = this.a;
        if (e.w(eVar) != null) {
            try {
                if (e.x(eVar) != null) {
                    e.x(eVar).l0();
                }
                e.w(this.a).d(null);
            } catch (RemoteException e) {
                e.y().b(e, "Unable to call %s on %s.", "onConnected", E.class.getSimpleName());
            }
        }
    }

    public final void b(int i) {
        e eVar = this.a;
        if (e.w(eVar) != null) {
            try {
                e.w(eVar).H(new w4.b(i));
            } catch (RemoteException e) {
                e.y().b(e, "Unable to call %s on %s.", "onConnectionFailed", E.class.getSimpleName());
            }
        }
    }

    public final void c(int i) {
        e eVar = this.a;
        if (e.w(eVar) != null) {
            try {
                e.w(eVar).zzj(i);
            } catch (RemoteException e) {
                e.y().b(e, "Unable to call %s on %s.", "onConnectionSuspended", E.class.getSimpleName());
            }
        }
    }

    public final void d(int i) {
        e eVar = this.a;
        if (e.w(eVar) != null) {
            try {
                e.w(eVar).H(new w4.b(i));
            } catch (RemoteException e) {
                e.y().b(e, "Unable to call %s on %s.", "onDisconnected", E.class.getSimpleName());
            }
        }
    }
}
