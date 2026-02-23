package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.m;
import androidx.lifecycle.j;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import androidx.navigation.k;
import androidx.navigation.s;
import java.util.HashSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DialogFragmentNavigator extends s {
    public final Context a;
    public final m b;
    public int c = 0;
    public final HashSet d = new HashSet();
    public n e = new 1();

    public class 1 implements n {
        public 1() {
        }

        public void b(p pVar, j.b bVar) {
            if (bVar == j.b.ON_STOP) {
                d dVar = (d) pVar;
                if (dVar.requireDialog().isShowing()) {
                    return;
                }
                NavHostFragment.z(dVar).u();
            }
        }
    }

    public static class a extends k implements androidx.navigation.b {
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
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, c.c);
            String string = obtainAttributes.getString(c.d);
            if (string != null) {
                A(string);
            }
            obtainAttributes.recycle();
        }

        public final String z() {
            String str = this.k;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }
    }

    public DialogFragmentNavigator(Context context, m mVar) {
        this.a = context;
        this.b = mVar;
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
            for (int i = 0; i < this.c; i++) {
                d dVar = (d) this.b.h0("androidx-nav-fragment:navigator:dialog:" + i);
                if (dVar != null) {
                    dVar.getLifecycle().a(this.e);
                } else {
                    this.d.add("androidx-nav-fragment:navigator:dialog:" + i);
                }
            }
        }
    }

    public Bundle d() {
        if (this.c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.c);
        return bundle;
    }

    public boolean e() {
        if (this.c == 0) {
            return false;
        }
        if (this.b.K0()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        m mVar = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append("androidx-nav-fragment:navigator:dialog:");
        int i = this.c - 1;
        this.c = i;
        sb.append(i);
        Fragment h0 = mVar.h0(sb.toString());
        if (h0 != null) {
            h0.getLifecycle().c(this.e);
            ((d) h0).dismiss();
        }
        return true;
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a a() {
        return new a(this);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public k b(a aVar, Bundle bundle, androidx.navigation.p pVar, s.a aVar2) {
        if (this.b.K0()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String z = aVar.z();
        if (z.charAt(0) == '.') {
            z = this.a.getPackageName() + z;
        }
        Fragment a2 = this.b.q0().a(this.a.getClassLoader(), z);
        if (!d.class.isAssignableFrom(a2.getClass())) {
            throw new IllegalArgumentException("Dialog destination " + aVar.z() + " is not an instance of DialogFragment");
        }
        d dVar = (d) a2;
        dVar.setArguments(bundle);
        dVar.getLifecycle().a(this.e);
        m mVar = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append("androidx-nav-fragment:navigator:dialog:");
        int i = this.c;
        this.c = i + 1;
        sb.append(i);
        dVar.show(mVar, sb.toString());
        return aVar;
    }

    public void h(Fragment fragment) {
        if (this.d.remove(fragment.getTag())) {
            fragment.getLifecycle().a(this.e);
        }
    }
}
