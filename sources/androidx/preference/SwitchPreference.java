package androidx.preference;

import F.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import z0.c;
import z0.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SwitchPreference extends TwoStatePreference {
    public final a J;
    public CharSequence K;
    public CharSequence L;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreference.this.a(Boolean.valueOf(z))) {
                SwitchPreference.this.N(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.j, 16843629));
    }

    private void V(View view) {
        if (((AccessibilityManager) h().getSystemService("accessibility")).isEnabled()) {
            U(view.findViewById(16908352));
            R(view.findViewById(16908304));
        }
    }

    public void F(View view) {
        super.F(view);
        V(view);
    }

    public void S(CharSequence charSequence) {
        this.L = charSequence;
        y();
    }

    public void T(CharSequence charSequence) {
        this.K = charSequence;
        y();
    }

    public final void U(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.E);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.K);
            r4.setTextOff(this.L);
            r4.setOnCheckedChangeListener(this.J);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.J = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.J0, i, i2);
        Q(k.o(obtainStyledAttributes, g.R0, g.K0));
        P(k.o(obtainStyledAttributes, g.Q0, g.L0));
        T(k.o(obtainStyledAttributes, g.T0, g.N0));
        S(k.o(obtainStyledAttributes, g.S0, g.O0));
        O(k.b(obtainStyledAttributes, g.P0, g.M0, false));
        obtainStyledAttributes.recycle();
    }
}
