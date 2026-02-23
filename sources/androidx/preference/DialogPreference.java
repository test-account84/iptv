package androidx.preference;

import F.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import z0.c;
import z0.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class DialogPreference extends Preference {
    public CharSequence E;
    public CharSequence F;
    public Drawable G;
    public CharSequence H;
    public CharSequence I;
    public int J;

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.b, 16842897));
    }

    public void A() {
        r();
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.i, i, i2);
        String o = k.o(obtainStyledAttributes, g.s, g.j);
        this.E = o;
        if (o == null) {
            this.E = u();
        }
        this.F = k.o(obtainStyledAttributes, g.r, g.k);
        this.G = k.c(obtainStyledAttributes, g.p, g.l);
        this.H = k.o(obtainStyledAttributes, g.u, g.m);
        this.I = k.o(obtainStyledAttributes, g.t, g.n);
        this.J = k.n(obtainStyledAttributes, g.q, g.o, 0);
        obtainStyledAttributes.recycle();
    }
}
