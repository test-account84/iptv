package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ajj {
    private final List a = new ArrayList(1);

    public final void a(AdErrorEvent.AdErrorListener adErrorListener) {
        this.a.add(adErrorListener);
    }

    public final void b() {
        this.a.clear();
    }

    public final void c(AdErrorEvent adErrorEvent) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((AdErrorEvent.AdErrorListener) it.next()).onAdError(adErrorEvent);
        }
    }

    public final void d(AdErrorEvent.AdErrorListener adErrorListener) {
        this.a.remove(adErrorListener);
    }

    public final String toString() {
        return "ErrorListenerSupport [errorListeners=" + this.a.toString() + "]";
    }
}
