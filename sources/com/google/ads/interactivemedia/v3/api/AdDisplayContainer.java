package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface AdDisplayContainer extends BaseDisplayContainer {
    VideoAdPlayer getPlayer();

    @Deprecated
    void setPlayer(VideoAdPlayer videoAdPlayer);
}
