package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.avo;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class af extends bs {
    private avo obstructions;

    public bv build() {
        avo avoVar = this.obstructions;
        if (avoVar != null) {
            return new ah(avoVar, null);
        }
        throw new IllegalStateException("Missing required properties: obstructions");
    }

    public bs obstructions(List list) {
        this.obstructions = avo.m(list);
        return this;
    }
}
