package com.google.android.gms.internal.cast;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o4.c;
import t4.H;
import t4.b;
import u0.K;
import u0.L;
import u0.h0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbf extends zzak {
    private static final b zza = new b("MediaRouterProxy");
    private final L zzb;
    private final c zzc;
    private final Map zzd = new HashMap();
    private zzbm zze;
    private boolean zzf;

    public zzbf(Context context, L l, c cVar, H h) {
        this.zzb = l;
        this.zzc = cVar;
        if (Build.VERSION.SDK_INT <= 32) {
            zza.e("Don't need to set MediaRouterParams for Android S v2 or below", new Object[0]);
            return;
        }
        zza.a("Set up MediaRouterParams based on module flag and CastOptions for Android T or above", new Object[0]);
        this.zze = new zzbm(cVar);
        Intent intent = new Intent(context, h0.class);
        intent.setPackage(context.getPackageName());
        boolean z = !context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
        this.zzf = z;
        if (z) {
            zzr.zzd(zzln.zzJ);
        }
        h.h(new String[]{"com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"}).addOnCompleteListener(new zzbd(this, cVar));
    }

    private final void zzt(K k, int i) {
        Set set = (Set) this.zzd.get(k);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.zzb.b(k, (L.a) it.next(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final void zzq(K k) {
        Set set = (Set) this.zzd.get(k);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.zzb.s((L.a) it.next());
        }
    }

    public final Bundle zzb(String str) {
        for (L.h hVar : this.zzb.m()) {
            if (hVar.k().equals(str)) {
                return hVar.i();
            }
        }
        return null;
    }

    public final String zzc() {
        return this.zzb.n().k();
    }

    public final void zzd(Bundle bundle, int i) {
        K d = K.d(bundle);
        if (d == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzt(d, i);
        } else {
            new zzdy(Looper.getMainLooper()).post(new zzbc(this, d, i));
        }
    }

    public final void zze(Bundle bundle, zzan zzanVar) {
        K d = K.d(bundle);
        if (d == null) {
            return;
        }
        if (!this.zzd.containsKey(d)) {
            this.zzd.put(d, new HashSet());
        }
        ((Set) this.zzd.get(d)).add(new zzas(zzanVar));
    }

    public final void zzf() {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Set) it.next()).iterator();
            while (it2.hasNext()) {
                this.zzb.s((L.a) it2.next());
            }
        }
        this.zzd.clear();
    }

    public final void zzg(Bundle bundle) {
        K d = K.d(bundle);
        if (d == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzq(d);
        } else {
            new zzdy(Looper.getMainLooper()).post(new zzbe(this, d));
        }
    }

    public final void zzh() {
        L l = this.zzb;
        l.u(l.g());
    }

    public final void zzi(String str) {
        zza.a("select route with routeId = %s", str);
        for (L.h hVar : this.zzb.m()) {
            if (hVar.k().equals(str)) {
                zza.a("media route is found and selected", new Object[0]);
                this.zzb.u(hVar);
                return;
            }
        }
    }

    public final void zzj(int i) {
        this.zzb.z(i);
    }

    public final boolean zzk() {
        L.h f = this.zzb.f();
        return f != null && this.zzb.n().k().equals(f.k());
    }

    public final boolean zzl() {
        L.h g = this.zzb.g();
        return g != null && this.zzb.n().k().equals(g.k());
    }

    public final boolean zzm(Bundle bundle, int i) {
        K d = K.d(bundle);
        if (d == null) {
            return false;
        }
        return this.zzb.q(d, i);
    }

    public final zzbm zzn() {
        return this.zze;
    }

    public final /* synthetic */ void zzo(K k, int i) {
        synchronized (this.zzd) {
            zzt(k, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zzp(o4.c r9, com.google.android.gms.tasks.Task r10) {
        /*
            r8 = this;
            r0 = 2
            boolean r1 = r10.isSuccessful()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L35
            java.lang.Object r10 = r10.getResult()
            android.os.Bundle r10 = (android.os.Bundle) r10
            java.lang.String r1 = "com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"
            if (r10 == 0) goto L1b
            boolean r4 = r10.containsKey(r1)
            if (r4 == 0) goto L1b
            r4 = 1
            goto L1c
        L1b:
            r4 = 0
        L1c:
            t4.b r5 = com.google.android.gms.internal.cast.zzbf.zza
            if (r3 == r4) goto L23
            java.lang.String r6 = "not existed"
            goto L25
        L23:
            java.lang.String r6 = "existed"
        L25:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r7[r2] = r6
            java.lang.String r6 = "The module-to-client output switcher flag %s"
            r5.a(r6, r7)
            if (r4 == 0) goto L35
            boolean r10 = r10.getBoolean(r1)
            goto L36
        L35:
            r10 = 1
        L36:
            t4.b r1 = com.google.android.gms.internal.cast.zzbf.zza
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r10)
            boolean r5 = r9.T()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r6[r2] = r4
            r6[r3] = r5
            java.lang.String r4 = "Set up output switcher flags: %b (from module), %b (from CastOptions)"
            r1.e(r4, r6)
            if (r10 == 0) goto L59
            boolean r9 = r9.T()
            if (r9 == 0) goto L59
            r9 = 1
            goto L5a
        L59:
            r9 = 0
        L5a:
            u0.L r10 = r8.zzb
            if (r10 == 0) goto Lbf
            o4.c r4 = r8.zzc
            if (r4 != 0) goto L63
            goto Lbf
        L63:
            boolean r5 = r4.S()
            boolean r4 = r4.Q()
            u0.g0$a r6 = new u0.g0$a
            r6.<init>()
            u0.g0$a r6 = r6.b(r9)
            u0.g0$a r6 = r6.d(r5)
            u0.g0$a r6 = r6.c(r4)
            u0.g0 r6 = r6.a()
            r10.x(r6)
            boolean r10 = r8.zzf
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r2] = r10
            r7[r3] = r9
            r7[r0] = r6
            r9 = 3
            r7[r9] = r4
            java.lang.String r9 = "media transfer = %b, session transfer = %b, transfer to local = %b, in-app output switcher = %b"
            r1.e(r9, r7)
            if (r5 == 0) goto Lbf
            u0.L r9 = r8.zzb
            com.google.android.gms.internal.cast.zzbb r10 = new com.google.android.gms.internal.cast.zzbb
            com.google.android.gms.internal.cast.zzbm r0 = r8.zze
            java.lang.Object r0 = com.google.android.gms.common.internal.r.m(r0)
            com.google.android.gms.internal.cast.zzbm r0 = (com.google.android.gms.internal.cast.zzbm) r0
            r10.<init>(r0)
            r9.w(r10)
            com.google.android.gms.internal.cast.zzln r9 = com.google.android.gms.internal.cast.zzln.zzK
            com.google.android.gms.internal.cast.zzr.zzd(r9)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzbf.zzp(o4.c, com.google.android.gms.tasks.Task):void");
    }

    public final void zzr(MediaSessionCompat mediaSessionCompat) {
        this.zzb.v(mediaSessionCompat);
    }

    public final boolean zzs() {
        return this.zzf;
    }
}
