package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends B {
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final B.e i;
    public final B.d j;
    public final B.a k;

    public static final class b extends B.b {
        public String a;
        public String b;
        public Integer c;
        public String d;
        public String e;
        public String f;
        public String g;
        public B.e h;
        public B.d i;
        public B.a j;

        public b() {
        }

        public B a() {
            String str = "";
            if (this.a == null) {
                str = " sdkVersion";
            }
            if (this.b == null) {
                str = str + " gmpAppId";
            }
            if (this.c == null) {
                str = str + " platform";
            }
            if (this.d == null) {
                str = str + " installationUuid";
            }
            if (this.f == null) {
                str = str + " buildVersion";
            }
            if (this.g == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b, this.c.intValue(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.b b(B.a aVar) {
            this.j = aVar;
            return this;
        }

        public B.b c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f = str;
            return this;
        }

        public B.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.g = str;
            return this;
        }

        public B.b e(String str) {
            this.e = str;
            return this;
        }

        public B.b f(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.b = str;
            return this;
        }

        public B.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.d = str;
            return this;
        }

        public B.b h(B.d dVar) {
            this.i = dVar;
            return this;
        }

        public B.b i(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public B.b j(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.a = str;
            return this;
        }

        public B.b k(B.e eVar) {
            this.h = eVar;
            return this;
        }

        public b(B b) {
            this.a = b.k();
            this.b = b.g();
            this.c = Integer.valueOf(b.j());
            this.d = b.h();
            this.e = b.f();
            this.f = b.d();
            this.g = b.e();
            this.h = b.l();
            this.i = b.i();
            this.j = b.c();
        }

        public /* synthetic */ b(B b, a aVar) {
            this(b);
        }
    }

    public b(String str, String str2, int i, String str3, String str4, String str5, String str6, B.e eVar, B.d dVar, B.a aVar) {
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = eVar;
        this.j = dVar;
        this.k = aVar;
    }

    public B.a c() {
        return this.k;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        String str;
        B.e eVar;
        B.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b2 = (B) obj;
        if (this.b.equals(b2.k()) && this.c.equals(b2.g()) && this.d == b2.j() && this.e.equals(b2.h()) && ((str = this.f) != null ? str.equals(b2.f()) : b2.f() == null) && this.g.equals(b2.d()) && this.h.equals(b2.e()) && ((eVar = this.i) != null ? eVar.equals(b2.l()) : b2.l() == null) && ((dVar = this.j) != null ? dVar.equals(b2.i()) : b2.i() == null)) {
            B.a aVar = this.k;
            B.a c = b2.c();
            if (aVar == null) {
                if (c == null) {
                    return true;
                }
            } else if (aVar.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.e;
    }

    public int hashCode() {
        int hashCode = (((((((this.b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003;
        String str = this.f;
        int hashCode2 = (((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003;
        B.e eVar = this.i;
        int hashCode3 = (hashCode2 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        B.d dVar = this.j;
        int hashCode4 = (hashCode3 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        B.a aVar = this.k;
        return hashCode4 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public B.d i() {
        return this.j;
    }

    public int j() {
        return this.d;
    }

    public String k() {
        return this.b;
    }

    public B.e l() {
        return this.i;
    }

    public B.b m() {
        return new b(this, null);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.b + ", gmpAppId=" + this.c + ", platform=" + this.d + ", installationUuid=" + this.e + ", firebaseInstallationId=" + this.f + ", buildVersion=" + this.g + ", displayVersion=" + this.h + ", session=" + this.i + ", ndkPayload=" + this.j + ", appExitInfo=" + this.k + "}";
    }

    public /* synthetic */ b(String str, String str2, int i, String str3, String str4, String str5, String str6, B.e eVar, B.d dVar, B.a aVar, a aVar2) {
        this(str, str2, i, str3, str4, str5, str6, eVar, dVar, aVar);
    }
}
