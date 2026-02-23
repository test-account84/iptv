package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m extends B.e.d.a {
    public final B.e.d.a.b a;
    public final C b;
    public final C c;
    public final Boolean d;
    public final int e;

    public static final class b extends B.e.d.a.a {
        public B.e.d.a.b a;
        public C b;
        public C c;
        public Boolean d;
        public Integer e;

        public b() {
        }

        public B.e.d.a a() {
            String str = "";
            if (this.a == null) {
                str = " execution";
            }
            if (this.e == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new m(this.a, this.b, this.c, this.d, this.e.intValue(), null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.d.a.a b(Boolean bool) {
            this.d = bool;
            return this;
        }

        public B.e.d.a.a c(C c) {
            this.b = c;
            return this;
        }

        public B.e.d.a.a d(B.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.a = bVar;
            return this;
        }

        public B.e.d.a.a e(C c) {
            this.c = c;
            return this;
        }

        public B.e.d.a.a f(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public b(B.e.d.a aVar) {
            this.a = aVar.d();
            this.b = aVar.c();
            this.c = aVar.e();
            this.d = aVar.b();
            this.e = Integer.valueOf(aVar.f());
        }

        public /* synthetic */ b(B.e.d.a aVar, a aVar2) {
            this(aVar);
        }
    }

    public m(B.e.d.a.b bVar, C c, C c2, Boolean bool, int i) {
        this.a = bVar;
        this.b = c;
        this.c = c2;
        this.d = bool;
        this.e = i;
    }

    public Boolean b() {
        return this.d;
    }

    public C c() {
        return this.b;
    }

    public B.e.d.a.b d() {
        return this.a;
    }

    public C e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        C c;
        C c2;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.d.a)) {
            return false;
        }
        B.e.d.a aVar = (B.e.d.a) obj;
        return this.a.equals(aVar.d()) && ((c = this.b) != null ? c.equals(aVar.c()) : aVar.c() == null) && ((c2 = this.c) != null ? c2.equals(aVar.e()) : aVar.e() == null) && ((bool = this.d) != null ? bool.equals(aVar.b()) : aVar.b() == null) && this.e == aVar.f();
    }

    public int f() {
        return this.e;
    }

    public B.e.d.a.a g() {
        return new b(this, null);
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        C c = this.b;
        int hashCode2 = (hashCode ^ (c == null ? 0 : c.hashCode())) * 1000003;
        C c2 = this.c;
        int hashCode3 = (hashCode2 ^ (c2 == null ? 0 : c2.hashCode())) * 1000003;
        Boolean bool = this.d;
        return ((hashCode3 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.e;
    }

    public String toString() {
        return "Application{execution=" + this.a + ", customAttributes=" + this.b + ", internalKeys=" + this.c + ", background=" + this.d + ", uiOrientation=" + this.e + "}";
    }

    public /* synthetic */ m(B.e.d.a.b bVar, C c, C c2, Boolean bool, int i, a aVar) {
        this(bVar, c, c2, bool, i);
    }
}
