package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public static final b a = new b(new a[0]);
    private static final a d = new a().c();
    private final a[] e;
    public final long c = 0;
    public final int b = 0;

    private b(a[] aVarArr) {
        this.e = aVarArr;
    }

    public final a a(int i) {
        return i < 0 ? d : this.e[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (cq.V(null, null) && Arrays.equals(this.e, bVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) (-9223372036854775807L)) * 961) + Arrays.hashCode(this.e);
    }

    public final String toString() {
        return "AdPlaybackState(adsId=" + ((Object) null) + ", adResumePositionUs=0, adGroups=[])";
    }
}
