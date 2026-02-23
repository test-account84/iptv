package k6;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class l implements o {
    public final TaskCompletionSource a;

    public l(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    public boolean a(Exception exc) {
        return false;
    }

    public boolean b(l6.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.a.trySetResult(dVar.d());
        return true;
    }
}
