package q5;

import android.os.IBinder;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u extends o {
    public final /* synthetic */ IBinder f;
    public final /* synthetic */ x g;

    public u(x xVar, IBinder iBinder) {
        this.g = xVar;
        this.f = iBinder;
    }

    public final void b() {
        y.k(this.g.a, j.A(this.f));
        y.n(this.g.a);
        y.j(this.g.a, false);
        Iterator it = y.g(this.g.a).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        y.g(this.g.a).clear();
    }
}
