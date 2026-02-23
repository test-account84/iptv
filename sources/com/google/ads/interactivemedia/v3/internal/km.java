package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class km implements jm {
    final /* synthetic */ kn a;

    public /* synthetic */ km(kn knVar) {
        this.a = knVar;
    }

    public final void a(Exception exc) {
        cd.c("MediaCodecAudioRenderer", "Audio sink error", exc);
        kn.U(this.a).b(exc);
    }

    public final void b() {
        kn knVar = this.a;
        if (kn.T(knVar) != null) {
            kn.T(knVar).b();
        }
    }
}
