package v1;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public final String a;
    public final List b;
    public final Map c;

    public static class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            long j = this.a;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.b;
            return i + ((int) (j2 ^ (j2 >>> 32)));
        }

        public String toString() {
            return "Location{line=" + this.a + ", column=" + this.b + '}';
        }
    }

    public a(String str, List list, Map map) {
        this.a = str;
        this.b = list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
        this.c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
    }

    public Map a() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.a;
        if (str == null ? aVar.a != null : !str.equals(aVar.a)) {
            return false;
        }
        if (this.b.equals(aVar.b)) {
            return this.c.equals(aVar.c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Error{message='" + this.a + "', locations=" + this.b + ", customAttributes=" + this.c + '}';
    }
}
