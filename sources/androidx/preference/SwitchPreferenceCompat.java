package androidx.preference;

import F.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import z0.c;
import z0.d;
import z0.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final a J;
    public CharSequence K;
    public CharSequence L;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreferenceCompat.this.a(Boolean.valueOf(z))) {
                SwitchPreferenceCompat.this.N(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.i);
    }

    private void U(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.E);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.K);
            switchCompat.setTextOff(this.L);
            switchCompat.setOnCheckedChangeListener(this.J);
        }
    }

    private void V(View view) {
        if (((AccessibilityManager) h().getSystemService("accessibility")).isEnabled()) {
            U(view.findViewById(d.a));
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

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.J = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.U0, i, i2);
        Q(k.o(obtainStyledAttributes, g.c1, g.V0));
        P(k.o(obtainStyledAttributes, g.b1, g.W0));
        T(k.o(obtainStyledAttributes, g.e1, g.Y0));
        S(k.o(obtainStyledAttributes, g.d1, g.Z0));
        O(k.b(obtainStyledAttributes, g.a1, g.X0, false));
        obtainStyledAttributes.recycle();
    }
}
