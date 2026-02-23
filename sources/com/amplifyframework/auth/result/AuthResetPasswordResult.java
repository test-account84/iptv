package com.amplifyframework.auth.result;

import O.c;
import com.amplifyframework.auth.result.step.AuthNextResetPasswordStep;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthResetPasswordResult {
    private final boolean isPasswordReset;
    private final AuthNextResetPasswordStep nextStep;

    public AuthResetPasswordResult(boolean z, AuthNextResetPasswordStep authNextResetPasswordStep) {
        this.isPasswordReset = z;
        Objects.requireNonNull(authNextResetPasswordStep);
        this.nextStep = authNextResetPasswordStep;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthResetPasswordResult.class != obj.getClass()) {
            return false;
        }
        AuthResetPasswordResult authResetPasswordResult = (AuthResetPasswordResult) obj;
        return c.a(Boolean.valueOf(isPasswordReset()), Boolean.valueOf(authResetPasswordResult.isPasswordReset())) && c.a(getNextStep(), authResetPasswordResult.getNextStep());
    }

    public AuthNextResetPasswordStep getNextStep() {
        return this.nextStep;
    }

    public int hashCode() {
        return c.b(Boolean.valueOf(isPasswordReset()), getNextStep());
    }

    public boolean isPasswordReset() {
        return this.isPasswordReset;
    }

    public String toString() {
        return "AuthResetPasswordResult{isPasswordReset=" + isPasswordReset() + ", nextStep=" + getNextStep() + '}';
    }
}
