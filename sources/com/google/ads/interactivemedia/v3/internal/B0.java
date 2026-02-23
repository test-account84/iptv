package com.google.ads.interactivemedia.v3.internal;

import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackSession;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class b0 {
    public static /* bridge */ /* synthetic */ void a(PlaybackSession playbackSession, NetworkEvent networkEvent) {
        playbackSession.reportNetworkEvent(networkEvent);
    }
}
