package com.google.android.material.transformation;

import P.L;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c {
    public int a;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ int c;
        public final /* synthetic */ d5.a d;

        public a(View view, int i, d5.a aVar) {
            this.a = view;
            this.c = i;
            this.d = aVar;
        }

        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.E(ExpandableBehavior.this) == this.c) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                d5.a aVar = this.d;
                expandableBehavior.H((View) aVar, this.a, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    public static /* synthetic */ int E(ExpandableBehavior expandableBehavior) {
        return expandableBehavior.a;
    }

    public final boolean F(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i = this.a;
        return i == 0 || i == 2;
    }

    public d5.a G(CoordinatorLayout coordinatorLayout, View view) {
        List s = coordinatorLayout.s(view);
        int size = s.size();
        for (int i = 0; i < size; i++) {
            d5.a aVar = (View) s.get(i);
            if (e(coordinatorLayout, view, aVar)) {
                return aVar;
            }
        }
        return null;
    }

    public abstract boolean H(View view, View view2, boolean z, boolean z2);

    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        d5.a aVar = (d5.a) view2;
        if (!F(aVar.a())) {
            return false;
        }
        this.a = aVar.a() ? 1 : 2;
        return H((View) aVar, view, aVar.a(), true);
    }

    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        d5.a G;
        if (L.W(view) || (G = G(coordinatorLayout, view)) == null || !F(G.a())) {
            return false;
        }
        int i2 = G.a() ? 1 : 2;
        this.a = i2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i2, G));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }
}
