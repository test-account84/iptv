package G5;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ FirebaseAuth a;
    public final /* synthetic */ o6.b c;

    public i0(FirebaseAuth firebaseAuth, o6.b bVar) {
        this.a = firebaseAuth;
        this.c = bVar;
    }

    public final void run() {
        Iterator it = FirebaseAuth.H(this.a).iterator();
        if (it.hasNext()) {
            d.D.a(it.next());
            throw null;
        }
        Iterator it2 = FirebaseAuth.F(this.a).iterator();
        if (it2.hasNext()) {
            d.D.a(it2.next());
            throw null;
        }
    }
}
