package com.amplifyframework.auth;

import android.app.Activity;
import android.content.Intent;
import com.amplifyframework.auth.options.AuthConfirmResetPasswordOptions;
import com.amplifyframework.auth.options.AuthConfirmSignInOptions;
import com.amplifyframework.auth.options.AuthConfirmSignUpOptions;
import com.amplifyframework.auth.options.AuthResendSignUpCodeOptions;
import com.amplifyframework.auth.options.AuthResendUserAttributeConfirmationCodeOptions;
import com.amplifyframework.auth.options.AuthResetPasswordOptions;
import com.amplifyframework.auth.options.AuthSignInOptions;
import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.options.AuthUpdateUserAttributeOptions;
import com.amplifyframework.auth.options.AuthUpdateUserAttributesOptions;
import com.amplifyframework.auth.options.AuthWebUISignInOptions;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AuthCategoryBehavior {
    void confirmResetPassword(String str, String str2, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Action action, Consumer consumer);

    void confirmResetPassword(String str, String str2, Action action, Consumer consumer);

    void confirmSignIn(String str, AuthConfirmSignInOptions authConfirmSignInOptions, Consumer consumer, Consumer consumer2);

    void confirmSignIn(String str, Consumer consumer, Consumer consumer2);

    void confirmSignUp(String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Consumer consumer, Consumer consumer2);

    void confirmSignUp(String str, String str2, Consumer consumer, Consumer consumer2);

    void confirmUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str, Action action, Consumer consumer);

    void deleteUser(Action action, Consumer consumer);

    void fetchAuthSession(Consumer consumer, Consumer consumer2);

    void fetchDevices(Consumer consumer, Consumer consumer2);

    void fetchUserAttributes(Consumer consumer, Consumer consumer2);

    void forgetDevice(AuthDevice authDevice, Action action, Consumer consumer);

    void forgetDevice(Action action, Consumer consumer);

    AuthUser getCurrentUser();

    void handleWebUISignInResponse(Intent intent);

    void rememberDevice(Action action, Consumer consumer);

    void resendSignUpCode(String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Consumer consumer, Consumer consumer2);

    void resendSignUpCode(String str, Consumer consumer, Consumer consumer2);

    void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Consumer consumer, Consumer consumer2);

    void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, Consumer consumer, Consumer consumer2);

    void resetPassword(String str, AuthResetPasswordOptions authResetPasswordOptions, Consumer consumer, Consumer consumer2);

    void resetPassword(String str, Consumer consumer, Consumer consumer2);

    void signIn(String str, String str2, AuthSignInOptions authSignInOptions, Consumer consumer, Consumer consumer2);

    void signIn(String str, String str2, Consumer consumer, Consumer consumer2);

    void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2);

    void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, Consumer consumer, Consumer consumer2);

    void signInWithWebUI(Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2);

    void signInWithWebUI(Activity activity, Consumer consumer, Consumer consumer2);

    void signOut(AuthSignOutOptions authSignOutOptions, Action action, Consumer consumer);

    void signOut(Action action, Consumer consumer);

    void signUp(String str, String str2, AuthSignUpOptions authSignUpOptions, Consumer consumer, Consumer consumer2);

    void updatePassword(String str, String str2, Action action, Consumer consumer);

    void updateUserAttribute(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Consumer consumer, Consumer consumer2);

    void updateUserAttribute(AuthUserAttribute authUserAttribute, Consumer consumer, Consumer consumer2);

    void updateUserAttributes(List list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Consumer consumer, Consumer consumer2);

    void updateUserAttributes(List list, Consumer consumer, Consumer consumer2);
}
