package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.a;
import com.google.android.gms.internal.play_billing.zzb;
import g1.Q;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public static Q a(Bundle bundle, String str, String str2) {
        a aVar = b.j;
        if (bundle == null) {
            zzb.zzk("BillingClient", String.format("%s got null owned items list", new Object[]{str2}));
            return new Q(aVar, 54);
        }
        int zzb = zzb.zzb(bundle, "BillingClient");
        String zzg = zzb.zzg(bundle, "BillingClient");
        a.a c = a.c();
        c.c(zzb);
        c.b(zzg);
        a a = c.a();
        if (zzb != 0) {
            zzb.zzk("BillingClient", String.format("%s failed. Response code: %s", new Object[]{str2, Integer.valueOf(zzb)}));
            return new Q(a, 23);
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            zzb.zzk("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", new Object[]{str2}));
            return new Q(aVar, 55);
        }
        ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", new Object[]{str2}));
            return new Q(aVar, 56);
        }
        if (stringArrayList2 == null) {
            zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null purchases list.", new Object[]{str2}));
            return new Q(aVar, 57);
        }
        if (stringArrayList3 != null) {
            return new Q(b.l, 1);
        }
        zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null signatures list.", new Object[]{str2}));
        return new Q(aVar, 58);
    }
}
