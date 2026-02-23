package com.amplifyframework.storage.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class StorageListResult {
    private final List items;

    private StorageListResult(List list) {
        this.items = list;
    }

    public static StorageListResult fromItems(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        return new StorageListResult(Collections.unmodifiableList(arrayList));
    }

    public List getItems() {
        return this.items;
    }
}
