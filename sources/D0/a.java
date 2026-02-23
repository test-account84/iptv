package d0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public final b a;
    public int b = Integer.MAX_VALUE;
    public int c = 0;

    public static class a extends b {
        public final EditText a;
        public final g b;

        public a(EditText editText, boolean z) {
            this.a = editText;
            g gVar = new g(editText, z);
            this.b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(d0.b.getInstance());
        }

        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.a, inputConnection, editorInfo);
        }

        public void c(boolean z) {
            this.b.c(z);
        }
    }

    public static class b {
        public abstract KeyListener a(KeyListener keyListener);

        public abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        public abstract void c(boolean z);
    }

    public a(EditText editText, boolean z) {
        O.h.g(editText, "editText cannot be null");
        this.a = new a(editText, z);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.a.b(inputConnection, editorInfo);
    }

    public void c(boolean z) {
        this.a.c(z);
    }
}
