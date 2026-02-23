package i;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b {
    public Object a;
    public boolean c;

    public interface a {
        boolean a(b bVar, MenuItem menuItem);

        void b(b bVar);

        boolean c(b bVar, Menu menu);

        boolean d(b bVar, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.c;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.a = obj;
    }

    public abstract void q(int i);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z) {
        this.c = z;
    }
}
