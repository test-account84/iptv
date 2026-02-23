package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class kf extends AudioTrack.StreamEventCallback {
    final /* synthetic */ kg a;

    public kf(kg kgVar) {
        this.a = kgVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        if (audioTrack.equals(kh.C(this.a.a))) {
            kh khVar = this.a.a;
            if (kh.D(khVar) == null || !kh.E(khVar)) {
                return;
            }
            kh.D(khVar).b();
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        if (audioTrack.equals(kh.C(this.a.a))) {
            kh khVar = this.a.a;
            if (kh.D(khVar) == null || !kh.E(khVar)) {
                return;
            }
            kh.D(khVar).b();
        }
    }
}
