package a4;

import O2.z0;
import android.content.res.Resources;
import android.text.TextUtils;
import d4.k0;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h implements c0 {
    public final Resources a;

    public h(Resources resources) {
        this.a = (Resources) d4.a.e(resources);
    }

    public static int i(z0 z0Var) {
        int k = d4.F.k(z0Var.m);
        if (k != -1) {
            return k;
        }
        if (d4.F.n(z0Var.j) != null) {
            return 2;
        }
        if (d4.F.c(z0Var.j) != null) {
            return 1;
        }
        if (z0Var.r == -1 && z0Var.s == -1) {
            return (z0Var.z == -1 && z0Var.A == -1) ? -1 : 1;
        }
        return 2;
    }

    public String a(z0 z0Var) {
        int i = i(z0Var);
        String j = i == 2 ? j(h(z0Var), g(z0Var), c(z0Var)) : i == 1 ? j(e(z0Var), b(z0Var), c(z0Var)) : e(z0Var);
        return j.length() == 0 ? this.a.getString(w.F) : j;
    }

    public final String b(z0 z0Var) {
        Resources resources;
        int i;
        int i2 = z0Var.z;
        if (i2 == -1 || i2 < 1) {
            return "";
        }
        if (i2 == 1) {
            resources = this.a;
            i = w.q;
        } else if (i2 == 2) {
            resources = this.a;
            i = w.B;
        } else if (i2 == 6 || i2 == 7) {
            resources = this.a;
            i = w.D;
        } else if (i2 != 8) {
            resources = this.a;
            i = w.C;
        } else {
            resources = this.a;
            i = w.E;
        }
        return resources.getString(i);
    }

    public final String c(z0 z0Var) {
        int i = z0Var.i;
        return i == -1 ? "" : this.a.getString(w.p, new Object[]{Float.valueOf(i / 1000000.0f)});
    }

    public final String d(z0 z0Var) {
        return TextUtils.isEmpty(z0Var.c) ? "" : z0Var.c;
    }

    public final String e(z0 z0Var) {
        String j = j(f(z0Var), h(z0Var));
        return TextUtils.isEmpty(j) ? d(z0Var) : j;
    }

    public final String f(z0 z0Var) {
        String str = z0Var.d;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        Locale forLanguageTag = k0.a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale T = k0.T();
        String displayName = forLanguageTag.getDisplayName(T);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, offsetByCodePoints).toUpperCase(T) + displayName.substring(offsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    public final String g(z0 z0Var) {
        int i = z0Var.r;
        int i2 = z0Var.s;
        return (i == -1 || i2 == -1) ? "" : this.a.getString(w.r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final String h(z0 z0Var) {
        String string = (z0Var.f & 2) != 0 ? this.a.getString(w.s) : "";
        if ((z0Var.f & 4) != 0) {
            string = j(string, this.a.getString(w.v));
        }
        if ((z0Var.f & 8) != 0) {
            string = j(string, this.a.getString(w.u));
        }
        return (z0Var.f & 1088) != 0 ? j(string, this.a.getString(w.t)) : string;
    }

    public final String j(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.a.getString(w.o, new Object[]{str, str2});
            }
        }
        return str;
    }
}
