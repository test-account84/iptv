package w4;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.common.zzd;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class i {
    public static final int a = m.a;
    public static final i b = new i();

    public static i h() {
        return b;
    }

    public void a(Context context) {
        m.a(context);
    }

    public int b(Context context) {
        return m.c(context);
    }

    public Intent c(int i) {
        return d(null, i, null);
    }

    public Intent d(Context context, int i, String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", (String) null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        }
        if (context != null && C4.i.d(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(E4.e.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String sb2 = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(sb2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
        }
        intent3.setData(appendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public PendingIntent e(Context context, int i, int i2) {
        return f(context, i, i2, null);
    }

    public PendingIntent f(Context context, int i, int i2, String str) {
        Intent d = d(context, i, str);
        if (d == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, d, zzd.zza | 134217728);
    }

    public String g(int i) {
        return m.d(i);
    }

    public int i(Context context) {
        return j(context, a);
    }

    public int j(Context context, int i) {
        int h = m.h(context, i);
        if (m.i(context, h)) {
            return 18;
        }
        return h;
    }

    public boolean k(Context context, int i) {
        return m.i(context, i);
    }

    public boolean l(Context context, String str) {
        return m.m(context, str);
    }

    public boolean m(int i) {
        return m.k(i);
    }

    public void n(Context context, int i) {
        m.b(context, i);
    }
}
