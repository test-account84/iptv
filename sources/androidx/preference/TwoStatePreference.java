package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class TwoStatePreference extends Preference {
    public boolean E;
    public CharSequence F;
    public CharSequence G;
    public boolean H;
    public boolean I;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void A() {
        super.A();
        boolean z = !M();
        if (a(Boolean.valueOf(z))) {
            N(z);
        }
    }

    public Object C(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    public boolean K() {
        return (this.I ? this.E : !this.E) || super.K();
    }

    public boolean M() {
        return this.E;
    }

    public void N(boolean z) {
        boolean z2 = this.E != z;
        if (z2 || !this.H) {
            this.E = z;
            this.H = true;
            G(z);
            if (z2) {
                z(K());
                y();
            }
        }
    }

    public void O(boolean z) {
        this.I = z;
    }

    public void P(CharSequence charSequence) {
        this.G = charSequence;
        if (M()) {
            return;
        }
        y();
    }

    public void Q(CharSequence charSequence) {
        this.F = charSequence;
        if (M()) {
            y();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void R(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.E
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r4.F
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r4.F
        L16:
            r5.setText(r0)
            r0 = 0
            goto L2b
        L1b:
            boolean r0 = r4.E
            if (r0 != 0) goto L2a
            java.lang.CharSequence r0 = r4.G
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2a
            java.lang.CharSequence r0 = r4.G
            goto L16
        L2a:
            r0 = 1
        L2b:
            if (r0 == 0) goto L3b
            java.lang.CharSequence r2 = r4.s()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L3b
            r5.setText(r2)
            r0 = 0
        L3b:
            if (r0 != 0) goto L3e
            goto L40
        L3e:
            r1 = 8
        L40:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L49
            r5.setVisibility(r1)
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.R(android.view.View):void");
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
