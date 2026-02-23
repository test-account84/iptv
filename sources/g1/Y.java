package g1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhl;
import com.google.android.gms.internal.play_billing.zzr;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class y implements ServiceConnection {
    public final Object a = new Object();
    public boolean c = false;
    public e d;
    public final /* synthetic */ d e;

    public /* synthetic */ y(d dVar, e eVar, x xVar) {
        this.e = dVar;
        this.d = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object a() {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.y.a():java.lang.Object");
    }

    public final /* synthetic */ void b() {
        d.d0(this.e, 0);
        d.w(this.e, null);
        com.android.billingclient.api.a aVar = com.android.billingclient.api.b.n;
        d.H(this.e, 24, 6, aVar);
        d(aVar);
    }

    public final void c() {
        synchronized (this.a) {
            this.d = null;
            this.c = true;
        }
    }

    public final void d(com.android.billingclient.api.a aVar) {
        synchronized (this.a) {
            try {
                e eVar = this.d;
                if (eVar != null) {
                    eVar.a(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzb.zzj("BillingClient", "Billing service connected.");
        d.w(this.e, zzr.zzu(iBinder));
        u uVar = new u(this);
        w wVar = new w(this);
        d dVar = this.e;
        if (d.c0(dVar, uVar, 30000L, wVar, d.V(dVar)) == null) {
            d dVar2 = this.e;
            com.android.billingclient.api.a Y = d.Y(dVar2);
            d.H(dVar2, 25, 6, Y);
            d(Y);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzb.zzk("BillingClient", "Billing service disconnected.");
        d.X(this.e).c(zzhl.zzz());
        d.w(this.e, null);
        d.d0(this.e, 0);
        synchronized (this.a) {
            try {
                e eVar = this.d;
                if (eVar != null) {
                    eVar.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
