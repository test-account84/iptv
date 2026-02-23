package o4;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.zzaf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class w {
    public static final t4.b c = new t4.b("Session");
    public final M a;
    public final Y b;

    public w(Context context, String str, String str2) {
        Y y = new Y(this, null);
        this.b = y;
        this.a = zzaf.zzd(context, str, str2, y);
    }

    public abstract void a(boolean z);

    public abstract long b();

    public boolean c() {
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        M m = this.a;
        if (m != null) {
            try {
                return m.zzp();
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "isConnected", M.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean d() {
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        M m = this.a;
        if (m != null) {
            try {
                return m.zzq();
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "isConnecting", M.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean e() {
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        M m = this.a;
        if (m != null) {
            try {
                return m.zzt();
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "isResuming", M.class.getSimpleName());
            }
        }
        return false;
    }

    public final void f(int i) {
        M m = this.a;
        if (m != null) {
            try {
                m.zzj(i);
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "notifyFailedToResumeSession", M.class.getSimpleName());
            }
        }
    }

    public final void g(int i) {
        M m = this.a;
        if (m != null) {
            try {
                m.e(i);
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "notifyFailedToStartSession", M.class.getSimpleName());
            }
        }
    }

    public final void h(int i) {
        M m = this.a;
        if (m != null) {
            try {
                m.x0(i);
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "notifySessionEnded", M.class.getSimpleName());
            }
        }
    }

    public abstract void i(Bundle bundle);

    public abstract void j(Bundle bundle);

    public abstract void k(Bundle bundle);

    public abstract void l(Bundle bundle);

    public abstract void m(Bundle bundle);

    public final int n() {
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        M m = this.a;
        if (m != null) {
            try {
                if (m.zze() >= 211100000) {
                    return this.a.zzf();
                }
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "getSessionStartType", M.class.getSimpleName());
            }
        }
        return 0;
    }

    public final F4.a o() {
        M m = this.a;
        if (m != null) {
            try {
                return m.zzg();
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "getWrappedObject", M.class.getSimpleName());
            }
        }
        return null;
    }
}
