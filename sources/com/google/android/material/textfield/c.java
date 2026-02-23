package com.google.android.material.textfield;

import R4.e;
import R4.j;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import f5.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c extends o5.d {
    public final TextWatcher e;
    public final TextInputLayout.f f;
    public final TextInputLayout.g g;

    public class a extends t {
        public a() {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            c.this.c.setChecked(!c.e(r1));
        }
    }

    public class b implements TextInputLayout.f {
        public b() {
        }

        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            c.this.c.setChecked(!c.e(r0));
            editText.removeTextChangedListener(c.f(c.this));
            editText.addTextChangedListener(c.f(c.this));
        }
    }

    public class c implements TextInputLayout.g {

        public class a implements Runnable {
            public final /* synthetic */ EditText a;

            public a(EditText editText) {
                this.a = editText;
            }

            public void run() {
                this.a.removeTextChangedListener(c.f(c.this));
            }
        }

        public c() {
        }

        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            EditText editText = c.this.a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            editText.setTransformationMethod(c.e(c.this) ? null : PasswordTransformationMethod.getInstance());
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            c.this.a.U();
        }
    }

    public c(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.e = new a();
        this.f = new b();
        this.g = new c();
    }

    public static /* synthetic */ boolean e(c cVar) {
        return cVar.g();
    }

    public static /* synthetic */ TextWatcher f(c cVar) {
        return cVar.e;
    }

    public static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    public void a() {
        TextInputLayout textInputLayout = this.a;
        int i = this.d;
        if (i == 0) {
            i = e.a;
        }
        textInputLayout.setEndIconDrawable(i);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(j.t));
        this.a.setEndIconVisible(true);
        this.a.setEndIconCheckable(true);
        this.a.setEndIconOnClickListener(new d());
        this.a.g(this.f);
        this.a.h(this.g);
        EditText editText = this.a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean g() {
        EditText editText = this.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
