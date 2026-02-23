package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class FragmentManager$6 implements androidx.lifecycle.n {
    public final /* synthetic */ String a;
    public final /* synthetic */ androidx.lifecycle.j c;
    public final /* synthetic */ m d;

    public void b(androidx.lifecycle.p pVar, j.b bVar) {
        if (bVar == j.b.ON_START && ((Bundle) m.a(this.d).get(this.a)) != null) {
            throw null;
        }
        if (bVar == j.b.ON_DESTROY) {
            this.c.c(this);
            m.b(this.d).remove(this.a);
        }
    }
}
