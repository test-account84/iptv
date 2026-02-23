package k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends Button implements T.m {
    public final d a;
    public final A c;
    public l d;

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.n);
    }

    private l getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new l(this);
        }
        return this.d;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.a;
        if (dVar != null) {
            dVar.b();
        }
        A a = this.c;
        if (a != null) {
            a.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (m0.b) {
            return super.getAutoSizeMaxTextSize();
        }
        A a = this.c;
        if (a != null) {
            return a.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (m0.b) {
            return super.getAutoSizeMinTextSize();
        }
        A a = this.c;
        if (a != null) {
            return a.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (m0.b) {
            return super.getAutoSizeStepGranularity();
        }
        A a = this.c;
        if (a != null) {
            return a.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (m0.b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        A a = this.c;
        return a != null ? a.h() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (m0.b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        A a = this.c;
        if (a != null) {
            return a.i();
        }
        return 0;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return T.j.q(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.a;
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

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        A a = this.c;
        if (a != null) {
            a.o(z, i, i2, i3, i4);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        A a = this.c;
        if (a == null || m0.b || !a.l()) {
            return;
        }
        this.c.c();
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (m0.b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        A a = this.c;
        if (a != null) {
            a.t(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (m0.b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        A a = this.c;
        if (a != null) {
            a.u(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (m0.b) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        A a = this.c;
        if (a != null) {
            a.v(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        d dVar = this.a;
        if (dVar != null) {
            dVar.g(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(T.j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        A a = this.c;
        if (a != null) {
            a.s(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.a;
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
        A a = this.c;
        if (a != null) {
            a.q(context, i);
        }
    }

    public void setTextSize(int i, float f) {
        if (m0.b) {
            super.setTextSize(i, f);
            return;
        }
        A a = this.c;
        if (a != null) {
            a.A(i, f);
        }
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(a0.b(context), attributeSet, i);
        Z.a(this, getContext());
        d dVar = new d(this);
        this.a = dVar;
        dVar.e(attributeSet, i);
        A a = new A(this);
        this.c = a;
        a.m(attributeSet, i);
        a.b();
        getEmojiTextViewHelper().c(attributeSet, i);
    }
}
