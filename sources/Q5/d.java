package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends B.a.a {
    public final String a;
    public final String b;
    public final String c;

    public static final class b extends B.a.a.a {
        public String a;
        public String b;
        public String c;

        public B.a.a a() {
            String str = "";
            if (this.a == null) {
                str = " arch";
            }
            if (this.b == null) {
                str = str + " libraryName";
            }
            if (this.c == null) {
                str = str + " buildId";
            }
            if (str.isEmpty()) {
                return new d(this.a, this.b, this.c, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.a.a.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.a = str;
            return this;
        }

        public B.a.a.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.c = str;
            return this;
        }

        public B.a.a.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.b = str;
            return this;
        }
    }

    public d(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.a.a)) {
            return false;
        }
        B.a.a aVar = (B.a.a) obj;
        return this.a.equals(aVar.b()) && this.b.equals(aVar.d()) && this.c.equals(aVar.c());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.a + ", libraryName=" + this.b + ", buildId=" + this.c + "}";
    }

    public /* synthetic */ d(String str, String str2, String str3, a aVar) {
        this(str, str2, str3);
    }
}
