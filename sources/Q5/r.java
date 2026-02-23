package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r extends B.e.d.a.b.e {
    public final String a;
    public final int b;
    public final C c;

    public static final class b extends B.e.d.a.b.e.a {
        public String a;
        public Integer b;
        public C c;

        public B.e.d.a.b.e a() {
            String str = "";
            if (this.a == null) {
                str = " name";
            }
            if (this.b == null) {
                str = str + " importance";
            }
            if (this.c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new r(this.a, this.b.intValue(), this.c, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.d.a.b.e.a b(C c) {
            if (c == null) {
                throw new NullPointerException("Null frames");
            }
            this.c = c;
            return this;
        }

        public B.e.d.a.b.e.a c(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public B.e.d.a.b.e.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.a = str;
            return this;
        }
    }

    public r(String str, int i, C c) {
        this.a = str;
        this.b = i;
        this.c = c;
    }

    public C b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.d.a.b.e)) {
            return false;
        }
        B.e.d.a.b.e eVar = (B.e.d.a.b.e) obj;
        return this.a.equals(eVar.d()) && this.b == eVar.c() && this.c.equals(eVar.b());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.a + ", importance=" + this.b + ", frames=" + this.c + "}";
    }

    public /* synthetic */ r(String str, int i, C c, a aVar) {
        this(str, i, c);
    }
}
