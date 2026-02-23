package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ProgressBar;
import t0.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class i {
    public static final int a = t0.c.g;

    public static Context a(Context context) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, l(context));
        int p = p(contextThemeWrapper, t0.a.h);
        return p != 0 ? new ContextThemeWrapper(contextThemeWrapper, p) : contextThemeWrapper;
    }

    public static Context b(Context context, int i, boolean z) {
        if (i == 0) {
            i = p(context, !z ? c.a.y : c.a.l);
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        return p(contextThemeWrapper, t0.a.h) != 0 ? new ContextThemeWrapper(contextThemeWrapper, l(contextThemeWrapper)) : contextThemeWrapper;
    }

    public static int c(Context context) {
        int p = p(context, t0.a.h);
        return p == 0 ? l(context) : p;
    }

    public static int d(Context context) {
        int o = o(context, 0, c.a.v);
        return G.a.d(o, o(context, 0, 16842801)) < 3.0d ? o(context, 0, c.a.q) : o;
    }

    public static Drawable e(Context context) {
        return j(context, t0.e.a);
    }

    public static int f(Context context, int i) {
        return G.a.d(-1, o(context, i, c.a.v)) >= 3.0d ? -1 : -570425344;
    }

    public static Drawable g(Context context) {
        return i(context, t0.a.b);
    }

    public static float h(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842803, typedValue, true)) {
            return typedValue.getFloat();
        }
        return 0.5f;
    }

    public static Drawable i(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        Drawable r = H.a.r(e.a.b(context, obtainStyledAttributes.getResourceId(0, 0)));
        if (r(context)) {
            H.a.n(r, E.b.getColor(context, a));
        }
        obtainStyledAttributes.recycle();
        return r;
    }

    public static Drawable j(Context context, int i) {
        Drawable r = H.a.r(e.a.b(context, i));
        if (r(context)) {
            H.a.n(r, E.b.getColor(context, a));
        }
        return r;
    }

    public static Drawable k(Context context) {
        return j(context, t0.e.b);
    }

    public static int l(Context context) {
        boolean r = r(context);
        int f = f(context, 0);
        return r ? f == -570425344 ? k.b : k.d : f == -570425344 ? k.c : k.a;
    }

    public static Drawable m(Context context) {
        return i(context, t0.a.f);
    }

    public static Drawable n(Context context) {
        return i(context, t0.a.e);
    }

    public static int o(Context context, int i, int i2) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            if (color != 0) {
                return color;
            }
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? context.getResources().getColor(typedValue.resourceId) : typedValue.data;
    }

    public static int p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    public static Drawable q(Context context) {
        return i(context, t0.a.i);
    }

    public static boolean r(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(c.a.D, typedValue, true) && typedValue.data != 0;
    }

    public static void s(Context context, Dialog dialog) {
        dialog.getWindow().getDecorView().setBackgroundColor(E.b.getColor(context, r(context) ? t0.c.f : t0.c.e));
    }

    public static void t(Context context, ProgressBar progressBar) {
        if (progressBar.isIndeterminate()) {
            progressBar.getIndeterminateDrawable().setColorFilter(E.b.getColor(context, r(context) ? t0.c.d : t0.c.c), PorterDuff.Mode.SRC_IN);
        }
    }

    public static void u(Context context, View view, View view2, boolean z) {
        int o = o(context, 0, c.a.v);
        int o2 = o(context, 0, c.a.w);
        if (z && f(context, 0) == -570425344) {
            o2 = o;
            o = -1;
        }
        view.setBackgroundColor(o);
        view2.setBackgroundColor(o2);
        view.setTag(Integer.valueOf(o));
        view2.setTag(Integer.valueOf(o2));
    }

    public static void v(Context context, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
        int color;
        int i;
        if (r(context)) {
            color = E.b.getColor(context, t0.c.d);
            i = t0.c.b;
        } else {
            color = E.b.getColor(context, t0.c.c);
            i = t0.c.a;
        }
        mediaRouteVolumeSlider.b(color, E.b.getColor(context, i));
    }

    public static void w(Context context, MediaRouteVolumeSlider mediaRouteVolumeSlider, View view) {
        int f = f(context, 0);
        if (Color.alpha(f) != 255) {
            f = G.a.j(f, ((Integer) view.getTag()).intValue());
        }
        mediaRouteVolumeSlider.a(f);
    }
}
