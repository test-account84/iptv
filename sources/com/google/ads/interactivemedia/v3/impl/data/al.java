package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class al extends ResizeAndPositionVideoMsgData {
    private final Integer height;
    private final Integer width;
    private final Integer x;
    private final Integer y;

    public al(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            throw new NullPointerException("Null x");
        }
        this.x = num;
        if (num2 == null) {
            throw new NullPointerException("Null y");
        }
        this.y = num2;
        if (num3 == null) {
            throw new NullPointerException("Null width");
        }
        this.width = num3;
        if (num4 == null) {
            throw new NullPointerException("Null height");
        }
        this.height = num4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ResizeAndPositionVideoMsgData) {
            ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData = (ResizeAndPositionVideoMsgData) obj;
            if (this.x.equals(resizeAndPositionVideoMsgData.x()) && this.y.equals(resizeAndPositionVideoMsgData.y()) && this.width.equals(resizeAndPositionVideoMsgData.width()) && this.height.equals(resizeAndPositionVideoMsgData.height())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.x.hashCode() ^ 1000003) * 1000003) ^ this.y.hashCode()) * 1000003) ^ this.width.hashCode()) * 1000003) ^ this.height.hashCode();
    }

    public Integer height() {
        return this.height;
    }

    public Integer width() {
        return this.width;
    }

    public Integer x() {
        return this.x;
    }

    public Integer y() {
        return this.y;
    }
}
