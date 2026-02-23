package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChooseMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.NewPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.RegisterMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.VerifyMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoNotAuthorizedException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.DevicesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.RegisterMfaHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoAccessToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoIdToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoRefreshToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoDeviceHelper;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoSecretHash;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.Hkdf;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenResult;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.AuthenticationResultType;
import com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResult;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserResult;
import com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest;
import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthRequest;
import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthResult;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidParameterException;
import com.amazonaws.services.cognitoidentityprovider.model.ListDevicesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult;
import com.amazonaws.services.cognitoidentityprovider.model.NewDeviceMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeResult;
import com.amazonaws.services.cognitoidentityprovider.model.ResourceNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenResult;
import com.amazonaws.services.cognitoidentityprovider.model.SMSMfaSettingsType;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaSettingsType;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.services.cognitoidentityprovider.model.UserNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenRequest;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResponseType;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResult;
import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import j$.util.DesugarTimeZone;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoUser {
    private static final int SRP_RADIX = 16;
    private final String clientId;
    private final String clientSecret;
    private final AmazonCognitoIdentityProvider cognitoIdentityProviderClient;
    private final Context context;
    private final CognitoUserPool pool;
    private String secretHash;
    private String userId;
    private String usernameInternal;
    private static final Log LOGGER = LogFactory.getLog(CognitoUser.class);
    private static final Object GET_CACHED_SESSION_LOCK = new Object();
    private String deviceKey = null;
    private CognitoUserSession cipSession = null;

    public class 1 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$confirmationCode;
        final /* synthetic */ boolean val$forcedAliasCreation;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                1.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                1.this.val$callback.onFailure(this.val$e);
            }
        }

        public 1(String str, boolean z, Map map, GenericHandler genericHandler) {
            this.val$confirmationCode = str;
            this.val$forcedAliasCreation = z;
            this.val$clientMetadata = map;
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$100(CognitoUser.this, this.val$confirmationCode, this.val$forcedAliasCreation, this.val$clientMetadata);
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 10 implements Runnable {
        final /* synthetic */ GetDetailsHandler val$callback;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            final /* synthetic */ CognitoUserDetails val$userDetails;

            public 1(CognitoUserDetails cognitoUserDetails) {
                this.val$userDetails = cognitoUserDetails;
            }

            public void run() {
                10.this.val$callback.onSuccess(this.val$userDetails);
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                10.this.val$callback.onFailure(this.val$e);
            }
        }

        public 10(CognitoUser cognitoUser, GetDetailsHandler getDetailsHandler) {
            this.val$user = cognitoUser;
            this.val$callback = getDetailsHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                runnable = new 1(CognitoUser.access$700(CognitoUser.this, this.val$user.getCachedSession()));
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 11 implements Runnable {
        final /* synthetic */ String val$attributeName;
        final /* synthetic */ VerificationHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            final /* synthetic */ GetUserAttributeVerificationCodeResult val$getUserAttributeVerificationCodeResult;

            public 1(GetUserAttributeVerificationCodeResult getUserAttributeVerificationCodeResult) {
                this.val$getUserAttributeVerificationCodeResult = getUserAttributeVerificationCodeResult;
            }

            public void run() {
                11.this.val$callback.onSuccess(new CognitoUserCodeDeliveryDetails(this.val$getUserAttributeVerificationCodeResult.getCodeDeliveryDetails()));
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                11.this.val$callback.onFailure(this.val$e);
            }
        }

        public 11(CognitoUser cognitoUser, Map map, String str, VerificationHandler verificationHandler) {
            this.val$user = cognitoUser;
            this.val$clientMetadata = map;
            this.val$attributeName = str;
            this.val$callback = verificationHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                runnable = new 1(CognitoUser.access$800(CognitoUser.this, this.val$clientMetadata, this.val$attributeName, this.val$user.getCachedSession()));
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 12 implements Runnable {
        final /* synthetic */ String val$attributeName;
        final /* synthetic */ GenericHandler val$callback;
        final /* synthetic */ CognitoUser val$user;
        final /* synthetic */ String val$verificationCode;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                12.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                12.this.val$callback.onFailure(this.val$e);
            }
        }

        public 12(CognitoUser cognitoUser, String str, String str2, GenericHandler genericHandler) {
            this.val$user = cognitoUser;
            this.val$attributeName = str;
            this.val$verificationCode = str2;
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$900(CognitoUser.this, this.val$attributeName, this.val$verificationCode, this.val$user.getCachedSession());
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 13 implements Runnable {
        final /* synthetic */ RegisterMfaHandler val$callback;
        final /* synthetic */ String val$sessionToken;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            final /* synthetic */ String val$nextSessionToken;
            final /* synthetic */ Map val$parameters;

            public 1(Map map, String str) {
                this.val$parameters = map;
                this.val$nextSessionToken = str;
            }

            public void run() {
                13 r0 = 13.this;
                RegisterMfaHandler registerMfaHandler = r0.val$callback;
                Context access$000 = CognitoUser.access$000(CognitoUser.this);
                String access$1200 = CognitoUser.access$1200(CognitoUser.this);
                13 r02 = 13.this;
                registerMfaHandler.onVerify(new VerifyMfaContinuation(access$000, access$1200, r02.val$user, r02.val$callback, this.val$parameters, true, this.val$nextSessionToken, true));
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ String val$nextSessionToken;
            final /* synthetic */ Map val$parameters;

            public 2(Map map, String str) {
                this.val$parameters = map;
                this.val$nextSessionToken = str;
            }

            public void run() {
                13 r0 = 13.this;
                RegisterMfaHandler registerMfaHandler = r0.val$callback;
                Context access$000 = CognitoUser.access$000(CognitoUser.this);
                String access$1200 = CognitoUser.access$1200(CognitoUser.this);
                13 r02 = 13.this;
                registerMfaHandler.onVerify(new VerifyMfaContinuation(access$000, access$1200, r02.val$user, r02.val$callback, this.val$parameters, false, this.val$nextSessionToken, true));
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 3(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                13.this.val$callback.onFailure(this.val$e);
            }
        }

        public 13(CognitoUser cognitoUser, String str, RegisterMfaHandler registerMfaHandler) {
            this.val$user = cognitoUser;
            this.val$sessionToken = str;
            this.val$callback = registerMfaHandler;
        }

        public void run() {
            Runnable runnable;
            AssociateSoftwareTokenResult access$1100;
            boolean z;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUserSession cachedSession = this.val$user.getCachedSession();
                if (StringUtils.isBlank(this.val$sessionToken)) {
                    access$1100 = CognitoUser.access$1100(CognitoUser.this, cachedSession);
                    z = false;
                } else {
                    access$1100 = CognitoUser.access$1000(CognitoUser.this, this.val$sessionToken);
                    z = true;
                }
                String session = access$1100.getSession();
                HashMap hashMap = new HashMap();
                hashMap.put("type", "SOFTWARE_TOKEN_MFA");
                hashMap.put("secretKey", access$1100.getSecretCode());
                runnable = z ? new 1(hashMap, session) : new 2(hashMap, session);
            } catch (Exception e) {
                runnable = new 3(e);
            }
            handler.post(runnable);
        }
    }

    public class 14 implements Runnable {
        final /* synthetic */ RegisterMfaHandler val$callback;
        final /* synthetic */ String val$friendlyName;
        final /* synthetic */ String val$sessionToken;
        final /* synthetic */ String val$totpCode;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            final /* synthetic */ String val$newSessionToken;

            public 1(String str) {
                this.val$newSessionToken = str;
            }

            public void run() {
                14.this.val$callback.onSuccess(this.val$newSessionToken);
            }
        }

        public class 2 implements Runnable {
            public 2() {
            }

            public void run() {
                14.this.val$callback.onSuccess(null);
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 3(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                14.this.val$callback.onFailure(this.val$e);
            }
        }

        public 14(CognitoUser cognitoUser, String str, String str2, String str3, RegisterMfaHandler registerMfaHandler) {
            this.val$user = cognitoUser;
            this.val$sessionToken = str;
            this.val$totpCode = str2;
            this.val$friendlyName = str3;
            this.val$callback = registerMfaHandler;
        }

        public void run() {
            Runnable runnable;
            VerifySoftwareTokenResult access$1400;
            boolean z;
            String session;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUserSession cachedSession = this.val$user.getCachedSession();
                if (StringUtils.isBlank(this.val$sessionToken)) {
                    access$1400 = CognitoUser.access$1400(CognitoUser.this, cachedSession, this.val$totpCode, this.val$friendlyName);
                    z = false;
                } else {
                    access$1400 = CognitoUser.access$1300(CognitoUser.this, this.val$sessionToken, this.val$totpCode, this.val$friendlyName);
                    z = true;
                }
                session = access$1400.getSession();
            } catch (Exception e) {
                runnable = new 3(e);
            }
            if (VerifySoftwareTokenResponseType.ERROR.equals(access$1400.getStatus())) {
                throw new CognitoInternalErrorException("verification failed");
            }
            runnable = z ? new 1(session) : new 2();
            handler.post(runnable);
        }
    }

    public class 15 implements Runnable {
        final /* synthetic */ CognitoUserAttributes val$attributes;
        final /* synthetic */ UpdateAttributesHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            final /* synthetic */ List val$attributesVerificationList;

            public 1(List list) {
                this.val$attributesVerificationList = list;
            }

            public void run() {
                15.this.val$callback.onSuccess(this.val$attributesVerificationList);
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                15.this.val$callback.onFailure(this.val$e);
            }
        }

        public 15(CognitoUser cognitoUser, Map map, CognitoUserAttributes cognitoUserAttributes, UpdateAttributesHandler updateAttributesHandler) {
            this.val$user = cognitoUser;
            this.val$clientMetadata = map;
            this.val$attributes = cognitoUserAttributes;
            this.val$callback = updateAttributesHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                UpdateUserAttributesResult access$1500 = CognitoUser.access$1500(CognitoUser.this, this.val$clientMetadata, this.val$attributes, this.val$user.getCachedSession());
                ArrayList arrayList = new ArrayList();
                if (access$1500.getCodeDeliveryDetailsList() != null) {
                    Iterator it = access$1500.getCodeDeliveryDetailsList().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new CognitoUserCodeDeliveryDetails((CodeDeliveryDetailsType) it.next()));
                    }
                }
                runnable = new 1(arrayList);
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 16 implements Runnable {
        final /* synthetic */ List val$attributeNamesToDelete;
        final /* synthetic */ GenericHandler val$callback;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                16.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                16.this.val$callback.onFailure(this.val$e);
            }
        }

        public 16(CognitoUser cognitoUser, List list, GenericHandler genericHandler) {
            this.val$user = cognitoUser;
            this.val$attributeNamesToDelete = list;
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$1600(CognitoUser.this, this.val$attributeNamesToDelete, this.val$user.getCachedSession());
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 17 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                CognitoUser.this.signOut();
                17.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                17.this.val$callback.onFailure(this.val$e);
            }
        }

        public 17(CognitoUser cognitoUser, GenericHandler genericHandler) {
            this.val$user = cognitoUser;
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$1700(CognitoUser.this, this.val$user.getCachedSession());
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 18 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                18.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                18.this.val$callback.onFailure(this.val$e);
            }
        }

        public 18(CognitoUser cognitoUser, GenericHandler genericHandler) {
            this.val$user = cognitoUser;
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$1800(CognitoUser.this, this.val$user.getCachedSession());
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 19 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;
        final /* synthetic */ CognitoUserSettings val$cognitoUserSettings;
        final /* synthetic */ CognitoUserSession val$session;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                19.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                19.this.val$callback.onFailure(this.val$e);
            }
        }

        public 19(CognitoUserSettings cognitoUserSettings, CognitoUserSession cognitoUserSession, GenericHandler genericHandler) {
            this.val$cognitoUserSettings = cognitoUserSettings;
            this.val$session = cognitoUserSession;
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$1900(CognitoUser.this, this.val$cognitoUserSettings, this.val$session);
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ VerificationHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;

        public class 1 implements Runnable {
            final /* synthetic */ ResendConfirmationCodeResult val$resendConfirmationCodeResult;

            public 1(ResendConfirmationCodeResult resendConfirmationCodeResult) {
                this.val$resendConfirmationCodeResult = resendConfirmationCodeResult;
            }

            public void run() {
                2.this.val$callback.onSuccess(new CognitoUserCodeDeliveryDetails(this.val$resendConfirmationCodeResult.getCodeDeliveryDetails()));
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                2.this.val$callback.onFailure(this.val$e);
            }
        }

        public 2(Map map, VerificationHandler verificationHandler) {
            this.val$clientMetadata = map;
            this.val$callback = verificationHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                runnable = new 1(CognitoUser.access$200(CognitoUser.this, this.val$clientMetadata));
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 20 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;
        final /* synthetic */ List val$mfaSettings;
        final /* synthetic */ CognitoUserSession val$session;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                20.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                20.this.val$callback.onFailure(this.val$e);
            }
        }

        public 20(List list, CognitoUserSession cognitoUserSession, GenericHandler genericHandler) {
            this.val$mfaSettings = list;
            this.val$session = cognitoUserSession;
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$2000(CognitoUser.this, this.val$mfaSettings, this.val$session);
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 21 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ CognitoUser val$cognitoUser;
        final /* synthetic */ boolean val$runInBackground;

        public 21(CognitoUser cognitoUser, boolean z, AuthenticationHandler authenticationHandler, Map map) {
            this.val$cognitoUser = cognitoUser;
            this.val$runInBackground = z;
            this.val$callback = authenticationHandler;
            this.val$clientMetadata = map;
        }

        public void run() {
            AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(this.val$cognitoUser, CognitoUser.access$000(CognitoUser.this), this.val$runInBackground, this.val$callback);
            authenticationContinuation.setClientMetaData(this.val$clientMetadata);
            this.val$callback.getAuthenticationDetails(authenticationContinuation, this.val$cognitoUser.getUserId());
        }
    }

    public class 22 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ ResourceNotFoundException val$rna;

        public 22(AuthenticationHandler authenticationHandler, ResourceNotFoundException resourceNotFoundException) {
            this.val$callback = authenticationHandler;
            this.val$rna = resourceNotFoundException;
        }

        public void run() {
            this.val$callback.onFailure(this.val$rna);
        }
    }

    public class 23 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ Exception val$e;

        public 23(AuthenticationHandler authenticationHandler, Exception exc) {
            this.val$callback = authenticationHandler;
            this.val$e = exc;
        }

        public void run() {
            this.val$callback.onFailure(this.val$e);
        }
    }

    public class 24 implements Runnable {
        final /* synthetic */ AuthenticationDetails val$authenticationDetails;
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ boolean val$runInBackground;

        public 24(Map map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
            this.val$clientMetadata = map;
            this.val$authenticationDetails = authenticationDetails;
            this.val$callback = authenticationHandler;
            this.val$runInBackground = z;
        }

        public void run() {
            Runnable access$2600;
            AuthenticationHelper authenticationHelper = new AuthenticationHelper(CognitoUser.access$2100(CognitoUser.this).getUserPoolId());
            try {
                InitiateAuthResult initiateAuth = CognitoUser.access$2300(CognitoUser.this).initiateAuth(CognitoUser.access$2200(CognitoUser.this, this.val$clientMetadata, this.val$authenticationDetails, authenticationHelper));
                CognitoUser.access$2400(CognitoUser.this, initiateAuth.getChallengeParameters());
                if (!"PASSWORD_VERIFIER".equals(initiateAuth.getChallengeName())) {
                    access$2600 = CognitoUser.access$2600(CognitoUser.this, this.val$clientMetadata, initiateAuth, this.val$authenticationDetails, this.val$callback, this.val$runInBackground);
                } else {
                    if (this.val$authenticationDetails.getPassword() == null) {
                        throw new IllegalStateException("Failed to find password in authentication details to response to PASSWORD_VERIFIER challenge");
                    }
                    access$2600 = CognitoUser.this.respondToChallenge(this.val$clientMetadata, CognitoUser.access$2500(CognitoUser.this, this.val$clientMetadata, initiateAuth.getChallengeParameters(), this.val$authenticationDetails.getPassword(), initiateAuth.getChallengeName(), initiateAuth.getSession(), authenticationHelper), this.val$callback, this.val$runInBackground);
                }
                access$2600.run();
            } catch (Exception e) {
                e = e;
                this.val$callback.onFailure(e);
            } catch (ResourceNotFoundException e2) {
                e = e2;
                CognitoUser cognitoUser = CognitoUser.this;
                if (e.getMessage().contains("Device")) {
                    CognitoDeviceHelper.clearCachedDevice(CognitoUser.access$2700(CognitoUser.this), CognitoUser.access$2100(CognitoUser.this).getUserPoolId(), CognitoUser.access$000(CognitoUser.this));
                    AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(cognitoUser, CognitoUser.access$000(CognitoUser.this), this.val$runInBackground, this.val$callback);
                    authenticationContinuation.setClientMetaData(this.val$clientMetadata);
                    this.val$callback.getAuthenticationDetails(authenticationContinuation, cognitoUser.getUserId());
                    return;
                }
                this.val$callback.onFailure(e);
            }
        }
    }

    public class 25 implements Runnable {
        final /* synthetic */ AuthenticationDetails val$authenticationDetails;
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ boolean val$runInBackground;

        public 25(Map map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
            this.val$clientMetadata = map;
            this.val$authenticationDetails = authenticationDetails;
            this.val$callback = authenticationHandler;
            this.val$runInBackground = z;
        }

        public void run() {
            Runnable access$2600;
            try {
                AuthenticationHelper authenticationHelper = new AuthenticationHelper(CognitoUser.this.getUserPoolId());
                InitiateAuthResult initiateAuth = CognitoUser.access$2300(CognitoUser.this).initiateAuth(CognitoUser.access$2800(CognitoUser.this, this.val$clientMetadata, this.val$authenticationDetails, authenticationHelper));
                CognitoUser.access$2400(CognitoUser.this, initiateAuth.getChallengeParameters());
                if (!"PASSWORD_VERIFIER".equals(initiateAuth.getChallengeName())) {
                    access$2600 = CognitoUser.access$2600(CognitoUser.this, this.val$clientMetadata, initiateAuth, this.val$authenticationDetails, this.val$callback, this.val$runInBackground);
                } else {
                    if (this.val$authenticationDetails.getPassword() == null) {
                        throw new IllegalStateException("Failed to find password in authentication details to response to PASSWORD_VERIFIER challenge");
                    }
                    access$2600 = CognitoUser.this.respondToChallenge(this.val$clientMetadata, CognitoUser.access$2500(CognitoUser.this, this.val$clientMetadata, initiateAuth.getChallengeParameters(), this.val$authenticationDetails.getPassword(), initiateAuth.getChallengeName(), initiateAuth.getSession(), authenticationHelper), this.val$callback, this.val$runInBackground);
                }
                access$2600.run();
            } catch (Exception e) {
                this.val$callback.onFailure(e);
            }
        }
    }

    public class 26 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;

        public 26(AuthenticationHandler authenticationHandler) {
            this.val$callback = authenticationHandler;
        }

        public void run() {
            this.val$callback.onFailure(new CognitoInternalErrorException("Authentication failed due to an internal error"));
        }
    }

    public class 27 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ CognitoUserSession val$cognitoUserSession;

        public 27(AuthenticationHandler authenticationHandler, CognitoUserSession cognitoUserSession) {
            this.val$callback = authenticationHandler;
            this.val$cognitoUserSession = cognitoUserSession;
        }

        public void run() {
            this.val$callback.onSuccess(this.val$cognitoUserSession, null);
        }
    }

    public class 28 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ CognitoUserSession val$cognitoUserSession;
        final /* synthetic */ CognitoDevice val$newDevice;

        public 28(AuthenticationHandler authenticationHandler, CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
            this.val$callback = authenticationHandler;
            this.val$cognitoUserSession = cognitoUserSession;
            this.val$newDevice = cognitoDevice;
        }

        public void run() {
            this.val$callback.onSuccess(this.val$cognitoUserSession, this.val$newDevice);
        }
    }

    public class 29 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ CognitoUserSession val$cognitoUserSession;

        public 29(AuthenticationHandler authenticationHandler, CognitoUserSession cognitoUserSession) {
            this.val$callback = authenticationHandler;
            this.val$cognitoUserSession = cognitoUserSession;
        }

        public void run() {
            this.val$callback.onSuccess(this.val$cognitoUserSession, null);
        }
    }

    public class 3 implements Runnable {
        final /* synthetic */ ForgotPasswordHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ CognitoUser val$cognitoUser;

        public class 1 implements Runnable {
            final /* synthetic */ ForgotPasswordContinuation val$continuation;

            public 1(ForgotPasswordContinuation forgotPasswordContinuation) {
                this.val$continuation = forgotPasswordContinuation;
            }

            public void run() {
                3.this.val$callback.getResetCode(this.val$continuation);
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                3.this.val$callback.onFailure(this.val$e);
            }
        }

        public 3(Map map, CognitoUser cognitoUser, ForgotPasswordHandler forgotPasswordHandler) {
            this.val$clientMetadata = map;
            this.val$cognitoUser = cognitoUser;
            this.val$callback = forgotPasswordHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                runnable = new 1(new ForgotPasswordContinuation(this.val$cognitoUser, new CognitoUserCodeDeliveryDetails(CognitoUser.access$300(CognitoUser.this, this.val$clientMetadata).getCodeDeliveryDetails()), true, this.val$callback));
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 30 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;

        public 30(AuthenticationHandler authenticationHandler) {
            this.val$callback = authenticationHandler;
        }

        public void run() {
            this.val$callback.onFailure(new CognitoInternalErrorException("Authentication failed due to an internal error: PASSWORD_VERIFIER challenge encountered not at the start of authentication flow"));
        }
    }

    public class 31 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ MultiFactorAuthenticationContinuation val$multiFactorAuthenticationContinuation;

        public 31(AuthenticationHandler authenticationHandler, MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
            this.val$callback = authenticationHandler;
            this.val$multiFactorAuthenticationContinuation = multiFactorAuthenticationContinuation;
        }

        public void run() {
            this.val$callback.getMFACode(this.val$multiFactorAuthenticationContinuation);
        }
    }

    public class 32 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ ChooseMfaContinuation val$continuation;

        public 32(AuthenticationHandler authenticationHandler, ChooseMfaContinuation chooseMfaContinuation) {
            this.val$callback = authenticationHandler;
            this.val$continuation = chooseMfaContinuation;
        }

        public void run() {
            this.val$callback.authenticationChallenge(this.val$continuation);
        }
    }

    public class 33 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ RegisterMfaContinuation val$continuation;

        public 33(AuthenticationHandler authenticationHandler, RegisterMfaContinuation registerMfaContinuation) {
            this.val$callback = authenticationHandler;
            this.val$continuation = registerMfaContinuation;
        }

        public void run() {
            this.val$callback.authenticationChallenge(this.val$continuation);
        }
    }

    public class 34 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ NewPasswordContinuation val$newPasswordContinuation;

        public 34(AuthenticationHandler authenticationHandler, NewPasswordContinuation newPasswordContinuation) {
            this.val$callback = authenticationHandler;
            this.val$newPasswordContinuation = newPasswordContinuation;
        }

        public void run() {
            this.val$callback.authenticationChallenge(this.val$newPasswordContinuation);
        }
    }

    public class 35 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ ChallengeContinuation val$challengeContinuation;

        public 35(AuthenticationHandler authenticationHandler, ChallengeContinuation challengeContinuation) {
            this.val$callback = authenticationHandler;
            this.val$challengeContinuation = challengeContinuation;
        }

        public void run() {
            this.val$callback.authenticationChallenge(this.val$challengeContinuation);
        }
    }

    public class 36 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ Exception val$e;

        public 36(AuthenticationHandler authenticationHandler, Exception exc) {
            this.val$callback = authenticationHandler;
            this.val$e = exc;
        }

        public void run() {
            this.val$callback.onFailure(this.val$e);
        }
    }

    public class 37 implements Runnable {
        final /* synthetic */ AuthenticationDetails val$authenticationDetails;
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ boolean val$runInBackground;

        public 37(Map map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
            this.val$clientMetadata = map;
            this.val$authenticationDetails = authenticationDetails;
            this.val$callback = authenticationHandler;
            this.val$runInBackground = z;
        }

        public void run() {
            try {
                InitiateAuthResult initiateAuth = CognitoUser.access$2300(CognitoUser.this).initiateAuth(CognitoUser.access$2900(CognitoUser.this, this.val$clientMetadata, this.val$authenticationDetails));
                CognitoUser.access$2702(CognitoUser.this, (String) initiateAuth.getChallengeParameters().get("USER_ID_FOR_SRP"));
                CognitoUser.access$2600(CognitoUser.this, this.val$clientMetadata, initiateAuth, this.val$authenticationDetails, this.val$callback, this.val$runInBackground).run();
            } catch (Exception e) {
                this.val$callback.onFailure(e);
            }
        }
    }

    public class 38 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ CognitoUser val$cognitoUser;
        final /* synthetic */ boolean val$runInBackground;

        public 38(CognitoUser cognitoUser, boolean z, AuthenticationHandler authenticationHandler, Map map) {
            this.val$cognitoUser = cognitoUser;
            this.val$runInBackground = z;
            this.val$callback = authenticationHandler;
            this.val$clientMetadata = map;
        }

        public void run() {
            AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(this.val$cognitoUser, CognitoUser.access$000(CognitoUser.this), this.val$runInBackground, this.val$callback);
            authenticationContinuation.setClientMetaData(this.val$clientMetadata);
            this.val$callback.getAuthenticationDetails(authenticationContinuation, this.val$cognitoUser.getUserId());
        }
    }

    public class 39 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ Exception val$e;

        public 39(AuthenticationHandler authenticationHandler, Exception exc) {
            this.val$callback = authenticationHandler;
            this.val$e = exc;
        }

        public void run() {
            this.val$callback.onFailure(this.val$e);
        }
    }

    public class 4 implements Runnable {
        final /* synthetic */ ForgotPasswordHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$newPassword;
        final /* synthetic */ String val$verificationCode;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                4.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                4.this.val$callback.onFailure(this.val$e);
            }
        }

        public 4(String str, String str2, Map map, ForgotPasswordHandler forgotPasswordHandler) {
            this.val$verificationCode = str;
            this.val$newPassword = str2;
            this.val$clientMetadata = map;
            this.val$callback = forgotPasswordHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$400(CognitoUser.this, this.val$verificationCode, this.val$newPassword, this.val$clientMetadata);
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 40 implements Runnable {
        final /* synthetic */ DevicesHandler val$callback;
        final /* synthetic */ int val$limit;
        final /* synthetic */ String val$paginationToken;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            final /* synthetic */ List val$devicesList;

            public 1(List list) {
                this.val$devicesList = list;
            }

            public void run() {
                40.this.val$callback.onSuccess(this.val$devicesList);
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                40.this.val$callback.onFailure(this.val$e);
            }
        }

        public 40(CognitoUser cognitoUser, int i, String str, DevicesHandler devicesHandler) {
            this.val$user = cognitoUser;
            this.val$limit = i;
            this.val$paginationToken = str;
            this.val$callback = devicesHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                ListDevicesResult access$3100 = CognitoUser.access$3100(CognitoUser.this, this.val$user.getCachedSession(), this.val$limit, this.val$paginationToken);
                ArrayList arrayList = new ArrayList();
                Iterator it = access$3100.getDevices().iterator();
                while (it.hasNext()) {
                    arrayList.add(new CognitoDevice((DeviceType) it.next(), this.val$user, CognitoUser.access$000(CognitoUser.this)));
                }
                runnable = new 1(arrayList);
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 5 implements Runnable {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ CognitoUser val$cognitoUser;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                5 r0 = 5.this;
                r0.val$callback.onSuccess(CognitoUser.access$500(CognitoUser.this), null);
            }
        }

        public class 2 implements Runnable {
            public 2() {
            }

            public void run() {
                5 r1 = 5.this;
                AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(r1.val$cognitoUser, CognitoUser.access$000(CognitoUser.this), true, 5.this.val$callback);
                5 r12 = 5.this;
                r12.val$callback.getAuthenticationDetails(authenticationContinuation, r12.val$cognitoUser.getUserId());
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 3(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                5.this.val$callback.onFailure(this.val$e);
            }
        }

        public 5(AuthenticationHandler authenticationHandler, CognitoUser cognitoUser) {
            this.val$callback = authenticationHandler;
            this.val$cognitoUser = cognitoUser;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.this.getCachedSession();
                runnable = new 1();
            } catch (CognitoNotAuthorizedException unused) {
                runnable = new 2();
            } catch (Exception e) {
                runnable = new 3(e);
            }
            handler.post(runnable);
        }
    }

    public class 6 implements AuthenticationHandler {
        final /* synthetic */ AuthenticationHandler val$callback;
        final /* synthetic */ boolean val$runInBackground;

        public class 1 implements Runnable {
            final /* synthetic */ CognitoDevice val$newDevice;
            final /* synthetic */ CognitoUserSession val$userSession;

            public 1(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
                this.val$userSession = cognitoUserSession;
                this.val$newDevice = cognitoDevice;
            }

            public void run() {
                6.this.val$callback.onSuccess(this.val$userSession, this.val$newDevice);
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ AuthenticationContinuation val$authenticationContinuation;
            final /* synthetic */ String val$userId;

            public 2(AuthenticationContinuation authenticationContinuation, String str) {
                this.val$authenticationContinuation = authenticationContinuation;
                this.val$userId = str;
            }

            public void run() {
                6.this.val$callback.getAuthenticationDetails(this.val$authenticationContinuation, this.val$userId);
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ MultiFactorAuthenticationContinuation val$continuation;

            public 3(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                this.val$continuation = multiFactorAuthenticationContinuation;
            }

            public void run() {
                6.this.val$callback.getMFACode(this.val$continuation);
            }
        }

        public class 4 implements Runnable {
            final /* synthetic */ ChallengeContinuation val$continuation;

            public 4(ChallengeContinuation challengeContinuation) {
                this.val$continuation = challengeContinuation;
            }

            public void run() {
                6.this.val$callback.authenticationChallenge(this.val$continuation);
            }
        }

        public class 5 implements Runnable {
            final /* synthetic */ Exception val$exception;

            public 5(Exception exc) {
                this.val$exception = exc;
            }

            public void run() {
                6.this.val$callback.onFailure(this.val$exception);
            }
        }

        public 6(boolean z, AuthenticationHandler authenticationHandler) {
            this.val$runInBackground = z;
            this.val$callback = authenticationHandler;
        }

        public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
            if (this.val$runInBackground) {
                new Handler(Looper.getMainLooper()).post(new 4(challengeContinuation));
            } else {
                this.val$callback.authenticationChallenge(challengeContinuation);
            }
        }

        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str) {
            if (this.val$runInBackground) {
                new Handler(Looper.getMainLooper()).post(new 2(authenticationContinuation, str));
            } else {
                this.val$callback.getAuthenticationDetails(authenticationContinuation, str);
            }
        }

        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
            if (this.val$runInBackground) {
                new Handler(Looper.getMainLooper()).post(new 3(multiFactorAuthenticationContinuation));
            } else {
                this.val$callback.getMFACode(multiFactorAuthenticationContinuation);
            }
        }

        public void onFailure(Exception exc) {
            if (this.val$runInBackground) {
                new Handler(Looper.getMainLooper()).post(new 5(exc));
            } else {
                this.val$callback.onFailure(exc);
            }
        }

        public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
            if (this.val$runInBackground) {
                new Handler(Looper.getMainLooper()).post(new 1(cognitoUserSession, cognitoDevice));
            } else {
                this.val$callback.onSuccess(cognitoUserSession, cognitoDevice);
            }
        }
    }

    public class 7 implements Runnable {
        final /* synthetic */ Runnable val$task;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                7.this.val$task.run();
            }
        }

        public 7(Runnable runnable) {
            this.val$task = runnable;
        }

        public void run() {
            new Thread(new 1()).start();
        }
    }

    public class 8 implements Runnable {
        final /* synthetic */ AuthenticationDetails val$authenticationDetails;
        final /* synthetic */ AuthenticationHandler val$callback;

        public 8(AuthenticationHandler authenticationHandler, AuthenticationDetails authenticationDetails) {
            this.val$callback = authenticationHandler;
            this.val$authenticationDetails = authenticationDetails;
        }

        public void run() {
            this.val$callback.onFailure(new CognitoParameterInvalidException("Unsupported authentication type " + this.val$authenticationDetails.getAuthenticationType()));
        }
    }

    public class 9 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;
        final /* synthetic */ String val$newUserPassword;
        final /* synthetic */ String val$oldUserPassword;
        final /* synthetic */ CognitoUser val$user;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                9.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                9.this.val$callback.onFailure(this.val$e);
            }
        }

        public 9(CognitoUser cognitoUser, String str, String str2, GenericHandler genericHandler) {
            this.val$user = cognitoUser;
            this.val$oldUserPassword = str;
            this.val$newUserPassword = str2;
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUser.access$000(CognitoUser.this).getMainLooper());
            try {
                CognitoUser.access$600(CognitoUser.this, this.val$oldUserPassword, this.val$newUserPassword, this.val$user.getCachedSession());
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public static class AuthenticationHelper {
        private static final String DERIVED_KEY_INFO = "Caldera Derived Key";
        private static final int DERIVED_KEY_SIZE = 16;
        private static final int EPHEMERAL_KEY_LENGTH = 1024;
        private static final BigInteger GG;
        private static final String HEX_N = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF";
        private static final BigInteger KK;
        private static final BigInteger N;
        private static final SecureRandom SECURE_RANDOM;
        private static final ThreadLocal THREAD_MESSAGE_DIGEST;
        private BigInteger A;
        private BigInteger a;
        private String poolName;

        public static class 1 extends ThreadLocal {
            public MessageDigest initialValue() {
                try {
                    return MessageDigest.getInstance("SHA-256");
                } catch (NoSuchAlgorithmException e) {
                    throw new CognitoInternalErrorException("Exception in authentication", e);
                }
            }
        }

        static {
            BigInteger bigInteger = new BigInteger("FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF", 16);
            N = bigInteger;
            BigInteger valueOf = BigInteger.valueOf(2L);
            GG = valueOf;
            1 r2 = new 1();
            THREAD_MESSAGE_DIGEST = r2;
            try {
                SECURE_RANDOM = SecureRandom.getInstance("SHA1PRNG");
                MessageDigest messageDigest = (MessageDigest) r2.get();
                messageDigest.reset();
                messageDigest.update(bigInteger.toByteArray());
                KK = new BigInteger(1, messageDigest.digest(valueOf.toByteArray()));
            } catch (NoSuchAlgorithmException e) {
                throw new CognitoInternalErrorException(e.getMessage(), e);
            }
        }

        public AuthenticationHelper(String str) {
            BigInteger bigInteger;
            BigInteger modPow;
            do {
                BigInteger bigInteger2 = new BigInteger(1024, SECURE_RANDOM);
                bigInteger = N;
                BigInteger mod = bigInteger2.mod(bigInteger);
                this.a = mod;
                modPow = GG.modPow(mod, bigInteger);
                this.A = modPow;
            } while (modPow.mod(bigInteger).equals(BigInteger.ZERO));
            this.poolName = str.contains("_") ? str.split("_", 2)[1] : str;
        }

        public static /* synthetic */ BigInteger access$3000() {
            return N;
        }

        public BigInteger getA() {
            return this.A;
        }

        public byte[] getPasswordAuthenticationKey(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2) {
            MessageDigest messageDigest = (MessageDigest) THREAD_MESSAGE_DIGEST.get();
            messageDigest.reset();
            messageDigest.update(this.A.toByteArray());
            BigInteger bigInteger3 = new BigInteger(1, messageDigest.digest(bigInteger.toByteArray()));
            if (bigInteger3.equals(BigInteger.ZERO)) {
                throw new CognitoInternalErrorException("Hash of A and B cannot be zero");
            }
            messageDigest.reset();
            String str3 = this.poolName;
            Charset charset = StringUtils.UTF8;
            messageDigest.update(str3.getBytes(charset));
            messageDigest.update(str.getBytes(charset));
            messageDigest.update(":".getBytes(charset));
            byte[] digest = messageDigest.digest(str2.getBytes(charset));
            messageDigest.reset();
            messageDigest.update(bigInteger2.toByteArray());
            BigInteger bigInteger4 = new BigInteger(1, messageDigest.digest(digest));
            BigInteger bigInteger5 = KK;
            BigInteger bigInteger6 = GG;
            BigInteger bigInteger7 = N;
            BigInteger mod = bigInteger.subtract(bigInteger5.multiply(bigInteger6.modPow(bigInteger4, bigInteger7))).modPow(this.a.add(bigInteger3.multiply(bigInteger4)), bigInteger7).mod(bigInteger7);
            try {
                Hkdf hkdf = Hkdf.getInstance("HmacSHA256");
                hkdf.init(mod.toByteArray(), bigInteger3.toByteArray());
                return hkdf.deriveKey("Caldera Derived Key", 16);
            } catch (NoSuchAlgorithmException e) {
                throw new CognitoInternalErrorException(e.getMessage(), e);
            }
        }

        public BigInteger geta() {
            return this.a;
        }
    }

    public CognitoUser(CognitoUserPool cognitoUserPool, String str, String str2, String str3, String str4, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider, Context context) {
        this.pool = cognitoUserPool;
        this.context = context;
        this.userId = str;
        this.cognitoIdentityProviderClient = amazonCognitoIdentityProvider;
        this.clientId = str2;
        this.clientSecret = str3;
        this.secretHash = str4;
    }

    public static /* synthetic */ Context access$000(CognitoUser cognitoUser) {
        return cognitoUser.context;
    }

    public static /* synthetic */ void access$100(CognitoUser cognitoUser, String str, boolean z, Map map) {
        cognitoUser.confirmSignUpInternal(str, z, map);
    }

    public static /* synthetic */ AssociateSoftwareTokenResult access$1000(CognitoUser cognitoUser, String str) {
        return cognitoUser.associateTotpMfaInternalWithSession(str);
    }

    public static /* synthetic */ AssociateSoftwareTokenResult access$1100(CognitoUser cognitoUser, CognitoUserSession cognitoUserSession) {
        return cognitoUser.associateTotpMfaInternalWithTokens(cognitoUserSession);
    }

    public static /* synthetic */ String access$1200(CognitoUser cognitoUser) {
        return cognitoUser.clientId;
    }

    public static /* synthetic */ VerifySoftwareTokenResult access$1300(CognitoUser cognitoUser, String str, String str2, String str3) {
        return cognitoUser.verifyTotpAssociationWithSession(str, str2, str3);
    }

    public static /* synthetic */ VerifySoftwareTokenResult access$1400(CognitoUser cognitoUser, CognitoUserSession cognitoUserSession, String str, String str2) {
        return cognitoUser.verifyTotpAssociationWithTokens(cognitoUserSession, str, str2);
    }

    public static /* synthetic */ UpdateUserAttributesResult access$1500(CognitoUser cognitoUser, Map map, CognitoUserAttributes cognitoUserAttributes, CognitoUserSession cognitoUserSession) {
        return cognitoUser.updateAttributesInternal(map, cognitoUserAttributes, cognitoUserSession);
    }

    public static /* synthetic */ void access$1600(CognitoUser cognitoUser, List list, CognitoUserSession cognitoUserSession) {
        cognitoUser.deleteAttributesInternal(list, cognitoUserSession);
    }

    public static /* synthetic */ void access$1700(CognitoUser cognitoUser, CognitoUserSession cognitoUserSession) {
        cognitoUser.globalSignOutInternal(cognitoUserSession);
    }

    public static /* synthetic */ void access$1800(CognitoUser cognitoUser, CognitoUserSession cognitoUserSession) {
        cognitoUser.deleteUserInternal(cognitoUserSession);
    }

    public static /* synthetic */ void access$1900(CognitoUser cognitoUser, CognitoUserSettings cognitoUserSettings, CognitoUserSession cognitoUserSession) {
        cognitoUser.setUserSettingsInternal(cognitoUserSettings, cognitoUserSession);
    }

    public static /* synthetic */ ResendConfirmationCodeResult access$200(CognitoUser cognitoUser, Map map) {
        return cognitoUser.resendConfirmationCodeInternal(map);
    }

    public static /* synthetic */ void access$2000(CognitoUser cognitoUser, List list, CognitoUserSession cognitoUserSession) {
        cognitoUser.setUserMfaSettingsInternal(list, cognitoUserSession);
    }

    public static /* synthetic */ CognitoUserPool access$2100(CognitoUser cognitoUser) {
        return cognitoUser.pool;
    }

    public static /* synthetic */ InitiateAuthRequest access$2200(CognitoUser cognitoUser, Map map, AuthenticationDetails authenticationDetails, AuthenticationHelper authenticationHelper) {
        return cognitoUser.initiateUserSrpAuthRequest(map, authenticationDetails, authenticationHelper);
    }

    public static /* synthetic */ AmazonCognitoIdentityProvider access$2300(CognitoUser cognitoUser) {
        return cognitoUser.cognitoIdentityProviderClient;
    }

    public static /* synthetic */ void access$2400(CognitoUser cognitoUser, Map map) {
        cognitoUser.updateInternalUsername(map);
    }

    public static /* synthetic */ RespondToAuthChallengeRequest access$2500(CognitoUser cognitoUser, Map map, Map map2, String str, String str2, String str3, AuthenticationHelper authenticationHelper) {
        return cognitoUser.userSrpAuthRequest(map, map2, str, str2, str3, authenticationHelper);
    }

    public static /* synthetic */ Runnable access$2600(CognitoUser cognitoUser, Map map, InitiateAuthResult initiateAuthResult, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        return cognitoUser.handleChallenge(map, initiateAuthResult, authenticationDetails, authenticationHandler, z);
    }

    public static /* synthetic */ String access$2700(CognitoUser cognitoUser) {
        return cognitoUser.usernameInternal;
    }

    public static /* synthetic */ String access$2702(CognitoUser cognitoUser, String str) {
        cognitoUser.usernameInternal = str;
        return str;
    }

    public static /* synthetic */ InitiateAuthRequest access$2800(CognitoUser cognitoUser, Map map, AuthenticationDetails authenticationDetails, AuthenticationHelper authenticationHelper) {
        return cognitoUser.initiateCustomAuthRequest(map, authenticationDetails, authenticationHelper);
    }

    public static /* synthetic */ InitiateAuthRequest access$2900(CognitoUser cognitoUser, Map map, AuthenticationDetails authenticationDetails) {
        return cognitoUser.initiateUserPasswordAuthRequest(map, authenticationDetails);
    }

    public static /* synthetic */ ForgotPasswordResult access$300(CognitoUser cognitoUser, Map map) {
        return cognitoUser.forgotPasswordInternal(map);
    }

    public static /* synthetic */ ListDevicesResult access$3100(CognitoUser cognitoUser, CognitoUserSession cognitoUserSession, int i, String str) {
        return cognitoUser.listDevicesInternal(cognitoUserSession, i, str);
    }

    public static /* synthetic */ void access$400(CognitoUser cognitoUser, String str, String str2, Map map) {
        cognitoUser.confirmPasswordInternal(str, str2, map);
    }

    public static /* synthetic */ CognitoUserSession access$500(CognitoUser cognitoUser) {
        return cognitoUser.cipSession;
    }

    public static /* synthetic */ void access$600(CognitoUser cognitoUser, String str, String str2, CognitoUserSession cognitoUserSession) {
        cognitoUser.changePasswordInternal(str, str2, cognitoUserSession);
    }

    public static /* synthetic */ CognitoUserDetails access$700(CognitoUser cognitoUser, CognitoUserSession cognitoUserSession) {
        return cognitoUser.getUserDetailsInternal(cognitoUserSession);
    }

    public static /* synthetic */ GetUserAttributeVerificationCodeResult access$800(CognitoUser cognitoUser, Map map, String str, CognitoUserSession cognitoUserSession) {
        return cognitoUser.getAttributeVerificationCodeInternal(map, str, cognitoUserSession);
    }

    public static /* synthetic */ VerifyUserAttributeResult access$900(CognitoUser cognitoUser, String str, String str2, CognitoUserSession cognitoUserSession) {
        return cognitoUser.verifyAttributeInternal(str, str2, cognitoUserSession);
    }

    private AssociateSoftwareTokenResult associateTotpMfaInternal(AssociateSoftwareTokenRequest associateSoftwareTokenRequest) {
        return this.cognitoIdentityProviderClient.associateSoftwareToken(associateSoftwareTokenRequest);
    }

    private AssociateSoftwareTokenResult associateTotpMfaInternalWithSession(String str) {
        if (str == null) {
            throw new CognitoNotAuthorizedException("session token is invalid");
        }
        AssociateSoftwareTokenRequest associateSoftwareTokenRequest = new AssociateSoftwareTokenRequest();
        associateSoftwareTokenRequest.setSession(str);
        return associateTotpMfaInternal(associateSoftwareTokenRequest);
    }

    private AssociateSoftwareTokenResult associateTotpMfaInternalWithTokens(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        AssociateSoftwareTokenRequest associateSoftwareTokenRequest = new AssociateSoftwareTokenRequest();
        associateSoftwareTokenRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        return associateTotpMfaInternal(associateSoftwareTokenRequest);
    }

    private void changePasswordInternal(String str, String str2, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setPreviousPassword(str);
        changePasswordRequest.setProposedPassword(str2);
        changePasswordRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        this.cognitoIdentityProviderClient.changePassword(changePasswordRequest);
    }

    private void clearCachedTokens() {
        try {
            String format = String.format("CognitoIdentityProvider.%s.%s.idToken", new Object[]{this.clientId, this.userId});
            String format2 = String.format("CognitoIdentityProvider.%s.%s.accessToken", new Object[]{this.clientId, this.userId});
            String format3 = String.format("CognitoIdentityProvider.%s.%s.refreshToken", new Object[]{this.clientId, this.userId});
            this.pool.awsKeyValueStore.remove(format);
            this.pool.awsKeyValueStore.remove(format2);
            this.pool.awsKeyValueStore.remove(format3);
        } catch (Exception e) {
            LOGGER.error("Error while deleting from SharedPreferences", e);
        }
    }

    private ConfirmDeviceResult confirmDevice(NewDeviceMetadataType newDeviceMetadataType) {
        Map generateVerificationParameters = CognitoDeviceHelper.generateVerificationParameters(newDeviceMetadataType.getDeviceKey(), newDeviceMetadataType.getDeviceGroupKey());
        new ConfirmDeviceResult().setUserConfirmationNecessary(Boolean.FALSE);
        try {
            ConfirmDeviceResult confirmDeviceInternal = confirmDeviceInternal(getCachedSession(), newDeviceMetadataType.getDeviceKey(), (String) generateVerificationParameters.get("verifier"), (String) generateVerificationParameters.get("salt"), CognitoDeviceHelper.getDeviceName());
            CognitoDeviceHelper.cacheDeviceKey(this.usernameInternal, this.pool.getUserPoolId(), newDeviceMetadataType.getDeviceKey(), this.context);
            CognitoDeviceHelper.cacheDeviceVerifier(this.usernameInternal, this.pool.getUserPoolId(), (String) generateVerificationParameters.get("secret"), this.context);
            CognitoDeviceHelper.cacheDeviceGroupKey(this.usernameInternal, this.pool.getUserPoolId(), newDeviceMetadataType.getDeviceGroupKey(), this.context);
            return confirmDeviceInternal;
        } catch (Exception e) {
            LOGGER.error("Device confirmation failed: ", e);
            return null;
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    private com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult confirmDeviceInternal(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r2v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
        	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
        	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
        	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
        	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
        	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
        	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
        	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
        	at java.util.ArrayList.forEach(ArrayList.java:1262)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
        */

    private void confirmPasswordInternal(String str, String str2, Map map) {
        ConfirmForgotPasswordRequest confirmForgotPasswordRequest = new ConfirmForgotPasswordRequest();
        confirmForgotPasswordRequest.setUsername(this.userId);
        confirmForgotPasswordRequest.setClientId(this.clientId);
        confirmForgotPasswordRequest.setSecretHash(this.secretHash);
        confirmForgotPasswordRequest.setConfirmationCode(str);
        confirmForgotPasswordRequest.setPassword(str2);
        confirmForgotPasswordRequest.setUserContextData(getUserContextData());
        confirmForgotPasswordRequest.setClientMetadata(map);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            confirmForgotPasswordRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        this.cognitoIdentityProviderClient.confirmForgotPassword(confirmForgotPasswordRequest);
    }

    private void confirmSignUpInternal(String str, boolean z, Map map) {
        ConfirmSignUpRequest withUserContextData = new ConfirmSignUpRequest().withClientId(this.clientId).withSecretHash(this.secretHash).withUsername(this.userId).withConfirmationCode(str).withForceAliasCreation(Boolean.valueOf(z)).withClientMetadata(map).withUserContextData(getUserContextData());
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            withUserContextData.setAnalyticsMetadata(analyticsMetadataType);
        }
        this.cognitoIdentityProviderClient.confirmSignUp(withUserContextData);
    }

    private void deleteAttributesInternal(List list, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        if (!cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        if (list != null && list.size() >= 1) {
            DeleteUserAttributesRequest deleteUserAttributesRequest = new DeleteUserAttributesRequest();
            deleteUserAttributesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            deleteUserAttributesRequest.setUserAttributeNames(list);
            this.cognitoIdentityProviderClient.deleteUserAttributes(deleteUserAttributesRequest);
        }
    }

    private void deleteUserInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        if (!cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        this.cognitoIdentityProviderClient.deleteUser(deleteUserRequest);
    }

    private Runnable deviceSrpAuthentication(Map map, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationHandler authenticationHandler, boolean z) {
        String deviceSecret = CognitoDeviceHelper.getDeviceSecret(this.usernameInternal, this.pool.getUserPoolId(), this.context);
        String deviceGroupKey = CognitoDeviceHelper.getDeviceGroupKey(this.usernameInternal, this.pool.getUserPoolId(), this.context);
        AuthenticationHelper authenticationHelper = new AuthenticationHelper(deviceGroupKey);
        try {
            RespondToAuthChallengeResult respondToAuthChallenge = this.cognitoIdentityProviderClient.respondToAuthChallenge(initiateDevicesAuthRequest(map, respondToAuthChallengeResult, authenticationHelper));
            if (!"DEVICE_PASSWORD_VERIFIER".equals(respondToAuthChallenge.getChallengeName())) {
                return handleChallenge(map, respondToAuthChallenge, (AuthenticationDetails) null, authenticationHandler, z);
            }
            return handleChallenge(map, this.cognitoIdentityProviderClient.respondToAuthChallenge(deviceSrpAuthRequest(map, respondToAuthChallenge, deviceSecret, deviceGroupKey, authenticationHelper)), (AuthenticationDetails) null, authenticationHandler, z);
        } catch (Exception e) {
            return new 39(authenticationHandler, e);
        } catch (NotAuthorizedException unused) {
            CognitoDeviceHelper.clearCachedDevice(this.usernameInternal, this.pool.getUserPoolId(), this.context);
            return new 38(this, z, authenticationHandler, map);
        }
    }

    private ForgotPasswordResult forgotPasswordInternal(Map map) {
        ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setClientId(this.clientId);
        forgotPasswordRequest.setSecretHash(this.secretHash);
        forgotPasswordRequest.setUsername(this.userId);
        forgotPasswordRequest.setUserContextData(getUserContextData());
        forgotPasswordRequest.setClientMetadata(map);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            forgotPasswordRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        return this.cognitoIdentityProviderClient.forgotPassword(forgotPasswordRequest);
    }

    private GetUserAttributeVerificationCodeResult getAttributeVerificationCodeInternal(Map map, String str, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        GetUserAttributeVerificationCodeRequest getUserAttributeVerificationCodeRequest = new GetUserAttributeVerificationCodeRequest();
        getUserAttributeVerificationCodeRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        getUserAttributeVerificationCodeRequest.setAttributeName(str);
        getUserAttributeVerificationCodeRequest.setClientMetadata(map);
        return this.cognitoIdentityProviderClient.getUserAttributeVerificationCode(getUserAttributeVerificationCodeRequest);
    }

    private CognitoUserSession getCognitoUserSession(AuthenticationResultType authenticationResultType) {
        return getCognitoUserSession(authenticationResultType, null);
    }

    private UserContextDataType getUserContextData() {
        return this.pool.getUserContextData(this.userId);
    }

    private CognitoUserDetails getUserDetailsInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        GetUserResult user = this.cognitoIdentityProviderClient.getUser(getUserRequest);
        return new CognitoUserDetails(new CognitoUserAttributes(user.getUserAttributes()), new CognitoUserSettings(user.getMFAOptions()));
    }

    private void globalSignOutInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        if (!cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        GlobalSignOutRequest globalSignOutRequest = new GlobalSignOutRequest();
        globalSignOutRequest.setAccessToken(getCachedSession().getAccessToken().getJWTToken());
        this.cognitoIdentityProviderClient.globalSignOut(globalSignOutRequest);
    }

    private Runnable handleChallenge(Map map, InitiateAuthResult initiateAuthResult, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        try {
            RespondToAuthChallengeResult respondToAuthChallengeResult = new RespondToAuthChallengeResult();
            respondToAuthChallengeResult.setChallengeName(initiateAuthResult.getChallengeName());
            respondToAuthChallengeResult.setSession(initiateAuthResult.getSession());
            respondToAuthChallengeResult.setAuthenticationResult(initiateAuthResult.getAuthenticationResult());
            respondToAuthChallengeResult.setChallengeParameters(initiateAuthResult.getChallengeParameters());
            return handleChallenge(map, respondToAuthChallengeResult, authenticationDetails, authenticationHandler, z);
        } catch (Exception e) {
            return new 36(authenticationHandler, e);
        }
    }

    private InitiateAuthRequest initiateCustomAuthRequest(Map map, AuthenticationDetails authenticationDetails, AuthenticationHelper authenticationHelper) {
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.setAuthFlow("CUSTOM_AUTH");
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setClientMetadata(map);
        Map authenticationParameters = authenticationDetails.getAuthenticationParameters();
        if (this.clientSecret != null && authenticationParameters.get("SECRET_HASH") == null) {
            String secretHash = CognitoSecretHash.getSecretHash(authenticationDetails.getUserId(), this.clientId, this.clientSecret);
            this.secretHash = secretHash;
            authenticationParameters.put("SECRET_HASH", secretHash);
        }
        if ("SRP_A".equals(authenticationDetails.getCustomChallenge())) {
            authenticationParameters.put("SRP_A", authenticationHelper.getA().toString(16));
        }
        initiateAuthRequest.setAuthParameters(authenticationDetails.getAuthenticationParameters());
        if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
            HashMap hashMap = new HashMap();
            for (AttributeType attributeType : authenticationDetails.getValidationData()) {
                hashMap.put(attributeType.getName(), attributeType.getValue());
            }
            initiateAuthRequest.setClientMetadata(hashMap);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    private RespondToAuthChallengeRequest initiateDevicesAuthRequest(Map map, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationHelper authenticationHelper) {
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setChallengeName("DEVICE_SRP_AUTH");
        respondToAuthChallengeRequest.setClientMetadata(map);
        respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
        respondToAuthChallengeRequest.addChallengeResponsesEntry("USERNAME", this.usernameInternal);
        respondToAuthChallengeRequest.addChallengeResponsesEntry("SRP_A", authenticationHelper.getA().toString(16));
        respondToAuthChallengeRequest.addChallengeResponsesEntry("DEVICE_KEY", this.deviceKey);
        respondToAuthChallengeRequest.addChallengeResponsesEntry("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setUserContextData(getUserContextData());
        return respondToAuthChallengeRequest;
    }

    private InitiateAuthRequest initiateRefreshTokenAuthRequest(CognitoUserSession cognitoUserSession) {
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.addAuthParametersEntry("REFRESH_TOKEN", cognitoUserSession.getRefreshToken().getToken());
        if (this.deviceKey == null) {
            String str = this.usernameInternal;
            this.deviceKey = str != null ? CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context) : CognitoDeviceHelper.getDeviceKey(cognitoUserSession.getUsername(), this.pool.getUserPoolId(), this.context);
        }
        initiateAuthRequest.addAuthParametersEntry("DEVICE_KEY", this.deviceKey);
        initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", this.clientSecret);
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setAuthFlow("REFRESH_TOKEN_AUTH");
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            initiateAuthRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    private InitiateAuthRequest initiateUserPasswordAuthRequest(Map map, AuthenticationDetails authenticationDetails) {
        if (StringUtils.isBlank(authenticationDetails.getUserId()) || StringUtils.isBlank(authenticationDetails.getPassword())) {
            throw new CognitoNotAuthorizedException("User name and password are required");
        }
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.setAuthFlow("USER_PASSWORD_AUTH");
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setClientMetadata(map);
        initiateAuthRequest.addAuthParametersEntry("USERNAME", authenticationDetails.getUserId());
        initiateAuthRequest.addAuthParametersEntry("PASSWORD", authenticationDetails.getPassword());
        initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", CognitoSecretHash.getSecretHash(this.userId, this.clientId, this.clientSecret));
        if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
            HashMap hashMap = new HashMap();
            for (AttributeType attributeType : authenticationDetails.getValidationData()) {
                hashMap.put(attributeType.getName(), attributeType.getValue());
            }
            initiateAuthRequest.setClientMetadata(hashMap);
        }
        return initiateAuthRequest;
    }

    private InitiateAuthRequest initiateUserSrpAuthRequest(Map map, AuthenticationDetails authenticationDetails, AuthenticationHelper authenticationHelper) {
        this.userId = authenticationDetails.getUserId();
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.setAuthFlow("USER_SRP_AUTH");
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setClientMetadata(map);
        initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", CognitoSecretHash.getSecretHash(this.userId, this.clientId, this.clientSecret));
        initiateAuthRequest.addAuthParametersEntry("USERNAME", authenticationDetails.getUserId());
        initiateAuthRequest.addAuthParametersEntry("SRP_A", authenticationHelper.getA().toString(16));
        String str = this.deviceKey;
        if (str == null) {
            str = CognitoDeviceHelper.getDeviceKey(authenticationDetails.getUserId(), this.pool.getUserPoolId(), this.context);
        }
        initiateAuthRequest.addAuthParametersEntry("DEVICE_KEY", str);
        if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
            HashMap hashMap = new HashMap();
            for (AttributeType attributeType : authenticationDetails.getValidationData()) {
                hashMap.put(attributeType.getName(), attributeType.getValue());
            }
            initiateAuthRequest.setClientMetadata(hashMap);
        }
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            initiateAuthRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    private ListDevicesResult listDevicesInternal(CognitoUserSession cognitoUserSession, int i, String str) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        }
        ListDevicesRequest listDevicesRequest = new ListDevicesRequest();
        if (i < 1) {
            i = 10;
        }
        listDevicesRequest.setLimit(Integer.valueOf(i));
        listDevicesRequest.setPaginationToken(str);
        listDevicesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        return this.cognitoIdentityProviderClient.listDevices(listDevicesRequest);
    }

    private CognitoUserSession readCachedTokens() {
        CognitoIdToken cognitoIdToken;
        CognitoAccessToken cognitoAccessToken;
        CognitoRefreshToken cognitoRefreshToken = null;
        CognitoUserSession cognitoUserSession = new CognitoUserSession(null, null, null);
        try {
            String str = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".idToken";
            String str2 = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".accessToken";
            String str3 = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".refreshToken";
            if (this.pool.awsKeyValueStore.contains(str)) {
                String str4 = this.pool.awsKeyValueStore.get(str);
                if (str4 != null) {
                    cognitoIdToken = new CognitoIdToken(str4);
                } else {
                    LOGGER.warn("IdToken for " + str + " is null.");
                    cognitoIdToken = null;
                }
            } else {
                cognitoIdToken = null;
            }
            if (this.pool.awsKeyValueStore.contains(str2)) {
                String str5 = this.pool.awsKeyValueStore.get(str2);
                if (str5 != null) {
                    cognitoAccessToken = new CognitoAccessToken(str5);
                } else {
                    LOGGER.warn("IdToken for " + str2 + " is null.");
                    cognitoAccessToken = null;
                }
            } else {
                cognitoAccessToken = null;
            }
            if (this.pool.awsKeyValueStore.contains(str3)) {
                String str6 = this.pool.awsKeyValueStore.get(str3);
                if (str6 != null) {
                    cognitoRefreshToken = new CognitoRefreshToken(str6);
                } else {
                    LOGGER.warn("IdToken for " + str3 + " is null.");
                }
            }
            return new CognitoUserSession(cognitoIdToken, cognitoAccessToken, cognitoRefreshToken);
        } catch (Exception e) {
            LOGGER.error("Error while reading the tokens from the persistent store.", e);
            return cognitoUserSession;
        }
    }

    private CognitoUserSession refreshSession(CognitoUserSession cognitoUserSession) {
        InitiateAuthResult initiateAuth = this.cognitoIdentityProviderClient.initiateAuth(initiateRefreshTokenAuthRequest(cognitoUserSession));
        if (initiateAuth.getAuthenticationResult() != null) {
            return getCognitoUserSession(initiateAuth.getAuthenticationResult(), cognitoUserSession.getRefreshToken());
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    private ResendConfirmationCodeResult resendConfirmationCodeInternal(Map map) {
        ResendConfirmationCodeRequest withClientMetadata = new ResendConfirmationCodeRequest().withUsername(this.userId).withClientId(this.clientId).withSecretHash(this.secretHash).withClientMetadata(map);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        withClientMetadata.setUserContextData(getUserContextData());
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            withClientMetadata.setAnalyticsMetadata(analyticsMetadataType);
        }
        return this.cognitoIdentityProviderClient.resendConfirmationCode(withClientMetadata);
    }

    private void setUserMfaSettingsInternal(List list, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        if (list == null || list.size() < 1) {
            throw new CognitoParameterInvalidException("mfa settings are empty");
        }
        SetUserMFAPreferenceRequest setUserMFAPreferenceRequest = new SetUserMFAPreferenceRequest();
        setUserMFAPreferenceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CognitoMfaSettings cognitoMfaSettings = (CognitoMfaSettings) it.next();
            if ("SMS_MFA".equals(cognitoMfaSettings.getMfaName())) {
                SMSMfaSettingsType sMSMfaSettingsType = new SMSMfaSettingsType();
                sMSMfaSettingsType.setEnabled(Boolean.valueOf(cognitoMfaSettings.isEnabled()));
                sMSMfaSettingsType.setPreferredMfa(Boolean.valueOf(cognitoMfaSettings.isPreferred()));
                setUserMFAPreferenceRequest.setSMSMfaSettings(sMSMfaSettingsType);
            }
            if ("TOTP_MFA".equals(cognitoMfaSettings.getMfaName())) {
                SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType = new SoftwareTokenMfaSettingsType();
                softwareTokenMfaSettingsType.setEnabled(Boolean.valueOf(cognitoMfaSettings.isEnabled()));
                softwareTokenMfaSettingsType.setPreferredMfa(Boolean.valueOf(cognitoMfaSettings.isPreferred()));
                setUserMFAPreferenceRequest.setSoftwareTokenMfaSettings(softwareTokenMfaSettingsType);
            }
        }
        this.cognitoIdentityProviderClient.setUserMFAPreference(setUserMFAPreferenceRequest);
    }

    private void setUserSettingsInternal(CognitoUserSettings cognitoUserSettings, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        if (cognitoUserSettings == null) {
            throw new CognitoParameterInvalidException("user attributes is null");
        }
        SetUserSettingsRequest setUserSettingsRequest = new SetUserSettingsRequest();
        setUserSettingsRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        setUserSettingsRequest.setMFAOptions(cognitoUserSettings.getSettingsList());
        this.cognitoIdentityProviderClient.setUserSettings(setUserSettingsRequest);
    }

    private Runnable startWithCustomAuth(Map map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        return new 25(map, authenticationDetails, authenticationHandler, z);
    }

    private Runnable startWithUserPasswordAuth(Map map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        return new 37(map, authenticationDetails, authenticationHandler, z);
    }

    private Runnable startWithUserSrpAuth(Map map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        return new 24(map, authenticationDetails, authenticationHandler, z);
    }

    private UpdateUserAttributesResult updateAttributesInternal(Map map, CognitoUserAttributes cognitoUserAttributes, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        UpdateUserAttributesRequest updateUserAttributesRequest = new UpdateUserAttributesRequest();
        updateUserAttributesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        updateUserAttributesRequest.setUserAttributes(cognitoUserAttributes.getAttributesList());
        updateUserAttributesRequest.setClientMetadata(map);
        return this.cognitoIdentityProviderClient.updateUserAttributes(updateUserAttributesRequest);
    }

    private void updateInternalUsername(Map map) {
        if (this.usernameInternal == null && map != null && map.containsKey("USERNAME")) {
            String str = (String) map.get("USERNAME");
            this.usernameInternal = str;
            this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
            if (this.secretHash == null) {
                this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
            }
        }
    }

    private RespondToAuthChallengeRequest userSrpAuthRequest(Map map, Map map2, String str, String str2, String str3, AuthenticationHelper authenticationHelper) {
        String str4 = (String) map2.get("USERNAME");
        String str5 = (String) map2.get("USER_ID_FOR_SRP");
        String str6 = (String) map2.get("SRP_B");
        String str7 = (String) map2.get("SALT");
        String str8 = (String) map2.get("SECRET_BLOCK");
        this.usernameInternal = str4;
        this.deviceKey = CognitoDeviceHelper.getDeviceKey(str4, this.pool.getUserPoolId(), this.context);
        this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
        BigInteger bigInteger = new BigInteger(str6, 16);
        if (bigInteger.mod(AuthenticationHelper.access$3000()).equals(BigInteger.ZERO)) {
            throw new CognitoInternalErrorException("SRP error, B cannot be zero");
        }
        byte[] passwordAuthenticationKey = authenticationHelper.getPasswordAuthenticationKey(str5, str, bigInteger, new BigInteger(str7, 16));
        Date date = new Date();
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(passwordAuthenticationKey, "HmacSHA256"));
            String str9 = this.pool.getUserPoolId().split("_", 2)[1];
            Charset charset = StringUtils.UTF8;
            mac.update(str9.getBytes(charset));
            mac.update(str5.getBytes(charset));
            mac.update(Base64.decode(str8));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(date);
            byte[] doFinal = mac.doFinal(format.getBytes(charset));
            Map hashMap = new HashMap();
            hashMap.put("PASSWORD_CLAIM_SECRET_BLOCK", str8);
            hashMap.put("PASSWORD_CLAIM_SIGNATURE", new String(Base64.encode(doFinal), charset));
            hashMap.put("TIMESTAMP", format);
            hashMap.put("USERNAME", this.usernameInternal);
            hashMap.put("DEVICE_KEY", this.deviceKey);
            hashMap.put("SECRET_HASH", this.secretHash);
            RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
            respondToAuthChallengeRequest.setChallengeName(str2);
            respondToAuthChallengeRequest.setClientId(this.clientId);
            respondToAuthChallengeRequest.setSession(str3);
            respondToAuthChallengeRequest.setChallengeResponses(hashMap);
            respondToAuthChallengeRequest.setClientMetadata(map);
            String pinpointEndpointId = this.pool.getPinpointEndpointId();
            if (pinpointEndpointId != null) {
                AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
                analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
                respondToAuthChallengeRequest.setAnalyticsMetadata(analyticsMetadataType);
            }
            respondToAuthChallengeRequest.setUserContextData(getUserContextData());
            return respondToAuthChallengeRequest;
        } catch (Exception e) {
            throw new CognitoInternalErrorException("SRP error", e);
        }
    }

    private VerifyUserAttributeResult verifyAttributeInternal(String str, String str2, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        VerifyUserAttributeRequest verifyUserAttributeRequest = new VerifyUserAttributeRequest();
        verifyUserAttributeRequest.setAttributeName(str);
        verifyUserAttributeRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        verifyUserAttributeRequest.setCode(str2);
        return this.cognitoIdentityProviderClient.verifyUserAttribute(verifyUserAttributeRequest);
    }

    private VerifySoftwareTokenResult verifyTotpAssociationInternal(VerifySoftwareTokenRequest verifySoftwareTokenRequest) {
        return this.cognitoIdentityProviderClient.verifySoftwareToken(verifySoftwareTokenRequest);
    }

    private VerifySoftwareTokenResult verifyTotpAssociationWithSession(String str, String str2, String str3) {
        if (str == null) {
            throw new CognitoNotAuthorizedException("session token is invalid");
        }
        VerifySoftwareTokenRequest verifySoftwareTokenRequest = new VerifySoftwareTokenRequest();
        verifySoftwareTokenRequest.setSession(str);
        verifySoftwareTokenRequest.setUserCode(str2);
        verifySoftwareTokenRequest.setFriendlyDeviceName(str3);
        return verifyTotpAssociationInternal(verifySoftwareTokenRequest);
    }

    private VerifySoftwareTokenResult verifyTotpAssociationWithTokens(CognitoUserSession cognitoUserSession, String str, String str2) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        VerifySoftwareTokenRequest verifySoftwareTokenRequest = new VerifySoftwareTokenRequest();
        verifySoftwareTokenRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        verifySoftwareTokenRequest.setUserCode(str);
        verifySoftwareTokenRequest.setFriendlyDeviceName(str2);
        return verifyTotpAssociationInternal(verifySoftwareTokenRequest);
    }

    public Runnable _initiateUserAuthentication(Map map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        return "PASSWORD_VERIFIER".equals(authenticationDetails.getAuthenticationType()) ? startWithUserSrpAuth(map, authenticationDetails, authenticationHandler, z) : "CUSTOM_CHALLENGE".equals(authenticationDetails.getAuthenticationType()) ? startWithCustomAuth(map, authenticationDetails, authenticationHandler, z) : "USER_PASSWORD".equals(authenticationDetails.getAuthenticationType()) ? startWithUserPasswordAuth(map, authenticationDetails, authenticationHandler, z) : new 8(authenticationHandler, authenticationDetails);
    }

    public void associateSoftwareToken(String str, RegisterMfaHandler registerMfaHandler) {
        AssociateSoftwareTokenResult associateTotpMfaInternalWithTokens;
        boolean z;
        if (registerMfaHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            CognitoUserSession cachedSession = getCachedSession();
            if (StringUtils.isBlank(str)) {
                associateTotpMfaInternalWithTokens = associateTotpMfaInternalWithTokens(cachedSession);
                z = false;
            } else {
                associateTotpMfaInternalWithTokens = associateTotpMfaInternalWithSession(str);
                z = true;
            }
            String session = associateTotpMfaInternalWithTokens.getSession();
            HashMap hashMap = new HashMap();
            hashMap.put("type", "SOFTWARE_TOKEN_MFA");
            hashMap.put("secretKey", associateTotpMfaInternalWithTokens.getSecretCode());
            registerMfaHandler.onVerify(new VerifyMfaContinuation(this.context, this.clientId, this, registerMfaHandler, hashMap, z, session, false));
        } catch (Exception e) {
            registerMfaHandler.onFailure(e);
        }
    }

    public void associateSoftwareTokenInBackground(String str, RegisterMfaHandler registerMfaHandler) {
        if (registerMfaHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 13(this, str, registerMfaHandler)).start();
    }

    public void cacheLastAuthUser() {
        try {
            this.pool.awsKeyValueStore.put("CognitoIdentityProvider." + this.clientId + ".LastAuthUser", this.userId);
        } catch (Exception e) {
            LOGGER.error("Error while writing to SharedPreferences.", e);
        }
    }

    public void cacheTokens(CognitoUserSession cognitoUserSession) {
        try {
            String str = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".idToken";
            String str2 = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".accessToken";
            String str3 = "CognitoIdentityProvider." + this.clientId + "." + this.userId + ".refreshToken";
            String str4 = "CognitoIdentityProvider." + this.clientId + ".LastAuthUser";
            if (cognitoUserSession != null) {
                this.pool.awsKeyValueStore.put(str, cognitoUserSession.getIdToken() != null ? cognitoUserSession.getIdToken().getJWTToken() : null);
                this.pool.awsKeyValueStore.put(str2, cognitoUserSession.getAccessToken() != null ? cognitoUserSession.getAccessToken().getJWTToken() : null);
                this.pool.awsKeyValueStore.put(str3, cognitoUserSession.getRefreshToken() != null ? cognitoUserSession.getRefreshToken().getToken() : null);
            }
            this.pool.awsKeyValueStore.put(str4, this.userId);
        } catch (Exception e) {
            LOGGER.error("Error while writing to SharedPreferences.", e);
        }
    }

    public void changePassword(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            changePasswordInternal(str, str2, getCachedSession());
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void changePasswordInBackground(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 9(this, str, str2, genericHandler)).start();
    }

    public void confirmPassword(String str, String str2, ForgotPasswordHandler forgotPasswordHandler) {
        confirmPassword(str, str2, Collections.emptyMap(), forgotPasswordHandler);
    }

    public void confirmPasswordInBackground(String str, String str2, ForgotPasswordHandler forgotPasswordHandler) {
        confirmPasswordInBackground(str, str2, Collections.emptyMap(), forgotPasswordHandler);
    }

    public void confirmSignUp(String str, boolean z, GenericHandler genericHandler) {
        confirmSignUp(str, z, Collections.emptyMap(), genericHandler);
    }

    public void confirmSignUpInBackground(String str, boolean z, GenericHandler genericHandler) {
        confirmSignUpInBackground(str, z, Collections.emptyMap(), genericHandler);
    }

    public void deleteAttributes(List list, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            deleteAttributesInternal(list, getCachedSession());
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void deleteAttributesInBackground(List list, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 16(this, list, genericHandler)).start();
    }

    public void deleteUser(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            deleteUserInternal(getCachedSession());
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void deleteUserInBackground(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 18(this, genericHandler)).start();
    }

    public RespondToAuthChallengeRequest deviceSrpAuthRequest(Map map, RespondToAuthChallengeResult respondToAuthChallengeResult, String str, String str2, AuthenticationHelper authenticationHelper) {
        this.usernameInternal = (String) respondToAuthChallengeResult.getChallengeParameters().get("USERNAME");
        BigInteger bigInteger = new BigInteger((String) respondToAuthChallengeResult.getChallengeParameters().get("SRP_B"), 16);
        if (bigInteger.mod(AuthenticationHelper.access$3000()).equals(BigInteger.ZERO)) {
            throw new CognitoInternalErrorException("SRP error, B cannot be zero");
        }
        byte[] passwordAuthenticationKey = authenticationHelper.getPasswordAuthenticationKey(this.deviceKey, str, bigInteger, new BigInteger((String) respondToAuthChallengeResult.getChallengeParameters().get("SALT"), 16));
        Date date = new Date();
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(passwordAuthenticationKey, "HmacSHA256"));
            Charset charset = StringUtils.UTF8;
            mac.update(str2.getBytes(charset));
            mac.update(this.deviceKey.getBytes(charset));
            mac.update(Base64.decode((String) respondToAuthChallengeResult.getChallengeParameters().get("SECRET_BLOCK")));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(date);
            byte[] doFinal = mac.doFinal(format.getBytes(charset));
            this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
            Map hashMap = new HashMap();
            hashMap.put("PASSWORD_CLAIM_SECRET_BLOCK", respondToAuthChallengeResult.getChallengeParameters().get("SECRET_BLOCK"));
            hashMap.put("PASSWORD_CLAIM_SIGNATURE", new String(Base64.encode(doFinal), charset));
            hashMap.put("TIMESTAMP", format);
            hashMap.put("USERNAME", this.usernameInternal);
            hashMap.put("DEVICE_KEY", this.deviceKey);
            hashMap.put("SECRET_HASH", this.secretHash);
            RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
            respondToAuthChallengeRequest.setChallengeName(respondToAuthChallengeResult.getChallengeName());
            respondToAuthChallengeRequest.setClientId(this.clientId);
            respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
            respondToAuthChallengeRequest.setChallengeResponses(hashMap);
            respondToAuthChallengeRequest.setUserContextData(getUserContextData());
            respondToAuthChallengeRequest.setClientMetadata(map);
            return respondToAuthChallengeRequest;
        } catch (Exception e) {
            throw new CognitoInternalErrorException("SRP error", e);
        }
    }

    public void forgotPassword(ForgotPasswordHandler forgotPasswordHandler) {
        forgotPassword(Collections.emptyMap(), forgotPasswordHandler);
    }

    public void forgotPasswordInBackground(ForgotPasswordHandler forgotPasswordHandler) {
        forgotPasswordInBackground(Collections.emptyMap(), forgotPasswordHandler);
    }

    public void getAttributeVerificationCode(String str, VerificationHandler verificationHandler) {
        getAttributeVerificationCode(Collections.emptyMap(), str, verificationHandler);
    }

    public void getAttributeVerificationCodeInBackground(String str, VerificationHandler verificationHandler) {
        getAttributeVerificationCodeInBackground(Collections.emptyMap(), str, verificationHandler);
    }

    public CognitoUserSession getCachedSession() {
        synchronized (GET_CACHED_SESSION_LOCK) {
            try {
                if (this.userId == null) {
                    throw new CognitoNotAuthorizedException("User-ID is null");
                }
                CognitoUserSession cognitoUserSession = this.cipSession;
                if (cognitoUserSession != null && cognitoUserSession.isValidForThreshold()) {
                    cacheLastAuthUser();
                    return this.cipSession;
                }
                CognitoUserSession readCachedTokens = readCachedTokens();
                if (readCachedTokens.isValidForThreshold()) {
                    this.cipSession = readCachedTokens;
                    cacheLastAuthUser();
                    return this.cipSession;
                }
                if (readCachedTokens.getRefreshToken() == null) {
                    throw new CognitoNotAuthorizedException("User is not authenticated");
                }
                try {
                    try {
                        CognitoUserSession refreshSession = refreshSession(readCachedTokens);
                        this.cipSession = refreshSession;
                        cacheTokens(refreshSession);
                        return this.cipSession;
                    } catch (NotAuthorizedException e) {
                        clearCachedTokens();
                        throw new CognitoNotAuthorizedException("User is not authenticated", e);
                    }
                } catch (Exception e2) {
                    throw new CognitoInternalErrorException("Failed to authenticate user", e2);
                } catch (UserNotFoundException e3) {
                    clearCachedTokens();
                    throw new CognitoNotAuthorizedException("User does not exist", e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AmazonCognitoIdentityProvider getCognitoIdentityProviderClient() {
        return this.cognitoIdentityProviderClient;
    }

    public void getDetails(GetDetailsHandler getDetailsHandler) {
        if (getDetailsHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            getDetailsHandler.onSuccess(getUserDetailsInternal(getCachedSession()));
        } catch (Exception e) {
            getDetailsHandler.onFailure(e);
        }
    }

    public void getDetailsInBackground(GetDetailsHandler getDetailsHandler) {
        if (getDetailsHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 10(this, getDetailsHandler)).start();
    }

    public void getSession(AuthenticationHandler authenticationHandler) {
        getSession(Collections.emptyMap(), authenticationHandler);
    }

    public void getSessionInBackground(AuthenticationHandler authenticationHandler) {
        if (authenticationHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 5(authenticationHandler, this)).start();
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserPoolId() {
        return this.pool.getUserPoolId();
    }

    public void globalSignOut(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            globalSignOutInternal(getCachedSession());
            signOut();
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void globalSignOutInBackground(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 17(this, genericHandler)).start();
    }

    public Runnable initiateUserAuthentication(AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        return initiateUserAuthentication(Collections.emptyMap(), authenticationDetails, authenticationHandler, z);
    }

    public void listDevices(int i, String str, DevicesHandler devicesHandler) {
        if (devicesHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            ListDevicesResult listDevicesInternal = listDevicesInternal(getCachedSession(), i, str);
            ArrayList arrayList = new ArrayList();
            Iterator it = listDevicesInternal.getDevices().iterator();
            while (it.hasNext()) {
                arrayList.add(new CognitoDevice((DeviceType) it.next(), this, this.context));
            }
            devicesHandler.onSuccess(arrayList);
        } catch (Exception e) {
            devicesHandler.onFailure(e);
        }
    }

    public void listDevicesInBackground(int i, String str, DevicesHandler devicesHandler) {
        if (devicesHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 40(this, i, str, devicesHandler)).start();
    }

    public void resendConfirmationCode(VerificationHandler verificationHandler) {
        resendConfirmationCode(Collections.emptyMap(), verificationHandler);
    }

    public void resendConfirmationCodeInBackground(VerificationHandler verificationHandler) {
        resendConfirmationCodeInBackground(Collections.emptyMap(), verificationHandler);
    }

    public Runnable respondToChallenge(RespondToAuthChallengeRequest respondToAuthChallengeRequest, AuthenticationHandler authenticationHandler, boolean z) {
        return respondToChallenge(Collections.emptyMap(), respondToAuthChallengeRequest, authenticationHandler, z);
    }

    public Runnable respondToMfaChallenge(String str, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationHandler authenticationHandler, boolean z) {
        return respondToMfaChallenge(Collections.emptyMap(), str, respondToAuthChallengeResult, authenticationHandler, z);
    }

    public RevokeTokenResult revokeTokens() {
        try {
            CognitoUserSession cachedSession = getCachedSession();
            if (!CognitoJWTParser.hasClaim(cachedSession.getAccessToken().getJWTToken(), "origin_jti")) {
                LOGGER.debug("Access Token does not contain `origin_jti` claim. Skip revoking tokens.");
                return null;
            }
            String token = cachedSession.getRefreshToken().getToken();
            RevokeTokenRequest revokeTokenRequest = new RevokeTokenRequest();
            revokeTokenRequest.setToken(token);
            revokeTokenRequest.setClientId(this.clientId);
            if (!StringUtils.isBlank(this.clientSecret)) {
                revokeTokenRequest.setClientSecret(this.clientSecret);
            }
            return this.cognitoIdentityProviderClient.revokeToken(revokeTokenRequest);
        } catch (Exception e) {
            LOGGER.warn("Failed to revoke tokens.", e);
            return null;
        }
    }

    public void setUserMfaSettingsInBackground(List list, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 20(list, getCachedSession(), genericHandler)).start();
    }

    public void setUserSettings(CognitoUserSettings cognitoUserSettings, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            setUserSettingsInternal(cognitoUserSettings, getCachedSession());
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void setUserSettingsInBackground(CognitoUserSettings cognitoUserSettings, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 19(cognitoUserSettings, getCachedSession(), genericHandler)).start();
    }

    public void signOut() {
        this.cipSession = null;
        clearCachedTokens();
    }

    public CognitoDevice thisDevice() {
        if (this.deviceKey == null) {
            String str = this.usernameInternal;
            if (str == null) {
                String str2 = this.userId;
                if (str2 != null) {
                    String deviceKey = CognitoDeviceHelper.getDeviceKey(str2, this.pool.getUserPoolId(), this.context);
                    this.deviceKey = deviceKey;
                    if (deviceKey == null) {
                        str = readCachedTokens().getUsername();
                        this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
                    }
                }
            } else {
                this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
            }
        }
        String str3 = this.deviceKey;
        if (str3 != null) {
            return new CognitoDevice(str3, null, null, null, null, this, this.context);
        }
        return null;
    }

    public void updateAttributes(CognitoUserAttributes cognitoUserAttributes, UpdateAttributesHandler updateAttributesHandler) {
        updateAttributes(cognitoUserAttributes, Collections.emptyMap(), updateAttributesHandler);
    }

    public void updateAttributesInBackground(CognitoUserAttributes cognitoUserAttributes, UpdateAttributesHandler updateAttributesHandler) {
        updateAttributesInBackground(Collections.emptyMap(), cognitoUserAttributes, updateAttributesHandler);
    }

    public void verifyAttribute(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            verifyAttributeInternal(str, str2, getCachedSession());
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void verifyAttributeInBackground(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 12(this, str, str2, genericHandler)).start();
    }

    public void verifySoftwareToken(String str, String str2, String str3, RegisterMfaHandler registerMfaHandler) {
        VerifySoftwareTokenResult verifyTotpAssociationWithTokens;
        boolean z;
        if (registerMfaHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            CognitoUserSession cachedSession = getCachedSession();
            if (StringUtils.isBlank(str)) {
                verifyTotpAssociationWithTokens = verifyTotpAssociationWithTokens(cachedSession, str2, str3);
                z = false;
            } else {
                verifyTotpAssociationWithTokens = verifyTotpAssociationWithSession(str, str2, str3);
                z = true;
            }
            String session = verifyTotpAssociationWithTokens.getSession();
            if (VerifySoftwareTokenResponseType.ERROR.equals(verifyTotpAssociationWithTokens.getStatus())) {
                throw new CognitoInternalErrorException("verification failed");
            }
            if (z) {
                registerMfaHandler.onSuccess(session);
            } else {
                registerMfaHandler.onSuccess(null);
            }
        } catch (Exception e) {
            registerMfaHandler.onFailure(e);
        }
    }

    public void verifySoftwareTokenInBackground(String str, String str2, String str3, RegisterMfaHandler registerMfaHandler) {
        if (registerMfaHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 14(this, str, str2, str3, registerMfaHandler)).start();
    }

    private CognitoUserSession getCognitoUserSession(AuthenticationResultType authenticationResultType, CognitoRefreshToken cognitoRefreshToken) {
        CognitoIdToken cognitoIdToken = new CognitoIdToken(authenticationResultType.getIdToken());
        CognitoAccessToken cognitoAccessToken = new CognitoAccessToken(authenticationResultType.getAccessToken());
        if (cognitoRefreshToken == null) {
            cognitoRefreshToken = new CognitoRefreshToken(authenticationResultType.getRefreshToken());
        }
        return new CognitoUserSession(cognitoIdToken, cognitoAccessToken, cognitoRefreshToken);
    }

    private Runnable handleChallenge(Map map, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        26 r13 = new 26(authenticationHandler);
        if (respondToAuthChallengeResult == null) {
            return r13;
        }
        updateInternalUsername(respondToAuthChallengeResult.getChallengeParameters());
        String challengeName = respondToAuthChallengeResult.getChallengeName();
        if (challengeName == null) {
            CognitoUserSession cognitoUserSession = getCognitoUserSession(respondToAuthChallengeResult.getAuthenticationResult());
            cacheTokens(cognitoUserSession);
            NewDeviceMetadataType newDeviceMetadata = respondToAuthChallengeResult.getAuthenticationResult().getNewDeviceMetadata();
            if (newDeviceMetadata == null) {
                return new 27(authenticationHandler, cognitoUserSession);
            }
            ConfirmDeviceResult confirmDevice = confirmDevice(newDeviceMetadata);
            return (confirmDevice == null || !confirmDevice.isUserConfirmationNecessary().booleanValue()) ? new 29(authenticationHandler, cognitoUserSession) : new 28(authenticationHandler, cognitoUserSession, new CognitoDevice(newDeviceMetadata.getDeviceKey(), null, null, null, null, this, this.context));
        }
        if ("PASSWORD_VERIFIER".equals(challengeName)) {
            return new 30(authenticationHandler);
        }
        if ("SMS_MFA".equals(challengeName) || "SOFTWARE_TOKEN_MFA".equals(challengeName)) {
            MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation = new MultiFactorAuthenticationContinuation(this, this.context, respondToAuthChallengeResult, z, authenticationHandler);
            multiFactorAuthenticationContinuation.setClientMetaData(map);
            return new 31(authenticationHandler, multiFactorAuthenticationContinuation);
        }
        if ("SELECT_MFA_TYPE".equals(challengeName)) {
            return new 32(authenticationHandler, new ChooseMfaContinuation(this, this.context, this.usernameInternal, this.clientId, this.secretHash, respondToAuthChallengeResult, z, authenticationHandler));
        }
        if ("MFA_SETUP".equals(challengeName)) {
            return new 33(authenticationHandler, new RegisterMfaContinuation(this, this.context, this.usernameInternal, this.clientId, this.secretHash, respondToAuthChallengeResult, z, authenticationHandler));
        }
        if ("DEVICE_SRP_AUTH".equals(challengeName)) {
            return deviceSrpAuthentication(map, respondToAuthChallengeResult, authenticationHandler, z);
        }
        if ("NEW_PASSWORD_REQUIRED".equals(challengeName)) {
            Context context = this.context;
            String str = this.usernameInternal;
            String str2 = this.clientId;
            return new 34(authenticationHandler, new NewPasswordContinuation(this, context, str, str2, CognitoSecretHash.getSecretHash(str, str2, this.clientSecret), respondToAuthChallengeResult, z, authenticationHandler));
        }
        Context context2 = this.context;
        String str3 = this.usernameInternal;
        String str4 = this.clientId;
        ChallengeContinuation challengeContinuation = new ChallengeContinuation(this, context2, str3, str4, CognitoSecretHash.getSecretHash(str3, str4, this.clientSecret), respondToAuthChallengeResult, z, authenticationHandler);
        challengeContinuation.setClientMetaData(map);
        return new 35(authenticationHandler, challengeContinuation);
    }

    public void confirmPassword(String str, String str2, Map map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            confirmPasswordInternal(str, str2, map);
            forgotPasswordHandler.onSuccess();
        } catch (Exception e) {
            forgotPasswordHandler.onFailure(e);
        }
    }

    public void confirmPasswordInBackground(String str, String str2, Map map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 4(str, str2, map, forgotPasswordHandler)).start();
    }

    public void confirmSignUp(String str, boolean z, Map map, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            confirmSignUpInternal(str, z, map);
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void confirmSignUpInBackground(String str, boolean z, Map map, GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 1(str, z, map, genericHandler)).start();
    }

    public void forgotPassword(Map map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            forgotPasswordHandler.getResetCode(new ForgotPasswordContinuation(this, new CognitoUserCodeDeliveryDetails(forgotPasswordInternal(map).getCodeDeliveryDetails()), false, forgotPasswordHandler));
        } catch (Exception e) {
            forgotPasswordHandler.onFailure(e);
        }
    }

    public void forgotPasswordInBackground(Map map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 3(map, this, forgotPasswordHandler)).start();
    }

    public void getAttributeVerificationCode(Map map, String str, VerificationHandler verificationHandler) {
        if (verificationHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(getAttributeVerificationCodeInternal(map, str, getCachedSession()).getCodeDeliveryDetails()));
        } catch (Exception e) {
            verificationHandler.onFailure(e);
        }
    }

    public void getAttributeVerificationCodeInBackground(Map map, String str, VerificationHandler verificationHandler) {
        if (verificationHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 11(this, map, str, verificationHandler)).start();
    }

    public void getSession(Map map, AuthenticationHandler authenticationHandler) {
        if (authenticationHandler == null) {
            throw new InvalidParameterException("callback is null");
        }
        try {
            getCachedSession();
            authenticationHandler.onSuccess(this.cipSession, null);
        } catch (CognitoNotAuthorizedException unused) {
            AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(this, this.context, false, authenticationHandler);
            authenticationContinuation.setClientMetaData(map);
            authenticationHandler.getAuthenticationDetails(authenticationContinuation, getUserId());
        } catch (InvalidParameterException e) {
            e = e;
            authenticationHandler.onFailure(e);
        } catch (Exception e2) {
            e = e2;
            authenticationHandler.onFailure(e);
        }
    }

    public Runnable initiateUserAuthentication(Map map, AuthenticationDetails authenticationDetails, AuthenticationHandler authenticationHandler, boolean z) {
        Runnable _initiateUserAuthentication = _initiateUserAuthentication(map, authenticationDetails, new 6(z, authenticationHandler), z);
        return z ? new 7(_initiateUserAuthentication) : _initiateUserAuthentication;
    }

    public void resendConfirmationCode(Map map, VerificationHandler verificationHandler) {
        if (verificationHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(resendConfirmationCodeInternal(map).getCodeDeliveryDetails()));
        } catch (Exception e) {
            verificationHandler.onFailure(e);
        }
    }

    public void resendConfirmationCodeInBackground(Map map, VerificationHandler verificationHandler) {
        if (verificationHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 2(map, verificationHandler)).start();
    }

    public Runnable respondToChallenge(Map map, RespondToAuthChallengeRequest respondToAuthChallengeRequest, AuthenticationHandler authenticationHandler, boolean z) {
        if (respondToAuthChallengeRequest != null) {
            try {
                if (respondToAuthChallengeRequest.getChallengeResponses() != null) {
                    respondToAuthChallengeRequest.getChallengeResponses().put("DEVICE_KEY", this.deviceKey);
                }
            } catch (ResourceNotFoundException e) {
                if (!e.getMessage().contains("Device")) {
                    return new 22(authenticationHandler, e);
                }
                CognitoDeviceHelper.clearCachedDevice(this.usernameInternal, this.pool.getUserPoolId(), this.context);
                return new 21(this, z, authenticationHandler, map);
            } catch (Exception e2) {
                return new 23(authenticationHandler, e2);
            }
        }
        return handleChallenge(map, this.cognitoIdentityProviderClient.respondToAuthChallenge(respondToAuthChallengeRequest), (AuthenticationDetails) null, authenticationHandler, z);
    }

    public Runnable respondToMfaChallenge(Map map, String str, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationHandler authenticationHandler, boolean z) {
        String str2;
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        HashMap hashMap = new HashMap();
        if (!"SMS_MFA".equals(respondToAuthChallengeResult.getChallengeName())) {
            str2 = "SOFTWARE_TOKEN_MFA".equals(respondToAuthChallengeResult.getChallengeName()) ? "SOFTWARE_TOKEN_MFA_CODE" : "SMS_MFA_CODE";
            hashMap.put("USERNAME", this.usernameInternal);
            hashMap.put("DEVICE_KEY", this.deviceKey);
            hashMap.put("SECRET_HASH", this.secretHash);
            respondToAuthChallengeRequest.setClientId(this.clientId);
            respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
            respondToAuthChallengeRequest.setChallengeName(respondToAuthChallengeResult.getChallengeName());
            respondToAuthChallengeRequest.setChallengeResponses(hashMap);
            respondToAuthChallengeRequest.setUserContextData(getUserContextData());
            respondToAuthChallengeRequest.setClientMetadata(map);
            return respondToChallenge(map, respondToAuthChallengeRequest, authenticationHandler, z);
        }
        hashMap.put(str2, str);
        hashMap.put("USERNAME", this.usernameInternal);
        hashMap.put("DEVICE_KEY", this.deviceKey);
        hashMap.put("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
        respondToAuthChallengeRequest.setChallengeName(respondToAuthChallengeResult.getChallengeName());
        respondToAuthChallengeRequest.setChallengeResponses(hashMap);
        respondToAuthChallengeRequest.setUserContextData(getUserContextData());
        respondToAuthChallengeRequest.setClientMetadata(map);
        return respondToChallenge(map, respondToAuthChallengeRequest, authenticationHandler, z);
    }

    public void updateAttributes(CognitoUserAttributes cognitoUserAttributes, Map map, UpdateAttributesHandler updateAttributesHandler) {
        if (updateAttributesHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            UpdateUserAttributesResult updateAttributesInternal = updateAttributesInternal(map, cognitoUserAttributes, getCachedSession());
            ArrayList arrayList = new ArrayList();
            if (updateAttributesInternal.getCodeDeliveryDetailsList() != null) {
                Iterator it = updateAttributesInternal.getCodeDeliveryDetailsList().iterator();
                while (it.hasNext()) {
                    arrayList.add(new CognitoUserCodeDeliveryDetails((CodeDeliveryDetailsType) it.next()));
                }
            }
            updateAttributesHandler.onSuccess(arrayList);
        } catch (Exception e) {
            updateAttributesHandler.onFailure(e);
        }
    }

    public void updateAttributesInBackground(Map map, CognitoUserAttributes cognitoUserAttributes, UpdateAttributesHandler updateAttributesHandler) {
        if (updateAttributesHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 15(this, map, cognitoUserAttributes, updateAttributesHandler)).start();
    }
}
