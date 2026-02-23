package k6;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class k implements o {
    public final p a;
    public final TaskCompletionSource b;

    public k(p pVar, TaskCompletionSource taskCompletionSource) {
        this.a = pVar;
        this.b = taskCompletionSource;
    }

    public boolean a(Exception exc) {
        this.b.trySetException(exc);
        return true;
    }

    public boolean b(l6.d dVar) {
        if (!dVar.k() || this.a.f(dVar)) {
            return false;
        }
        this.b.setResult(m.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }
}
