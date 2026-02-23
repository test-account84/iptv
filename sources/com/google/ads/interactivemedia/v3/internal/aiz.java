package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aiz extends aku {
    private final String TXXX;

    public aiz(String str) {
        if (str == null) {
            throw new NullPointerException("Null TXXX");
        }
        this.TXXX = str;
    }

    public String TXXX() {
        return this.TXXX;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aku) {
            return this.TXXX.equals(((aku) obj).TXXX());
        }
        return false;
    }

    public int hashCode() {
        return this.TXXX.hashCode() ^ 1000003;
    }

    public String toString() {
        return "TimedMetadataWithKeys{TXXX=" + this.TXXX + "}";
    }
}
