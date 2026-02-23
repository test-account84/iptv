package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class kg {
    final /* synthetic */ kh a;
    private final Handler b = new Handler(Looper.myLooper());
    private final AudioTrack.StreamEventCallback c = new kf(this);

    public kg(kh khVar) {
        this.a = khVar;
    }

    public final void a(AudioTrack audioTrack) {
        o1.a(audioTrack, new vw(this.b, 1), this.c);
    }

    public final void b(AudioTrack audioTrack) {
        p1.a(audioTrack, this.c);
        this.b.removeCallbacksAndMessages((Object) null);
    }
}
