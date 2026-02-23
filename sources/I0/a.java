package i0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a {
    public static a c;
    public boolean a;
    public boolean b;

    public static class a {
        public Resources a;
        public String b;

        public a(Resources resources, String str) {
            this.a = resources;
            this.b = str;
        }

        public boolean a(String str, boolean z) {
            int identifier = this.a.getIdentifier(str, "bool", this.b);
            return identifier > 0 ? this.a.getBoolean(identifier) : z;
        }
    }

    public a(Context context) {
        a(b(context));
    }

    public static a c(Context context) {
        if (c == null) {
            c = new a(context);
        }
        return c;
    }

    public static boolean e(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        return (activityInfo == null || (activityInfo.applicationInfo.flags & 1) == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(i0.a.a r3) {
        /*
            r2 = this;
            boolean r0 = androidx.leanback.widget.P.b()
            r1 = 0
            if (r0 == 0) goto L14
            r2.a = r1
            if (r3 == 0) goto L16
            java.lang.String r0 = "leanback_prefer_static_shadows"
            boolean r0 = r3.a(r0, r1)
        L11:
            r2.a = r0
            goto L16
        L14:
            r0 = 1
            goto L11
        L16:
            r2.b = r1
            if (r3 == 0) goto L22
            java.lang.String r0 = "leanback_outline_clipping_disabled"
            boolean r3 = r3.a(r0, r1)
            r2.b = r3
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.a.a(i0.a$a):void");
    }

    public final a b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Resources resources = null;
        String str = null;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent("android.support.v17.leanback.action.PARTNER_CUSTOMIZATION"), 0)) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (str2 != null && e(resolveInfo)) {
                try {
                    resources = packageManager.getResourcesForApplication(str2);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            str = str2;
            if (resources != null) {
                break;
            }
        }
        if (resources == null) {
            return null;
        }
        return new a(resources, str);
    }

    public boolean d() {
        return this.b;
    }

    public boolean f() {
        return this.a;
    }
}
