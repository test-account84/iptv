package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aig implements AdEvent {
    private final AdEvent.AdEventType a;
    private final Ad b;
    private final Map c;

    public aig(AdEvent.AdEventType adEventType, Ad ad, Map map) {
        this.a = adEventType;
        this.b = ad;
        this.c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aig)) {
            return false;
        }
        aig aigVar = (aig) obj;
        return this.a == aigVar.a && com.google.ads.interactivemedia.v3.impl.data.k.c(this.b, aigVar.b) && com.google.ads.interactivemedia.v3.impl.data.k.c(this.c, aigVar.c);
    }

    public final Ad getAd() {
        return this.b;
    }

    public final Map getAdData() {
        return this.c;
    }

    public final AdEvent.AdEventType getType() {
        return this.a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
    }

    public final String toString() {
        String format;
        String format2 = String.format("AdEvent[type=%s, ad=%s", new Object[]{this.a, this.b});
        if (this.c == null) {
            format = "]";
        } else {
            StringBuilder sb = new StringBuilder("{");
            Iterator it = this.c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append((String) entry.getValue());
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            format = String.format(", adData=%s]", new Object[]{sb.toString()});
        }
        return format2.concat(format);
    }
}
