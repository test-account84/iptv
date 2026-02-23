package m6;

import m6.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends d {
    public final String a;
    public final String b;
    public final String c;
    public final f d;
    public final d.b e;

    public static final class b extends d.a {
        public String a;
        public String b;
        public String c;
        public f d;
        public d.b e;

        public d a() {
            return new a(this.a, this.b, this.c, this.d, this.e, null);
        }

        public d.a b(f fVar) {
            this.d = fVar;
            return this;
        }

        public d.a c(String str) {
            this.b = str;
            return this;
        }

        public d.a d(String str) {
            this.c = str;
            return this;
        }

        public d.a e(d.b bVar) {
            this.e = bVar;
            return this;
        }

        public d.a f(String str) {
            this.a = str;
            return this;
        }
    }

    public a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = fVar;
        this.e = bVar;
    }

    public f b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public d.b e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.a;
        if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
            String str2 = this.b;
            if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                String str3 = this.c;
                if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                    f fVar = this.d;
                    if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                        d.b bVar = this.e;
                        d.b e = dVar.e();
                        if (bVar == null) {
                            if (e == null) {
                                return true;
                            }
                        } else if (bVar.equals(e)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.d;
        int hashCode4 = (hashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.e;
        return hashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.a + ", fid=" + this.b + ", refreshToken=" + this.c + ", authToken=" + this.d + ", responseCode=" + this.e + "}";
    }

    public /* synthetic */ a(String str, String str2, String str3, f fVar, d.b bVar, a aVar) {
        this(str, str2, str3, fVar, bVar);
    }
}
