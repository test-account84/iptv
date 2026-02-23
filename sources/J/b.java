package j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import s.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b {
    public final Context a;
    public i b;
    public i c;

    public b(Context context) {
        this.a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof I.b)) {
            return menuItem;
        }
        I.b bVar = (I.b) menuItem;
        if (this.b == null) {
            this.b = new i();
        }
        MenuItem menuItem2 = (MenuItem) this.b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.a, bVar);
        this.b.put(bVar, cVar);
        return cVar;
    }

    public final void e() {
        i iVar = this.b;
        if (iVar != null) {
            iVar.clear();
        }
        i iVar2 = this.c;
        if (iVar2 != null) {
            iVar2.clear();
        }
    }

    public final void f(int i) {
        if (this.b == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.b.size()) {
            if (((I.b) this.b.j(i2)).getGroupId() == i) {
                this.b.m(i2);
                i2--;
            }
            i2++;
        }
    }

    public final void g(int i) {
        if (this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (((I.b) this.b.j(i2)).getItemId() == i) {
                this.b.m(i2);
                return;
            }
        }
    }

    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }
}
