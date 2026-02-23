package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class p1 {
    public static /* bridge */ /* synthetic */ void a(AudioTrack audioTrack, AudioTrack.StreamEventCallback streamEventCallback) {
        audioTrack.unregisterStreamEventCallback(streamEventCallback);
    }
}
