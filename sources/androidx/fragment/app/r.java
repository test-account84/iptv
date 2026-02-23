package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class r extends N0.a {
    public final m c;
    public final int d;
    public w e;
    public Fragment f;
    public boolean g;

    public r(m mVar) {
        this(mVar, 0);
    }

    public static String r(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.e == null) {
            this.e = this.c.m();
        }
        this.e.m(fragment);
        if (fragment.equals(this.f)) {
            this.f = null;
        }
    }

    public void b(ViewGroup viewGroup) {
        w wVar = this.e;
        if (wVar != null) {
            if (!this.g) {
                try {
                    this.g = true;
                    wVar.l();
                } finally {
                    this.g = false;
                }
            }
            this.e = null;
        }
    }

    public Object g(ViewGroup viewGroup, int i) {
        if (this.e == null) {
            this.e = this.c.m();
        }
        long q = q(i);
        Fragment h0 = this.c.h0(r(viewGroup.getId(), q));
        if (h0 != null) {
            this.e.h(h0);
        } else {
            h0 = p(i);
            this.e.c(viewGroup.getId(), h0, r(viewGroup.getId(), q));
        }
        if (h0 != this.f) {
            h0.setMenuVisibility(false);
            if (this.d == 1) {
                this.e.u(h0, j.c.STARTED);
            } else {
                h0.setUserVisibleHint(false);
            }
        }
        return h0;
    }

    public boolean h(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void j(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable k() {
        return null;
    }

    public void l(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.d == 1) {
                    if (this.e == null) {
                        this.e = this.c.m();
                    }
                    this.e.u(this.f, j.c.STARTED);
                } else {
                    this.f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.d == 1) {
                if (this.e == null) {
                    this.e = this.c.m();
                }
                this.e.u(fragment, j.c.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f = fragment;
        }
    }

    public void n(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract Fragment p(int i);

    public long q(int i) {
        return i;
    }

    public r(m mVar, int i) {
        this.e = null;
        this.f = null;
        this.c = mVar;
        this.d = i;
    }
}
