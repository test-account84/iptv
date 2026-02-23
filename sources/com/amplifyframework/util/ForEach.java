package com.amplifyframework.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ForEach {

    @FunctionalInterface
    public interface Mapping {
        Object apply(Object obj);
    }

    private ForEach() {
    }

    public static List inArray(Object[] objArr, Mapping mapping) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(mapping.apply(obj));
        }
        return Immutable.of((List) arrayList);
    }

    public static List inCollection(Collection collection, Mapping mapping) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(mapping.apply(it.next()));
        }
        return Immutable.of((List) arrayList);
    }
}
