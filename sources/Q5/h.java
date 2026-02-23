package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends B.e {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final Long e;
    public final boolean f;
    public final B.e.a g;
    public final B.e.f h;
    public final B.e.e i;
    public final B.e.c j;
    public final C k;
    public final int l;

    public static final class b extends B.e.b {
        public String a;
        public String b;
        public String c;
        public Long d;
        public Long e;
        public Boolean f;
        public B.e.a g;
        public B.e.f h;
        public B.e.e i;
        public B.e.c j;
        public C k;
        public Integer l;

        public b() {
        }

        public B.e a() {
            String str = "";
            if (this.a == null) {
                str = " generator";
            }
            if (this.b == null) {
                str = str + " identifier";
            }
            if (this.d == null) {
                str = str + " startedAt";
            }
            if (this.f == null) {
                str = str + " crashed";
            }
            if (this.g == null) {
                str = str + " app";
            }
            if (this.l == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new h(this.a, this.b, this.c, this.d.longValue(), this.e, this.f.booleanValue(), this.g, this.h, this.i, this.j, this.k, this.l.intValue(), null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.b b(B.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.g = aVar;
            return this;
        }

        public B.e.b c(String str) {
            this.c = str;
            return this;
        }

        public B.e.b d(boolean z) {
            this.f = Boolean.valueOf(z);
            return this;
        }

        public B.e.b e(B.e.c cVar) {
            this.j = cVar;
            return this;
        }

        public B.e.b f(Long l) {
            this.e = l;
            return this;
        }

        public B.e.b g(C c) {
            this.k = c;
            return this;
        }

        public B.e.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.a = str;
            return this;
        }

        public B.e.b i(int i) {
            this.l = Integer.valueOf(i);
            return this;
        }

        public B.e.b j(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.b = str;
            return this;
        }

        public B.e.b l(B.e.e eVar) {
            this.i = eVar;
            return this;
        }

        public B.e.b m(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        public B.e.b n(B.e.f fVar) {
            this.h = fVar;
            return this;
        }

        public b(B.e eVar) {
            this.a = eVar.g();
            this.b = eVar.i();
            this.c = eVar.c();
            this.d = Long.valueOf(eVar.l());
            this.e = eVar.e();
            this.f = Boolean.valueOf(eVar.n());
            this.g = eVar.b();
            this.h = eVar.m();
            this.i = eVar.k();
            this.j = eVar.d();
            this.k = eVar.f();
            this.l = Integer.valueOf(eVar.h());
        }

        public /* synthetic */ b(B.e eVar, a aVar) {
            this(eVar);
        }
    }

    public h(String str, String str2, String str3, long j, Long l, boolean z, B.e.a aVar, B.e.f fVar, B.e.e eVar, B.e.c cVar, C c, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = l;
        this.f = z;
        this.g = aVar;
        this.h = fVar;
        this.i = eVar;
        this.j = cVar;
        this.k = c;
        this.l = i;
    }

    public B.e.a b() {
        return this.g;
    }

    public String c() {
        return this.c;
    }

    public B.e.c d() {
        return this.j;
    }

    public Long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l;
        B.e.f fVar;
        B.e.e eVar;
        B.e.c cVar;
        C c;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e)) {
            return false;
        }
        B.e eVar2 = (B.e) obj;
        return this.a.equals(eVar2.g()) && this.b.equals(eVar2.i()) && ((str = this.c) != null ? str.equals(eVar2.c()) : eVar2.c() == null) && this.d == eVar2.l() && ((l = this.e) != null ? l.equals(eVar2.e()) : eVar2.e() == null) && this.f == eVar2.n() && this.g.equals(eVar2.b()) && ((fVar = this.h) != null ? fVar.equals(eVar2.m()) : eVar2.m() == null) && ((eVar = this.i) != null ? eVar.equals(eVar2.k()) : eVar2.k() == null) && ((cVar = this.j) != null ? cVar.equals(eVar2.d()) : eVar2.d() == null) && ((c = this.k) != null ? c.equals(eVar2.f()) : eVar2.f() == null) && this.l == eVar2.h();
    }

    public C f() {
        return this.k;
    }

    public String g() {
        return this.a;
    }

    public int h() {
        return this.l;
    }

    public int hashCode() {
        int hashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str = this.c;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j = this.d;
        int i = (((hashCode ^ hashCode2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.e;
        int hashCode3 = (((((i ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.g.hashCode()) * 1000003;
        B.e.f fVar = this.h;
        int hashCode4 = (hashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        B.e.e eVar = this.i;
        int hashCode5 = (hashCode4 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        B.e.c cVar = this.j;
        int hashCode6 = (hashCode5 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        C c = this.k;
        return ((hashCode6 ^ (c != null ? c.hashCode() : 0)) * 1000003) ^ this.l;
    }

    public String i() {
        return this.b;
    }

    public B.e.e k() {
        return this.i;
    }

    public long l() {
        return this.d;
    }

    public B.e.f m() {
        return this.h;
    }

    public boolean n() {
        return this.f;
    }

    public B.e.b o() {
        return new b(this, null);
    }

    public String toString() {
        return "Session{generator=" + this.a + ", identifier=" + this.b + ", appQualitySessionId=" + this.c + ", startedAt=" + this.d + ", endedAt=" + this.e + ", crashed=" + this.f + ", app=" + this.g + ", user=" + this.h + ", os=" + this.i + ", device=" + this.j + ", events=" + this.k + ", generatorType=" + this.l + "}";
    }

    public /* synthetic */ h(String str, String str2, String str3, long j, Long l, boolean z, B.e.a aVar, B.e.f fVar, B.e.e eVar, B.e.c cVar, C c, int i, a aVar2) {
        this(str, str2, str3, j, l, z, aVar, fVar, eVar, cVar, c, i);
    }
}
