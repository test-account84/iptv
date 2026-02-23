package com.nst.iptvsmarterstvbox.view.demo;

import O2.V1;
import O2.t1;
import Z3.z;
import a4.s;
import a4.u;
import a7.f;
import a7.g;
import a7.j;
import a7.k;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.m;
import androidx.fragment.app.r;
import androidx.viewpager.widget.ViewPager;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r7.v;
import r7.w;
import r7.x;
import s5.c0;
import s5.y;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class b extends d {
    public static final y g = y.D(2, 1, 3);
    public final SparseArray a = new SparseArray();
    public final ArrayList c = new ArrayList();
    public int d;
    public DialogInterface.OnClickListener e;
    public DialogInterface.OnDismissListener f;

    public final class a extends r {
        public a(m mVar) {
            super(mVar, 1);
        }

        public int c() {
            return b.E(b.this).size();
        }

        public CharSequence e(int i) {
            return b.L(b.this.getResources(), ((Integer) b.E(b.this).get(i)).intValue());
        }

        public Fragment p(int i) {
            return (Fragment) b.J(b.this).get(((Integer) b.E(b.this).get(i)).intValue());
        }
    }

    public interface b {
        void b(z zVar);
    }

    public static final class c extends Fragment implements TrackSelectionView.d {
        public List a;
        public boolean c;
        public boolean d;
        public boolean e;
        public Map f;

        public c() {
            setRetainInstance(true);
        }

        public void l(boolean z, Map map) {
            this.e = z;
            this.f = map;
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(u.i, viewGroup, false);
            TrackSelectionView findViewById = inflate.findViewById(s.U);
            findViewById.setShowDisableOption(true);
            findViewById.setAllowMultipleOverrides(this.d);
            findViewById.setAllowAdaptiveSelections(this.c);
            findViewById.d(this.a, this.e, this.f, (Comparator) null, this);
            return inflate;
        }

        public void x(List list, boolean z, Map map, boolean z2, boolean z3) {
            this.a = list;
            this.e = z;
            this.c = z2;
            this.d = z3;
            this.f = new HashMap(TrackSelectionView.c(map, list, z3));
        }
    }

    public b() {
        setRetainInstance(true);
    }

    public static /* synthetic */ void A(b bVar, View view) {
        bVar.lambda$onCreateView$1(view);
    }

    public static /* synthetic */ void B(b bVar, View view) {
        bVar.lambda$onCreateView$2(view);
    }

    public static /* synthetic */ void D(z zVar, b bVar, b bVar2, DialogInterface dialogInterface, int i) {
        Z(zVar, bVar, bVar2, dialogInterface, i);
    }

    public static /* synthetic */ ArrayList E(b bVar) {
        return bVar.c;
    }

    public static /* synthetic */ SparseArray J(b bVar) {
        return bVar.a;
    }

    public static /* synthetic */ String L(Resources resources, int i) {
        return X(resources, i);
    }

    public static b P(t1 t1Var, DialogInterface.OnDismissListener onDismissListener) {
        return S(j.X7, t1Var.p(), t1Var.y(), true, false, new x(t1Var), onDismissListener);
    }

    public static b S(int i, V1 v1, z zVar, boolean z, boolean z2, b bVar, DialogInterface.OnDismissListener onDismissListener) {
        b bVar2 = new b();
        bVar2.Y(v1, zVar, i, z, z2, new w(zVar, bVar2, bVar), onDismissListener);
        return bVar2;
    }

    public static String X(Resources resources, int i) {
        int i2;
        if (i == 1) {
            i2 = a4.w.y;
        } else if (i == 2) {
            i2 = a4.w.A;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException();
            }
            i2 = a4.w.z;
        }
        return resources.getString(i2);
    }

    public static /* synthetic */ void Z(z zVar, b bVar, b bVar2, DialogInterface dialogInterface, int i) {
        z.a B = zVar.B();
        int i2 = 0;
        while (true) {
            y yVar = g;
            if (i2 >= yVar.size()) {
                bVar2.b(B.B());
                return;
            }
            int intValue = ((Integer) yVar.get(i2)).intValue();
            B.L(intValue, bVar.T(intValue));
            B.C(intValue);
            Iterator it = bVar.W(intValue).values().iterator();
            while (it.hasNext()) {
                B.A((Z3.x) it.next());
            }
            i2++;
        }
    }

    public static boolean b0(t1 t1Var) {
        return c0(t1Var.p());
    }

    public static boolean c0(V1 v1) {
        c0 l = v1.c().l();
        while (l.hasNext()) {
            if (g.contains(Integer.valueOf(((V1.a) l.next()).e()))) {
                return true;
            }
        }
        return false;
    }

    public boolean T(int i) {
        c cVar = (c) this.a.get(i);
        return cVar != null && cVar.e;
    }

    public Map W(int i) {
        c cVar = (c) this.a.get(i);
        return cVar == null ? Collections.emptyMap() : cVar.f;
    }

    public final void Y(V1 v1, z zVar, int i, boolean z, boolean z2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        this.d = i;
        this.e = onClickListener;
        this.f = onDismissListener;
        int i2 = 0;
        while (true) {
            y yVar = g;
            if (i2 >= yVar.size()) {
                return;
            }
            Integer num = (Integer) yVar.get(i2);
            int intValue = num.intValue();
            List arrayList = new ArrayList();
            c0 l = v1.c().l();
            while (l.hasNext()) {
                V1.a aVar = (V1.a) l.next();
                if (aVar.e() == intValue) {
                    arrayList.add(aVar);
                }
            }
            if (!arrayList.isEmpty()) {
                c cVar = new c();
                cVar.x(arrayList, zVar.A.contains(num), zVar.z, z, z2);
                this.a.put(intValue, cVar);
                this.c.add(num);
            }
            i2++;
        }
    }

    public final /* synthetic */ void lambda$onCreateView$1(View view) {
        dismiss();
    }

    public final /* synthetic */ void lambda$onCreateView$2(View view) {
        this.e.onClick(getDialog(), -1);
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        d.u uVar = new d.u(getActivity(), k.j);
        uVar.setTitle(this.d);
        return uVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.M4, viewGroup, false);
        TabLayout findViewById = inflate.findViewById(f.nh);
        ViewPager findViewById2 = inflate.findViewById(f.oh);
        Button findViewById3 = inflate.findViewById(f.lh);
        Button findViewById4 = inflate.findViewById(f.mh);
        findViewById2.setAdapter(new a(getChildFragmentManager()));
        findViewById.setupWithViewPager(findViewById2);
        findViewById.setVisibility(this.a.size() <= 1 ? 8 : 0);
        findViewById3.setOnClickListener(new r7.u(this));
        findViewById4.setOnClickListener(new v(this));
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f.onDismiss(dialogInterface);
    }
}
