package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j extends EditText implements P.G, T.m {
    public final d a;
    public final A c;
    public final z d;
    public final T.l e;
    public final k f;
    public a g;

    public class a {
        public a() {
        }

        public TextClassifier a() {
            return j.b(j.this);
        }

        public void b(TextClassifier textClassifier) {
            j.c(j.this, textClassifier);
        }
    }

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.B);
    }

    public static /* synthetic */ TextClassifier b(j jVar) {
        return super.getTextClassifier();
    }

    public static /* synthetic */ void c(j jVar, TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    private a getSuperCaller() {
        if (this.g == null) {
            this.g = new a();
        }
        return this.g;
    }

    public P.d a(P.d dVar) {
        return this.e.a(this, dVar);
    }

    public void d(k kVar) {
        KeyListener keyListener = getKeyListener();
        if (kVar.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a2 = kVar.a(keyListener);
            if (a2 == keyListener) {
                return;
            }
            super.setKeyListener(a2);
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
        A a2 = this.c;
        if (a2 != null) {
            a2.b();
        }
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

    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    public TextClassifier getTextClassifier() {
        z zVar;
        return (Build.VERSION.SDK_INT >= 28 || (zVar = this.d) == null) ? getSuperCaller().a() : zVar.a();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] H;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.c.r(this, onCreateInputConnection, editorInfo);
        InputConnection a2 = m.a(onCreateInputConnection, editorInfo, this);
        if (a2 != null && Build.VERSION.SDK_INT <= 30 && (H = P.L.H(this)) != null) {
            S.c.d(editorInfo, H);
            a2 = S.f.c(this, a2, editorInfo);
        }
        return this.f.d(a2, editorInfo);
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (t.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public boolean onTextContextMenuItem(int i) {
        if (t.b(this, i)) {
            return true;
        }
        return super.onTextContextMenuItem(i);
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(T.j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f.e(z);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f.a(keyListener));
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
        A a2 = this.c;
        if (a2 != null) {
            a2.q(context, i);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.d) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            zVar.b(textClassifier);
        }
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(a0.b(context), attributeSet, i);
        Z.a(this, getContext());
        d dVar = new d(this);
        this.a = dVar;
        dVar.e(attributeSet, i);
        A a2 = new A(this);
        this.c = a2;
        a2.m(attributeSet, i);
        a2.b();
        this.d = new z(this);
        this.e = new T.l();
        k kVar = new k(this);
        this.f = kVar;
        kVar.c(attributeSet, i);
        d(kVar);
    }
}
