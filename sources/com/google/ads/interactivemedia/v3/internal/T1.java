package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class t1 {
    public static /* bridge */ /* synthetic */ int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, int i2, long j) {
        return audioTrack.write(byteBuffer, i, i2, j);
    }
}
