package O5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class e {
    public final Float a;
    public final boolean b;

    public e(Float f, boolean z) {
        this.b = z;
        this.a = f;
    }

    public static e a(Context context) {
        boolean z = false;
        Float f = null;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z = e(registerReceiver);
                f = d(registerReceiver);
            }
        } catch (IllegalStateException e) {
            L5.f.f().e("An error occurred getting battery state.", e);
        }
        return new e(f, z);
    }

    public static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }

    public static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    public Float b() {
        return this.a;
    }

    public int c() {
        Float f;
        if (!this.b || (f = this.a) == null) {
            return 1;
        }
        return ((double) f.floatValue()) < 0.99d ? 2 : 3;
    }
}
