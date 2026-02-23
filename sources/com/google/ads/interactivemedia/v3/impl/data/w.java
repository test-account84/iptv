package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class w extends bd {
    private final String detailedReason;
    private final FriendlyObstructionPurpose purpose;
    private final View view;

    private w(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.view = view;
        this.purpose = friendlyObstructionPurpose;
        this.detailedReason = str;
    }

    public String detailedReason() {
        return this.detailedReason;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bd) {
            bd bdVar = (bd) obj;
            if (this.view.equals(bdVar.view()) && this.purpose.equals(bdVar.purpose())) {
                String str = this.detailedReason;
                String detailedReason = bdVar.detailedReason();
                if (str != null ? str.equals(detailedReason) : detailedReason == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.view.hashCode() ^ 1000003) * 1000003) ^ this.purpose.hashCode()) * 1000003;
        String str = this.detailedReason;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public FriendlyObstructionPurpose purpose() {
        return this.purpose;
    }

    public String toString() {
        return "FriendlyObstructionImpl{view=" + String.valueOf(this.view) + ", purpose=" + String.valueOf(this.purpose) + ", detailedReason=" + this.detailedReason + "}";
    }

    public View view() {
        return this.view;
    }

    public /* synthetic */ w(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str, v vVar) {
        this(view, friendlyObstructionPurpose, str);
    }
}
