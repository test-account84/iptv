package B2;

import B2.m;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g extends m {
    public final long a;
    public final long b;
    public final k c;
    public final Integer d;
    public final String e;
    public final List f;
    public final p g;

    public static final class b extends m.a {
        public Long a;
        public Long b;
        public k c;
        public Integer d;
        public String e;
        public List f;
        public p g;

        public m a() {
            String str = "";
            if (this.a == null) {
                str = " requestTimeMs";
            }
            if (this.b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.a.longValue(), this.b.longValue(), this.c, this.d, this.e, this.f, this.g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public m.a b(k kVar) {
            this.c = kVar;
            return this;
        }

        public m.a c(List list) {
            this.f = list;
            return this;
        }

        public m.a d(Integer num) {
            this.d = num;
            return this;
        }

        public m.a e(String str) {
            this.e = str;
            return this;
        }

        public m.a f(p pVar) {
            this.g = pVar;
            return this;
        }

        public m.a g(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        public m.a h(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    public g(long j, long j2, k kVar, Integer num, String str, List list, p pVar) {
        this.a = j;
        this.b = j2;
        this.c = kVar;
        this.d = num;
        this.e = str;
        this.f = list;
        this.g = pVar;
    }

    public k b() {
        return this.c;
    }

    public List c() {
        return this.f;
    }

    public Integer d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.a == mVar.g() && this.b == mVar.h() && ((kVar = this.c) != null ? kVar.equals(mVar.b()) : mVar.b() == null) && ((num = this.d) != null ? num.equals(mVar.d()) : mVar.d() == null) && ((str = this.e) != null ? str.equals(mVar.e()) : mVar.e() == null) && ((list = this.f) != null ? list.equals(mVar.c()) : mVar.c() == null)) {
            p pVar = this.g;
            p f = mVar.f();
            if (pVar == null) {
                if (f == null) {
                    return true;
                }
            } else if (pVar.equals(f)) {
                return true;
            }
        }
        return false;
    }

    public p f() {
        return this.g;
    }

    public long g() {
        return this.a;
    }

    public long h() {
        return this.b;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        k kVar = this.c;
        int hashCode = (i ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.g;
        return hashCode4 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.a + ", requestUptimeMs=" + this.b + ", clientInfo=" + this.c + ", logSource=" + this.d + ", logSourceName=" + this.e + ", logEvents=" + this.f + ", qosTier=" + this.g + "}";
    }

    public /* synthetic */ g(long j, long j2, k kVar, Integer num, String str, List list, p pVar, a aVar) {
        this(j, j2, kVar, num, str, list, pVar);
    }
}
