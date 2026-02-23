package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ai extends bt {
    private boolean attached;
    private ay bounds;
    private String detailedReason;
    private boolean hidden;
    private FriendlyObstructionPurpose purpose;
    private byte set$0;
    private String type;

    public bt attached(boolean z) {
        this.attached = z;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    public bt bounds(ay ayVar) {
        if (ayVar == null) {
            throw new NullPointerException("Null bounds");
        }
        this.bounds = ayVar;
        return this;
    }

    public bu build() {
        ay ayVar;
        FriendlyObstructionPurpose friendlyObstructionPurpose;
        String str;
        if (this.set$0 == 3 && (ayVar = this.bounds) != null && (friendlyObstructionPurpose = this.purpose) != null && (str = this.type) != null) {
            return new ak(this.attached, ayVar, this.detailedReason, this.hidden, friendlyObstructionPurpose, str, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" attached");
        }
        if (this.bounds == null) {
            sb.append(" bounds");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" hidden");
        }
        if (this.purpose == null) {
            sb.append(" purpose");
        }
        if (this.type == null) {
            sb.append(" type");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public bt detailedReason(String str) {
        this.detailedReason = str;
        return this;
    }

    public bt hidden(boolean z) {
        this.hidden = z;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    public bt purpose(FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (friendlyObstructionPurpose == null) {
            throw new NullPointerException("Null purpose");
        }
        this.purpose = friendlyObstructionPurpose;
        return this;
    }

    public bt type(String str) {
        if (str == null) {
            throw new NullPointerException("Null type");
        }
        this.type = str;
        return this;
    }
}
