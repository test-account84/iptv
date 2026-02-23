package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.j;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class w {
    public final i a;
    public final ClassLoader b;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public String k;
    public int l;
    public CharSequence m;
    public int n;
    public CharSequence o;
    public ArrayList p;
    public ArrayList q;
    public ArrayList s;
    public ArrayList c = new ArrayList();
    public boolean j = true;
    public boolean r = false;

    public static final class a {
        public int a;
        public Fragment b;
        public int c;
        public int d;
        public int e;
        public int f;
        public j.c g;
        public j.c h;

        public a() {
        }

        public a(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
            j.c cVar = j.c.RESUMED;
            this.g = cVar;
            this.h = cVar;
        }

        public a(int i, Fragment fragment, j.c cVar) {
            this.a = i;
            this.b = fragment;
            this.g = fragment.mMaxState;
            this.h = cVar;
        }
    }

    public w(i iVar, ClassLoader classLoader) {
        this.a = iVar;
        this.b = classLoader;
    }

    public w b(int i, Fragment fragment) {
        o(i, fragment, null, 1);
        return this;
    }

    public w c(int i, Fragment fragment, String str) {
        o(i, fragment, str, 1);
        return this;
    }

    public w d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public w e(Fragment fragment, String str) {
        o(0, fragment, str, 1);
        return this;
    }

    public void f(a aVar) {
        this.c.add(aVar);
        aVar.c = this.d;
        aVar.d = this.e;
        aVar.e = this.f;
        aVar.f = this.g;
    }

    public w g(String str) {
        if (!this.j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.i = true;
        this.k = str;
        return this;
    }

    public w h(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    public w m(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public w n() {
        if (this.i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.j = false;
        return this;
    }

    public void o(int i, Fragment fragment, String str, int i2) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        f(new a(i2, fragment));
    }

    public w p(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public w q(int i, Fragment fragment) {
        return r(i, fragment, null);
    }

    public w r(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        o(i, fragment, str, 2);
        return this;
    }

    public w s(int i, int i2) {
        return t(i, i2, 0, 0);
    }

    public w t(int i, int i2, int i3, int i4) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        return this;
    }

    public w u(Fragment fragment, j.c cVar) {
        f(new a(10, fragment, cVar));
        return this;
    }

    public w v(Fragment fragment) {
        f(new a(8, fragment));
        return this;
    }

    public w w(boolean z) {
        this.r = z;
        return this;
    }
}
