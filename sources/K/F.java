package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends CheckedTextView implements T.m {
    public final g a;
    public final d c;
    public final A d;
    public l e;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.p);
    }

    private l getEmojiTextViewHelper() {
        if (this.e == null) {
            this.e = new l(this);
        }
        return this.e;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        A a = this.d;
        if (a != null) {
            a.b();
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.b();
        }
        g gVar = this.a;
        if (gVar != null) {
            gVar.a();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return T.j.q(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.c;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.c;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.d.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.d.k();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return m.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.c;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        d dVar = this.c;
        if (dVar != null) {
            dVar.g(i);
        }
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(e.a.b(getContext(), i));
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(T.j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.g(mode);
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

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a = this.d;
        if (a != null) {
            a.q(context, i);
        }
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(a0.b(context), attributeSet, i);
        Z.a(this, getContext());
        A a = new A(this);
        this.d = a;
        a.m(attributeSet, i);
        a.b();
        d dVar = new d(this);
        this.c = dVar;
        dVar.e(attributeSet, i);
        g gVar = new g(this);
        this.a = gVar;
        gVar.d(attributeSet, i);
        getEmojiTextViewHelper().c(attributeSet, i);
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        g gVar = this.a;
        if (gVar != null) {
            gVar.e();
        }
    }
}
