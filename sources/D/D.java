package d;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar;
import d.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d {
    public static z.a a = new z.a(new z.b());
    public static int c = -100;
    public static L.i d = null;
    public static L.i e = null;
    public static Boolean f = null;
    public static boolean g = false;
    public static final s.b h = new s.b();
    public static final Object i = new Object();
    public static final Object j = new Object();

    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public static void E(d dVar) {
        synchronized (i) {
            F(dVar);
        }
    }

    public static void F(d dVar) {
        synchronized (i) {
            try {
                Iterator it = h.iterator();
                while (it.hasNext()) {
                    d dVar2 = (d) ((WeakReference) it.next()).get();
                    if (dVar2 == dVar || dVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void O(Context context) {
        if (u(context)) {
            if (L.a.d()) {
                if (g) {
                    return;
                }
                a.execute(new c(context));
                return;
            }
            synchronized (j) {
                try {
                    L.i iVar = d;
                    if (iVar == null) {
                        if (e == null) {
                            e = L.i.c(z.b(context));
                        }
                        if (e.f()) {
                        } else {
                            d = e;
                        }
                    } else if (!iVar.equals(e)) {
                        L.i iVar2 = d;
                        e = iVar2;
                        z.a(context, iVar2.h());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static /* synthetic */ void c(Context context) {
        v(context);
    }

    public static void d(d dVar) {
        synchronized (i) {
            F(dVar);
            h.add(new WeakReference(dVar));
        }
    }

    public static d h(Activity activity, d.b bVar) {
        return new e(activity, bVar);
    }

    public static d i(Dialog dialog, d.b bVar) {
        return new e(dialog, bVar);
    }

    public static L.i k() {
        if (L.a.d()) {
            Object o = o();
            if (o != null) {
                return L.i.i(b.a(o));
            }
        } else {
            L.i iVar = d;
            if (iVar != null) {
                return iVar;
            }
        }
        return L.i.e();
    }

    public static int m() {
        return c;
    }

    public static Object o() {
        Context l;
        Iterator it = h.iterator();
        while (it.hasNext()) {
            d dVar = (d) ((WeakReference) it.next()).get();
            if (dVar != null && (l = dVar.l()) != null) {
                return l.getSystemService("locale");
            }
        }
        return null;
    }

    public static L.i q() {
        return d;
    }

    public static boolean u(Context context) {
        if (f == null) {
            try {
                Bundle bundle = x.a(context).metaData;
                if (bundle != null) {
                    f = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f = Boolean.FALSE;
            }
        }
        return f.booleanValue();
    }

    public static /* synthetic */ void v(Context context) {
        z.c(context);
        g = true;
    }

    public abstract void A();

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D();

    public abstract boolean G(int i2);

    public abstract void H(int i2);

    public abstract void I(View view);

    public abstract void J(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void L(Toolbar toolbar);

    public abstract void M(int i2);

    public abstract void N(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract View j(int i2);

    public abstract Context l();

    public abstract int n();

    public abstract MenuInflater p();

    public abstract d.a r();

    public abstract void s();

    public abstract void t();

    public abstract void w(Configuration configuration);

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z(Bundle bundle);

    public void K(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public void f(Context context) {
    }
}
