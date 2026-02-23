package g1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzcd;
import com.google.android.gms.internal.play_billing.zzga;
import j$.util.Objects;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class V extends BroadcastReceiver {
    public boolean a;
    public final boolean b;
    public final /* synthetic */ W c;

    public V(W w, boolean z) {
        this.c = w;
        this.b = z;
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                T.a(context, this, intentFilter, true != this.b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context, IntentFilter intentFilter, String str) {
        try {
            if (this.a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                U.a(context, this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", (Handler) null);
            }
            this.a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(Context context) {
        if (!this.a) {
            zzb.zzk("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.a = false;
        }
    }

    public final void d(Bundle bundle, com.android.billingclient.api.a aVar, int i) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            W.b(this.c).e(E.a(23, i, aVar));
            return;
        }
        try {
            W.b(this.c).e(zzga.zzA(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzcd.zza()));
        } catch (Throwable unused) {
            zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            F b = W.b(this.c);
            com.android.billingclient.api.a aVar = com.android.billingclient.api.b.j;
            b.e(E.a(11, 1, aVar));
            W w = this.c;
            if (W.c(w) != null) {
                W.c(w).e(aVar, null);
                return;
            }
            return;
        }
        com.android.billingclient.api.a zze = zzb.zze(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        int i = true == Objects.equals(extras.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW") ? 2 : 1;
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List zzi = zzb.zzi(extras);
            if (zze.b() == 0) {
                W.b(this.c).b(E.c(i));
            } else {
                d(extras, zze, i);
            }
            W.c(this.c).e(zze, zzi);
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            if (zze.b() != 0) {
                d(extras, zze, i);
                W.c(this.c).e(zze, zzai.zzk());
                return;
            }
            W w2 = this.c;
            W.a(w2);
            W.e(w2);
            zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
            F b2 = W.b(this.c);
            com.android.billingclient.api.a aVar2 = com.android.billingclient.api.b.j;
            b2.e(E.a(77, i, aVar2));
            W.c(this.c).e(aVar2, zzai.zzk());
        }
    }
}
