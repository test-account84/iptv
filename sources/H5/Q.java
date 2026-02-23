package H5;

import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements OnFailureListener {
    public final /* synthetic */ n a;

    public q(n nVar) {
        this.a = nVar;
    }

    public final void onFailure(Exception exc) {
        if (exc instanceof A5.n) {
            o.a().f("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.a.c.d();
        }
    }
}
