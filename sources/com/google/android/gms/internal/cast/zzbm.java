package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.internal.r;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import n4.s;
import o4.A;
import o4.c;
import o4.e;
import o4.x;
import p4.i;
import t.c;
import t4.b;
import u0.L;

@TargetApi(30)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbm {
    private static final b zza = new b("SessionTransController");
    private final c zzb;
    private x zzg;
    private c.a zzh;
    private s zzi;
    private final Set zzc = Collections.synchronizedSet(new HashSet());
    private int zzf = 0;
    private final Handler zzd = new zzdy(Looper.getMainLooper());
    private final Runnable zze = new zzbh(this);

    public zzbm(o4.c cVar) {
        this.zzb = cVar;
    }

    public static /* bridge */ /* synthetic */ int zza(zzbm zzbmVar) {
        return zzbmVar.zzf;
    }

    public static /* bridge */ /* synthetic */ o4.c zzb(zzbm zzbmVar) {
        return zzbmVar.zzb;
    }

    public static /* bridge */ /* synthetic */ b zzc() {
        return zza;
    }

    public static /* synthetic */ void zzd(zzbm zzbmVar, s sVar) {
        zzbmVar.zzi = sVar;
        c.a aVar = zzbmVar.zzh;
        if (aVar != null) {
            aVar.b((Object) null);
        }
    }

    public static /* synthetic */ void zze(zzbm zzbmVar) {
        zza.e("transfer with type = %d has timed out", Integer.valueOf(zzbmVar.zzf));
        zzbmVar.zzp(101);
    }

    public static /* synthetic */ void zzf(zzbm zzbmVar) {
        ((x) r.m(zzbmVar.zzg)).a(new zzbl(zzbmVar, null), e.class);
    }

    public static /* bridge */ /* synthetic */ void zzg(zzbm zzbmVar) {
        int i = zzbmVar.zzf;
        if (i == 0) {
            zza.a("No need to notify transferred if the transfer type is unknown", new Object[0]);
            return;
        }
        s sVar = zzbmVar.zzi;
        if (sVar == null) {
            zza.a("No need to notify with null sessionState", new Object[0]);
            return;
        }
        zza.a("notify transferred with type = %d, sessionState = %s", Integer.valueOf(i), zzbmVar.zzi);
        Iterator it = new HashSet(zzbmVar.zzc).iterator();
        while (it.hasNext()) {
            ((A) it.next()).onTransferred(zzbmVar.zzf, sVar);
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(zzbm zzbmVar) {
        zzbmVar.zzq();
    }

    public static /* bridge */ /* synthetic */ void zzi(zzbm zzbmVar) {
        if (zzbmVar.zzi == null) {
            zza.a("skip restoring session state due to null SessionState", new Object[0]);
            return;
        }
        i zzo = zzbmVar.zzo();
        if (zzo == null) {
            zza.a("skip restoring session state due to null RemoteMediaClient", new Object[0]);
        } else {
            zza.a("resume SessionState to current session", new Object[0]);
            zzo.m0(zzbmVar.zzi);
        }
    }

    private final i zzo() {
        x xVar = this.zzg;
        if (xVar == null) {
            zza.a("skip transferring as SessionManager is null", new Object[0]);
            return null;
        }
        e c = xVar.c();
        if (c != null) {
            return c.r();
        }
        zza.a("skip transferring as CastSession is null", new Object[0]);
        return null;
    }

    private final void zzp(int i) {
        c.a aVar = this.zzh;
        if (aVar != null) {
            aVar.c();
        }
        zza.a("notify failed transfer with type = %d, reason = %d", Integer.valueOf(this.zzf), Integer.valueOf(i));
        Iterator it = new HashSet(this.zzc).iterator();
        while (it.hasNext()) {
            ((A) it.next()).onTransferFailed(this.zzf, i);
        }
        zzq();
    }

    private final void zzq() {
        ((Handler) r.m(this.zzd)).removeCallbacks((Runnable) r.m(this.zze));
        this.zzf = 0;
        this.zzi = null;
    }

    public final void zzj(x xVar) {
        this.zzg = xVar;
        ((Handler) r.m(this.zzd)).post(new zzbg(this));
    }

    public final /* synthetic */ void zzk(Exception exc) {
        zza.g(exc, "Fail to store SessionState", new Object[0]);
        zzp(100);
    }

    public final void zzl(L.h hVar, L.h hVar2, c.a aVar) {
        int i;
        if (new HashSet(this.zzc).isEmpty()) {
            zza.a("No need to prepare transfer without any callback", new Object[0]);
            aVar.b((Object) null);
            return;
        }
        if (hVar.o() != 1) {
            zza.a("No need to prepare transfer when transferring from local", new Object[0]);
            aVar.b((Object) null);
            return;
        }
        i zzo = zzo();
        if (zzo == null || !zzo.q()) {
            zza.a("No need to prepare transfer when there is no media session", new Object[0]);
            aVar.b((Object) null);
            return;
        }
        b bVar = zza;
        bVar.a("Prepare route transfer for changing endpoint", new Object[0]);
        if (hVar2.o() == 0) {
            zzr.zzd(zzln.zzP);
            i = 1;
        } else {
            i = CastDevice.K(hVar2.i()) == null ? 3 : 2;
        }
        this.zzf = i;
        this.zzh = aVar;
        bVar.a("notify transferring with type = %d", Integer.valueOf(i));
        Iterator it = new HashSet(this.zzc).iterator();
        while (it.hasNext()) {
            ((A) it.next()).onTransferring(this.zzf);
        }
        this.zzi = null;
        zzo.g0(null).addOnSuccessListener(new zzbi(this)).addOnFailureListener(new zzbj(this));
        ((Handler) r.m(this.zzd)).postDelayed((Runnable) r.m(this.zze), 10000L);
    }

    public final void zzm(A a) {
        zza.a("register callback = %s", a);
        r.f("Must be called from the main thread.");
        r.m(a);
        this.zzc.add(a);
    }

    public final void zzn(A a) {
        zza.a("unregister callback = %s", a);
        r.f("Must be called from the main thread.");
        if (a != null) {
            this.zzc.remove(a);
        }
    }
}
