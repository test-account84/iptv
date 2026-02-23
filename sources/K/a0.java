package k;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a0 extends ContextWrapper {
    public static final Object c = new Object();
    public static ArrayList d;
    public final Resources a;
    public final Resources.Theme b;

    public a0(Context context) {
        super(context);
        if (!l0.c()) {
            this.a = new c0(this, context.getResources());
            this.b = null;
            return;
        }
        l0 l0Var = new l0(this, context.getResources());
        this.a = l0Var;
        Resources.Theme newTheme = l0Var.newTheme();
        this.b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        if ((context instanceof a0) || (context.getResources() instanceof c0) || (context.getResources() instanceof l0)) {
            return false;
        }
        return l0.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (c) {
            try {
                ArrayList arrayList = d;
                if (arrayList == null) {
                    d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            d.remove(size);
                        }
                    }
                    for (int size2 = d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) d.get(size2);
                        a0 a0Var = weakReference2 != null ? (a0) weakReference2.get() : null;
                        if (a0Var != null && a0Var.getBaseContext() == context) {
                            return a0Var;
                        }
                    }
                }
                a0 a0Var2 = new a0(context);
                d.add(new WeakReference(a0Var2));
                return a0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    public Resources getResources() {
        return this.a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
