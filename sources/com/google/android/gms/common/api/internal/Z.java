package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class z {
    public final Map a = DesugarCollections.synchronizedMap(new WeakHashMap());
    public final Map b = DesugarCollections.synchronizedMap(new WeakHashMap());

    public static /* bridge */ /* synthetic */ Map a(z zVar) {
        return zVar.a;
    }

    public static /* bridge */ /* synthetic */ Map b(z zVar) {
        return zVar.b;
    }

    public final void c(BasePendingResult basePendingResult, boolean z) {
        this.a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.addStatusListener(new x(this, basePendingResult));
    }

    public final void d(TaskCompletionSource taskCompletionSource, boolean z) {
        this.b.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.getTask().addOnCompleteListener(new y(this, taskCompletionSource));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The connection to Google Play services was lost"
            r0.<init>(r1)
            r1 = 1
            if (r4 != r1) goto L10
            java.lang.String r4 = " due to service disconnection."
        Lc:
            r0.append(r4)
            goto L16
        L10:
            r2 = 3
            if (r4 != r2) goto L16
            java.lang.String r4 = " due to dead object exception."
            goto Lc
        L16:
            if (r5 == 0) goto L20
            java.lang.String r4 = " Last reason for disconnect: "
            r0.append(r4)
            r0.append(r5)
        L20:
            java.lang.String r4 = r0.toString()
            com.google.android.gms.common.api.Status r5 = new com.google.android.gms.common.api.Status
            r0 = 20
            r5.<init>(r0, r4)
            r3.h(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.z.e(int, java.lang.String):void");
    }

    public final void f() {
        h(false, g.q);
    }

    public final boolean g() {
        return (this.a.isEmpty() && this.b.isEmpty()) ? false : true;
    }

    public final void h(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.a) {
            hashMap = new HashMap(this.a);
        }
        synchronized (this.b) {
            hashMap2 = new HashMap(this.b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new com.google.android.gms.common.api.b(status));
            }
        }
    }
}
