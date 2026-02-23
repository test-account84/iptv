package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class aqa {
    protected apx a;

    @Deprecated
    public final Uri a(Uri uri, Context context) throws aqb, RemoteException {
        aro d = this.a.d(arp.c(uri), arp.c(context));
        if (d != null) {
            return (Uri) arp.d(d);
        }
        throw new aqb();
    }

    @Deprecated
    public final String b(Context context) throws RemoteException {
        return this.a.g(arp.c(context), null);
    }

    @Deprecated
    public final boolean c(Uri uri) throws RemoteException {
        return this.a.q(arp.c(uri));
    }
}
