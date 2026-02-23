package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.cognito.clientcontext.data.UserContextDataProvider;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoDeviceHelper;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoPinpointSharedContext;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoSecretHash;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoUserPool {
    private static final String DEFAULT_SHARED_PREFERENCES_NAME = "CognitoIdentityProviderCache";
    private static final int USER_POOL_ID_MAX_LENGTH = 55;
    private static final String USER_POOL_ID_PATTERN = "^[\\w-]+_[0-9a-zA-Z]+$";
    private static final Log logger = LogFactory.getLog(CognitoUserPool.class);
    private boolean advancedSecurityDataCollectionFlag;
    AWSKeyValueStore awsKeyValueStore;
    private AmazonCognitoIdentityProvider client;
    private final String clientId;
    private final String clientSecret;
    private final Context context;
    private boolean isPersistenceEnabled;
    private String pinpointEndpointId;
    private String secretHash;
    private final String userPoolId;

    public class 1 implements Runnable {
        final /* synthetic */ SignUpHandler val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$password;
        final /* synthetic */ CognitoUserAttributes val$userAttributes;
        final /* synthetic */ String val$userId;
        final /* synthetic */ Map val$validationData;

        public class 1 implements Runnable {
            final /* synthetic */ SignUpResult val$signUpResult;
            final /* synthetic */ CognitoUser val$user;

            public 1(CognitoUser cognitoUser, SignUpResult signUpResult) {
                this.val$user = cognitoUser;
                this.val$signUpResult = signUpResult;
            }

            public void run() {
                1.this.val$callback.onSuccess(this.val$user, this.val$signUpResult);
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

        public 1(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map map, Map map2, SignUpHandler signUpHandler) {
            this.val$userId = str;
            this.val$password = str2;
            this.val$userAttributes = cognitoUserAttributes;
            this.val$validationData = map;
            this.val$clientMetadata = map2;
            this.val$callback = signUpHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoUserPool.access$000(CognitoUserPool.this).getMainLooper());
            try {
                runnable = new 1(CognitoUserPool.this.getUser(this.val$userId), CognitoUserPool.access$100(CognitoUserPool.this, this.val$userId, this.val$password, this.val$userAttributes, this.val$validationData, this.val$clientMetadata));
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public CognitoUserPool(Context context, AWSConfiguration aWSConfiguration) {
        this.advancedSecurityDataCollectionFlag = true;
        this.isPersistenceEnabled = true;
        try {
            initialize(context);
            JSONObject optJsonObject = aWSConfiguration.optJsonObject("CognitoUserPool");
            this.context = context;
            this.userPoolId = optJsonObject.getString("PoolId");
            this.clientId = optJsonObject.getString("AppClientId");
            this.clientSecret = optJsonObject.optString("AppClientSecret");
            this.pinpointEndpointId = CognitoPinpointSharedContext.getPinpointEndpoint(context, optJsonObject.optString("PinpointAppId"));
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            clientConfiguration.setUserAgent(aWSConfiguration.getUserAgent());
            clientConfiguration.setUserAgentOverride(aWSConfiguration.getUserAgentOverride());
            AmazonCognitoIdentityProviderClient amazonCognitoIdentityProviderClient = new AmazonCognitoIdentityProviderClient(new AnonymousAWSCredentials(), clientConfiguration);
            this.client = amazonCognitoIdentityProviderClient;
            amazonCognitoIdentityProviderClient.setRegion(Region.getRegion(Regions.fromName(optJsonObject.getString("Region"))));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to read PoolId, AppClientId, AppClientSecret, or Region from AWSConfiguration please check your setup or awsconfiguration.json file", e);
        }
    }

    public static /* synthetic */ Context access$000(CognitoUserPool cognitoUserPool) {
        return cognitoUserPool.context;
    }

    public static /* synthetic */ SignUpResult access$100(CognitoUserPool cognitoUserPool, String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map map, Map map2) {
        return cognitoUserPool.signUpInternal(str, str2, cognitoUserAttributes, map, map2);
    }

    private void initialize(Context context) {
        this.awsKeyValueStore = new AWSKeyValueStore(context, "CognitoIdentityProviderCache", this.isPersistenceEnabled);
        CognitoDeviceHelper.setPersistenceEnabled(this.isPersistenceEnabled);
    }

    private SignUpResult signUpInternal(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map map, Map map2) {
        ArrayList arrayList;
        if (map != null) {
            arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                AttributeType attributeType = new AttributeType();
                attributeType.setName((String) entry.getKey());
                attributeType.setValue((String) entry.getValue());
                arrayList.add(attributeType);
            }
        } else {
            arrayList = null;
        }
        this.secretHash = CognitoSecretHash.getSecretHash(str, this.clientId, this.clientSecret);
        SignUpRequest withUserContextData = new SignUpRequest().withUsername(str).withPassword(str2).withClientId(this.clientId).withSecretHash(this.secretHash).withUserAttributes((Collection) cognitoUserAttributes.getAttributesList()).withValidationData((Collection) arrayList).withClientMetadata(map2).withUserContextData(getUserContextData(str));
        String pinpointEndpointId = getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            withUserContextData.setAnalyticsMetadata(analyticsMetadataType);
        }
        return this.client.signUp(withUserContextData);
    }

    public String getClientId() {
        return this.clientId;
    }

    public CognitoUser getCurrentUser() {
        String str = "CognitoIdentityProvider." + this.clientId + ".LastAuthUser";
        return this.awsKeyValueStore.contains(str) ? getUser(this.awsKeyValueStore.get(str)) : getUser();
    }

    public String getPinpointEndpointId() {
        return this.pinpointEndpointId;
    }

    public CognitoUser getUser() {
        return new CognitoUser(this, null, this.clientId, this.clientSecret, null, this.client, this.context);
    }

    public UserContextDataType getUserContextData(String str) {
        if (!this.advancedSecurityDataCollectionFlag) {
            return null;
        }
        String encodedContextData = UserContextDataProvider.getInstance().getEncodedContextData(this.context, str, getUserPoolId(), this.clientId);
        UserContextDataType userContextDataType = new UserContextDataType();
        userContextDataType.setEncodedData(encodedContextData);
        return userContextDataType;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setAdvancedSecurityDataCollectionFlag(boolean z) {
        this.advancedSecurityDataCollectionFlag = z;
    }

    public void setIdentityProvider(AmazonCognitoIdentityProvider amazonCognitoIdentityProvider) {
        this.client = amazonCognitoIdentityProvider;
    }

    public void setPersistenceEnabled(boolean z) {
        this.isPersistenceEnabled = z;
        this.awsKeyValueStore.setPersistenceEnabled(z);
        CognitoDeviceHelper.setPersistenceEnabled(z);
    }

    public void signUp(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map map, SignUpHandler signUpHandler) {
        signUp(str, str2, cognitoUserAttributes, map, Collections.emptyMap(), signUpHandler);
    }

    public void signUpInBackground(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map map, SignUpHandler signUpHandler) {
        signUpInBackground(str, str2, cognitoUserAttributes, map, Collections.emptyMap(), signUpHandler);
    }

    @Deprecated
    public CognitoUserPool(Context context, String str, String str2, String str3) {
        this(context, str, str2, str3, new ClientConfiguration(), Regions.US_EAST_1);
    }

    public CognitoUser getUser(String str) {
        if (str != null && !str.isEmpty()) {
            String str2 = this.clientId;
            String str3 = this.clientSecret;
            return new CognitoUser(this, str, str2, str3, CognitoSecretHash.getSecretHash(str, str2, str3), this.client, this.context);
        }
        return getUser();
    }

    public void signUp(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map map, Map map2, SignUpHandler signUpHandler) {
        try {
            signUpHandler.onSuccess(getUser(str), signUpInternal(str, str2, cognitoUserAttributes, map, map2));
        } catch (Exception e) {
            signUpHandler.onFailure(e);
        }
    }

    public void signUpInBackground(String str, String str2, CognitoUserAttributes cognitoUserAttributes, Map map, Map map2, SignUpHandler signUpHandler) {
        new Thread(new 1(str, str2, cognitoUserAttributes, map, map2, signUpHandler)).start();
    }

    @Deprecated
    public CognitoUserPool(Context context, String str, String str2, String str3, ClientConfiguration clientConfiguration) {
        this(context, str, str2, str3, clientConfiguration, Regions.US_EAST_1);
    }

    public CognitoUserPool(Context context, String str, String str2, String str3, ClientConfiguration clientConfiguration, Regions regions) {
        this(context, str, str2, str3, clientConfiguration, regions, (String) null);
    }

    public CognitoUserPool(Context context, String str, String str2, String str3, ClientConfiguration clientConfiguration, Regions regions, String str4) {
        this.advancedSecurityDataCollectionFlag = true;
        this.isPersistenceEnabled = true;
        initialize(context);
        this.context = context;
        if (str.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException("Both UserPoolId and ClientId are required.");
        }
        if (str.length() > 55 || !Pattern.matches("^[\\w-]+_[0-9a-zA-Z]+$", str)) {
            throw new IllegalArgumentException("Invalid userPoolId format.");
        }
        this.userPoolId = str;
        this.clientId = str2;
        this.clientSecret = str3;
        AmazonCognitoIdentityProviderClient amazonCognitoIdentityProviderClient = new AmazonCognitoIdentityProviderClient(new AnonymousAWSCredentials(), clientConfiguration);
        this.client = amazonCognitoIdentityProviderClient;
        amazonCognitoIdentityProviderClient.setRegion(Region.getRegion(regions));
        this.pinpointEndpointId = CognitoPinpointSharedContext.getPinpointEndpoint(context, str4);
    }

    public CognitoUserPool(Context context, String str, String str2, String str3, Regions regions) {
        this(context, str, str2, str3, new ClientConfiguration(), regions);
    }

    public CognitoUserPool(Context context, String str, String str2, String str3, Regions regions, String str4) {
        this(context, str, str2, str3, new ClientConfiguration(), regions, str4);
    }

    public CognitoUserPool(Context context, String str, String str2, String str3, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider) {
        this(context, str, str2, str3, amazonCognitoIdentityProvider, (String) null);
    }

    public CognitoUserPool(Context context, String str, String str2, String str3, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider, String str4) {
        this(context, str, str2, str3, amazonCognitoIdentityProvider, str4, (String) null);
    }

    public CognitoUserPool(Context context, String str, String str2, String str3, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider, String str4, String str5) {
        this.advancedSecurityDataCollectionFlag = true;
        this.isPersistenceEnabled = true;
        initialize(context);
        this.context = context;
        if (str.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException("Both UserPoolId and ClientId are required.");
        }
        if (str.length() > 55 || !Pattern.matches("^[\\w-]+_[0-9a-zA-Z]+$", str)) {
            throw new IllegalArgumentException("Invalid userPoolId format.");
        }
        this.userPoolId = str;
        this.clientId = str2;
        this.clientSecret = str3;
        this.client = amazonCognitoIdentityProvider;
        this.pinpointEndpointId = CognitoPinpointSharedContext.getPinpointEndpoint(context, str4);
        if (str5 == null || str5.isEmpty()) {
            return;
        }
        this.client.setEndpoint(str5);
    }
}
