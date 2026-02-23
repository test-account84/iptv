package androidx.preference;

import F.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import z0.c;
import z0.f;
import z0.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListPreference extends DialogPreference {
    public CharSequence[] K;
    public CharSequence[] L;
    public String M;
    public String N;
    public boolean O;

    public static final class a implements Preference.b {
        public static a a;

        public static a b() {
            if (a == null) {
                a = new a();
            }
            return a;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.O()) ? listPreference.h().getString(f.a) : listPreference.O();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.b, 16842897));
    }

    public Object C(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public int M(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.L) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.L[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] N() {
        return this.K;
    }

    public CharSequence O() {
        CharSequence[] charSequenceArr;
        int R = R();
        if (R < 0 || (charSequenceArr = this.K) == null) {
            return null;
        }
        return charSequenceArr[R];
    }

    public CharSequence[] P() {
        return this.L;
    }

    public String Q() {
        return this.M;
    }

    public final int R() {
        return M(this.M);
    }

    public void S(String str) {
        boolean z = !TextUtils.equals(this.M, str);
        if (z || !this.O) {
            this.M = str;
            this.O = true;
            I(str);
            if (z) {
                y();
            }
        }
    }

    public CharSequence s() {
        if (t() != null) {
            return t().a(this);
        }
        String O = O();
        CharSequence s = super.s();
        String str = this.N;
        if (str == null) {
            return s;
        }
        if (O == null) {
            O = "";
        }
        String format = String.format(str, new Object[]{O});
        if (TextUtils.equals(format, s)) {
            return s;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.x, i, i2);
        this.K = k.q(obtainStyledAttributes, g.A, g.y);
        this.L = k.q(obtainStyledAttributes, g.B, g.z);
        int i3 = g.C;
        if (k.b(obtainStyledAttributes, i3, i3, false)) {
            J(a.b());
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.I, i, i2);
        this.N = k.o(obtainStyledAttributes2, g.q0, g.Q);
        obtainStyledAttributes2.recycle();
    }
}
