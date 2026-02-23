package com.amplifyframework.auth.result;

import O.c;
import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.auth.result.step.AuthNextSignUpStep;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthSignUpResult {
    private final boolean isSignUpComplete;
    private final AuthNextSignUpStep nextStep;
    private final AuthUser user;

    public AuthSignUpResult(boolean z, AuthNextSignUpStep authNextSignUpStep, AuthUser authUser) {
        this.isSignUpComplete = z;
        Objects.requireNonNull(authNextSignUpStep);
        this.nextStep = authNextSignUpStep;
        this.user = authUser;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthSignUpResult.class != obj.getClass()) {
            return false;
        }
        AuthSignUpResult authSignUpResult = (AuthSignUpResult) obj;
        return c.a(Boolean.valueOf(isSignUpComplete()), Boolean.valueOf(authSignUpResult.isSignUpComplete())) && c.a(getNextStep(), authSignUpResult.getNextStep()) && c.a(getUser(), authSignUpResult.getUser());
    }

    public AuthNextSignUpStep getNextStep() {
        return this.nextStep;
    }

    public AuthUser getUser() {
        return this.user;
    }

    public int hashCode() {
        return c.b(Boolean.valueOf(isSignUpComplete()), getNextStep(), getUser());
    }

    public boolean isSignUpComplete() {
        return this.isSignUpComplete;
    }

    public String toString() {
        return "AuthSignUpResult{isSignUpComplete=" + isSignUpComplete() + ", nextStep=" + getNextStep() + ", user=" + getUser() + '}';
    }
}
