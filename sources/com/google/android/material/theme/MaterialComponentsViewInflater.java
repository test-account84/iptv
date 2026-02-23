package com.google.android.material.theme;

import X4.a;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d.w;
import k.c;
import k.e;
import o5.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MaterialComponentsViewInflater extends w {
    public c c(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    public e d(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    public AppCompatRadioButton k(Context context, AttributeSet attributeSet) {
        return new h5.a(context, attributeSet);
    }

    public AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
