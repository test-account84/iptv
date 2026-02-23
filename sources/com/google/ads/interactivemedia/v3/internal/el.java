package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioManager;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class el implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ en a;
    private final Handler b;

    public el(en enVar, Handler handler) {
        this.a = enVar;
        this.b = handler;
    }

    public final void onAudioFocusChange(int i) {
        this.b.post(new ek(this, i));
    }
}
