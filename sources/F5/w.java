package f5;

import P.E;
import P.L;
import P.X;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class w {

    public class a implements Runnable {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        public void run() {
            ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 1);
        }
    }

    public class b implements E {
        public final /* synthetic */ d a;
        public final /* synthetic */ e b;

        public b(d dVar, e eVar) {
            this.a = dVar;
            this.b = eVar;
        }

        public X a(View view, X x) {
            return this.a.a(view, x, new e(this.b));
        }
    }

    public interface d {
        X a(View view, X x, e eVar);
    }

    public static class e {
        public int a;
        public int b;
        public int c;
        public int d;

        public e(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public e(e eVar) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
        }
    }

    public static void a(View view, d dVar) {
        L.E0(view, new b(dVar, new e(L.J(view), view.getPaddingTop(), L.I(view), view.getPaddingBottom())));
        g(view);
    }

    public static float b(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static Integer c(View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(view.getBackground().getColor());
        }
        return null;
    }

    public static float d(View view) {
        float f = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f += L.y((View) parent);
        }
        return f;
    }

    public static boolean e(View view) {
        return L.E(view) == 1;
    }

    public static PorterDuff.Mode f(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void g(View view) {
        if (L.V(view)) {
            L.p0(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void h(View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    public class c implements View.OnAttachStateChangeListener {
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            L.p0(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }
}
