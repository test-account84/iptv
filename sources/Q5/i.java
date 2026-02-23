package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i extends B.e.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public static final class b extends B.e.a.a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;

        public B.e.a a() {
            String str = "";
            if (this.a == null) {
                str = " identifier";
            }
            if (this.b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new i(this.a, this.b, this.c, null, this.d, this.e, this.f, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.a.a b(String str) {
            this.e = str;
            return this;
        }

        public B.e.a.a c(String str) {
            this.f = str;
            return this;
        }

        public B.e.a.a d(String str) {
            this.c = str;
            return this;
        }

        public B.e.a.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.a = str;
            return this;
        }

        public B.e.a.a f(String str) {
            this.d = str;
            return this;
        }

        public B.e.a.a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.b = str;
            return this;
        }
    }

    public i(String str, String str2, String str3, B.e.a.b bVar, String str4, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.a)) {
            return false;
        }
        B.e.a aVar = (B.e.a) obj;
        if (this.a.equals(aVar.e()) && this.b.equals(aVar.h()) && ((str = this.c) != null ? str.equals(aVar.d()) : aVar.d() == null)) {
            aVar.g();
            String str2 = this.d;
            if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                String str3 = this.e;
                if (str3 != null ? str3.equals(aVar.b()) : aVar.b() == null) {
                    String str4 = this.f;
                    String c = aVar.c();
                    if (str4 == null) {
                        if (c == null) {
                            return true;
                        }
                    } else if (str4.equals(c)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.d;
    }

    public B.e.a.b g() {
        return null;
    }

    public String h() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str = this.c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.d;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f;
        return hashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.a + ", version=" + this.b + ", displayVersion=" + this.c + ", organization=" + ((Object) null) + ", installationUuid=" + this.d + ", developmentPlatform=" + this.e + ", developmentPlatformVersion=" + this.f + "}";
    }

    public /* synthetic */ i(String str, String str2, String str3, B.e.a.b bVar, String str4, String str5, String str6, a aVar) {
        this(str, str2, str3, bVar, str4, str5, str6);
    }
}
