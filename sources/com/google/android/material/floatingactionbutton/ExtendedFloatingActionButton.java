package com.google.android.material.floatingactionbutton;

import P.L;
import R4.k;
import R4.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import d.D;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    public static final int u = k.r;
    public static final Property v = new a(Float.class, "width");
    public static final Property w = new b(Float.class, "height");
    public static final Property x = new c(Float.class, "paddingStart");
    public static final Property y = new d(Float.class, "paddingEnd");

    public static class ExtendedFloatingActionButtonBehavior extends CoordinatorLayout.c {
        public Rect a;
        public boolean b;
        public boolean c;

        public ExtendedFloatingActionButtonBehavior() {
            this.b = false;
            this.c = true;
        }

        public static boolean G(View view) {
            CoordinatorLayout.f layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return layoutParams.f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (this.c) {
                ExtendedFloatingActionButton.m(extendedFloatingActionButton);
            } else {
                ExtendedFloatingActionButton.n(extendedFloatingActionButton);
            }
            ExtendedFloatingActionButton.l(extendedFloatingActionButton, null, null);
        }

        public boolean F(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean H(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!G(view)) {
                return false;
            }
            M(view, extendedFloatingActionButton);
            return false;
        }

        public boolean I(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List s = coordinatorLayout.s(extendedFloatingActionButton);
            int size = s.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) s.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.J(extendedFloatingActionButton, i);
            return true;
        }

        public final boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            throw null;
        }

        public void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (this.c) {
                ExtendedFloatingActionButton.j(extendedFloatingActionButton);
            } else {
                ExtendedFloatingActionButton.k(extendedFloatingActionButton);
            }
            ExtendedFloatingActionButton.l(extendedFloatingActionButton, null, null);
        }

        public final boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            f5.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        public final boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (J(view, extendedFloatingActionButton)) {
                throw null;
            }
            return false;
        }

        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            D.a(view);
            return F(coordinatorLayout, null, rect);
        }

        public void g(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            D.a(view);
            return H(coordinatorLayout, null, view2);
        }

        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            D.a(view);
            return I(coordinatorLayout, null, i);
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.L1);
            this.b = obtainStyledAttributes.getBoolean(l.M1, false);
            this.c = obtainStyledAttributes.getBoolean(l.N1, true);
            obtainStyledAttributes.recycle();
        }
    }

    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            view.getLayoutParams().width = f.intValue();
            view.requestLayout();
        }
    }

    public class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            view.getLayoutParams().height = f.intValue();
            view.requestLayout();
        }
    }

    public class c extends Property {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(L.J(view));
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            L.F0(view, f.intValue(), view.getPaddingTop(), L.I(view), view.getPaddingBottom());
        }
    }

    public class d extends Property {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(L.I(view));
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            L.F0(view, L.J(view), view.getPaddingTop(), f.intValue(), view.getPaddingBottom());
        }
    }

    public static abstract class e {
    }

    public static /* synthetic */ com.google.android.material.floatingactionbutton.b j(ExtendedFloatingActionButton extendedFloatingActionButton) {
        throw null;
    }

    public static /* synthetic */ com.google.android.material.floatingactionbutton.b k(ExtendedFloatingActionButton extendedFloatingActionButton) {
        throw null;
    }

    public static /* synthetic */ void l(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.b bVar, e eVar) {
        throw null;
    }

    public static /* synthetic */ com.google.android.material.floatingactionbutton.b m(ExtendedFloatingActionButton extendedFloatingActionButton) {
        throw null;
    }

    public static /* synthetic */ com.google.android.material.floatingactionbutton.b n(ExtendedFloatingActionButton extendedFloatingActionButton) {
        throw null;
    }
}
