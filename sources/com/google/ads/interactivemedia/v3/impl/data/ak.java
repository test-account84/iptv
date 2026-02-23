package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ak extends bu {
    private final boolean attached;
    private final ay bounds;
    private final String detailedReason;
    private final boolean hidden;
    private final FriendlyObstructionPurpose purpose;
    private final String type;

    private ak(boolean z, ay ayVar, String str, boolean z2, FriendlyObstructionPurpose friendlyObstructionPurpose, String str2) {
        this.attached = z;
        this.bounds = ayVar;
        this.detailedReason = str;
        this.hidden = z2;
        this.purpose = friendlyObstructionPurpose;
        this.type = str2;
    }

    public boolean attached() {
        return this.attached;
    }

    public ay bounds() {
        return this.bounds;
    }

    public String detailedReason() {
        return this.detailedReason;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof bu) {
            bu buVar = (bu) obj;
            if (this.attached == buVar.attached() && this.bounds.equals(buVar.bounds()) && ((str = this.detailedReason) != null ? str.equals(buVar.detailedReason()) : buVar.detailedReason() == null) && this.hidden == buVar.hidden() && this.purpose.equals(buVar.purpose()) && this.type.equals(buVar.type())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((true != this.attached ? 1237 : 1231) ^ 1000003) * 1000003) ^ this.bounds.hashCode()) * 1000003;
        String str = this.detailedReason;
        return ((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ (true != this.hidden ? 1237 : 1231)) * 1000003) ^ this.purpose.hashCode()) * 1000003) ^ this.type.hashCode();
    }

    public boolean hidden() {
        return this.hidden;
    }

    public FriendlyObstructionPurpose purpose() {
        return this.purpose;
    }

    public String toString() {
        return "ObstructionData{attached=" + this.attached + ", bounds=" + String.valueOf(this.bounds) + ", detailedReason=" + this.detailedReason + ", hidden=" + this.hidden + ", purpose=" + String.valueOf(this.purpose) + ", type=" + this.type + "}";
    }

    public String type() {
        return this.type;
    }

    public /* synthetic */ ak(boolean z, ay ayVar, String str, boolean z2, FriendlyObstructionPurpose friendlyObstructionPurpose, String str2, aj ajVar) {
        this(z, ayVar, str, z2, friendlyObstructionPurpose, str2);
    }
}
