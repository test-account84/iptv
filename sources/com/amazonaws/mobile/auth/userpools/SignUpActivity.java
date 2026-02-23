package com.amazonaws.mobile.auth.userpools;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.amazonaws.mobile.auth.core.internal.util.ViewHelper;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignUpActivity extends Activity {
    private static final String LOG_TAG = "SignUpActivity";
    private CognitoUserPool mUserPool;
    private SignUpView signUpView;

    public class 1 implements SignUpHandler {
        final /* synthetic */ AlertDialog val$alertDialog;
        final /* synthetic */ String val$password;
        final /* synthetic */ String val$username;

        public 1(AlertDialog alertDialog, String str, String str2) {
            this.val$alertDialog = alertDialog;
            this.val$username = str;
            this.val$password = str2;
        }

        public void onFailure(Exception exc) {
            this.val$alertDialog.dismiss();
            SignUpActivity.this.showError(exc.getLocalizedMessage() != null ? CognitoUserPoolsSignInProvider.getErrorMessageFromException(exc) : "");
        }

        public void onSuccess(CognitoUser cognitoUser, SignUpResult signUpResult) {
            this.val$alertDialog.dismiss();
            Intent intent = new Intent();
            intent.putExtra("username", this.val$username);
            intent.putExtra("password", this.val$password);
            intent.putExtra("isSignUpConfirmed", signUpResult.getUserConfirmed());
            intent.putExtra("destination", signUpResult.getCodeDeliveryDetails().getDestination());
            SignUpActivity.this.setResult(-1, intent);
            SignUpActivity.this.finish();
        }
    }

    public static void startActivity(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, SignUpActivity.class), i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sign_up);
        this.signUpView = findViewById(R.id.signup_view);
        Context applicationContext = getApplicationContext();
        this.mUserPool = new CognitoUserPool(applicationContext, new AWSConfiguration(applicationContext));
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
    }

    public void onResume() {
        super.onResume();
    }

    public void showError(String str) {
        ViewHelper.showDialog(this, getString(R.string.title_activity_sign_up), getString(R.string.sign_up_failed) + " " + str);
    }

    public void signUp(View view) {
        String userName = this.signUpView.getUserName();
        String password = this.signUpView.getPassword();
        String givenName = this.signUpView.getGivenName();
        String email = this.signUpView.getEmail();
        String phone = this.signUpView.getPhone();
        String str = LOG_TAG;
        Log.d(str, "username = " + userName);
        Log.d(str, "given_name = " + givenName);
        Log.d(str, "email = " + email);
        Log.d(str, "phone = " + phone);
        if (userName.isEmpty()) {
            showError(getString(R.string.sign_up_username_missing));
            return;
        }
        if (password.length() < 6) {
            showError(getString(R.string.password_length_validation_failed));
            return;
        }
        CognitoUserAttributes cognitoUserAttributes = new CognitoUserAttributes();
        cognitoUserAttributes.addAttribute("given_name", givenName);
        cognitoUserAttributes.addAttribute("email", email);
        if (!phone.isEmpty()) {
            cognitoUserAttributes.addAttribute("phone_number", phone);
        }
        this.mUserPool.signUpInBackground(userName, password, cognitoUserAttributes, null, new 1(new AlertDialog.Builder(this).setTitle(getString(R.string.sign_up_in_progress)).setMessage(getString(R.string.please_wait)).setNeutralButton(17039370, (DialogInterface.OnClickListener) null).show(), userName, password));
    }
}
