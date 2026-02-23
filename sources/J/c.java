package j;

import P.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends j.b implements MenuItem {
    public final I.b d;
    public Method e;

    public class a extends P.b {
        public final ActionProvider d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.d = actionProvider;
        }

        public boolean b() {
            return this.d.hasSubMenu();
        }

        public View d() {
            return this.d.onCreateActionView();
        }

        public boolean f() {
            return this.d.onPerformDefaultAction();
        }

        public void g(SubMenu subMenu) {
            this.d.onPrepareSubMenu(c.this.d(subMenu));
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {
        public b.b f;

        public b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean c() {
            return this.d.isVisible();
        }

        public View e(MenuItem menuItem) {
            return this.d.onCreateActionView(menuItem);
        }

        public boolean h() {
            return this.d.overridesItemVisibility();
        }

        public void l(b.b bVar) {
            this.f = bVar;
            this.d.setVisibilityListener(bVar != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            b.b bVar = this.f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }
    }

    public static class c extends FrameLayout implements i.c {
        public final CollapsibleActionView a;

        public c(View view) {
            super(view.getContext());
            this.a = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return this.a;
        }

        public void b() {
            this.a.onActionViewExpanded();
        }

        public void f() {
            this.a.onActionViewCollapsed();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {
        public final MenuItem.OnActionExpandListener a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {
        public final MenuItem.OnMenuItemClickListener a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, I.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.d = bVar;
    }

    public boolean collapseActionView() {
        return this.d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        P.b b2 = this.d.b();
        if (b2 instanceof a) {
            return ((a) b2).d;
        }
        return null;
    }

    public View getActionView() {
        c actionView = this.d.getActionView();
        return actionView instanceof c ? actionView.a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.d.getContentDescription();
    }

    public int getGroupId() {
        return this.d.getGroupId();
    }

    public Drawable getIcon() {
        return this.d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.d.getIntent();
    }

    public int getItemId() {
        return this.d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.d.getNumericShortcut();
    }

    public int getOrder() {
        return this.d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.d.getTooltipText();
    }

    public void h(boolean z) {
        try {
            if (this.e == null) {
                this.e = this.d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.e.invoke(this.d, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    public boolean hasSubMenu() {
        return this.d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.d.isCheckable();
    }

    public boolean isChecked() {
        return this.d.isChecked();
    }

    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    public boolean isVisible() {
        return this.d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.a, actionProvider);
        I.b bVar2 = this.d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    public MenuItem setActionView(int i) {
        this.d.setActionView(i);
        View actionView = this.d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.d.setActionView((View) new c(actionView));
        }
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.d.setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.d.setIcon(i);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.d.setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int i) {
        this.d.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.d.setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.d.setTitle(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.d.setVisible(z);
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.d.setAlphabeticShortcut(c2, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.d.setIcon(drawable);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i) {
        this.d.setNumericShortcut(c2, i);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.d.setShortcut(c2, c3, i, i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.d.setTitle(charSequence);
        return this;
    }
}
