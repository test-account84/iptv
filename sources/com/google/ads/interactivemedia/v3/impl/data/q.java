package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class q extends ay {
    private final int height;
    private final int left;
    private final int top;
    private final int width;

    private q(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.height = i3;
        this.width = i4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ay) {
            ay ayVar = (ay) obj;
            if (this.left == ayVar.left() && this.top == ayVar.top() && this.height == ayVar.height() && this.width == ayVar.width()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.left ^ 1000003) * 1000003) ^ this.top) * 1000003) ^ this.height) * 1000003) ^ this.width;
    }

    public int height() {
        return this.height;
    }

    public int left() {
        return this.left;
    }

    public String toString() {
        return "BoundingRectData{left=" + this.left + ", top=" + this.top + ", height=" + this.height + ", width=" + this.width + "}";
    }

    public int top() {
        return this.top;
    }

    public int width() {
        return this.width;
    }

    public /* synthetic */ q(int i, int i2, int i3, int i4, p pVar) {
        this(i, i2, i3, i4);
    }
}
