package androidx.lifecycle;

import androidx.lifecycle.j;
import k8.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements n {
    public final /* synthetic */ j.c a;
    public final /* synthetic */ j c;
    public final /* synthetic */ G8.n d;
    public final /* synthetic */ w8.a e;

    public void b(p pVar, j.b bVar) {
        G8.n nVar;
        Throwable th;
        Object b;
        kotlin.jvm.internal.l.e(pVar, "source");
        kotlin.jvm.internal.l.e(bVar, "event");
        if (bVar == j.b.upTo(this.a)) {
            this.c.c(this);
            nVar = this.d;
            w8.a aVar = this.e;
            try {
                j.a aVar2 = k8.j.c;
                b = k8.j.b(aVar.invoke());
            } catch (Throwable th2) {
                th = th2;
                j.a aVar3 = k8.j.c;
            }
            nVar.resumeWith(b);
        }
        if (bVar != j.b.ON_DESTROY) {
            return;
        }
        this.c.c(this);
        nVar = this.d;
        j.a aVar4 = k8.j.c;
        th = new l();
        b = k8.j.b(k8.k.a(th));
        nVar.resumeWith(b);
    }
}
