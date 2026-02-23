package B2;

import B2.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i extends o {
    public final o.c a;
    public final o.b b;

    public static final class b extends o.a {
        public o.c a;
        public o.b b;

        public o a() {
            return new i(this.a, this.b, null);
        }

        public o.a b(o.b bVar) {
            this.b = bVar;
            return this;
        }

        public o.a c(o.c cVar) {
            this.a = cVar;
            return this;
        }
    }

    public i(o.c cVar, o.b bVar) {
        this.a = cVar;
        this.b = bVar;
    }

    public o.b b() {
        return this.b;
    }

    public o.c c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.c cVar = this.a;
        if (cVar != null ? cVar.equals(oVar.c()) : oVar.c() == null) {
            o.b bVar = this.b;
            o.b b2 = oVar.b();
            if (bVar == null) {
                if (b2 == null) {
                    return true;
                }
            } else if (bVar.equals(b2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.c cVar = this.a;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        o.b bVar = this.b;
        return hashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.a + ", mobileSubtype=" + this.b + "}";
    }

    public /* synthetic */ i(o.c cVar, o.b bVar, a aVar) {
        this(cVar, bVar);
    }
}
