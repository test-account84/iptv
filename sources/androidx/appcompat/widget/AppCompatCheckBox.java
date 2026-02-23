package androidx.appcompat.widget;

import T.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import k.A;
import k.Z;
import k.a0;
import k.h;
import k.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppCompatCheckBox extends CheckBox implements m {
    public final h a;
    public final k.d c;
    public final A d;
    public l e;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.o);
    }

    private l getEmojiTextViewHelper() {
        if (this.e == null) {
            this.e = new l(this);
        }
        return this.e;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        k.d dVar = this.c;
        if (dVar != null) {
            dVar.b();
        }
        A a = this.d;
        if (a != null) {
            a.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        h hVar = this.a;
        return hVar != null ? hVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        k.d dVar = this.c;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        k.d dVar = this.c;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        h hVar = this.a;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        h hVar = this.a;
        if (hVar != null) {
            return hVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.d.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.d.k();
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        k.d dVar = this.c;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        k.d dVar = this.c;
        if (dVar != null) {
            dVar.g(i);
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(e.a.b(getContext(), i));
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        A a = this.d;
        if (a != null) {
            a.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        A a = this.d;
        if (a != null) {
            a.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        k.d dVar = this.c;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        k.d dVar = this.c;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.h(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.d.w(colorStateList);
        this.d.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.d.x(mode);
        this.d.b();
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(a0.b(context), attributeSet, i);
        Z.a(this, getContext());
        h hVar = new h(this);
        this.a = hVar;
        hVar.e(attributeSet, i);
        k.d dVar = new k.d(this);
        this.c = dVar;
        dVar.e(attributeSet, i);
        A a = new A(this);
        this.d = a;
        a.m(attributeSet, i);
        getEmojiTextViewHelper().c(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        h hVar = this.a;
        if (hVar != null) {
            hVar.f();
        }
    }
}
