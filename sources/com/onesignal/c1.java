package com.onesignal;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.onesignal.a;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class C1 {
    public static final int a = b(24);

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Runnable c;

        public class a extends a.b {
            public final /* synthetic */ com.onesignal.a a;

            public a(com.onesignal.a aVar) {
                this.a = aVar;
            }

            public void a(Activity activity) {
                this.a.r(a.this.a);
                if (C1.k(activity)) {
                    a.this.c.run();
                } else {
                    C1.a(activity, a.this.c);
                }
            }
        }

        public a(String str, Runnable runnable) {
            this.a = str;
            this.c = runnable;
        }

        public void run() {
            com.onesignal.a b = b.b();
            if (b != null) {
                b.c(this.a, new a(b));
            }
        }
    }

    public static void a(Activity activity, Runnable runnable) {
        activity.getWindow().getDecorView().post(new a("decorViewReady:" + runnable, runnable));
    }

    public static int b(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int[] c(Activity activity) {
        float f;
        float f2;
        DisplayCutout a2;
        Rect i = i(activity);
        View findViewById = activity.getWindow().findViewById(16908290);
        float top = (i.top - findViewById.getTop()) / Resources.getSystem().getDisplayMetrics().density;
        float bottom = (findViewById.getBottom() - i.bottom) / Resources.getSystem().getDisplayMetrics().density;
        if (Build.VERSION.SDK_INT != 29 || (a2 = z1.a(activity.getWindowManager().getDefaultDisplay())) == null) {
            f = 0.0f;
            f2 = 0.0f;
        } else {
            f = A1.a(a2) / Resources.getSystem().getDisplayMetrics().density;
            f2 = B1.a(a2) / Resources.getSystem().getDisplayMetrics().density;
        }
        return new int[]{Math.round(top), Math.round(bottom), Math.round(f), Math.round(f2)};
    }

    public static int d(Activity activity) {
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int e(Activity activity) {
        return Build.VERSION.SDK_INT >= 23 ? activity.getWindow().getDecorView().getWidth() : j(activity);
    }

    public static int f(Activity activity) {
        return Build.VERSION.SDK_INT >= 23 ? g(activity) : h(activity);
    }

    public static int g(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        WindowInsets a2 = y1.a(decorView);
        int height = decorView.getHeight();
        return a2 == null ? height : (height - a2.getStableInsetBottom()) - a2.getStableInsetTop();
    }

    public static int h(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 2 ? i(activity).height() : d(activity);
    }

    public static Rect i(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    public static int j(Activity activity) {
        return i(activity).width();
    }

    public static boolean k(Activity activity) {
        boolean z = activity.getWindow().getDecorView().getApplicationWindowToken() != null;
        if (Build.VERSION.SDK_INT < 23) {
            return z;
        }
        return z && (y1.a(activity.getWindow().getDecorView()) != null);
    }

    public static boolean l(WeakReference weakReference) {
        View view;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Rect rect = new Rect();
        if (weakReference.get() != null) {
            Window window = ((Activity) weakReference.get()).getWindow();
            view = window.getDecorView();
            view.getWindowVisibleDisplayFrame(rect);
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            view = null;
        }
        return view != null && displayMetrics.heightPixels - rect.bottom > a;
    }
}
