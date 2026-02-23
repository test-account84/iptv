package o4;

import android.content.Context;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class x {
    public static final t4.b c = new t4.b("SessionManager");
    public final O a;
    public final Context b;

    public x(O o, Context context) {
        this.a = o;
        this.b = context;
    }

    public void a(y yVar, Class cls) {
        if (yVar == null) {
            throw new NullPointerException("SessionManagerListener can't be null");
        }
        com.google.android.gms.common.internal.r.m(cls);
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        try {
            this.a.K0(new Z(yVar, cls));
        } catch (RemoteException e) {
            c.b(e, "Unable to call %s on %s.", "addSessionManagerListener", O.class.getSimpleName());
        }
    }

    public void b(boolean z) {
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        try {
            c.e("End session for %s", this.b.getPackageName());
            this.a.e0(true, z);
        } catch (RemoteException e) {
            c.b(e, "Unable to call %s on %s.", "endCurrentSession", O.class.getSimpleName());
        }
    }

    public e c() {
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        w d = d();
        if (d == null || !(d instanceof e)) {
            return null;
        }
        return (e) d;
    }

    public w d() {
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        try {
            return (w) F4.b.E(this.a.zzf());
        } catch (RemoteException e) {
            c.b(e, "Unable to call %s on %s.", "getWrappedCurrentSession", O.class.getSimpleName());
            return null;
        }
    }

    public void e(y yVar, Class cls) {
        com.google.android.gms.common.internal.r.m(cls);
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        if (yVar == null) {
            return;
        }
        try {
            this.a.d0(new Z(yVar, cls));
        } catch (RemoteException e) {
            c.b(e, "Unable to call %s on %s.", "removeSessionManagerListener", O.class.getSimpleName());
        }
    }

    public final F4.a f() {
        try {
            return this.a.zzg();
        } catch (RemoteException e) {
            c.b(e, "Unable to call %s on %s.", "getWrappedThis", O.class.getSimpleName());
            return null;
        }
    }
}
