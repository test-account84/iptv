package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ayn implements Executor {
    public static final ayn a;
    private static final /* synthetic */ ayn[] b;

    static {
        ayn aynVar = new ayn();
        a = aynVar;
        b = new ayn[]{aynVar};
    }

    private ayn() {
    }

    public static ayn[] values() {
        return (ayn[]) b.clone();
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
