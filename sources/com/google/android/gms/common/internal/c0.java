package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.common.zzi;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 extends zzi {
    public final /* synthetic */ c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(c cVar, Looper looper) {
        super(looper);
        this.a = cVar;
    }

    public static final void a(Message message) {
        d0 d0Var = (d0) message.obj;
        d0Var.b();
        d0Var.e();
    }

    public static final boolean b(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    public final void handleMessage(Message message) {
        if (this.a.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || ((i == 4 && !this.a.enableLocalFallback()) || message.what == 5)) && !this.a.isConnecting()) {
            a(message);
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            c.zzg(this.a, new w4.b(message.arg2));
            if (c.zzo(this.a)) {
                c cVar = this.a;
                if (!c.zzm(cVar)) {
                    c.zzi(cVar, 3, null);
                    return;
                }
            }
            c cVar2 = this.a;
            w4.b zza = c.zza(cVar2) != null ? c.zza(cVar2) : new w4.b(8);
            this.a.zzc.c(zza);
            this.a.onConnectionFailed(zza);
            return;
        }
        if (i2 == 5) {
            c cVar3 = this.a;
            w4.b zza2 = c.zza(cVar3) != null ? c.zza(cVar3) : new w4.b(8);
            this.a.zzc.c(zza2);
            this.a.onConnectionFailed(zza2);
            return;
        }
        if (i2 == 3) {
            Object obj = message.obj;
            w4.b bVar = new w4.b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.a.zzc.c(bVar);
            this.a.onConnectionFailed(bVar);
            return;
        }
        if (i2 == 6) {
            c.zzi(this.a, 5, null);
            c cVar4 = this.a;
            if (c.zzb(cVar4) != null) {
                c.zzb(cVar4).onConnectionSuspended(message.arg2);
            }
            this.a.onConnectionSuspended(message.arg2);
            c.zzn(this.a, 5, 1, null);
            return;
        }
        if (i2 == 2 && !this.a.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((d0) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
