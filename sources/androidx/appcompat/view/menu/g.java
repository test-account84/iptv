package androidx.appcompat.view.menu;

import P.b;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class g implements I.b {
    public View A;
    public P.b B;
    public MenuItem.OnActionExpandListener C;
    public ContextMenu.ContextMenuInfo E;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;
    public char j;
    public Drawable l;
    public e n;
    public l o;
    public Runnable p;
    public MenuItem.OnMenuItemClickListener q;
    public CharSequence r;
    public CharSequence s;
    public int z;
    public int i = 4096;
    public int k = 4096;
    public int m = 0;
    public ColorStateList t = null;
    public PorterDuff.Mode u = null;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public int y = 16;
    public boolean D = false;

    public class a implements b.b {
        public a() {
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            g gVar = g.this;
            gVar.n.J(gVar);
        }
    }

    public g(e eVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.n = eVar;
        this.a = i2;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = charSequence;
        this.z = i5;
    }

    public static void d(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    public boolean A() {
        return this.n.H() && g() != 0;
    }

    public boolean B() {
        return (this.z & 4) == 4;
    }

    public I.b a(P.b bVar) {
        P.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.j();
        }
        this.A = null;
        this.B = bVar;
        this.n.K(true);
        P.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.l(new a());
        }
        return this;
    }

    public P.b b() {
        return this.B;
    }

    public void c() {
        this.n.I(this);
    }

    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.f(this);
        }
        return false;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = H.a.r(drawable).mutate();
            if (this.v) {
                H.a.o(drawable, this.t);
            }
            if (this.w) {
                H.a.p(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.k(this);
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    public char g() {
        return this.n.G() ? this.j : this.h;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        P.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View e = bVar.e(this);
        this.A = e;
        return e;
    }

    public int getAlphabeticModifiers() {
        return this.k;
    }

    public char getAlphabeticShortcut() {
        return this.j;
    }

    public CharSequence getContentDescription() {
        return this.r;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.m == 0) {
            return null;
        }
        Drawable b = e.a.b(this.n.u(), this.m);
        this.m = 0;
        this.l = b;
        return e(b);
    }

    public ColorStateList getIconTintList() {
        return this.t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    public Intent getIntent() {
        return this.g;
    }

    public int getItemId() {
        return this.a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.i;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.c;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        return charSequence != null ? charSequence : this.e;
    }

    public CharSequence getTooltipText() {
        return this.s;
    }

    public String h() {
        int i;
        char g = g();
        if (g == 0) {
            return "";
        }
        Resources resources = this.n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(c.h.m));
        }
        int i2 = this.n.G() ? this.k : this.i;
        d(sb, i2, 65536, resources.getString(c.h.i));
        d(sb, i2, 4096, resources.getString(c.h.e));
        d(sb, i2, 2, resources.getString(c.h.d));
        d(sb, i2, 1, resources.getString(c.h.j));
        d(sb, i2, 4, resources.getString(c.h.l));
        d(sb, i2, 8, resources.getString(c.h.h));
        if (g == '\b') {
            i = c.h.f;
        } else if (g == '\n') {
            i = c.h.g;
        } else {
            if (g != ' ') {
                sb.append(g);
                return sb.toString();
            }
            i = c.h.k;
        }
        sb.append(resources.getString(i));
        return sb.toString();
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public CharSequence i(j.a aVar) {
        return (aVar == null || !aVar.e()) ? getTitle() : getTitleCondensed();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    public boolean isVisible() {
        P.b bVar = this.B;
        return (bVar == null || !bVar.h()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.c();
    }

    public boolean j() {
        P.b bVar;
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.e(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.g != null) {
            try {
                this.n.u().startActivity(this.g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        P.b bVar = this.B;
        return bVar != null && bVar.f();
    }

    public boolean l() {
        return (this.y & 32) == 32;
    }

    public boolean m() {
        return (this.y & 4) != 0;
    }

    public boolean n() {
        return (this.z & 1) == 1;
    }

    public boolean o() {
        return (this.z & 2) == 2;
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public I.b setActionView(int i) {
        Context u = this.n.u();
        setActionView(LayoutInflater.from(u).inflate(i, new LinearLayout(u), false));
        return this;
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public I.b setActionView(View view) {
        int i;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i = this.a) > 0) {
            view.setId(i);
        }
        this.n.I(this);
        return this;
    }

    public void r(boolean z) {
        this.D = z;
        this.n.K(false);
    }

    public void s(boolean z) {
        int i = this.y;
        int i2 = (z ? 2 : 0) | (i & (-3));
        this.y = i2;
        if (i != i2) {
            this.n.K(false);
        }
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.j == c) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.n.K(false);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.y;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.y = i2;
        if (i != i2) {
            this.n.K(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.n.T(this);
        } else {
            s(z);
        }
        return this;
    }

    public I.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.n.K(false);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.y = z ? this.y | 16 : this.y & (-17);
        this.n.K(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.l = null;
        this.m = i;
        this.x = true;
        this.n.K(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.K(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.K(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.h == c) {
            return this;
        }
        this.h = c;
        this.n.K(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.j = Character.toLowerCase(c2);
        this.n.K(false);
        return this;
    }

    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i;
        this.n.I(this);
    }

    public MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.n.u().getString(i));
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.n.K(false);
        return this;
    }

    public I.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.n.K(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (y(z)) {
            this.n.J(this);
        }
        return this;
    }

    public void t(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z) {
        this.y = z ? this.y | 32 : this.y & (-33);
    }

    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public I.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public void x(l lVar) {
        this.o = lVar;
        lVar.setHeaderTitle(getTitle());
    }

    public boolean y(boolean z) {
        int i = this.y;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.y = i2;
        return i != i2;
    }

    public boolean z() {
        return this.n.A();
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.j == c && this.k == i) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(i);
        this.n.K(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.x = true;
        this.n.K(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (this.h == c && this.i == i) {
            return this;
        }
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.n.K(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.K(false);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.n.K(false);
        l lVar = this.o;
        if (lVar != null) {
            lVar.setHeaderTitle(charSequence);
        }
        return this;
    }
}
