package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public enum zzgo implements zzcu {
    BROADCAST_ACTION_UNSPECIFIED(0),
    PURCHASES_UPDATED_ACTION(1),
    LOCAL_PURCHASES_UPDATED_ACTION(2),
    ALTERNATIVE_BILLING_ACTION(3);

    private static final zzcv zze = new zzgm();
    private final int zzg;

    zzgo(int i) {
        this.zzg = i;
    }

    public final String toString() {
        return Integer.toString(this.zzg);
    }
}
