package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class an extends bx {
    private final int major;
    private final int micro;
    private final int minor;

    public an(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.micro = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bx) {
            bx bxVar = (bx) obj;
            if (this.major == bxVar.major() && this.minor == bxVar.minor() && this.micro == bxVar.micro()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.major ^ 1000003) * 1000003) ^ this.minor) * 1000003) ^ this.micro;
    }

    public int major() {
        return this.major;
    }

    public int micro() {
        return this.micro;
    }

    public int minor() {
        return this.minor;
    }

    public String toString() {
        return "SecureSignalsVersionData{major=" + this.major + ", minor=" + this.minor + ", micro=" + this.micro + "}";
    }
}
