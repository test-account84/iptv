package com.google.ads.interactivemedia.v3.api;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Hide;
import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface BaseDisplayContainer {
    @Hide
    void claim();

    @Deprecated
    void destroy();

    ViewGroup getAdContainer();

    Collection getCompanionSlots();

    void registerFriendlyObstruction(FriendlyObstruction friendlyObstruction);

    @Deprecated
    void registerVideoControlsOverlay(View view);

    @Deprecated
    void setAdContainer(ViewGroup viewGroup);

    void setCompanionSlots(Collection collection);

    void unregisterAllFriendlyObstructions();

    @Deprecated
    void unregisterAllVideoControlsOverlays();
}
