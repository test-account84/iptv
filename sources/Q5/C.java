package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends B.a {
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final long g;
    public final String h;
    public final C i;

    public static final class b extends B.a.b {
        public Integer a;
        public String b;
        public Integer c;
        public Integer d;
        public Long e;
        public Long f;
        public Long g;
        public String h;
        public C i;

        public B.a a() {
            String str = "";
            if (this.a == null) {
                str = " pid";
            }
            if (this.b == null) {
                str = str + " processName";
            }
            if (this.c == null) {
                str = str + " reasonCode";
            }
            if (this.d == null) {
                str = str + " importance";
            }
            if (this.e == null) {
                str = str + " pss";
            }
            if (this.f == null) {
                str = str + " rss";
            }
            if (this.g == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new c(this.a.intValue(), this.b, this.c.intValue(), this.d.intValue(), this.e.longValue(), this.f.longValue(), this.g.longValue(), this.h, this.i, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.a.b b(C c) {
            this.i = c;
            return this;
        }

        public B.a.b c(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public B.a.b d(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }

        public B.a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.b = str;
            return this;
        }

        public B.a.b f(long j) {
            this.e = Long.valueOf(j);
            return this;
        }

        public B.a.b g(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public B.a.b h(long j) {
            this.f = Long.valueOf(j);
            return this;
        }

        public B.a.b i(long j) {
            this.g = Long.valueOf(j);
            return this;
        }

        public B.a.b j(String str) {
            this.h = str;
            return this;
        }
    }

    public c(int i, String str, int i2, int i3, long j, long j2, long j3, String str2, C c) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = str2;
        this.i = c;
    }

    public C b() {
        return this.i;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.a)) {
            return false;
        }
        B.a aVar = (B.a) obj;
        if (this.a == aVar.d() && this.b.equals(aVar.e()) && this.c == aVar.g() && this.d == aVar.c() && this.e == aVar.f() && this.f == aVar.h() && this.g == aVar.i() && ((str = this.h) != null ? str.equals(aVar.j()) : aVar.j() == null)) {
            C c = this.i;
            C b2 = aVar.b();
            if (c == null) {
                if (b2 == null) {
                    return true;
                }
            } else if (c.equals(b2)) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.e;
    }

    public int g() {
        return this.c;
    }

    public long h() {
        return this.f;
    }

    public int hashCode() {
        int hashCode = (((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        long j = this.e;
        int i = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.g;
        int i3 = (i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str = this.h;
        int hashCode2 = (i3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        C c = this.i;
        return hashCode2 ^ (c != null ? c.hashCode() : 0);
    }

    public long i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.a + ", processName=" + this.b + ", reasonCode=" + this.c + ", importance=" + this.d + ", pss=" + this.e + ", rss=" + this.f + ", timestamp=" + this.g + ", traceFile=" + this.h + ", buildIdMappingForArch=" + this.i + "}";
    }

    public /* synthetic */ c(int i, String str, int i2, int i3, long j, long j2, long j3, String str2, C c, a aVar) {
        this(i, str, i2, i3, j, j2, j3, str2, c);
    }
}
