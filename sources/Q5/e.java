package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e extends B.c {
    public final String a;
    public final String b;

    public static final class b extends B.c.a {
        public String a;
        public String b;

        public B.c a() {
            String str = "";
            if (this.a == null) {
                str = " key";
            }
            if (this.b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new e(this.a, this.b, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.a = str;
            return this;
        }

        public B.c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.b = str;
            return this;
        }
    }

    public e(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.c)) {
            return false;
        }
        B.c cVar = (B.c) obj;
        return this.a.equals(cVar.b()) && this.b.equals(cVar.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.a + ", value=" + this.b + "}";
    }

    public /* synthetic */ e(String str, String str2, a aVar) {
        this(str, str2);
    }
}
