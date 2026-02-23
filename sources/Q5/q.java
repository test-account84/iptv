package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q extends B.e.d.a.b.d {
    public final String a;
    public final String b;
    public final long c;

    public static final class b extends B.e.d.a.b.d.a {
        public String a;
        public String b;
        public Long c;

        public B.e.d.a.b.d a() {
            String str = "";
            if (this.a == null) {
                str = " name";
            }
            if (this.b == null) {
                str = str + " code";
            }
            if (this.c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new q(this.a, this.b, this.c.longValue(), null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.d.a.b.d.a b(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        public B.e.d.a.b.d.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.b = str;
            return this;
        }

        public B.e.d.a.b.d.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.a = str;
            return this;
        }
    }

    public q(String str, String str2, long j) {
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public long b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.d.a.b.d)) {
            return false;
        }
        B.e.d.a.b.d dVar = (B.e.d.a.b.d) obj;
        return this.a.equals(dVar.d()) && this.b.equals(dVar.c()) && this.c == dVar.b();
    }

    public int hashCode() {
        int hashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        long j = this.c;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.a + ", code=" + this.b + ", address=" + this.c + "}";
    }

    public /* synthetic */ q(String str, String str2, long j, a aVar) {
        this(str, str2, j);
    }
}
