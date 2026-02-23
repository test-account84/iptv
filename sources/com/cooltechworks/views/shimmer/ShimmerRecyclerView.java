package com.cooltechworks.views.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ShimmerRecyclerView extends RecyclerView {
    public RecyclerView.g M0;
    public s2.d N0;
    public RecyclerView.o O0;
    public RecyclerView.o P0;
    public e Q0;
    public boolean R0;
    public int S0;
    public int T0;

    public class a extends LinearLayoutManager {
        public a(Context context) {
            super(context);
        }

        public boolean I() {
            return ShimmerRecyclerView.C1(ShimmerRecyclerView.this);
        }
    }

    public class b extends LinearLayoutManager {
        public b(Context context, int i, boolean z) {
            super(context, i, z);
        }

        public boolean H() {
            return ShimmerRecyclerView.C1(ShimmerRecyclerView.this);
        }
    }

    public class c extends GridLayoutManager {
        public c(Context context, int i) {
            super(context, i);
        }

        public boolean I() {
            return ShimmerRecyclerView.C1(ShimmerRecyclerView.this);
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.LINEAR_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.LINEAR_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.GRID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum e {
        LINEAR_VERTICAL,
        LINEAR_HORIZONTAL,
        GRID
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        F1(context, attributeSet);
    }

    public static /* synthetic */ boolean C1(ShimmerRecyclerView shimmerRecyclerView) {
        return shimmerRecyclerView.R0;
    }

    private void F1(Context context, AttributeSet attributeSet) {
        e eVar;
        this.N0 = new s2.d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s2.c.g, 0, 0);
        try {
            setDemoLayoutReference(obtainStyledAttributes.getResourceId(s2.c.l, s2.b.a));
            setDemoChildCount(obtainStyledAttributes.getInteger(s2.c.i, 10));
            setGridChildCount(obtainStyledAttributes.getInteger(s2.c.k, 2));
            int integer = obtainStyledAttributes.getInteger(s2.c.m, 0);
            if (integer == 0) {
                eVar = e.LINEAR_VERTICAL;
            } else if (integer == 1) {
                eVar = e.LINEAR_HORIZONTAL;
            } else {
                if (integer != 2) {
                    throw new IllegalArgumentException("This value for layout manager is not valid!");
                }
                eVar = e.GRID;
            }
            setDemoLayoutManager(eVar);
            int integer2 = obtainStyledAttributes.getInteger(s2.c.h, 0);
            int color = obtainStyledAttributes.getColor(s2.c.o, D1(s2.a.a));
            Drawable drawable = obtainStyledAttributes.getDrawable(s2.c.p);
            int integer3 = obtainStyledAttributes.getInteger(s2.c.j, 1500);
            boolean z = obtainStyledAttributes.getBoolean(s2.c.n, false);
            obtainStyledAttributes.recycle();
            this.N0.p0(integer2);
            this.N0.q0(color);
            this.N0.s0(drawable);
            this.N0.r0(integer3);
            this.N0.l0(z);
            H1();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final int D1(int i) {
        return Build.VERSION.SDK_INT >= 23 ? s2.e.a(getContext(), i) : getResources().getColor(i);
    }

    public void E1() {
        this.R0 = true;
        setLayoutManager(this.P0);
        setAdapter(this.M0);
    }

    public final void G1() {
        RecyclerView.o aVar;
        int i = d.a[this.Q0.ordinal()];
        if (i == 1) {
            aVar = new a(getContext());
        } else if (i == 2) {
            aVar = new b(getContext(), 0, false);
        } else if (i != 3) {
            return;
        } else {
            aVar = new c(getContext(), this.T0);
        }
        this.O0 = aVar;
    }

    public void H1() {
        this.R0 = false;
        if (this.O0 == null) {
            G1();
        }
        setLayoutManager(this.O0);
        setAdapter(this.N0);
    }

    public RecyclerView.g getActualAdapter() {
        return this.M0;
    }

    public int getLayoutReference() {
        return this.S0;
    }

    public void setAdapter(RecyclerView.g gVar) {
        if (gVar == null) {
            this.M0 = null;
        } else if (gVar != this.N0) {
            this.M0 = gVar;
        }
        super.setAdapter(gVar);
    }

    public void setDemoChildCount(int i) {
        this.N0.n0(i);
    }

    public void setDemoLayoutManager(e eVar) {
        this.Q0 = eVar;
    }

    public void setDemoLayoutReference(int i) {
        this.S0 = i;
        this.N0.m0(getLayoutReference());
    }

    public void setDemoShimmerDuration(int i) {
        this.N0.r0(i);
    }

    public void setGridChildCount(int i) {
        this.T0 = i;
    }

    public void setLayoutManager(RecyclerView.o oVar) {
        if (oVar == null) {
            this.P0 = null;
        } else if (oVar != this.O0) {
            this.P0 = oVar;
        }
        super.setLayoutManager(oVar);
    }
}
