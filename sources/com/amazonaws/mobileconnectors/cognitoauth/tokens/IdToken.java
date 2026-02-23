package com.amazonaws.mobileconnectors.cognitoauth.tokens;

import com.amazonaws.mobileconnectors.cognitoauth.util.JWTParser;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class IdToken extends UserToken {
    private long SEC_IN_MILLSEC;

    public IdToken(String str) {
        super(str);
        this.SEC_IN_MILLSEC = 1000L;
    }

    public String getCognitoUsername() throws Exception {
        return JWTParser.getClaim(super.getToken(), "cognito:username");
    }

    public Date getExpiration() throws Exception {
        String claim = JWTParser.getClaim(super.getToken(), "exp");
        if (claim == null) {
            return null;
        }
        return new Date(Long.parseLong(claim) * this.SEC_IN_MILLSEC);
    }

    public Date getIssuedAt() throws Exception {
        String claim = JWTParser.getClaim(super.getToken(), "iat");
        if (claim == null) {
            return null;
        }
        return new Date(Long.parseLong(claim) * this.SEC_IN_MILLSEC);
    }

    public String getJWTToken() {
        return super.getToken();
    }

    public Date getNotBefore() throws Exception {
        String claim = JWTParser.getClaim(super.getToken(), "nbf");
        if (claim == null) {
            return null;
        }
        return new Date(Long.parseLong(claim) * this.SEC_IN_MILLSEC);
    }
}
