package com.amazonaws.mobileconnectors.cognitoauth.util;

import com.amazonaws.mobileconnectors.cognitoauth.AuthUserSession;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthClientException;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthInvalidGrantException;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthInvalidParameterException;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthServiceException;
import com.amazonaws.mobileconnectors.cognitoauth.tokens.AccessToken;
import com.amazonaws.mobileconnectors.cognitoauth.tokens.IdToken;
import com.amazonaws.mobileconnectors.cognitoauth.tokens.RefreshToken;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthHttpResponseParser {
    private AuthHttpResponseParser() {
    }

    public static final AuthUserSession parseHttpResponse(String str) {
        if (str == null || str.isEmpty()) {
            throw new AuthInvalidParameterException("Invalid (null) response from Amazon Cognito Auth endpoint");
        }
        AccessToken accessToken = new AccessToken(null);
        IdToken idToken = new IdToken(null);
        RefreshToken refreshToken = new RefreshToken(null);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("error")) {
                String string = jSONObject.getString("error");
                if ("invalid_grant".equals(string)) {
                    throw new AuthInvalidGrantException(string);
                }
                throw new AuthServiceException(string);
            }
            if (jSONObject.has("access_token")) {
                accessToken = new AccessToken(jSONObject.getString("access_token"));
            }
            if (jSONObject.has("id_token")) {
                idToken = new IdToken(jSONObject.getString("id_token"));
            }
            if (jSONObject.has("refresh_token")) {
                refreshToken = new RefreshToken(jSONObject.getString("refresh_token"));
            }
            return new AuthUserSession(idToken, accessToken, refreshToken);
        } catch (AuthInvalidGrantException e) {
            throw e;
        } catch (AuthServiceException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new AuthClientException(e3.getMessage(), e3);
        }
    }
}
