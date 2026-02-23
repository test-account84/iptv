package s2;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends RecyclerView.g {
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public Drawable j;

    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void E(f fVar, int i) {
        fVar.P();
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public f L(ViewGroup viewGroup, int i) {
        f fVar = new f(LayoutInflater.from(viewGroup.getContext()), viewGroup, this.e);
        fVar.U(this.g);
        fVar.S(this.f);
        fVar.V(this.j);
        fVar.T(this.h);
        fVar.Q(this.i);
        return fVar;
    }

    public void l0(boolean z) {
        this.i = z;
    }

    public void m0(int i) {
        this.e = i;
    }

    public int n() {
        return this.d;
    }

    public void n0(int i) {
        this.d = i;
    }

    public void p0(int i) {
        this.f = i;
    }

    public void q0(int i) {
        this.g = i;
    }

    public void r0(int i) {
        this.h = i;
    }

    public void s0(Drawable drawable) {
        this.j = drawable;
    }
}
