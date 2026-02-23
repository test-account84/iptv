package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aju {
    public final AdEvent.AdEventType a;
    public final com.google.ads.interactivemedia.v3.impl.data.c b;
    public Map c;
    public List d = new ArrayList();
    AdProgressInfo e;
    public double f;

    public aju(AdEvent.AdEventType adEventType, com.google.ads.interactivemedia.v3.impl.data.c cVar) {
        this.a = adEventType;
        this.b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return bur.c(this, obj, new String[0]);
    }

    public final int hashCode() {
        return but.a(this, new String[0]);
    }
}
