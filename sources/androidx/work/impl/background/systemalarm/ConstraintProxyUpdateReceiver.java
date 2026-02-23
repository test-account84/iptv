package androidx.work.impl.background.systemalarm;

import Q0.k;
import R0.j;
import a1.g;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final String a = k.f("ConstrntProxyUpdtRecvr");

    public class a implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Context c;
        public final /* synthetic */ BroadcastReceiver.PendingResult d;

        public a(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.a = intent;
            this.c = context;
            this.d = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                k.c().a(ConstraintProxyUpdateReceiver.a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)}), new Throwable[0]);
                g.a(this.c, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                g.a(this.c, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                g.a(this.c, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                g.a(this.c, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.d.finish();
            }
        }
    }

    public static Intent a(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
        return intent;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            j.m(context).r().b(new a(intent, context, goAsync()));
        } else {
            k.c().a(a, String.format("Ignoring unknown action %s", new Object[]{action}), new Throwable[0]);
        }
    }
}
