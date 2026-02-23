package com.amazonaws.mobileconnectors.cognitoauth;

import com.amazonaws.mobileconnectors.cognitoauth.tokens.AccessToken;
import com.amazonaws.mobileconnectors.cognitoauth.tokens.IdToken;
import com.amazonaws.mobileconnectors.cognitoauth.tokens.RefreshToken;
import com.amazonaws.mobileconnectors.cognitoauth.util.AuthClientConfig;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthUserSession {
    private AccessToken accessToken;
    private IdToken idToken;
    private RefreshToken refreshToken;

    public AuthUserSession(IdToken idToken, AccessToken accessToken, RefreshToken refreshToken) {
        this.idToken = idToken;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    public IdToken getIdToken() {
        return this.idToken;
    }

    public RefreshToken getRefreshToken() {
        return this.refreshToken;
    }

    public String getUsername() {
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            try {
                return accessToken.getUsername();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean isValid() {
        AccessToken accessToken = this.accessToken;
        if (accessToken != null && accessToken.getJWTToken() != null) {
            try {
                return new Date().before(this.accessToken.getExpiration());
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean isValidForThreshold() {
        AccessToken accessToken = this.accessToken;
        if (accessToken == null || accessToken.getJWTToken() == null) {
            return false;
        }
        try {
            return this.accessToken.getExpiration().getTime() - System.currentTimeMillis() > AuthClientConfig.getRefreshThreshold();
        } catch (Exception unused) {
            return false;
        }
    }
}
