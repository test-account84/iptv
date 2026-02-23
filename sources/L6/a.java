package l6;

import l6.c;
import l6.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends d {
    public final String b;
    public final c.a c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;
    public final String h;

    public static final class b extends d.a {
        public String a;
        public c.a b;
        public String c;
        public String d;
        public Long e;
        public Long f;
        public String g;

        public b() {
        }

        public d a() {
            String str = "";
            if (this.b == null) {
                str = " registrationStatus";
            }
            if (this.e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d, this.e.longValue(), this.f.longValue(), this.g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public d.a b(String str) {
            this.c = str;
            return this;
        }

        public d.a c(long j) {
            this.e = Long.valueOf(j);
            return this;
        }

        public d.a d(String str) {
            this.a = str;
            return this;
        }

        public d.a e(String str) {
            this.g = str;
            return this;
        }

        public d.a f(String str) {
            this.d = str;
            return this;
        }

        public d.a g(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.b = aVar;
            return this;
        }

        public d.a h(long j) {
            this.f = Long.valueOf(j);
            return this;
        }

        public b(d dVar) {
            this.a = dVar.d();
            this.b = dVar.g();
            this.c = dVar.b();
            this.d = dVar.f();
            this.e = Long.valueOf(dVar.c());
            this.f = Long.valueOf(dVar.h());
            this.g = dVar.e();
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    public a(String str, c.a aVar, String str2, String str3, long j, long j2, String str4) {
        this.b = str;
        this.c = aVar;
        this.d = str2;
        this.e = str3;
        this.f = j;
        this.g = j2;
        this.h = str4;
    }

    public String b() {
        return this.d;
    }

    public long c() {
        return this.f;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.b;
        if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
            if (this.c.equals(dVar.g()) && ((str = this.d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f == dVar.c() && this.g == dVar.h()) {
                String str4 = this.h;
                String e = dVar.e();
                if (str4 == null) {
                    if (e == null) {
                        return true;
                    }
                } else if (str4.equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String f() {
        return this.e;
    }

    public c.a g() {
        return this.c;
    }

    public long h() {
        return this.g;
    }

    public int hashCode() {
        String str = this.b;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003;
        String str2 = this.d;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f;
        int i = (hashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.g;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.h;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public d.a n() {
        return new b(this, null);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.b + ", registrationStatus=" + this.c + ", authToken=" + this.d + ", refreshToken=" + this.e + ", expiresInSecs=" + this.f + ", tokenCreationEpochInSecs=" + this.g + ", fisError=" + this.h + "}";
    }

    public /* synthetic */ a(String str, c.a aVar, String str2, String str3, long j, long j2, String str4, a aVar2) {
        this(str, aVar, str2, str3, j, j2, str4);
    }
}
