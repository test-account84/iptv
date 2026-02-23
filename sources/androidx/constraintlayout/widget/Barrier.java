package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import x.e;
import z.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Barrier extends b {
    public int j;
    public int k;
    public x.a l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.l = new x.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == d.h1) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == d.g1) {
                    this.l.K0(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == d.i1) {
                    this.l.M0(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
        }
        this.e = this.l;
        k();
    }

    public void f(e eVar, boolean z) {
        m(eVar, this.j, z);
    }

    public int getMargin() {
        return this.l.I0();
    }

    public int getType() {
        return this.j;
    }

    public boolean l() {
        return this.l.G0();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(x.e r4, int r5, boolean r6) {
        /*
            r3 = this;
            r3.k = r5
            r5 = 0
            r0 = 6
            r1 = 1
            r2 = 5
            if (r6 == 0) goto L14
            int r6 = r3.j
            if (r6 != r2) goto Lf
        Lc:
            r3.k = r1
            goto L1c
        Lf:
            if (r6 != r0) goto L1c
        L11:
            r3.k = r5
            goto L1c
        L14:
            int r6 = r3.j
            if (r6 != r2) goto L19
            goto L11
        L19:
            if (r6 != r0) goto L1c
            goto Lc
        L1c:
            boolean r5 = r4 instanceof x.a
            if (r5 == 0) goto L27
            x.a r4 = (x.a) r4
            int r5 = r3.k
            r4.L0(r5)
        L27:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.Barrier.m(x.e, int, boolean):void");
    }

    public void setAllowsGoneWidget(boolean z) {
        this.l.K0(z);
    }

    public void setDpMargin(int i) {
        this.l.M0((int) ((i * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i) {
        this.l.M0(i);
    }

    public void setType(int i) {
        this.j = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
