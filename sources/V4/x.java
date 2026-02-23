package v4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x {
    public final Context a;
    public int b;
    public int c = 0;

    public x(Context context) {
        this.a = context;
    }

    public final synchronized int a() {
        PackageInfo packageInfo;
        if (this.b == 0) {
            try {
                packageInfo = E4.e.a(this.a).e("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                sb.append("Failed to find package ");
                sb.append(valueOf);
                Log.w("Metadata", sb.toString());
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.b = packageInfo.versionCode;
            }
        }
        return this.b;
    }

    public final synchronized int b() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (E4.e.a(this.a).b("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i2 = 1;
        if (!C4.m.i()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.c = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.c = 2;
            return 2;
        }
        Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
        if (C4.m.i()) {
            this.c = 2;
            i2 = 2;
        } else {
            this.c = 1;
        }
        return i2;
    }
}
