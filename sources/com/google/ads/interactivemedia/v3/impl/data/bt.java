package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bt {
    public abstract bt attached(boolean z);

    public abstract bt bounds(ay ayVar);

    public abstract bu build();

    public abstract bt detailedReason(String str);

    public abstract bt hidden(boolean z);

    public abstract bt purpose(FriendlyObstructionPurpose friendlyObstructionPurpose);

    public abstract bt type(String str);

    public bt view(View view) {
        return attached(view.isAttachedToWindow()).bounds(ay.builder().locationOnScreenOfView(view).build()).hidden(!view.isShown()).type(view.getClass().getCanonicalName());
    }
}
