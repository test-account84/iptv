package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n extends B.e.d.a.b {
    public final C a;
    public final B.e.d.a.b.c b;
    public final B.a c;
    public final B.e.d.a.b.d d;
    public final C e;

    public static final class b extends B.e.d.a.b.b {
        public C a;
        public B.e.d.a.b.c b;
        public B.a c;
        public B.e.d.a.b.d d;
        public C e;

        public B.e.d.a.b a() {
            String str = "";
            if (this.d == null) {
                str = " signal";
            }
            if (this.e == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new n(this.a, this.b, this.c, this.d, this.e, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.d.a.b.b b(B.a aVar) {
            this.c = aVar;
            return this;
        }

        public B.e.d.a.b.b c(C c) {
            if (c == null) {
                throw new NullPointerException("Null binaries");
            }
            this.e = c;
            return this;
        }

        public B.e.d.a.b.b d(B.e.d.a.b.c cVar) {
            this.b = cVar;
            return this;
        }

        public B.e.d.a.b.b e(B.e.d.a.b.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null signal");
            }
            this.d = dVar;
            return this;
        }

        public B.e.d.a.b.b f(C c) {
            this.a = c;
            return this;
        }
    }

    public n(C c, B.e.d.a.b.c cVar, B.a aVar, B.e.d.a.b.d dVar, C c2) {
        this.a = c;
        this.b = cVar;
        this.c = aVar;
        this.d = dVar;
        this.e = c2;
    }

    public B.a b() {
        return this.c;
    }

    public C c() {
        return this.e;
    }

    public B.e.d.a.b.c d() {
        return this.b;
    }

    public B.e.d.a.b.d e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.d.a.b)) {
            return false;
        }
        B.e.d.a.b bVar = (B.e.d.a.b) obj;
        C c = this.a;
        if (c != null ? c.equals(bVar.f()) : bVar.f() == null) {
            B.e.d.a.b.c cVar = this.b;
            if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                B.a aVar = this.c;
                if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                    if (this.d.equals(bVar.e()) && this.e.equals(bVar.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public C f() {
        return this.a;
    }

    public int hashCode() {
        C c = this.a;
        int hashCode = ((c == null ? 0 : c.hashCode()) ^ 1000003) * 1000003;
        B.e.d.a.b.c cVar = this.b;
        int hashCode2 = (hashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        B.a aVar = this.c;
        return ((((hashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.a + ", exception=" + this.b + ", appExitInfo=" + this.c + ", signal=" + this.d + ", binaries=" + this.e + "}";
    }

    public /* synthetic */ n(C c, B.e.d.a.b.c cVar, B.a aVar, B.e.d.a.b.d dVar, C c2, a aVar2) {
        this(c, cVar, aVar, dVar, c2);
    }
}
