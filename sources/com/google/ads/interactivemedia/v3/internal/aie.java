package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aie extends ajb implements AdDisplayContainer {
    private VideoAdPlayer a;

    public aie(Context context, VideoAdPlayer videoAdPlayer) {
        this(new aix(context), videoAdPlayer);
    }

    public final VideoAdPlayer getPlayer() {
        return this.a;
    }

    public final void setPlayer(VideoAdPlayer videoAdPlayer) {
        atp.k(videoAdPlayer);
        this.a = videoAdPlayer;
    }

    public aie(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
        super(viewGroup);
        this.a = videoAdPlayer;
    }
}
