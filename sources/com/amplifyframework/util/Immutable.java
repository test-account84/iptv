package com.amplifyframework.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Immutable {
    private Immutable() {
    }

    public static List of(List list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static Map of(Map map) {
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static Set of(Set set) {
        if (set == null) {
            return null;
        }
        return Collections.unmodifiableSet(new HashSet(set));
    }
}
