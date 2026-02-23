package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.w;
import androidx.navigation.k;
import androidx.navigation.p;
import androidx.navigation.s;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends s {
    public final Context a;
    public final m b;
    public final int c;
    public ArrayDeque d = new ArrayDeque();

    public static class a extends k {
        public String k;

        public a(s sVar) {
            super(sVar);
        }

        public final a A(String str) {
            this.k = str;
            return this;
        }

        public void p(Context context, AttributeSet attributeSet) {
            super.p(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, c.i);
            String string = obtainAttributes.getString(c.j);
            if (string != null) {
                A(string);
            }
            obtainAttributes.recycle();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.k;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            return sb.toString();
        }

        public final String z() {
            String str = this.k;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }
    }

    public a(Context context, m mVar, int i) {
        this.a = context;
        this.b = mVar;
        this.c = i;
    }

    public void c(Bundle bundle) {
        int[] intArray;
        if (bundle == null || (intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds")) == null) {
            return;
        }
        this.d.clear();
        for (int i : intArray) {
            this.d.add(Integer.valueOf(i));
        }
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.d.size()];
        Iterator it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    public boolean e() {
        if (this.d.isEmpty()) {
            return false;
        }
        if (this.b.K0()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        this.b.X0(g(this.d.size(), ((Integer) this.d.peekLast()).intValue()), 1);
        this.d.removeLast();
        return true;
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a a() {
        return new a(this);
    }

    public final String g(int i, int i2) {
        return i + "-" + i2;
    }

    public Fragment h(Context context, m mVar, String str, Bundle bundle) {
        return mVar.q0().a(context.getClassLoader(), str);
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public k b(a aVar, Bundle bundle, p pVar, s.a aVar2) {
        if (this.b.K0()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String z = aVar.z();
        boolean z2 = false;
        if (z.charAt(0) == '.') {
            z = this.a.getPackageName() + z;
        }
        Fragment h = h(this.a, this.b, z, bundle);
        h.setArguments(bundle);
        w m = this.b.m();
        int a2 = pVar != null ? pVar.a() : -1;
        int b = pVar != null ? pVar.b() : -1;
        int c = pVar != null ? pVar.c() : -1;
        int d = pVar != null ? pVar.d() : -1;
        if (a2 != -1 || b != -1 || c != -1 || d != -1) {
            if (a2 == -1) {
                a2 = 0;
            }
            if (b == -1) {
                b = 0;
            }
            if (c == -1) {
                c = 0;
            }
            if (d == -1) {
                d = 0;
            }
            m.t(a2, b, c, d);
        }
        m.q(this.c, h);
        m.v(h);
        int i = aVar.i();
        boolean isEmpty = this.d.isEmpty();
        boolean z3 = pVar != null && !isEmpty && pVar.g() && ((Integer) this.d.peekLast()).intValue() == i;
        if (isEmpty) {
            z2 = true;
        } else if (!z3) {
            m.g(g(this.d.size() + 1, i));
            z2 = true;
        } else if (this.d.size() > 1) {
            this.b.X0(g(this.d.size(), ((Integer) this.d.peekLast()).intValue()), 1);
            m.g(g(this.d.size(), i));
        }
        m.w(true);
        m.i();
        if (!z2) {
            return null;
        }
        this.d.add(Integer.valueOf(i));
        return aVar;
    }
}
