package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillValue;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GuidedActionEditText extends EditText {
    public final Drawable a;
    public final Drawable c;

    public static final class a extends Drawable {
        public void draw(Canvas canvas) {
        }

        public int getOpacity() {
            return -2;
        }

        public boolean getPadding(Rect rect) {
            rect.set(0, 0, 0, 0);
            return true;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public GuidedActionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public void autofill(AutofillValue autofillValue) {
        super.autofill(autofillValue);
    }

    public int getAutofillType() {
        return 1;
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        setBackground(z ? this.a : this.c);
        if (z) {
            return;
        }
        setFocusable(false);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((isFocused() ? EditText.class : TextView.class).getName());
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(T.j.r(this, callback));
    }

    public void setImeKeyListener(p pVar) {
    }

    public void setOnAutofillListener(n nVar) {
    }

    public GuidedActionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = getBackground();
        a aVar = new a();
        this.c = aVar;
        setBackground(aVar);
    }
}
