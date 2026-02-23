package com.google.android.gms.internal.cast;

import X0.e;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.VisibleForTesting;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import t4.b;
import t4.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdc implements zzcz {
    private static final b zzb = new b("ConnectivityMonitor");
    private final zzqp zzc;
    private final ConnectivityManager zze;
    private boolean zzh;
    private final Context zzi;
    private final Object zzj = new Object();

    @VisibleForTesting
    public final Set zza = Collections.synchronizedSet(new HashSet());
    private final Map zzf = DesugarCollections.synchronizedMap(new HashMap());
    private final List zzg = Collections.synchronizedList(new ArrayList());
    private final ConnectivityManager.NetworkCallback zzd = new zzdb(this);

    @TargetApi(23)
    public zzdc(Context context, zzqp zzqpVar) {
        this.zzc = zzqpVar;
        this.zzi = context;
        this.zze = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static /* bridge */ /* synthetic */ void zzc(zzdc zzdcVar, Network network, LinkProperties linkProperties) {
        zzdcVar.zzg(network, linkProperties);
    }

    public static /* bridge */ /* synthetic */ void zzd(zzdc zzdcVar) {
        synchronized (r.m(zzdcVar.zzj)) {
            if (zzdcVar.zzf != null && zzdcVar.zzg != null) {
                zzb.a("all networks are unavailable.", new Object[0]);
                zzdcVar.zzf.clear();
                zzdcVar.zzg.clear();
                zzdcVar.zzh();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void zze(zzdc zzdcVar, Network network) {
        synchronized (r.m(zzdcVar.zzj)) {
            try {
                if (zzdcVar.zzf != null && zzdcVar.zzg != null) {
                    zzb.a("the network is lost", new Object[0]);
                    if (zzdcVar.zzg.remove(network)) {
                        zzdcVar.zzf.remove(network);
                    }
                    zzdcVar.zzh();
                }
            } finally {
            }
        }
    }

    private final void zzg(Network network, LinkProperties linkProperties) {
        synchronized (r.m(this.zzj)) {
            try {
                if (this.zzf != null && this.zzg != null) {
                    zzb.a("a new network is available", new Object[0]);
                    if (this.zzf.containsKey(network)) {
                        this.zzg.remove(network);
                    }
                    this.zzf.put(network, linkProperties);
                    this.zzg.add(network);
                    zzh();
                }
            } finally {
            }
        }
    }

    private final void zzh() {
        if (this.zzc == null) {
            return;
        }
        synchronized (this.zza) {
            try {
                for (zzcy zzcyVar : this.zza) {
                    if (!this.zzc.isShutdown()) {
                        this.zzc.execute(new zzda(this, zzcyVar));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @TargetApi(23)
    public final void zza() {
        LinkProperties linkProperties;
        zzb.a("Start monitoring connectivity changes", new Object[0]);
        if (this.zzh || this.zze == null || !u.a(this.zzi)) {
            return;
        }
        Network a = e.a(this.zze);
        if (a != null && (linkProperties = this.zze.getLinkProperties(a)) != null) {
            zzg(a, linkProperties);
        }
        this.zze.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), this.zzd);
        this.zzh = true;
    }

    public final boolean zzb() {
        NetworkInfo activeNetworkInfo;
        return this.zze != null && u.a(this.zzi) && (activeNetworkInfo = this.zze.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected();
    }

    public final boolean zzf() {
        List list = this.zzg;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
