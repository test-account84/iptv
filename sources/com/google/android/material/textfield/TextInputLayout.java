package com.google.android.material.textfield;

import K0.n;
import P.L;
import P.s;
import Q.C;
import R4.j;
import R4.k;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.internal.CheckableImageButton;
import f5.u;
import f5.w;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k.M;
import k.d0;
import l5.k;
import o5.i;
import o5.l;
import o5.m;
import o5.o;
import o5.p;
import o5.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class TextInputLayout extends LinearLayout {
    public static final int N0 = k.j;
    public ColorStateList A;
    public ColorStateList A0;
    public CharSequence B;
    public int B0;
    public final TextView C;
    public int C0;
    public boolean D;
    public int D0;
    public CharSequence E;
    public int E0;
    public boolean F;
    public int F0;
    public l5.g G;
    public boolean G0;
    public l5.g H;
    public final f5.b H0;
    public l5.g I;
    public boolean I0;
    public l5.k J;
    public boolean J0;
    public boolean K;
    public ValueAnimator K0;
    public final int L;
    public boolean L0;
    public int M;
    public boolean M0;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public final Rect T;
    public final Rect U;
    public final RectF V;
    public Typeface W;
    public final FrameLayout a;
    public final i c;
    public final LinearLayout d;
    public final FrameLayout e;
    public Drawable e0;
    public EditText f;
    public int f0;
    public CharSequence g;
    public final LinkedHashSet g0;
    public int h;
    public int h0;
    public int i;
    public final SparseArray i0;
    public int j;
    public final CheckableImageButton j0;
    public int k;
    public final LinkedHashSet k0;
    public final o5.f l;
    public ColorStateList l0;
    public boolean m;
    public PorterDuff.Mode m0;
    public int n;
    public Drawable n0;
    public boolean o;
    public int o0;
    public TextView p;
    public Drawable p0;
    public int q;
    public View.OnLongClickListener q0;
    public int r;
    public View.OnLongClickListener r0;
    public CharSequence s;
    public final CheckableImageButton s0;
    public boolean t;
    public ColorStateList t0;
    public TextView u;
    public PorterDuff.Mode u0;
    public ColorStateList v;
    public ColorStateList v0;
    public int w;
    public ColorStateList w0;
    public K0.d x;
    public int x0;
    public K0.d y;
    public int y0;
    public ColorStateList z;
    public int z0;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.w0(!TextInputLayout.a(r0));
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.m) {
                textInputLayout.m0(editable.length());
            }
            if (TextInputLayout.b(TextInputLayout.this)) {
                TextInputLayout.c(TextInputLayout.this, editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            TextInputLayout.d(TextInputLayout.this).performClick();
            TextInputLayout.d(TextInputLayout.this).jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            TextInputLayout.this.f.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.H0.d0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends P.a {
        public final TextInputLayout d;

        public e(TextInputLayout textInputLayout) {
            this.d = textInputLayout;
        }

        public void g(View view, C c) {
            super.g(view, c);
            EditText editText = this.d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.d.getHint();
            CharSequence error = this.d.getError();
            String placeholderText = this.d.getPlaceholderText();
            int counterMaxLength = this.d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.d.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(text);
            boolean z = !isEmpty;
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(hint);
            boolean z4 = !this.d.N();
            boolean z5 = !TextUtils.isEmpty(error);
            if (!z5 && TextUtils.isEmpty(counterOverflowDescription)) {
                z2 = false;
            }
            String charSequence = z3 ? hint.toString() : "";
            TextInputLayout.e(this.d).v(c);
            if (z) {
                c.u0(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                c.u0(charSequence);
                if (z4 && placeholderText != null) {
                    placeholderText = charSequence + ", " + placeholderText;
                    c.u0(placeholderText);
                }
            } else if (placeholderText != null) {
                c.u0(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    c.h0(charSequence);
                } else {
                    if (z) {
                        charSequence = text + ", " + charSequence;
                    }
                    c.u0(charSequence);
                }
                c.r0(isEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            c.j0(counterMaxLength);
            if (z2) {
                if (!z5) {
                    error = counterOverflowDescription;
                }
                c.d0(error);
            }
            View s = TextInputLayout.f(this.d).s();
            if (s != null) {
                c.i0(s);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    public static class h extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public CharSequence d;
        public boolean e;
        public CharSequence f;
        public CharSequence g;
        public CharSequence h;

        public class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i) {
                return new h[i];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.d = (CharSequence) creator.createFromParcel(parcel);
            this.e = parcel.readInt() == 1;
            this.f = (CharSequence) creator.createFromParcel(parcel);
            this.g = (CharSequence) creator.createFromParcel(parcel);
            this.h = (CharSequence) creator.createFromParcel(parcel);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.d + " hint=" + this.f + " helperText=" + this.g + " placeholderText=" + this.h + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeInt(this.e ? 1 : 0);
            TextUtils.writeToParcel(this.f, parcel, i);
            TextUtils.writeToParcel(this.g, parcel, i);
            TextUtils.writeToParcel(this.h, parcel, i);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.I);
    }

    public static void T(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                T(childAt, z);
            }
        }
    }

    public static /* synthetic */ boolean a(TextInputLayout textInputLayout) {
        return textInputLayout.M0;
    }

    public static void a0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean R = L.R(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = R || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(R);
        checkableImageButton.setPressable(R);
        checkableImageButton.setLongClickable(z);
        L.C0(checkableImageButton, z2 ? 1 : 2);
    }

    public static /* synthetic */ boolean b(TextInputLayout textInputLayout) {
        return textInputLayout.t;
    }

    public static void b0(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        a0(checkableImageButton, onLongClickListener);
    }

    public static /* synthetic */ void c(TextInputLayout textInputLayout, int i) {
        textInputLayout.A0(i);
    }

    public static void c0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a0(checkableImageButton, onLongClickListener);
    }

    public static /* synthetic */ CheckableImageButton d(TextInputLayout textInputLayout) {
        return textInputLayout.j0;
    }

    public static /* synthetic */ i e(TextInputLayout textInputLayout) {
        return textInputLayout.c;
    }

    public static /* synthetic */ o5.f f(TextInputLayout textInputLayout) {
        return textInputLayout.l;
    }

    private o5.d getEndIconDelegate() {
        o5.d dVar = (o5.d) this.i0.get(this.h0);
        return dVar != null ? dVar : (o5.d) this.i0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.s0.getVisibility() == 0) {
            return this.s0;
        }
        if (I() && K()) {
            return this.j0;
        }
        return null;
    }

    public static void n0(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? j.c : j.b, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    private void setEditText(EditText editText) {
        if (this.f != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.h0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f = editText;
        int i = this.h;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.j);
        }
        int i2 = this.i;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.k);
        }
        Q();
        setTextInputAccessibilityDelegate(new e(this));
        this.H0.j0(this.f.getTypeface());
        this.H0.b0(this.f.getTextSize());
        this.H0.X(this.f.getLetterSpacing());
        int gravity = this.f.getGravity();
        this.H0.S((gravity & (-113)) | 48);
        this.H0.a0(gravity);
        this.f.addTextChangedListener(new a());
        if (this.v0 == null) {
            this.v0 = this.f.getHintTextColors();
        }
        if (this.D) {
            if (TextUtils.isEmpty(this.E)) {
                CharSequence hint = this.f.getHint();
                this.g = hint;
                setHint(hint);
                this.f.setHint((CharSequence) null);
            }
            this.F = true;
        }
        if (this.p != null) {
            m0(this.f.getText().length());
        }
        r0();
        this.l.f();
        this.c.bringToFront();
        this.d.bringToFront();
        this.e.bringToFront();
        this.s0.bringToFront();
        B();
        C0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        x0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.E)) {
            return;
        }
        this.E = charSequence;
        this.H0.h0(charSequence);
        if (this.G0) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.t == z) {
            return;
        }
        if (z) {
            i();
        } else {
            X();
            this.u = null;
        }
        this.t = z;
    }

    public final boolean A() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof o5.c);
    }

    public final void A0(int i) {
        if (i != 0 || this.G0) {
            J();
        } else {
            h0();
        }
    }

    public final void B() {
        Iterator it = this.g0.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(this);
        }
    }

    public final void B0(boolean z, boolean z2) {
        int defaultColor = this.A0.getDefaultColor();
        int colorForState = this.A0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.A0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.R = colorForState2;
        } else if (z2) {
            this.R = colorForState;
        } else {
            this.R = defaultColor;
        }
    }

    public final void C(int i) {
        Iterator it = this.k0.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(this, i);
        }
    }

    public final void C0() {
        if (this.f == null) {
            return;
        }
        L.F0(this.C, getContext().getResources().getDimensionPixelSize(R4.d.x), this.f.getPaddingTop(), (K() || L()) ? 0 : L.I(this.f), this.f.getPaddingBottom());
    }

    public final void D(Canvas canvas) {
        l5.g gVar;
        if (this.I == null || (gVar = this.H) == null) {
            return;
        }
        gVar.draw(canvas);
        if (this.f.isFocused()) {
            Rect bounds = this.I.getBounds();
            Rect bounds2 = this.H.getBounds();
            float x = this.H0.x();
            int centerX = bounds2.centerX();
            bounds.left = S4.a.c(centerX, bounds2.left, x);
            bounds.right = S4.a.c(centerX, bounds2.right, x);
            this.I.draw(canvas);
        }
    }

    public final void D0() {
        int visibility = this.C.getVisibility();
        int i = (this.B == null || N()) ? 8 : 0;
        if (visibility != i) {
            getEndIconDelegate().c(i == 0);
        }
        t0();
        this.C.setVisibility(i);
        q0();
    }

    public final void E(Canvas canvas) {
        if (this.D) {
            this.H0.l(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E0() {
        /*
            r5 = this;
            l5.g r0 = r5.G
            if (r0 == 0) goto Ld0
            int r0 = r5.M
            if (r0 != 0) goto La
            goto Ld0
        La:
            boolean r0 = r5.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L1f
            android.widget.EditText r0 = r5.f
            if (r0 == 0) goto L1d
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L1d
            goto L1f
        L1d:
            r0 = 0
            goto L20
        L1f:
            r0 = 1
        L20:
            boolean r3 = r5.isHovered()
            if (r3 != 0) goto L30
            android.widget.EditText r3 = r5.f
            if (r3 == 0) goto L31
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L31
        L30:
            r1 = 1
        L31:
            boolean r3 = r5.isEnabled()
            if (r3 != 0) goto L3c
            int r3 = r5.F0
        L39:
            r5.R = r3
            goto L72
        L3c:
            o5.f r3 = r5.l
            boolean r3 = r3.l()
            if (r3 == 0) goto L53
            android.content.res.ColorStateList r3 = r5.A0
            if (r3 == 0) goto L4c
        L48:
            r5.B0(r0, r1)
            goto L72
        L4c:
            o5.f r3 = r5.l
            int r3 = r3.p()
            goto L39
        L53:
            boolean r3 = r5.o
            if (r3 == 0) goto L65
            android.widget.TextView r3 = r5.p
            if (r3 == 0) goto L65
            android.content.res.ColorStateList r4 = r5.A0
            if (r4 == 0) goto L60
            goto L48
        L60:
            int r3 = r3.getCurrentTextColor()
            goto L39
        L65:
            if (r0 == 0) goto L6a
            int r3 = r5.z0
            goto L39
        L6a:
            if (r1 == 0) goto L6f
            int r3 = r5.y0
            goto L39
        L6f:
            int r3 = r5.x0
            goto L39
        L72:
            r5.u0()
            r5.V()
            r5.W()
            r5.U()
            o5.d r3 = r5.getEndIconDelegate()
            boolean r3 = r3.d()
            if (r3 == 0) goto L91
            o5.f r3 = r5.l
            boolean r3 = r3.l()
            r5.i0(r3)
        L91:
            int r3 = r5.M
            r4 = 2
            if (r3 != r4) goto Laf
            int r3 = r5.O
            if (r0 == 0) goto La5
            boolean r4 = r5.isEnabled()
            if (r4 == 0) goto La5
            int r4 = r5.Q
        La2:
            r5.O = r4
            goto La8
        La5:
            int r4 = r5.P
            goto La2
        La8:
            int r4 = r5.O
            if (r4 == r3) goto Laf
            r5.S()
        Laf:
            int r3 = r5.M
            if (r3 != r2) goto Lcd
            boolean r2 = r5.isEnabled()
            if (r2 != 0) goto Lbe
            int r0 = r5.C0
        Lbb:
            r5.S = r0
            goto Lcd
        Lbe:
            if (r1 == 0) goto Lc5
            if (r0 != 0) goto Lc5
            int r0 = r5.E0
            goto Lbb
        Lc5:
            if (r0 == 0) goto Lca
            int r0 = r5.D0
            goto Lbb
        Lca:
            int r0 = r5.B0
            goto Lbb
        Lcd:
            r5.l()
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.E0():void");
    }

    public final void F(boolean z) {
        ValueAnimator valueAnimator = this.K0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K0.cancel();
        }
        if (z && this.J0) {
            k(0.0f);
        } else {
            this.H0.d0(0.0f);
        }
        if (A() && ((o5.c) this.G).h0()) {
            x();
        }
        this.G0 = true;
        J();
        this.c.i(true);
        D0();
    }

    public final int G(int i, boolean z) {
        int compoundPaddingLeft = i + this.f.getCompoundPaddingLeft();
        return (getPrefixText() == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    public final int H(int i, boolean z) {
        int compoundPaddingRight = i - this.f.getCompoundPaddingRight();
        return (getPrefixText() == null || !z) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    public final boolean I() {
        return this.h0 != 0;
    }

    public final void J() {
        TextView textView = this.u;
        if (textView == null || !this.t) {
            return;
        }
        textView.setText((CharSequence) null);
        n.b(this.a, this.y);
        this.u.setVisibility(4);
    }

    public boolean K() {
        return this.e.getVisibility() == 0 && this.j0.getVisibility() == 0;
    }

    public final boolean L() {
        return this.s0.getVisibility() == 0;
    }

    public boolean M() {
        return this.l.A();
    }

    public final boolean N() {
        return this.G0;
    }

    public boolean O() {
        return this.F;
    }

    public final boolean P() {
        return this.M == 1 && this.f.getMinLines() <= 1;
    }

    public final void Q() {
        o();
        Z();
        E0();
        j0();
        j();
        if (this.M != 0) {
            v0();
        }
    }

    public final void R() {
        if (A()) {
            RectF rectF = this.V;
            this.H0.o(rectF, this.f.getWidth(), this.f.getGravity());
            n(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.O);
            ((o5.c) this.G).k0(rectF);
        }
    }

    public final void S() {
        if (!A() || this.G0) {
            return;
        }
        x();
        R();
    }

    public void U() {
        o5.e.c(this, this.j0, this.l0);
    }

    public void V() {
        o5.e.c(this, this.s0, this.t0);
    }

    public void W() {
        this.c.j();
    }

    public final void X() {
        TextView textView = this.u;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void Y(float f2, float f3, float f4, float f5) {
        boolean e2 = w.e(this);
        this.K = e2;
        float f6 = e2 ? f3 : f2;
        if (!e2) {
            f2 = f3;
        }
        float f7 = e2 ? f5 : f4;
        if (!e2) {
            f4 = f5;
        }
        l5.g gVar = this.G;
        if (gVar != null && gVar.E() == f6 && this.G.F() == f2 && this.G.s() == f7 && this.G.t() == f4) {
            return;
        }
        this.J = this.J.v().A(f6).E(f2).s(f7).w(f4).m();
        l();
    }

    public final void Z() {
        if (g0()) {
            L.w0(this.f, this.G);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.a.addView(view, layoutParams2);
        this.a.setLayoutParams(layoutParams);
        v0();
        setEditText((EditText) view);
    }

    public void d0(TextView textView, int i) {
        try {
            T.j.o(textView, i);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
            T.j.o(textView, k.a);
            textView.setTextColor(E.b.getColor(getContext(), R4.c.a));
        }
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.g != null) {
            boolean z = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.f.setHint(this.g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f.setHint(hint);
                this.F = z;
            }
        }
        o5.k.a(viewStructure, o5.j.a(this));
        l.a(this, viewStructure, i);
        m.a(this, viewStructure, i);
        o5.n.a(viewStructure, this.a.getChildCount());
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            EditText childAt = this.a.getChildAt(i2);
            ViewStructure a2 = o.a(viewStructure, i2);
            p.a(childAt, a2, i);
            if (childAt == this.f) {
                q.a(a2, getHint());
            }
        }
    }

    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.M0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.M0 = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    public void drawableStateChanged() {
        if (this.L0) {
            return;
        }
        this.L0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        f5.b bVar = this.H0;
        boolean g0 = bVar != null ? bVar.g0(drawableState) : false;
        if (this.f != null) {
            w0(L.W(this) && isEnabled());
        }
        r0();
        E0();
        if (g0) {
            invalidate();
        }
        this.L0 = false;
    }

    public final boolean e0() {
        return (this.s0.getVisibility() == 0 || ((I() && K()) || this.B != null)) && this.d.getMeasuredWidth() > 0;
    }

    public final boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.c.getMeasuredWidth() > 0;
    }

    public void g(f fVar) {
        this.g0.add(fVar);
        if (this.f != null) {
            fVar.a(this);
        }
    }

    public final boolean g0() {
        EditText editText = this.f;
        return (editText == null || this.G == null || editText.getBackground() != null || this.M == 0) ? false : true;
    }

    public int getBaseline() {
        EditText editText = this.f;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    public l5.g getBoxBackground() {
        int i = this.M;
        if (i == 1 || i == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.S;
    }

    public int getBoxBackgroundMode() {
        return this.M;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.N;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return (w.e(this) ? this.J.j() : this.J.l()).a(this.V);
    }

    public float getBoxCornerRadiusBottomStart() {
        return (w.e(this) ? this.J.l() : this.J.j()).a(this.V);
    }

    public float getBoxCornerRadiusTopEnd() {
        return (w.e(this) ? this.J.r() : this.J.t()).a(this.V);
    }

    public float getBoxCornerRadiusTopStart() {
        return (w.e(this) ? this.J.t() : this.J.r()).a(this.V);
    }

    public int getBoxStrokeColor() {
        return this.z0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.A0;
    }

    public int getBoxStrokeWidth() {
        return this.P;
    }

    public int getBoxStrokeWidthFocused() {
        return this.Q;
    }

    public int getCounterMaxLength() {
        return this.n;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.m && this.o && (textView = this.p) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.z;
    }

    public ColorStateList getCounterTextColor() {
        return this.z;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.v0;
    }

    public EditText getEditText() {
        return this.f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.j0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.j0.getDrawable();
    }

    public int getEndIconMode() {
        return this.h0;
    }

    public CheckableImageButton getEndIconView() {
        return this.j0;
    }

    public CharSequence getError() {
        if (this.l.z()) {
            return this.l.o();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.l.n();
    }

    public int getErrorCurrentTextColors() {
        return this.l.p();
    }

    public Drawable getErrorIconDrawable() {
        return this.s0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.l.p();
    }

    public CharSequence getHelperText() {
        if (this.l.A()) {
            return this.l.r();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.l.t();
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.H0.q();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.H0.t();
    }

    public ColorStateList getHintTextColor() {
        return this.w0;
    }

    public int getMaxEms() {
        return this.i;
    }

    public int getMaxWidth() {
        return this.k;
    }

    public int getMinEms() {
        return this.h;
    }

    public int getMinWidth() {
        return this.j;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.j0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.j0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.t) {
            return this.s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.v;
    }

    public CharSequence getPrefixText() {
        return this.c.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.c.b();
    }

    public TextView getPrefixTextView() {
        return this.c.c();
    }

    public CharSequence getStartIconContentDescription() {
        return this.c.d();
    }

    public Drawable getStartIconDrawable() {
        return this.c.e();
    }

    public CharSequence getSuffixText() {
        return this.B;
    }

    public ColorStateList getSuffixTextColor() {
        return this.C.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.C;
    }

    public Typeface getTypeface() {
        return this.W;
    }

    public void h(g gVar) {
        this.k0.add(gVar);
    }

    public final void h0() {
        if (this.u == null || !this.t || TextUtils.isEmpty(this.s)) {
            return;
        }
        this.u.setText(this.s);
        n.b(this.a, this.x);
        this.u.setVisibility(0);
        this.u.bringToFront();
        announceForAccessibility(this.s);
    }

    public final void i() {
        TextView textView = this.u;
        if (textView != null) {
            this.a.addView(textView);
            this.u.setVisibility(0);
        }
    }

    public final void i0(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            o5.e.a(this, this.j0, this.l0, this.m0);
            return;
        }
        Drawable mutate = H.a.r(getEndIconDrawable()).mutate();
        H.a.n(mutate, this.l.p());
        this.j0.setImageDrawable(mutate);
    }

    public final void j() {
        EditText editText;
        int J;
        int dimensionPixelSize;
        int I;
        Resources resources;
        int i;
        if (this.f == null || this.M != 1) {
            return;
        }
        if (i5.c.h(getContext())) {
            editText = this.f;
            J = L.J(editText);
            dimensionPixelSize = getResources().getDimensionPixelSize(R4.d.r);
            I = L.I(this.f);
            resources = getResources();
            i = R4.d.q;
        } else {
            if (!i5.c.g(getContext())) {
                return;
            }
            editText = this.f;
            J = L.J(editText);
            dimensionPixelSize = getResources().getDimensionPixelSize(R4.d.p);
            I = L.I(this.f);
            resources = getResources();
            i = R4.d.o;
        }
        L.F0(editText, J, dimensionPixelSize, I, resources.getDimensionPixelSize(i));
    }

    public final void j0() {
        Resources resources;
        int i;
        if (this.M == 1) {
            if (i5.c.h(getContext())) {
                resources = getResources();
                i = R4.d.t;
            } else {
                if (!i5.c.g(getContext())) {
                    return;
                }
                resources = getResources();
                i = R4.d.s;
            }
            this.N = resources.getDimensionPixelSize(i);
        }
    }

    public void k(float f2) {
        if (this.H0.x() == f2) {
            return;
        }
        if (this.K0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.K0 = valueAnimator;
            valueAnimator.setInterpolator(S4.a.b);
            this.K0.setDuration(167L);
            this.K0.addUpdateListener(new d());
        }
        this.K0.setFloatValues(new float[]{this.H0.x(), f2});
        this.K0.start();
    }

    public final void k0(Rect rect) {
        l5.g gVar = this.H;
        if (gVar != null) {
            int i = rect.bottom;
            gVar.setBounds(rect.left, i - this.P, rect.right, i);
        }
        l5.g gVar2 = this.I;
        if (gVar2 != null) {
            int i2 = rect.bottom;
            gVar2.setBounds(rect.left, i2 - this.Q, rect.right, i2);
        }
    }

    public final void l() {
        l5.g gVar = this.G;
        if (gVar == null) {
            return;
        }
        l5.k C = gVar.C();
        l5.k kVar = this.J;
        if (C != kVar) {
            this.G.setShapeAppearanceModel(kVar);
            p0();
        }
        if (v()) {
            this.G.a0(this.O, this.R);
        }
        int p = p();
        this.S = p;
        this.G.W(ColorStateList.valueOf(p));
        if (this.h0 == 3) {
            this.f.getBackground().invalidateSelf();
        }
        m();
        invalidate();
    }

    public final void l0() {
        if (this.p != null) {
            EditText editText = this.f;
            m0(editText == null ? 0 : editText.getText().length());
        }
    }

    public final void m() {
        if (this.H == null || this.I == null) {
            return;
        }
        if (w()) {
            this.H.W(ColorStateList.valueOf(this.f.isFocused() ? this.x0 : this.R));
            this.I.W(ColorStateList.valueOf(this.R));
        }
        invalidate();
    }

    public void m0(int i) {
        boolean z = this.o;
        int i2 = this.n;
        if (i2 == -1) {
            this.p.setText(String.valueOf(i));
            this.p.setContentDescription((CharSequence) null);
            this.o = false;
        } else {
            this.o = i > i2;
            n0(getContext(), this.p, i, this.n, this.o);
            if (z != this.o) {
                o0();
            }
            this.p.setText(N.a.c().j(getContext().getString(j.d, new Object[]{Integer.valueOf(i), Integer.valueOf(this.n)})));
        }
        if (this.f == null || z == this.o) {
            return;
        }
        w0(false);
        E0();
        r0();
    }

    public final void n(RectF rectF) {
        float f2 = rectF.left;
        int i = this.L;
        rectF.left = f2 - i;
        rectF.right += i;
    }

    public final void o() {
        int i = this.M;
        if (i == 0) {
            this.G = null;
        } else if (i == 1) {
            this.G = new l5.g(this.J);
            this.H = new l5.g();
            this.I = new l5.g();
            return;
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.M + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.G = (!this.D || (this.G instanceof o5.c)) ? new l5.g(this.J) : new o5.c(this.J);
        }
        this.H = null;
        this.I = null;
    }

    public final void o0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.p;
        if (textView != null) {
            d0(textView, this.o ? this.q : this.r);
            if (!this.o && (colorStateList2 = this.z) != null) {
                this.p.setTextColor(colorStateList2);
            }
            if (!this.o || (colorStateList = this.A) == null) {
                return;
            }
            this.p.setTextColor(colorStateList);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.H0.H(configuration);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.f;
        if (editText != null) {
            Rect rect = this.T;
            f5.c.a(this, editText, rect);
            k0(rect);
            if (this.D) {
                this.H0.b0(this.f.getTextSize());
                int gravity = this.f.getGravity();
                this.H0.S((gravity & (-113)) | 48);
                this.H0.a0(gravity);
                this.H0.O(q(rect));
                this.H0.W(t(rect));
                this.H0.K();
                if (!A() || this.G0) {
                    return;
                }
                R();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean s0 = s0();
        boolean q0 = q0();
        if (s0 || q0) {
            this.f.post(new c());
        }
        y0();
        C0();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.a());
        setError(hVar.d);
        if (hVar.e) {
            this.j0.post(new b());
        }
        setHint(hVar.f);
        setHelperText(hVar.g);
        setPlaceholderText(hVar.h);
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = false;
        boolean z2 = i == 1;
        boolean z3 = this.K;
        if (z2 != z3) {
            if (z2 && !z3) {
                z = true;
            }
            float a2 = this.J.r().a(this.V);
            float a3 = this.J.t().a(this.V);
            float a4 = this.J.j().a(this.V);
            float a5 = this.J.l().a(this.V);
            float f2 = z ? a2 : a3;
            if (z) {
                a2 = a3;
            }
            float f3 = z ? a4 : a5;
            if (z) {
                a4 = a5;
            }
            Y(f2, a2, f3, a4);
        }
    }

    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.l.l()) {
            hVar.d = getError();
        }
        hVar.e = I() && this.j0.isChecked();
        hVar.f = getHint();
        hVar.g = getHelperText();
        hVar.h = getPlaceholderText();
        return hVar;
    }

    public final int p() {
        return this.M == 1 ? Z4.a.g(Z4.a.e(this, R4.b.m, 0), this.S) : this.S;
    }

    public final void p0() {
        if (this.h0 == 3 && this.M == 2) {
            ((com.google.android.material.textfield.b) this.i0.get(3)).O((AutoCompleteTextView) this.f);
        }
    }

    public final Rect q(Rect rect) {
        int i;
        int i2;
        if (this.f == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.U;
        boolean e2 = w.e(this);
        rect2.bottom = rect.bottom;
        int i3 = this.M;
        if (i3 == 1) {
            rect2.left = G(rect.left, e2);
            i = rect.top + this.N;
        } else {
            if (i3 == 2) {
                rect2.left = rect.left + this.f.getPaddingLeft();
                rect2.top = rect.top - u();
                i2 = rect.right - this.f.getPaddingRight();
                rect2.right = i2;
                return rect2;
            }
            rect2.left = G(rect.left, e2);
            i = getPaddingTop();
        }
        rect2.top = i;
        i2 = H(rect.right, e2);
        rect2.right = i2;
        return rect2;
    }

    public boolean q0() {
        boolean z;
        Drawable drawable;
        EditText editText;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        if (this.f == null) {
            return false;
        }
        boolean z2 = true;
        if (f0()) {
            int measuredWidth = this.c.getMeasuredWidth() - this.f.getPaddingLeft();
            if (this.e0 == null || this.f0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.e0 = colorDrawable;
                this.f0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a2 = T.j.a(this.f);
            Drawable drawable5 = a2[0];
            Drawable drawable6 = this.e0;
            if (drawable5 != drawable6) {
                T.j.j(this.f, drawable6, a2[1], a2[2], a2[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.e0 != null) {
                Drawable[] a3 = T.j.a(this.f);
                T.j.j(this.f, (Drawable) null, a3[1], a3[2], a3[3]);
                this.e0 = null;
                z = true;
            }
            z = false;
        }
        if (e0()) {
            int measuredWidth2 = this.C.getMeasuredWidth() - this.f.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + s.b(endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] a4 = T.j.a(this.f);
            Drawable drawable7 = this.n0;
            if (drawable7 == null || this.o0 == measuredWidth2) {
                if (drawable7 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.n0 = colorDrawable2;
                    this.o0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable8 = a4[2];
                drawable = this.n0;
                if (drawable8 != drawable) {
                    this.p0 = drawable8;
                    editText = this.f;
                    drawable2 = a4[0];
                    drawable3 = a4[1];
                    drawable4 = a4[3];
                } else {
                    z2 = z;
                }
            } else {
                this.o0 = measuredWidth2;
                drawable7.setBounds(0, 0, measuredWidth2, 1);
                editText = this.f;
                drawable2 = a4[0];
                drawable3 = a4[1];
                drawable = this.n0;
                drawable4 = a4[3];
            }
            T.j.j(editText, drawable2, drawable3, drawable, drawable4);
        } else {
            if (this.n0 == null) {
                return z;
            }
            Drawable[] a5 = T.j.a(this.f);
            if (a5[2] == this.n0) {
                T.j.j(this.f, a5[0], a5[1], this.p0, a5[3]);
            } else {
                z2 = z;
            }
            this.n0 = null;
        }
        return z2;
    }

    public final int r(Rect rect, Rect rect2, float f2) {
        return P() ? (int) (rect2.top + f2) : rect.bottom - this.f.getCompoundPaddingBottom();
    }

    public void r0() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f;
        if (editText == null || this.M != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (M.a(background)) {
            background = background.mutate();
        }
        if (this.l.l()) {
            currentTextColor = this.l.p();
        } else {
            if (!this.o || (textView = this.p) == null) {
                H.a.c(background);
                this.f.refreshDrawableState();
                return;
            }
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(k.i.e(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    public final int s(Rect rect, float f2) {
        return P() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.f.getCompoundPaddingTop();
    }

    public final boolean s0() {
        int max;
        if (this.f == null || this.f.getMeasuredHeight() >= (max = Math.max(this.d.getMeasuredHeight(), this.c.getMeasuredHeight()))) {
            return false;
        }
        this.f.setMinimumHeight(max);
        return true;
    }

    public void setBoxBackgroundColor(int i) {
        if (this.S != i) {
            this.S = i;
            this.B0 = i;
            this.D0 = i;
            this.E0 = i;
            l();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(E.b.getColor(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.B0 = defaultColor;
        this.S = defaultColor;
        this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.D0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.E0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.M) {
            return;
        }
        this.M = i;
        if (this.f != null) {
            Q();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.N = i;
    }

    public void setBoxStrokeColor(int i) {
        if (this.z0 != i) {
            this.z0 = i;
            E0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (!colorStateList.isStateful()) {
            if (this.z0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            E0();
        } else {
            this.x0 = colorStateList.getDefaultColor();
            this.F0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.y0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        }
        this.z0 = defaultColor;
        E0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            E0();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.P = i;
        E0();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.Q = i;
        E0();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.m != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.p = appCompatTextView;
                appCompatTextView.setId(R4.f.K);
                Typeface typeface = this.W;
                if (typeface != null) {
                    this.p.setTypeface(typeface);
                }
                this.p.setMaxLines(1);
                this.l.e(this.p, 2);
                s.d(this.p.getLayoutParams(), getResources().getDimensionPixelOffset(R4.d.Z));
                o0();
                l0();
            } else {
                this.l.B(this.p, 2);
                this.p = null;
            }
            this.m = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.n != i) {
            if (i <= 0) {
                i = -1;
            }
            this.n = i;
            if (this.m) {
                l0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.q != i) {
            this.q = i;
            o0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            o0();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.r != i) {
            this.r = i;
            o0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            o0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.v0 = colorStateList;
        this.w0 = colorStateList;
        if (this.f != null) {
            w0(false);
        }
    }

    public void setEnabled(boolean z) {
        T(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.j0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.j0.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? e.a.b(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        int i2 = this.h0;
        if (i2 == i) {
            return;
        }
        this.h0 = i;
        C(i2);
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().b(this.M)) {
            getEndIconDelegate().a();
            o5.e.a(this, this.j0, this.l0, this.m0);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.M + " is not supported by the end icon mode " + i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        b0(this.j0, onClickListener, this.q0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.q0 = onLongClickListener;
        c0(this.j0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.l0 != colorStateList) {
            this.l0 = colorStateList;
            o5.e.a(this, this.j0, colorStateList, this.m0);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.m0 != mode) {
            this.m0 = mode;
            o5.e.a(this, this.j0, this.l0, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        if (K() != z) {
            this.j0.setVisibility(z ? 0 : 8);
            t0();
            C0();
            q0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.l.z()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.l.v();
        } else {
            this.l.O(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.l.D(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.l.E(z);
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? e.a.b(getContext(), i) : null);
        V();
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        b0(this.s0, onClickListener, this.r0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.r0 = onLongClickListener;
        c0(this.s0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.t0 != colorStateList) {
            this.t0 = colorStateList;
            o5.e.a(this, this.s0, colorStateList, this.u0);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.u0 != mode) {
            this.u0 = mode;
            o5.e.a(this, this.s0, this.t0, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        this.l.F(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.l.G(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.I0 != z) {
            this.I0 = z;
            w0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (M()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!M()) {
                setHelperTextEnabled(true);
            }
            this.l.P(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.l.J(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.l.I(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.l.H(i);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setHintAnimationEnabled(boolean z) {
        this.J0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.D) {
            this.D = z;
            if (z) {
                CharSequence hint = this.f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.f.setHint((CharSequence) null);
                }
                this.F = true;
            } else {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.f.getHint())) {
                    this.f.setHint(this.E);
                }
                setHintInternal(null);
            }
            if (this.f != null) {
                v0();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.H0.P(i);
        this.w0 = this.H0.p();
        if (this.f != null) {
            w0(false);
            v0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.w0 != colorStateList) {
            if (this.v0 == null) {
                this.H0.R(colorStateList);
            }
            this.w0 = colorStateList;
            if (this.f != null) {
                w0(false);
            }
        }
    }

    public void setMaxEms(int i) {
        this.i = i;
        EditText editText = this.f;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.k = i;
        EditText editText = this.f;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.h = i;
        EditText editText = this.f;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.j = i;
        EditText editText = this.f;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? e.a.b(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.h0 != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.l0 = colorStateList;
        o5.e.a(this, this.j0, colorStateList, this.m0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.m0 = mode;
        o5.e.a(this, this.j0, this.l0, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.u == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.u = appCompatTextView;
            appCompatTextView.setId(R4.f.N);
            L.C0(this.u, 2);
            K0.d z = z();
            this.x = z;
            z.a0(67L);
            this.y = z();
            setPlaceholderTextAppearance(this.w);
            setPlaceholderTextColor(this.v);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.t) {
                setPlaceholderTextEnabled(true);
            }
            this.s = charSequence;
        }
        z0();
    }

    public void setPlaceholderTextAppearance(int i) {
        this.w = i;
        TextView textView = this.u;
        if (textView != null) {
            T.j.o(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            TextView textView = this.u;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.c.k(charSequence);
    }

    public void setPrefixTextAppearance(int i) {
        this.c.l(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.c.m(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.c.n(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? e.a.b(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.c.q(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.c.r(onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.c.s(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.c.t(mode);
    }

    public void setStartIconVisible(boolean z) {
        this.c.u(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.B = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.C.setText(charSequence);
        D0();
    }

    public void setSuffixTextAppearance(int i) {
        T.j.o(this.C, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.C.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f;
        if (editText != null) {
            L.s0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.W) {
            this.W = typeface;
            this.H0.j0(typeface);
            this.l.L(typeface);
            TextView textView = this.p;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public final Rect t(Rect rect) {
        if (this.f == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.U;
        float w = this.H0.w();
        rect2.left = rect.left + this.f.getCompoundPaddingLeft();
        rect2.top = s(rect, w);
        rect2.right = rect.right - this.f.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, w);
        return rect2;
    }

    public final void t0() {
        this.e.setVisibility((this.j0.getVisibility() != 0 || L()) ? 8 : 0);
        this.d.setVisibility(K() || L() || ((this.B == null || N()) ? '\b' : (char) 0) == 0 ? 0 : 8);
    }

    public final int u() {
        float q;
        if (!this.D) {
            return 0;
        }
        int i = this.M;
        if (i == 0) {
            q = this.H0.q();
        } else {
            if (i != 2) {
                return 0;
            }
            q = this.H0.q() / 2.0f;
        }
        return (int) q;
    }

    public final void u0() {
        this.s0.setVisibility(getErrorIconDrawable() != null && this.l.z() && this.l.l() ? 0 : 8);
        t0();
        C0();
        if (I()) {
            return;
        }
        q0();
    }

    public final boolean v() {
        return this.M == 2 && w();
    }

    public final void v0() {
        if (this.M != 1) {
            LinearLayout.LayoutParams layoutParams = this.a.getLayoutParams();
            int u = u();
            if (u != layoutParams.topMargin) {
                layoutParams.topMargin = u;
                this.a.requestLayout();
            }
        }
    }

    public final boolean w() {
        return this.O > -1 && this.R != 0;
    }

    public void w0(boolean z) {
        x0(z, false);
    }

    public final void x() {
        if (A()) {
            ((o5.c) this.G).i0();
        }
    }

    public final void x0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        f5.b bVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f;
        boolean z3 = false;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f;
        if (editText2 != null && editText2.hasFocus()) {
            z3 = true;
        }
        boolean l = this.l.l();
        ColorStateList colorStateList2 = this.v0;
        if (colorStateList2 != null) {
            this.H0.R(colorStateList2);
            this.H0.Z(this.v0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.v0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.F0) : this.F0;
            this.H0.R(ColorStateList.valueOf(colorForState));
            this.H0.Z(ColorStateList.valueOf(colorForState));
        } else if (l) {
            this.H0.R(this.l.q());
        } else {
            if (this.o && (textView = this.p) != null) {
                bVar = this.H0;
                colorStateList = textView.getTextColors();
            } else if (z3 && (colorStateList = this.w0) != null) {
                bVar = this.H0;
            }
            bVar.R(colorStateList);
        }
        if (z4 || !this.I0 || (isEnabled() && z3)) {
            if (z2 || this.G0) {
                y(z);
                return;
            }
            return;
        }
        if (z2 || !this.G0) {
            F(z);
        }
    }

    public final void y(boolean z) {
        ValueAnimator valueAnimator = this.K0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K0.cancel();
        }
        if (z && this.J0) {
            k(1.0f);
        } else {
            this.H0.d0(1.0f);
        }
        this.G0 = false;
        if (A()) {
            R();
        }
        z0();
        this.c.i(false);
        D0();
    }

    public final void y0() {
        EditText editText;
        if (this.u == null || (editText = this.f) == null) {
            return;
        }
        this.u.setGravity(editText.getGravity());
        this.u.setPadding(this.f.getCompoundPaddingLeft(), this.f.getCompoundPaddingTop(), this.f.getCompoundPaddingRight(), this.f.getCompoundPaddingBottom());
    }

    public final K0.d z() {
        K0.d dVar = new K0.d();
        dVar.V(87L);
        dVar.X(S4.a.a);
        return dVar;
    }

    public final void z0() {
        EditText editText = this.f;
        A0(editText == null ? 0 : editText.getText().length());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v43 */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        ?? r4;
        int i4 = N0;
        super(p5.a.c(context, attributeSet, i, i4), attributeSet, i);
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = new o5.f(this);
        this.T = new Rect();
        this.U = new Rect();
        this.V = new RectF();
        this.g0 = new LinkedHashSet();
        this.h0 = 0;
        SparseArray sparseArray = new SparseArray();
        this.i0 = sparseArray;
        this.k0 = new LinkedHashSet();
        f5.b bVar = new f5.b(this);
        this.H0 = bVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.a = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.e = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.d = linearLayout;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.C = appCompatTextView;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        appCompatTextView.setVisibility(8);
        LayoutInflater from = LayoutInflater.from(context2);
        CheckableImageButton inflate = from.inflate(R4.h.d, linearLayout, false);
        this.s0 = inflate;
        CheckableImageButton inflate2 = from.inflate(R4.h.d, frameLayout2, false);
        this.j0 = inflate2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = S4.a.a;
        bVar.i0(timeInterpolator);
        bVar.f0(timeInterpolator);
        bVar.S(8388659);
        d0 i5 = u.i(context2, attributeSet, R4.l.b6, i, i4, R4.l.y6, R4.l.w6, R4.l.L6, R4.l.Q6, R4.l.U6);
        i iVar = new i(this, i5);
        this.c = iVar;
        this.D = i5.a(R4.l.T6, true);
        setHint(i5.p(R4.l.g6));
        this.J0 = i5.a(R4.l.S6, true);
        this.I0 = i5.a(R4.l.N6, true);
        if (i5.s(R4.l.i6)) {
            i2 = -1;
            setMinEms(i5.k(R4.l.i6, -1));
        } else {
            i2 = -1;
            if (i5.s(R4.l.f6)) {
                setMinWidth(i5.f(R4.l.f6, -1));
            }
        }
        if (i5.s(R4.l.h6)) {
            setMaxEms(i5.k(R4.l.h6, i2));
        } else if (i5.s(R4.l.e6)) {
            setMaxWidth(i5.f(R4.l.e6, i2));
        }
        this.J = l5.k.e(context2, attributeSet, i, i4).m();
        this.L = context2.getResources().getDimensionPixelOffset(R4.d.W);
        this.N = i5.e(R4.l.l6, 0);
        this.P = i5.f(R4.l.s6, context2.getResources().getDimensionPixelSize(R4.d.X));
        this.Q = i5.f(R4.l.t6, context2.getResources().getDimensionPixelSize(R4.d.Y));
        this.O = this.P;
        float d2 = i5.d(R4.l.p6, -1.0f);
        float d3 = i5.d(R4.l.o6, -1.0f);
        float d4 = i5.d(R4.l.m6, -1.0f);
        float d5 = i5.d(R4.l.n6, -1.0f);
        k.b v = this.J.v();
        if (d2 >= 0.0f) {
            v.A(d2);
        }
        if (d3 >= 0.0f) {
            v.E(d3);
        }
        if (d4 >= 0.0f) {
            v.w(d4);
        }
        if (d5 >= 0.0f) {
            v.s(d5);
        }
        this.J = v.m();
        ColorStateList b2 = i5.c.b(context2, i5, R4.l.j6);
        if (b2 != null) {
            int defaultColor = b2.getDefaultColor();
            this.B0 = defaultColor;
            this.S = defaultColor;
            if (b2.isStateful()) {
                this.C0 = b2.getColorForState(new int[]{-16842910}, -1);
                this.D0 = b2.getColorForState(new int[]{16842908, 16842910}, -1);
                i3 = b2.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                this.D0 = this.B0;
                ColorStateList a2 = e.a.a(context2, R4.c.g);
                this.C0 = a2.getColorForState(new int[]{-16842910}, -1);
                i3 = a2.getColorForState(new int[]{16843623}, -1);
            }
        } else {
            i3 = 0;
            this.S = 0;
            this.B0 = 0;
            this.C0 = 0;
            this.D0 = 0;
        }
        this.E0 = i3;
        if (i5.s(R4.l.d6)) {
            ColorStateList c2 = i5.c(R4.l.d6);
            this.w0 = c2;
            this.v0 = c2;
        }
        ColorStateList b3 = i5.c.b(context2, i5, R4.l.q6);
        this.z0 = i5.b(R4.l.q6, 0);
        this.x0 = E.b.getColor(context2, R4.c.h);
        this.F0 = E.b.getColor(context2, R4.c.i);
        this.y0 = E.b.getColor(context2, R4.c.j);
        if (b3 != null) {
            setBoxStrokeColorStateList(b3);
        }
        if (i5.s(R4.l.r6)) {
            setBoxStrokeErrorColor(i5.c.b(context2, i5, R4.l.r6));
        }
        if (i5.n(R4.l.U6, -1) != -1) {
            r4 = 0;
            setHintTextAppearance(i5.n(R4.l.U6, 0));
        } else {
            r4 = 0;
        }
        int n = i5.n(R4.l.L6, (int) r4);
        CharSequence p = i5.p(R4.l.G6);
        boolean a3 = i5.a(R4.l.H6, (boolean) r4);
        inflate.setId(R4.f.J);
        if (i5.c.g(context2)) {
            s.d(inflate.getLayoutParams(), (int) r4);
        }
        if (i5.s(R4.l.J6)) {
            this.t0 = i5.c.b(context2, i5, R4.l.J6);
        }
        if (i5.s(R4.l.K6)) {
            this.u0 = w.f(i5.k(R4.l.K6, -1), null);
        }
        if (i5.s(R4.l.I6)) {
            setErrorIconDrawable(i5.g(R4.l.I6));
        }
        inflate.setContentDescription(getResources().getText(j.f));
        L.C0(inflate, 2);
        inflate.setClickable(false);
        inflate.setPressable(false);
        inflate.setFocusable(false);
        int n2 = i5.n(R4.l.Q6, 0);
        boolean a4 = i5.a(R4.l.P6, false);
        CharSequence p2 = i5.p(R4.l.O6);
        int n3 = i5.n(R4.l.c7, 0);
        CharSequence p3 = i5.p(R4.l.b7);
        int n4 = i5.n(R4.l.n7, 0);
        CharSequence p4 = i5.p(R4.l.m7);
        boolean a5 = i5.a(R4.l.u6, false);
        setCounterMaxLength(i5.k(R4.l.v6, -1));
        this.r = i5.n(R4.l.y6, 0);
        this.q = i5.n(R4.l.w6, 0);
        setBoxBackgroundMode(i5.k(R4.l.k6, 0));
        if (i5.c.g(context2)) {
            s.d(inflate2.getLayoutParams(), 0);
        }
        int n5 = i5.n(R4.l.C6, 0);
        sparseArray.append(-1, new o5.a(this, n5));
        sparseArray.append(0, new o5.h(this));
        sparseArray.append(1, new com.google.android.material.textfield.c(this, n5 == 0 ? i5.n(R4.l.X6, 0) : n5));
        sparseArray.append(2, new com.google.android.material.textfield.a(this, n5));
        sparseArray.append(3, new com.google.android.material.textfield.b(this, n5));
        if (!i5.s(R4.l.Y6)) {
            if (i5.s(R4.l.E6)) {
                this.l0 = i5.c.b(context2, i5, R4.l.E6);
            }
            if (i5.s(R4.l.F6)) {
                this.m0 = w.f(i5.k(R4.l.F6, -1), null);
            }
        }
        if (i5.s(R4.l.D6)) {
            setEndIconMode(i5.k(R4.l.D6, 0));
            if (i5.s(R4.l.B6)) {
                setEndIconContentDescription(i5.p(R4.l.B6));
            }
            setEndIconCheckable(i5.a(R4.l.A6, true));
        } else if (i5.s(R4.l.Y6)) {
            if (i5.s(R4.l.Z6)) {
                this.l0 = i5.c.b(context2, i5, R4.l.Z6);
            }
            if (i5.s(R4.l.a7)) {
                this.m0 = w.f(i5.k(R4.l.a7, -1), null);
            }
            setEndIconMode(i5.a(R4.l.Y6, false) ? 1 : 0);
            setEndIconContentDescription(i5.p(R4.l.W6));
        }
        appCompatTextView.setId(R4.f.P);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        L.u0(appCompatTextView, 1);
        setErrorContentDescription(p);
        setCounterOverflowTextAppearance(this.q);
        setHelperTextTextAppearance(n2);
        setErrorTextAppearance(n);
        setCounterTextAppearance(this.r);
        setPlaceholderText(p3);
        setPlaceholderTextAppearance(n3);
        setSuffixTextAppearance(n4);
        if (i5.s(R4.l.M6)) {
            setErrorTextColor(i5.c(R4.l.M6));
        }
        if (i5.s(R4.l.R6)) {
            setHelperTextColor(i5.c(R4.l.R6));
        }
        if (i5.s(R4.l.V6)) {
            setHintTextColor(i5.c(R4.l.V6));
        }
        if (i5.s(R4.l.z6)) {
            setCounterTextColor(i5.c(R4.l.z6));
        }
        if (i5.s(R4.l.x6)) {
            setCounterOverflowTextColor(i5.c(R4.l.x6));
        }
        if (i5.s(R4.l.d7)) {
            setPlaceholderTextColor(i5.c(R4.l.d7));
        }
        if (i5.s(R4.l.o7)) {
            setSuffixTextColor(i5.c(R4.l.o7));
        }
        setEnabled(i5.a(R4.l.c6, true));
        i5.w();
        L.C0(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            L.D0(this, 1);
        }
        frameLayout2.addView(inflate2);
        linearLayout.addView(appCompatTextView);
        linearLayout.addView(inflate);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(iVar);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(a4);
        setErrorEnabled(a3);
        setCounterEnabled(a5);
        setHelperText(p2);
        setSuffixText(p4);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.j0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.j0.setImageDrawable(drawable);
        if (drawable != null) {
            o5.e.a(this, this.j0, this.l0, this.m0);
            U();
        }
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.s0.setImageDrawable(drawable);
        u0();
        o5.e.a(this, this.s0, this.t0, this.u0);
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.j0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.j0.setImageDrawable(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.c.o(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.c.p(drawable);
    }
}
