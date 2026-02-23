package d0;

import android.text.Editable;
import androidx.emoji2.text.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile Editable.Factory b;
    public static Class c;

    public b() {
        try {
            c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (b == null) {
            synchronized (a) {
                try {
                    if (b == null) {
                        b = new b();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? n.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
