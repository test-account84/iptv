package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.util.VisibleForTesting;
import d.D;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n4.f;
import t4.b;
import u0.K;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzay extends L.a {
    private static final b zzb = new b("MRDiscoveryCallback");
    private final zzax zzf;
    private final Map zzd = DesugarCollections.synchronizedMap(new HashMap());
    private final LinkedHashSet zze = new LinkedHashSet();
    private final Set zzc = Collections.synchronizedSet(new LinkedHashSet());
    public final zzaw zza = new zzaw(this);

    public zzay(Context context) {
        this.zzf = new zzax(context);
    }

    public final void onRouteAdded(L l, L.h hVar) {
        zzb.a("MediaRouterDiscoveryCallback.onRouteAdded.", new Object[0]);
        zzf(hVar, true);
    }

    public final void onRouteChanged(L l, L.h hVar) {
        zzb.a("MediaRouterDiscoveryCallback.onRouteChanged.", new Object[0]);
        zzf(hVar, true);
    }

    public final void onRouteRemoved(L l, L.h hVar) {
        zzb.a("MediaRouterDiscoveryCallback.onRouteRemoved.", new Object[0]);
        zzf(hVar, false);
    }

    public final void zza(List list) {
        zzb.a("SetRouteDiscovery for " + list.size() + " IDs", new Object[0]);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(zzen.zza((String) it.next()));
        }
        zzb.a("resetting routes. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.zzd.keySet())), new Object[0]);
        HashMap hashMap = new HashMap();
        synchronized (this.zzd) {
            try {
                for (String str : linkedHashSet) {
                    zzav zzavVar = (zzav) this.zzd.get(zzen.zza(str));
                    if (zzavVar != null) {
                        hashMap.put(str, zzavVar);
                    }
                }
                this.zzd.clear();
                this.zzd.putAll(hashMap);
            } catch (Throwable th) {
                throw th;
            }
        }
        zzb.a("Routes reset. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.zzd.keySet())), new Object[0]);
        synchronized (this.zze) {
            this.zze.clear();
            this.zze.addAll(linkedHashSet);
        }
        zzb();
    }

    public final void zzb() {
        b bVar = zzb;
        bVar.a("Starting RouteDiscovery with " + this.zze.size() + " IDs", new Object[0]);
        bVar.a("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.zzd.keySet())), new Object[0]);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzc();
        } else {
            new zzdy(Looper.getMainLooper()).post(new zzau(this));
        }
    }

    public final void zzc() {
        this.zzf.zzb(this);
        synchronized (this.zze) {
            try {
                Iterator it = this.zze.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    K d = new K.a().b(f.a(str)).d();
                    if (((zzav) this.zzd.get(str)) == null) {
                        this.zzd.put(str, new zzav(d));
                    }
                    zzb.a("Adding mediaRouter callback for control category " + f.a(str), new Object[0]);
                    this.zzf.zza().b(d, this, 4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzb.a("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.zzd.keySet())), new Object[0]);
    }

    public final void zzd() {
        zzb.a("Stopping RouteDiscovery.", new Object[0]);
        this.zzd.clear();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zzf.zzb(this);
        } else {
            new zzdy(Looper.getMainLooper()).post(new zzat(this));
        }
    }

    public final void zze() {
        this.zzf.zzb(this);
    }

    @VisibleForTesting
    public final void zzf(L.h hVar, boolean z) {
        boolean z2;
        boolean remove;
        b bVar = zzb;
        bVar.a("MediaRouterDiscoveryCallback.updateRouteToAppIds (add=%b) route %s", Boolean.valueOf(z), hVar);
        synchronized (this.zzd) {
            try {
                bVar.a("appIdToRouteInfo has these appId route keys: " + String.valueOf(this.zzd.keySet()), new Object[0]);
                z2 = false;
                for (Map.Entry entry : this.zzd.entrySet()) {
                    String str = (String) entry.getKey();
                    zzav zzavVar = (zzav) entry.getValue();
                    if (hVar.E(zzavVar.zzb)) {
                        if (z) {
                            b bVar2 = zzb;
                            bVar2.a("Adding/updating route for appId " + str, new Object[0]);
                            remove = zzavVar.zza.add(hVar);
                            if (!remove) {
                                bVar2.f("Route " + String.valueOf(hVar) + " already exists for appId " + str, new Object[0]);
                            }
                        } else {
                            b bVar3 = zzb;
                            bVar3.a("Removing route for appId " + str, new Object[0]);
                            remove = zzavVar.zza.remove(hVar);
                            if (!remove) {
                                bVar3.f("Route " + String.valueOf(hVar) + " already removed from appId " + str, new Object[0]);
                            }
                        }
                        z2 = remove;
                    }
                }
            } finally {
            }
        }
        if (z2) {
            zzb.a("Invoking callback.onRouteUpdated.", new Object[0]);
            synchronized (this.zzc) {
                try {
                    HashMap hashMap = new HashMap();
                    synchronized (this.zzd) {
                        for (String str2 : this.zzd.keySet()) {
                            zzav zzavVar2 = (zzav) this.zzd.get(zzen.zza(str2));
                            zzfl zzk = zzavVar2 == null ? zzfl.zzk() : zzfl.zzj(zzavVar2.zza);
                            if (!zzk.isEmpty()) {
                                hashMap.put(str2, zzk);
                            }
                        }
                    }
                    zzfk.zzc(hashMap.entrySet());
                    Iterator it = this.zzc.iterator();
                    if (it.hasNext()) {
                        D.a(it.next());
                        throw null;
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
    }
}
