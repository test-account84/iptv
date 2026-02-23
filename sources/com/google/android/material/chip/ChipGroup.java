package com.google.android.material.chip;

import P.L;
import Q.C;
import R4.k;
import R4.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import f5.a;
import f5.u;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ChipGroup extends f5.e {
    public static final int l = k.n;
    public int f;
    public int g;
    public e h;
    public final f5.a i;
    public final int j;
    public final f k;

    public class a implements a.b {
        public a() {
        }

        public void a(Set set) {
            if (ChipGroup.e(ChipGroup.this) != null) {
                e e = ChipGroup.e(ChipGroup.this);
                ChipGroup chipGroup = ChipGroup.this;
                e.a(chipGroup, ChipGroup.f(chipGroup).j(ChipGroup.this));
            }
        }
    }

    public class b implements e {
        public b(d dVar) {
        }

        public void a(ChipGroup chipGroup, List list) {
            if (ChipGroup.f(ChipGroup.this).l()) {
                ChipGroup.this.getCheckedChipId();
                throw null;
            }
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface d {
    }

    public interface e {
        void a(ChipGroup chipGroup, List list);
    }

    public class f implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup.OnHierarchyChangeListener a;

        public f() {
        }

        public static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(f fVar, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
            fVar.a = onHierarchyChangeListener;
            return onHierarchyChangeListener;
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(L.m());
                }
                ChipGroup.f(ChipGroup.this).e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                ChipGroup.f(chipGroup).n((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        public /* synthetic */ f(ChipGroup chipGroup, a aVar) {
            this();
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.f);
    }

    public static /* synthetic */ e e(ChipGroup chipGroup) {
        return chipGroup.h;
    }

    public static /* synthetic */ f5.a f(ChipGroup chipGroup) {
        return chipGroup.i;
    }

    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    public boolean c() {
        return super.c();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    public int g(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                if (getChildAt(i2) == view) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.i.k();
    }

    public List getCheckedChipIds() {
        return this.i.j(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f;
    }

    public int getChipSpacingVertical() {
        return this.g;
    }

    public boolean h() {
        return this.i.l();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.j;
        if (i != -1) {
            this.i.f(i);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C.y0(accessibilityNodeInfo).Z(C.b.a(getRowCount(), c() ? getChipCount() : -1, false, h() ? 1 : 2));
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.f != i) {
            this.f = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.g != i) {
            this.g = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(d dVar) {
        if (dVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new b(dVar));
        }
    }

    public void setOnCheckedStateChangeListener(e eVar) {
        this.h = eVar;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        f.a(this.k, onHierarchyChangeListener);
    }

    public void setSelectionRequired(boolean z) {
        this.i.p(z);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        int i2 = l;
        super(p5.a.c(context, attributeSet, i, i2), attributeSet, i);
        f5.a aVar = new f5.a();
        this.i = aVar;
        f fVar = new f(this, null);
        this.k = fVar;
        TypedArray h = u.h(getContext(), attributeSet, l.h1, i, i2, new int[0]);
        int dimensionPixelOffset = h.getDimensionPixelOffset(l.j1, 0);
        setChipSpacingHorizontal(h.getDimensionPixelOffset(l.k1, dimensionPixelOffset));
        setChipSpacingVertical(h.getDimensionPixelOffset(l.l1, dimensionPixelOffset));
        setSingleLine(h.getBoolean(l.n1, false));
        setSingleSelection(h.getBoolean(l.o1, false));
        setSelectionRequired(h.getBoolean(l.m1, false));
        this.j = h.getResourceId(l.i1, -1);
        h.recycle();
        aVar.o(new a());
        super.setOnHierarchyChangeListener(fVar);
        L.C0(this, 1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        this.i.q(z);
    }
}
