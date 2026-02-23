package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class u extends N0.a {
    public final m c;
    public final int d;
    public w e;
    public ArrayList f;
    public ArrayList g;
    public Fragment h;
    public boolean i;

    public u(m mVar) {
        this(mVar, 0);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.e == null) {
            this.e = this.c.m();
        }
        while (this.f.size() <= i) {
            this.f.add((Object) null);
        }
        this.f.set(i, fragment.isAdded() ? this.c.m1(fragment) : null);
        this.g.set(i, (Object) null);
        this.e.p(fragment);
        if (fragment.equals(this.h)) {
            this.h = null;
        }
    }

    public void b(ViewGroup viewGroup) {
        w wVar = this.e;
        if (wVar != null) {
            if (!this.i) {
                try {
                    this.i = true;
                    wVar.l();
                } finally {
                    this.i = false;
                }
            }
            this.e = null;
        }
    }

    public Object g(ViewGroup viewGroup, int i) {
        Fragment.m mVar;
        Fragment fragment;
        if (this.g.size() > i && (fragment = (Fragment) this.g.get(i)) != null) {
            return fragment;
        }
        if (this.e == null) {
            this.e = this.c.m();
        }
        Fragment p = p(i);
        if (this.f.size() > i && (mVar = (Fragment.m) this.f.get(i)) != null) {
            p.setInitialSavedState(mVar);
        }
        while (this.g.size() <= i) {
            this.g.add((Object) null);
        }
        p.setMenuVisibility(false);
        if (this.d == 0) {
            p.setUserVisibleHint(false);
        }
        this.g.set(i, p);
        this.e.b(viewGroup.getId(), p);
        if (this.d == 1) {
            this.e.u(p, j.c.STARTED);
        }
        return p;
    }

    public boolean h(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void j(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f.clear();
            this.g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f.add((Fragment.m) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment o0 = this.c.o0(bundle, str);
                    if (o0 != null) {
                        while (this.g.size() <= parseInt) {
                            this.g.add((Object) null);
                        }
                        o0.setMenuVisibility(false);
                        this.g.set(parseInt, o0);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable k() {
        Bundle bundle;
        if (this.f.size() > 0) {
            bundle = new Bundle();
            Fragment.m[] mVarArr = new Fragment.m[this.f.size()];
            this.f.toArray(mVarArr);
            bundle.putParcelableArray("states", mVarArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = (Fragment) this.g.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.c.c1(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    public void l(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.d == 1) {
                    if (this.e == null) {
                        this.e = this.c.m();
                    }
                    this.e.u(this.h, j.c.STARTED);
                } else {
                    this.h.setUserVisibleHint(false);
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
            this.h = fragment;
        }
    }

    public void n(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract Fragment p(int i);

    public u(m mVar, int i) {
        this.e = null;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = null;
        this.c = mVar;
        this.d = i;
    }
}
