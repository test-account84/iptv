package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.IntegrityTokenRequest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class a extends IntegrityTokenRequest.Builder {
    private String a;
    private Long b;

    public final IntegrityTokenRequest build() {
        String str = this.a;
        if (str != null) {
            return new c(str, this.b, null);
        }
        throw new IllegalStateException("Missing required properties: nonce");
    }

    public final IntegrityTokenRequest.Builder setCloudProjectNumber(long j) {
        this.b = Long.valueOf(j);
        return this;
    }

    public final IntegrityTokenRequest.Builder setNonce(String str) {
        if (str == null) {
            throw new NullPointerException("Null nonce");
        }
        this.a = str;
        return this;
    }
}
