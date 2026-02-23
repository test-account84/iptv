package z1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i {
    public final String a;
    public final Map b;
    public volatile UUID c;
    public volatile int d = -1;

    public static class a {
        public final Map a;
        public final String b;
        public UUID c;

        public a(String str, Map map, UUID uuid) {
            this.b = str;
            this.a = new LinkedHashMap(map);
            this.c = uuid;
        }

        public a a(String str, Object obj) {
            this.a.put(x1.g.c(str, "key == null"), obj);
            return this;
        }

        public a b(Map map) {
            x1.g.c(map, "fields == null");
            this.a.putAll(map);
            return this;
        }

        public i c() {
            return new i(this.b, this.a, this.c);
        }

        public String d() {
            return this.b;
        }

        public a e(UUID uuid) {
            this.c = uuid;
            return this;
        }
    }

    public i(String str, Map map, UUID uuid) {
        this.a = str;
        this.b = map;
        this.c = uuid;
    }

    public static a b(String str) {
        return new a((String) x1.g.c(str, "key == null"), new LinkedHashMap(), null);
    }

    public final void a(Object obj, Object obj2) {
        if (this.d != -1) {
            this.d += F1.g.a(obj, obj2);
        }
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i clone() {
        return i().c();
    }

    public Object d(String str) {
        return this.b.get(str);
    }

    public Map e() {
        return this.b;
    }

    public boolean f(String str) {
        return this.b.containsKey(str);
    }

    public String g() {
        return this.a;
    }

    public Set h(i iVar) {
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : iVar.b.entrySet()) {
            Object value = entry.getValue();
            boolean containsKey = this.b.containsKey(entry.getKey());
            Object obj = this.b.get(entry.getKey());
            if (!containsKey || ((obj == null && value != null) || (obj != null && !obj.equals(value)))) {
                this.b.put(entry.getKey(), value);
                hashSet.add(g() + "." + ((String) entry.getKey()));
                a(value, obj);
            }
        }
        this.c = iVar.c;
        return hashSet;
    }

    public a i() {
        return new a(g(), this.b, this.c);
    }
}
