package com.google.android.exoplayer2.ui;

import B3.g0;
import O2.V1;
import O2.z0;
import Z3.x;
import a4.c0;
import a4.d0;
import a4.h;
import a4.u;
import a4.w;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s5.y;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class TrackSelectionView extends LinearLayout {
    public final int a;
    public final LayoutInflater c;
    public final CheckedTextView d;
    public final CheckedTextView e;
    public final b f;
    public final List g;
    public final Map h;
    public boolean i;
    public boolean j;
    public c0 k;
    public CheckedTextView[][] l;
    public boolean m;
    public Comparator n;
    public d o;

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            TrackSelectionView.b(TrackSelectionView.this, view);
        }

        public /* synthetic */ b(TrackSelectionView trackSelectionView, a aVar) {
            this();
        }
    }

    public static final class c {
        public final V1.a a;
        public final int b;

        public c(V1.a aVar, int i) {
            this.a = aVar;
            this.b = i;
        }

        public z0 a() {
            return this.a.c(this.b);
        }
    }

    public interface d {
        void l(boolean z, Map map);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ int a(Comparator comparator, c cVar, c cVar2) {
        return e(comparator, cVar, cVar2);
    }

    public static /* synthetic */ void b(TrackSelectionView trackSelectionView, View view) {
        trackSelectionView.onClick(view);
    }

    public static Map c(Map map, List list, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            x xVar = (x) map.get(((V1.a) list.get(i)).b());
            if (xVar != null && (z || hashMap.isEmpty())) {
                hashMap.put(xVar.a, xVar);
            }
        }
        return hashMap;
    }

    public static /* synthetic */ int e(Comparator comparator, c cVar, c cVar2) {
        return comparator.compare(cVar.a(), cVar2.a());
    }

    private void onClick(View view) {
        if (view == this.d) {
            g();
        } else if (view == this.e) {
            f();
        } else {
            h(view);
        }
        k();
        d dVar = this.o;
        if (dVar != null) {
            dVar.l(getIsDisabled(), getOverrides());
        }
    }

    public void d(List list, boolean z, Map map, Comparator comparator, d dVar) {
        this.m = z;
        this.n = comparator == null ? null : new d0(comparator);
        this.o = dVar;
        this.g.clear();
        this.g.addAll(list);
        this.h.clear();
        this.h.putAll(c(map, list, this.j));
        l();
    }

    public final void f() {
        this.m = false;
        this.h.clear();
    }

    public final void g() {
        this.m = true;
        this.h.clear();
    }

    public boolean getIsDisabled() {
        return this.m;
    }

    public Map getOverrides() {
        return this.h;
    }

    public final void h(View view) {
        Map map;
        x xVar;
        this.m = false;
        c cVar = (c) d4.a.e(view.getTag());
        g0 b2 = cVar.a.b();
        int i = cVar.b;
        x xVar2 = (x) this.h.get(b2);
        if (xVar2 == null) {
            if (!this.j && this.h.size() > 0) {
                this.h.clear();
            }
            map = this.h;
            xVar = new x(b2, y.A(Integer.valueOf(i)));
        } else {
            ArrayList arrayList = new ArrayList(xVar2.c);
            boolean isChecked = ((CheckedTextView) view).isChecked();
            boolean i2 = i(cVar.a);
            boolean z = i2 || j();
            if (isChecked && z) {
                arrayList.remove(Integer.valueOf(i));
                if (arrayList.isEmpty()) {
                    this.h.remove(b2);
                    return;
                } else {
                    map = this.h;
                    xVar = new x(b2, arrayList);
                }
            } else {
                if (isChecked) {
                    return;
                }
                if (i2) {
                    arrayList.add(Integer.valueOf(i));
                    map = this.h;
                    xVar = new x(b2, arrayList);
                } else {
                    map = this.h;
                    xVar = new x(b2, y.A(Integer.valueOf(i)));
                }
            }
        }
        map.put(b2, xVar);
    }

    public final boolean i(V1.a aVar) {
        return this.i && aVar.f();
    }

    public final boolean j() {
        return this.j && this.g.size() > 1;
    }

    public final void k() {
        this.d.setChecked(this.m);
        this.e.setChecked(!this.m && this.h.size() == 0);
        for (int i = 0; i < this.l.length; i++) {
            x xVar = (x) this.h.get(((V1.a) this.g.get(i)).b());
            int i2 = 0;
            while (true) {
                View[] viewArr = this.l[i];
                if (i2 < viewArr.length) {
                    if (xVar != null) {
                        this.l[i][i2].setChecked(xVar.c.contains(Integer.valueOf(((c) d4.a.e(viewArr[i2].getTag())).b)));
                    } else {
                        viewArr[i2].setChecked(false);
                    }
                    i2++;
                }
            }
        }
    }

    public final void l() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.g.isEmpty()) {
            this.d.setEnabled(false);
            this.e.setEnabled(false);
            return;
        }
        this.d.setEnabled(true);
        this.e.setEnabled(true);
        this.l = new CheckedTextView[this.g.size()][];
        boolean j = j();
        for (int i = 0; i < this.g.size(); i++) {
            V1.a aVar = (V1.a) this.g.get(i);
            boolean i2 = i(aVar);
            CheckedTextView[][] checkedTextViewArr = this.l;
            int i3 = aVar.a;
            checkedTextViewArr[i] = new CheckedTextView[i3];
            c[] cVarArr = new c[i3];
            for (int i4 = 0; i4 < aVar.a; i4++) {
                cVarArr[i4] = new c(aVar, i4);
            }
            Comparator comparator = this.n;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                if (i5 == 0) {
                    addView(this.c.inflate(u.a, this, false));
                }
                CheckedTextView inflate = this.c.inflate((i2 || j) ? 17367056 : 17367055, this, false);
                inflate.setBackgroundResource(this.a);
                inflate.setText(this.k.a(cVarArr[i5].a()));
                inflate.setTag(cVarArr[i5]);
                if (aVar.k(i5)) {
                    inflate.setFocusable(true);
                    inflate.setOnClickListener(this.f);
                } else {
                    inflate.setFocusable(false);
                    inflate.setEnabled(false);
                }
                this.l[i][i5] = inflate;
                addView(inflate);
            }
        }
        k();
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.i != z) {
            this.i = z;
            l();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.j != z) {
            this.j = z;
            if (!z && this.h.size() > 1) {
                Map c2 = c(this.h, this.g, false);
                this.h.clear();
                this.h.putAll(c2);
            }
            l();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(c0 c0Var) {
        this.k = (c0) d4.a.e(c0Var);
        l();
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.a = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.c = from;
        b bVar = new b(this, null);
        this.f = bVar;
        this.k = new h(getResources());
        this.g = new ArrayList();
        this.h = new HashMap();
        CheckedTextView inflate = from.inflate(17367055, this, false);
        this.d = inflate;
        inflate.setBackgroundResource(resourceId);
        inflate.setText(w.x);
        inflate.setEnabled(false);
        inflate.setFocusable(true);
        inflate.setOnClickListener(bVar);
        inflate.setVisibility(8);
        addView(inflate);
        addView(from.inflate(u.a, this, false));
        CheckedTextView inflate2 = from.inflate(17367055, this, false);
        this.e = inflate2;
        inflate2.setBackgroundResource(resourceId);
        inflate2.setText(w.w);
        inflate2.setEnabled(false);
        inflate2.setFocusable(true);
        inflate2.setOnClickListener(bVar);
        addView(inflate2);
    }
}
