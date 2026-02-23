package d0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d implements InputFilter {
    public final TextView a;
    public e.e b;

    public static class a extends e.e {
        public final Reference a;
        public final Reference b;

        public a(TextView textView, d dVar) {
            this.a = new WeakReference(textView);
            this.b = new WeakReference(dVar);
        }

        public void b() {
            Spannable text;
            Spannable o;
            super.b();
            TextView textView = (TextView) this.a.get();
            if (c(textView, (InputFilter) this.b.get()) && textView.isAttachedToWindow() && text != (o = androidx.emoji2.text.e.b().o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(o);
                int selectionEnd = Selection.getSelectionEnd(o);
                textView.setText(o);
                if (o instanceof Spannable) {
                    d.b(o, selectionStart, selectionEnd);
                }
            }
        }

        public final boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(TextView textView) {
        this.a = textView;
    }

    public static void b(Spannable spannable, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            Selection.setSelection(spannable, i, i2);
        } else if (i >= 0) {
            Selection.setSelection(spannable, i);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        }
    }

    public final e.e a() {
        if (this.b == null) {
            this.b = new a(this.a, this);
        }
        return this.b;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.a.isInEditMode()) {
            return charSequence;
        }
        int d = androidx.emoji2.text.e.b().d();
        if (d != 0) {
            if (d == 1) {
                if ((i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == this.a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i2 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return androidx.emoji2.text.e.b().p(charSequence, 0, charSequence.length());
            }
            if (d != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.e.b().s(a());
        return charSequence;
    }
}
