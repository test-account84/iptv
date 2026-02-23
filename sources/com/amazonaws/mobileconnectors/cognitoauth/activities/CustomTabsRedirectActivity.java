package com.amazonaws.mobileconnectors.cognitoauth.activities;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class CustomTabsRedirectActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(CustomTabsManagerActivity.createResponseHandlingIntent(this, getIntent().getData()));
        finish();
    }
}
