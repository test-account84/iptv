package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = ak.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bu {
    public static bt builder() {
        return new ai();
    }

    public abstract boolean attached();

    public abstract ay bounds();

    public abstract String detailedReason();

    public abstract boolean hidden();

    public abstract FriendlyObstructionPurpose purpose();

    public abstract String type();
}
