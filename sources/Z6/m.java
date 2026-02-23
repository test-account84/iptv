package Z6;

import Y6.v;
import android.graphics.Rect;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class m {
    public v a;
    public int b;
    public boolean c = false;
    public q d = new n();

    public m(int i, v vVar) {
        this.b = i;
        this.a = vVar;
    }

    public v a(List list, boolean z) {
        return this.d.b(list, b(z));
    }

    public v b(boolean z) {
        v vVar = this.a;
        if (vVar == null) {
            return null;
        }
        return z ? vVar.b() : vVar;
    }

    public int c() {
        return this.b;
    }

    public Rect d(v vVar) {
        return this.d.d(vVar, this.a);
    }

    public void e(q qVar) {
        this.d = qVar;
    }
}
