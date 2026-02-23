package com.amplifyframework.auth.result;

import O.c;
import com.amplifyframework.auth.result.step.AuthNextUpdateAttributeStep;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthUpdateAttributeResult {
    private final boolean isUpdated;
    private final AuthNextUpdateAttributeStep nextStep;

    public AuthUpdateAttributeResult(boolean z, AuthNextUpdateAttributeStep authNextUpdateAttributeStep) {
        this.isUpdated = z;
        Objects.requireNonNull(authNextUpdateAttributeStep);
        this.nextStep = authNextUpdateAttributeStep;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthUpdateAttributeResult.class != obj.getClass()) {
            return false;
        }
        AuthUpdateAttributeResult authUpdateAttributeResult = (AuthUpdateAttributeResult) obj;
        return c.a(Boolean.valueOf(isUpdated()), Boolean.valueOf(authUpdateAttributeResult.isUpdated())) && c.a(getNextStep(), authUpdateAttributeResult.getNextStep());
    }

    public AuthNextUpdateAttributeStep getNextStep() {
        return this.nextStep;
    }

    public int hashCode() {
        return c.b(Boolean.valueOf(isUpdated()), getNextStep());
    }

    public boolean isUpdated() {
        return this.isUpdated;
    }

    public String toString() {
        return "AuthUpdateAttributeResult{isUpdated=" + isUpdated() + ", nextStep=" + getNextStep() + '}';
    }
}
