package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o extends B.e.d.a.b.a {
    public final long a;
    public final long b;
    public final String c;
    public final String d;

    public static final class b extends B.e.d.a.b.a.a {
        public Long a;
        public Long b;
        public String c;
        public String d;

        public B.e.d.a.b.a a() {
            String str = "";
            if (this.a == null) {
                str = " baseAddress";
            }
            if (this.b == null) {
                str = str + " size";
            }
            if (this.c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new o(this.a.longValue(), this.b.longValue(), this.c, this.d, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.d.a.b.a.a b(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        public B.e.d.a.b.a.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.c = str;
            return this;
        }

        public B.e.d.a.b.a.a d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        public B.e.d.a.b.a.a e(String str) {
            this.d = str;
            return this;
        }
    }

    public o(long j, long j2, String str, String str2) {
        this.a = j;
        this.b = j2;
        this.c = str;
        this.d = str2;
    }

    public long b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    public long d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.d.a.b.a)) {
            return false;
        }
        B.e.d.a.b.a aVar = (B.e.d.a.b.a) obj;
        if (this.a == aVar.b() && this.b == aVar.d() && this.c.equals(aVar.c())) {
            String str = this.d;
            String e = aVar.e();
            if (str == null) {
                if (e == null) {
                    return true;
                }
            } else if (str.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.c.hashCode()) * 1000003;
        String str = this.d;
        return (str == null ? 0 : str.hashCode()) ^ hashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.a + ", size=" + this.b + ", name=" + this.c + ", uuid=" + this.d + "}";
    }

    public /* synthetic */ o(long j, long j2, String str, String str2, a aVar) {
        this(j, j2, str, str2);
    }
}
