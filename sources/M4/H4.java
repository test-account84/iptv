package M4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h4 implements ServiceConnection, c.a, c.b {
    public volatile boolean a;
    public volatile v1 c;
    public final /* synthetic */ i4 d;

    public h4(i4 i4Var) {
        this.d = i4Var;
    }

    public static /* bridge */ /* synthetic */ void a(h4 h4Var, boolean z) {
        h4Var.a = false;
    }

    public final void b(Intent intent) {
        this.d.h();
        Context c = this.d.a.c();
        B4.b b = B4.b.b();
        synchronized (this) {
            try {
                if (this.a) {
                    this.d.a.d().v().a("Connection attempt already in progress");
                    return;
                }
                this.d.a.d().v().a("Using local app measurement service");
                this.a = true;
                b.a(c, intent, i4.I(this.d), 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        this.d.h();
        Context c = this.d.a.c();
        synchronized (this) {
            try {
                if (this.a) {
                    this.d.a.d().v().a("Connection attempt already in progress");
                    return;
                }
                if (this.c != null && (this.c.isConnecting() || this.c.isConnected())) {
                    this.d.a.d().v().a("Already awaiting connection attempt");
                    return;
                }
                this.c = new v1(c, Looper.getMainLooper(), this, this);
                this.d.a.d().v().a("Connecting to remote service");
                this.a = true;
                com.google.android.gms.common.internal.r.m(this.c);
                this.c.checkAvailabilityAndConnect();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        if (this.c != null && (this.c.isConnected() || this.c.isConnecting())) {
            this.c.disconnect();
        }
        this.c = null;
    }

    public final void onConnected(Bundle bundle) {
        com.google.android.gms.common.internal.r.f("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                com.google.android.gms.common.internal.r.m(this.c);
                this.d.a.f().z(new e4(this, (p1) this.c.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.c = null;
                this.a = false;
            }
        }
    }

    public final void onConnectionFailed(w4.b bVar) {
        com.google.android.gms.common.internal.r.f("MeasurementServiceConnection.onConnectionFailed");
        z1 E = this.d.a.E();
        if (E != null) {
            E.w().b("Service connection failed", bVar);
        }
        synchronized (this) {
            this.a = false;
            this.c = null;
        }
        this.d.a.f().z(new g4(this));
    }

    public final void onConnectionSuspended(int i) {
        com.google.android.gms.common.internal.r.f("MeasurementServiceConnection.onConnectionSuspended");
        this.d.a.d().q().a("Service connection suspended");
        this.d.a.f().z(new f4(this));
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.common.internal.r.f("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.a = false;
                this.d.a.d().r().a("Service connected with null binder");
                return;
            }
            p1 p1Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    p1Var = queryLocalInterface instanceof p1 ? (p1) queryLocalInterface : new n1(iBinder);
                    this.d.a.d().v().a("Bound to IMeasurementService interface");
                } else {
                    this.d.a.d().r().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.d.a.d().r().a("Service connect failed to get IMeasurementService");
            }
            if (p1Var == null) {
                this.a = false;
                try {
                    B4.b.b().c(this.d.a.c(), i4.I(this.d));
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.d.a.f().z(new c4(this, p1Var));
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.r.f("MeasurementServiceConnection.onServiceDisconnected");
        this.d.a.d().q().a("Service disconnected");
        this.d.a.f().z(new d4(this, componentName));
    }
}
