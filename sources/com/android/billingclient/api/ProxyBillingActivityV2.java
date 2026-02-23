package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.e;
import b.d;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;
import g1.N;
import g1.O;

@UsedByReflection("PlatformActivityProxy")
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ProxyBillingActivityV2 extends ComponentActivity {
    public androidx.activity.result.c a;
    public androidx.activity.result.c c;
    public ResultReceiver d;
    public ResultReceiver e;

    public final void f1(androidx.activity.result.a aVar) {
        Intent a = aVar.a();
        int b = zzb.zze(a, "ProxyBillingActivityV2").b();
        ResultReceiver resultReceiver = this.d;
        if (resultReceiver != null) {
            resultReceiver.send(b, a == null ? null : a.getExtras());
        }
        if (aVar.c() != -1 || b != 0) {
            zzb.zzk("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + aVar.c() + " and billing's responseCode: " + b);
        }
        finish();
    }

    public final void g1(androidx.activity.result.a aVar) {
        Intent a = aVar.a();
        int b = zzb.zze(a, "ProxyBillingActivityV2").b();
        ResultReceiver resultReceiver = this.e;
        if (resultReceiver != null) {
            resultReceiver.send(b, a == null ? null : a.getExtras());
        }
        if (aVar.c() != -1 || b != 0) {
            zzb.zzk("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", new Object[]{Integer.valueOf(aVar.c()), Integer.valueOf(b)}));
        }
        finish();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = registerForActivityResult(new d(), new N(this));
        this.c = registerForActivityResult(new d(), new O(this));
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.d = bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            } else {
                if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                    this.e = bundle.getParcelable("external_payment_dialog_result_receiver");
                    return;
                }
                return;
            }
        }
        zzb.zzj("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent parcelableExtra = getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.d = getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.a.a(new e.b(parcelableExtra).a());
        } else if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent parcelableExtra2 = getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.e = getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            this.c.a(new e.b(parcelableExtra2).a());
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.d;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.e;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }
}
