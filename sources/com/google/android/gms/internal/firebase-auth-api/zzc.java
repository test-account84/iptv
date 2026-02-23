package com.google.android.gms.internal.firebase-auth-api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import g1.T;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzc extends E.b {
    @Deprecated
    public static Intent zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (zza.zza()) {
            return T.a(context, broadcastReceiver, intentFilter, zza.zza() ? 2 : 0);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
