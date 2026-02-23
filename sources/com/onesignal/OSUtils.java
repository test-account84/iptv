package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.firebase.messaging.FirebaseMessaging;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.location.LocationCallback;
import com.onesignal.F1;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class OSUtils {
    public static int a = 3;
    public static final int[] b = {401, 402, 403, 404, 410};

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.HTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        DATA("data"),
        HTTPS("https"),
        HTTP("http");

        private final String text;

        b(String str) {
            this.text = str;
        }

        public static b fromString(String str) {
            for (b bVar : values()) {
                if (bVar.text.equalsIgnoreCase(str)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public static boolean B() {
        return new OSUtils().e() == 1;
    }

    public static boolean C() {
        return new OSUtils().e() == 2;
    }

    public static boolean D() {
        return P("com.google.android.gms");
    }

    public static boolean E() {
        try {
            return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(F1.b) == 0;
        } catch (RuntimeException e) {
            if (i.a(e.getCause())) {
                return false;
            }
            throw e;
        }
    }

    public static boolean F() {
        return P("com.huawei.hwid");
    }

    public static boolean G() {
        return new OSUtils().e() == 13;
    }

    public static boolean H() {
        return Thread.currentThread().equals(Looper.getMainLooper().getThread());
    }

    public static boolean I(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean J(String str) {
        return (str == null || str.matches("^[0-9]")) ? false : true;
    }

    public static Set K() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static Set L(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return hashSet;
    }

    public static void M(Uri uri) {
        F1.b.startActivity(O(uri));
    }

    public static void N(String str) {
        M(Uri.parse(str.trim()));
    }

    public static Intent O(Uri uri) {
        Intent makeMainSelectorActivity;
        b fromString = uri.getScheme() != null ? b.fromString(uri.getScheme()) : null;
        if (fromString == null) {
            fromString = b.HTTP;
            if (!uri.toString().contains("://")) {
                uri = Uri.parse("http://" + uri.toString());
            }
        }
        if (a.a[fromString.ordinal()] != 1) {
            makeMainSelectorActivity = new Intent("android.intent.action.VIEW", uri);
        } else {
            makeMainSelectorActivity = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
            makeMainSelectorActivity.setData(uri);
        }
        makeMainSelectorActivity.addFlags(268435456);
        return makeMainSelectorActivity;
    }

    public static boolean P(String str) {
        PackageInfo a2;
        A a3 = X1.a.a(F1.b, str, 128);
        if (a3.b() && (a2 = a3.a()) != null) {
            return a2.applicationInfo.enabled;
        }
        return false;
    }

    public static long[] Q(JSONObject jSONObject) {
        try {
            Object opt = jSONObject.opt("vib_pt");
            JSONArray jSONArray = opt instanceof String ? new JSONArray((String) opt) : (JSONArray) opt;
            long[] jArr = new long[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void R(Runnable runnable, int i) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, i);
    }

    public static void S(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static boolean T(String str) {
        if (str != null) {
            return false;
        }
        F1.a(F1.v.INFO, "OneSignal was not initialized, ensure to always initialize OneSignal from the onCreate of your Application class.");
        return true;
    }

    public static boolean U(int i) {
        for (int i2 : b) {
            if (i == i2) {
                return false;
            }
        }
        return true;
    }

    public static void V(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void W(Thread thread) {
        boolean z = false;
        while (!z) {
            try {
                thread.start();
                z = true;
            } catch (OutOfMemoryError unused) {
                try {
                    Thread.sleep(250L);
                } catch (InterruptedException unused2) {
                }
            }
        }
    }

    public static boolean a(Context context) {
        try {
            return D.L.d(F1.b).a();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String f(Context context, String str) {
        Bundle h = h(context);
        if (h != null) {
            return h.getString(str);
        }
        return null;
    }

    public static boolean g(Context context, String str) {
        Bundle h = h(context);
        if (h != null) {
            return h.getBoolean(str);
        }
        return false;
    }

    public static Bundle h(Context context) {
        ApplicationInfo a2 = j.a.a(context);
        if (a2 == null) {
            return null;
        }
        return a2.metaData;
    }

    public static int j(int i, int i2) {
        return new Random().nextInt((i2 + 1) - i) + i;
    }

    public static String k(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "string", context.getPackageName());
        return identifier != 0 ? resources.getString(identifier) : str2;
    }

    public static String l(Throwable th) {
        return m(th).getMessage();
    }

    public static Throwable m(Throwable th) {
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    public static Uri n(Context context, String str) {
        int identifier;
        StringBuilder sb;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        if (!J(str) || (identifier = resources.getIdentifier(str, "raw", packageName)) == 0) {
            identifier = resources.getIdentifier("onesignal_default_sound", "raw", packageName);
            if (identifier == 0) {
                return null;
            }
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
        }
        sb.append("android.resource://");
        sb.append(packageName);
        sb.append("/");
        sb.append(identifier);
        return Uri.parse(sb.toString());
    }

    public static int o(Context context) {
        ApplicationInfo a2 = j.a.a(context);
        if (a2 == null) {
            return 15;
        }
        return a2.targetSdkVersion;
    }

    @Keep
    private static boolean opaqueHasClass(Class cls) {
        return true;
    }

    public static boolean p() {
        return t() && w();
    }

    public static boolean q(Activity activity, int i) {
        try {
            return (activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).configChanges & i) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean r() {
        try {
            return opaqueHasClass(FirebaseMessaging.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean s() {
        try {
            return opaqueHasClass(J4.j.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean t() {
        try {
            return opaqueHasClass(AGConnectServicesConfig.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean u() {
        try {
            return opaqueHasClass(HuaweiApiAvailability.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean v() {
        try {
            return opaqueHasClass(LocationCallback.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean w() {
        try {
            return opaqueHasClass(HmsInstanceId.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean x() {
        return true;
    }

    public static boolean y() {
        return true;
    }

    public static boolean z() {
        return true;
    }

    public int A(Context context, String str) {
        Integer c;
        int e = e();
        try {
            UUID.fromString(str);
            if ("b2f7f966-d8cc-11e4-bed1-df8f05be55ba".equals(str) || "5eb5a37e-b458-11e3-ac11-000c2940e62c".equals(str)) {
                F1.a(F1.v.ERROR, "OneSignal Example AppID detected, please update to your app's id found on OneSignal.com");
            }
            int i = 1;
            if (e == 1 && (c = c()) != null) {
                i = c.intValue();
            }
            Integer b2 = b(context);
            return b2 != null ? b2.intValue() : i;
        } catch (Throwable th) {
            F1.b(F1.v.FATAL, "OneSignal AppId format is invalid.\nExample: 'b2f7f966-d8cc-11e4-bed1-df8f05be55ba'\n", th);
            return -999;
        }
    }

    public final boolean X() {
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean Y() {
        if (r()) {
            return D();
        }
        return false;
    }

    public final boolean Z() {
        if (u() && p()) {
            return E();
        }
        return false;
    }

    public final Integer b(Context context) {
        boolean z = z();
        boolean y = y();
        if (!z && !y) {
            F1.a(F1.v.FATAL, "Could not find the Android Support Library. Please make sure it has been correctly added to your project.");
            return -3;
        }
        if (!z || !y) {
            F1.a(F1.v.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
            return -5;
        }
        if (Build.VERSION.SDK_INT < 26 || o(context) < 26 || x()) {
            return null;
        }
        F1.a(F1.v.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
        return -5;
    }

    public Integer c() {
        if (r()) {
            return null;
        }
        F1.a(F1.v.FATAL, "The Firebase FCM library is missing! Please make sure to include it in your project.");
        return -4;
    }

    public String d() {
        try {
            String networkOperatorName = ((TelephonyManager) F1.b.getSystemService("phone")).getNetworkOperatorName();
            if ("".equals(networkOperatorName)) {
                return null;
            }
            return networkOperatorName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int e() {
        if (X()) {
            return 2;
        }
        boolean Z = Z();
        boolean Y = Y();
        if (Y && Z) {
            Context context = F1.b;
            return (context == null || !g(context, "com.onesignal.preferHMS")) ? 1 : 13;
        }
        if (Y) {
            return 1;
        }
        if (Z) {
            return 13;
        }
        return (!D() && F()) ? 13 : 1;
    }

    public Integer i() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) F1.b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        return (type == 1 || type == 9) ? 0 : 1;
    }
}
