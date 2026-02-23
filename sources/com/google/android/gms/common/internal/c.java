package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private w4.b zzB;
    private boolean zzC;
    private volatile k0 zzD;
    v0 zza;
    final Handler zzb;
    protected c zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final i zzn;
    private final w4.i zzo;
    private final Object zzp;
    private final Object zzq;
    private n zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private f0 zzu;
    private int zzv;
    private final a zzw;
    private final b zzx;
    private final int zzy;
    private final String zzz;
    private static final w4.d[] zze = new w4.d[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    public interface a {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface b {
        void onConnectionFailed(w4.b bVar);
    }

    public interface c {
        void c(w4.b bVar);
    }

    public class d implements c {
        public d() {
        }

        public final void c(w4.b bVar) {
            if (bVar.L()) {
                c cVar = c.this;
                cVar.getRemoteService(null, cVar.getScopes());
            } else if (c.zzc(c.this) != null) {
                c.zzc(c.this).onConnectionFailed(bVar);
            }
        }
    }

    public interface e {
        void a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context, Looper looper, int i, a aVar, b bVar, String str) {
        i a2 = i.a(context);
        w4.i h = w4.i.h();
        r.m(aVar);
        r.m(bVar);
        this(context, looper, a2, h, i, aVar, bVar, str);
    }

    public static /* bridge */ /* synthetic */ w4.b zza(c cVar) {
        return cVar.zzB;
    }

    public static /* bridge */ /* synthetic */ a zzb(c cVar) {
        return cVar.zzw;
    }

    public static /* bridge */ /* synthetic */ b zzc(c cVar) {
        return cVar.zzx;
    }

    public static /* bridge */ /* synthetic */ Object zzd(c cVar) {
        return cVar.zzq;
    }

    public static /* bridge */ /* synthetic */ ArrayList zzf(c cVar) {
        return cVar.zzt;
    }

    public static /* bridge */ /* synthetic */ void zzg(c cVar, w4.b bVar) {
        cVar.zzB = bVar;
    }

    public static /* bridge */ /* synthetic */ void zzh(c cVar, n nVar) {
        cVar.zzr = nVar;
    }

    public static /* bridge */ /* synthetic */ void zzi(c cVar, int i, IInterface iInterface) {
        cVar.a(i, null);
    }

    public static /* bridge */ /* synthetic */ void zzj(c cVar, k0 k0Var) {
        cVar.zzD = k0Var;
        if (cVar.usesClientTelemetry()) {
            f fVar = k0Var.i;
            s.b().c(fVar == null ? null : fVar.M());
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(c cVar, int i) {
        int i2;
        int i3;
        synchronized (cVar.zzp) {
            i2 = cVar.zzv;
        }
        if (i2 == 3) {
            cVar.zzC = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = cVar.zzb;
        handler.sendMessage(handler.obtainMessage(i3, cVar.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzm(c cVar) {
        return cVar.zzC;
    }

    public static /* bridge */ /* synthetic */ boolean zzn(c cVar, int i, int i2, IInterface iInterface) {
        synchronized (cVar.zzp) {
            try {
                if (cVar.zzv != i) {
                    return false;
                }
                cVar.a(i2, iInterface);
                return true;
            } finally {
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzo(c cVar) {
        if (cVar.zzC || TextUtils.isEmpty(cVar.getServiceDescriptor()) || TextUtils.isEmpty(cVar.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(cVar.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void a(int i, IInterface iInterface) {
        v0 v0Var;
        r.a((i == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i;
                this.zzs = iInterface;
                if (i == 1) {
                    f0 f0Var = this.zzu;
                    if (f0Var != null) {
                        i iVar = this.zzn;
                        String b2 = this.zza.b();
                        r.m(b2);
                        iVar.d(b2, this.zza.a(), 4225, f0Var, zze(), this.zza.c());
                        this.zzu = null;
                    }
                } else if (i == 2 || i == 3) {
                    f0 f0Var2 = this.zzu;
                    if (f0Var2 != null && (v0Var = this.zza) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + v0Var.b() + " on " + v0Var.a());
                        i iVar2 = this.zzn;
                        String b3 = this.zza.b();
                        r.m(b3);
                        iVar2.d(b3, this.zza.a(), 4225, f0Var2, zze(), this.zza.c());
                        this.zzd.incrementAndGet();
                    }
                    f0 f0Var3 = new f0(this, this.zzd.get());
                    this.zzu = f0Var3;
                    v0 v0Var2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new v0(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new v0(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = v0Var2;
                    if (v0Var2.c() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.b())));
                    }
                    i iVar3 = this.zzn;
                    String b4 = this.zza.b();
                    r.m(b4);
                    if (!iVar3.e(new o0(b4, this.zza.a(), 4225, this.zza.c()), f0Var3, zze(), getBindServiceExecutor())) {
                        Log.w("GmsClient", "unable to connect to service: " + this.zza.b() + " on " + this.zza.a());
                        zzl(16, null, this.zzd.get());
                    }
                } else if (i == 4) {
                    r.m(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int j = this.zzo.j(this.zzl, getMinApkVersion());
        if (j == 0) {
            connect(new d());
        } else {
            a(1, null);
            triggerNotAvailable(new d(), j, null);
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(c cVar) {
        r.n(cVar, "Connection progress callbacks cannot be null.");
        this.zzc = cVar;
        a(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i = 0; i < size; i++) {
                    ((d0) this.zzt.get(i)).d();
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        a(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        n nVar;
        synchronized (this.zzp) {
            i = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            nVar = this.zzr;
        }
        printWriter.append(str).append("mConnectState=");
        printWriter.print(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (nVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(nVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.zzh;
            append.println(j + " " + simpleDateFormat.format(new Date(j)));
        }
        if (this.zzg > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i2 = this.zzf;
            printWriter.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? String.valueOf(i2) : "CAUSE_DEAD_OBJECT_EXCEPTION" : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED");
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzg;
            append2.println(j2 + " " + simpleDateFormat.format(new Date(j2)));
        }
        if (this.zzj > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(com.google.android.gms.common.api.c.a(this.zzi));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzj;
            append3.println(j3 + " " + simpleDateFormat.format(new Date(j3)));
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public w4.d[] getApiFeatures() {
        return zze;
    }

    public final w4.d[] getAvailableFeatures() {
        k0 k0Var = this.zzD;
        if (k0Var == null) {
            return null;
        }
        return k0Var.g;
    }

    public Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        v0 v0Var;
        if (!isConnected() || (v0Var = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return v0Var.a();
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return w4.i.a;
    }

    public void getRemoteService(k kVar, Set set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = this.zzA;
        int i = w4.i.a;
        Scope[] scopeArr = g.t;
        Bundle bundle = new Bundle();
        int i2 = this.zzy;
        w4.d[] dVarArr = g.u;
        g gVar = new g(6, i2, i, null, null, scopeArr, bundle, null, dVarArr, dVarArr, true, 0, false, str);
        gVar.i = this.zzl.getPackageName();
        gVar.l = getServiceRequestExtraArgs;
        if (set != null) {
            gVar.k = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            gVar.m = account;
            if (kVar != null) {
                gVar.j = kVar.asBinder();
            }
        } else if (requiresAccount()) {
            gVar.m = getAccount();
        }
        gVar.n = zze;
        gVar.o = getApiFeatures();
        if (usesClientTelemetry()) {
            gVar.r = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    n nVar = this.zzr;
                    if (nVar != null) {
                        nVar.i0(new e0(this, this.zzd.get()), gVar);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (DeadObjectException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            triggerConnectionSuspended(3);
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    public Set getScopes() {
        return Collections.emptySet();
    }

    public final IInterface getService() throws DeadObjectException {
        IInterface iInterface;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                iInterface = this.zzs;
                r.n(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                n nVar = this.zzr;
                if (nVar == null) {
                    return null;
                }
                return nVar.asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public abstract String getStartServiceAction();

    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public f getTelemetryConfiguration() {
        k0 k0Var = this.zzD;
        if (k0Var == null) {
            return null;
        }
        return k0Var.i;
    }

    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    public void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(w4.b bVar) {
        this.zzi = bVar.H();
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i) {
        this.zzf = i;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i2, -1, new g0(this, i, iBinder, bundle)));
    }

    public void onUserSignOut(e eVar) {
        eVar.a();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i));
    }

    public void triggerNotAvailable(c cVar, int i, PendingIntent pendingIntent) {
        r.n(cVar, "Connection progress callbacks cannot be null.");
        this.zzc = cVar;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzl(int i, Bundle bundle, int i2) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i2, -1, new h0(this, i, null)));
    }

    public c(Context context, Looper looper, i iVar, w4.i iVar2, int i, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        r.n(context, "Context must not be null");
        this.zzl = context;
        r.n(looper, "Looper must not be null");
        this.zzm = looper;
        r.n(iVar, "Supervisor must not be null");
        this.zzn = iVar;
        r.n(iVar2, "API availability must not be null");
        this.zzo = iVar2;
        this.zzb = new c0(this, looper);
        this.zzy = i;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }
}
