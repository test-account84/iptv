package com.google.android.material.datepicker;

import P.L;
import Q.C;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class MaterialCalendarGridView extends GridView {
    public final Calendar a;
    public final boolean c;

    public class a extends P.a {
        public a() {
        }

        public void g(View view, C c) {
            super.g(view, c);
            c.Z((Object) null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(int i, Rect rect) {
        int b;
        if (i == 33) {
            b = getAdapter().g();
        } else {
            if (i != 130) {
                super.onFocusChanged(true, i, rect);
                return;
            }
            b = getAdapter().b();
        }
        setSelection(b);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m getAdapter() {
        return super.getAdapter();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m adapter = getAdapter();
        adapter.getClass();
        int max = Math.max(adapter.b(), getFirstVisiblePosition());
        int min = Math.min(adapter.g(), getLastVisiblePosition());
        adapter.c(max);
        adapter.c(min);
        throw null;
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            a(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    public void onMeasure(int i, int i2) {
        if (!this.c) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    public void setSelection(int i) {
        if (i < getAdapter().b()) {
            i = getAdapter().b();
        }
        super.setSelection(i);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = v.k();
        if (j.W(getContext())) {
            setNextFocusLeftId(R4.f.a);
            setNextFocusRightId(R4.f.c);
        }
        this.c = j.X(getContext());
        L.s0(this, new a());
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof m)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), m.class.getCanonicalName()}));
        }
        super.setAdapter(listAdapter);
    }
}
