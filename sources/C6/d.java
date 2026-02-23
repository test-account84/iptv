package c6;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d {
    public final String a;
    public final Map b;

    public static final class b {
        public final String a;
        public Map b = null;

        public b(String str) {
            this.a = str;
        }

        public d a() {
            return new d(this.a, this.b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.b)), null);
        }

        public b b(Annotation annotation) {
            if (this.b == null) {
                this.b = new HashMap();
            }
            this.b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public d(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    public static b a(String str) {
        return new b(str);
    }

    public static d d(String str) {
        return new d(str, Collections.emptyMap());
    }

    public String b() {
        return this.a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a.equals(dVar.a) && this.b.equals(dVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.a + ", properties=" + this.b.values() + "}";
    }

    public /* synthetic */ d(String str, Map map, a aVar) {
        this(str, map);
    }
}
