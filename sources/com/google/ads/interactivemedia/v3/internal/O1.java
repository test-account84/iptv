package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class o1 {
    public static /* bridge */ /* synthetic */ void a(AudioTrack audioTrack, Executor executor, AudioTrack.StreamEventCallback streamEventCallback) {
        audioTrack.registerStreamEventCallback(executor, streamEventCallback);
    }
}
