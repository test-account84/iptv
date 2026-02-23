package com.google.android.gms.measurement.internal;

import F4.b;
import M4.J3;
import M4.K4;
import M4.P2;
import M4.S2;
import M4.T2;
import M4.U2;
import M4.X2;
import M4.a5;
import M4.b5;
import M4.c5;
import M4.d5;
import M4.e5;
import M4.g3;
import M4.i3;
import M4.j4;
import M4.l2;
import M4.q3;
import M4.s3;
import M4.t;
import M4.t3;
import M4.v;
import M4.z3;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import java.util.Map;
import s.a;

@DynamiteApi
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class AppMeasurementDynamiteService extends zzcb {
    public l2 a = null;
    public final Map c = new a();

    public final void A() {
        if (this.a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public final void E(zzcf zzcfVar, String str) {
        A();
        this.a.N().K(zzcfVar, str);
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        A();
        this.a.y().l(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        A();
        this.a.I().o(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) throws RemoteException {
        A();
        this.a.I().I(null);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        A();
        this.a.y().m(str, j);
    }

    public void generateEventId(zzcf zzcfVar) throws RemoteException {
        A();
        long t0 = this.a.N().t0();
        A();
        this.a.N().J(zzcfVar, t0);
    }

    public void getAppInstanceId(zzcf zzcfVar) throws RemoteException {
        A();
        this.a.f().z(new i3(this, zzcfVar));
    }

    public void getCachedAppInstanceId(zzcf zzcfVar) throws RemoteException {
        A();
        E(zzcfVar, this.a.I().V());
    }

    public void getConditionalUserProperties(String str, String str2, zzcf zzcfVar) throws RemoteException {
        A();
        this.a.f().z(new b5(this, zzcfVar, str, str2));
    }

    public void getCurrentScreenClass(zzcf zzcfVar) throws RemoteException {
        A();
        E(zzcfVar, this.a.I().W());
    }

    public void getCurrentScreenName(zzcf zzcfVar) throws RemoteException {
        A();
        E(zzcfVar, this.a.I().X());
    }

    public void getGmpAppId(zzcf zzcfVar) throws RemoteException {
        String str;
        A();
        t3 I = this.a.I();
        if (I.a.O() != null) {
            str = I.a.O();
        } else {
            try {
                str = z3.b(I.a.c(), "google_app_id", I.a.R());
            } catch (IllegalStateException e) {
                I.a.d().r().b("getGoogleAppId failed with exception", e);
                str = null;
            }
        }
        E(zzcfVar, str);
    }

    public void getMaxUserProperties(String str, zzcf zzcfVar) throws RemoteException {
        A();
        this.a.I().Q(str);
        A();
        this.a.N().I(zzcfVar, 25);
    }

    public void getSessionId(zzcf zzcfVar) throws RemoteException {
        A();
        t3 I = this.a.I();
        I.a.f().z(new g3(I, zzcfVar));
    }

    public void getTestFlag(zzcf zzcfVar, int i) throws RemoteException {
        A();
        if (i == 0) {
            this.a.N().K(zzcfVar, this.a.I().Y());
            return;
        }
        if (i == 1) {
            this.a.N().J(zzcfVar, this.a.I().U().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.a.N().I(zzcfVar, this.a.I().T().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.a.N().E(zzcfVar, this.a.I().R().booleanValue());
                return;
            }
        }
        a5 N = this.a.N();
        double doubleValue = this.a.I().S().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", doubleValue);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            N.a.d().w().b("Error returning double value to wrapper", e);
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzcf zzcfVar) throws RemoteException {
        A();
        this.a.f().z(new j4(this, zzcfVar, str, str2, z));
    }

    public void initForTests(Map map) throws RemoteException {
        A();
    }

    public void initialize(F4.a aVar, zzcl zzclVar, long j) throws RemoteException {
        l2 l2Var = this.a;
        if (l2Var == null) {
            this.a = l2.H((Context) r.m((Context) b.E(aVar)), zzclVar, Long.valueOf(j));
        } else {
            l2Var.d().w().a("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzcf zzcfVar) throws RemoteException {
        A();
        this.a.f().z(new c5(this, zzcfVar));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        A();
        this.a.I().s(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcfVar, long j) throws RemoteException {
        A();
        r.g(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.a.f().z(new J3(this, zzcfVar, new v(str2, new t(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, F4.a aVar, F4.a aVar2, F4.a aVar3) throws RemoteException {
        A();
        this.a.d().G(i, true, false, str, aVar == null ? null : b.E(aVar), aVar2 == null ? null : b.E(aVar2), aVar3 != null ? b.E(aVar3) : null);
    }

    public void onActivityCreated(F4.a aVar, Bundle bundle, long j) throws RemoteException {
        A();
        s3 s3Var = this.a.I().c;
        if (s3Var != null) {
            this.a.I().p();
            s3Var.onActivityCreated((Activity) b.E(aVar), bundle);
        }
    }

    public void onActivityDestroyed(F4.a aVar, long j) throws RemoteException {
        A();
        s3 s3Var = this.a.I().c;
        if (s3Var != null) {
            this.a.I().p();
            s3Var.onActivityDestroyed((Activity) b.E(aVar));
        }
    }

    public void onActivityPaused(F4.a aVar, long j) throws RemoteException {
        A();
        s3 s3Var = this.a.I().c;
        if (s3Var != null) {
            this.a.I().p();
            s3Var.onActivityPaused((Activity) b.E(aVar));
        }
    }

    public void onActivityResumed(F4.a aVar, long j) throws RemoteException {
        A();
        s3 s3Var = this.a.I().c;
        if (s3Var != null) {
            this.a.I().p();
            s3Var.onActivityResumed((Activity) b.E(aVar));
        }
    }

    public void onActivitySaveInstanceState(F4.a aVar, zzcf zzcfVar, long j) throws RemoteException {
        A();
        s3 s3Var = this.a.I().c;
        Bundle bundle = new Bundle();
        if (s3Var != null) {
            this.a.I().p();
            s3Var.onActivitySaveInstanceState((Activity) b.E(aVar), bundle);
        }
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            this.a.d().w().b("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(F4.a aVar, long j) throws RemoteException {
        A();
        if (this.a.I().c != null) {
            this.a.I().p();
        }
    }

    public void onActivityStopped(F4.a aVar, long j) throws RemoteException {
        A();
        if (this.a.I().c != null) {
            this.a.I().p();
        }
    }

    public void performAction(Bundle bundle, zzcf zzcfVar, long j) throws RemoteException {
        A();
        zzcfVar.zze(null);
    }

    public void registerOnMeasurementEventListener(zzci zzciVar) throws RemoteException {
        P2 p2;
        A();
        synchronized (this.c) {
            try {
                p2 = (P2) this.c.get(Integer.valueOf(zzciVar.zzd()));
                if (p2 == null) {
                    p2 = new e5(this, zzciVar);
                    this.c.put(Integer.valueOf(zzciVar.zzd()), p2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.I().x(p2);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        A();
        this.a.I().y(j);
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        A();
        if (bundle == null) {
            this.a.d().r().a("Conditional user property must not be null");
        } else {
            this.a.I().E(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) throws RemoteException {
        A();
        t3 I = this.a.I();
        I.a.f().A(new S2(I, bundle, j));
    }

    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        A();
        this.a.I().G(bundle, -20, j);
    }

    public void setCurrentScreen(F4.a aVar, String str, String str2, long j) throws RemoteException {
        A();
        this.a.K().D((Activity) b.E(aVar), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        A();
        t3 I = this.a.I();
        I.i();
        I.a.f().z(new q3(I, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        A();
        t3 I = this.a.I();
        I.a.f().z(new T2(I, bundle == null ? null : new Bundle(bundle)));
    }

    public void setEventInterceptor(zzci zzciVar) throws RemoteException {
        A();
        d5 d5Var = new d5(this, zzciVar);
        if (this.a.f().C()) {
            this.a.I().H(d5Var);
        } else {
            this.a.f().z(new K4(this, d5Var));
        }
    }

    public void setInstanceIdProvider(zzck zzckVar) throws RemoteException {
        A();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        A();
        this.a.I().I(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        A();
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        A();
        t3 I = this.a.I();
        I.a.f().z(new X2(I, j));
    }

    public void setUserId(String str, long j) throws RemoteException {
        A();
        t3 I = this.a.I();
        if (str != null && TextUtils.isEmpty(str)) {
            I.a.d().w().a("User ID must be non-empty or null");
        } else {
            I.a.f().z(new U2(I, str));
            I.L(null, "_id", str, true, j);
        }
    }

    public void setUserProperty(String str, String str2, F4.a aVar, boolean z, long j) throws RemoteException {
        A();
        this.a.I().L(str, str2, b.E(aVar), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzci zzciVar) throws RemoteException {
        P2 p2;
        A();
        synchronized (this.c) {
            p2 = (P2) this.c.remove(Integer.valueOf(zzciVar.zzd()));
        }
        if (p2 == null) {
            p2 = new e5(this, zzciVar);
        }
        this.a.I().N(p2);
    }
}
