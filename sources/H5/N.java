package H5;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n implements Runnable {
    public final String a;
    public final /* synthetic */ o c;

    public n(o oVar, String str) {
        this.c = oVar;
        this.a = com.google.android.gms.common.internal.r.g(str);
    }

    public final void run() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(A5.f.n(this.a));
        if (firebaseAuth.c() != null) {
            Task a = firebaseAuth.a(true);
            o.a().f("Token refreshing started", new Object[0]);
            a.addOnFailureListener(new q(this));
        }
    }
}
