package com.google.android.gms.common.api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b extends Exception {

    @Deprecated
    protected final Status mStatus;

    public b(Status status) {
        super(status.I() + ": " + (status.J() != null ? status.J() : ""));
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.I();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.J();
    }
}
