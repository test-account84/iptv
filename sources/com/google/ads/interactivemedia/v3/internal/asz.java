package com.google.ads.interactivemedia.v3.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asz {
    final /* synthetic */ ata a;
    private final byte[] b;
    private int c;
    private int d;

    public /* synthetic */ asz(ata ataVar, byte[] bArr) {
        this.a = ataVar;
        this.b = bArr;
    }

    public final synchronized void a() {
        try {
            ata ataVar = this.a;
            if (ataVar.b) {
                ataVar.a.h(this.b);
                this.a.a.g(this.c);
                this.a.a.f(this.d);
                this.a.a.j();
                this.a.a.e();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }

    public final void b(int i) {
        this.d = i;
    }

    public final void c(int i) {
        this.c = i;
    }
}
