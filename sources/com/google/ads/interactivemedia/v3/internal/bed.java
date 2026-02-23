package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bed extends azh {
    private final String a;
    private final bid b;

    public /* synthetic */ bed(String str, bid bidVar) {
        this.a = str;
        this.b = bidVar;
    }

    public final String toString() {
        String str = this.a;
        bid bidVar = this.b;
        bhq bhqVar = bhq.UNKNOWN_KEYMATERIAL;
        bid bidVar2 = bid.UNKNOWN_PREFIX;
        int ordinal = bidVar.ordinal();
        return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{str, ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK"});
    }
}
