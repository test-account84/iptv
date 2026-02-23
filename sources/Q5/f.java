package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f extends B.d {
    public final C a;
    public final String b;

    public static final class b extends B.d.a {
        public C a;
        public String b;

        public B.d a() {
            String str = "";
            if (this.a == null) {
                str = " files";
            }
            if (str.isEmpty()) {
                return new f(this.a, this.b, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.d.a b(C c) {
            if (c == null) {
                throw new NullPointerException("Null files");
            }
            this.a = c;
            return this;
        }

        public B.d.a c(String str) {
            this.b = str;
            return this;
        }
    }

    public f(C c, String str) {
        this.a = c;
        this.b = str;
    }

    public C b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.d)) {
            return false;
        }
        B.d dVar = (B.d) obj;
        if (this.a.equals(dVar.b())) {
            String str = this.b;
            String c = dVar.c();
            if (str == null) {
                if (c == null) {
                    return true;
                }
            } else if (str.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.a + ", orgId=" + this.b + "}";
    }

    public /* synthetic */ f(C c, String str, a aVar) {
        this(c, str);
    }
}
