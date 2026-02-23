package com.google.android.recaptcha;

import kotlin.jvm.internal.g;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class RecaptchaException extends Exception {

    @NotNull
    private final RecaptchaErrorCode errorCode;

    @NotNull
    private final String errorMessage;

    public RecaptchaException(RecaptchaErrorCode recaptchaErrorCode, String str) {
        super(str);
        this.errorCode = recaptchaErrorCode;
        this.errorMessage = str;
    }

    @NotNull
    public final RecaptchaErrorCode getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ RecaptchaException(RecaptchaErrorCode recaptchaErrorCode, String str, int i, g gVar) {
        this(recaptchaErrorCode, (i & 2) != 0 ? recaptchaErrorCode.getErrorMessage() : str);
    }
}
