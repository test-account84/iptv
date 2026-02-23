package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ata {

    @VisibleForTesting
    final atd a;

    @VisibleForTesting
    final boolean b;

    private ata(atd atdVar) {
        this.a = atdVar;
        this.b = atdVar != null;
    }

    public static ata b() {
        atc atcVar = new atc(null);
        Log.d("GASS", "Clearcut logging disabled");
        return new ata(atcVar);
    }

    public static ata c(Context context, String str) {
        try {
            try {
                try {
                    atd b = atc.b(DynamiteModule.e(context, DynamiteModule.b, "com.google.android.gms.ads.dynamite").d("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger"));
                    b.i(arp.c(context), str);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new ata(b);
                } catch (Exception e) {
                    throw new asi(e);
                }
            } catch (asi | RemoteException | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new ata(new atc(null));
            }
        } catch (Exception e2) {
            throw new asi(e2);
        }
    }

    public final asz a(byte[] bArr) {
        return new asz(this, bArr);
    }
}
