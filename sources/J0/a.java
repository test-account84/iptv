package j0;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.leanback.widget.B;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import d.D;
import g0.f;
import g0.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a extends FrameLayout {
    public ViewGroup a;
    public ViewGroup c;
    public final List d;
    public ArrayList e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public Interpolator k;
    public Interpolator l;
    public ArrayList m;
    public float n;
    public float o;
    public int p;
    public List q;
    public int r;
    public int s;
    public final B t;

    public class a extends B {
        public a() {
        }

        public void a(RecyclerView recyclerView, RecyclerView.D d, int i, int i2) {
            int indexOf = a.this.d.indexOf(recyclerView);
            a.this.h(indexOf, true);
            if (d != null) {
                a.this.c(indexOf, ((j0.b) a.this.e.get(indexOf)).e() + i);
            }
        }
    }

    public class b extends RecyclerView.g {
        public final int d;
        public final int e;
        public final int f;
        public j0.b g;

        public b(Context context, int i, int i2, int i3) {
            this.d = i;
            this.e = i3;
            this.f = i2;
            this.g = (j0.b) a.this.e.get(i3);
        }

        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void E(c cVar, int i) {
            j0.b bVar;
            TextView textView = cVar.t;
            if (textView != null && (bVar = this.g) != null) {
                textView.setText(bVar.c(bVar.e() + i));
            }
            a aVar = a.this;
            aVar.g(cVar.a, ((VerticalGridView) aVar.d.get(this.e)).getSelectedPosition() == i, this.e, false);
        }

        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public c L(ViewGroup viewGroup, int i) {
            TextView inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.d, viewGroup, false);
            int i2 = this.f;
            return new c(inflate, i2 != 0 ? (TextView) inflate.findViewById(i2) : inflate);
        }

        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void W(c cVar) {
            cVar.a.setFocusable(a.this.isActivated());
        }

        public int n() {
            j0.b bVar = this.g;
            if (bVar == null) {
                return 0;
            }
            return bVar.a();
        }
    }

    public static class c extends RecyclerView.D {
        public final TextView t;

        public c(View view, TextView textView) {
            super(view);
            this.t = textView;
        }
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new ArrayList();
        this.n = 3.0f;
        this.o = 1.0f;
        this.p = 0;
        this.q = new ArrayList();
        this.r = h.d;
        this.s = 0;
        this.t = new a();
        setEnabled(true);
        setDescendantFocusability(262144);
        this.g = 1.0f;
        this.f = 1.0f;
        this.h = 0.5f;
        this.i = 0.0f;
        this.j = 200;
        this.k = new DecelerateInterpolator(2.5f);
        this.l = new AccelerateInterpolator(2.5f);
        ViewGroup inflate = LayoutInflater.from(getContext()).inflate(h.b, this, true);
        this.a = inflate;
        this.c = inflate.findViewById(f.v);
    }

    public j0.b a(int i) {
        ArrayList arrayList = this.e;
        if (arrayList == null) {
            return null;
        }
        return (j0.b) arrayList.get(i);
    }

    public final void b(int i) {
        int size;
        if (this.m == null || r2.size() - 1 < 0) {
            return;
        }
        D.a(this.m.get(size));
        throw null;
    }

    public abstract void c(int i, int i2);

    public void d(int i, j0.b bVar) {
        this.e.set(i, bVar);
        VerticalGridView verticalGridView = (VerticalGridView) this.d.get(i);
        b bVar2 = (b) verticalGridView.getAdapter();
        if (bVar2 != null) {
            bVar2.w();
        }
        verticalGridView.setSelectedPosition(bVar.b() - bVar.e());
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isActivated()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 23 && keyCode != 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }

    public void e(int i, int i2, boolean z) {
        j0.b bVar = (j0.b) this.e.get(i);
        if (bVar.b() != i2) {
            bVar.f(i2);
            b(i);
            VerticalGridView verticalGridView = (VerticalGridView) this.d.get(i);
            if (verticalGridView != null) {
                int e = i2 - ((j0.b) this.e.get(i)).e();
                if (z) {
                    verticalGridView.setSelectedPositionSmooth(e);
                } else {
                    verticalGridView.setSelectedPosition(e);
                }
            }
        }
    }

    public final void f(View view, boolean z, float f, float f2, Interpolator interpolator) {
        view.animate().cancel();
        if (!z) {
            view.setAlpha(f);
            return;
        }
        if (f2 >= 0.0f) {
            view.setAlpha(f2);
        }
        view.animate().alpha(f).setDuration(this.j).setInterpolator(interpolator).start();
    }

    public void g(View view, boolean z, int i, boolean z2) {
        boolean z3 = i == this.p || !hasFocus();
        f(view, z2, z ? z3 ? this.g : this.f : z3 ? this.h : this.i, -1.0f, this.k);
    }

    public float getActivatedVisibleItemCount() {
        return this.n;
    }

    public int getColumnsCount() {
        ArrayList arrayList = this.e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getPickerItemHeightPixels() {
        return getContext().getResources().getDimensionPixelSize(g0.c.x);
    }

    public final int getPickerItemLayoutId() {
        return this.r;
    }

    public final int getPickerItemTextViewId() {
        return this.s;
    }

    public int getSelectedColumn() {
        return this.p;
    }

    public final CharSequence getSeparator() {
        return (CharSequence) this.q.get(0);
    }

    public final List getSeparators() {
        return this.q;
    }

    public float getVisibleItemCount() {
        return 1.0f;
    }

    public void h(int i, boolean z) {
        VerticalGridView verticalGridView = (VerticalGridView) this.d.get(i);
        int selectedPosition = verticalGridView.getSelectedPosition();
        int i2 = 0;
        while (i2 < verticalGridView.getAdapter().n()) {
            View a0 = verticalGridView.getLayoutManager().a0(i2);
            if (a0 != null) {
                g(a0, selectedPosition == i2, i, z);
            }
            i2++;
        }
    }

    public final void i() {
        for (int i = 0; i < getColumnsCount(); i++) {
            j((VerticalGridView) this.d.get(i));
        }
    }

    public final void j(VerticalGridView verticalGridView) {
        ViewGroup.LayoutParams layoutParams = verticalGridView.getLayoutParams();
        float activatedVisibleItemCount = isActivated() ? getActivatedVisibleItemCount() : getVisibleItemCount();
        layoutParams.height = (int) ((getPickerItemHeightPixels() * activatedVisibleItemCount) + (verticalGridView.getVerticalSpacing() * (activatedVisibleItemCount - 1.0f)));
        verticalGridView.setLayoutParams(layoutParams);
    }

    public final void k() {
        boolean isActivated = isActivated();
        for (int i = 0; i < getColumnsCount(); i++) {
            VerticalGridView verticalGridView = (VerticalGridView) this.d.get(i);
            for (int i2 = 0; i2 < verticalGridView.getChildCount(); i2++) {
                verticalGridView.getChildAt(i2).setFocusable(isActivated);
            }
        }
    }

    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn < this.d.size()) {
            return ((VerticalGridView) this.d.get(selectedColumn)).requestFocus(i, rect);
        }
        return false;
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        for (int i = 0; i < this.d.size(); i++) {
            if (((VerticalGridView) this.d.get(i)).hasFocus()) {
                setSelectedColumn(i);
            }
        }
    }

    public void setActivated(boolean z) {
        boolean isActivated = isActivated();
        super.setActivated(z);
        if (z == isActivated) {
            return;
        }
        boolean hasFocus = hasFocus();
        int selectedColumn = getSelectedColumn();
        setDescendantFocusability(131072);
        if (!z && hasFocus && isFocusable()) {
            requestFocus();
        }
        for (int i = 0; i < getColumnsCount(); i++) {
            ((VerticalGridView) this.d.get(i)).setFocusable(z);
        }
        i();
        k();
        if (z && hasFocus && selectedColumn >= 0) {
            ((VerticalGridView) this.d.get(selectedColumn)).requestFocus();
        }
        setDescendantFocusability(262144);
    }

    public void setActivatedVisibleItemCount(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (this.n != f) {
            this.n = f;
            if (isActivated()) {
                i();
            }
        }
    }

    public void setColumns(List list) {
        if (this.q.size() == 0) {
            throw new IllegalStateException("Separators size is: " + this.q.size() + ". At least one separator must be provided");
        }
        if (this.q.size() == 1) {
            CharSequence charSequence = (CharSequence) this.q.get(0);
            this.q.clear();
            this.q.add("");
            for (int i = 0; i < list.size() - 1; i++) {
                this.q.add(charSequence);
            }
            this.q.add("");
        } else if (this.q.size() != list.size() + 1) {
            throw new IllegalStateException("Separators size: " + this.q.size() + " mustequal the size of columns: " + list.size() + " + 1");
        }
        this.d.clear();
        this.c.removeAllViews();
        ArrayList arrayList = new ArrayList(list);
        this.e = arrayList;
        if (this.p > arrayList.size() - 1) {
            this.p = this.e.size() - 1;
        }
        LayoutInflater from = LayoutInflater.from(getContext());
        int columnsCount = getColumnsCount();
        if (!TextUtils.isEmpty((CharSequence) this.q.get(0))) {
            TextView inflate = from.inflate(h.e, this.c, false);
            inflate.setText((CharSequence) this.q.get(0));
            this.c.addView(inflate);
        }
        int i2 = 0;
        while (i2 < columnsCount) {
            VerticalGridView verticalGridView = (VerticalGridView) from.inflate(h.c, this.c, false);
            j(verticalGridView);
            verticalGridView.setWindowAlignment(0);
            verticalGridView.setHasFixedSize(false);
            verticalGridView.setFocusable(isActivated());
            verticalGridView.setItemViewCacheSize(0);
            this.d.add(verticalGridView);
            this.c.addView(verticalGridView);
            int i3 = i2 + 1;
            if (!TextUtils.isEmpty((CharSequence) this.q.get(i3))) {
                TextView inflate2 = from.inflate(h.e, this.c, false);
                inflate2.setText((CharSequence) this.q.get(i3));
                this.c.addView(inflate2);
            }
            verticalGridView.setAdapter(new b(getContext(), getPickerItemLayoutId(), getPickerItemTextViewId(), i2));
            verticalGridView.setOnChildViewHolderSelectedListener(this.t);
            i2 = i3;
        }
    }

    public final void setPickerItemTextViewId(int i) {
        this.s = i;
    }

    public void setSelectedColumn(int i) {
        if (this.p != i) {
            this.p = i;
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                h(i2, true);
            }
        }
    }

    public final void setSeparator(CharSequence charSequence) {
        setSeparators(Arrays.asList(new CharSequence[]{charSequence}));
    }

    public final void setSeparators(List list) {
        this.q.clear();
        this.q.addAll(list);
    }

    public void setVisibleItemCount(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (this.o != f) {
            this.o = f;
            if (isActivated()) {
                return;
            }
            i();
        }
    }
}
