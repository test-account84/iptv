package B2;

import B2.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends B2.a {
    public final Integer a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public static final class b extends a.a {
        public Integer a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;

        public B2.a a() {
            return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null);
        }

        public a.a b(String str) {
            this.l = str;
            return this;
        }

        public a.a c(String str) {
            this.j = str;
            return this;
        }

        public a.a d(String str) {
            this.d = str;
            return this;
        }

        public a.a e(String str) {
            this.h = str;
            return this;
        }

        public a.a f(String str) {
            this.c = str;
            return this;
        }

        public a.a g(String str) {
            this.i = str;
            return this;
        }

        public a.a h(String str) {
            this.g = str;
            return this;
        }

        public a.a i(String str) {
            this.k = str;
            return this;
        }

        public a.a j(String str) {
            this.b = str;
            return this;
        }

        public a.a k(String str) {
            this.f = str;
            return this;
        }

        public a.a l(String str) {
            this.e = str;
            return this;
        }

        public a.a m(Integer num) {
            this.a = num;
            return this;
        }
    }

    public c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
    }

    public String b() {
        return this.l;
    }

    public String c() {
        return this.j;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B2.a)) {
            return false;
        }
        B2.a aVar = (B2.a) obj;
        Integer num = this.a;
        if (num != null ? num.equals(aVar.m()) : aVar.m() == null) {
            String str = this.b;
            if (str != null ? str.equals(aVar.j()) : aVar.j() == null) {
                String str2 = this.c;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.d;
                    if (str3 != null ? str3.equals(aVar.d()) : aVar.d() == null) {
                        String str4 = this.e;
                        if (str4 != null ? str4.equals(aVar.l()) : aVar.l() == null) {
                            String str5 = this.f;
                            if (str5 != null ? str5.equals(aVar.k()) : aVar.k() == null) {
                                String str6 = this.g;
                                if (str6 != null ? str6.equals(aVar.h()) : aVar.h() == null) {
                                    String str7 = this.h;
                                    if (str7 != null ? str7.equals(aVar.e()) : aVar.e() == null) {
                                        String str8 = this.i;
                                        if (str8 != null ? str8.equals(aVar.g()) : aVar.g() == null) {
                                            String str9 = this.j;
                                            if (str9 != null ? str9.equals(aVar.c()) : aVar.c() == null) {
                                                String str10 = this.k;
                                                if (str10 != null ? str10.equals(aVar.i()) : aVar.i() == null) {
                                                    String str11 = this.l;
                                                    String b2 = aVar.b();
                                                    if (str11 == null) {
                                                        if (b2 == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(b2)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.i;
    }

    public String h() {
        return this.g;
    }

    public int hashCode() {
        Integer num = this.a;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.h;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.j;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.k;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.l;
        return hashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    public String i() {
        return this.k;
    }

    public String j() {
        return this.b;
    }

    public String k() {
        return this.f;
    }

    public String l() {
        return this.e;
    }

    public Integer m() {
        return this.a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.a + ", model=" + this.b + ", hardware=" + this.c + ", device=" + this.d + ", product=" + this.e + ", osBuild=" + this.f + ", manufacturer=" + this.g + ", fingerprint=" + this.h + ", locale=" + this.i + ", country=" + this.j + ", mccMnc=" + this.k + ", applicationBuild=" + this.l + "}";
    }

    public /* synthetic */ c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, a aVar) {
        this(num, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }
}
