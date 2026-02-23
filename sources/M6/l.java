package M6;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class l extends p {
    public final p i = new e();

    public static x6.o s(x6.o oVar) {
        String f = oVar.f();
        if (f.charAt(0) != '0') {
            throw x6.g.a();
        }
        x6.o oVar2 = new x6.o(f.substring(1), null, oVar.e(), x6.a.UPC_A);
        if (oVar.d() != null) {
            oVar2.g(oVar.d());
        }
        return oVar2;
    }

    public x6.o a(x6.c cVar) {
        return s(this.i.a(cVar));
    }

    public x6.o b(x6.c cVar, Map map) {
        return s(this.i.b(cVar, map));
    }

    public x6.o c(int i, D6.a aVar, Map map) {
        return s(this.i.c(i, aVar, map));
    }

    public int l(D6.a aVar, int[] iArr, StringBuilder sb) {
        return this.i.l(aVar, iArr, sb);
    }

    public x6.o m(int i, D6.a aVar, int[] iArr, Map map) {
        return s(this.i.m(i, aVar, iArr, map));
    }

    public x6.a q() {
        return x6.a.UPC_A;
    }
}
