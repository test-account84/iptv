package com.google.android.play.core.integrity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class c extends IntegrityTokenRequest {
    private final String a;
    private final Long b;

    public /* synthetic */ c(String str, Long l, b bVar) {
        this.a = str;
        this.b = l;
    }

    public final Long cloudProjectNumber() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (this.a.equals(integrityTokenRequest.nonce())) {
                Long l = this.b;
                Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
                if (l != null ? l.equals(cloudProjectNumber) : cloudProjectNumber == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode() ^ 1000003;
        Long l = this.b;
        return (hashCode * 1000003) ^ (l == null ? 0 : l.hashCode());
    }

    public final String nonce() {
        return this.a;
    }

    public final String toString() {
        return "IntegrityTokenRequest{nonce=" + this.a + ", cloudProjectNumber=" + this.b + "}";
    }
}
