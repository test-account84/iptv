package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class b1 {
    public static /* bridge */ /* synthetic */ boolean a(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        return AudioTrack.isDirectPlaybackSupported(audioFormat, audioAttributes);
    }
}
