package com.amplifyframework.datastore;

import com.amplifyframework.util.Immutable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DataStoreQuerySnapshot {
    private final boolean isSynced;
    private final List items;

    public DataStoreQuerySnapshot(List list, boolean z) {
        this.items = list;
        this.isSynced = z;
    }

    public boolean getIsSynced() {
        return this.isSynced;
    }

    public List getItems() {
        return Immutable.of(this.items);
    }
}
