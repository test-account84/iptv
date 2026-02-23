package J2;

import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class v {
    public final Executor a;
    public final K2.d b;
    public final x c;
    public final L2.b d;

    public v(Executor executor, K2.d dVar, x xVar, L2.b bVar) {
        this.a = executor;
        this.b = dVar;
        this.c = xVar;
        this.d = bVar;
    }

    public static /* synthetic */ Object a(v vVar) {
        return vVar.d();
    }

    public static /* synthetic */ void b(v vVar) {
        vVar.e();
    }

    public void c() {
        this.a.execute(new t(this));
    }

    public final /* synthetic */ Object d() {
        Iterator it = this.b.F().iterator();
        while (it.hasNext()) {
            this.c.b((C2.p) it.next(), 1);
        }
        return null;
    }

    public final /* synthetic */ void e() {
        this.d.a(new u(this));
    }
}
