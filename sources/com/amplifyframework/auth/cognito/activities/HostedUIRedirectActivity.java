package com.amplifyframework.auth.cognito.activities;

import android.app.Activity;
import android.os.Bundle;
import com.amazonaws.mobileconnectors.cognitoauth.activities.CustomTabsManagerActivity;
import com.amplifyframework.core.Amplify;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class HostedUIRedirectActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(CustomTabsManagerActivity.createResponseHandlingIntent(this, getIntent().getData()));
    }

    public void onResume() {
        super.onResume();
        Amplify.Auth.handleWebUISignInResponse(getIntent());
        finish();
    }
}
