package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f0 implements ServiceConnection {
    public final int a;
    public final /* synthetic */ c c;

    public f0(c cVar, int i) {
        this.c = cVar;
        this.a = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c cVar = this.c;
        if (iBinder == null) {
            c.zzk(cVar, 16);
            return;
        }
        synchronized (c.zzd(cVar)) {
            try {
                c cVar2 = this.c;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                c.zzh(cVar2, (queryLocalInterface == null || !(queryLocalInterface instanceof n)) ? new V(iBinder) : (n) queryLocalInterface);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.c.zzl(0, null, this.a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (c.zzd(this.c)) {
            c.zzh(this.c, null);
        }
        c cVar = this.c;
        int i = this.a;
        Handler handler = cVar.zzb;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
