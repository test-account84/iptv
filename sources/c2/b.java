package C2;

import C2.i;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends i {
    public final String a;
    public final Integer b;
    public final h c;
    public final long d;
    public final long e;
    public final Map f;

    public static final class b extends i.a {
        public String a;
        public Integer b;
        public h c;
        public Long d;
        public Long e;
        public Map f;

        public i d() {
            String str = "";
            if (this.a == null) {
                str = " transportName";
            }
            if (this.c == null) {
                str = str + " encodedPayload";
            }
            if (this.d == null) {
                str = str + " eventMillis";
            }
            if (this.e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b, this.c, this.d.longValue(), this.e.longValue(), this.f, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public Map e() {
            Map map = this.f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f = map;
            return this;
        }

        public i.a g(Integer num) {
            this.b = num;
            return this;
        }

        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.c = hVar;
            return this;
        }

        public i.a i(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        public i.a j(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.a = str;
            return this;
        }

        public i.a k(long j) {
            this.e = Long.valueOf(j);
            return this;
        }
    }

    public b(String str, Integer num, h hVar, long j, long j2, Map map) {
        this.a = str;
        this.b = num;
        this.c = hVar;
        this.d = j;
        this.e = j2;
        this.f = map;
    }

    public Map c() {
        return this.f;
    }

    public Integer d() {
        return this.b;
    }

    public h e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a.equals(iVar.j()) && ((num = this.b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.c.equals(iVar.e()) && this.d == iVar.f() && this.e == iVar.k() && this.f.equals(iVar.c());
    }

    public long f() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        long j = this.d;
        int i = (hashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.e;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f.hashCode();
    }

    public String j() {
        return this.a;
    }

    public long k() {
        return this.e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + "}";
    }

    public /* synthetic */ b(String str, Integer num, h hVar, long j, long j2, Map map, a aVar) {
        this(str, num, hVar, j, j2, map);
    }
}
