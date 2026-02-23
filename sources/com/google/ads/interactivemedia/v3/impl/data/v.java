package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class v {
    public static boolean a(BaseDisplayContainer baseDisplayContainer, ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        return resizeAndPositionVideoMsgData.x().intValue() >= 0 && resizeAndPositionVideoMsgData.width().intValue() >= 0 && resizeAndPositionVideoMsgData.x().intValue() + resizeAndPositionVideoMsgData.width().intValue() <= baseDisplayContainer.getAdContainer().getWidth() && resizeAndPositionVideoMsgData.y().intValue() >= 0 && resizeAndPositionVideoMsgData.height().intValue() >= 0 && resizeAndPositionVideoMsgData.y().intValue() + resizeAndPositionVideoMsgData.height().intValue() <= baseDisplayContainer.getAdContainer().getHeight();
    }
}
