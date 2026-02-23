package androidx.appcompat.widget;

import G.f;
import N.m;
import T.j;
import T.m;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import d.D;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import k.A;
import k.Z;
import k.a0;
import k.l;
import k.m0;
import k.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppCompatTextView extends TextView implements m {
    public final k.d a;
    public final A c;
    public final z d;
    public l e;
    public boolean f;
    public a g;
    public Future h;

    public interface a {
        void a(int[] iArr, int i);

        void b(int i);

        int c();

        int d();

        int[] e();

        TextClassifier f();

        int g();

        void h(TextClassifier textClassifier);

        void i(int i, int i2, int i3, int i4);

        void j(int i);

        int k();

        void l(int i);
    }

    public class b implements a {
        public b() {
        }

        public void a(int[] iArr, int i) {
            AppCompatTextView.n(AppCompatTextView.this, iArr, i);
        }

        public void b(int i) {
        }

        public int c() {
            return AppCompatTextView.k(AppCompatTextView.this);
        }

        public int d() {
            return AppCompatTextView.g(AppCompatTextView.this);
        }

        public int[] e() {
            return AppCompatTextView.j(AppCompatTextView.this);
        }

        public TextClassifier f() {
            return AppCompatTextView.l(AppCompatTextView.this);
        }

        public int g() {
            return AppCompatTextView.d(AppCompatTextView.this);
        }

        public void h(TextClassifier textClassifier) {
            AppCompatTextView.p(AppCompatTextView.this, textClassifier);
        }

        public void i(int i, int i2, int i3, int i4) {
            AppCompatTextView.m(AppCompatTextView.this, i, i2, i3, i4);
        }

        public void j(int i) {
        }

        public int k() {
            return AppCompatTextView.i(AppCompatTextView.this);
        }

        public void l(int i) {
            AppCompatTextView.o(AppCompatTextView.this, i);
        }
    }

    public class c extends b {
        public c() {
            super();
        }

        public void b(int i) {
            AppCompatTextView.h(AppCompatTextView.this, i);
        }

        public void j(int i) {
            AppCompatTextView.f(AppCompatTextView.this, i);
        }
    }

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int d(AppCompatTextView appCompatTextView) {
        return super.getAutoSizeMaxTextSize();
    }

    public static /* synthetic */ void f(AppCompatTextView appCompatTextView, int i) {
        super.setFirstBaselineToTopHeight(i);
    }

    public static /* synthetic */ int g(AppCompatTextView appCompatTextView) {
        return super.getAutoSizeMinTextSize();
    }

    private l getEmojiTextViewHelper() {
        if (this.e == null) {
            this.e = new l(this);
        }
        return this.e;
    }

    public static /* synthetic */ void h(AppCompatTextView appCompatTextView, int i) {
        super.setLastBaselineToBottomHeight(i);
    }

    public static /* synthetic */ int i(AppCompatTextView appCompatTextView) {
        return super.getAutoSizeStepGranularity();
    }

    public static /* synthetic */ int[] j(AppCompatTextView appCompatTextView) {
        return super.getAutoSizeTextAvailableSizes();
    }

    public static /* synthetic */ int k(AppCompatTextView appCompatTextView) {
        return super.getAutoSizeTextType();
    }

    public static /* synthetic */ TextClassifier l(AppCompatTextView appCompatTextView) {
        return super.getTextClassifier();
    }

    public static /* synthetic */ void m(AppCompatTextView appCompatTextView, int i, int i2, int i3, int i4) {
        super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    public static /* synthetic */ void n(AppCompatTextView appCompatTextView, int[] iArr, int i) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    public static /* synthetic */ void o(AppCompatTextView appCompatTextView, int i) {
        super.setAutoSizeTextTypeWithDefaults(i);
    }

    public static /* synthetic */ void p(AppCompatTextView appCompatTextView, TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.b();
        }
        A a2 = this.c;
        if (a2 != null) {
            a2.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (m0.b) {
            return getSuperCaller().g();
        }
        A a2 = this.c;
        if (a2 != null) {
            return a2.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (m0.b) {
            return getSuperCaller().d();
        }
        A a2 = this.c;
        if (a2 != null) {
            return a2.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (m0.b) {
            return getSuperCaller().k();
        }
        A a2 = this.c;
        if (a2 != null) {
            return a2.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (m0.b) {
            return getSuperCaller().e();
        }
        A a2 = this.c;
        return a2 != null ? a2.h() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (m0.b) {
            return getSuperCaller().c() == 1 ? 1 : 0;
        }
        A a2 = this.c;
        if (a2 != null) {
            return a2.i();
        }
        return 0;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return j.q(super.getCustomSelectionActionModeCallback());
    }

    public int getFirstBaselineToTopHeight() {
        return j.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return j.c(this);
    }

    public a getSuperCaller() {
        a bVar;
        if (this.g == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                bVar = new c();
            } else if (i >= 26) {
                bVar = new b();
            }
            this.g = bVar;
        }
        return this.g;
    }

    public ColorStateList getSupportBackgroundTintList() {
        k.d dVar = this.a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        k.d dVar = this.a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.k();
    }

    public CharSequence getText() {
        q();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        z zVar;
        return (Build.VERSION.SDK_INT >= 28 || (zVar = this.d) == null) ? getSuperCaller().f() : zVar.a();
    }

    public m.a getTextMetricsParamsCompat() {
        return j.g(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.c.r(this, onCreateInputConnection, editorInfo);
        return k.m.a(onCreateInputConnection, editorInfo, this);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        A a2 = this.c;
        if (a2 != null) {
            a2.o(z, i, i2, i3, i4);
        }
    }

    public void onMeasure(int i, int i2) {
        q();
        super.onMeasure(i, i2);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        A a2 = this.c;
        if (a2 == null || m0.b || !a2.l()) {
            return;
        }
        this.c.c();
    }

    public final void q() {
        Future future = this.h;
        if (future != null) {
            try {
                this.h = null;
                D.a(future.get());
                j.n(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (m0.b) {
            getSuperCaller().i(i, i2, i3, i4);
            return;
        }
        A a2 = this.c;
        if (a2 != null) {
            a2.t(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (m0.b) {
            getSuperCaller().a(iArr, i);
            return;
        }
        A a2 = this.c;
        if (a2 != null) {
            a2.u(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (m0.b) {
            getSuperCaller().l(i);
            return;
        }
        A a2 = this.c;
        if (a2 != null) {
            a2.v(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.g(i);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        A a2 = this.c;
        if (a2 != null) {
            a2.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        A a2 = this.c;
        if (a2 != null) {
            a2.p();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? e.a.b(context, i) : null, i2 != 0 ? e.a.b(context, i2) : null, i3 != 0 ? e.a.b(context, i3) : null, i4 != 0 ? e.a.b(context, i4) : null);
        A a2 = this.c;
        if (a2 != null) {
            a2.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? e.a.b(context, i) : null, i2 != 0 ? e.a.b(context, i2) : null, i3 != 0 ? e.a.b(context, i3) : null, i4 != 0 ? e.a.b(context, i4) : null);
        A a2 = this.c;
        if (a2 != null) {
            a2.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i);
        } else {
            j.k(this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i);
        } else {
            j.l(this, i);
        }
    }

    public void setLineHeight(int i) {
        j.m(this, i);
    }

    public void setPrecomputedText(N.m mVar) {
        j.n(this, mVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.c.w(colorStateList);
        this.c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.c.x(mode);
        this.c.b();
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.c;
        if (a2 != null) {
            a2.q(context, i);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.d) == null) {
            getSuperCaller().h(textClassifier);
        } else {
            zVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future future) {
        this.h = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(m.a aVar) {
        j.p(this, aVar);
    }

    public void setTextSize(int i, float f) {
        if (m0.b) {
            super.setTextSize(i, f);
            return;
        }
        A a2 = this.c;
        if (a2 != null) {
            a2.A(i, f);
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        if (this.f) {
            return;
        }
        Typeface a2 = (typeface == null || i <= 0) ? null : f.a(getContext(), typeface, i);
        this.f = true;
        if (a2 != null) {
            typeface = a2;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        A a2 = this.c;
        if (a2 != null) {
            a2.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        A a2 = this.c;
        if (a2 != null) {
            a2.p();
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(a0.b(context), attributeSet, i);
        this.f = false;
        this.g = null;
        Z.a(this, getContext());
        k.d dVar = new k.d(this);
        this.a = dVar;
        dVar.e(attributeSet, i);
        A a2 = new A(this);
        this.c = a2;
        a2.m(attributeSet, i);
        a2.b();
        this.d = new z(this);
        getEmojiTextViewHelper().c(attributeSet, i);
    }
}
