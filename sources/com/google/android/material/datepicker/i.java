package com.google.android.material.datepicker;

import P.L;
import Q.C;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import d.D;
import java.util.Calendar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i extends p {
    public static final Object l = "MONTHS_VIEW_GROUP_TAG";
    public static final Object m = "NAVIGATION_PREV_TAG";
    public static final Object n = "NAVIGATION_NEXT_TAG";
    public static final Object o = "SELECTOR_TOGGLE_TAG";
    public int c;
    public com.google.android.material.datepicker.a d;
    public com.google.android.material.datepicker.l e;
    public k f;
    public com.google.android.material.datepicker.c g;
    public RecyclerView h;
    public RecyclerView i;
    public View j;
    public View k;

    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        public void run() {
            i.A(i.this).u1(this.a);
        }
    }

    public class b extends P.a {
        public b() {
        }

        public void g(View view, C c) {
            super.g(view, c);
            c.Z((Object) null);
        }
    }

    public class c extends q {
        public final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.I = i2;
        }

        public void k2(RecyclerView.A a, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = i.A(i.this).getWidth();
                iArr[1] = i.A(i.this).getWidth();
            } else {
                iArr[0] = i.A(i.this).getHeight();
                iArr[1] = i.A(i.this).getHeight();
            }
        }
    }

    public class d implements l {
        public d() {
        }

        public void a(long j) {
            if (i.B(i.this).f().b(j)) {
                i.D(i.this);
                throw null;
            }
        }
    }

    public class e extends RecyclerView.n {
        public final Calendar a = v.k();
        public final Calendar b = v.k();

        public e() {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.A a) {
            if ((recyclerView.getAdapter() instanceof w) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                recyclerView.getLayoutManager();
                i.D(i.this);
                throw null;
            }
        }
    }

    public class f extends P.a {
        public f() {
        }

        public void g(View view, C c) {
            i iVar;
            int i;
            super.g(view, c);
            if (i.E(i.this).getVisibility() == 0) {
                iVar = i.this;
                i = R4.j.s;
            } else {
                iVar = i.this;
                i = R4.j.q;
            }
            c.h0(iVar.getString(i));
        }
    }

    public class g extends RecyclerView.t {
        public final /* synthetic */ n a;
        public final /* synthetic */ MaterialButton b;

        public g(n nVar, MaterialButton materialButton) {
            this.a = nVar;
            this.b = materialButton;
        }

        public void a(RecyclerView recyclerView, int i) {
            if (i == 0) {
                recyclerView.announceForAccessibility(this.b.getText());
            }
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
            LinearLayoutManager b0 = i.this.b0();
            int x2 = i < 0 ? b0.x2() : b0.A2();
            i.J(i.this, this.a.k0(x2));
            this.b.setText(this.a.l0(x2));
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            i.this.l0();
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ n a;

        public i(n nVar) {
            this.a = nVar;
        }

        public void onClick(View view) {
            int x2 = i.this.b0().x2() + 1;
            if (x2 < i.A(i.this).getAdapter().n()) {
                i.this.j0(this.a.k0(x2));
            }
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ n a;

        public j(n nVar) {
            this.a = nVar;
        }

        public void onClick(View view) {
            int A2 = i.this.b0().A2() - 1;
            if (A2 >= 0) {
                i.this.j0(this.a.k0(A2));
            }
        }
    }

    public enum k {
        DAY,
        YEAR
    }

    public interface l {
        void a(long j);
    }

    public static /* synthetic */ RecyclerView A(i iVar) {
        return iVar.i;
    }

    public static /* synthetic */ com.google.android.material.datepicker.a B(i iVar) {
        return iVar.d;
    }

    public static /* synthetic */ com.google.android.material.datepicker.d D(i iVar) {
        iVar.getClass();
        return null;
    }

    public static /* synthetic */ View E(i iVar) {
        return iVar.k;
    }

    public static /* synthetic */ com.google.android.material.datepicker.l J(i iVar, com.google.android.material.datepicker.l lVar) {
        iVar.e = lVar;
        return lVar;
    }

    public static int Y(Context context) {
        return context.getResources().getDimensionPixelSize(R4.d.H);
    }

    public static int Z(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R4.d.O) + resources.getDimensionPixelOffset(R4.d.P) + resources.getDimensionPixelOffset(R4.d.N);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R4.d.J);
        int i2 = m.f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R4.d.H) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R4.d.M)) + resources.getDimensionPixelOffset(R4.d.F);
    }

    public static i c0(com.google.android.material.datepicker.d dVar, int i2, com.google.android.material.datepicker.a aVar) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.k());
        iVar.setArguments(bundle);
        return iVar;
    }

    public final void L(View view, n nVar) {
        MaterialButton findViewById = view.findViewById(R4.f.p);
        findViewById.setTag(o);
        L.s0(findViewById, new f());
        MaterialButton findViewById2 = view.findViewById(R4.f.r);
        findViewById2.setTag(m);
        MaterialButton findViewById3 = view.findViewById(R4.f.q);
        findViewById3.setTag(n);
        this.j = view.findViewById(R4.f.z);
        this.k = view.findViewById(R4.f.u);
        k0(k.DAY);
        findViewById.setText(this.e.w());
        this.i.l(new g(nVar, findViewById));
        findViewById.setOnClickListener(new h());
        findViewById3.setOnClickListener(new i(nVar));
        findViewById2.setOnClickListener(new j(nVar));
    }

    public final RecyclerView.n P() {
        return new e();
    }

    public com.google.android.material.datepicker.a S() {
        return this.d;
    }

    public com.google.android.material.datepicker.c T() {
        return this.g;
    }

    public com.google.android.material.datepicker.l W() {
        return this.e;
    }

    public com.google.android.material.datepicker.d X() {
        return null;
    }

    public LinearLayoutManager b0() {
        return this.i.getLayoutManager();
    }

    public final void i0(int i2) {
        this.i.post(new a(i2));
    }

    public void j0(com.google.android.material.datepicker.l lVar) {
        RecyclerView recyclerView;
        int i2;
        n nVar = (n) this.i.getAdapter();
        int m0 = nVar.m0(lVar);
        int m02 = m0 - nVar.m0(this.e);
        boolean z = Math.abs(m02) > 3;
        boolean z2 = m02 > 0;
        this.e = lVar;
        if (!z || !z2) {
            if (z) {
                recyclerView = this.i;
                i2 = m0 + 3;
            }
            i0(m0);
        }
        recyclerView = this.i;
        i2 = m0 - 3;
        recyclerView.m1(i2);
        i0(m0);
    }

    public void k0(k kVar) {
        this.f = kVar;
        if (kVar == k.YEAR) {
            this.h.getLayoutManager().U1(((w) this.h.getAdapter()).j0(this.e.d));
            this.j.setVisibility(0);
            this.k.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            j0(this.e);
        }
    }

    public void l0() {
        k kVar = this.f;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            k0(k.DAY);
        } else if (kVar == k.DAY) {
            k0(kVar2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.c = bundle.getInt("THEME_RES_ID_KEY");
        D.a(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.d = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.e = (com.google.android.material.datepicker.l) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.c);
        this.g = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.l m2 = this.d.m();
        if (com.google.android.material.datepicker.j.W(contextThemeWrapper)) {
            i2 = R4.h.q;
            i3 = 1;
        } else {
            i2 = R4.h.o;
            i3 = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        inflate.setMinimumHeight(Z(requireContext()));
        GridView findViewById = inflate.findViewById(R4.f.v);
        L.s0(findViewById, new b());
        findViewById.setAdapter(new com.google.android.material.datepicker.h());
        findViewById.setNumColumns(m2.e);
        findViewById.setEnabled(false);
        this.i = inflate.findViewById(R4.f.y);
        this.i.setLayoutManager(new c(getContext(), i3, false, i3));
        this.i.setTag(l);
        n nVar = new n(contextThemeWrapper, null, this.d, new d());
        this.i.setAdapter(nVar);
        int integer = contextThemeWrapper.getResources().getInteger(R4.g.c);
        RecyclerView findViewById2 = inflate.findViewById(R4.f.z);
        this.h = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setHasFixedSize(true);
            this.h.setLayoutManager(new GridLayoutManager(contextThemeWrapper, integer, 1, false));
            this.h.setAdapter(new w(this));
            this.h.h(P());
        }
        if (inflate.findViewById(R4.f.p) != null) {
            L(inflate, nVar);
        }
        if (!com.google.android.material.datepicker.j.W(contextThemeWrapper)) {
            new androidx.recyclerview.widget.k().b(this.i);
        }
        this.i.m1(nVar.m0(this.e));
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.c);
        bundle.putParcelable("GRID_SELECTOR_KEY", (Parcelable) null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.e);
    }

    public boolean x(o oVar) {
        return super.x(oVar);
    }
}
