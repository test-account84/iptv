package com.google.android.material.textfield;

import R4.j;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a extends o5.d {
    public final TextWatcher e;
    public final View.OnFocusChangeListener f;
    public final TextInputLayout.f g;
    public final TextInputLayout.g h;
    public AnimatorSet i;
    public ValueAnimator j;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (a.this.a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            a.f(aVar, a.e(aVar));
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z) {
            a aVar = a.this;
            a.f(aVar, a.e(aVar));
        }
    }

    public class c implements TextInputLayout.f {
        public c() {
        }

        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.e(a.this));
            editText.setOnFocusChangeListener(a.g(a.this));
            a aVar = a.this;
            aVar.c.setOnFocusChangeListener(a.g(aVar));
            editText.removeTextChangedListener(a.h(a.this));
            editText.addTextChangedListener(a.h(a.this));
        }
    }

    public class d implements TextInputLayout.g {

        public class a implements Runnable {
            public final /* synthetic */ EditText a;

            public a(EditText editText) {
                this.a = editText;
            }

            public void run() {
                this.a.removeTextChangedListener(a.h(a.this));
                a.f(a.this, true);
            }
        }

        public d() {
        }

        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 2) {
                return;
            }
            editText.post(new a(editText));
            if (editText.getOnFocusChangeListener() == a.g(a.this)) {
                editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            }
            if (a.this.c.getOnFocusChangeListener() == a.g(a.this)) {
                a.this.c.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.U();
        }
    }

    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        public void onAnimationStart(Animator animator) {
            a.this.a.setEndIconVisible(true);
        }
    }

    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        public void onAnimationEnd(Animator animator) {
            a.this.a.setEndIconVisible(false);
        }
    }

    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.c.setScaleX(floatValue);
            a.this.c.setScaleY(floatValue);
        }
    }

    public a(TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
        this.e = new a();
        this.f = new b();
        this.g = new c();
        this.h = new d();
    }

    public static /* synthetic */ boolean e(a aVar) {
        return aVar.m();
    }

    public static /* synthetic */ void f(a aVar, boolean z) {
        aVar.i(z);
    }

    public static /* synthetic */ View.OnFocusChangeListener g(a aVar) {
        return aVar.f;
    }

    public static /* synthetic */ TextWatcher h(a aVar) {
        return aVar.e;
    }

    public void a() {
        TextInputLayout textInputLayout = this.a;
        int i2 = this.d;
        if (i2 == 0) {
            i2 = R4.e.f;
        }
        textInputLayout.setEndIconDrawable(i2);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(j.e));
        this.a.setEndIconCheckable(false);
        this.a.setEndIconOnClickListener(new e());
        this.a.g(this.g);
        this.a.h(this.h);
        l();
    }

    public void c(boolean z) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        i(z);
    }

    public final void i(boolean z) {
        boolean z2 = this.a.K() == z;
        if (z && !this.i.isRunning()) {
            this.j.cancel();
            this.i.start();
            if (z2) {
                this.i.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.i.cancel();
        this.j.start();
        if (z2) {
            this.j.end();
        }
    }

    public final ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(S4.a.a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    public final ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(S4.a.d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    public final void l() {
        Animator k = k();
        Animator j = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.i = animatorSet;
        animatorSet.playTogether(new Animator[]{k, j});
        this.i.addListener(new f());
        ValueAnimator j2 = j(1.0f, 0.0f);
        this.j = j2;
        j2.addListener(new g());
    }

    public final boolean m() {
        EditText editText = this.a.getEditText();
        return editText != null && (editText.hasFocus() || this.c.hasFocus()) && editText.getText().length() > 0;
    }
}
