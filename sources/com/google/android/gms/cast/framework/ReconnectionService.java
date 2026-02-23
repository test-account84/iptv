package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.zzaf;
import o4.J;
import t4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ReconnectionService extends Service {
    public static final b c = new b("ReconnectionService");
    public J a;

    public IBinder onBind(Intent intent) {
        J j = this.a;
        if (j != null) {
            try {
                return j.v(intent);
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "onBind", J.class.getSimpleName());
            }
        }
        return null;
    }

    public void onCreate() {
        o4.b e = o4.b.e(this);
        J zzc = zzaf.zzc(this, e.c().f(), e.h().a());
        this.a = zzc;
        if (zzc != null) {
            try {
                zzc.zzg();
            } catch (RemoteException e2) {
                c.b(e2, "Unable to call %s on %s.", "onCreate", J.class.getSimpleName());
            }
            super.onCreate();
        }
    }

    public void onDestroy() {
        J j = this.a;
        if (j != null) {
            try {
                j.zzh();
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "onDestroy", J.class.getSimpleName());
            }
            super.onDestroy();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        J j = this.a;
        if (j != null) {
            try {
                return j.X0(intent, i, i2);
            } catch (RemoteException e) {
                c.b(e, "Unable to call %s on %s.", "onStartCommand", J.class.getSimpleName());
            }
        }
        return 2;
    }
}
