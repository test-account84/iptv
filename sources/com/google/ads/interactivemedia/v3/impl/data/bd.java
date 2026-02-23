package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bd implements FriendlyObstruction {
    public static bc builder() {
        return new u();
    }

    public abstract String detailedReason();

    public String getDetailedReason() {
        return detailedReason();
    }

    public FriendlyObstructionPurpose getPurpose() {
        return purpose();
    }

    public View getView() {
        return view();
    }

    public abstract FriendlyObstructionPurpose purpose();

    public abstract View view();
}
