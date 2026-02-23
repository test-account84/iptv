package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzsb {
    private static final zzsb zzb = new zzsb(true);
    final zzun zza = new zzud(16);
    private boolean zzc;
    private boolean zzd;

    private zzsb() {
    }

    public static zzsb zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.cast.zzsa r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.cast.zzvg r0 = r4.zzb()
            byte[] r1 = com.google.android.gms.internal.cast.zzsq.zzd
            r5.getClass()
            com.google.android.gms.internal.cast.zzvg r1 = com.google.android.gms.internal.cast.zzvg.zza
            com.google.android.gms.internal.cast.zzvh r1 = com.google.android.gms.internal.cast.zzvh.zza
            com.google.android.gms.internal.cast.zzvh r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zztp
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzsu
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzsj
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzrm
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.cast.zzvg r4 = r4.zzb()
            com.google.android.gms.internal.cast.zzvh r4 = r4.zza()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r4
            r4 = 2
            r2[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzsb.zzd(com.google.android.gms.internal.cast.zzsa, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzsb zzsbVar = new zzsb();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzsbVar.zzc((zzsa) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzsbVar.zzc((zzsa) entry.getKey(), entry.getValue());
        }
        zzsbVar.zzd = this.zzd;
        return zzsbVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzsb) {
            return this.zza.equals(((zzsb) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            if (zzg.getValue() instanceof zzsh) {
                ((zzsh) zzg.getValue()).zzE();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzsa zzsaVar, Object obj) {
        if (!zzsaVar.zzc()) {
            zzd(zzsaVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzsaVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzsu) {
            this.zzd = true;
        }
        this.zza.zze(zzsaVar, obj);
    }

    private zzsb(boolean z) {
        zzb();
        zzb();
    }
}
