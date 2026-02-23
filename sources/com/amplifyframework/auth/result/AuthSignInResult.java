package com.amplifyframework.auth.result;

import O.c;
import com.amplifyframework.auth.result.step.AuthNextSignInStep;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthSignInResult {
    private final boolean isSignInComplete;
    private final AuthNextSignInStep nextStep;

    public AuthSignInResult(boolean z, AuthNextSignInStep authNextSignInStep) {
        this.isSignInComplete = z;
        Objects.requireNonNull(authNextSignInStep);
        this.nextStep = authNextSignInStep;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthSignInResult.class != obj.getClass()) {
            return false;
        }
        AuthSignInResult authSignInResult = (AuthSignInResult) obj;
        return c.a(Boolean.valueOf(isSignInComplete()), Boolean.valueOf(authSignInResult.isSignInComplete())) && c.a(getNextStep(), authSignInResult.getNextStep());
    }

    public AuthNextSignInStep getNextStep() {
        return this.nextStep;
    }

    public int hashCode() {
        return c.b(Boolean.valueOf(isSignInComplete()), getNextStep());
    }

    public boolean isSignInComplete() {
        return this.isSignInComplete;
    }

    public String toString() {
        return "AuthSignInResult{isSignInComplete=" + isSignInComplete() + ", nextStep=" + getNextStep() + '}';
    }
}
