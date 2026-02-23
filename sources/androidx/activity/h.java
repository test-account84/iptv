package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h {
    public boolean a;
    public CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public O.a c;

    public h(boolean z) {
        this.a = z;
    }

    public void a(a aVar) {
        this.b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.a;
    }

    public final void d() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).cancel();
        }
    }

    public void e(a aVar) {
        this.b.remove(aVar);
    }

    public final void f(boolean z) {
        this.a = z;
        O.a aVar = this.c;
        if (aVar != null) {
            aVar.accept(Boolean.valueOf(z));
        }
    }

    public void g(O.a aVar) {
        this.c = aVar;
    }
}
