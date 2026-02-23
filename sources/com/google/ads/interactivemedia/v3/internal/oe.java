package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaDrm;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class oe implements MediaDrm.OnEventListener {
    public final /* synthetic */ og a;
    public final /* synthetic */ oa b;

    public /* synthetic */ oe(og ogVar, oa oaVar) {
        this.a = ogVar;
        this.b = oaVar;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        nb nbVar = ((na) this.b).a.a;
        af.s(nbVar);
        nbVar.obtainMessage(i, bArr).sendToTarget();
    }
}
