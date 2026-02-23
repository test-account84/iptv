package b4;

import d4.k0;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class g implements o {
    public final boolean a;
    public final ArrayList b = new ArrayList(1);
    public int c;
    public s d;

    public g(boolean z) {
        this.a = z;
    }

    public /* synthetic */ Map e() {
        return n.a(this);
    }

    public final void g(S s) {
        d4.a.e(s);
        if (this.b.contains(s)) {
            return;
        }
        this.b.add(s);
        this.c++;
    }

    public final void t(int i) {
        s sVar = (s) k0.j(this.d);
        for (int i2 = 0; i2 < this.c; i2++) {
            ((S) this.b.get(i2)).f(this, sVar, this.a, i);
        }
    }

    public final void u() {
        s sVar = (s) k0.j(this.d);
        for (int i = 0; i < this.c; i++) {
            ((S) this.b.get(i)).i(this, sVar, this.a);
        }
        this.d = null;
    }

    public final void v(s sVar) {
        for (int i = 0; i < this.c; i++) {
            ((S) this.b.get(i)).c(this, sVar, this.a);
        }
    }

    public final void w(s sVar) {
        this.d = sVar;
        for (int i = 0; i < this.c; i++) {
            ((S) this.b.get(i)).a(this, sVar, this.a);
        }
    }
}
