package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class u implements bc {
    private String detailedReason;
    private FriendlyObstructionPurpose purpose;
    private View view;

    public bd build() {
        FriendlyObstructionPurpose friendlyObstructionPurpose;
        View view = this.view;
        if (view != null && (friendlyObstructionPurpose = this.purpose) != null) {
            return new w(view, friendlyObstructionPurpose, this.detailedReason, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.view == null) {
            sb.append(" view");
        }
        if (this.purpose == null) {
            sb.append(" purpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public bc detailedReason(String str) {
        this.detailedReason = str;
        return this;
    }

    public bc purpose(FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (friendlyObstructionPurpose == null) {
            throw new NullPointerException("Null purpose");
        }
        this.purpose = friendlyObstructionPurpose;
        return this;
    }

    public bc view(View view) {
        if (view == null) {
            throw new NullPointerException("Null view");
        }
        this.view = view;
        return this;
    }
}
