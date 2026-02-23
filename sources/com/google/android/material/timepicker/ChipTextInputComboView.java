package com.google.android.material.timepicker;

import R4.h;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import d.f;
import f5.t;
import f5.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip a;
    public final TextInputLayout c;
    public final EditText d;
    public TextWatcher e;
    public TextView f;

    public class b extends t {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.b(ChipTextInputComboView.this).setText(ChipTextInputComboView.a(ChipTextInputComboView.this, "00"));
            } else {
                ChipTextInputComboView.b(ChipTextInputComboView.this).setText(ChipTextInputComboView.a(ChipTextInputComboView.this, editable));
            }
        }

        public /* synthetic */ b(ChipTextInputComboView chipTextInputComboView, a aVar) {
            this();
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ String a(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        return chipTextInputComboView.c(charSequence);
    }

    public static /* synthetic */ Chip b(ChipTextInputComboView chipTextInputComboView) {
        return chipTextInputComboView.a;
    }

    public final String c(CharSequence charSequence) {
        return d.a(getResources(), charSequence);
    }

    public final void d() {
        if (Build.VERSION.SDK_INT >= 24) {
            com.google.android.material.timepicker.a.a(this.d, f.a(getContext().getResources().getConfiguration()));
        }
    }

    public boolean isChecked() {
        return this.a.isChecked();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    public void setChecked(boolean z) {
        this.a.setChecked(z);
        this.d.setVisibility(z ? 0 : 4);
        this.a.setVisibility(z ? 8 : 0);
        if (isChecked()) {
            w.h(this.d);
            if (TextUtils.isEmpty(this.d.getText())) {
                return;
            }
            EditText editText = this.d;
            editText.setSelection(editText.getText().length());
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public void setTag(int i, Object obj) {
        this.a.setTag(i, obj);
    }

    public void toggle() {
        this.a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater from = LayoutInflater.from(context);
        Chip inflate = from.inflate(h.i, this, false);
        this.a = inflate;
        inflate.setAccessibilityClassName("android.view.View");
        TextInputLayout inflate2 = from.inflate(h.j, this, false);
        this.c = inflate2;
        EditText editText = inflate2.getEditText();
        this.d = editText;
        editText.setVisibility(4);
        b bVar = new b(this, null);
        this.e = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(inflate);
        addView(inflate2);
        this.f = findViewById(R4.f.l);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
