package com.amazonaws.mobile.client.internal.oauth2;

import com.amazonaws.mobile.client.internal.oauth2.OAuth2Constants;
import com.amazonaws.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class HTTPUtil {
    /* JADX WARN: Removed duplicated region for block: B:61:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String httpPost(java.net.URL r5, java.util.Map r6, java.util.Map r7, java.lang.String r8) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.internal.oauth2.HTTPUtil.httpPost(java.net.URL, java.util.Map, java.util.Map, java.lang.String):java.lang.String");
    }

    public static OAuth2Tokens parseHttpResponse(String str) throws JSONException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid (null) response from Amazon Cognito Auth endpoint");
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR.toString(), (String) null);
        String optString2 = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR_DESCRIPTION.toString(), (String) null);
        String optString3 = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR_URI.toString(), (String) null);
        if (optString != null) {
            throw new OAuth2Exception("Failed to exchange code for tokens", optString, optString2, optString3);
        }
        String optString4 = jSONObject.optString(OAuth2Constants.TokenResponseFields.EXPIRES_IN.toString());
        return new OAuth2Tokens(jSONObject.getString(OAuth2Constants.TokenResponseFields.ACCESS_TOKEN.toString()), jSONObject.optString(OAuth2Constants.TokenResponseFields.ID_TOKEN.toString(), (String) null), jSONObject.optString(OAuth2Constants.TokenResponseFields.REFRESH_TOKEN.toString(), (String) null), jSONObject.getString(OAuth2Constants.TokenResponseFields.TOKEN_TYPE.toString()), !StringUtils.isBlank(optString4) ? Long.valueOf(Long.parseLong(optString4)) : null, Long.valueOf(System.currentTimeMillis() / 1000), jSONObject.optString("scopes", (String) null));
    }
}
