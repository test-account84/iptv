package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class C1 {
    public static /* bridge */ /* synthetic */ void a(MediaCodec mediaCodec, MediaCodec.Callback callback, Handler handler) {
        mediaCodec.setCallback(callback, handler);
    }
}
