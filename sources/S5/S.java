package s5;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class s extends t implements Map {
    public abstract Map c();

    public void clear() {
        c().clear();
    }

    public boolean containsKey(Object obj) {
        return c().containsKey(obj);
    }

    public boolean d(Object obj) {
        return I.b(this, obj);
    }

    public boolean e(Object obj) {
        return I.c(this, obj);
    }

    public Set entrySet() {
        return c().entrySet();
    }

    public int f() {
        return Z.d(entrySet());
    }

    public Object get(Object obj) {
        return c().get(obj);
    }

    public boolean isEmpty() {
        return c().isEmpty();
    }

    public Set keySet() {
        return c().keySet();
    }

    public Object put(Object obj, Object obj2) {
        return c().put(obj, obj2);
    }

    public void putAll(Map map) {
        c().putAll(map);
    }

    public Object remove(Object obj) {
        return c().remove(obj);
    }

    public int size() {
        return c().size();
    }

    public Collection values() {
        return c().values();
    }
}
