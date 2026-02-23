package androidx.preference;

import F.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashSet;
import java.util.Set;
import z0.c;
import z0.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    public CharSequence[] K;
    public CharSequence[] L;
    public Set M;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.b, 16842897));
    }

    public Object C(TypedArray typedArray, int i) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.M = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.D, i, i2);
        this.K = k.q(obtainStyledAttributes, g.G, g.E);
        this.L = k.q(obtainStyledAttributes, g.H, g.F);
        obtainStyledAttributes.recycle();
    }
}
