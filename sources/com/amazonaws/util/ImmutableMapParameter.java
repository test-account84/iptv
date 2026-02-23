package com.amazonaws.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ImmutableMapParameter implements Map {
    private static final String DUPLICATED_KEY_MESSAGE = "Duplicate keys are provided.";
    private static final String UNMODIFIABLE_MESSAGE = "This is an immutable map.";
    private final Map map;

    public static class Builder {
        private final Map entries = new HashMap();

        public ImmutableMapParameter build() {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.entries);
            return new ImmutableMapParameter(hashMap, null);
        }

        public Builder put(Object obj, Object obj2) {
            ImmutableMapParameter.access$000(this.entries, obj, obj2);
            return this;
        }
    }

    private ImmutableMapParameter(Map map) {
        this.map = map;
    }

    public static /* synthetic */ void access$000(Map map, Object obj, Object obj2) {
        putAndWarnDuplicateKeys(map, obj, obj2);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ImmutableMapParameter of(Object obj, Object obj2) {
        return new ImmutableMapParameter(Collections.singletonMap(obj, obj2));
    }

    private static void putAndWarnDuplicateKeys(Map map, Object obj, Object obj2) {
        if (map.containsKey(obj)) {
            throw new IllegalArgumentException("Duplicate keys are provided.");
        }
        map.put(obj, obj2);
    }

    public void clear() {
        throw new UnsupportedOperationException("This is an immutable map.");
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Set entrySet() {
        return this.map.entrySet();
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set keySet() {
        return this.map.keySet();
    }

    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("This is an immutable map.");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("This is an immutable map.");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("This is an immutable map.");
    }

    public int size() {
        return this.map.size();
    }

    public Collection values() {
        return this.map.values();
    }

    public /* synthetic */ ImmutableMapParameter(Map map, 1 r2) {
        this(map);
    }

    public static ImmutableMapParameter of(Object obj, Object obj2, Object obj3, Object obj4) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, obj, obj2);
        putAndWarnDuplicateKeys(hashMap, obj3, obj4);
        return new ImmutableMapParameter(hashMap);
    }

    public static ImmutableMapParameter of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, obj, obj2);
        putAndWarnDuplicateKeys(hashMap, obj3, obj4);
        putAndWarnDuplicateKeys(hashMap, obj5, obj6);
        return new ImmutableMapParameter(hashMap);
    }

    public static ImmutableMapParameter of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, obj, obj2);
        putAndWarnDuplicateKeys(hashMap, obj3, obj4);
        putAndWarnDuplicateKeys(hashMap, obj5, obj6);
        putAndWarnDuplicateKeys(hashMap, obj7, obj8);
        return new ImmutableMapParameter(hashMap);
    }

    public static ImmutableMapParameter of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, obj, obj2);
        putAndWarnDuplicateKeys(hashMap, obj3, obj4);
        putAndWarnDuplicateKeys(hashMap, obj5, obj6);
        putAndWarnDuplicateKeys(hashMap, obj7, obj8);
        putAndWarnDuplicateKeys(hashMap, obj9, obj10);
        return new ImmutableMapParameter(hashMap);
    }
}
