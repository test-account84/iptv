package com.google.android.material.button;

import P.L;
import P.s;
import Q.C;
import R4.k;
import R4.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import f5.u;
import f5.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import l5.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final String l = "MaterialButtonToggleGroup";
    public static final int m = k.s;
    public final List a;
    public final e c;
    public final LinkedHashSet d;
    public final Comparator e;
    public Integer[] f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final int j;
    public Set k;

    public class a implements Comparator {
        public a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    public class b extends P.a {
        public b() {
        }

        public void g(View view, C c) {
            super.g(view, c);
            c.a0(C.c.a(0, 1, MaterialButtonToggleGroup.a(MaterialButtonToggleGroup.this, view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public static class c {
        public static final l5.c e = new l5.a(0.0f);
        public l5.c a;
        public l5.c b;
        public l5.c c;
        public l5.c d;

        public c(l5.c cVar, l5.c cVar2, l5.c cVar3, l5.c cVar4) {
            this.a = cVar;
            this.b = cVar3;
            this.c = cVar4;
            this.d = cVar2;
        }

        public static c a(c cVar) {
            l5.c cVar2 = e;
            return new c(cVar2, cVar.d, cVar2, cVar.c);
        }

        public static c b(c cVar, View view) {
            return w.e(view) ? c(cVar) : d(cVar);
        }

        public static c c(c cVar) {
            l5.c cVar2 = cVar.a;
            l5.c cVar3 = cVar.d;
            l5.c cVar4 = e;
            return new c(cVar2, cVar3, cVar4, cVar4);
        }

        public static c d(c cVar) {
            l5.c cVar2 = e;
            return new c(cVar2, cVar2, cVar.b, cVar.c);
        }

        public static c e(c cVar, View view) {
            return w.e(view) ? d(cVar) : c(cVar);
        }

        public static c f(c cVar) {
            l5.c cVar2 = cVar.a;
            l5.c cVar3 = e;
            return new c(cVar2, cVar3, cVar.b, cVar3);
        }
    }

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    public class e implements MaterialButton.a {
        public e() {
        }

        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.u);
    }

    public static /* synthetic */ int a(MaterialButtonToggleGroup materialButtonToggleGroup, View view) {
        return materialButtonToggleGroup.i(view);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (k(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && k(i2)) {
                i++;
            }
        }
        return i;
    }

    public static void p(k.b bVar, c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.B(cVar.a).t(cVar.d).F(cVar.b).x(cVar.c);
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(L.m());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(l, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        l5.k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.a.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        L.s0(materialButton, new b());
    }

    public void b(d dVar) {
        this.d.add(dVar);
    }

    public final void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton h = h(i);
            int min = Math.min(h.getStrokeWidth(), h(i - 1).getStrokeWidth());
            LinearLayout.LayoutParams d2 = d(h);
            if (getOrientation() == 0) {
                s.c(d2, 0);
                s.d(d2, -min);
                d2.topMargin = 0;
            } else {
                d2.bottomMargin = 0;
                d2.topMargin = -min;
                s.d(d2, 0);
            }
            h.setLayoutParams(d2);
        }
        n(firstVisibleChildIndex);
    }

    public final LinearLayout.LayoutParams d(View view) {
        LinearLayout.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? layoutParams : new LinearLayout.LayoutParams(((ViewGroup.LayoutParams) layoutParams).width, ((ViewGroup.LayoutParams) layoutParams).height);
    }

    public void dispatchDraw(Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public final void e(int i, boolean z) {
        if (i == -1) {
            Log.e(l, "Button ID is not valid: " + i);
            return;
        }
        HashSet hashSet = new HashSet(this.k);
        if (z && !hashSet.contains(Integer.valueOf(i))) {
            if (this.h && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.i || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        q(hashSet);
    }

    public void f() {
        q(new HashSet());
    }

    public final void g(int i, boolean z) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(this, i, z);
        }
    }

    public int getCheckedButtonId() {
        if (!this.h || this.k.isEmpty()) {
            return -1;
        }
        return ((Integer) this.k.iterator().next()).intValue();
    }

    public List getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id = h(i).getId();
            if (this.k.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    public int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.f;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w(l, "Child order wasn't updated");
        return i2;
    }

    public final MaterialButton h(int i) {
        return getChildAt(i);
    }

    public final int i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) == view) {
                return i;
            }
            if ((getChildAt(i2) instanceof MaterialButton) && k(i2)) {
                i++;
            }
        }
        return -1;
    }

    public final c j(int i, int i2, int i3) {
        c cVar = (c) this.a.get(i);
        if (i2 == i3) {
            return cVar;
        }
        boolean z = getOrientation() == 0;
        if (i == i2) {
            return z ? c.e(cVar, this) : c.f(cVar);
        }
        if (i == i3) {
            return z ? c.b(cVar, this) : c.a(cVar);
        }
        return null;
    }

    public final boolean k(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public boolean l() {
        return this.h;
    }

    public void m(MaterialButton materialButton, boolean z) {
        if (this.g) {
            return;
        }
        e(materialButton.getId(), z);
    }

    public final void n(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = h(i).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            s.c(layoutParams, 0);
            s.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    public final void o(int i, boolean z) {
        MaterialButton findViewById = findViewById(i);
        if (findViewById instanceof MaterialButton) {
            this.g = true;
            findViewById.setChecked(z);
            this.g = false;
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.j;
        if (i != -1) {
            q(Collections.singleton(Integer.valueOf(i)));
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C.y0(accessibilityNodeInfo).Z(C.b.a(1, getVisibleButtonCount(), false, l() ? 1 : 2));
    }

    public void onMeasure(int i, int i2) {
        s();
        c();
        super.onMeasure(i, i2);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.a.remove(indexOfChild);
        }
        s();
        c();
    }

    public final void q(Set set) {
        Set set2 = this.k;
        this.k = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id = h(i).getId();
            o(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                g(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    public final void r() {
        TreeMap treeMap = new TreeMap(this.e);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(h(i), Integer.valueOf(i));
        }
        this.f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton h = h(i);
            if (h.getVisibility() != 8) {
                k.b v = h.getShapeAppearanceModel().v();
                p(v, j(i, firstVisibleChildIndex, lastVisibleChildIndex));
                h.setShapeAppearanceModel(v.m());
            }
        }
    }

    public void setSelectionRequired(boolean z) {
        this.i = z;
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i) {
        int i2 = m;
        super(p5.a.c(context, attributeSet, i, i2), attributeSet, i);
        this.a = new ArrayList();
        this.c = new e(this, null);
        this.d = new LinkedHashSet();
        this.e = new a();
        this.g = false;
        this.k = new HashSet();
        TypedArray h = u.h(getContext(), attributeSet, l.f3, i, i2, new int[0]);
        setSingleSelection(h.getBoolean(l.i3, false));
        this.j = h.getResourceId(l.g3, -1);
        this.i = h.getBoolean(l.h3, false);
        setChildrenDrawingOrderEnabled(true);
        h.recycle();
        L.C0(this, 1);
    }

    public void setSingleSelection(boolean z) {
        if (this.h != z) {
            this.h = z;
            f();
        }
    }
}
