package P6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d extends h {
    public d(D6.a aVar) {
        super(aVar);
    }

    public String d() {
        if (c().l() < 48) {
            throw x6.k.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int f = b().f(48, 2);
        sb.append("(393");
        sb.append(f);
        sb.append(')');
        int f2 = b().f(50, 10);
        if (f2 / 100 == 0) {
            sb.append('0');
        }
        if (f2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(f2);
        sb.append(b().c(60, null).b());
        return sb.toString();
    }
}
