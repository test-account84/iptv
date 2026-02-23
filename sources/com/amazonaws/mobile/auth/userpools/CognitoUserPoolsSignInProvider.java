package com.amazonaws.mobile.auth.userpools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.amazonaws.mobile.auth.core.internal.util.ViewHelper;
import com.amazonaws.mobile.auth.core.signin.SignInProvider;
import com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.NewPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidParameterException;
import java.util.Map;
import org.json.JSONException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoUserPoolsSignInProvider implements SignInProvider {
    private static final String LOG_TAG = "CognitoUserPoolsSignInProvider";
    private static final int PASSWORD_MIN_LENGTH = 6;
    private static final int REQUEST_CODE_START = 10608;
    private static final String USERPOOLS_EXCEPTION_PREFIX = "(Service";
    private static int backgroundColor;
    private static String fontFamily;
    private static boolean isBackgroundColorFullScreenEnabled;
    private Activity activity;
    private AWSConfiguration awsConfiguration;
    private String cognitoLoginKey;
    private CognitoUserPool cognitoUserPool;
    private CognitoUserSession cognitoUserSession;
    private Context context;
    private ForgotPasswordContinuation forgotPasswordContinuation;
    private NewPasswordContinuation mForceChangePasswordContinuation;
    private MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation;
    private String password;
    private SignInProviderResultHandler resultsHandler;
    private String signUpConfirmationDestination;
    private String username;
    private String verificationCode;
    private ForgotPasswordHandler forgotPasswordHandler = new 1();
    private GenericHandler signUpConfirmationHandler = new 2();
    private AuthenticationHandler authenticationHandler = new 4();

    public class 1 implements ForgotPasswordHandler {
        public 1() {
        }

        public void getResetCode(ForgotPasswordContinuation forgotPasswordContinuation) {
            CognitoUserPoolsSignInProvider.access$502(CognitoUserPoolsSignInProvider.this, forgotPasswordContinuation);
            CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).startActivityForResult(new Intent(CognitoUserPoolsSignInProvider.access$600(CognitoUserPoolsSignInProvider.this), ForgotPasswordActivity.class), RequestCodes.FORGOT_PASSWORD_REQUEST_CODE.value);
        }

        public void onFailure(Exception exc) {
            Log.e(CognitoUserPoolsSignInProvider.access$000(), "Password change failed.", exc);
            String string = exc instanceof InvalidParameterException ? CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.password_change_no_verification_failed) : CognitoUserPoolsSignInProvider.getErrorMessageFromException(exc);
            ViewHelper.showDialog(CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.title_activity_forgot_password), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.password_change_failed) + " " + string);
        }

        public void onSuccess() {
            Log.d(CognitoUserPoolsSignInProvider.access$000(), "Password change succeeded.");
            ViewHelper.showDialog(CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.title_activity_forgot_password), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.password_change_success));
            CognitoUserPoolsSignInProvider.access$300(CognitoUserPoolsSignInProvider.this).getUser(CognitoUserPoolsSignInProvider.access$200(CognitoUserPoolsSignInProvider.this)).getSessionInBackground(CognitoUserPoolsSignInProvider.access$400(CognitoUserPoolsSignInProvider.this));
        }
    }

    public class 2 implements GenericHandler {
        public 2() {
        }

        public void onFailure(Exception exc) {
            Log.e(CognitoUserPoolsSignInProvider.access$000(), "Failed to confirm user.", exc);
            ViewHelper.showDialog(CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.title_activity_sign_up_confirm), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.sign_up_confirm_failed) + " " + CognitoUserPoolsSignInProvider.getErrorMessageFromException(exc));
        }

        public void onSuccess() {
            Log.i(CognitoUserPoolsSignInProvider.access$000(), "Confirmed.");
            ViewHelper.showDialog(CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.title_activity_sign_up_confirm), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.sign_up_confirm_success));
            CognitoUserPoolsSignInProvider.access$300(CognitoUserPoolsSignInProvider.this).getUser(CognitoUserPoolsSignInProvider.access$200(CognitoUserPoolsSignInProvider.this)).getSessionInBackground(CognitoUserPoolsSignInProvider.access$400(CognitoUserPoolsSignInProvider.this));
        }
    }

    public class 3 implements VerificationHandler {
        public 3() {
        }

        public void onFailure(Exception exc) {
            if (CognitoUserPoolsSignInProvider.access$800(CognitoUserPoolsSignInProvider.this) != null) {
                ViewHelper.showDialog(CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.title_activity_sign_in), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.login_failed) + "\nUser was not verified and resending confirmation code failed.\n" + CognitoUserPoolsSignInProvider.getErrorMessageFromException(exc));
                CognitoUserPoolsSignInProvider.access$800(CognitoUserPoolsSignInProvider.this).onError(CognitoUserPoolsSignInProvider.this, exc);
            }
        }

        public void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
            CognitoUserPoolsSignInProvider.access$700(CognitoUserPoolsSignInProvider.this);
        }
    }

    public class 4 implements AuthenticationHandler {
        public 4() {
        }

        public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
            if (!(challengeContinuation instanceof NewPasswordContinuation)) {
                throw new UnsupportedOperationException("Not supported in this sample.");
            }
            CognitoUserPoolsSignInProvider.access$1202(CognitoUserPoolsSignInProvider.this, (NewPasswordContinuation) challengeContinuation);
            CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).startActivityForResult(new Intent(CognitoUserPoolsSignInProvider.access$600(CognitoUserPoolsSignInProvider.this), ForceChangePasswordActivity.class), RequestCodes.FORCE_CHANGE_PASSWORD_REQUEST_CODE.value);
        }

        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str) {
            if (CognitoUserPoolsSignInProvider.access$200(CognitoUserPoolsSignInProvider.this) == null || CognitoUserPoolsSignInProvider.access$1000(CognitoUserPoolsSignInProvider.this) == null) {
                return;
            }
            authenticationContinuation.setAuthenticationDetails(new AuthenticationDetails(CognitoUserPoolsSignInProvider.access$200(CognitoUserPoolsSignInProvider.this), CognitoUserPoolsSignInProvider.access$1000(CognitoUserPoolsSignInProvider.this), (Map) null));
            authenticationContinuation.continueTask();
        }

        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
            CognitoUserPoolsSignInProvider.access$1102(CognitoUserPoolsSignInProvider.this, multiFactorAuthenticationContinuation);
            CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).startActivityForResult(new Intent(CognitoUserPoolsSignInProvider.access$600(CognitoUserPoolsSignInProvider.this), MFAActivity.class), RequestCodes.MFA_REQUEST_CODE.value);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFailure(java.lang.Exception r7) {
            /*
                r6 = this;
                java.lang.String r0 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$000()
                java.lang.String r1 = "Failed to login."
                android.util.Log.e(r0, r1, r7)
                boolean r0 = r7 instanceof com.amazonaws.services.cognitoidentityprovider.model.UserNotConfirmedException
                if (r0 == 0) goto L13
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r7 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$1300(r7)
                return
            L13:
                boolean r0 = r7 instanceof com.amazonaws.services.cognitoidentityprovider.model.UserNotFoundException
                if (r0 == 0) goto L24
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r0 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                android.app.Activity r0 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$100(r0)
                int r1 = com.amazonaws.mobile.auth.userpools.R.string.user_does_not_exist
            L1f:
                java.lang.String r0 = r0.getString(r1)
                goto L35
            L24:
                boolean r0 = r7 instanceof com.amazonaws.services.cognitoidentityprovider.model.NotAuthorizedException
                if (r0 == 0) goto L31
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r0 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                android.app.Activity r0 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$100(r0)
                int r1 = com.amazonaws.mobile.auth.userpools.R.string.incorrect_username_or_password
                goto L1f
            L31:
                java.lang.String r0 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.getErrorMessageFromException(r7)
            L35:
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r1 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler r1 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$800(r1)
                if (r1 == 0) goto L7d
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r1 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                android.app.Activity r1 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$100(r1)
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r2 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                android.app.Activity r2 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$100(r2)
                int r3 = com.amazonaws.mobile.auth.userpools.R.string.title_activity_sign_in
                java.lang.String r2 = r2.getString(r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r4 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                android.app.Activity r4 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$100(r4)
                int r5 = com.amazonaws.mobile.auth.userpools.R.string.login_failed
                java.lang.String r4 = r4.getString(r5)
                r3.append(r4)
                java.lang.String r4 = " "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                com.amazonaws.mobile.auth.core.internal.util.ViewHelper.showDialog(r1, r2, r0)
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r0 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler r0 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.access$800(r0)
                com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider r1 = com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.this
                r0.onError(r1, r7)
            L7d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider.4.onFailure(java.lang.Exception):void");
        }

        public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
            Log.i(CognitoUserPoolsSignInProvider.access$000(), "Logged in. " + cognitoUserSession.getIdToken());
            CognitoUserPoolsSignInProvider.access$902(CognitoUserPoolsSignInProvider.this, cognitoUserSession);
            if (CognitoUserPoolsSignInProvider.access$800(CognitoUserPoolsSignInProvider.this) != null) {
                CognitoUserPoolsSignInProvider.access$800(CognitoUserPoolsSignInProvider.this).onSuccess(CognitoUserPoolsSignInProvider.this);
            }
        }
    }

    public class 5 implements View.OnClickListener {
        public 5() {
        }

        public void onClick(View view) {
            SignUpActivity.startActivity(CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this), RequestCodes.SIGN_UP_REQUEST_CODE.value);
        }
    }

    public class 6 implements View.OnClickListener {
        final /* synthetic */ UserPoolSignInView val$userPoolSignInView;

        public 6(UserPoolSignInView userPoolSignInView) {
            this.val$userPoolSignInView = userPoolSignInView;
        }

        public void onClick(View view) {
            CognitoUserPoolsSignInProvider.access$202(CognitoUserPoolsSignInProvider.this, this.val$userPoolSignInView.getEnteredUserName());
            if (CognitoUserPoolsSignInProvider.access$200(CognitoUserPoolsSignInProvider.this).length() >= 1) {
                CognitoUserPoolsSignInProvider.access$300(CognitoUserPoolsSignInProvider.this).getUser(CognitoUserPoolsSignInProvider.access$200(CognitoUserPoolsSignInProvider.this)).forgotPasswordInBackground(CognitoUserPoolsSignInProvider.access$1400(CognitoUserPoolsSignInProvider.this));
            } else {
                Log.w(CognitoUserPoolsSignInProvider.access$000(), "Missing username.");
                ViewHelper.showDialog(CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this), CognitoUserPoolsSignInProvider.access$100(CognitoUserPoolsSignInProvider.this).getString(R.string.title_activity_sign_in), "Missing username.");
            }
        }
    }

    public class 7 implements View.OnClickListener {
        final /* synthetic */ UserPoolSignInView val$userPoolSignInView;

        public 7(UserPoolSignInView userPoolSignInView) {
            this.val$userPoolSignInView = userPoolSignInView;
        }

        public void onClick(View view) {
            CognitoUserPoolsSignInProvider.access$202(CognitoUserPoolsSignInProvider.this, this.val$userPoolSignInView.getEnteredUserName());
            CognitoUserPoolsSignInProvider.access$1002(CognitoUserPoolsSignInProvider.this, this.val$userPoolSignInView.getEnteredPassword());
            CognitoUserPoolsSignInProvider.this.signInUser();
        }
    }

    public static /* synthetic */ class 8 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$auth$userpools$CognitoUserPoolsSignInProvider$RequestCodes;

        static {
            int[] iArr = new int[RequestCodes.values().length];
            $SwitchMap$com$amazonaws$mobile$auth$userpools$CognitoUserPoolsSignInProvider$RequestCodes = iArr;
            try {
                iArr[RequestCodes.FORGOT_PASSWORD_REQUEST_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$auth$userpools$CognitoUserPoolsSignInProvider$RequestCodes[RequestCodes.SIGN_UP_REQUEST_CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$auth$userpools$CognitoUserPoolsSignInProvider$RequestCodes[RequestCodes.MFA_REQUEST_CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$auth$userpools$CognitoUserPoolsSignInProvider$RequestCodes[RequestCodes.VERIFICATION_REQUEST_CODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$auth$userpools$CognitoUserPoolsSignInProvider$RequestCodes[RequestCodes.FORCE_CHANGE_PASSWORD_REQUEST_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static final class AttributeKeys {
        public static final String BACKGROUND_COLOR = "signInBackgroundColor";
        public static final String CONFIRMATION_DESTINATION = "destination";
        public static final String EMAIL_ADDRESS = "email";
        public static final String FONT_FAMILY = "fontFamily";
        public static final String FULL_SCREEN_BACKGROUND_COLOR = "fullScreenBackgroundColor";
        public static final String GIVEN_NAME = "given_name";
        public static final String IS_SIGN_UP_CONFIRMED = "isSignUpConfirmed";
        public static final String PASSWORD = "password";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String USERNAME = "username";
        public static final String VERIFICATION_CODE = "verification_code";
    }

    public static class RefreshSessionAuthenticationHandler implements AuthenticationHandler {
        private CognitoUserSession userSession;

        private RefreshSessionAuthenticationHandler() {
            this.userSession = null;
        }

        public static /* synthetic */ CognitoUserSession access$1600(RefreshSessionAuthenticationHandler refreshSessionAuthenticationHandler) {
            return refreshSessionAuthenticationHandler.getUserSession();
        }

        private CognitoUserSession getUserSession() {
            return this.userSession;
        }

        public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
            Log.wtf(CognitoUserPoolsSignInProvider.access$000(), "Refresh flow can not trigger request for authentication challenge.");
        }

        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str) {
            Log.d(CognitoUserPoolsSignInProvider.access$000(), "Can't refresh the session silently, due to authentication details needed.");
        }

        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
            Log.wtf(CognitoUserPoolsSignInProvider.access$000(), "Refresh flow can not trigger request for MFA code.");
        }

        public void onFailure(Exception exc) {
            Log.e(CognitoUserPoolsSignInProvider.access$000(), "Can't refresh session.", exc);
        }

        public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
            this.userSession = cognitoUserSession;
        }

        public /* synthetic */ RefreshSessionAuthenticationHandler(1 r1) {
            this();
        }
    }

    public enum RequestCodes {
        FORGOT_PASSWORD_REQUEST_CODE(10650),
        SIGN_UP_REQUEST_CODE(10651),
        MFA_REQUEST_CODE(10652),
        VERIFICATION_REQUEST_CODE(10653),
        FORCE_CHANGE_PASSWORD_REQUEST_CODE(10654);

        public final int value;

        RequestCodes(int i) {
            this.value = i;
        }

        public static RequestCodes valueOf(int i) {
            Log.e(CognitoUserPoolsSignInProvider.access$000(), "valueOf: " + i, new RuntimeException(""));
            for (RequestCodes requestCodes : values()) {
                Log.e(CognitoUserPoolsSignInProvider.access$000(), "valueOf: compare " + requestCodes.value);
                if (i == requestCodes.value) {
                    return requestCodes;
                }
            }
            return null;
        }
    }

    public static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    public static /* synthetic */ Activity access$100(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        return cognitoUserPoolsSignInProvider.activity;
    }

    public static /* synthetic */ String access$1000(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        return cognitoUserPoolsSignInProvider.password;
    }

    public static /* synthetic */ String access$1002(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider, String str) {
        cognitoUserPoolsSignInProvider.password = str;
        return str;
    }

    public static /* synthetic */ MultiFactorAuthenticationContinuation access$1102(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider, MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        cognitoUserPoolsSignInProvider.multiFactorAuthenticationContinuation = multiFactorAuthenticationContinuation;
        return multiFactorAuthenticationContinuation;
    }

    public static /* synthetic */ NewPasswordContinuation access$1202(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider, NewPasswordContinuation newPasswordContinuation) {
        cognitoUserPoolsSignInProvider.mForceChangePasswordContinuation = newPasswordContinuation;
        return newPasswordContinuation;
    }

    public static /* synthetic */ void access$1300(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        cognitoUserPoolsSignInProvider.resendConfirmationCode();
    }

    public static /* synthetic */ ForgotPasswordHandler access$1400(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        return cognitoUserPoolsSignInProvider.forgotPasswordHandler;
    }

    public static /* synthetic */ String access$200(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        return cognitoUserPoolsSignInProvider.username;
    }

    public static /* synthetic */ String access$202(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider, String str) {
        cognitoUserPoolsSignInProvider.username = str;
        return str;
    }

    public static /* synthetic */ CognitoUserPool access$300(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        return cognitoUserPoolsSignInProvider.cognitoUserPool;
    }

    public static /* synthetic */ AuthenticationHandler access$400(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        return cognitoUserPoolsSignInProvider.authenticationHandler;
    }

    public static /* synthetic */ ForgotPasswordContinuation access$502(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider, ForgotPasswordContinuation forgotPasswordContinuation) {
        cognitoUserPoolsSignInProvider.forgotPasswordContinuation = forgotPasswordContinuation;
        return forgotPasswordContinuation;
    }

    public static /* synthetic */ Context access$600(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        return cognitoUserPoolsSignInProvider.context;
    }

    public static /* synthetic */ void access$700(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        cognitoUserPoolsSignInProvider.startVerificationActivity();
    }

    public static /* synthetic */ SignInProviderResultHandler access$800(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider) {
        return cognitoUserPoolsSignInProvider.resultsHandler;
    }

    public static /* synthetic */ CognitoUserSession access$902(CognitoUserPoolsSignInProvider cognitoUserPoolsSignInProvider, CognitoUserSession cognitoUserSession) {
        cognitoUserPoolsSignInProvider.cognitoUserSession = cognitoUserSession;
        return cognitoUserSession;
    }

    public static int getBackgroundColor() {
        return backgroundColor;
    }

    public static String getErrorMessageFromException(Exception exc) {
        String localizedMessage = exc.getLocalizedMessage();
        if (localizedMessage == null) {
            return exc.getMessage();
        }
        int indexOf = localizedMessage.indexOf("(Service");
        return indexOf == -1 ? localizedMessage : localizedMessage.substring(0, indexOf);
    }

    public static String getFontFamily() {
        return fontFamily;
    }

    public static boolean isBackgroundColorFullScreen() {
        return isBackgroundColorFullScreenEnabled;
    }

    private void resendConfirmationCode() {
        this.cognitoUserPool.getUser(this.username).resendConfirmationCodeInBackground(new 3());
    }

    private void startVerificationActivity() {
        Intent intent = new Intent(this.context, SignUpConfirmActivity.class);
        intent.putExtra("username", this.username);
        intent.putExtra("destination", this.signUpConfirmationDestination);
        this.activity.startActivityForResult(intent, RequestCodes.VERIFICATION_REQUEST_CODE.value);
    }

    public String getCognitoLoginKey() {
        return this.cognitoLoginKey;
    }

    public CognitoUserPool getCognitoUserPool() {
        return this.cognitoUserPool;
    }

    public String getDisplayName() {
        return "Amazon Cognito Your User Pools";
    }

    public String getToken() {
        CognitoUserSession cognitoUserSession = this.cognitoUserSession;
        if (cognitoUserSession == null) {
            return null;
        }
        return cognitoUserSession.getIdToken().getJWTToken();
    }

    public String getValueFromConfig(String str) {
        try {
            return this.awsConfiguration.optJsonObject("CognitoUserPool").getString(str);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Cannot find the CognitoUserPool " + str + " from the AWSConfiguration file.", e);
        }
    }

    public void handleActivityResult(int i, int i2, Intent intent) {
        Activity activity;
        String string;
        StringBuilder sb;
        Activity activity2;
        int i3;
        RequestCodes valueOf = RequestCodes.valueOf(i);
        if (-1 != i2 || valueOf == null) {
            return;
        }
        int i4 = 8.$SwitchMap$com$amazonaws$mobile$auth$userpools$CognitoUserPoolsSignInProvider$RequestCodes[valueOf.ordinal()];
        if (i4 == 1) {
            this.password = intent.getStringExtra("password");
            this.verificationCode = intent.getStringExtra("verification_code");
            if (this.password.length() >= 6) {
                Log.d(LOG_TAG, "verificationCode = " + this.verificationCode);
                this.forgotPasswordContinuation.setPassword(this.password);
                this.forgotPasswordContinuation.setVerificationCode(this.verificationCode);
                this.forgotPasswordContinuation.continueTask();
                return;
            }
            activity = this.activity;
            string = activity.getString(R.string.title_activity_forgot_password);
            sb = new StringBuilder();
            sb.append(this.activity.getString(R.string.password_change_failed));
            sb.append(" ");
            activity2 = this.activity;
            i3 = R.string.password_length_validation_failed;
        } else {
            if (i4 == 2) {
                this.username = intent.getStringExtra("username");
                this.password = intent.getStringExtra("password");
                boolean booleanExtra = intent.getBooleanExtra("isSignUpConfirmed", true);
                this.signUpConfirmationDestination = intent.getStringExtra("destination");
                String str = LOG_TAG;
                Log.d(str, "sign up result username = " + this.username);
                if (!booleanExtra) {
                    Log.w(str, "Additional confirmation for sign up.");
                    startVerificationActivity();
                    return;
                }
                Log.d(str, "Signed up. User ID = " + this.username);
                Activity activity3 = this.activity;
                ViewHelper.showDialog(activity3, activity3.getString(R.string.title_activity_sign_up), this.activity.getString(R.string.sign_up_success) + " " + this.username);
                signInUser();
                return;
            }
            if (i4 == 3) {
                String stringExtra = intent.getStringExtra("verification_code");
                this.verificationCode = stringExtra;
                if (stringExtra.length() >= 1) {
                    Log.d(LOG_TAG, "verificationCode = " + this.verificationCode);
                    this.multiFactorAuthenticationContinuation.setMfaCode(this.verificationCode);
                    this.multiFactorAuthenticationContinuation.continueTask();
                    return;
                }
                activity = this.activity;
                string = activity.getString(R.string.title_activity_mfa);
                sb = new StringBuilder();
                sb.append(this.activity.getString(R.string.mfa_failed));
                sb.append(" ");
                activity2 = this.activity;
                i3 = R.string.mfa_code_empty;
            } else {
                if (i4 != 4) {
                    if (i4 != 5) {
                        Log.e(LOG_TAG, "Unknown Request Code sent.");
                        return;
                    }
                    Log.d(LOG_TAG, "handleActivityResult: FORCE_CHANGE_PASSWORD_REQUEST_CODE");
                    String stringExtra2 = intent.getStringExtra("password");
                    this.password = stringExtra2;
                    this.mForceChangePasswordContinuation.setPassword(stringExtra2);
                    this.mForceChangePasswordContinuation.continueTask();
                    return;
                }
                String str2 = LOG_TAG;
                Log.d(str2, "handleActivityResult: VERIFICATION_REQUEST_CODE");
                this.username = intent.getStringExtra("username");
                this.verificationCode = intent.getStringExtra("verification_code");
                if (this.username.length() < 1) {
                    activity = this.activity;
                    string = activity.getString(R.string.title_activity_sign_up_confirm);
                    sb = new StringBuilder();
                    sb.append(this.activity.getString(R.string.sign_up_confirm_title));
                    sb.append(" ");
                    activity2 = this.activity;
                    i3 = R.string.sign_up_username_missing;
                } else {
                    if (this.verificationCode.length() >= 1) {
                        Log.d(str2, "username = " + this.username);
                        Log.d(str2, "verificationCode = " + this.verificationCode);
                        this.cognitoUserPool.getUser(this.username).confirmSignUpInBackground(this.verificationCode, true, this.signUpConfirmationHandler);
                        return;
                    }
                    activity = this.activity;
                    string = activity.getString(R.string.title_activity_sign_up_confirm);
                    sb = new StringBuilder();
                    sb.append(this.activity.getString(R.string.sign_up_confirm_title));
                    sb.append(" ");
                    activity2 = this.activity;
                    i3 = R.string.sign_up_confirm_code_missing;
                }
            }
        }
        sb.append(activity2.getString(i3));
        ViewHelper.showDialog(activity, string, sb.toString());
    }

    public void initialize(Context context, AWSConfiguration aWSConfiguration) {
        this.context = context;
        this.awsConfiguration = aWSConfiguration;
        Log.d(LOG_TAG, "Initializing Cognito User Pools");
        this.cognitoUserPool = new CognitoUserPool(context, aWSConfiguration);
        this.cognitoLoginKey = "cognito-idp." + getValueFromConfig("Region") + ".amazonaws.com/" + this.cognitoUserPool.getUserPoolId();
    }

    public View.OnClickListener initializeSignInButton(Activity activity, View view, SignInProviderResultHandler signInProviderResultHandler) {
        this.activity = activity;
        this.resultsHandler = signInProviderResultHandler;
        UserPoolSignInView findViewById = activity.findViewById(R.id.user_pool_sign_in_view_id);
        backgroundColor = findViewById.getBackgroundColor();
        fontFamily = findViewById.getFontFamily();
        isBackgroundColorFullScreenEnabled = findViewById.isBackgroundColorFullScreen();
        findViewById.getSignUpTextView().setOnClickListener(new 5());
        findViewById.getForgotPasswordTextView().setOnClickListener(new 6(findViewById));
        7 r4 = new 7(findViewById);
        view.setOnClickListener(r4);
        return r4;
    }

    public boolean isRequestCodeOurs(int i) {
        return RequestCodes.valueOf(i) != null;
    }

    public String refreshToken() {
        CognitoUserSession cognitoUserSession = this.cognitoUserSession;
        if (cognitoUserSession != null && !cognitoUserSession.isValid()) {
            RefreshSessionAuthenticationHandler refreshSessionAuthenticationHandler = new RefreshSessionAuthenticationHandler(null);
            this.cognitoUserPool.getCurrentUser().getSession(refreshSessionAuthenticationHandler);
            if (RefreshSessionAuthenticationHandler.access$1600(refreshSessionAuthenticationHandler) != null) {
                this.cognitoUserSession = RefreshSessionAuthenticationHandler.access$1600(refreshSessionAuthenticationHandler);
            } else {
                Log.e(LOG_TAG, "Could not refresh the Cognito User Pool Token.");
            }
        }
        return getToken();
    }

    public boolean refreshUserSignInState() {
        CognitoUserSession cognitoUserSession = this.cognitoUserSession;
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            return true;
        }
        RefreshSessionAuthenticationHandler refreshSessionAuthenticationHandler = new RefreshSessionAuthenticationHandler(null);
        this.cognitoUserPool.getCurrentUser().getSession(refreshSessionAuthenticationHandler);
        if (RefreshSessionAuthenticationHandler.access$1600(refreshSessionAuthenticationHandler) != null) {
            this.cognitoUserSession = RefreshSessionAuthenticationHandler.access$1600(refreshSessionAuthenticationHandler);
            Log.i(LOG_TAG, "refreshUserSignInState: Signed in with Cognito.");
            return true;
        }
        Log.i(LOG_TAG, "refreshUserSignInState: Not signed in with Cognito.");
        this.cognitoUserSession = null;
        return false;
    }

    public void signInUser() {
        this.cognitoUserPool.getUser(this.username).getSessionInBackground(this.authenticationHandler);
    }

    public void signOut() {
        CognitoUserPool cognitoUserPool = this.cognitoUserPool;
        if (cognitoUserPool == null || cognitoUserPool.getCurrentUser() == null) {
            return;
        }
        this.cognitoUserPool.getCurrentUser().signOut();
        this.cognitoUserSession = null;
        this.username = null;
        this.password = null;
    }
}
