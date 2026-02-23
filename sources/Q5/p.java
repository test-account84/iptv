package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p extends B.e.d.a.b.c {
    public final String a;
    public final String b;
    public final C c;
    public final B.e.d.a.b.c d;
    public final int e;

    public static final class b extends B.e.d.a.b.c.a {
        public String a;
        public String b;
        public C c;
        public B.e.d.a.b.c d;
        public Integer e;

        public B.e.d.a.b.c a() {
            String str = "";
            if (this.a == null) {
                str = " type";
            }
            if (this.c == null) {
                str = str + " frames";
            }
            if (this.e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new p(this.a, this.b, this.c, this.d, this.e.intValue(), null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.d.a.b.c.a b(B.e.d.a.b.c cVar) {
            this.d = cVar;
            return this;
        }

        public B.e.d.a.b.c.a c(C c) {
            if (c == null) {
                throw new NullPointerException("Null frames");
            }
            this.c = c;
            return this;
        }

        public B.e.d.a.b.c.a d(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public B.e.d.a.b.c.a e(String str) {
            this.b = str;
            return this;
        }

        public B.e.d.a.b.c.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.a = str;
            return this;
        }
    }

    public p(String str, String str2, C c, B.e.d.a.b.c cVar, int i) {
        this.a = str;
        this.b = str2;
        this.c = c;
        this.d = cVar;
        this.e = i;
    }

    public B.e.d.a.b.c b() {
        return this.d;
    }

    public C c() {
        return this.c;
    }

    public int d() {
        return this.e;
    }

    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        String str;
        B.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.d.a.b.c)) {
            return false;
        }
        B.e.d.a.b.c cVar2 = (B.e.d.a.b.c) obj;
        return this.a.equals(cVar2.f()) && ((str = this.b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.c.equals(cVar2.c()) && ((cVar = this.d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.e == cVar2.d();
    }

    public String f() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        B.e.d.a.b.c cVar = this.d;
        return ((hashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.e;
    }

    public String toString() {
        return "Exception{type=" + this.a + ", reason=" + this.b + ", frames=" + this.c + ", causedBy=" + this.d + ", overflowCount=" + this.e + "}";
    }

    public /* synthetic */ p(String str, String str2, C c, B.e.d.a.b.c cVar, int i, a aVar) {
        this(str, str2, c, cVar, i);
    }
}
