package org.spongycastle.util.io.pem;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PemGenerationException extends IOException {
    private Throwable cause;

    public PemGenerationException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public PemGenerationException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
