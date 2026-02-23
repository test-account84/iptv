package com.amazonaws.mobile.auth.userpools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MFAActivity extends Activity {
    private static final String LOG_TAG = "MFAActivity";
    private MFAView mfaView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mfa);
        this.mfaView = findViewById(R.id.mfa_view);
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
    }

    public void verify(View view) {
        String mFACode = this.mfaView.getMFACode();
        Log.d(LOG_TAG, "verificationCode = " + mFACode);
        Intent intent = new Intent();
        intent.putExtra("verification_code", mFACode);
        setResult(-1, intent);
        finish();
    }
}
