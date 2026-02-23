package com.amplifyframework.auth.cognito;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.results.Tokens;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.result.AuthSessionResult;
import com.amplifyframework.core.Consumer;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class MobileClientSessionAdapter {
    private static final List MOBILE_CLIENT_INVALID_ACCOUNT_MESSAGES = Arrays.asList(new String[]{"getTokens does not support retrieving tokens for federated sign-in", "You must be signed-in with Cognito Userpools to be able to use getTokens", "Tokens are not supported for OAuth2", "Cognito Identity not configured"});
    private static final List MOBILE_CLIENT_SIGNED_OUT_MESSAGES = Arrays.asList(new String[]{"getTokens does not support retrieving tokens while signed-out"});

    public static class 1 implements Callback {
        final /* synthetic */ AWSMobileClient val$awsMobileClient;
        final /* synthetic */ Consumer val$onComplete;

        public 1(AWSMobileClient aWSMobileClient, Consumer consumer) {
            this.val$awsMobileClient = aWSMobileClient;
            this.val$onComplete = consumer;
        }

        public void onError(Exception exc) {
            Consumer consumer;
            AuthSession access$200;
            if (exc.getMessage().contains("Cognito Identity not configured")) {
                consumer = this.val$onComplete;
                access$200 = MobileClientSessionAdapter.access$100();
            } else {
                consumer = this.val$onComplete;
                access$200 = MobileClientSessionAdapter.access$200();
            }
            consumer.accept(access$200);
        }

        public void onResult(AWSCredentials aWSCredentials) {
            MobileClientSessionAdapter.access$000(aWSCredentials, this.val$awsMobileClient, this.val$onComplete);
        }
    }

    public static class 2 implements Callback {
        final /* synthetic */ AWSMobileClient val$awsMobileClient;
        final /* synthetic */ Consumer val$onComplete;

        public 2(AWSMobileClient aWSMobileClient, Consumer consumer) {
            this.val$awsMobileClient = aWSMobileClient;
            this.val$onComplete = consumer;
        }

        public void onError(Exception exc) {
            if (MobileClientSessionAdapter.access$400().contains(exc.getMessage())) {
                MobileClientSessionAdapter.access$500(this.val$awsMobileClient, this.val$onComplete);
            } else if (MobileClientSessionAdapter.access$600().contains(exc.getMessage())) {
                MobileClientSessionAdapter.fetchSignedOutSession(this.val$awsMobileClient, this.val$onComplete);
            } else {
                MobileClientSessionAdapter.access$300(AuthSessionResult.failure(new AuthException.UnknownException(exc)), AuthSessionResult.failure(new AuthException.UnknownException(exc)), this.val$awsMobileClient, this.val$onComplete);
            }
        }

        public void onResult(Tokens tokens) {
            AuthSessionResult failure;
            try {
                failure = AuthSessionResult.success(CognitoJWTParser.getPayload(tokens.getAccessToken().getTokenString()).getString("sub"));
            } catch (JSONException e) {
                failure = AuthSessionResult.failure(new AuthException.UnknownException(e));
            }
            MobileClientSessionAdapter.access$300(failure, AuthSessionResult.success(new AWSCognitoUserPoolTokens(tokens.getAccessToken().getTokenString(), tokens.getIdToken().getTokenString(), tokens.getRefreshToken().getTokenString())), this.val$awsMobileClient, this.val$onComplete);
        }
    }

    public static class 3 implements Callback {
        final /* synthetic */ AWSMobileClient val$awsMobileClient;
        final /* synthetic */ Consumer val$onComplete;
        final /* synthetic */ AuthSessionResult val$tokensResult;
        final /* synthetic */ AuthSessionResult val$userSubResult;

        public 3(AuthSessionResult authSessionResult, AuthSessionResult authSessionResult2, AWSMobileClient aWSMobileClient, Consumer consumer) {
            this.val$userSubResult = authSessionResult;
            this.val$tokensResult = authSessionResult2;
            this.val$awsMobileClient = aWSMobileClient;
            this.val$onComplete = consumer;
        }

        public void onError(Exception exc) {
            AuthException invalidAccountTypeException = MobileClientSessionAdapter.access$400().contains(exc.getMessage()) ? new AuthException.InvalidAccountTypeException(exc) : new AuthException.UnknownException(exc);
            this.val$onComplete.accept(new AWSCognitoAuthSession(true, AuthSessionResult.failure(invalidAccountTypeException), AuthSessionResult.failure(invalidAccountTypeException), this.val$userSubResult, this.val$tokensResult));
        }

        public void onResult(AWSCredentials aWSCredentials) {
            if (aWSCredentials != null) {
                MobileClientSessionAdapter.access$700(AuthSessionResult.success(aWSCredentials), this.val$userSubResult, this.val$tokensResult, this.val$awsMobileClient, this.val$onComplete);
            } else {
                AuthException authException = new AuthException("Could not fetch AWS Cognito credentials, but there was no error reported back from AWSMobileClient.getAWSCredentials call.", "This is a bug with the underlying AWSMobileClient");
                this.val$onComplete.accept(new AWSCognitoAuthSession(true, AuthSessionResult.failure(authException), AuthSessionResult.failure(authException), this.val$userSubResult, this.val$tokensResult));
            }
        }
    }

    private MobileClientSessionAdapter() {
    }

    public static /* synthetic */ void access$000(AWSCredentials aWSCredentials, AWSMobileClient aWSMobileClient, Consumer consumer) {
        fetchSignedOutSessionWithAWSCredentials(aWSCredentials, aWSMobileClient, consumer);
    }

    public static /* synthetic */ AuthSession access$100() {
        return signedOutSessionWithoutIdentityPool();
    }

    public static /* synthetic */ AuthSession access$200() {
        return signedOutSessionWithIdentityPool();
    }

    public static /* synthetic */ void access$300(AuthSessionResult authSessionResult, AuthSessionResult authSessionResult2, AWSMobileClient aWSMobileClient, Consumer consumer) {
        fetchSignedInSessionWithUserPoolResults(authSessionResult, authSessionResult2, aWSMobileClient, consumer);
    }

    public static /* synthetic */ List access$400() {
        return MOBILE_CLIENT_INVALID_ACCOUNT_MESSAGES;
    }

    public static /* synthetic */ void access$500(AWSMobileClient aWSMobileClient, Consumer consumer) {
        fetchIdentityPoolOnlySignedInSession(aWSMobileClient, consumer);
    }

    public static /* synthetic */ List access$600() {
        return MOBILE_CLIENT_SIGNED_OUT_MESSAGES;
    }

    public static /* synthetic */ void access$700(AuthSessionResult authSessionResult, AuthSessionResult authSessionResult2, AuthSessionResult authSessionResult3, AWSMobileClient aWSMobileClient, Consumer consumer) {
        fetchSignedInSessionWithUserPoolAndAWSCredentialResults(authSessionResult, authSessionResult2, authSessionResult3, aWSMobileClient, consumer);
    }

    private static void fetchIdentityPoolOnlySignedInSession(AWSMobileClient aWSMobileClient, Consumer consumer) {
        fetchSignedInSessionWithUserPoolResults(AuthSessionResult.failure(new AuthException.InvalidAccountTypeException()), AuthSessionResult.failure(new AuthException.InvalidAccountTypeException()), aWSMobileClient, consumer);
    }

    public static void fetchSignedInSession(AWSMobileClient aWSMobileClient, Consumer consumer) {
        aWSMobileClient.getTokens(new 2(aWSMobileClient, consumer));
    }

    private static void fetchSignedInSessionWithUserPoolAndAWSCredentialResults(AuthSessionResult authSessionResult, AuthSessionResult authSessionResult2, AuthSessionResult authSessionResult3, AWSMobileClient aWSMobileClient, Consumer consumer) {
        try {
            String identityId = aWSMobileClient.getIdentityId();
            consumer.accept(new AWSCognitoAuthSession(true, identityId != null ? AuthSessionResult.success(identityId) : AuthSessionResult.failure(new AuthException("AWSMobileClient returned awsCredentials but no identity id and no error", "This should never happen and is a bug with AWSMobileClient.")), authSessionResult, authSessionResult2, authSessionResult3));
        } catch (Throwable th) {
            consumer.accept(new AWSCognitoAuthSession(true, AuthSessionResult.failure(new AuthException.UnknownException(th)), authSessionResult, authSessionResult2, authSessionResult3));
        }
    }

    private static void fetchSignedInSessionWithUserPoolResults(AuthSessionResult authSessionResult, AuthSessionResult authSessionResult2, AWSMobileClient aWSMobileClient, Consumer consumer) {
        aWSMobileClient.getAWSCredentials(new 3(authSessionResult, authSessionResult2, aWSMobileClient, consumer));
    }

    public static void fetchSignedOutSession(AWSMobileClient aWSMobileClient, Consumer consumer) {
        aWSMobileClient.getAWSCredentials(new 1(aWSMobileClient, consumer));
    }

    private static void fetchSignedOutSessionWithAWSCredentials(AWSCredentials aWSCredentials, AWSMobileClient aWSMobileClient, Consumer consumer) {
        try {
            consumer.accept(new AWSCognitoAuthSession(false, AuthSessionResult.success(aWSMobileClient.getIdentityId()), AuthSessionResult.success(aWSCredentials), AuthSessionResult.failure(new AuthException.SignedOutException()), AuthSessionResult.failure(new AuthException.SignedOutException())));
        } catch (Throwable th) {
            consumer.accept(new AWSCognitoAuthSession(false, AuthSessionResult.failure(new AuthException("Retrieved guest credentials but failed to retrieve Identity ID", th, "This should never happen. See the attached exception for more details.")), AuthSessionResult.success(aWSCredentials), AuthSessionResult.failure(new AuthException.SignedOutException()), AuthSessionResult.failure(new AuthException.SignedOutException())));
        }
    }

    private static AuthSession signedOutSessionWithIdentityPool() {
        AuthException.GuestAccess guestAccess = AuthException.GuestAccess.GUEST_ACCESS_POSSIBLE;
        return new AWSCognitoAuthSession(false, AuthSessionResult.failure(new AuthException.SignedOutException(guestAccess)), AuthSessionResult.failure(new AuthException.SignedOutException(guestAccess)), AuthSessionResult.failure(new AuthException.SignedOutException()), AuthSessionResult.failure(new AuthException.SignedOutException()));
    }

    private static AuthSession signedOutSessionWithoutIdentityPool() {
        return new AWSCognitoAuthSession(false, AuthSessionResult.failure(new AuthException.InvalidAccountTypeException()), AuthSessionResult.failure(new AuthException.InvalidAccountTypeException()), AuthSessionResult.failure(new AuthException.SignedOutException()), AuthSessionResult.failure(new AuthException.SignedOutException()));
    }
}
