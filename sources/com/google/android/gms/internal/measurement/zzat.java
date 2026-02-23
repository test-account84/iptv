package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzat implements Iterable, zzap {
    private final String zza;

    public zzat(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public static /* bridge */ /* synthetic */ String zzb(zzat zzatVar) {
        return zzatVar.zza;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x032f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzap zzbU(java.lang.String r20, com.google.android.gms.internal.measurement.zzg r21, java.util.List r22) {
        /*
            Method dump skipped, instructions count: 1754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzat.zzbU(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    public final zzap zzd() {
        return new zzat(this.zza);
    }

    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Double zzh() {
        double d;
        if (this.zza.isEmpty()) {
            d = 0.0d;
        } else {
            try {
                return Double.valueOf(this.zza);
            } catch (NumberFormatException unused) {
                d = Double.NaN;
            }
        }
        return Double.valueOf(d);
    }

    public final String zzi() {
        return this.zza;
    }

    public final Iterator zzl() {
        return new zzar(this);
    }
}
