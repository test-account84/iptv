package k;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static j0 l;
    public static j0 m;
    public final View a;
    public final CharSequence c;
    public final int d;
    public final Runnable e = new h0(this);
    public final Runnable f = new i0(this);
    public int g;
    public int h;
    public k0 i;
    public boolean j;
    public boolean k;

    public j0(View view, CharSequence charSequence) {
        this.a = view;
        this.c = charSequence;
        this.d = P.N.c(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static /* synthetic */ void a(j0 j0Var) {
        j0Var.e();
    }

    public static void g(j0 j0Var) {
        j0 j0Var2 = l;
        if (j0Var2 != null) {
            j0Var2.b();
        }
        l = j0Var;
        if (j0Var != null) {
            j0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        j0 j0Var = l;
        if (j0Var != null && j0Var.a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new j0(view, charSequence);
            return;
        }
        j0 j0Var2 = m;
        if (j0Var2 != null && j0Var2.a == view) {
            j0Var2.d();
        }
        view.setOnLongClickListener((View.OnLongClickListener) null);
        view.setLongClickable(false);
        view.setOnHoverListener((View.OnHoverListener) null);
    }

    public final void b() {
        this.a.removeCallbacks(this.e);
    }

    public final void c() {
        this.k = true;
    }

    public void d() {
        if (m == this) {
            m = null;
            k0 k0Var = this.i;
            if (k0Var != null) {
                k0Var.c();
                this.i = null;
                c();
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (l == this) {
            g(null);
        }
        this.a.removeCallbacks(this.f);
    }

    public final /* synthetic */ void e() {
        i(false);
    }

    public final void f() {
        this.a.postDelayed(this.e, ViewConfiguration.getLongPressTimeout());
    }

    public void i(boolean z) {
        long longPressTimeout;
        long j;
        long j2;
        if (P.L.V(this.a)) {
            g(null);
            j0 j0Var = m;
            if (j0Var != null) {
                j0Var.d();
            }
            m = this;
            this.j = z;
            k0 k0Var = new k0(this.a.getContext());
            this.i = k0Var;
            k0Var.e(this.a, this.g, this.h, this.j, this.c);
            this.a.addOnAttachStateChangeListener(this);
            if (this.j) {
                j2 = 2500;
            } else {
                if ((P.L.O(this.a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            this.a.removeCallbacks(this.f);
            this.a.postDelayed(this.f, j2);
        }
    }

    public final boolean j(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (!this.k && Math.abs(x - this.g) <= this.d && Math.abs(y - this.h) <= this.d) {
            return false;
        }
        this.g = x;
        this.h = y;
        this.k = false;
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.i != null && this.j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.a.isEnabled() && this.i == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.g = view.getWidth() / 2;
        this.h = view.getHeight() / 2;
        i(true);
        return true;
    }

    public void onViewDetachedFromWindow(View view) {
        d();
    }

    public void onViewAttachedToWindow(View view) {
    }
}
