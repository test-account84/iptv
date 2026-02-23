package com.google.android.gms.internal.cast;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzql extends AbstractOwnableSynchronizer implements Runnable {
    private final zzqo zza;

    public /* synthetic */ zzql(zzqo zzqoVar, zzqk zzqkVar) {
        this.zza = zzqoVar;
    }

    public static /* synthetic */ void zza(zzql zzqlVar, Thread thread) {
        super.setExclusiveOwnerThread(thread);
    }

    public final void run() {
    }

    public final String toString() {
        return this.zza.toString();
    }
}
