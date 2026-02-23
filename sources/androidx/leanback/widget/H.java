package androidx.leanback.widget;

import android.animation.TimeAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h {

    public static class a implements g {
        public int a;
        public final boolean b;

        public a(int i, boolean z) {
            if (!h.b(i)) {
                throw new IllegalArgumentException("Unhandled zoom index");
            }
            this.a = i;
            this.b = z;
        }

        public void a(View view, boolean z) {
            view.setSelected(z);
            c(view).a(z, false);
        }

        public void b(View view) {
            c(view).a(false, true);
        }

        public final b c(View view) {
            b bVar = (b) view.getTag(g0.f.k);
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b(view, d(view.getResources()), this.b, 150);
            view.setTag(g0.f.k, bVar2);
            return bVar2;
        }

        public final float d(Resources resources) {
            int i = this.a;
            if (i == 0) {
                return 1.0f;
            }
            return resources.getFraction(h.a(i), 1, 1);
        }
    }

    public static class b implements TimeAnimator.TimeListener {
        public final View a;
        public final int b;
        public final P c;
        public final float d;
        public float e = 0.0f;
        public float f;
        public float g;
        public final TimeAnimator h;
        public final Interpolator i;
        public final h0.a j;

        public b(View view, float f, boolean z, int i) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.h = timeAnimator;
            this.i = new AccelerateDecelerateInterpolator();
            this.a = view;
            this.b = i;
            this.d = f - 1.0f;
            if (view instanceof P) {
                this.c = (P) view;
            } else {
                this.c = null;
            }
            timeAnimator.setTimeListener(this);
            if (z) {
                this.j = h0.a.a(view.getContext());
            } else {
                this.j = null;
            }
        }

        public void a(boolean z, boolean z2) {
            b();
            float f = z ? 1.0f : 0.0f;
            if (z2) {
                c(f);
                return;
            }
            float f2 = this.e;
            if (f2 != f) {
                this.f = f2;
                this.g = f - f2;
                this.h.start();
            }
        }

        public void b() {
            this.h.end();
        }

        public void c(float f) {
            this.e = f;
            float f2 = (this.d * f) + 1.0f;
            this.a.setScaleX(f2);
            this.a.setScaleY(f2);
            P p = this.c;
            if (p != null) {
                p.setShadowFocusLevel(f);
            } else {
                Q.i(this.a, f);
            }
            h0.a aVar = this.j;
            if (aVar != null) {
                aVar.c(f);
                int color = this.j.b().getColor();
                P p2 = this.c;
                if (p2 != null) {
                    p2.setOverlayColor(color);
                } else {
                    Q.h(this.a, color);
                }
            }
        }

        public void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
            float f;
            int i = this.b;
            if (j >= i) {
                this.h.end();
                f = 1.0f;
            } else {
                f = (float) (j / i);
            }
            Interpolator interpolator = this.i;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            c(this.f + (f * this.g));
        }
    }

    public static int a(int i) {
        if (i == 1) {
            return g0.e.d;
        }
        if (i == 2) {
            return g0.e.c;
        }
        if (i == 3) {
            return g0.e.b;
        }
        if (i != 4) {
            return 0;
        }
        return g0.e.e;
    }

    public static boolean b(int i) {
        return i == 0 || a(i) > 0;
    }

    public static void c(t tVar, int i, boolean z) {
        tVar.x0(new a(i, z));
    }
}
