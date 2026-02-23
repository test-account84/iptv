package i;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import i.b;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends b implements e.a {
    public Context d;
    public ActionBarContextView e;
    public b.a f;
    public WeakReference g;
    public boolean h;
    public boolean i;
    public androidx.appcompat.view.menu.e j;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.d = context;
        this.e = actionBarContextView;
        this.f = aVar;
        androidx.appcompat.view.menu.e S = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).S(1);
        this.j = S;
        S.R(this);
        this.i = z;
    }

    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f.a(this, menuItem);
    }

    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.e.l();
    }

    public void c() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.f.b(this);
    }

    public View d() {
        WeakReference weakReference = this.g;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public Menu e() {
        return this.j;
    }

    public MenuInflater f() {
        return new g(this.e.getContext());
    }

    public CharSequence g() {
        return this.e.getSubtitle();
    }

    public CharSequence i() {
        return this.e.getTitle();
    }

    public void k() {
        this.f.c(this, this.j);
    }

    public boolean l() {
        return this.e.j();
    }

    public void m(View view) {
        this.e.setCustomView(view);
        this.g = view != null ? new WeakReference(view) : null;
    }

    public void n(int i) {
        o(this.d.getString(i));
    }

    public void o(CharSequence charSequence) {
        this.e.setSubtitle(charSequence);
    }

    public void q(int i) {
        r(this.d.getString(i));
    }

    public void r(CharSequence charSequence) {
        this.e.setTitle(charSequence);
    }

    public void s(boolean z) {
        super.s(z);
        this.e.setTitleOptional(z);
    }
}
