package D2;

import D2.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends g {
    public final g.a a;
    public final long b;

    public b(g.a aVar, long j) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.a = aVar;
        this.b = j;
    }

    public long b() {
        return this.b;
    }

    public g.a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.c()) && this.b == gVar.b();
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.b;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.a + ", nextRequestWaitMillis=" + this.b + "}";
    }
}
