package j$.time.format;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class m implements f {
    private final j$.time.temporal.r a;
    private final v b;
    private final b c;
    private volatile i d;

    m(j$.time.temporal.r rVar, v vVar, b bVar) {
        this.a = rVar;
        this.b = vVar;
        this.c = bVar;
    }

    public final boolean i(p pVar, StringBuilder sb) {
        Long e = pVar.e(this.a);
        if (e == null) {
            return false;
        }
        j$.time.chrono.n nVar = (j$.time.chrono.n) pVar.d().t(j$.time.temporal.n.e());
        String c = (nVar == null || nVar == j$.time.chrono.u.d) ? this.c.c(this.a, e.longValue(), this.b, pVar.c()) : this.c.b(nVar, this.a, e.longValue(), this.b, pVar.c());
        if (c != null) {
            sb.append(c);
            return true;
        }
        if (this.d == null) {
            this.d = new i(this.a, 1, 19, u.NORMAL);
        }
        return this.d.i(pVar, sb);
    }

    public final String toString() {
        StringBuilder sb;
        v vVar = v.FULL;
        j$.time.temporal.r rVar = this.a;
        v vVar2 = this.b;
        if (vVar2 == vVar) {
            sb = new StringBuilder("Text(");
            sb.append(rVar);
        } else {
            sb = new StringBuilder("Text(");
            sb.append(rVar);
            sb.append(",");
            sb.append(vVar2);
        }
        sb.append(")");
        return sb.toString();
    }
}
