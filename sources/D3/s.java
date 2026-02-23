package d3;

import d4.M;
import java.io.EOFException;
import v3.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s {
    public final M a = new M(10);

    public q3.a a(j jVar, h.a aVar) {
        q3.a aVar2 = null;
        int i = 0;
        while (true) {
            try {
                jVar.s(this.a.e(), 0, 10);
                this.a.U(0);
                if (this.a.K() != 4801587) {
                    break;
                }
                this.a.V(3);
                int G = this.a.G();
                int i2 = G + 10;
                if (aVar2 == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.a.e(), 0, bArr, 0, 10);
                    jVar.s(bArr, 10, G);
                    aVar2 = new v3.h(aVar).e(bArr, i2);
                } else {
                    jVar.n(G);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        jVar.f();
        jVar.n(i);
        return aVar2;
    }
}
