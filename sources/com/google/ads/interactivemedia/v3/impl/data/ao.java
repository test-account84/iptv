package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ao extends by {
    private final Integer height;
    private final Integer width;

    public ao(Integer num, Integer num2) {
        if (num == null) {
            throw new NullPointerException("Null width");
        }
        this.width = num;
        if (num2 == null) {
            throw new NullPointerException("Null height");
        }
        this.height = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof by) {
            by byVar = (by) obj;
            if (this.width.equals(byVar.width()) && this.height.equals(byVar.height())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.width.hashCode() ^ 1000003) * 1000003) ^ this.height.hashCode();
    }

    public Integer height() {
        return this.height;
    }

    public String toString() {
        return "SizeData{width=" + this.width + ", height=" + this.height + "}";
    }

    public Integer width() {
        return this.width;
    }
}
