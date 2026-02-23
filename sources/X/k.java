package x;

import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class k extends e {
    public ArrayList w0 = new ArrayList();

    public abstract void G0();

    public void H0(e eVar) {
        this.w0.remove(eVar);
        eVar.s0(null);
    }

    public void I0() {
        this.w0.clear();
    }

    public void W() {
        this.w0.clear();
        super.W();
    }

    public void X(w.c cVar) {
        super.X(cVar);
        int size = this.w0.size();
        for (int i = 0; i < size; i++) {
            ((e) this.w0.get(i)).X(cVar);
        }
    }

    public void b(e eVar) {
        this.w0.add(eVar);
        if (eVar.E() != null) {
            ((k) eVar.E()).H0(eVar);
        }
        eVar.s0(this);
    }
}
