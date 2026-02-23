package com.amazonaws.internal.keyvaluestore;

import java.security.Key;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
interface KeyProvider {
    void deleteKey(String str);

    Key generateKey(String str) throws KeyNotGeneratedException;

    Key retrieveKey(String str) throws KeyNotFoundException;
}
