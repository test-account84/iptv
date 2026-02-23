package u0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h0 extends BroadcastReceiver {
    public static boolean a(Context context) {
        Intent intent = new Intent(context, h0.class);
        intent.setPackage(context.getPackageName());
        return context.getPackageManager().queryBroadcastReceivers(intent, 0).size() > 0;
    }
}
