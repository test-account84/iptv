package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g0 extends S {
    public final IBinder g;
    public final /* synthetic */ c h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(c cVar, int i, IBinder iBinder, Bundle bundle) {
        super(cVar, i, bundle);
        this.h = cVar;
        this.g = iBinder;
    }

    public final void f(w4.b bVar) {
        if (c.zzc(this.h) != null) {
            c.zzc(this.h).onConnectionFailed(bVar);
        }
        this.h.onConnectionFailed(bVar);
    }

    public final boolean g() {
        String str;
        String interfaceDescriptor;
        try {
            IBinder iBinder = this.g;
            r.m(iBinder);
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
        } catch (RemoteException unused) {
            str = "service probably died";
        }
        if (!this.h.getServiceDescriptor().equals(interfaceDescriptor)) {
            str = "service descriptor mismatch: " + this.h.getServiceDescriptor() + " vs. " + interfaceDescriptor;
            Log.w("GmsClient", str);
            return false;
        }
        IInterface createServiceInterface = this.h.createServiceInterface(this.g);
        if (createServiceInterface == null || !(c.zzn(this.h, 2, 4, createServiceInterface) || c.zzn(this.h, 3, 4, createServiceInterface))) {
            return false;
        }
        c.zzg(this.h, null);
        c cVar = this.h;
        Bundle connectionHint = cVar.getConnectionHint();
        if (c.zzb(cVar) == null) {
            return true;
        }
        c.zzb(this.h).onConnected(connectionHint);
        return true;
    }
}
