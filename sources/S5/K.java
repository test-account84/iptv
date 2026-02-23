package s5;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k extends Q implements Serializable {
    public final r5.f a;
    public final Q c;

    public k(r5.f fVar, Q q) {
        this.a = (r5.f) r5.m.k(fVar);
        this.c = (Q) r5.m.k(q);
    }

    public int compare(Object obj, Object obj2) {
        return this.c.compare(this.a.apply(obj), this.a.apply(obj2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a.equals(kVar.a) && this.c.equals(kVar.c);
    }

    public int hashCode() {
        return r5.j.b(this.a, this.c);
    }

    public String toString() {
        String valueOf = String.valueOf(this.c);
        String valueOf2 = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13 + valueOf2.length());
        sb.append(valueOf);
        sb.append(".onResultOf(");
        sb.append(valueOf2);
        sb.append(")");
        return sb.toString();
    }
}
