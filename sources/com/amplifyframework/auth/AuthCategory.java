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
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthCategory extends Category implements AuthCategoryBehavior {
    public void confirmResetPassword(String str, String str2, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).confirmResetPassword(str, str2, authConfirmResetPasswordOptions, action, consumer);
    }

    public void confirmSignIn(String str, AuthConfirmSignInOptions authConfirmSignInOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).confirmSignIn(str, authConfirmSignInOptions, consumer, consumer2);
    }

    public void confirmSignUp(String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).confirmSignUp(str, str2, authConfirmSignUpOptions, consumer, consumer2);
    }

    public void confirmUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str, Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).confirmUserAttribute(authUserAttributeKey, str, action, consumer);
    }

    public void deleteUser(Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).deleteUser(action, consumer);
    }

    public void fetchAuthSession(Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).fetchAuthSession(consumer, consumer2);
    }

    public void fetchDevices(Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).fetchDevices(consumer, consumer2);
    }

    public void fetchUserAttributes(Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).fetchUserAttributes(consumer, consumer2);
    }

    public void forgetDevice(AuthDevice authDevice, Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).forgetDevice(authDevice, action, consumer);
    }

    public CategoryType getCategoryType() {
        return CategoryType.AUTH;
    }

    public AuthUser getCurrentUser() {
        return ((AuthPlugin) getSelectedPlugin()).getCurrentUser();
    }

    public void handleWebUISignInResponse(Intent intent) {
        ((AuthPlugin) getSelectedPlugin()).handleWebUISignInResponse(intent);
    }

    public void rememberDevice(Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).rememberDevice(action, consumer);
    }

    public void resendSignUpCode(String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).resendSignUpCode(str, authResendSignUpCodeOptions, consumer, consumer2);
    }

    public void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).resendUserAttributeConfirmationCode(authUserAttributeKey, authResendUserAttributeConfirmationCodeOptions, consumer, consumer2);
    }

    public void resetPassword(String str, AuthResetPasswordOptions authResetPasswordOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).resetPassword(str, authResetPasswordOptions, consumer, consumer2);
    }

    public void signIn(String str, String str2, AuthSignInOptions authSignInOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).signIn(str, str2, authSignInOptions, consumer, consumer2);
    }

    public void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).signInWithSocialWebUI(authProvider, activity, authWebUISignInOptions, consumer, consumer2);
    }

    public void signInWithWebUI(Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).signInWithWebUI(activity, authWebUISignInOptions, consumer, consumer2);
    }

    public void signOut(AuthSignOutOptions authSignOutOptions, Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).signOut(authSignOutOptions, action, consumer);
    }

    public void signUp(String str, String str2, AuthSignUpOptions authSignUpOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).signUp(str, str2, authSignUpOptions, consumer, consumer2);
    }

    public void updatePassword(String str, String str2, Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).updatePassword(str, str2, action, consumer);
    }

    public void updateUserAttribute(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).updateUserAttribute(authUserAttribute, authUpdateUserAttributeOptions, consumer, consumer2);
    }

    public void updateUserAttributes(List list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).updateUserAttributes(list, authUpdateUserAttributesOptions, consumer, consumer2);
    }

    public void confirmResetPassword(String str, String str2, Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).confirmResetPassword(str, str2, action, consumer);
    }

    public void confirmSignIn(String str, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).confirmSignIn(str, consumer, consumer2);
    }

    public void confirmSignUp(String str, String str2, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).confirmSignUp(str, str2, consumer, consumer2);
    }

    public void forgetDevice(Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).forgetDevice(action, consumer);
    }

    public void resendSignUpCode(String str, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).resendSignUpCode(str, consumer, consumer2);
    }

    public void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).resendUserAttributeConfirmationCode(authUserAttributeKey, consumer, consumer2);
    }

    public void resetPassword(String str, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).resetPassword(str, consumer, consumer2);
    }

    public void signIn(String str, String str2, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).signIn(str, str2, consumer, consumer2);
    }

    public void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).signInWithSocialWebUI(authProvider, activity, consumer, consumer2);
    }

    public void signInWithWebUI(Activity activity, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).signInWithWebUI(activity, consumer, consumer2);
    }

    public void signOut(Action action, Consumer consumer) {
        ((AuthPlugin) getSelectedPlugin()).signOut(action, consumer);
    }

    public void updateUserAttribute(AuthUserAttribute authUserAttribute, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).updateUserAttribute(authUserAttribute, consumer, consumer2);
    }

    public void updateUserAttributes(List list, Consumer consumer, Consumer consumer2) {
        ((AuthPlugin) getSelectedPlugin()).updateUserAttributes(list, consumer, consumer2);
    }
}
