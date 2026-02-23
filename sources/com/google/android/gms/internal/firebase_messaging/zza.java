package com.google.android.gms.internal.firebase_messaging;

import c6.d;
import c6.e;
import c6.f;
import java.io.IOException;
import r6.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zza implements e {
    static final zza zza = new zza();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;
    private static final d zzh;
    private static final d zzi;
    private static final d zzj;
    private static final d zzk;
    private static final d zzl;
    private static final d zzm;
    private static final d zzn;
    private static final d zzo;
    private static final d zzp;

    static {
        d.b a = d.a("projectNumber");
        zzo zzoVar = new zzo();
        zzoVar.zza(1);
        zzb = a.b(zzoVar.zzb()).a();
        d.b a2 = d.a("messageId");
        zzo zzoVar2 = new zzo();
        zzoVar2.zza(2);
        zzc = a2.b(zzoVar2.zzb()).a();
        d.b a3 = d.a("instanceId");
        zzo zzoVar3 = new zzo();
        zzoVar3.zza(3);
        zzd = a3.b(zzoVar3.zzb()).a();
        d.b a4 = d.a("messageType");
        zzo zzoVar4 = new zzo();
        zzoVar4.zza(4);
        zze = a4.b(zzoVar4.zzb()).a();
        d.b a5 = d.a("sdkPlatform");
        zzo zzoVar5 = new zzo();
        zzoVar5.zza(5);
        zzf = a5.b(zzoVar5.zzb()).a();
        d.b a6 = d.a("packageName");
        zzo zzoVar6 = new zzo();
        zzoVar6.zza(6);
        zzg = a6.b(zzoVar6.zzb()).a();
        d.b a7 = d.a("collapseKey");
        zzo zzoVar7 = new zzo();
        zzoVar7.zza(7);
        zzh = a7.b(zzoVar7.zzb()).a();
        d.b a8 = d.a("priority");
        zzo zzoVar8 = new zzo();
        zzoVar8.zza(8);
        zzi = a8.b(zzoVar8.zzb()).a();
        d.b a9 = d.a("ttl");
        zzo zzoVar9 = new zzo();
        zzoVar9.zza(9);
        zzj = a9.b(zzoVar9.zzb()).a();
        d.b a10 = d.a("topic");
        zzo zzoVar10 = new zzo();
        zzoVar10.zza(10);
        zzk = a10.b(zzoVar10.zzb()).a();
        d.b a11 = d.a("bulkId");
        zzo zzoVar11 = new zzo();
        zzoVar11.zza(11);
        zzl = a11.b(zzoVar11.zzb()).a();
        d.b a12 = d.a("event");
        zzo zzoVar12 = new zzo();
        zzoVar12.zza(12);
        zzm = a12.b(zzoVar12.zzb()).a();
        d.b a13 = d.a("analyticsLabel");
        zzo zzoVar13 = new zzo();
        zzoVar13.zza(13);
        zzn = a13.b(zzoVar13.zzb()).a();
        d.b a14 = d.a("campaignId");
        zzo zzoVar14 = new zzo();
        zzoVar14.zza(14);
        zzo = a14.b(zzoVar14.zzb()).a();
        d.b a15 = d.a("composerLabel");
        zzo zzoVar15 = new zzo();
        zzoVar15.zza(15);
        zzp = a15.b(zzoVar15.zzb()).a();
    }

    private zza() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        a aVar = (a) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, aVar.l());
        fVar.add(zzc, aVar.h());
        fVar.add(zzd, aVar.g());
        fVar.add(zze, aVar.i());
        fVar.add(zzf, aVar.m());
        fVar.add(zzg, aVar.j());
        fVar.add(zzh, aVar.d());
        fVar.add(zzi, aVar.k());
        fVar.add(zzj, aVar.o());
        fVar.add(zzk, aVar.n());
        fVar.add(zzl, aVar.b());
        fVar.add(zzm, aVar.f());
        fVar.add(zzn, aVar.a());
        fVar.add(zzo, aVar.c());
        fVar.add(zzp, aVar.e());
    }
}
