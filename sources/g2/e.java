package g2;

import U1.l;
import android.graphics.Bitmap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e implements S1.g {
    public final S1.g a;
    public final V1.b b;

    public e(S1.g gVar, V1.b bVar) {
        this.a = gVar;
        this.b = bVar;
    }

    public l a(l lVar, int i, int i2) {
        b bVar = (b) lVar.get();
        Bitmap e = ((b) lVar.get()).e();
        Bitmap bitmap = (Bitmap) this.a.a(new d2.c(e, this.b), i, i2).get();
        return !bitmap.equals(e) ? new d(new b(bVar, bitmap, this.a)) : lVar;
    }

    public String getId() {
        return this.a.getId();
    }
}
