package com.google.android.material.datepicker;

import P.L;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class n extends RecyclerView.g {
    public final com.google.android.material.datepicker.a d;
    public final i.l e;
    public final int f;

    public class a implements AdapterView.OnItemClickListener {
        public final /* synthetic */ MaterialCalendarGridView a;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.a = materialCalendarGridView;
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getAdapter().l(i)) {
                n.j0(n.this).a(this.a.getAdapter().getItem(i).longValue());
            }
        }
    }

    public static class b extends RecyclerView.D {
        public final TextView t;
        public final MaterialCalendarGridView u;

        public b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView findViewById = linearLayout.findViewById(R4.f.s);
            this.t = findViewById;
            L.t0(findViewById, true);
            this.u = linearLayout.findViewById(R4.f.o);
            if (z) {
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    public n(Context context, d dVar, com.google.android.material.datepicker.a aVar, i.l lVar) {
        l m = aVar.m();
        l g = aVar.g();
        l k = aVar.k();
        if (m.compareTo(k) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (k.compareTo(g) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (m.f * i.Y(context)) + (j.W(context) ? i.Y(context) : 0);
        this.d = aVar;
        this.e = lVar;
        c0(true);
    }

    public static /* synthetic */ i.l j0(n nVar) {
        return nVar.e;
    }

    public l k0(int i) {
        return this.d.m().A(i);
    }

    public CharSequence l0(int i) {
        return k0(i).w();
    }

    public int m0(l lVar) {
        return this.d.m().C(lVar);
    }

    public int n() {
        return this.d.h();
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void E(b bVar, int i) {
        l A = this.d.m().A(i);
        bVar.t.setText(A.w());
        MaterialCalendarGridView findViewById = bVar.u.findViewById(R4.f.o);
        if (findViewById.getAdapter() == null || !A.equals(findViewById.getAdapter().a)) {
            m mVar = new m(A, null, this.d);
            findViewById.setNumColumns(A.e);
            findViewById.setAdapter((ListAdapter) mVar);
        } else {
            findViewById.invalidate();
            findViewById.getAdapter().k(findViewById);
        }
        findViewById.setOnItemClickListener(new a(findViewById));
    }

    public long o(int i) {
        return this.d.m().A(i).x();
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public b L(ViewGroup viewGroup, int i) {
        LinearLayout inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R4.h.p, viewGroup, false);
        if (!j.W(viewGroup.getContext())) {
            return new b(inflate, false);
        }
        inflate.setLayoutParams(new RecyclerView.p(-1, this.f));
        return new b(inflate, true);
    }
}
