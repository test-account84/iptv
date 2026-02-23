package y;

import y.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends f {
    public int m;

    public g(m mVar) {
        super(mVar);
        this.e = mVar instanceof j ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (d dVar : this.k) {
            dVar.a(dVar);
        }
    }
}
