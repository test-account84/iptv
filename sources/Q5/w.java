package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w extends B.e.f {
    public final String a;

    public static final class b extends B.e.f.a {
        public String a;

        public B.e.f a() {
            String str = "";
            if (this.a == null) {
                str = " identifier";
            }
            if (str.isEmpty()) {
                return new w(this.a, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.a = str;
            return this;
        }
    }

    public w(String str) {
        this.a = str;
    }

    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof B.e.f) {
            return this.a.equals(((B.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.a + "}";
    }

    public /* synthetic */ w(String str, a aVar) {
        this(str);
    }
}
