package com.google.android.play.core.integrity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class f extends IntegrityTokenResponse {
    private final String a;

    public /* synthetic */ f(String str, e eVar) {
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenResponse) {
            return this.a.equals(((IntegrityTokenResponse) obj).token());
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "IntegrityTokenResponse{token=" + this.a + "}";
    }

    public final String token() {
        return this.a;
    }
}
