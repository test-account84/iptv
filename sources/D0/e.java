package d0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e implements KeyListener {
    public final KeyListener a;
    public final a b;

    public static class a {
        public boolean a(Editable editable, int i, KeyEvent keyEvent) {
            return androidx.emoji2.text.e.f(editable, i, keyEvent);
        }
    }

    public e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    public void clearMetaKeyState(View view, Editable editable, int i) {
        this.a.clearMetaKeyState(view, editable, i);
    }

    public int getInputType() {
        return this.a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.b.a(editable, i, keyEvent) || this.a.onKeyDown(view, editable, i, keyEvent);
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.a.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.a.onKeyUp(view, editable, i, keyEvent);
    }

    public e(KeyListener keyListener, a aVar) {
        this.a = keyListener;
        this.b = aVar;
    }
}
