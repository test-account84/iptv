package com.google.android.material.internal;

import F.h;
import P.L;
import Q.C;
import R4.d;
import R4.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.b;
import f5.f;
import k.g0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class NavigationMenuItemView extends f implements j.a {
    public static final int[] G = {16842912};
    public FrameLayout A;
    public g B;
    public ColorStateList C;
    public boolean D;
    public Drawable E;
    public final P.a F;
    public int w;
    public boolean x;
    public boolean y;
    public final CheckedTextView z;

    public class a extends P.a {
        public a() {
        }

        public void g(View view, C c) {
            super.g(view, c);
            c.V(NavigationMenuItemView.this.y);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = findViewById(R4.f.d).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    public final void B() {
        b.a layoutParams;
        int i;
        if (D()) {
            this.z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout == null) {
                return;
            }
            layoutParams = frameLayout.getLayoutParams();
            i = -1;
        } else {
            this.z.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 == null) {
                return;
            }
            layoutParams = frameLayout2.getLayoutParams();
            i = -2;
        }
        ((LinearLayout.LayoutParams) layoutParams).width = i;
        this.A.setLayoutParams(layoutParams);
    }

    public final StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(c.a.t, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public final boolean D() {
        return this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null;
    }

    public void c(g gVar, int i) {
        this.B = gVar;
        if (gVar.getItemId() > 0) {
            setId(gVar.getItemId());
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            L.w0(this, C());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        g0.a(this, gVar.getTooltipText());
        B();
    }

    public boolean e() {
        return false;
    }

    public g getItemData() {
        return this.B;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super/*android.view.ViewGroup*/.onCreateDrawableState(i + 1);
        g gVar = this.B;
        if (gVar != null && gVar.isCheckable() && this.B.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.y != z) {
            this.y = z;
            this.F.l(this.z, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.z.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = H.a.r(drawable).mutate();
                H.a.o(drawable, this.C);
            }
            int i = this.w;
            drawable.setBounds(0, 0, i, i);
        } else if (this.x) {
            if (this.E == null) {
                Drawable f = h.f(getResources(), e.g, getContext().getTheme());
                this.E = f;
                if (f != null) {
                    int i2 = this.w;
                    f.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.E;
        }
        T.j.j(this.z, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconPadding(int i) {
        this.z.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.w = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        g gVar = this.B;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.z.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.x = z;
    }

    public void setTextAppearance(int i) {
        T.j.o(this.z, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a();
        this.F = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R4.h.c, this, true);
        setIconSize(context.getResources().getDimensionPixelSize(d.e));
        CheckedTextView findViewById = findViewById(R4.f.e);
        this.z = findViewById;
        findViewById.setDuplicateParentStateEnabled(true);
        L.s0(findViewById, aVar);
    }
}
