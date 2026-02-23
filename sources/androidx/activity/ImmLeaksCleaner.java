package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import java.lang.reflect.Field;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.n {
    public static int c;
    public static Field d;
    public static Field e;
    public static Field f;
    public Activity a;

    public ImmLeaksCleaner(Activity activity) {
        this.a = activity;
    }

    public static void c() {
        try {
            c = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            e = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            d = declaredField3;
            declaredField3.setAccessible(true);
            c = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    public void b(p pVar, j.b bVar) {
        if (bVar != j.b.ON_DESTROY) {
            return;
        }
        if (c == 0) {
            c();
        }
        if (c == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
            try {
                Object obj = d.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) e.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f.set(inputMethodManager, (Object) null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
