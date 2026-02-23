package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class brn extends LinkedHashMap {
    private static final brn a;
    private boolean b;

    static {
        brn brnVar = new brn();
        a = brnVar;
        brnVar.c();
    }

    private brn() {
        this.b = true;
    }

    public static brn a() {
        return a;
    }

    private static int f(Object obj) {
        if (obj instanceof byte[]) {
            return bqu.b((byte[]) obj);
        }
        if (obj instanceof bqp) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    private final void g() {
        if (!this.b) {
            throw new UnsupportedOperationException();
        }
    }

    public final brn b() {
        return isEmpty() ? new brn() : new brn(this);
    }

    public final void c() {
        this.b = false;
    }

    public final void clear() {
        g();
        super.clear();
    }

    public final void d(brn brnVar) {
        g();
        if (brnVar.isEmpty()) {
            return;
        }
        putAll(brnVar);
    }

    public final boolean e() {
        return this.b;
    }

    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += f(entry.getValue()) ^ f(entry.getKey());
        }
        return i;
    }

    public final Object put(Object obj, Object obj2) {
        g();
        bqu.i(obj);
        bqu.i(obj2);
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        g();
        for (Object obj : map.keySet()) {
            bqu.i(obj);
            bqu.i(map.get(obj));
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        g();
        return super.remove(obj);
    }

    private brn(Map map) {
        super(map);
        this.b = true;
    }
}
