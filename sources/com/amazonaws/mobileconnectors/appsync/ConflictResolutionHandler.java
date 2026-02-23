package com.amazonaws.mobileconnectors.appsync;

import android.util.Log;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v1.a;
import v1.e;
import v1.i;
import x1.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConflictResolutionHandler {
    private static final String TAG = "ConflictResolutionHandler";
    final AppSyncOfflineMutationInterceptor mutationInterceptor;

    public ConflictResolutionHandler(AppSyncOfflineMutationInterceptor appSyncOfflineMutationInterceptor) {
        this.mutationInterceptor = appSyncOfflineMutationInterceptor;
    }

    public static boolean conflictPresent(String str) {
        JSONArray optJSONArray;
        String optString;
        if (str == null) {
            return false;
        }
        try {
            optJSONArray = new JSONObject(str).optJSONArray("errors");
        } catch (JSONException unused) {
        }
        if (optJSONArray == null || optJSONArray.length() < 1 || (optString = optJSONArray.getJSONObject(0).optString("errorType")) == null) {
            return false;
        }
        return optString.equals("DynamoDB:ConditionalCheckFailedException");
    }

    public void fail(String str) {
        this.mutationInterceptor.failConflictMutation(str);
    }

    public void retryMutation(e eVar, String str) {
        Log.d(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Calling retry conflict mutation.");
        this.mutationInterceptor.retryConflictMutation(eVar, str);
    }

    public static boolean conflictPresent(d dVar) {
        Map a;
        if (dVar != null && dVar.e() != null && ((i) dVar.e()).e()) {
            Log.d(TAG, "Thread:[" + Thread.currentThread().getId() + "]: onResponse -- found error");
            if (((i) dVar.e()).d().get(0).toString().contains("The conditional request failed") && (a = ((a) ((i) dVar.e()).d().get(0)).a()) != null && a.get("data") != null) {
                return true;
            }
        }
        return false;
    }
}
