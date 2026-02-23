package d0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class g implements TextWatcher {
    public final EditText a;
    public final boolean c;
    public e.e d;
    public int e = Integer.MAX_VALUE;
    public int f = 0;
    public boolean g = true;

    public static class a extends e.e {
        public final Reference a;

        public a(EditText editText) {
            this.a = new WeakReference(editText);
        }

        public void b() {
            super.b();
            g.b((EditText) this.a.get(), 1);
        }
    }

    public g(EditText editText, boolean z) {
        this.a = editText;
        this.c = z;
    }

    public static void b(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            CharSequence editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.e.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final e.e a() {
        if (this.d == null) {
            this.d = new a(this.a);
        }
        return this.d;
    }

    public void c(boolean z) {
        if (this.g != z) {
            if (this.d != null) {
                androidx.emoji2.text.e.b().t(this.d);
            }
            this.g = z;
            if (z) {
                b(this.a, androidx.emoji2.text.e.b().d());
            }
        }
    }

    public final boolean d() {
        return (this.g && (this.c || androidx.emoji2.text.e.h())) ? false : true;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.a.isInEditMode() || d() || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int d = androidx.emoji2.text.e.b().d();
        if (d != 0) {
            if (d == 1) {
                androidx.emoji2.text.e.b().r((Spannable) charSequence, i, i + i3, this.e, this.f);
                return;
            } else if (d != 3) {
                return;
            }
        }
        androidx.emoji2.text.e.b().s(a());
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
