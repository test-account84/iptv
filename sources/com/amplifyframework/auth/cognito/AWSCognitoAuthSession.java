package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.result.AuthSessionResult;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthSession extends AuthSession {
    private final AuthSessionResult awsCredentials;
    private final AuthSessionResult identityId;
    private final AuthSessionResult userPoolTokens;
    private final AuthSessionResult userSub;

    public AWSCognitoAuthSession(boolean z, AuthSessionResult authSessionResult, AuthSessionResult authSessionResult2, AuthSessionResult authSessionResult3, AuthSessionResult authSessionResult4) {
        super(z);
        Objects.requireNonNull(authSessionResult);
        this.identityId = authSessionResult;
        Objects.requireNonNull(authSessionResult2);
        this.awsCredentials = authSessionResult2;
        Objects.requireNonNull(authSessionResult3);
        this.userSub = authSessionResult3;
        Objects.requireNonNull(authSessionResult4);
        this.userPoolTokens = authSessionResult4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthSession.class != obj.getClass()) {
            return false;
        }
        AWSCognitoAuthSession aWSCognitoAuthSession = (AWSCognitoAuthSession) obj;
        return O.c.a(Boolean.valueOf(isSignedIn()), Boolean.valueOf(aWSCognitoAuthSession.isSignedIn())) && O.c.a(getAWSCredentials(), aWSCognitoAuthSession.getAWSCredentials()) && O.c.a(getUserSub(), aWSCognitoAuthSession.getUserSub()) && O.c.a(getIdentityId(), aWSCognitoAuthSession.getIdentityId()) && O.c.a(getUserPoolTokens(), aWSCognitoAuthSession.getUserPoolTokens());
    }

    public AuthSessionResult getAWSCredentials() {
        return this.awsCredentials;
    }

    public AuthSessionResult getIdentityId() {
        return this.identityId;
    }

    public AuthSessionResult getUserPoolTokens() {
        return this.userPoolTokens;
    }

    public AuthSessionResult getUserSub() {
        return this.userSub;
    }

    public int hashCode() {
        return O.c.b(Boolean.valueOf(isSignedIn()), getAWSCredentials(), getUserSub(), getIdentityId(), getUserPoolTokens());
    }

    public String toString() {
        return "AWSCognitoAuthSession{isSignedIn=" + isSignedIn() + ", awsCredentials=" + getAWSCredentials() + ", userSub='" + getUserSub() + "', identityId='" + getIdentityId() + "', userPoolTokens='" + getUserPoolTokens() + "'}";
    }
}
