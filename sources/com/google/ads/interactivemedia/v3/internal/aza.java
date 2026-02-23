package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aza extends AbstractOwnableSynchronizer implements Runnable {
    private final azc a;

    public /* synthetic */ aza(azc azcVar) {
        this.a = azcVar;
    }

    public static /* synthetic */ void a(aza azaVar, Thread thread) {
        super.setExclusiveOwnerThread(thread);
    }

    public final void run() {
    }

    public final String toString() {
        return this.a.toString();
    }
}
