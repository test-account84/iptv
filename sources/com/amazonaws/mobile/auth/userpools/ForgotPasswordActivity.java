package com.amazonaws.mobile.auth.userpools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ForgotPasswordActivity extends Activity {
    private static final String LOG_TAG = "ForgotPasswordActivity";
    private ForgotPasswordView forgotPasswordView;

    public void forgotPassword(View view) {
        String password = this.forgotPasswordView.getPassword();
        String verificationCode = this.forgotPasswordView.getVerificationCode();
        Log.d(LOG_TAG, "verificationCode = " + verificationCode);
        Intent intent = new Intent();
        intent.putExtra("password", password);
        intent.putExtra("verification_code", verificationCode);
        setResult(-1, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_forgot_password);
        this.forgotPasswordView = findViewById(R.id.forgot_password_view);
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
    }
}
