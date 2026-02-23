package G5;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ FirebaseAuth a;

    public k0(FirebaseAuth firebaseAuth) {
        this.a = firebaseAuth;
    }

    public final void run() {
        Iterator it = FirebaseAuth.E(this.a).iterator();
        if (it.hasNext()) {
            d.D.a(it.next());
            throw null;
        }
    }
}
