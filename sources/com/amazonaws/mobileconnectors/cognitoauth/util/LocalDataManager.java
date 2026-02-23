package com.amazonaws.mobileconnectors.cognitoauth.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.mobileconnectors.cognitoauth.AuthUserSession;
import com.amazonaws.mobileconnectors.cognitoauth.tokens.AccessToken;
import com.amazonaws.mobileconnectors.cognitoauth.tokens.IdToken;
import com.amazonaws.mobileconnectors.cognitoauth.tokens.RefreshToken;
import com.amazonaws.util.StringUtils;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LocalDataManager {
    static final String TAG = "LocalDataManager";

    public static void cacheSession(Context context, String str, String str2, AuthUserSession authUserSession, Set set) {
        if (context == null || str == null || str.isEmpty() || str2 == null || authUserSession == null) {
            Log.e(TAG, "Application context, and application domain cannot be null");
            return;
        }
        Locale locale = Locale.US;
        String format = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "idToken"});
        String format2 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "accessToken"});
        String format3 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "refreshToken"});
        String format4 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenType"});
        String format5 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenScopes"});
        String format6 = String.format(locale, "%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, "LastAuthUser"});
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("CognitoIdentityProviderCache", 0).edit();
            edit.putString(format4, "JWT");
            edit.putString(format, authUserSession.getIdToken().getJWTToken());
            edit.putString(format2, authUserSession.getAccessToken().getJWTToken());
            edit.putString(format3, authUserSession.getRefreshToken().getToken());
            if (set != null && set.size() > 0) {
                edit.putStringSet(format5, set);
            }
            edit.putString(format6, str2).apply();
        } catch (Exception e) {
            Log.e(TAG, "Failed while writing to SharedPreferences", e);
        }
    }

    public static void cacheState(Context context, String str, String str2, Set set) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("CognitoIdentityProviderCache", 0).edit();
            edit.putString(str + "code_challenge", str2);
            edit.putStringSet(str + "scope", set).apply();
        } catch (Exception e) {
            Log.e(TAG, "Failed while writing to SharedPreferences", e);
        }
    }

    public static void clearCache(Context context, String str, String str2) {
        if (str2 == null) {
            return;
        }
        Locale locale = Locale.US;
        String format = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "idToken"});
        String format2 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "accessToken"});
        String format3 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "refreshToken"});
        String format4 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenType"});
        String format5 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenScopes"});
        String format6 = String.format(locale, "%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, "LastAuthUser"});
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("CognitoIdentityProviderCache", 0).edit();
            edit.remove(format);
            edit.remove(format2);
            edit.remove(format3);
            edit.remove(format4);
            edit.remove(format5);
            edit.remove(format6).apply();
        } catch (Exception e) {
            Log.e(TAG, "Failed while writing to SharedPreferences", e);
        }
    }

    public static void clearCacheAll(AWSKeyValueStore aWSKeyValueStore) {
        try {
            aWSKeyValueStore.clear();
        } catch (Exception e) {
            Log.e(TAG, "Failed while clearing data from SharedPreferences", e);
        }
    }

    public static String getCachedProofKey(Context context, String str) {
        try {
            return context.getSharedPreferences("CognitoIdentityProviderCache", 0).getString(str + "code_challenge", (String) null);
        } catch (Exception e) {
            Log.e(TAG, "Failed to read from SharedPreferences", e);
            return null;
        }
    }

    public static Set getCachedScopes(Context context, String str) {
        HashSet hashSet = new HashSet();
        try {
            return context.getSharedPreferences("CognitoIdentityProviderCache", 0).getStringSet(str + "scope", hashSet);
        } catch (Exception e) {
            Log.e(TAG, "Failed to read from SharedPreferences", e);
            return hashSet;
        }
    }

    public static AuthUserSession getCachedSession(Context context, String str, String str2, Set set) {
        AuthUserSession authUserSession = new AuthUserSession(null, null, null);
        if (str2 == null) {
            return authUserSession;
        }
        if (context == null || str == null || str.isEmpty()) {
            throw new InvalidParameterException("Application context, and application domain cannot be null");
        }
        Locale locale = Locale.US;
        String format = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "idToken"});
        String format2 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "accessToken"});
        String format3 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "refreshToken"});
        String format4 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenScopes"});
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CognitoIdentityProviderCache", 0);
            return !sharedPreferences.getStringSet(format4, new HashSet()).equals(set) ? authUserSession : new AuthUserSession(new IdToken(sharedPreferences.getString(format, (String) null)), new AccessToken(sharedPreferences.getString(format2, (String) null)), new RefreshToken(sharedPreferences.getString(format3, (String) null)));
        } catch (Exception e) {
            Log.e(TAG, "Failed to read from SharedPreferences", e);
            return authUserSession;
        }
    }

    public static String getLastAuthUser(Context context, String str) {
        if (context == null || str == null) {
            throw new InvalidParameterException("Application context, and application domain cannot be null");
        }
        try {
            return context.getSharedPreferences("CognitoIdentityProviderCache", 0).getString(String.format(Locale.US, "%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, "LastAuthUser"}), (String) null);
        } catch (Exception e) {
            Log.e(TAG, "Failed to read from SharedPreferences", e);
            return null;
        }
    }

    public static Set setFromString(String str) {
        HashSet hashSet = new HashSet();
        if (StringUtils.isBlank(str)) {
            return hashSet;
        }
        hashSet.addAll(Arrays.asList(str.split(",")));
        return hashSet;
    }

    public static String setToString(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append((String) it.next());
            int i2 = i + 1;
            if (i < set.size() - 1) {
                sb.append(",");
            }
            i = i2;
        }
        return sb.toString();
    }

    public static void cacheSession(AWSKeyValueStore aWSKeyValueStore, Context context, String str, String str2, AuthUserSession authUserSession, Set set) {
        if (context == null || str == null || str.isEmpty() || str2 == null || authUserSession == null) {
            Log.e(TAG, "Application context, and application domain cannot be null");
            return;
        }
        Locale locale = Locale.US;
        String format = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "idToken"});
        String format2 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "accessToken"});
        String format3 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "refreshToken"});
        String format4 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenType"});
        String format5 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenScopes"});
        String format6 = String.format(locale, "%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, "LastAuthUser"});
        try {
            aWSKeyValueStore.put(format4, "JWT");
            aWSKeyValueStore.put(format, authUserSession.getIdToken().getJWTToken());
            aWSKeyValueStore.put(format2, authUserSession.getAccessToken().getJWTToken());
            aWSKeyValueStore.put(format3, authUserSession.getRefreshToken().getToken());
            if (set != null && set.size() > 0) {
                aWSKeyValueStore.put(format5, setToString(set));
            }
            aWSKeyValueStore.put(format6, str2);
        } catch (Exception e) {
            Log.e(TAG, "Failed while writing to SharedPreferences", e);
        }
    }

    public static void cacheState(AWSKeyValueStore aWSKeyValueStore, Context context, String str, String str2, Set set) {
        try {
            aWSKeyValueStore.put(str + "code_challenge", str2);
            aWSKeyValueStore.put(str + "scope", setToString(set));
        } catch (Exception e) {
            Log.e(TAG, "Failed while writing to SharedPreferences", e);
        }
    }

    public static void clearCache(AWSKeyValueStore aWSKeyValueStore, Context context, String str, String str2) {
        if (str2 == null) {
            return;
        }
        Locale locale = Locale.US;
        String format = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "idToken"});
        String format2 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "accessToken"});
        String format3 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "refreshToken"});
        String format4 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenType"});
        String format5 = String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenScopes"});
        String format6 = String.format(locale, "%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, "LastAuthUser"});
        try {
            aWSKeyValueStore.remove(format);
            aWSKeyValueStore.remove(format2);
            aWSKeyValueStore.remove(format3);
            aWSKeyValueStore.remove(format4);
            aWSKeyValueStore.remove(format5);
            aWSKeyValueStore.remove(format6);
        } catch (Exception e) {
            Log.e(TAG, "Failed while writing to SharedPreferences", e);
        }
    }

    public static String getCachedProofKey(AWSKeyValueStore aWSKeyValueStore, Context context, String str) {
        try {
            return aWSKeyValueStore.get(str + "code_challenge");
        } catch (Exception e) {
            Log.e(TAG, "Failed to read from SharedPreferences", e);
            return null;
        }
    }

    public static Set getCachedScopes(AWSKeyValueStore aWSKeyValueStore, Context context, String str) {
        HashSet hashSet = new HashSet();
        try {
            return setFromString(aWSKeyValueStore.get(str + "scope"));
        } catch (Exception e) {
            Log.e(TAG, "Failed to read from SharedPreferences", e);
            return hashSet;
        }
    }

    public static AuthUserSession getCachedSession(AWSKeyValueStore aWSKeyValueStore, Context context, String str, String str2, Set set) {
        AuthUserSession authUserSession = new AuthUserSession(null, null, null);
        if (str2 == null) {
            return authUserSession;
        }
        if (context == null || str == null || str.isEmpty()) {
            throw new InvalidParameterException("Application context, and application domain cannot be null");
        }
        Locale locale = Locale.US;
        try {
            return !setFromString(aWSKeyValueStore.get(String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "tokenScopes"}))).equals(set) ? authUserSession : new AuthUserSession(new IdToken(aWSKeyValueStore.get(String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "idToken"}))), new AccessToken(aWSKeyValueStore.get(String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "accessToken"}))), new RefreshToken(aWSKeyValueStore.get(String.format(locale, "%s.%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, str2, "refreshToken"}))));
        } catch (Exception e) {
            Log.e(TAG, "Failed to read from SharedPreferences", e);
            return authUserSession;
        }
    }

    public static String getLastAuthUser(AWSKeyValueStore aWSKeyValueStore, Context context, String str) {
        if (context == null || str == null) {
            throw new InvalidParameterException("Application context, and application domain cannot be null");
        }
        try {
            return aWSKeyValueStore.get(String.format(Locale.US, "%s.%s.%s", new Object[]{"CognitoIdentityProvider", str, "LastAuthUser"}));
        } catch (Exception e) {
            Log.e(TAG, "Failed to read from SharedPreferences", e);
            return null;
        }
    }
}
