package com.amplifyframework.auth.cognito;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.HostedUIOptions;
import com.amazonaws.mobile.client.SignInUIOptions;
import com.amazonaws.mobile.client.SignOutOptions;
import com.amazonaws.mobile.client.UserState;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.client.results.Device;
import com.amazonaws.mobile.client.results.ForgotPasswordResult;
import com.amazonaws.mobile.client.results.ForgotPasswordState;
import com.amazonaws.mobile.client.results.ListDevicesResult;
import com.amazonaws.mobile.client.results.SignInResult;
import com.amazonaws.mobile.client.results.SignInState;
import com.amazonaws.mobile.client.results.SignUpResult;
import com.amazonaws.mobile.client.results.Tokens;
import com.amazonaws.mobile.client.results.UserCodeDeliveryDetails;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthNavigationException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.amazonaws.services.cognitoidentityprovider.model.NotAuthorizedException;
import com.amplifyframework.auth.AuthChannelEventName;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import com.amplifyframework.auth.AuthDevice;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthPlugin;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthConfirmResetPasswordOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthConfirmSignInOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthConfirmSignUpOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthResendSignUpCodeOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthResendUserAttributeConfirmationCodeOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthResetPasswordOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthSignInOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthSignOutOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthSignUpOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthUpdateUserAttributeOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthUpdateUserAttributesOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthWebUISignInOptions;
import com.amplifyframework.auth.cognito.options.AuthFlowType;
import com.amplifyframework.auth.cognito.util.AuthProviderConverter;
import com.amplifyframework.auth.cognito.util.CognitoAuthExceptionConverter;
import com.amplifyframework.auth.cognito.util.SignInStateConverter;
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
import com.amplifyframework.auth.result.AuthResetPasswordResult;
import com.amplifyframework.auth.result.AuthSessionResult;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.auth.result.AuthUpdateAttributeResult;
import com.amplifyframework.auth.result.step.AuthNextResetPasswordStep;
import com.amplifyframework.auth.result.step.AuthNextSignInStep;
import com.amplifyframework.auth.result.step.AuthNextSignUpStep;
import com.amplifyframework.auth.result.step.AuthNextUpdateAttributeStep;
import com.amplifyframework.auth.result.step.AuthResetPasswordStep;
import com.amplifyframework.auth.result.step.AuthSignInStep;
import com.amplifyframework.auth.result.step.AuthSignUpStep;
import com.amplifyframework.auth.result.step.AuthUpdateAttributeStep;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.util.UserAgent;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthPlugin extends AuthPlugin {
    private static final String AWS_COGNITO_AUTH_PLUGIN_KEY = "awsCognitoAuthPlugin";
    private static final String COGNITO_USER_ID_ATTRIBUTE = "sub";
    private static final String MOBILE_CLIENT_TOKEN_KEY = "token";
    private static final long SECONDS_BEFORE_TIMEOUT = 10;
    public static final int WEB_UI_SIGN_IN_ACTIVITY_CODE = 49281;
    private AWSMobileClient awsMobileClient;
    private AuthChannelEventName lastEvent;
    private String userId;

    public class 1 implements Callback {
        final /* synthetic */ AtomicReference val$asyncException;
        final /* synthetic */ CountDownLatch val$latch;

        public 1(CountDownLatch countDownLatch, AtomicReference atomicReference) {
            this.val$latch = countDownLatch;
            this.val$asyncException = atomicReference;
        }

        public static /* synthetic */ void a(1 r0) {
            r0.lambda$null$0();
        }

        public static /* synthetic */ void b(1 r0, UserStateDetails userStateDetails) {
            r0.lambda$onResult$2(userStateDetails);
        }

        public static /* synthetic */ void c() {
            lambda$null$1();
        }

        private /* synthetic */ void lambda$null$0() {
            AuthChannelEventName access$000 = AWSCognitoAuthPlugin.access$000(AWSCognitoAuthPlugin.this);
            AuthChannelEventName authChannelEventName = AuthChannelEventName.SIGNED_IN;
            if (access$000 != authChannelEventName) {
                AWSCognitoAuthPlugin.access$002(AWSCognitoAuthPlugin.this, authChannelEventName);
                Amplify.Hub.publish(HubChannel.AUTH, HubEvent.create(authChannelEventName));
            }
        }

        private static /* synthetic */ void lambda$null$1() {
        }

        private /* synthetic */ void lambda$onResult$2(UserStateDetails userStateDetails) {
            AuthChannelEventName authChannelEventName;
            int i = 25.$SwitchMap$com$amazonaws$mobile$client$UserState[userStateDetails.getUserState().ordinal()];
            if (i == 1 || i == 2) {
                AWSCognitoAuthPlugin.access$102(AWSCognitoAuthPlugin.this, null);
                AuthChannelEventName access$000 = AWSCognitoAuthPlugin.access$000(AWSCognitoAuthPlugin.this);
                authChannelEventName = AuthChannelEventName.SIGNED_OUT;
                if (access$000 == authChannelEventName) {
                    return;
                }
            } else {
                if (i == 3) {
                    AWSCognitoAuthPlugin.access$400(AWSCognitoAuthPlugin.this, new b(this));
                    return;
                }
                if (i != 4 && i != 5) {
                    AWSCognitoAuthPlugin.access$102(AWSCognitoAuthPlugin.this, null);
                    return;
                }
                AWSCognitoAuthPlugin.access$400(AWSCognitoAuthPlugin.this, new c());
                AuthChannelEventName access$0002 = AWSCognitoAuthPlugin.access$000(AWSCognitoAuthPlugin.this);
                authChannelEventName = AuthChannelEventName.SESSION_EXPIRED;
                if (access$0002 == authChannelEventName) {
                    return;
                }
            }
            AWSCognitoAuthPlugin.access$002(AWSCognitoAuthPlugin.this, authChannelEventName);
            Amplify.Hub.publish(HubChannel.AUTH, HubEvent.create(authChannelEventName));
        }

        public void onError(Exception exc) {
            this.val$asyncException.set(exc);
            this.val$latch.countDown();
        }

        public void onResult(UserStateDetails userStateDetails) {
            AWSCognitoAuthPlugin aWSCognitoAuthPlugin;
            AuthChannelEventName authChannelEventName;
            int i = 25.$SwitchMap$com$amazonaws$mobile$client$UserState[userStateDetails.getUserState().ordinal()];
            if (i == 1 || i == 2) {
                AWSCognitoAuthPlugin.access$002(AWSCognitoAuthPlugin.this, AuthChannelEventName.SIGNED_OUT);
                AWSCognitoAuthPlugin.access$102(AWSCognitoAuthPlugin.this, null);
            } else {
                if (i == 3) {
                    aWSCognitoAuthPlugin = AWSCognitoAuthPlugin.this;
                    authChannelEventName = AuthChannelEventName.SIGNED_IN;
                } else if (i == 4 || i == 5) {
                    aWSCognitoAuthPlugin = AWSCognitoAuthPlugin.this;
                    authChannelEventName = AuthChannelEventName.SESSION_EXPIRED;
                } else {
                    AWSCognitoAuthPlugin.access$102(AWSCognitoAuthPlugin.this, null);
                    AWSCognitoAuthPlugin.access$002(AWSCognitoAuthPlugin.this, null);
                }
                AWSCognitoAuthPlugin.access$002(aWSCognitoAuthPlugin, authChannelEventName);
                AWSCognitoAuthPlugin aWSCognitoAuthPlugin2 = AWSCognitoAuthPlugin.this;
                AWSCognitoAuthPlugin.access$102(aWSCognitoAuthPlugin2, AWSCognitoAuthPlugin.access$200(aWSCognitoAuthPlugin2, (String) userStateDetails.getDetails().get("token")));
            }
            AWSCognitoAuthPlugin.access$300(AWSCognitoAuthPlugin.this).addUserStateListener(new a(this));
            this.val$latch.countDown();
        }
    }

    public class 10 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Action val$onSuccess;

        public 10(Action action, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$onException = consumer;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Forget device failed."));
        }

        public void onResult(Void r1) {
            this.val$onSuccess.call();
        }
    }

    public class 11 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;

        public 11(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onException = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Fetching devices failed."));
        }

        public void onResult(ListDevicesResult listDevicesResult) {
            ArrayList arrayList = new ArrayList();
            Iterator it = listDevicesResult.getDevices().iterator();
            while (it.hasNext()) {
                arrayList.add(AuthDevice.fromId(((Device) it.next()).getDeviceKey()));
            }
            this.val$onSuccess.accept(arrayList);
        }
    }

    public class 12 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;

        public 12(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onException = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Reset password failed."));
        }

        public void onResult(ForgotPasswordResult forgotPasswordResult) {
            Consumer consumer;
            Object authException;
            if (forgotPasswordResult.getState().equals(ForgotPasswordState.CONFIRMATION_CODE)) {
                consumer = this.val$onSuccess;
                authException = new AuthResetPasswordResult(false, new AuthNextResetPasswordStep(AuthResetPasswordStep.CONFIRM_RESET_PASSWORD_WITH_CODE, Collections.emptyMap(), AWSCognitoAuthPlugin.access$800(AWSCognitoAuthPlugin.this, forgotPasswordResult.getParameters())));
            } else {
                consumer = this.val$onException;
                authException = new AuthException("Received an unsupported response after triggering password recovery: " + forgotPasswordResult.getState(), "This is almost certainly a bug. Please report it as an issue in our GitHub repo.");
            }
            consumer.accept(authException);
        }
    }

    public class 13 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Action val$onSuccess;

        public 13(Action action, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$onException = consumer;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Confirm reset password failed."));
        }

        public void onResult(ForgotPasswordResult forgotPasswordResult) {
            if (forgotPasswordResult.getState().equals(ForgotPasswordState.DONE)) {
                this.val$onSuccess.call();
                return;
            }
            this.val$onException.accept(new AuthException("Received an unsupported response while confirming password recovery code: " + forgotPasswordResult.getState(), "This is almost certainly a bug. Please report it as an issue in our GitHub repo."));
        }
    }

    public class 14 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Action val$onSuccess;

        public 14(Action action, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$onException = consumer;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Update password failed."));
        }

        public void onResult(Void r1) {
            this.val$onSuccess.call();
        }
    }

    public class 15 implements Callback {
        final /* synthetic */ Consumer val$onError;
        final /* synthetic */ Consumer val$onSuccess;

        public 15(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onError = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onError.accept(CognitoAuthExceptionConverter.lookup(exc, "Fetching user attributes failed."));
        }

        public void onResult(Map map) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new AuthUserAttribute(AuthUserAttributeKey.custom((String) entry.getKey()), (String) entry.getValue()));
            }
            this.val$onSuccess.accept(arrayList);
        }
    }

    public class 16 implements Callback {
        final /* synthetic */ Consumer val$onError;
        final /* synthetic */ Consumer val$onSuccess;

        public 16(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onError = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onError.accept(new AuthException("Failed to update user attributes", exc, "See attached exception for more details"));
        }

        public void onResult(List list) {
            if (list.size() == 0) {
                this.val$onSuccess.accept(new AuthUpdateAttributeResult(true, new AuthNextUpdateAttributeStep(AuthUpdateAttributeStep.DONE, Collections.emptyMap(), null)));
            } else {
                this.val$onSuccess.accept(new AuthUpdateAttributeResult(true, new AuthNextUpdateAttributeStep(AuthUpdateAttributeStep.CONFIRM_ATTRIBUTE_WITH_CODE, Collections.emptyMap(), AWSCognitoAuthPlugin.access$800(AWSCognitoAuthPlugin.this, (UserCodeDeliveryDetails) list.get(0)))));
            }
        }
    }

    public class 17 implements Callback {
        final /* synthetic */ Map val$attributesMap;
        final /* synthetic */ Consumer val$onError;
        final /* synthetic */ Consumer val$onSuccess;

        public 17(Map map, Consumer consumer, Consumer consumer2) {
            this.val$attributesMap = map;
            this.val$onSuccess = consumer;
            this.val$onError = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onError.accept(new AuthException("Failed to update user attributes", exc, "See attached exception for more details"));
        }

        public void onResult(List list) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                UserCodeDeliveryDetails userCodeDeliveryDetails = (UserCodeDeliveryDetails) it.next();
                hashMap.put(userCodeDeliveryDetails.getAttributeName(), userCodeDeliveryDetails);
            }
            for (String str : this.val$attributesMap.keySet()) {
                if (hashMap.containsKey(str)) {
                    hashMap2.put(AuthUserAttributeKey.custom(str), new AuthUpdateAttributeResult(true, new AuthNextUpdateAttributeStep(AuthUpdateAttributeStep.CONFIRM_ATTRIBUTE_WITH_CODE, Collections.emptyMap(), AWSCognitoAuthPlugin.access$800(AWSCognitoAuthPlugin.this, (UserCodeDeliveryDetails) hashMap.get(str)))));
                } else {
                    hashMap2.put(AuthUserAttributeKey.custom(str), new AuthUpdateAttributeResult(true, new AuthNextUpdateAttributeStep(AuthUpdateAttributeStep.DONE, Collections.emptyMap(), null)));
                }
            }
            this.val$onSuccess.accept(hashMap2);
        }
    }

    public class 18 implements Callback {
        final /* synthetic */ Consumer val$onError;
        final /* synthetic */ Consumer val$onSuccess;

        public 18(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onError = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onError.accept(new AuthException("Failed to resend user attribute confirmation code", exc, "See attached exception for more details"));
        }

        public void onResult(UserCodeDeliveryDetails userCodeDeliveryDetails) {
            this.val$onSuccess.accept(AWSCognitoAuthPlugin.access$800(AWSCognitoAuthPlugin.this, userCodeDeliveryDetails));
        }
    }

    public class 19 implements Callback {
        final /* synthetic */ Consumer val$onError;
        final /* synthetic */ Action val$onSuccess;

        public 19(Action action, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$onError = consumer;
        }

        public void onError(Exception exc) {
            this.val$onError.accept(CognitoAuthExceptionConverter.lookup(exc, "Confirming user attributes failed."));
        }

        public void onResult(Void r1) {
            this.val$onSuccess.call();
        }
    }

    public class 2 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;
        final /* synthetic */ String val$username;

        public 2(Consumer consumer, String str, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$username = str;
            this.val$onException = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Sign up failed"));
        }

        public void onResult(SignUpResult signUpResult) {
            this.val$onSuccess.accept(AWSCognitoAuthPlugin.access$500(AWSCognitoAuthPlugin.this, signUpResult, this.val$username));
        }
    }

    public class 20 implements Callback {
        final /* synthetic */ Consumer val$onError;
        final /* synthetic */ Action val$onSuccess;
        final /* synthetic */ AuthSignOutOptions val$options;

        public 20(Action action, AuthSignOutOptions authSignOutOptions, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$options = authSignOutOptions;
            this.val$onError = consumer;
        }

        public void onError(Exception exc) {
            Consumer consumer;
            Object authException;
            if (exc instanceof NotAuthorizedException) {
                AWSCognitoAuthPlugin.access$900(AWSCognitoAuthPlugin.this, this.val$options, this.val$onSuccess, this.val$onError);
                return;
            }
            if (exc instanceof AuthNavigationException) {
                consumer = this.val$onError;
                authException = new AuthException.UserCancelledException("The user cancelled the sign-out attempt.", exc, "To recover, catch this error, and retry sign-out.");
            } else {
                consumer = this.val$onError;
                authException = new AuthException("Failed to sign out globally", exc, "See attached exception for more details");
            }
            consumer.accept(authException);
        }

        public void onResult(Void r1) {
            this.val$onSuccess.call();
        }
    }

    public class 21 implements Callback {
        final /* synthetic */ Consumer val$onError;
        final /* synthetic */ Action val$onSuccess;

        public 21(Action action, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$onError = consumer;
        }

        public void onError(Exception exc) {
            this.val$onError.accept(CognitoAuthExceptionConverter.lookup(exc, "Delete user failed."));
        }

        public void onResult(Void r3) {
            Amplify.Hub.publish(HubChannel.AUTH, HubEvent.create(AuthChannelEventName.USER_DELETED));
            this.val$onSuccess.call();
        }
    }

    public class 22 implements Callback {
        final /* synthetic */ Consumer val$onError;
        final /* synthetic */ Action val$onSuccess;

        public 22(Action action, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$onError = consumer;
        }

        public void onError(Exception exc) {
            Consumer consumer;
            Object authException;
            if (exc != null && exc.getMessage() != null && exc.getMessage().contains("signed-out")) {
                this.val$onError.accept(new AuthException("Failed to sign out since Auth is already signed out", "No need to sign out - you already are!"));
                return;
            }
            if (exc instanceof AuthNavigationException) {
                consumer = this.val$onError;
                authException = new AuthException.UserCancelledException("The user cancelled the sign-out attempt.", exc, "To recover, catch this error, and retry sign-out.");
            } else {
                consumer = this.val$onError;
                authException = new AuthException("Failed to sign out", exc, "See attached exception for more details");
            }
            consumer.accept(authException);
        }

        public void onResult(Void r1) {
            this.val$onSuccess.call();
        }
    }

    public class 23 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;

        public 23(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onException = consumer2;
        }

        public static /* synthetic */ void a(Consumer consumer, UserStateDetails userStateDetails) {
            lambda$onResult$0(consumer, userStateDetails);
        }

        private static /* synthetic */ void lambda$onResult$0(Consumer consumer, UserStateDetails userStateDetails) {
            consumer.accept(new AuthSignInResult(UserState.SIGNED_IN.equals(userStateDetails.getUserState()), new AuthNextSignInStep(AuthSignInStep.DONE, userStateDetails.getDetails(), null)));
        }

        public void onError(Exception exc) {
            Consumer consumer;
            Object authException;
            if (exc instanceof AuthNavigationException) {
                consumer = this.val$onException;
                authException = new AuthException.UserCancelledException("The user cancelled the sign-in attempt, so it did not complete.", exc, "To recover: catch this error, and show the sign-in screen again.");
            } else {
                consumer = this.val$onException;
                authException = new AuthException("Sign-in with web UI failed", exc, "See attached exception for more details");
            }
            consumer.accept(authException);
        }

        public void onResult(UserStateDetails userStateDetails) {
            AWSCognitoAuthPlugin.access$400(AWSCognitoAuthPlugin.this, new d(this.val$onSuccess, userStateDetails));
        }
    }

    public class 24 implements Callback {
        final /* synthetic */ Action val$onComplete;

        public 24(Action action) {
            this.val$onComplete = action;
        }

        public void onError(Exception exc) {
            AWSCognitoAuthPlugin.access$102(AWSCognitoAuthPlugin.this, null);
            this.val$onComplete.call();
        }

        public void onResult(Tokens tokens) {
            AWSCognitoAuthPlugin aWSCognitoAuthPlugin = AWSCognitoAuthPlugin.this;
            AWSCognitoAuthPlugin.access$102(aWSCognitoAuthPlugin, AWSCognitoAuthPlugin.access$200(aWSCognitoAuthPlugin, tokens.getAccessToken().getTokenString()));
            this.val$onComplete.call();
        }
    }

    public static /* synthetic */ class 25 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$UserState;

        static {
            int[] iArr = new int[UserState.values().length];
            $SwitchMap$com$amazonaws$mobile$client$UserState = iArr;
            try {
                iArr[UserState.GUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT_FEDERATED_TOKENS_INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class 3 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;
        final /* synthetic */ String val$username;

        public 3(Consumer consumer, String str, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$username = str;
            this.val$onException = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Confirm sign up failed"));
        }

        public void onResult(SignUpResult signUpResult) {
            this.val$onSuccess.accept(AWSCognitoAuthPlugin.access$500(AWSCognitoAuthPlugin.this, signUpResult, this.val$username));
        }
    }

    public class 4 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;
        final /* synthetic */ String val$username;

        public 4(Consumer consumer, String str, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$username = str;
            this.val$onException = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Resend confirmation code failed"));
        }

        public void onResult(SignUpResult signUpResult) {
            this.val$onSuccess.accept(AWSCognitoAuthPlugin.access$500(AWSCognitoAuthPlugin.this, signUpResult, this.val$username));
        }
    }

    public class 5 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;

        public 5(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onException = consumer2;
        }

        public static /* synthetic */ void a(Consumer consumer, AuthSignInResult authSignInResult) {
            lambda$onResult$0(consumer, authSignInResult);
        }

        private static /* synthetic */ void lambda$onResult$0(Consumer consumer, AuthSignInResult authSignInResult) {
            consumer.accept(authSignInResult);
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Sign in failed"));
        }

        public void onResult(SignInResult signInResult) {
            try {
                AWSCognitoAuthPlugin.access$400(AWSCognitoAuthPlugin.this, new e(this.val$onSuccess, AWSCognitoAuthPlugin.access$600(AWSCognitoAuthPlugin.this, signInResult)));
            } catch (AuthException e) {
                this.val$onException.accept(e);
            }
        }
    }

    public class 6 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;

        public 6(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onException = consumer2;
        }

        public static /* synthetic */ void a(Consumer consumer, AuthSignInResult authSignInResult) {
            lambda$onResult$0(consumer, authSignInResult);
        }

        private static /* synthetic */ void lambda$onResult$0(Consumer consumer, AuthSignInResult authSignInResult) {
            consumer.accept(authSignInResult);
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Confirm sign in failed"));
        }

        public void onResult(SignInResult signInResult) {
            try {
                AWSCognitoAuthPlugin.access$400(AWSCognitoAuthPlugin.this, new f(this.val$onSuccess, AWSCognitoAuthPlugin.access$600(AWSCognitoAuthPlugin.this, signInResult)));
            } catch (AuthException e) {
                this.val$onException.accept(e);
            }
        }
    }

    public class 7 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Consumer val$onSuccess;

        public 7(Consumer consumer, Consumer consumer2) {
            this.val$onSuccess = consumer;
            this.val$onException = consumer2;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Fetching authorization session failed."));
        }

        public void onResult(UserStateDetails userStateDetails) {
            int i = 25.$SwitchMap$com$amazonaws$mobile$client$UserState[userStateDetails.getUserState().ordinal()];
            if (i == 1 || i == 2) {
                MobileClientSessionAdapter.fetchSignedOutSession(AWSCognitoAuthPlugin.access$300(AWSCognitoAuthPlugin.this), this.val$onSuccess);
            } else if (i != 4 && i != 5) {
                MobileClientSessionAdapter.fetchSignedInSession(AWSCognitoAuthPlugin.access$300(AWSCognitoAuthPlugin.this), this.val$onSuccess);
            } else {
                Amplify.Hub.publish(HubChannel.AUTH, HubEvent.create(AuthChannelEventName.SESSION_EXPIRED));
                this.val$onSuccess.accept(AWSCognitoAuthPlugin.access$700(AWSCognitoAuthPlugin.this));
            }
        }
    }

    public class 8 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Action val$onSuccess;

        public 8(Action action, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$onException = consumer;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Remember device failed."));
        }

        public void onResult(Void r1) {
            this.val$onSuccess.call();
        }
    }

    public class 9 implements Callback {
        final /* synthetic */ Consumer val$onException;
        final /* synthetic */ Action val$onSuccess;

        public 9(Action action, Consumer consumer) {
            this.val$onSuccess = action;
            this.val$onException = consumer;
        }

        public void onError(Exception exc) {
            this.val$onException.accept(CognitoAuthExceptionConverter.lookup(exc, "Forget device failed."));
        }

        public void onResult(Void r1) {
            this.val$onSuccess.call();
        }
    }

    public AWSCognitoAuthPlugin() {
        this.awsMobileClient = AWSMobileClient.getInstance();
    }

    public static /* synthetic */ AuthChannelEventName access$000(AWSCognitoAuthPlugin aWSCognitoAuthPlugin) {
        return aWSCognitoAuthPlugin.lastEvent;
    }

    public static /* synthetic */ AuthChannelEventName access$002(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, AuthChannelEventName authChannelEventName) {
        aWSCognitoAuthPlugin.lastEvent = authChannelEventName;
        return authChannelEventName;
    }

    public static /* synthetic */ String access$102(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, String str) {
        aWSCognitoAuthPlugin.userId = str;
        return str;
    }

    public static /* synthetic */ String access$200(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, String str) {
        return aWSCognitoAuthPlugin.getUserIdFromToken(str);
    }

    public static /* synthetic */ AWSMobileClient access$300(AWSCognitoAuthPlugin aWSCognitoAuthPlugin) {
        return aWSCognitoAuthPlugin.awsMobileClient;
    }

    public static /* synthetic */ void access$400(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, Action action) {
        aWSCognitoAuthPlugin.fetchAndSetUserId(action);
    }

    public static /* synthetic */ AuthSignUpResult access$500(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, SignUpResult signUpResult, String str) {
        return aWSCognitoAuthPlugin.convertSignUpResult(signUpResult, str);
    }

    public static /* synthetic */ AuthSignInResult access$600(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, SignInResult signInResult) throws AuthException {
        return aWSCognitoAuthPlugin.convertSignInResult(signInResult);
    }

    public static /* synthetic */ AuthSession access$700(AWSCognitoAuthPlugin aWSCognitoAuthPlugin) {
        return aWSCognitoAuthPlugin.expiredSession();
    }

    public static /* synthetic */ AuthCodeDeliveryDetails access$800(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, UserCodeDeliveryDetails userCodeDeliveryDetails) {
        return aWSCognitoAuthPlugin.convertCodeDeliveryDetails(userCodeDeliveryDetails);
    }

    public static /* synthetic */ void access$900(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, AuthSignOutOptions authSignOutOptions, Action action, Consumer consumer) {
        aWSCognitoAuthPlugin.signOutLocally(authSignOutOptions, action, consumer);
    }

    private AuthCodeDeliveryDetails convertCodeDeliveryDetails(UserCodeDeliveryDetails userCodeDeliveryDetails) {
        if (userCodeDeliveryDetails != null) {
            return new AuthCodeDeliveryDetails(userCodeDeliveryDetails.getDestination(), AuthCodeDeliveryDetails.DeliveryMedium.fromString(userCodeDeliveryDetails.getDeliveryMedium()), userCodeDeliveryDetails.getAttributeName());
        }
        return null;
    }

    private AuthSignInResult convertSignInResult(SignInResult signInResult) throws AuthException {
        return new AuthSignInResult(SignInState.DONE.equals(signInResult.getSignInState()), new AuthNextSignInStep(SignInStateConverter.getAuthSignInStep(signInResult.getSignInState()), signInResult.getParameters() == null ? Collections.emptyMap() : signInResult.getParameters(), convertCodeDeliveryDetails(signInResult.getCodeDetails())));
    }

    private AuthSignUpResult convertSignUpResult(SignUpResult signUpResult, String str) {
        Objects.requireNonNull(signUpResult);
        UserCodeDeliveryDetails userCodeDeliveryDetails = signUpResult.getUserCodeDeliveryDetails();
        return new AuthSignUpResult(true, new AuthNextSignUpStep(signUpResult.getConfirmationState() ? AuthSignUpStep.DONE : AuthSignUpStep.CONFIRM_SIGN_UP_STEP, Collections.emptyMap(), userCodeDeliveryDetails != null ? new AuthCodeDeliveryDetails(userCodeDeliveryDetails.getDestination(), AuthCodeDeliveryDetails.DeliveryMedium.fromString(userCodeDeliveryDetails.getDeliveryMedium()), userCodeDeliveryDetails.getAttributeName()) : null), signUpResult.getUserSub() != null ? new AuthUser(signUpResult.getUserSub(), str) : null);
    }

    private AuthSession expiredSession() {
        return new AWSCognitoAuthSession(true, AuthSessionResult.failure(new AuthException.SessionExpiredException()), AuthSessionResult.failure(new AuthException.SessionExpiredException()), AuthSessionResult.failure(new AuthException.SessionExpiredException()), AuthSessionResult.failure(new AuthException.SessionExpiredException()));
    }

    private void fetchAndSetUserId(Action action) {
        this.awsMobileClient.getTokens(new 24(action));
    }

    private String getUserIdFromToken(String str) {
        try {
            return CognitoJWTParser.getPayload(str).getString("sub");
        } catch (JSONException unused) {
            return null;
        }
    }

    private void signInWithWebUIHelper(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2) {
        HostedUIOptions.Builder builder = HostedUIOptions.builder();
        SignInUIOptions.Builder builder2 = SignInUIOptions.builder();
        if (authWebUISignInOptions != null) {
            if (authWebUISignInOptions.getScopes() != null) {
                builder.scopes((String[]) authWebUISignInOptions.getScopes().toArray(new String[authWebUISignInOptions.getScopes().size()]));
            }
            if (!authWebUISignInOptions.getSignInQueryParameters().isEmpty()) {
                builder.signInQueryParameters(authWebUISignInOptions.getSignInQueryParameters());
            }
            if (!authWebUISignInOptions.getSignOutQueryParameters().isEmpty()) {
                builder.signOutQueryParameters(authWebUISignInOptions.getSignOutQueryParameters());
            }
            if (!authWebUISignInOptions.getTokenQueryParameters().isEmpty()) {
                builder.tokenQueryParameters(authWebUISignInOptions.getTokenQueryParameters());
            }
            if (authWebUISignInOptions instanceof AWSCognitoAuthWebUISignInOptions) {
                AWSCognitoAuthWebUISignInOptions aWSCognitoAuthWebUISignInOptions = (AWSCognitoAuthWebUISignInOptions) authWebUISignInOptions;
                builder.idpIdentifier(aWSCognitoAuthWebUISignInOptions.getIdpIdentifier()).federationProviderName(aWSCognitoAuthWebUISignInOptions.getFederationProviderName());
                builder2.browserPackage(aWSCognitoAuthWebUISignInOptions.getBrowserPackage());
            }
            if (authProvider != null) {
                builder.identityProvider(AuthProviderConverter.getIdentityProvider(authProvider));
            }
        }
        this.awsMobileClient.showSignIn(activity, builder2.hostedUIOptions(builder.build()).build(), new 23(consumer, consumer2));
    }

    private void signOutLocally(AuthSignOutOptions authSignOutOptions, Action action, Consumer consumer) {
        SignOutOptions.Builder invalidateTokens = SignOutOptions.builder().signOutGlobally(false).invalidateTokens(true);
        if (authSignOutOptions instanceof AWSCognitoAuthSignOutOptions) {
            invalidateTokens.browserPackage(((AWSCognitoAuthSignOutOptions) authSignOutOptions).getBrowserPackage());
        }
        this.awsMobileClient.signOut(invalidateTokens.build(), new 22(action, consumer));
    }

    public void configure(JSONObject jSONObject, Context context) throws AuthException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        LogFactory.setLevel(LogFactory.Level.OFF);
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            jSONObject2.put("UserAgentOverride", UserAgent.string());
            this.awsMobileClient.initialize(context, new AWSConfiguration(jSONObject2), new 1(countDownLatch, atomicReference));
            try {
                if (!countDownLatch.await(10L, TimeUnit.SECONDS)) {
                    throw new AuthException("Failed to instantiate AWSMobileClient within 10 seconds", "Check network connectivity");
                }
                if (atomicReference.get() != null) {
                    throw new AuthException("Failed to instantiate AWSMobileClient", (Throwable) atomicReference.get(), "See attached exception for more details");
                }
            } catch (InterruptedException e) {
                throw new AuthException("Failed to instantiate AWSMobileClient", e, "See attached exception for more details");
            }
        } catch (JSONException e2) {
            throw new AuthException("Failed to set user agent string", e2, "There is a possibility that there is a bug if this error persists. Please take a look at \nhttps://github.com/aws-amplify/amplify-android/issues to see if there are any existing issues that \nmatch your scenario, and file an issue with the details of the bug if there isn't.");
        }
    }

    public void confirmResetPassword(String str, String str2, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Action action, Consumer consumer) {
        Map hashMap = new HashMap();
        if (authConfirmResetPasswordOptions instanceof AWSCognitoAuthConfirmResetPasswordOptions) {
            hashMap.putAll(((AWSCognitoAuthConfirmResetPasswordOptions) authConfirmResetPasswordOptions).getMetadata());
        }
        this.awsMobileClient.confirmForgotPassword(str, str2, hashMap, new 13(action, consumer));
    }

    public void confirmSignIn(String str, AuthConfirmSignInOptions authConfirmSignInOptions, Consumer consumer, Consumer consumer2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (authConfirmSignInOptions instanceof AWSCognitoAuthConfirmSignInOptions) {
            AWSCognitoAuthConfirmSignInOptions aWSCognitoAuthConfirmSignInOptions = (AWSCognitoAuthConfirmSignInOptions) authConfirmSignInOptions;
            hashMap.putAll(aWSCognitoAuthConfirmSignInOptions.getMetadata());
            for (AuthUserAttribute authUserAttribute : aWSCognitoAuthConfirmSignInOptions.getUserAttributes()) {
                hashMap2.put(authUserAttribute.getKey().getKeyString(), authUserAttribute.getValue());
            }
        }
        this.awsMobileClient.confirmSignIn(str, hashMap, hashMap2, new 6(consumer, consumer2));
    }

    public void confirmSignUp(String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Consumer consumer, Consumer consumer2) {
        Map hashMap = new HashMap();
        if (authConfirmSignUpOptions instanceof AWSCognitoAuthConfirmSignUpOptions) {
            hashMap.putAll(((AWSCognitoAuthConfirmSignUpOptions) authConfirmSignUpOptions).getClientMetadata());
        }
        this.awsMobileClient.confirmSignUp(str, str2, hashMap, new 3(consumer, str, consumer2));
    }

    public void confirmUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str, Action action, Consumer consumer) {
        this.awsMobileClient.confirmUpdateUserAttribute(authUserAttributeKey.getKeyString(), str, new 19(action, consumer));
    }

    public void deleteUser(Action action, Consumer consumer) {
        this.awsMobileClient.deleteUser(new 21(action, consumer));
    }

    public void fetchAuthSession(Consumer consumer, Consumer consumer2) {
        try {
            this.awsMobileClient.currentUserState(new 7(consumer, consumer2));
        } catch (Throwable th) {
            consumer2.accept(new AuthException("An error occurred fetching authorization details for the current user", th, "See attached exception for more details"));
        }
    }

    public void fetchDevices(Consumer consumer, Consumer consumer2) {
        this.awsMobileClient.getDeviceOperations().list(new 11(consumer, consumer2));
    }

    public void fetchUserAttributes(Consumer consumer, Consumer consumer2) {
        this.awsMobileClient.getUserAttributes(new 15(consumer, consumer2));
    }

    public void forgetDevice(AuthDevice authDevice, Action action, Consumer consumer) {
        this.awsMobileClient.getDeviceOperations().forget(authDevice.getDeviceId(), new 10(action, consumer));
    }

    public AuthUser getCurrentUser() {
        if (this.userId == null || this.awsMobileClient.getUsername() == null) {
            return null;
        }
        return new AuthUser(this.userId, this.awsMobileClient.getUsername());
    }

    public AWSMobileClient getEscapeHatch() {
        return this.awsMobileClient;
    }

    public String getPluginKey() {
        return "awsCognitoAuthPlugin";
    }

    public String getVersion() {
        return "1.37.10";
    }

    public void handleWebUISignInResponse(Intent intent) {
        this.awsMobileClient.handleAuthResponse(intent);
    }

    public void rememberDevice(Action action, Consumer consumer) {
        this.awsMobileClient.getDeviceOperations().updateStatus(true, (Callback) new 8(action, consumer));
    }

    public void resendSignUpCode(String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Consumer consumer, Consumer consumer2) {
        Map hashMap = new HashMap();
        if (authResendSignUpCodeOptions instanceof AWSCognitoAuthResendSignUpCodeOptions) {
            hashMap.putAll(((AWSCognitoAuthResendSignUpCodeOptions) authResendSignUpCodeOptions).getMetadata());
        }
        this.awsMobileClient.resendSignUp(str, hashMap, new 4(consumer, str, consumer2));
    }

    public void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Consumer consumer, Consumer consumer2) {
        Map hashMap = new HashMap();
        if (authResendUserAttributeConfirmationCodeOptions instanceof AWSCognitoAuthResendUserAttributeConfirmationCodeOptions) {
            hashMap.putAll(((AWSCognitoAuthResendUserAttributeConfirmationCodeOptions) authResendUserAttributeConfirmationCodeOptions).getMetadata());
        }
        this.awsMobileClient.verifyUserAttribute(authUserAttributeKey.getKeyString(), hashMap, new 18(consumer, consumer2));
    }

    public void resetPassword(String str, AuthResetPasswordOptions authResetPasswordOptions, Consumer consumer, Consumer consumer2) {
        Map hashMap = new HashMap();
        if (authResetPasswordOptions instanceof AWSCognitoAuthResetPasswordOptions) {
            hashMap.putAll(((AWSCognitoAuthResetPasswordOptions) authResetPasswordOptions).getMetadata());
        }
        this.awsMobileClient.forgotPassword(str, hashMap, new 12(consumer, consumer2));
    }

    public void signIn(String str, String str2, AuthSignInOptions authSignInOptions, Consumer consumer, Consumer consumer2) {
        AuthFlowType authFlowType;
        Map hashMap = new HashMap();
        if (authSignInOptions instanceof AWSCognitoAuthSignInOptions) {
            AWSCognitoAuthSignInOptions aWSCognitoAuthSignInOptions = (AWSCognitoAuthSignInOptions) authSignInOptions;
            hashMap.putAll(aWSCognitoAuthSignInOptions.getMetadata());
            authFlowType = aWSCognitoAuthSignInOptions.getAuthFlowType();
        } else {
            authFlowType = null;
        }
        this.awsMobileClient.signIn(str, str2, hashMap, hashMap, authFlowType != null ? com.amazonaws.services.cognitoidentityprovider.model.AuthFlowType.valueOf(authFlowType.name()) : null, new 5(consumer, consumer2));
    }

    public void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2) {
        Objects.requireNonNull(authProvider);
        Objects.requireNonNull(activity);
        Objects.requireNonNull(authWebUISignInOptions);
        Objects.requireNonNull(consumer);
        Objects.requireNonNull(consumer2);
        signInWithWebUIHelper(authProvider, activity, authWebUISignInOptions, consumer, consumer2);
    }

    public void signInWithWebUI(Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2) {
        Objects.requireNonNull(activity);
        Objects.requireNonNull(authWebUISignInOptions);
        Objects.requireNonNull(consumer);
        Objects.requireNonNull(consumer2);
        signInWithWebUIHelper(null, activity, authWebUISignInOptions, consumer, consumer2);
    }

    public void signOut(AuthSignOutOptions authSignOutOptions, Action action, Consumer consumer) {
        if (authSignOutOptions.isGlobalSignOut()) {
            this.awsMobileClient.signOut(SignOutOptions.builder().signOutGlobally(true).build(), new 20(action, authSignOutOptions, consumer));
        } else {
            signOutLocally(authSignOutOptions, action, consumer);
        }
    }

    public void signUp(String str, String str2, AuthSignUpOptions authSignUpOptions, Consumer consumer, Consumer consumer2) {
        Map map;
        Map map2;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        if (authSignUpOptions.getUserAttributes() != null) {
            for (AuthUserAttribute authUserAttribute : authSignUpOptions.getUserAttributes()) {
                hashMap.put(authUserAttribute.getKey().getKeyString(), authUserAttribute.getValue());
            }
        }
        if (authSignUpOptions instanceof AWSCognitoAuthSignUpOptions) {
            AWSCognitoAuthSignUpOptions aWSCognitoAuthSignUpOptions = (AWSCognitoAuthSignUpOptions) authSignUpOptions;
            Map validationData = aWSCognitoAuthSignUpOptions.getValidationData();
            map2 = aWSCognitoAuthSignUpOptions.getClientMetadata();
            map = validationData;
        } else {
            map = hashMap2;
            map2 = hashMap3;
        }
        this.awsMobileClient.signUp(str, str2, hashMap, map, map2, new 2(consumer, str, consumer2));
    }

    public void updatePassword(String str, String str2, Action action, Consumer consumer) {
        this.awsMobileClient.changePassword(str, str2, new 14(action, consumer));
    }

    public void updateUserAttribute(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Consumer consumer, Consumer consumer2) {
        Map hashMap = new HashMap();
        if (authUpdateUserAttributeOptions instanceof AWSCognitoAuthUpdateUserAttributeOptions) {
            hashMap.putAll(((AWSCognitoAuthUpdateUserAttributeOptions) authUpdateUserAttributeOptions).getMetadata());
        }
        this.awsMobileClient.updateUserAttributes(Collections.singletonMap(authUserAttribute.getKey().getKeyString(), authUserAttribute.getValue()), hashMap, new 16(consumer, consumer2));
    }

    public void updateUserAttributes(List list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Consumer consumer, Consumer consumer2) {
        Map hashMap = new HashMap();
        if (authUpdateUserAttributesOptions instanceof AWSCognitoAuthUpdateUserAttributesOptions) {
            hashMap.putAll(((AWSCognitoAuthUpdateUserAttributesOptions) authUpdateUserAttributesOptions).getMetadata());
        }
        Map hashMap2 = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AuthUserAttribute authUserAttribute = (AuthUserAttribute) it.next();
            hashMap2.put(authUserAttribute.getKey().getKeyString(), authUserAttribute.getValue());
        }
        this.awsMobileClient.updateUserAttributes(hashMap2, hashMap, new 17(hashMap2, consumer, consumer2));
    }

    public AWSCognitoAuthPlugin(AWSMobileClient aWSMobileClient, String str) {
        this.awsMobileClient = aWSMobileClient;
        this.userId = str;
    }

    public void confirmResetPassword(String str, String str2, Action action, Consumer consumer) {
        confirmResetPassword(str, str2, AuthConfirmResetPasswordOptions.defaults(), action, consumer);
    }

    public void confirmSignIn(String str, Consumer consumer, Consumer consumer2) {
        confirmSignIn(str, AuthConfirmSignInOptions.defaults(), consumer, consumer2);
    }

    public void confirmSignUp(String str, String str2, Consumer consumer, Consumer consumer2) {
        confirmSignUp(str, str2, AuthConfirmSignUpOptions.defaults(), consumer, consumer2);
    }

    public void forgetDevice(Action action, Consumer consumer) {
        this.awsMobileClient.getDeviceOperations().forget(new 9(action, consumer));
    }

    public void resendSignUpCode(String str, Consumer consumer, Consumer consumer2) {
        resendSignUpCode(str, AuthResendSignUpCodeOptions.defaults(), consumer, consumer2);
    }

    public void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, Consumer consumer, Consumer consumer2) {
        resendUserAttributeConfirmationCode(authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions.defaults(), consumer, consumer2);
    }

    public void resetPassword(String str, Consumer consumer, Consumer consumer2) {
        resetPassword(str, AuthResetPasswordOptions.defaults(), consumer, consumer2);
    }

    public void signIn(String str, String str2, Consumer consumer, Consumer consumer2) {
        signIn(str, str2, AuthSignInOptions.defaults(), consumer, consumer2);
    }

    public void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, Consumer consumer, Consumer consumer2) {
        Objects.requireNonNull(authProvider);
        Objects.requireNonNull(activity);
        AuthWebUISignInOptions build = AuthWebUISignInOptions.builder().build();
        Objects.requireNonNull(consumer);
        Objects.requireNonNull(consumer2);
        signInWithSocialWebUI(authProvider, activity, build, consumer, consumer2);
    }

    public void signInWithWebUI(Activity activity, Consumer consumer, Consumer consumer2) {
        Objects.requireNonNull(activity);
        AuthWebUISignInOptions build = AuthWebUISignInOptions.builder().build();
        Objects.requireNonNull(consumer);
        Objects.requireNonNull(consumer2);
        signInWithWebUI(activity, build, consumer, consumer2);
    }

    public void signOut(Action action, Consumer consumer) {
        signOut(AuthSignOutOptions.builder().globalSignOut(false).build(), action, consumer);
    }

    public void updateUserAttribute(AuthUserAttribute authUserAttribute, Consumer consumer, Consumer consumer2) {
        updateUserAttribute(authUserAttribute, AuthUpdateUserAttributeOptions.defaults(), consumer, consumer2);
    }

    public void updateUserAttributes(List list, Consumer consumer, Consumer consumer2) {
        updateUserAttributes(list, AuthUpdateUserAttributesOptions.defaults(), consumer, consumer2);
    }
}
