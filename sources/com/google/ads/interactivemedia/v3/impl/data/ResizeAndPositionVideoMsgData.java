package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = al.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ResizeAndPositionVideoMsgData {
    public static ResizeAndPositionVideoMsgData create(Integer num, Integer num2, Integer num3, Integer num4) {
        return new al(num, num2, num3, num4);
    }

    public abstract Integer height();

    public final String toString() {
        return "ResizeAndPositionVideoMsgData [x=" + x() + ", y=" + y() + ", width=" + width() + ", height=" + height() + "]";
    }

    public abstract Integer width();

    public abstract Integer x();

    public abstract Integer y();
}
