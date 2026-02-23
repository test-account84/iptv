package com.nytimes.android.external.cache;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class r implements Map.Entry {
    public final Object a;
    public final Object c;
    public final p d;

    public r(Object obj, Object obj2, p pVar) {
        this.a = obj;
        this.c = obj2;
        this.d = (p) o.a(pVar);
    }

    public static r a(Object obj, Object obj2, p pVar) {
        return new r(obj, obj2, pVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return m.a(getKey(), entry.getKey()) && m.a(getValue(), entry.getValue());
    }

    public Object getKey() {
        return this.a;
    }

    public Object getValue() {
        return this.c;
    }

    public int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
