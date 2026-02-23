package com.amazonaws.mobile.auth.userpools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignUpConfirmActivity extends Activity {
    private static final String LOG_TAG = "SignUpConfirmActivity";
    private SignUpConfirmView signUpConfirmView;

    public void confirmAccount(View view) {
        String obj = this.signUpConfirmView.getUserNameEditText().getText().toString();
        String obj2 = this.signUpConfirmView.getConfirmCodeEditText().getText().toString();
        String str = LOG_TAG;
        Log.d(str, "username = " + obj);
        Log.d(str, "verificationCode = " + obj2);
        Intent intent = new Intent();
        intent.putExtra("username", obj);
        intent.putExtra("verification_code", obj2);
        setResult(-1, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sign_up_confirm);
        String stringExtra = getIntent().getStringExtra("username");
        String stringExtra2 = getIntent().getStringExtra("destination");
        SignUpConfirmView findViewById = findViewById(R.id.signup_confirm_view);
        this.signUpConfirmView = findViewById;
        findViewById.getUserNameEditText().setText(stringExtra);
        this.signUpConfirmView.getConfirmCodeEditText().requestFocus();
        findViewById(R.id.confirm_account_message1).setText(getString(R.string.sign_up_confirm_code_sent) + "\n" + stringExtra2);
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
    }
}
