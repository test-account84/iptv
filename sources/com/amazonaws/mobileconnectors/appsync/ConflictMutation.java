package com.amazonaws.mobileconnectors.appsync;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConflictMutation {
    final String mutationId;
    final int retryCount;

    public ConflictMutation(String str, int i) {
        this.mutationId = str;
        this.retryCount = i;
    }
}
