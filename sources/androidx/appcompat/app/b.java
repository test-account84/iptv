package androidx.appcompat.app;

import D.P;
import D.j;
import F0.c;
import F0.f;
import L.i;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.n;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.e;
import androidx.lifecycle.O;
import d.d;
import i.b;
import k.l0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b extends e implements d.b, P.b {
    public d a;
    public Resources c;

    public class a implements c.c {
        public a() {
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            b.this.h1().B(bundle);
            return bundle;
        }
    }

    public class b implements a.b {
        public b() {
        }

        public void a(Context context) {
            d h1 = b.this.h1();
            h1.s();
            h1.x(b.this.getSavedStateRegistry().b("androidx:appcompat"));
        }
    }

    public b() {
        j1();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c1();
        h1().e(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(h1().g(context));
    }

    public final void c1() {
        O.a(getWindow().getDecorView(), this);
        androidx.lifecycle.P.a(getWindow().getDecorView(), this);
        f.a(getWindow().getDecorView(), this);
        n.a(getWindow().getDecorView(), this);
    }

    public void closeOptionsMenu() {
        d.a i1 = i1();
        if (getWindow().hasFeature(0)) {
            if (i1 == null || !i1.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        d.a i1 = i1();
        if (keyCode == 82 && i1 != null && i1.q(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public View findViewById(int i) {
        return h1().j(i);
    }

    public MenuInflater getMenuInflater() {
        return h1().p();
    }

    public Resources getResources() {
        if (this.c == null && l0.c()) {
            this.c = new l0(this, super.getResources());
        }
        Resources resources = this.c;
        return resources == null ? super.getResources() : resources;
    }

    public d h1() {
        if (this.a == null) {
            this.a = d.h(this, this);
        }
        return this.a;
    }

    public d.a i1() {
        return h1().r();
    }

    public void invalidateOptionsMenu() {
        h1().t();
    }

    public final void j1() {
        getSavedStateRegistry().h("androidx:appcompat", new a());
        addOnContextAvailableListener(new b());
    }

    public void k1(P p) {
        p.c(this);
    }

    public void m1(int i) {
    }

    public void o1() {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h1().w(configuration);
        if (this.c != null) {
            this.c.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        o1();
    }

    public void onDestroy() {
        super.onDestroy();
        h1().y();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (q1(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        d.a i1 = i1();
        if (menuItem.getItemId() != 16908332 || i1 == null || (i1.j() & 4) == 0) {
            return false;
        }
        return p1();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        h1().z(bundle);
    }

    public void onPostResume() {
        super.onPostResume();
        h1().A();
    }

    public void onStart() {
        super.onStart();
        h1().C();
    }

    public void onStop() {
        super.onStop();
        h1().D();
    }

    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        h1().N(charSequence);
    }

    public i.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void openOptionsMenu() {
        d.a i1 = i1();
        if (getWindow().hasFeature(0)) {
            if (i1 == null || !i1.r()) {
                super.openOptionsMenu();
            }
        }
    }

    public boolean p1() {
        Intent v = v();
        if (v == null) {
            return false;
        }
        if (!t1(v)) {
            s1(v);
            return true;
        }
        P e = P.e(this);
        k1(e);
        n1(e);
        e.n();
        try {
            D.b.b(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public final boolean q1(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    public void r1(Toolbar toolbar) {
        h1().L(toolbar);
    }

    public void s1(Intent intent) {
        j.e(this, intent);
    }

    public void setContentView(int i) {
        c1();
        h1().H(i);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        h1().M(i);
    }

    public void supportInvalidateOptionsMenu() {
        h1().t();
    }

    public boolean t1(Intent intent) {
        return j.f(this, intent);
    }

    public Intent v() {
        return j.a(this);
    }

    public void setContentView(View view) {
        c1();
        h1().I(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c1();
        h1().J(view, layoutParams);
    }

    public void l1(i iVar) {
    }

    public void n1(P p) {
    }

    public void onSupportActionModeFinished(i.b bVar) {
    }

    public void onSupportActionModeStarted(i.b bVar) {
    }
}
