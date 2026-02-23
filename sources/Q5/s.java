package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s extends B.e.d.a.b.e.b {
    public final long a;
    public final String b;
    public final String c;
    public final long d;
    public final int e;

    public static final class b extends B.e.d.a.b.e.b.a {
        public Long a;
        public String b;
        public String c;
        public Long d;
        public Integer e;

        public B.e.d.a.b.e.b a() {
            String str = "";
            if (this.a == null) {
                str = " pc";
            }
            if (this.b == null) {
                str = str + " symbol";
            }
            if (this.d == null) {
                str = str + " offset";
            }
            if (this.e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new s(this.a.longValue(), this.b, this.c, this.d.longValue(), this.e.intValue(), null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.d.a.b.e.b.a b(String str) {
            this.c = str;
            return this;
        }

        public B.e.d.a.b.e.b.a c(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public B.e.d.a.b.e.b.a d(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        public B.e.d.a.b.e.b.a e(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        public B.e.d.a.b.e.b.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.b = str;
            return this;
        }
    }

    public s(long j, String str, String str2, long j2, int i) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = j2;
        this.e = i;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.e;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.d.a.b.e.b)) {
            return false;
        }
        B.e.d.a.b.e.b bVar = (B.e.d.a.b.e.b) obj;
        return this.a == bVar.e() && this.b.equals(bVar.f()) && ((str = this.c) != null ? str.equals(bVar.b()) : bVar.b() == null) && this.d == bVar.d() && this.e == bVar.c();
    }

    public String f() {
        return this.b;
    }

    public int hashCode() {
        long j = this.a;
        int hashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str = this.c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j2 = this.d;
        return this.e ^ ((hashCode2 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.a + ", symbol=" + this.b + ", file=" + this.c + ", offset=" + this.d + ", importance=" + this.e + "}";
    }

    public /* synthetic */ s(long j, String str, String str2, long j2, int i, a aVar) {
        this(j, str, str2, j2, i);
    }
}
