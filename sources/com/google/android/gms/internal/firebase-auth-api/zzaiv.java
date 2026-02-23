package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaiv {
    private static final zzaiv zzb = new zzaiv(true);
    final zzalg zza;
    private boolean zzc;
    private boolean zzd;

    private zzaiv() {
        this.zza = zzalg.zza(16);
    }

    public static zzaiv zzb() {
        return zzb;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzaiv zzaivVar = new zzaiv();
        for (int i = 0; i < this.zza.zza(); i++) {
            Map.Entry zzb2 = this.zza.zzb(i);
            zzaivVar.zzb((zzaix) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry entry : this.zza.zzb()) {
            zzaivVar.zzb((zzaix) entry.getKey(), entry.getValue());
        }
        zzaivVar.zzd = this.zzd;
        return zzaivVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaiv) {
            return this.zza.equals(((zzaiv) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zza() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zza(); i2++) {
            i += zza(this.zza.zzb(i2));
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            i += zza((Map.Entry) it.next());
        }
        return i;
    }

    public final Iterator zzc() {
        return this.zzd ? new zzajo(this.zza.zzc().iterator()) : this.zza.zzc().iterator();
    }

    public final Iterator zzd() {
        return this.zzd ? new zzajo(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zza(); i++) {
            Map.Entry zzb2 = this.zza.zzb(i);
            if (zzb2.getValue() instanceof zzajc) {
                ((zzajc) zzb2.getValue()).zzs();
            }
        }
        this.zza.zzd();
        this.zzc = true;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        for (int i = 0; i < this.zza.zza(); i++) {
            if (!zzc(this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            if (!zzc((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzaiv(zzalg zzalgVar) {
        this.zza = zzalgVar;
        zze();
    }

    public static int zza(zzaix zzaixVar, Object obj) {
        zzamr zzb2 = zzaixVar.zzb();
        int zza = zzaixVar.zza();
        if (!zzaixVar.zze()) {
            return zza(zzb2, zza, obj);
        }
        List list = (List) obj;
        int i = 0;
        if (!zzaixVar.zzd()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i += zza(zzb2, zza, it.next());
            }
            return i;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i += zza(zzb2, it2.next());
        }
        return zzaik.zzi(zza) + i + zzaik.zzj(i);
    }

    private final void zzb(zzaix zzaixVar, Object obj) {
        if (!zzaixVar.zze()) {
            zzc(zzaixVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zzc(zzaixVar, obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzajn) {
            this.zzd = true;
        }
        this.zza.zza(zzaixVar, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzc(com.google.android.gms.internal.firebase-auth-api.zzaix r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.firebase-auth-api.zzamr r0 = r5.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzajf.zza(r6)
            int[] r1 = com.google.android.gms.internal.firebase-auth-api.zzaiu.zza
            com.google.android.gms.internal.firebase-auth-api.zzanb r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L3f;
                case 4: goto L3c;
                case 5: goto L39;
                case 6: goto L36;
                case 7: goto L2d;
                case 8: goto L24;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = 0
            goto L47
        L1a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.firebase-auth-api.zzakn
            if (r0 != 0) goto L22
            boolean r0 = r6 instanceof com.google.android.gms.internal.firebase-auth-api.zzajn
            if (r0 == 0) goto L18
        L22:
            r0 = 1
            goto L47
        L24:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L22
            boolean r0 = r6 instanceof com.google.android.gms.internal.firebase-auth-api.zzaje
            if (r0 == 0) goto L18
            goto L22
        L2d:
            boolean r0 = r6 instanceof com.google.android.gms.internal.firebase-auth-api.zzahp
            if (r0 != 0) goto L22
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L18
            goto L22
        L36:
            boolean r0 = r6 instanceof java.lang.String
            goto L47
        L39:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L47
        L3c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L47
        L3f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L47
        L42:
            boolean r0 = r6 instanceof java.lang.Long
            goto L47
        L45:
            boolean r0 = r6 instanceof java.lang.Integer
        L47:
            if (r0 == 0) goto L4a
            return
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r3 = r5.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.internal.firebase-auth-api.zzamr r5 = r5.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzanb r5 = r5.zzb()
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r2] = r3
            r4[r1] = r5
            r5 = 2
            r4[r5] = r6
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r4)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzaiv.zzc(com.google.android.gms.internal.firebase-auth-api.zzaix, java.lang.Object):void");
    }

    private zzaiv(boolean z) {
        this(zzalg.zza(0));
        zze();
    }

    public static int zza(zzamr zzamrVar, int i, Object obj) {
        int zzi = zzaik.zzi(i);
        if (zzamrVar == zzamr.zzj) {
            zzajf.zza((zzakn) obj);
            zzi <<= 1;
        }
        return zzi + zza(zzamrVar, obj);
    }

    private final void zzb(Map.Entry entry) {
        zzaix zzaixVar = (zzaix) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzajn;
        if (zzaixVar.zze()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object zza = zza(zzaixVar);
            if (zza == null) {
                zza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) zza).add(zza(it.next()));
            }
            this.zza.zza(zzaixVar, zza);
            return;
        }
        if (zzaixVar.zzc() != zzanb.zzi) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.zza(zzaixVar, zza(value));
            return;
        }
        Object zza2 = zza(zzaixVar);
        if (zza2 != null) {
            if (z) {
                value = zzajn.zza();
            }
            this.zza.zza(zzaixVar, zza2 instanceof zzaks ? zzaixVar.zza((zzaks) zza2, (zzaks) value) : zzaixVar.zza(((zzakn) zza2).zzr(), (zzakn) value).zzf());
        } else {
            this.zza.zza(zzaixVar, zza(value));
            if (z) {
                this.zzd = true;
            }
        }
    }

    private static boolean zzc(Map.Entry entry) {
        zzaix zzaixVar = (zzaix) entry.getKey();
        if (zzaixVar.zzc() != zzanb.zzi) {
            return true;
        }
        boolean zze = zzaixVar.zze();
        Object value = entry.getValue();
        if (!zze) {
            return zzb(value);
        }
        Iterator it = ((List) value).iterator();
        while (it.hasNext()) {
            if (!zzb(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static int zza(zzamr zzamrVar, Object obj) {
        switch (zzaiu.zzb[zzamrVar.ordinal()]) {
            case 1:
                return zzaik.zza(((Double) obj).doubleValue());
            case 2:
                return zzaik.zza(((Float) obj).floatValue());
            case 3:
                return zzaik.zzd(((Long) obj).longValue());
            case 4:
                return zzaik.zzg(((Long) obj).longValue());
            case 5:
                return zzaik.zze(((Integer) obj).intValue());
            case 6:
                return zzaik.zzc(((Long) obj).longValue());
            case 7:
                return zzaik.zzd(((Integer) obj).intValue());
            case 8:
                return zzaik.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzaik.zza((zzakn) obj);
            case 10:
                return obj instanceof zzajn ? zzaik.zza((zzajn) obj) : zzaik.zzb((zzakn) obj);
            case 11:
                return obj instanceof zzahp ? zzaik.zza((zzahp) obj) : zzaik.zza((String) obj);
            case 12:
                return obj instanceof zzahp ? zzaik.zza((zzahp) obj) : zzaik.zza((byte[]) obj);
            case 13:
                return zzaik.zzj(((Integer) obj).intValue());
            case 14:
                return zzaik.zzg(((Integer) obj).intValue());
            case 15:
                return zzaik.zze(((Long) obj).longValue());
            case 16:
                return zzaik.zzh(((Integer) obj).intValue());
            case 17:
                return zzaik.zzf(((Long) obj).longValue());
            case 18:
                return obj instanceof zzaje ? zzaik.zzc(((zzaje) obj).zza()) : zzaik.zzc(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzakp) {
            return ((zzakp) obj).zzk();
        }
        if (obj instanceof zzajn) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static int zza(Map.Entry entry) {
        zzaix zzaixVar = (zzaix) entry.getKey();
        Object value = entry.getValue();
        if (zzaixVar.zzc() != zzanb.zzi || zzaixVar.zze() || zzaixVar.zzd()) {
            return zza(zzaixVar, value);
        }
        boolean z = value instanceof zzajn;
        int zza = ((zzaix) entry.getKey()).zza();
        return z ? zzaik.zza(zza, (zzajn) value) : zzaik.zza(zza, (zzakn) value);
    }

    private final Object zza(zzaix zzaixVar) {
        Object obj = this.zza.get(zzaixVar);
        return obj instanceof zzajn ? zzajn.zza() : obj;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzaks) {
            return ((zzaks) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static void zza(zzaik zzaikVar, zzamr zzamrVar, int i, Object obj) throws IOException {
        if (zzamrVar == zzamr.zzj) {
            zzakn zzaknVar = (zzakn) obj;
            zzajf.zza(zzaknVar);
            zzaikVar.zzk(i, 3);
            zzaknVar.zza(zzaikVar);
            zzaikVar.zzk(i, 4);
        }
        zzaikVar.zzk(i, zzamrVar.zza());
        switch (zzaiu.zzb[zzamrVar.ordinal()]) {
            case 1:
                zzaikVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzaikVar.zzb(((Float) obj).floatValue());
                break;
            case 3:
                zzaikVar.zzj(((Long) obj).longValue());
                break;
            case 4:
                zzaikVar.zzj(((Long) obj).longValue());
                break;
            case 5:
                zzaikVar.zzl(((Integer) obj).intValue());
                break;
            case 6:
                zzaikVar.zzh(((Long) obj).longValue());
                break;
            case 7:
                zzaikVar.zzk(((Integer) obj).intValue());
                break;
            case 8:
                zzaikVar.zzb(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzakn) obj).zza(zzaikVar);
                break;
            case 10:
                zzaikVar.zzc((zzakn) obj);
                break;
            case 11:
                if (!(obj instanceof zzahp)) {
                    zzaikVar.zzb((String) obj);
                    break;
                } else {
                    zzaikVar.zzb((zzahp) obj);
                    break;
                }
            case 12:
                if (!(obj instanceof zzahp)) {
                    byte[] bArr = (byte[]) obj;
                    zzaikVar.zzb(bArr, 0, bArr.length);
                    break;
                } else {
                    zzaikVar.zzb((zzahp) obj);
                    break;
                }
            case 13:
                zzaikVar.zzn(((Integer) obj).intValue());
                break;
            case 14:
                zzaikVar.zzk(((Integer) obj).intValue());
                break;
            case 15:
                zzaikVar.zzh(((Long) obj).longValue());
                break;
            case 16:
                zzaikVar.zzm(((Integer) obj).intValue());
                break;
            case 17:
                zzaikVar.zzi(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof zzaje)) {
                    zzaikVar.zzl(((Integer) obj).intValue());
                    break;
                } else {
                    zzaikVar.zzl(((zzaje) obj).zza());
                    break;
                }
        }
    }

    public final void zza(zzaiv zzaivVar) {
        for (int i = 0; i < zzaivVar.zza.zza(); i++) {
            zzb(zzaivVar.zza.zzb(i));
        }
        Iterator it = zzaivVar.zza.zzb().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }
}
