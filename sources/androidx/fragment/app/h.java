package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.N;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h {
    public final j a;

    public h(j jVar) {
        this.a = jVar;
    }

    public static h b(j jVar) {
        return new h((j) O.h.g(jVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        j jVar = this.a;
        jVar.f.k(jVar, jVar, fragment);
    }

    public void c() {
        this.a.f.y();
    }

    public void d(Configuration configuration) {
        this.a.f.A(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.a.f.B(menuItem);
    }

    public void f() {
        this.a.f.C();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.a.f.D(menu, menuInflater);
    }

    public void h() {
        this.a.f.E();
    }

    public void i() {
        this.a.f.G();
    }

    public void j(boolean z) {
        this.a.f.H(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.a.f.J(menuItem);
    }

    public void l(Menu menu) {
        this.a.f.K(menu);
    }

    public void m() {
        this.a.f.M();
    }

    public void n(boolean z) {
        this.a.f.N(z);
    }

    public boolean o(Menu menu) {
        return this.a.f.O(menu);
    }

    public void p() {
        this.a.f.Q();
    }

    public void q() {
        this.a.f.R();
    }

    public void r() {
        this.a.f.T();
    }

    public boolean s() {
        return this.a.f.a0(true);
    }

    public m t() {
        return this.a.f;
    }

    public void u() {
        this.a.f.T0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.f.u0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        j jVar = this.a;
        if (!(jVar instanceof N)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        jVar.f.j1(parcelable);
    }

    public Parcelable x() {
        return this.a.f.l1();
    }
}
