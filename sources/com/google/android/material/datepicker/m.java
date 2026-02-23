package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class m extends BaseAdapter {
    public static final int f = v.k().getMaximum(4);
    public final l a;
    public Collection c;
    public c d;
    public final a e;

    public m(l lVar, d dVar, a aVar) {
        this.a = lVar;
        this.e = aVar;
        this.c = dVar.B();
    }

    public int a(int i) {
        return b() + (i - 1);
    }

    public int b() {
        return this.a.r();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i) {
        if (i < this.a.r() || i > g()) {
            return null;
        }
        return Long.valueOf(this.a.t(h(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 1
            android.content.Context r1 = r8.getContext()
            r5.e(r1)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            if (r7 != 0) goto L1f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r1 = R4.h.m
            android.view.View r7 = r7.inflate(r1, r8, r2)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
        L1f:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L73
            com.google.android.material.datepicker.l r8 = r5.a
            int r3 = r8.f
            if (r7 < r3) goto L2e
            goto L73
        L2e:
            int r7 = r7 + r0
            r1.setTag(r8)
            android.content.res.Resources r8 = r1.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r1.setText(r8)
            com.google.android.material.datepicker.l r8 = r5.a
            long r7 = r8.t(r7)
            com.google.android.material.datepicker.l r3 = r5.a
            int r3 = r3.d
            com.google.android.material.datepicker.l r4 = com.google.android.material.datepicker.l.h()
            int r4 = r4.d
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.f.a(r7)
        L63:
            r1.setContentDescription(r7)
            goto L6c
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.f.d(r7)
            goto L63
        L6c:
            r1.setVisibility(r2)
            r1.setEnabled(r0)
            goto L7b
        L73:
            r7 = 8
            r1.setVisibility(r7)
            r1.setEnabled(r2)
        L7b:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L82
            return r1
        L82:
            long r6 = r6.longValue()
            r5.i(r1, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.m.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public final void e(Context context) {
        if (this.d == null) {
            this.d = new c(context);
        }
    }

    public final boolean f(long j) {
        throw null;
    }

    public int g() {
        return (this.a.r() + this.a.f) - 1;
    }

    public int getCount() {
        return this.a.f + b();
    }

    public long getItemId(int i) {
        return i / this.a.e;
    }

    public int h(int i) {
        return (i - this.a.r()) + 1;
    }

    public boolean hasStableIds() {
        return true;
    }

    public final void i(TextView textView, long j) {
        b bVar;
        if (textView == null) {
            return;
        }
        if (this.e.f().b(j)) {
            textView.setEnabled(true);
            if (f(j)) {
                bVar = this.d.b;
            } else {
                long timeInMillis = v.i().getTimeInMillis();
                c cVar = this.d;
                bVar = timeInMillis == j ? cVar.c : cVar.a;
            }
        } else {
            textView.setEnabled(false);
            bVar = this.d.g;
        }
        bVar.b(textView);
    }

    public final void j(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (l.d(j).equals(this.a)) {
            i((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.a.v(j)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    public void k(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            j(materialCalendarGridView, ((Long) it.next()).longValue());
        }
    }

    public boolean l(int i) {
        return i >= b() && i <= g();
    }
}
