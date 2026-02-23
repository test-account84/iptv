package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.preference;

import a7.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.ListPreference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class IjkListPreference extends ListPreference {
    public CharSequence[] P;

    public IjkListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        T(context, attributeSet);
    }

    public static String U() {
        return "W91ciBUViBTZXJ2aWNlIFByb3ZpZGVyIGhhcyBub3QgcHJvdmlkZWQgeW91ciB0aGUgb3JpZ2luYWwgYXBwLg==";
    }

    public static String V() {
        return "3VjaCBraW5kIG9mIGFwcHMgY291bGQgc2VuZCB0aGUgZGF0YSB0byBsZWdhbCBhdXRob3JpdGllcy4=";
    }

    public static String W() {
        return "W";
    }

    public final void T(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.a, 0, 0);
        if (obtainStyledAttributes == null) {
            return;
        }
        this.P = obtainStyledAttributes.getTextArray(l.b);
        obtainStyledAttributes.recycle();
    }
}
