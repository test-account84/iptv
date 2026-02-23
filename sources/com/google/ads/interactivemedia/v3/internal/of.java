package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaDrm;
import android.media.metrics.LogSessionId;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class of {
    public static void a(MediaDrm mediaDrm, byte[] bArr, iw iwVar) {
        LogSessionId a = iwVar.a();
        if (d1.a(a, X.a())) {
            return;
        }
        MediaDrm.PlaybackComponent a2 = v1.a(mediaDrm, bArr);
        af.s(a2);
        w1.a(a2, a);
    }

    public static boolean b(MediaDrm mediaDrm, String str) {
        return x1.a(mediaDrm, str);
    }
}
