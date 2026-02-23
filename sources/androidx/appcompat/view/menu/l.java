package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l extends e implements SubMenu {
    public e B;
    public g C;

    public l(Context context, e eVar, g gVar) {
        super(context);
        this.B = eVar;
        this.C = gVar;
    }

    public e D() {
        return this.B.D();
    }

    public boolean F() {
        return this.B.F();
    }

    public boolean G() {
        return this.B.G();
    }

    public boolean H() {
        return this.B.H();
    }

    public void R(e.a aVar) {
        this.B.R(aVar);
    }

    public Menu e0() {
        return this.B;
    }

    public boolean f(g gVar) {
        return this.B.f(gVar);
    }

    public MenuItem getItem() {
        return this.C;
    }

    public boolean h(e eVar, MenuItem menuItem) {
        return super.h(eVar, menuItem) || this.B.h(eVar, menuItem);
    }

    public boolean k(g gVar) {
        return this.B.k(gVar);
    }

    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(int i) {
        return super.U(i);
    }

    public SubMenu setHeaderTitle(int i) {
        return super.X(i);
    }

    public SubMenu setHeaderView(View view) {
        return super.Z(view);
    }

    public SubMenu setIcon(int i) {
        this.C.setIcon(i);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public String t() {
        g gVar = this.C;
        int itemId = gVar != null ? gVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return super.V(drawable);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return super.Y(charSequence);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }
}
