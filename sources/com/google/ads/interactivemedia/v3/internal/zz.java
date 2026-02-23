package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zz {
    public final aac a;
    public final aac b;

    public zz(aac aacVar, aac aacVar2) {
        this.a = aacVar;
        this.b = aacVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zz.class == obj.getClass()) {
            zz zzVar = (zz) obj;
            if (this.a.equals(zzVar.a) && this.b.equals(zzVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "[" + String.valueOf(this.a) + (this.a.equals(this.b) ? "" : ", ".concat(String.valueOf(this.b))) + "]";
    }
}
