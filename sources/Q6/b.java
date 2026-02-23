package q6;

import D.l;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b {
    public static final AtomicInteger a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static class a {
        public final l.e a;
        public final String b;
        public final int c = 0;

        public a(l.e eVar, String str, int i) {
            this.a = eVar;
            this.b = str;
        }
    }

    public static PendingIntent a(Context context, J j, String str, PackageManager packageManager) {
        Intent f = f(str, j, packageManager);
        if (f == null) {
            return null;
        }
        f.addFlags(67108864);
        f.putExtras(j.y());
        if (q(j)) {
            f.putExtra("gcm.n.analytics_data", j.x());
        }
        return PendingIntent.getActivity(context, g(), f, l(1073741824));
    }

    public static PendingIntent b(Context context, J j) {
        if (q(j)) {
            return c(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(j.x()));
        }
        return null;
    }

    public static PendingIntent c(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), l(1073741824));
    }

    public static a d(Context context, String str, J j, String str2, Resources resources, PackageManager packageManager, Bundle bundle) {
        l.e eVar = new l.e(context, str2);
        String n = j.n(resources, str, "gcm.n.title");
        if (!TextUtils.isEmpty(n)) {
            eVar.n(n);
        }
        String n2 = j.n(resources, str, "gcm.n.body");
        if (!TextUtils.isEmpty(n2)) {
            eVar.m(n2);
            eVar.F(new l.c().h(n2));
        }
        eVar.D(m(packageManager, resources, str, j.p("gcm.n.icon"), bundle));
        Uri n3 = n(str, j, resources);
        if (n3 != null) {
            eVar.E(n3);
        }
        eVar.l(a(context, j, str, packageManager));
        PendingIntent b = b(context, j);
        if (b != null) {
            eVar.p(b);
        }
        Integer h = h(context, j.p("gcm.n.color"), bundle);
        if (h != null) {
            eVar.j(h.intValue());
        }
        eVar.h(!j.a("gcm.n.sticky"));
        eVar.w(j.a("gcm.n.local_only"));
        String p = j.p("gcm.n.ticker");
        if (p != null) {
            eVar.G(p);
        }
        Integer m = j.m();
        if (m != null) {
            eVar.A(m.intValue());
        }
        Integer r = j.r();
        if (r != null) {
            eVar.I(r.intValue());
        }
        Integer l = j.l();
        if (l != null) {
            eVar.x(l.intValue());
        }
        Long j2 = j.j("gcm.n.event_time");
        if (j2 != null) {
            eVar.C(true);
            eVar.J(j2.longValue());
        }
        long[] q = j.q();
        if (q != null) {
            eVar.H(q);
        }
        int[] e = j.e();
        if (e != null) {
            eVar.v(e[0], e[1], e[2]);
        }
        eVar.o(i(j));
        return new a(eVar, o(j), 0);
    }

    public static a e(Context context, J j) {
        Bundle j2 = j(context.getPackageManager(), context.getPackageName());
        return d(context, context.getPackageName(), j, k(context, j.k(), j2), context.getResources(), context.getPackageManager(), j2);
    }

    public static Intent f(String str, J j, PackageManager packageManager) {
        String p = j.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p)) {
            Intent intent = new Intent(p);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f = j.f();
        if (f != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    public static int g() {
        return a.incrementAndGet();
    }

    public static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i == 0) {
            return null;
        }
        try {
            return Integer.valueOf(E.b.getColor(context, i));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static int i(J j) {
        boolean a2 = j.a("gcm.n.default_sound");
        ?? r0 = a2;
        if (j.a("gcm.n.default_vibrate_timings")) {
            r0 = (a2 ? 1 : 0) | 2;
        }
        return j.a("gcm.n.default_light_settings") ? r0 | 4 : r0;
    }

    public static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: ".concat(e.toString()));
        }
        return Bundle.EMPTY;
    }

    public static String k(Context context, String str, Bundle bundle) {
        String str2;
        String string;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion >= 26) {
                NotificationManager notificationManager = (NotificationManager) com.google.android.gms.internal.measurement.b.a(context, NotificationManager.class);
                if (!TextUtils.isEmpty(str)) {
                    if (w4.e.a(notificationManager, str) != null) {
                        return str;
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                    sb.append("Notification Channel requested (");
                    sb.append(str);
                    sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                    Log.w("FirebaseMessaging", sb.toString());
                }
                String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                if (TextUtils.isEmpty(string2)) {
                    str2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
                } else {
                    if (w4.e.a(notificationManager, string2) != null) {
                        return string2;
                    }
                    str2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
                }
                Log.w("FirebaseMessaging", str2);
                if (w4.e.a(notificationManager, "fcm_fallback_notification_channel") == null) {
                    int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                    if (identifier == 0) {
                        Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                        string = "Misc";
                    } else {
                        string = context.getString(identifier);
                    }
                    com.amplifyframework.storage.s3.service.a.a(notificationManager, com.amplifyframework.storage.s3.service.b.a("fcm_fallback_notification_channel", string, 3));
                }
                return "fcm_fallback_notification_channel";
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static int l(int i) {
        return Build.VERSION.SDK_INT >= 23 ? 1140850688 : 1073741824;
    }

    public static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 61);
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !p(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: ".concat(e.toString()));
            }
        }
        if (i == 0 || !p(resources, i)) {
            return 17301651;
        }
        return i;
    }

    public static Uri n(String str, J j, Resources resources) {
        String o = j.o();
        if (TextUtils.isEmpty(o)) {
            return null;
        }
        if ("default".equals(o) || resources.getIdentifier(o, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(o).length());
        sb.append("android.resource://");
        sb.append(str);
        sb.append("/raw/");
        sb.append(o);
        return Uri.parse(sb.toString());
    }

    public static String o(J j) {
        String p = j.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        StringBuilder sb = new StringBuilder(37);
        sb.append("FCM-Notification:");
        sb.append(uptimeMillis);
        return sb.toString();
    }

    public static boolean p(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!q6.a.a(resources.getDrawable(i, (Resources.Theme) null))) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    public static boolean q(J j) {
        return j.a("google.c.a.e");
    }
}
