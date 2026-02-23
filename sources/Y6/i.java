package Y6;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i implements x6.r {
    public x6.m a;
    public List b = new ArrayList();

    public i(x6.m mVar) {
        this.a = mVar;
    }

    public void a(x6.q qVar) {
        this.b.add(qVar);
    }

    public x6.o b(x6.c cVar) {
        this.b.clear();
        try {
            x6.m mVar = this.a;
            if (mVar instanceof x6.j) {
                x6.o d = ((x6.j) mVar).d(cVar);
                this.a.reset();
                return d;
            }
            x6.o a = mVar.a(cVar);
            this.a.reset();
            return a;
        } catch (Exception unused) {
            this.a.reset();
            return null;
        } catch (Throwable th) {
            this.a.reset();
            throw th;
        }
    }

    public x6.o c(x6.i iVar) {
        return b(e(iVar));
    }

    public List d() {
        return new ArrayList(this.b);
    }

    public x6.c e(x6.i iVar) {
        return new x6.c(new D6.j(iVar));
    }
}
