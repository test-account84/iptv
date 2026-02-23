package j$.util.concurrent;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class k implements Map.Entry {
    final Object a;
    Object b;
    final ConcurrentHashMap c;

    k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
        this.a = obj;
        this.b = obj2;
        this.c = concurrentHashMap;
    }

    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        Object obj2;
        Object obj3;
        return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.a) || key.equals(obj2)) && (value == (obj3 = this.b) || value.equals(obj3));
    }

    public final Object getKey() {
        return this.a;
    }

    public final Object getValue() {
        return this.b;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public final Object setValue(Object obj) {
        obj.getClass();
        Object obj2 = this.b;
        this.b = obj;
        this.c.put(this.a, obj);
        return obj2;
    }

    public final String toString() {
        return u.a(this.a, this.b);
    }
}
