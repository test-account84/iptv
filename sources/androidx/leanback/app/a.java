package androidx.leanback.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.B;
import androidx.leanback.widget.F;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.t;
import androidx.leanback.widget.y;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a extends Fragment {
    public y a;
    public VerticalGridView c;
    public F d;
    public boolean g;
    public final t e = new t();
    public int f = -1;
    public b h = new b();
    public final B i = new a();

    public class a extends B {
        public a() {
        }

        public void a(RecyclerView recyclerView, RecyclerView.D d, int i, int i2) {
            a aVar = a.this;
            if (aVar.h.a) {
                return;
            }
            aVar.f = i;
            aVar.J(recyclerView, d, i, i2);
        }
    }

    public class b extends RecyclerView.i {
        public boolean a = false;

        public b() {
        }

        public void a() {
            g();
        }

        public void f() {
            if (this.a) {
                this.a = false;
                a.this.e.i0(this);
            }
        }

        public void g() {
            f();
            a aVar = a.this;
            VerticalGridView verticalGridView = aVar.c;
            if (verticalGridView != null) {
                verticalGridView.setSelectedPosition(aVar.f);
            }
        }

        public void h() {
            this.a = true;
            a.this.e.b0(this);
        }
    }

    public final t A() {
        return this.e;
    }

    public abstract int B();

    public int D() {
        return this.f;
    }

    public VerticalGridView E() {
        return this.c;
    }

    public abstract void J(RecyclerView recyclerView, RecyclerView.D d, int i, int i2);

    public boolean L() {
        VerticalGridView verticalGridView = this.c;
        if (verticalGridView == null) {
            this.g = true;
            return false;
        }
        verticalGridView.setAnimateChildLayout(false);
        this.c.setScrollEnabled(false);
        return true;
    }

    public void P(y yVar) {
        if (this.a != yVar) {
            this.a = yVar;
            X();
        }
    }

    public void S() {
        if (this.a == null) {
            return;
        }
        RecyclerView.g adapter = this.c.getAdapter();
        t tVar = this.e;
        if (adapter != tVar) {
            this.c.setAdapter(tVar);
        }
        if (this.e.n() == 0 && this.f >= 0) {
            this.h.h();
            return;
        }
        int i = this.f;
        if (i >= 0) {
            this.c.setSelectedPosition(i);
        }
    }

    public void T(int i) {
        W(i, true);
    }

    public void W(int i, boolean z) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        VerticalGridView verticalGridView = this.c;
        if (verticalGridView == null || this.h.a) {
            return;
        }
        if (z) {
            verticalGridView.setSelectedPositionSmooth(i);
        } else {
            verticalGridView.setSelectedPosition(i);
        }
    }

    public void X() {
        this.e.s0(this.a);
        this.e.z0(this.d);
        if (this.c != null) {
            S();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(B(), viewGroup, false);
        this.c = x(inflate);
        if (this.g) {
            this.g = false;
            L();
        }
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.h.f();
        this.c = null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("currentSelectedPosition", this.f);
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (bundle != null) {
            this.f = bundle.getInt("currentSelectedPosition", -1);
        }
        S();
        this.c.setOnChildViewHolderSelectedListener(this.i);
    }

    public abstract VerticalGridView x(View view);

    public y z() {
        return this.a;
    }
}
