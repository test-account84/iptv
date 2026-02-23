package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class m extends s {
    public final t a;

    public m(t tVar) {
        this.a = tVar;
    }

    public boolean e() {
        return true;
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public l a() {
        return new l(this);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public k b(l lVar, Bundle bundle, p pVar, s.a aVar) {
        int E = lVar.E();
        if (E == 0) {
            throw new IllegalStateException("no start destination defined via app:startDestination for " + lVar.g());
        }
        k B = lVar.B(E, false);
        if (B != null) {
            return this.a.e(B.l()).b(B, B.c(bundle), pVar, aVar);
        }
        throw new IllegalArgumentException("navigation destination " + lVar.D() + " is not a direct child of this NavGraph");
    }
}
