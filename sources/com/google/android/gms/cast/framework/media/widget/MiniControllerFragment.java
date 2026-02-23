package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import o4.m;
import o4.o;
import o4.p;
import o4.q;
import o4.s;
import o4.u;
import o4.v;
import s4.t;
import t4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MiniControllerFragment extends Fragment {
    public static final b z = new b("MiniControllerFragment");
    public boolean a;
    public int c;
    public int d;
    public TextView e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int[] j;
    public final ImageView[] k = new ImageView[3];
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public r4.b y;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        r4.b bVar = new r4.b(getActivity());
        this.y = bVar;
        View inflate = layoutInflater.inflate(s.d, viewGroup);
        inflate.setVisibility(8);
        bVar.x(inflate, 8);
        RelativeLayout findViewById = inflate.findViewById(q.K);
        int i = this.f;
        if (i != 0) {
            findViewById.setBackgroundResource(i);
        }
        ImageView imageView = (ImageView) inflate.findViewById(q.P);
        TextView textView = (TextView) inflate.findViewById(q.d0);
        if (this.c != 0) {
            textView.setTextAppearance(getActivity(), this.c);
        }
        TextView findViewById2 = inflate.findViewById(q.Z);
        this.e = findViewById2;
        if (this.d != 0) {
            findViewById2.setTextAppearance(getActivity(), this.d);
        }
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(q.U);
        if (this.g != 0) {
            progressBar.getProgressDrawable().setColorFilter(this.g, PorterDuff.Mode.SRC_IN);
        }
        bVar.m(textView, "com.google.android.gms.cast.metadata.TITLE");
        bVar.o(this.e);
        bVar.j(progressBar);
        bVar.r(findViewById);
        if (this.a) {
            bVar.g(imageView, new p4.b(2, getResources().getDimensionPixelSize(o.i), getResources().getDimensionPixelSize(o.h)), p.a);
        } else {
            imageView.setVisibility(8);
        }
        this.k[0] = (ImageView) findViewById.findViewById(q.l);
        this.k[1] = (ImageView) findViewById.findViewById(q.m);
        this.k[2] = (ImageView) findViewById.findViewById(q.n);
        x(bVar, findViewById, q.l, 0);
        x(bVar, findViewById, q.m, 1);
        x(bVar, findViewById, q.n, 2);
        return inflate;
    }

    public void onDestroy() {
        r4.b bVar = this.y;
        if (bVar != null) {
            bVar.y();
            this.y = null;
        }
        super.onDestroy();
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        if (this.j == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.C, m.b, u.b);
            this.a = obtainStyledAttributes.getBoolean(v.O, true);
            this.c = obtainStyledAttributes.getResourceId(v.T, 0);
            this.d = obtainStyledAttributes.getResourceId(v.S, 0);
            this.f = obtainStyledAttributes.getResourceId(v.D, 0);
            int color = obtainStyledAttributes.getColor(v.M, 0);
            this.g = color;
            this.h = obtainStyledAttributes.getColor(v.I, color);
            this.i = obtainStyledAttributes.getResourceId(v.E, 0);
            this.m = obtainStyledAttributes.getResourceId(v.L, 0);
            this.n = obtainStyledAttributes.getResourceId(v.K, 0);
            this.o = obtainStyledAttributes.getResourceId(v.R, 0);
            this.p = obtainStyledAttributes.getResourceId(v.L, 0);
            this.q = obtainStyledAttributes.getResourceId(v.K, 0);
            this.r = obtainStyledAttributes.getResourceId(v.R, 0);
            this.s = obtainStyledAttributes.getResourceId(v.Q, 0);
            this.t = obtainStyledAttributes.getResourceId(v.P, 0);
            this.u = obtainStyledAttributes.getResourceId(v.N, 0);
            this.v = obtainStyledAttributes.getResourceId(v.H, 0);
            this.w = obtainStyledAttributes.getResourceId(v.J, 0);
            this.x = obtainStyledAttributes.getResourceId(v.F, 0);
            int resourceId = obtainStyledAttributes.getResourceId(v.G, 0);
            if (resourceId != 0) {
                TypedArray obtainTypedArray = context.getResources().obtainTypedArray(resourceId);
                r.a(obtainTypedArray.length() == 3);
                this.j = new int[obtainTypedArray.length()];
                for (int i = 0; i < obtainTypedArray.length(); i++) {
                    this.j[i] = obtainTypedArray.getResourceId(i, 0);
                }
                obtainTypedArray.recycle();
                if (this.a) {
                    this.j[0] = q.s;
                }
                this.l = 0;
                for (int i2 : this.j) {
                    if (i2 != q.s) {
                        this.l++;
                    }
                }
            } else {
                z.f("Unable to read attribute castControlButtons.", new Object[0]);
                int i3 = q.s;
                this.j = new int[]{i3, i3, i3};
            }
            obtainStyledAttributes.recycle();
        }
        zzr.zzd(zzln.CAF_MINI_CONTROLLER);
    }

    public final void x(r4.b bVar, RelativeLayout relativeLayout, int i, int i2) {
        ImageView findViewById = relativeLayout.findViewById(i);
        int i3 = this.j[i2];
        if (i3 == q.s) {
            findViewById.setVisibility(4);
            return;
        }
        if (i3 == q.r) {
            return;
        }
        if (i3 == q.v) {
            int i4 = this.m;
            int i5 = this.n;
            int i6 = this.o;
            if (this.l == 1) {
                i4 = this.p;
                i5 = this.q;
                i6 = this.r;
            }
            Drawable c = t.c(getContext(), this.i, i4);
            Drawable c2 = t.c(getContext(), this.i, i5);
            Drawable c3 = t.c(getContext(), this.i, i6);
            findViewById.setImageDrawable(c2);
            ProgressBar progressBar = new ProgressBar(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(8, i);
            layoutParams.addRule(6, i);
            layoutParams.addRule(5, i);
            layoutParams.addRule(7, i);
            layoutParams.addRule(15);
            progressBar.setLayoutParams(layoutParams);
            progressBar.setVisibility(8);
            Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
            int i7 = this.h;
            if (i7 != 0 && indeterminateDrawable != null) {
                indeterminateDrawable.setColorFilter(i7, PorterDuff.Mode.SRC_IN);
            }
            relativeLayout.addView(progressBar);
            bVar.i(findViewById, c, c2, c3, progressBar, true);
            return;
        }
        if (i3 == q.y) {
            findViewById.setImageDrawable(t.c(getContext(), this.i, this.s));
            findViewById.setContentDescription(getResources().getString(o4.t.t));
            bVar.v(findViewById, 0);
            return;
        }
        if (i3 == q.x) {
            findViewById.setImageDrawable(t.c(getContext(), this.i, this.t));
            findViewById.setContentDescription(getResources().getString(o4.t.s));
            bVar.u(findViewById, 0);
            return;
        }
        if (i3 == q.w) {
            findViewById.setImageDrawable(t.c(getContext(), this.i, this.u));
            findViewById.setContentDescription(getResources().getString(o4.t.r));
            bVar.t(findViewById, 30000L);
        } else if (i3 == q.t) {
            findViewById.setImageDrawable(t.c(getContext(), this.i, this.v));
            findViewById.setContentDescription(getResources().getString(o4.t.k));
            bVar.q(findViewById, 30000L);
        } else if (i3 == q.u) {
            findViewById.setImageDrawable(t.c(getContext(), this.i, this.w));
            bVar.h(findViewById);
        } else if (i3 == q.q) {
            findViewById.setImageDrawable(t.c(getContext(), this.i, this.x));
            bVar.p(findViewById);
        }
    }
}
