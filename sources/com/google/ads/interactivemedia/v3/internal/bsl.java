package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsl extends bst {
    public bsl(int i) {
        super(i);
    }

    public final void a() {
        if (!j()) {
            for (int i = 0; i < b(); i++) {
                Map.Entry g = g(i);
                if (((bqd) g.getKey()).e()) {
                    g.setValue(Collections.unmodifiableList((List) g.getValue()));
                }
            }
            for (Map.Entry entry : d()) {
                if (((bqd) entry.getKey()).e()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
