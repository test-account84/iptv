package C2;

import C2.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends o {
    public final p a;
    public final String b;
    public final z2.c c;
    public final z2.e d;
    public final z2.b e;

    public static final class b extends o.a {
        public p a;
        public String b;
        public z2.c c;
        public z2.e d;
        public z2.b e;

        public o a() {
            String str = "";
            if (this.a == null) {
                str = " transportContext";
            }
            if (this.b == null) {
                str = str + " transportName";
            }
            if (this.c == null) {
                str = str + " event";
            }
            if (this.d == null) {
                str = str + " transformer";
            }
            if (this.e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.a, this.b, this.c, this.d, this.e, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public o.a b(z2.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.e = bVar;
            return this;
        }

        public o.a c(z2.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null event");
            }
            this.c = cVar;
            return this;
        }

        public o.a d(z2.e eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.d = eVar;
            return this;
        }

        public o.a e(p pVar) {
            if (pVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.a = pVar;
            return this;
        }

        public o.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.b = str;
            return this;
        }
    }

    public c(p pVar, String str, z2.c cVar, z2.e eVar, z2.b bVar) {
        this.a = pVar;
        this.b = str;
        this.c = cVar;
        this.d = eVar;
        this.e = bVar;
    }

    public z2.b b() {
        return this.e;
    }

    public z2.c c() {
        return this.c;
    }

    public z2.e e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a.equals(oVar.f()) && this.b.equals(oVar.g()) && this.c.equals(oVar.c()) && this.d.equals(oVar.e()) && this.e.equals(oVar.b());
    }

    public p f() {
        return this.a;
    }

    public String g() {
        return this.b;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.a + ", transportName=" + this.b + ", event=" + this.c + ", transformer=" + this.d + ", encoding=" + this.e + "}";
    }

    public /* synthetic */ c(p pVar, String str, z2.c cVar, z2.e eVar, z2.b bVar, a aVar) {
        this(pVar, str, cVar, eVar, bVar);
    }
}
