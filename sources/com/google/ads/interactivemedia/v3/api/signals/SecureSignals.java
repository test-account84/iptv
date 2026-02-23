package com.google.ads.interactivemedia.v3.api.signals;

import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class SecureSignals {
    private final String a;

    private SecureSignals(String str) {
        this.a = str;
    }

    public static SecureSignals create(String str) {
        return new SecureSignals(str);
    }

    public String getSecureSignal() {
        return this.a;
    }
}
