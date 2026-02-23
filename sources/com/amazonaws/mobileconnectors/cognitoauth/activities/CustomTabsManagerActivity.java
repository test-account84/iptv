package com.amazonaws.mobileconnectors.cognitoauth.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class CustomTabsManagerActivity extends Activity {
    static final String CUSTOM_TABS_INTENT_KEY = "customTabsIntent";
    static final String CUSTOM_TABS_LAUNCHED_KEY = "customTabsLaunched";
    private static final String TAG = "AuthClient";
    private Intent customTabsIntent;
    private boolean customTabsLaunched = false;

    private static Intent createBaseIntent(Context context) {
        return new Intent(context, CustomTabsManagerActivity.class);
    }

    public static Intent createResponseHandlingIntent(Context context, Uri uri) {
        Intent createBaseIntent = createBaseIntent(context);
        createBaseIntent.setData(uri);
        createBaseIntent.addFlags(603979776);
        return createBaseIntent;
    }

    public static Intent createStartIntent(Context context, Intent intent) {
        Intent createBaseIntent = createBaseIntent(context);
        createBaseIntent.putExtra("customTabsIntent", intent);
        return createBaseIntent;
    }

    private void extractState(Bundle bundle) {
        if (bundle == null) {
            Log.d("AuthClient", "CustomTabsManagerActivity was created with a null state.");
            finish();
        } else {
            this.customTabsIntent = bundle.getParcelable("customTabsIntent");
            this.customTabsLaunched = bundle.getBoolean("customTabsLaunched", false);
        }
    }

    private void handleAuthorizationCanceled() {
        Log.d("AuthClient", "Authorization flow canceled by user");
        setResult(0);
    }

    private void handleAuthorizationComplete() {
        Log.d("AuthClient", "Authorization flow completed successfully");
        setResult(-1, getIntent());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        extractState(bundle);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onResume() {
        super.onResume();
        if (!this.customTabsLaunched) {
            startActivity(this.customTabsIntent);
            this.customTabsLaunched = true;
        } else {
            if (getIntent().getData() != null) {
                handleAuthorizationComplete();
            } else {
                handleAuthorizationCanceled();
            }
            finish();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("customTabsLaunched", this.customTabsLaunched);
        bundle.putParcelable("customTabsIntent", this.customTabsIntent);
    }
}
