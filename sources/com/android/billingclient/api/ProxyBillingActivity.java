package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;

@UsedByReflection("PlatformActivityProxy")
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ProxyBillingActivity extends Activity {
    public ResultReceiver a;
    public ResultReceiver c;
    public boolean d;
    public boolean e;

    public final Intent a(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    public final Intent b() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            super.onActivityResult(r8, r9, r10)
            r0 = 100
            r1 = 0
            r2 = 0
            r3 = 110(0x6e, float:1.54E-43)
            java.lang.String r4 = "ProxyBillingActivity"
            if (r8 == r0) goto L43
            if (r8 != r3) goto L10
            goto L43
        L10:
            r9 = 101(0x65, float:1.42E-43)
            if (r8 != r9) goto L28
            int r8 = com.google.android.gms.internal.play_billing.zzb.zza(r10, r4)
            android.os.ResultReceiver r9 = r7.c
            if (r9 == 0) goto Lef
            if (r10 != 0) goto L1f
            goto L23
        L1f:
            android.os.Bundle r2 = r10.getExtras()
        L23:
            r9.send(r8, r2)
            goto Lef
        L28:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Got onActivityResult with wrong requestCode: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = "; skipping..."
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.google.android.gms.internal.play_billing.zzb.zzk(r4, r8)
            goto Lef
        L43:
            com.android.billingclient.api.a r0 = com.google.android.gms.internal.play_billing.zzb.zze(r10, r4)
            int r0 = r0.b()
            r5 = -1
            if (r9 != r5) goto L54
            if (r0 == 0) goto L52
            r9 = -1
            goto L54
        L52:
            r0 = 0
            goto L70
        L54:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Activity finished with resultCode "
            r5.append(r6)
            r5.append(r9)
            java.lang.String r9 = " and billing's responseCode: "
            r5.append(r9)
            r5.append(r0)
            java.lang.String r9 = r5.toString()
            com.google.android.gms.internal.play_billing.zzb.zzk(r4, r9)
        L70:
            android.os.ResultReceiver r9 = r7.a
            if (r9 == 0) goto L7f
            if (r10 != 0) goto L77
            goto L7b
        L77:
            android.os.Bundle r2 = r10.getExtras()
        L7b:
            r9.send(r0, r2)
            goto Lef
        L7f:
            if (r10 == 0) goto Le0
            android.os.Bundle r9 = r10.getExtras()
            java.lang.String r0 = "LAUNCH_BILLING_FLOW"
            java.lang.String r2 = "INTENT_SOURCE"
            if (r9 == 0) goto Lab
            android.os.Bundle r9 = r10.getExtras()
            java.lang.String r4 = "ALTERNATIVE_BILLING_USER_CHOICE_DATA"
            java.lang.String r9 = r9.getString(r4)
            if (r9 == 0) goto L9f
            android.content.Intent r9 = r7.a(r9)
        L9b:
            r9.putExtra(r2, r0)
            goto Le4
        L9f:
            android.content.Intent r9 = r7.b()
            android.os.Bundle r10 = r10.getExtras()
            r9.putExtras(r10)
            goto L9b
        Lab:
            android.content.Intent r9 = r7.b()
            java.lang.String r10 = "Got null bundle!"
            com.google.android.gms.internal.play_billing.zzb.zzk(r4, r10)
            java.lang.String r10 = "RESPONSE_CODE"
            r4 = 6
            r9.putExtra(r10, r4)
            java.lang.String r10 = "DEBUG_MESSAGE"
            java.lang.String r5 = "An internal error occurred."
            r9.putExtra(r10, r5)
            com.android.billingclient.api.a$a r10 = com.android.billingclient.api.a.c()
            r10.c(r4)
            r10.b(r5)
            com.android.billingclient.api.a r10 = r10.a()
            r4 = 22
            r5 = 2
            com.google.android.gms.internal.play_billing.zzga r10 = g1.E.a(r4, r5, r10)
            byte[] r10 = r10.zzc()
            java.lang.String r4 = "FAILURE_LOGGING_PAYLOAD"
            r9.putExtra(r4, r10)
            goto L9b
        Le0:
            android.content.Intent r9 = r7.b()
        Le4:
            if (r8 != r3) goto Lec
            java.lang.String r8 = "IS_FIRST_PARTY_PURCHASE"
            r10 = 1
            r9.putExtra(r8, r10)
        Lec:
            r7.sendBroadcast(r9)
        Lef:
            r7.d = r1
            r7.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        int i;
        super.onCreate(bundle);
        if (bundle != null) {
            zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.d = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.a = bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.c = bundle.getParcelable("in_app_message_result_receiver");
            }
            this.e = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            return;
        }
        zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow");
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.e = true;
                i = 110;
            } else {
                i = 100;
            }
        } else {
            if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.a = getIntent().getParcelableExtra("result_receiver");
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.c = getIntent().getParcelableExtra("in_app_message_result_receiver");
                i = 101;
            } else {
                pendingIntent = null;
            }
            i = 100;
        }
        try {
            this.d = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            zzb.zzl("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e);
            ResultReceiver resultReceiver = this.a;
            if (resultReceiver != null) {
                resultReceiver.send(6, (Bundle) null);
            } else {
                ResultReceiver resultReceiver2 = this.c;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, (Bundle) null);
                } else {
                    Intent b = b();
                    if (this.e) {
                        b.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    b.putExtra("RESPONSE_CODE", 6);
                    b.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(b);
                }
            }
            this.d = false;
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.d) {
            Intent b = b();
            b.putExtra("RESPONSE_CODE", 1);
            b.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(b);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.a;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.c;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.d);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.e);
    }
}
