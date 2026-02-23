package com.amazonaws.mobile.client;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
interface KeyValueStore {
    void clear();

    String get(String str);

    Map get(String... strArr);

    void set(String str, String str2);

    void set(Map map);
}
