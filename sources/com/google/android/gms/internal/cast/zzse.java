package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzse extends zzqy {
    protected zzsh zza;
    private final zzsh zzb;

    public zzse(zzsh zzshVar) {
        this.zzb = zzshVar;
        if (zzshVar.zzJ()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = zzshVar.zzw();
    }

    private static void zza(Object obj, Object obj2) {
        zztx.zza().zzb(obj.getClass()).zze(obj, obj2);
    }

    /* renamed from: zzn, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzse zzm() {
        zzse zzseVar = (zzse) this.zzb.zzb(5, null, null);
        zzseVar.zza = zzr();
        return zzseVar;
    }

    public final zzse zzo(zzsh zzshVar) {
        if (!this.zzb.equals(zzshVar)) {
            if (!this.zza.zzJ()) {
                zzu();
            }
            zza(this.zza, zzshVar);
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if (r3 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.cast.zzsh zzp() {
        /*
            r5 = this;
            com.google.android.gms.internal.cast.zzsh r0 = r5.zzr()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.zzb(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L13
            goto L30
        L13:
            if (r3 == 0) goto L31
            com.google.android.gms.internal.cast.zztx r3 = com.google.android.gms.internal.cast.zztx.zza()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.cast.zzua r3 = r3.zzb(r4)
            boolean r3 = r3.zzh(r0)
            if (r1 == r3) goto L29
            r1 = r2
            goto L2a
        L29:
            r1 = r0
        L2a:
            r4 = 2
            r0.zzb(r4, r1, r2)
            if (r3 == 0) goto L31
        L30:
            return r0
        L31:
            com.google.android.gms.internal.cast.zzuq r1 = new com.google.android.gms.internal.cast.zzuq
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzse.zzp():com.google.android.gms.internal.cast.zzsh");
    }

    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzsh zzr() {
        if (!this.zza.zzJ()) {
            return this.zza;
        }
        this.zza.zzE();
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ zztp zzs() {
        throw null;
    }

    public final void zzt() {
        if (this.zza.zzJ()) {
            return;
        }
        zzu();
    }

    public void zzu() {
        zzsh zzw = this.zzb.zzw();
        zza(zzw, this.zza);
        this.zza = zzw;
    }
}
