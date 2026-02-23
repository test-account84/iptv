package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.avo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ah extends bv {
    private final avo obstructions;

    private ah(avo avoVar) {
        this.obstructions = avoVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bv) {
            return this.obstructions.equals(((bv) obj).obstructions());
        }
        return false;
    }

    public int hashCode() {
        return this.obstructions.hashCode() ^ 1000003;
    }

    public avo obstructions() {
        return this.obstructions;
    }

    public String toString() {
        return "ObstructionListData{obstructions=" + String.valueOf(this.obstructions) + "}";
    }

    public /* synthetic */ ah(avo avoVar, ag agVar) {
        this(avoVar);
    }
}
