package androidx.preference;

import F.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import z0.c;
import z0.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final a J;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (CheckBoxPreference.this.a(Boolean.valueOf(z))) {
                CheckBoxPreference.this.N(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.a, 16842895));
    }

    public void F(View view) {
        super.F(view);
        T(view);
    }

    public final void S(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.E);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.J);
        }
    }

    public final void T(View view) {
        if (((AccessibilityManager) h().getSystemService("accessibility")).isEnabled()) {
            S(view.findViewById(16908289));
            R(view.findViewById(16908304));
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.J = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.b, i, i2);
        Q(k.o(obtainStyledAttributes, g.h, g.c));
        P(k.o(obtainStyledAttributes, g.g, g.d));
        O(k.b(obtainStyledAttributes, g.f, g.e, false));
        obtainStyledAttributes.recycle();
    }
}
