package com.google.ads.interactivemedia.v3.internal;

import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bkb extends bjy {
    private final blj a = new blj(null);

    public final Set a() {
        return this.a.entrySet();
    }

    public final void b(String str, bjy bjyVar) {
        this.a.put(str, bjyVar);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof bkb) && ((bkb) obj).a.equals(this.a);
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
