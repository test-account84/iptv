package androidx.lifecycle;

import androidx.lifecycle.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class SavedStateHandleController implements n {
    public final String a;
    public boolean c = false;
    public final B d;

    public SavedStateHandleController(String str, B b) {
        this.a = str;
        this.d = b;
    }

    public void b(p pVar, j.b bVar) {
        if (bVar == j.b.ON_DESTROY) {
            this.c = false;
            pVar.getLifecycle().c(this);
        }
    }

    public void c(F0.c cVar, j jVar) {
        if (this.c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.c = true;
        jVar.a(this);
        cVar.h(this.a, this.d.d());
    }

    public B e() {
        return this.d;
    }

    public boolean j() {
        return this.c;
    }
}
