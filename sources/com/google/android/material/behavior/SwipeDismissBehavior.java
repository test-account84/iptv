package com.google.android.material.behavior;

import P.L;
import Q.C;
import Q.F;
import W.d;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class SwipeDismissBehavior extends CoordinatorLayout.c {
    public d a;
    public boolean b;
    public boolean d;
    public float c = 0.0f;
    public int e = 2;
    public float f = 0.5f;
    public float g = 0.0f;
    public float h = 0.5f;
    public final d.c i = new a();

    public class a extends d.c {
        public int a;
        public int b = -1;

        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = P.L.E(r3)
                r0 = 1
                if (r5 != r0) goto L9
                r5 = 1
                goto La
            L9:
                r5 = 0
            La:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.e
                if (r1 != 0) goto L24
                if (r5 == 0) goto L1c
            L12:
                int r5 = r2.a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.a
                goto L37
            L1c:
                int r5 = r2.a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L37
            L24:
                if (r1 != r0) goto L29
                if (r5 == 0) goto L12
                goto L1c
            L29:
                int r5 = r2.a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L37:
                int r3 = com.google.android.material.behavior.SwipeDismissBehavior.G(r5, r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int, int):int");
        }

        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        public int d(View view) {
            return view.getWidth();
        }

        public void i(View view, int i) {
            this.b = i;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void j(int i) {
            SwipeDismissBehavior.this.getClass();
        }

        public void k(View view, int i, int i2, int i3, int i4) {
            float width = this.a + (view.getWidth() * SwipeDismissBehavior.this.g);
            float width2 = this.a + (view.getWidth() * SwipeDismissBehavior.this.h);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f), 1.0f));
            }
        }

        public void l(View view, float f, float f2) {
            int i;
            boolean z;
            this.b = -1;
            int width = view.getWidth();
            if (n(view, f)) {
                int left = view.getLeft();
                int i2 = this.a;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.a;
                z = false;
            }
            if (SwipeDismissBehavior.this.a.F(i, view.getTop())) {
                L.k0(view, SwipeDismissBehavior.this.new c(view, z));
            } else if (z) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        public boolean m(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.E(view);
        }

        public final boolean n(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f);
            }
            boolean z = L.E(view) == 1;
            int i = SwipeDismissBehavior.this.e;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }
    }

    public class b implements F {
        public b() {
        }

        public boolean a(View view, F.a aVar) {
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean z = L.E(view) == 1;
            int i = SwipeDismissBehavior.this.e;
            L.c0(view, (!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            SwipeDismissBehavior.this.getClass();
            return true;
        }
    }

    public class c implements Runnable {
        public final View a;
        public final boolean c;

        public c(View view, boolean z) {
            this.a = view;
            this.c = z;
        }

        public void run() {
            d dVar = SwipeDismissBehavior.this.a;
            if (dVar != null && dVar.k(true)) {
                L.k0(this.a, this);
            } else if (this.c) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    public static float F(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public static int G(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public static float I(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        d dVar = this.a;
        if (dVar == null) {
            return false;
        }
        dVar.z(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public final void H(ViewGroup viewGroup) {
        if (this.a == null) {
            this.a = this.d ? d.l(viewGroup, this.c, this.i) : d.m(viewGroup, this.i);
        }
    }

    public void J(float f) {
        this.h = F(0.0f, f, 1.0f);
    }

    public void K(float f) {
        this.g = F(0.0f, f, 1.0f);
    }

    public void L(int i) {
        this.e = i;
    }

    public final void M(View view) {
        L.m0(view, 1048576);
        if (E(view)) {
            L.o0(view, C.a.y, (CharSequence) null, new b());
        }
    }

    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z = this.b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.C(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.b = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.b = false;
        }
        if (!z) {
            return false;
        }
        H(coordinatorLayout);
        return this.a.G(motionEvent);
    }

    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        boolean l = super.l(coordinatorLayout, view, i);
        if (L.C(view) == 0) {
            L.C0(view, 1);
            M(view);
        }
        return l;
    }
}
