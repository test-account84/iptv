package com.amazonaws.mobileconnectors.appsync;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface PersistentMutationsCallback {
    void onFailure(PersistentMutationsError persistentMutationsError);

    void onResponse(PersistentMutationsResponse persistentMutationsResponse);
}
