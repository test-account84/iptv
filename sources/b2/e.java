package B2;

import B2.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e extends k {
    public final k.b a;
    public final B2.a b;

    public static final class b extends k.a {
        public k.b a;
        public B2.a b;

        public k a() {
            return new e(this.a, this.b, null);
        }

        public k.a b(B2.a aVar) {
            this.b = aVar;
            return this;
        }

        public k.a c(k.b bVar) {
            this.a = bVar;
            return this;
        }
    }

    public e(k.b bVar, B2.a aVar) {
        this.a = bVar;
        this.b = aVar;
    }

    public B2.a b() {
        return this.b;
    }

    public k.b c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k.b bVar = this.a;
        if (bVar != null ? bVar.equals(kVar.c()) : kVar.c() == null) {
            B2.a aVar = this.b;
            B2.a b2 = kVar.b();
            if (aVar == null) {
                if (b2 == null) {
                    return true;
                }
            } else if (aVar.equals(b2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k.b bVar = this.a;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        B2.a aVar = this.b;
        return hashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.a + ", androidClientInfo=" + this.b + "}";
    }

    public /* synthetic */ e(k.b bVar, B2.a aVar, a aVar2) {
        this(bVar, aVar);
    }
}
