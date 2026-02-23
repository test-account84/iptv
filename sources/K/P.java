package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class p extends MultiAutoCompleteTextView implements T.m {
    public static final int[] e = {16843126};
    public final d a;
    public final A c;
    public final k d;

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.m);
    }

    public void a(k kVar) {
        KeyListener keyListener = getKeyListener();
        if (kVar.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a = kVar.a(keyListener);
            if (a == keyListener) {
                return;
            }
            super.setKeyListener(a);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
            super.setClickable(isClickable);
            super.setLongClickable(isLongClickable);
        }
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

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.d.d(m.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
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

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        A a = this.c;
        if (a != null) {
            a.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        A a = this.c;
        if (a != null) {
            a.p();
        }
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(e.a.b(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.d.e(z);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.d.a(keyListener));
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

    public p(Context context, AttributeSet attributeSet, int i) {
        super(a0.b(context), attributeSet, i);
        Z.a(this, getContext());
        d0 v = d0.v(getContext(), attributeSet, e, i, 0);
        if (v.s(0)) {
            setDropDownBackgroundDrawable(v.g(0));
        }
        v.w();
        d dVar = new d(this);
        this.a = dVar;
        dVar.e(attributeSet, i);
        A a = new A(this);
        this.c = a;
        a.m(attributeSet, i);
        a.b();
        k kVar = new k(this);
        this.d = kVar;
        kVar.c(attributeSet, i);
        a(kVar);
    }
}
