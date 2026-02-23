package mbanje.kurt.fabbutton;

import M8.b;
import M8.c;
import M8.d;
import M8.e;
import M8.f;
import P.L;
import P.T;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;
import mbanje.kurt.fabbutton.CircleImageView;

@CoordinatorLayout.d(Behavior.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class FabButton extends FrameLayout implements CircleImageView.b {
    public CircleImageView a;
    public ProgressRingView c;
    public float d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;

    public static class Behavior extends CoordinatorLayout.c {
        public Rect a;
        public boolean b;
        public float c;

        public class a implements T {
            public a() {
            }

            public void a(View view) {
                Behavior.E(Behavior.this, false);
            }

            public void b(View view) {
                Behavior.E(Behavior.this, false);
                view.setVisibility(8);
            }

            public void c(View view) {
                Behavior.E(Behavior.this, true);
            }
        }

        public static /* synthetic */ boolean E(Behavior behavior, boolean z) {
            behavior.b = z;
            return z;
        }

        public final void F(FabButton fabButton) {
            fabButton.setVisibility(0);
            L.e(fabButton).f(1.0f).g(1.0f).b(1.0f).i(M8.a.b).p().j((T) null).n();
        }

        public final void G(FabButton fabButton) {
            L.e(fabButton).f(0.0f).g(0.0f).b(0.0f).i(M8.a.b).p().j(new a()).n();
        }

        public final float H(CoordinatorLayout coordinatorLayout, FabButton fabButton) {
            List s = coordinatorLayout.s(fabButton);
            int size = s.size();
            float f = 0.0f;
            for (int i = 0; i < size; i++) {
                View view = (View) s.get(i);
                if ((view instanceof Snackbar.SnackbarLayout) && coordinatorLayout.g(fabButton, view)) {
                    f = Math.min(f, L.N(view) - view.getHeight());
                }
            }
            return f;
        }

        public final int I(AppBarLayout appBarLayout) {
            int F = L.F(appBarLayout);
            if (F != 0) {
                return F * 2;
            }
            int childCount = appBarLayout.getChildCount();
            if (childCount >= 1) {
                return L.F(appBarLayout.getChildAt(childCount - 1)) * 2;
            }
            return 0;
        }

        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public boolean e(CoordinatorLayout coordinatorLayout, FabButton fabButton, View view) {
            return view instanceof Snackbar.SnackbarLayout;
        }

        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FabButton fabButton, View view) {
            if (view instanceof Snackbar.SnackbarLayout) {
                L(coordinatorLayout, fabButton, view);
                return false;
            }
            if (!(view instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            f.a(coordinatorLayout, view, rect);
            if (rect.bottom > I(appBarLayout)) {
                if (fabButton.getVisibility() == 0) {
                    return false;
                }
                F(fabButton);
                return false;
            }
            if (this.b || fabButton.getVisibility() != 0) {
                return false;
            }
            G(fabButton);
            return false;
        }

        public final void L(CoordinatorLayout coordinatorLayout, FabButton fabButton, View view) {
            float H = H(coordinatorLayout, fabButton);
            if (H != this.c) {
                L.e(fabButton).c();
                if (Math.abs(H - this.c) == view.getHeight()) {
                    L.e(fabButton).o(H).i(M8.a.b).j((T) null);
                } else {
                    L.M0(fabButton, H);
                }
                this.c = H;
            }
        }
    }

    public FabButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.14f;
        c(context, attributeSet, 0);
    }

    public void a() {
        this.a.h(this.h, this.i);
        if (this.i) {
            this.c.setVisibility(8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.c.setVisibility(0);
            this.c.e();
        } else {
            this.c.f(true);
            this.c.setVisibility(8);
        }
    }

    public void c(Context context, AttributeSet attributeSet, int i) {
        int i2;
        float f;
        int i3;
        View inflate = View.inflate(context, d.a, this);
        setClipChildren(false);
        this.a = inflate.findViewById(c.a);
        this.c = (ProgressRingView) inflate.findViewById(c.b);
        this.a.setFabViewListener(this);
        this.c.setFabViewListener(this);
        int i4 = -16777216;
        int i5 = 4000;
        float f2 = 0.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a);
            int color = obtainStyledAttributes.getColor(e.j, -16777216);
            int color2 = obtainStyledAttributes.getColor(e.n, -16777216);
            f2 = obtainStyledAttributes.getFloat(e.d, 0.0f);
            f = obtainStyledAttributes.getFloat(e.c, 100.0f);
            this.e = obtainStyledAttributes.getBoolean(e.e, false);
            this.f = obtainStyledAttributes.getBoolean(e.k, true);
            i5 = obtainStyledAttributes.getInteger(e.f, 4000);
            i3 = obtainStyledAttributes.getResourceId(e.b, -1);
            this.d = obtainStyledAttributes.getFloat(e.o, this.d);
            this.g = obtainStyledAttributes.getResourceId(e.l, b.a);
            this.h = obtainStyledAttributes.getBoolean(e.p, false);
            this.i = obtainStyledAttributes.getBoolean(e.m, false);
            this.a.setShowShadow(obtainStyledAttributes.getBoolean(e.q, true));
            obtainStyledAttributes.recycle();
            i2 = color2;
            i4 = color;
        } else {
            i2 = -16777216;
            f = 0.0f;
            i3 = -1;
        }
        this.a.setColor(i4);
        this.a.setShowEndBitmap(this.h);
        this.a.setRingWidthRatio(this.d);
        this.c.setProgressColor(i2);
        this.c.setProgress(f2);
        this.c.setMaxProgress(f);
        this.c.setAutostartanim(this.f);
        this.c.setAnimDuration(i5);
        this.c.setRingWidthRatio(this.d);
        this.c.setIndeterminate(this.e);
        if (i3 != -1) {
            this.a.f(i3, this.g);
        }
    }

    public void d(boolean z) {
        this.a.i(z);
    }

    public void e(boolean z) {
        this.a.setShowShadow(z);
        invalidate();
    }

    public void setColor(int i) {
        this.a.setColor(i);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.a.setEnabled(z);
        this.c.setEnabled(z);
    }

    public void setIndeterminate(boolean z) {
        this.e = z;
        this.c.setIndeterminate(z);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
        this.a.setOnClickListener(onClickListener);
    }

    public void setProgress(float f) {
        this.c.setProgress(f);
    }

    public void setProgressColor(int i) {
        this.c.setProgressColor(i);
    }

    public void setShadow(boolean z) {
        this.a.setShowShadow(z);
    }
}
