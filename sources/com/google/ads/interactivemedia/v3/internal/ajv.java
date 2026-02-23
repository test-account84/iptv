package com.google.ads.interactivemedia.v3.internal;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface ajv {
    void b(aju ajuVar);

    void f(AdError.AdErrorType adErrorType, int i, String str);

    void g(AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str);

    void h(String str);

    void i(ViewGroup viewGroup, CompanionData companionData, String str, CompanionAdSlot companionAdSlot, ajx ajxVar, all allVar);

    void j(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData);

    void k();
}
