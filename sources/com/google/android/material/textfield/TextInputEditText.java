package com.google.android.material.textfield;

import R4.k;
import R4.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import f5.g;
import f5.u;
import k.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class TextInputEditText extends j {
    public final Rect h;
    public boolean i;

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.n);
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final String e(TextInputLayout textInputLayout) {
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean z = !TextUtils.isEmpty(text);
        String str = "";
        String charSequence = TextUtils.isEmpty(hint) ^ true ? hint.toString() : "";
        if (!z) {
            return !TextUtils.isEmpty(charSequence) ? charSequence : "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        if (!TextUtils.isEmpty(charSequence)) {
            str = ", " + charSequence;
        }
        sb.append(str);
        return sb.toString();
    }

    public final boolean f(TextInputLayout textInputLayout) {
        return textInputLayout != null && this.i;
    }

    public void getFocusedRect(Rect rect) {
        super/*android.widget.EditText*/.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!f(textInputLayout) || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.h);
        rect.bottom = this.h.bottom;
    }

    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        return f(textInputLayout) ? textInputLayout.getGlobalVisibleRect(rect, point) : super/*android.widget.EditText*/.getGlobalVisibleRect(rect, point);
    }

    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.O()) ? super/*android.widget.EditText*/.getHint() : textInputLayout.getHint();
    }

    public void onAttachedToWindow() {
        super/*android.widget.EditText*/.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.O() && super/*android.widget.EditText*/.getHint() == null && g.a()) {
            setHint("");
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super/*android.widget.EditText*/.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
            return;
        }
        accessibilityNodeInfo.setText(e(textInputLayout));
    }

    public boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!f(textInputLayout) || rect == null) {
            return super/*android.widget.EditText*/.requestRectangleOnScreen(rect);
        }
        this.h.set(rect.left, rect.top, rect.right, rect.bottom + (textInputLayout.getHeight() - getHeight()));
        return super/*android.widget.EditText*/.requestRectangleOnScreen(this.h);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.i = z;
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(p5.a.c(context, attributeSet, i, 0), attributeSet, i);
        this.h = new Rect();
        TypedArray h = u.h(context, attributeSet, l.Z5, i, k.i, new int[0]);
        setTextInputLayoutFocusedRectEnabled(h.getBoolean(l.a6, false));
        h.recycle();
    }
}
