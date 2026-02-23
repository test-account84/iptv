package com.google.ads.interactivemedia.v3.internal;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class cf extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    private final ch a;

    public cf(ch chVar) {
        this.a = chVar;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int a = H.a(telephonyDisplayInfo);
        ch.c(this.a, true == (a == 3 || a == 4 || a == 5) ? 10 : 5);
    }
}
