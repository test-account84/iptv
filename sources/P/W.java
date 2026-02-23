package P;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class w {

    public static class a {
        public static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        public static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        public static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        public static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        public static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        public static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        public static MenuItem g(MenuItem menuItem, char c, int i) {
            return menuItem.setAlphabeticShortcut(c, i);
        }

        public static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        public static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        public static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        public static MenuItem k(MenuItem menuItem, char c, int i) {
            return menuItem.setNumericShortcut(c, i);
        }

        public static MenuItem l(MenuItem menuItem, char c, char c2, int i, int i2) {
            return menuItem.setShortcut(c, c2, i, i2);
        }

        public static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    public static b a(MenuItem menuItem) {
        if (menuItem instanceof I.b) {
            return ((I.b) menuItem).b();
        }
        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    public static View b(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static MenuItem c(MenuItem menuItem, b bVar) {
        if (menuItem instanceof I.b) {
            return ((I.b) menuItem).a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void d(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof I.b) {
            ((I.b) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.g(menuItem, c, i);
        }
    }

    public static void e(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof I.b) {
            ((I.b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.h(menuItem, charSequence);
        }
    }

    public static void f(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof I.b) {
            ((I.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.i(menuItem, colorStateList);
        }
    }

    public static void g(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof I.b) {
            ((I.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.j(menuItem, mode);
        }
    }

    public static void h(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof I.b) {
            ((I.b) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.k(menuItem, c, i);
        }
    }

    public static void i(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof I.b) {
            ((I.b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.m(menuItem, charSequence);
        }
    }
}
