package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaDrm;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class nw {
    public static int a(Throwable th) {
        return cq.i(cq.j(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
    }

    public static boolean b(Throwable th) {
        return th instanceof MediaDrm.MediaDrmStateException;
    }
}
