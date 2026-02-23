package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class IntegrityServiceException extends com.google.android.gms.common.api.b {
    private final Throwable a;

    public IntegrityServiceException(int i, Throwable th) {
        super(new Status(i, String.format(Locale.ROOT, "Integrity API error (%d): %s.", new Object[]{Integer.valueOf(i), com.google.android.play.core.integrity.model.a.a(i)})));
        if (i == 0) {
            throw new IllegalArgumentException("ErrorCode should not be 0.");
        }
        this.a = th;
    }

    public final synchronized Throwable getCause() {
        return this.a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
