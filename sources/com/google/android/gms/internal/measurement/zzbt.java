package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.Method;

@TargetApi(24)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    static {
        Method declaredMethod;
        Method method = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[]{JobInfo.class, String.class, Integer.TYPE, String.class});
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
            }
        } else {
            declaredMethod = null;
        }
        zza = declaredMethod;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                method = UserHandle.class.getDeclaredMethod("myUserId", (Class[]) null);
            } catch (NoSuchMethodException unused2) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        zzb = method;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            r7 = 0
            java.lang.String r8 = "jobscheduler"
            java.lang.Object r8 = r5.getSystemService(r8)
            android.app.job.JobScheduler r8 = (android.app.job.JobScheduler) r8
            r8.getClass()
            java.lang.reflect.Method r0 = com.google.android.gms.internal.measurement.zzbt.zza
            if (r0 == 0) goto L76
            java.lang.String r0 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = T.k.a(r5, r0)
            if (r5 == 0) goto L19
            goto L76
        L19:
            java.lang.reflect.Method r5 = com.google.android.gms.internal.measurement.zzbt.zzb
            if (r5 == 0) goto L31
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            r1 = 0
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            if (r5 == 0) goto L31
            int r5 = r5.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            goto L42
        L2d:
            r5 = move-exception
            goto L33
        L2f:
            r5 = move-exception
            goto L33
        L31:
            r5 = 0
            goto L42
        L33:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L31
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r5)
            goto L31
        L42:
            java.lang.String r0 = "UploadAlarm"
            java.lang.reflect.Method r1 = com.google.android.gms.internal.measurement.zzbt.zza
            if (r1 == 0) goto L71
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            r2[r7] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            java.lang.String r3 = "com.google.android.gms"
            r4 = 1
            r2[r4] = r3     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            r3 = 2
            r2[r3] = r5     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            r5 = 3
            r2[r5] = r0     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            java.lang.Object r5 = r1.invoke(r8, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            if (r5 == 0) goto L75
            int r7 = r5.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            goto L75
        L69:
            r5 = move-exception
            goto L6c
        L6b:
            r5 = move-exception
        L6c:
            java.lang.String r7 = "error calling scheduleAsPackage"
            android.util.Log.e(r0, r7, r5)
        L71:
            int r7 = r8.schedule(r6)
        L75:
            return r7
        L76:
            int r5 = r8.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
