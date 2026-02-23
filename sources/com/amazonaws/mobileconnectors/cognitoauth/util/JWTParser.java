package com.amazonaws.mobileconnectors.cognitoauth.util;

import android.util.Base64;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthInvalidParameterException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class JWTParser {
    private static int HEADER = 0;
    private static int JWT_PARTS = 3;
    private static int PAYLOAD = 1;
    private static int SIGNATURE = 2;

    public static String getClaim(String str, String str2) {
        try {
            Object obj = getPayload(str).get(str2);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Exception e) {
            throw new AuthInvalidParameterException("error while parsing JSON", e);
        }
    }

    public static JSONObject getHeader(String str) {
        try {
            validateJWT(str);
            return new JSONObject(new String(Base64.decode(str.split("\\.")[HEADER], 8), "UTF-8"));
        } catch (Exception e) {
            throw new AuthInvalidParameterException("error while parsing JSON", e);
        }
    }

    public static JSONObject getPayload(String str) {
        try {
            validateJWT(str);
            return new JSONObject(new String(Base64.decode(str.split("\\.")[PAYLOAD], 8), "UTF-8"));
        } catch (Exception e) {
            throw new AuthInvalidParameterException("error while parsing JSON", e);
        }
    }

    public static String getSignature(String str) {
        try {
            validateJWT(str);
            return new String(Base64.decode(str.split("\\.")[SIGNATURE], 8), "UTF-8");
        } catch (Exception e) {
            throw new AuthInvalidParameterException("error while parsing JSON", e);
        }
    }

    public static void validateJWT(String str) {
        if (str.split("\\.").length < JWT_PARTS) {
            throw new AuthInvalidParameterException("Not a JSON Web Token");
        }
    }
}
