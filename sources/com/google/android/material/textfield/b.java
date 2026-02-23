package com.google.android.material.textfield;

import P.L;
import Q.C;
import Q.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import f5.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b extends o5.d {
    public static final boolean t = true;
    public final TextWatcher e;
    public final View.OnFocusChangeListener f;
    public final TextInputLayout.e g;
    public final TextInputLayout.f h;
    public final TextInputLayout.g i;
    public final View.OnAttachStateChangeListener j;
    public final c.b k;
    public boolean l;
    public boolean m;
    public long n;
    public StateListDrawable o;
    public l5.g p;
    public AccessibilityManager q;
    public ValueAnimator r;
    public ValueAnimator s;

    public class a extends t {

        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView a;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            public void run() {
                boolean isPopupShowing = this.a.isPopupShowing();
                b.r(b.this, isPopupShowing);
                b.s(b.this, isPopupShowing);
            }
        }

        public a() {
        }

        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView e = b.e(b.this.a.getEditText());
            if (b.f(b.this).isTouchExplorationEnabled() && b.q(e) && !b.this.c.hasFocus()) {
                e.dismissDropDown();
            }
            e.post(new a(e));
        }
    }

    public class b implements AutoCompleteTextView.OnDismissListener {
        public b() {
        }

        public void onDismiss() {
            b.u(b.this);
            b.r(b.this, false);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            b bVar = b.this;
            bVar.c.setChecked(b.o(bVar));
            b.p(b.this).start();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        public void onFocusChange(View view, boolean z) {
            b.this.a.setEndIconActivated(z);
            if (z) {
                return;
            }
            b.r(b.this, false);
            b.s(b.this, false);
        }
    }

    public class f extends TextInputLayout.e {
        public f(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        public void g(View view, C c) {
            super.g(view, c);
            if (!b.q(b.this.a.getEditText())) {
                c.X(Spinner.class.getName());
            }
            if (c.J()) {
                c.h0((CharSequence) null);
            }
        }

        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            AutoCompleteTextView e = b.e(b.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && b.f(b.this).isEnabled() && !b.q(b.this.a.getEditText())) {
                b.t(b.this, e);
                b.u(b.this);
            }
        }
    }

    public class g implements TextInputLayout.f {
        public g() {
        }

        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView e = b.e(textInputLayout.getEditText());
            b.v(b.this, e);
            b.w(b.this, e);
            b.x(b.this, e);
            e.setThreshold(0);
            e.removeTextChangedListener(b.g(b.this));
            e.addTextChangedListener(b.g(b.this));
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!b.q(e) && b.f(b.this).isTouchExplorationEnabled()) {
                L.C0(b.this.c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(b.h(b.this));
            textInputLayout.setEndIconVisible(true);
        }
    }

    public class h implements TextInputLayout.g {

        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView a;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            public void run() {
                this.a.removeTextChangedListener(b.g(b.this));
            }
        }

        public h() {
        }

        public void a(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView editText = textInputLayout.getEditText();
            if (editText != null && i == 3) {
                editText.post(new a(editText));
                if (editText.getOnFocusChangeListener() == b.i(b.this)) {
                    editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
                editText.setOnTouchListener((View.OnTouchListener) null);
                if (b.j()) {
                    editText.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
                }
            }
            if (i == 3) {
                textInputLayout.removeOnAttachStateChangeListener(b.k(b.this));
                b.l(b.this);
            }
        }
    }

    public class i implements View.OnAttachStateChangeListener {
        public i() {
        }

        public void onViewAttachedToWindow(View view) {
            b.m(b.this);
        }

        public void onViewDetachedFromWindow(View view) {
            b.l(b.this);
        }
    }

    public class j implements c.b {
        public j() {
        }

        public void onTouchExplorationStateChanged(boolean z) {
            AutoCompleteTextView editText;
            TextInputLayout textInputLayout = b.this.a;
            if (textInputLayout == null || (editText = textInputLayout.getEditText()) == null || b.q(editText)) {
                return;
            }
            L.C0(b.this.c, z ? 2 : 1);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        public void onClick(View view) {
            b.t(b.this, b.this.a.getEditText());
        }
    }

    public class l implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public l(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (b.n(b.this)) {
                    b.s(b.this, false);
                }
                b.t(b.this, this.a);
                b.u(b.this);
            }
            return false;
        }
    }

    public b(TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
        this.e = new a();
        this.f = new e();
        this.g = new f(this.a);
        this.h = new g();
        this.i = new h();
        this.j = new i();
        this.k = new j();
        this.l = false;
        this.m = false;
        this.n = Long.MAX_VALUE;
    }

    public static AutoCompleteTextView C(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private void F() {
        this.s = D(67, 0.0f, 1.0f);
        ValueAnimator D = D(50, 1.0f, 0.0f);
        this.r = D;
        D.addListener(new c());
    }

    public static boolean H(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static /* synthetic */ AutoCompleteTextView e(EditText editText) {
        return C(editText);
    }

    public static /* synthetic */ AccessibilityManager f(b bVar) {
        return bVar.q;
    }

    public static /* synthetic */ TextWatcher g(b bVar) {
        return bVar.e;
    }

    public static /* synthetic */ TextInputLayout.e h(b bVar) {
        return bVar.g;
    }

    public static /* synthetic */ View.OnFocusChangeListener i(b bVar) {
        return bVar.f;
    }

    public static /* synthetic */ boolean j() {
        return t;
    }

    public static /* synthetic */ View.OnAttachStateChangeListener k(b bVar) {
        return bVar.j;
    }

    public static /* synthetic */ void l(b bVar) {
        bVar.I();
    }

    public static /* synthetic */ void m(b bVar) {
        bVar.B();
    }

    public static /* synthetic */ boolean n(b bVar) {
        return bVar.G();
    }

    public static /* synthetic */ boolean o(b bVar) {
        return bVar.m;
    }

    public static /* synthetic */ ValueAnimator p(b bVar) {
        return bVar.s;
    }

    public static /* synthetic */ boolean q(EditText editText) {
        return H(editText);
    }

    public static /* synthetic */ void r(b bVar, boolean z) {
        bVar.J(z);
    }

    public static /* synthetic */ boolean s(b bVar, boolean z) {
        bVar.l = z;
        return z;
    }

    public static /* synthetic */ void t(b bVar, AutoCompleteTextView autoCompleteTextView) {
        bVar.M(autoCompleteTextView);
    }

    public static /* synthetic */ void u(b bVar) {
        bVar.N();
    }

    public static /* synthetic */ void v(b bVar, AutoCompleteTextView autoCompleteTextView) {
        bVar.K(autoCompleteTextView);
    }

    public static /* synthetic */ void w(b bVar, AutoCompleteTextView autoCompleteTextView) {
        bVar.y(autoCompleteTextView);
    }

    public static /* synthetic */ void x(b bVar, AutoCompleteTextView autoCompleteTextView) {
        bVar.L(autoCompleteTextView);
    }

    public final void A(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, l5.g gVar) {
        LayerDrawable layerDrawable;
        int d2 = Z4.a.d(autoCompleteTextView, R4.b.m);
        l5.g gVar2 = new l5.g(gVar.C());
        int h2 = Z4.a.h(i2, d2, 0.1f);
        gVar2.W(new ColorStateList(iArr, new int[]{h2, 0}));
        if (t) {
            gVar2.setTint(d2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{h2, d2});
            l5.g gVar3 = new l5.g(gVar.C());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        L.w0(autoCompleteTextView, layerDrawable);
    }

    public final void B() {
        TextInputLayout textInputLayout;
        if (this.q == null || (textInputLayout = this.a) == null || !L.V(textInputLayout)) {
            return;
        }
        Q.c.a(this.q, this.k);
    }

    public final ValueAnimator D(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(S4.a.a);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    public final l5.g E(float f2, float f3, float f4, int i2) {
        l5.k m = l5.k.a().A(f2).E(f2).s(f3).w(f3).m();
        l5.g m2 = l5.g.m(this.b, f4);
        m2.setShapeAppearanceModel(m);
        m2.Y(0, i2, 0, i2);
        return m2;
    }

    public final boolean G() {
        long currentTimeMillis = System.currentTimeMillis() - this.n;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    public final void I() {
        AccessibilityManager accessibilityManager = this.q;
        if (accessibilityManager != null) {
            Q.c.b(accessibilityManager, this.k);
        }
    }

    public final void J(boolean z) {
        if (this.m != z) {
            this.m = z;
            this.s.cancel();
            this.r.start();
        }
    }

    public final void K(AutoCompleteTextView autoCompleteTextView) {
        l5.g gVar;
        if (t) {
            int boxBackgroundMode = this.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                gVar = this.p;
            } else if (boxBackgroundMode != 1) {
                return;
            } else {
                gVar = this.o;
            }
            autoCompleteTextView.setDropDownBackgroundDrawable(gVar);
        }
    }

    public final void L(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new l(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f);
        if (t) {
            autoCompleteTextView.setOnDismissListener(new b());
        }
    }

    public final void M(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (G()) {
            this.l = false;
        }
        if (this.l) {
            this.l = false;
            return;
        }
        if (t) {
            J(!this.m);
        } else {
            this.m = !this.m;
            this.c.toggle();
        }
        if (!this.m) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    public final void N() {
        this.l = true;
        this.n = System.currentTimeMillis();
    }

    public void O(AutoCompleteTextView autoCompleteTextView) {
        if (!H(autoCompleteTextView) && this.a.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
            y(autoCompleteTextView);
        }
    }

    public void a() {
        float dimensionPixelOffset = this.b.getResources().getDimensionPixelOffset(R4.d.U);
        float dimensionPixelOffset2 = this.b.getResources().getDimensionPixelOffset(R4.d.Q);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R4.d.R);
        l5.g E = E(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        l5.g E2 = E(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.p = E;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.o = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, E);
        this.o.addState(new int[0], E2);
        int i2 = this.d;
        if (i2 == 0) {
            i2 = t ? R4.e.d : R4.e.e;
        }
        this.a.setEndIconDrawable(i2);
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R4.j.g));
        this.a.setEndIconOnClickListener(new k());
        this.a.g(this.h);
        this.a.h(this.i);
        F();
        this.q = (AccessibilityManager) this.b.getSystemService("accessibility");
        this.a.addOnAttachStateChangeListener(this.j);
        B();
    }

    public boolean b(int i2) {
        return i2 != 0;
    }

    public boolean d() {
        return true;
    }

    public final void y(AutoCompleteTextView autoCompleteTextView) {
        if (H(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.a.getBoxBackgroundMode();
        l5.g boxBackground = this.a.getBoxBackground();
        int d2 = Z4.a.d(autoCompleteTextView, R4.b.i);
        int[][] iArr = {new int[]{16842919}, new int[0]};
        if (boxBackgroundMode == 2) {
            A(autoCompleteTextView, d2, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            z(autoCompleteTextView, d2, iArr, boxBackground);
        }
    }

    public final void z(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, l5.g gVar) {
        int boxBackgroundColor = this.a.getBoxBackgroundColor();
        int[] iArr2 = {Z4.a.h(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (t) {
            L.w0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        l5.g gVar2 = new l5.g(gVar.C());
        gVar2.W(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int J = L.J(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int I = L.I(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        L.w0(autoCompleteTextView, layerDrawable);
        L.F0(autoCompleteTextView, J, paddingTop, I, paddingBottom);
    }
}
