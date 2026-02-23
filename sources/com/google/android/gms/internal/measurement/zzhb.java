package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.os.UserManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzhb {
    private static UserManager zza;
    private static volatile boolean zzb = !zzb();

    private zzhb() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, NullPointerException -> 0x0045, blocks: (B:8:0x000f, B:10:0x0013, B:15:0x001d, B:17:0x0021, B:18:0x002b, B:31:0x0058, B:32:0x005a, B:21:0x0031, B:23:0x0037, B:29:0x0054, B:39:0x0046), top: B:7:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(android.content.Context r8) {
        /*
            boolean r0 = zzb()
            r1 = 0
            if (r0 == 0) goto L60
            boolean r0 = com.google.android.gms.internal.measurement.zzhb.zzb
            if (r0 == 0) goto Lc
            goto L60
        Lc:
            java.lang.Class<com.google.android.gms.internal.measurement.zzhb> r0 = com.google.android.gms.internal.measurement.zzhb.class
            monitor-enter(r0)
            boolean r2 = com.google.android.gms.internal.measurement.zzhb.zzb     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            goto L60
        L15:
            r8 = move-exception
            goto L5e
        L17:
            r2 = 1
            r3 = 1
        L19:
            r4 = 2
            r5 = 0
            if (r3 > r4) goto L43
            android.os.UserManager r4 = com.google.android.gms.internal.measurement.zzhb.zza     // Catch: java.lang.Throwable -> L15
            if (r4 != 0) goto L2b
            java.lang.Class<android.os.UserManager> r4 = android.os.UserManager.class
            java.lang.Object r4 = com.google.android.gms.internal.measurement.b.a(r8, r4)     // Catch: java.lang.Throwable -> L15
            android.os.UserManager r4 = (android.os.UserManager) r4     // Catch: java.lang.Throwable -> L15
            com.google.android.gms.internal.measurement.zzhb.zza = r4     // Catch: java.lang.Throwable -> L15
        L2b:
            android.os.UserManager r4 = com.google.android.gms.internal.measurement.zzhb.zza     // Catch: java.lang.Throwable -> L15
            if (r4 != 0) goto L31
            r8 = 1
            goto L56
        L31:
            boolean r6 = com.google.android.gms.internal.measurement.c.a(r4)     // Catch: java.lang.Throwable -> L15 java.lang.NullPointerException -> L45
            if (r6 != 0) goto L41
            android.os.UserHandle r6 = android.os.Process.myUserHandle()     // Catch: java.lang.Throwable -> L15 java.lang.NullPointerException -> L45
            boolean r8 = r4.isUserRunning(r6)     // Catch: java.lang.Throwable -> L15 java.lang.NullPointerException -> L45
            if (r8 != 0) goto L43
        L41:
            r8 = 1
            goto L52
        L43:
            r8 = 0
            goto L52
        L45:
            r4 = move-exception
            java.lang.String r6 = "DirectBootUtils"
            java.lang.String r7 = "Failed to check if user is unlocked."
            android.util.Log.w(r6, r7, r4)     // Catch: java.lang.Throwable -> L15
            com.google.android.gms.internal.measurement.zzhb.zza = r5     // Catch: java.lang.Throwable -> L15
            int r3 = r3 + 1
            goto L19
        L52:
            if (r8 == 0) goto L56
            com.google.android.gms.internal.measurement.zzhb.zza = r5     // Catch: java.lang.Throwable -> L15
        L56:
            if (r8 == 0) goto L5a
            com.google.android.gms.internal.measurement.zzhb.zzb = r2     // Catch: java.lang.Throwable -> L15
        L5a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            if (r8 != 0) goto L60
            return r2
        L5e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r8
        L60:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhb.zza(android.content.Context):boolean");
    }

    public static boolean zzb() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
