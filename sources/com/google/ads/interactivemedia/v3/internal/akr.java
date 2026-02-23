package com.google.ads.interactivemedia.v3.internal;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class akr extends ajb implements StreamDisplayContainer {
    private VideoStreamPlayer a;

    public akr(ViewGroup viewGroup, VideoStreamPlayer videoStreamPlayer) {
        super(viewGroup);
        this.a = videoStreamPlayer;
    }

    public final VideoStreamPlayer getVideoStreamPlayer() {
        return this.a;
    }

    public final void setVideoStreamPlayer(VideoStreamPlayer videoStreamPlayer) {
        atp.k(videoStreamPlayer);
        this.a = videoStreamPlayer;
    }
}
