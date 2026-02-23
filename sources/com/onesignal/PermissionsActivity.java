package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.onesignal.a;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PermissionsActivity extends Activity {
    public static final String d = "com.onesignal.PermissionsActivity";
    public static boolean e;
    public static boolean f;
    public static boolean g;
    public static a.b h;
    public static final HashMap i = new HashMap();
    public String a;
    public String c;

    public class a implements Runnable {
        public final /* synthetic */ int[] a;

        public a(int[] iArr) {
            this.a = iArr;
        }

        public void run() {
            int[] iArr = this.a;
            boolean z = false;
            if (iArr.length > 0 && iArr[0] == 0) {
                z = true;
            }
            c cVar = (c) PermissionsActivity.b().get(PermissionsActivity.a(PermissionsActivity.this));
            if (cVar == null) {
                throw new RuntimeException("Missing handler for permissionRequestType: " + PermissionsActivity.a(PermissionsActivity.this));
            }
            if (z) {
                cVar.a();
            } else {
                cVar.b(PermissionsActivity.c(PermissionsActivity.this));
            }
        }
    }

    public class b extends a.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Class c;

        public b(String str, String str2, Class cls) {
            this.a = str;
            this.b = str2;
            this.c = cls;
        }

        public void a(Activity activity) {
            if (activity.getClass().equals(PermissionsActivity.class)) {
                return;
            }
            Intent intent = new Intent(activity, PermissionsActivity.class);
            intent.setFlags(131072);
            intent.putExtra("INTENT_EXTRA_PERMISSION_TYPE", this.a).putExtra("INTENT_EXTRA_ANDROID_PERMISSION_STRING", this.b).putExtra("INTENT_EXTRA_CALLBACK_CLASS", this.c.getName());
            activity.startActivity(intent);
            activity.overridePendingTransition(d2.a, d2.b);
        }
    }

    public interface c {
        void a();

        void b(boolean z);
    }

    public static /* synthetic */ String a(PermissionsActivity permissionsActivity) {
        return permissionsActivity.a;
    }

    public static /* synthetic */ HashMap b() {
        return i;
    }

    public static /* synthetic */ boolean c(PermissionsActivity permissionsActivity) {
        return permissionsActivity.h();
    }

    public static void e(String str, c cVar) {
        i.put(str, cVar);
    }

    public static void i(boolean z, String str, String str2, Class cls) {
        if (e) {
            return;
        }
        f = z;
        h = new b(str, str2, cls);
        com.onesignal.a b2 = com.onesignal.b.b();
        if (b2 != null) {
            b2.c(d, h);
        }
    }

    public final void d(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 23) {
            finish();
            overridePendingTransition(d2.a, d2.b);
            return;
        }
        g(bundle);
        this.a = bundle.getString("INTENT_EXTRA_PERMISSION_TYPE");
        String string = bundle.getString("INTENT_EXTRA_ANDROID_PERMISSION_STRING");
        this.c = string;
        f(string);
    }

    public final void f(String str) {
        if (e) {
            return;
        }
        e = true;
        g = true ^ f.b(this, str);
        f.a(this, new String[]{str}, 2);
    }

    public final void g(Bundle bundle) {
        String string = bundle.getString("INTENT_EXTRA_CALLBACK_CLASS");
        try {
            Class.forName(string);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Could not find callback class for PermissionActivity: " + string);
        }
    }

    public final boolean h() {
        return f && g && !f.b(this, this.c);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F1.K0(this);
        d(getIntent().getExtras());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d(intent.getExtras());
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        e = false;
        if (i2 == 2) {
            new Handler().postDelayed(new a(iArr), 500L);
        }
        com.onesignal.a b2 = com.onesignal.b.b();
        if (b2 != null) {
            b2.r(d);
        }
        finish();
        overridePendingTransition(d2.a, d2.b);
    }
}
