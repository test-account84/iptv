package com.amazonaws.mobileconnectors.appsync;

import K1.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import com.amazonaws.mobileconnectors.appsync.cache.normalized.AppSyncStore;
import com.amazonaws.mobileconnectors.appsync.cache.normalized.sql.AppSyncSqlHelper;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.amazonaws.mobileconnectors.appsync.retry.RetryInterceptor;
import com.amazonaws.mobileconnectors.appsync.sigv4.APIKeyAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.AWSLambdaAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.AppSyncSigV4SignerInterceptor;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicAPIKeyAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.CognitoUserPoolsAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.OidcAuthProvider;
import com.amazonaws.mobileconnectors.appsync.subscription.RealSubscriptionManager;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
import u1.a;
import u1.c;
import v1.e;
import v1.f;
import v1.h;
import v1.k;
import v1.r;
import v1.s;
import v1.t;
import z1.b;
import z1.c;
import z1.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AWSAppSyncClient {
    static final String CLIENT_DATABAE_PREFIX_PATTERN = "^[_a-zA-Z0-9]+$";
    static final String DATABASE_NAME_DELIMITER = "_";
    static final String DEFAULT_DELTA_SYNC_SQL_STORE_NAME = "appsync_deltasync_db";
    static final String DEFAULT_MUTATION_SQL_STORE_NAME = "appsyncstore_mutation";
    static final String DEFAULT_QUERY_SQL_STORE_NAME = "appsyncstore";
    private Context applicationContext;
    String clientDatabasePrefix;
    String deltaSyncSqlStoreName;
    a mApolloClient;
    private AppSyncOfflineMutationManager mAppSyncOfflineMutationManager;
    r mS3ObjectManager;
    AppSyncStore mSyncStore;
    String mutationSqlStoreName;
    private Map mutationsToRetryAfterConflictResolution;
    String querySqlStoreName;
    private final WebSocketConnectionManager webSocketConnectionManager;
    static Map prefixMap = new ConcurrentHashMap();
    private static final String TAG = AWSAppSyncClient.class.getSimpleName();

    public class AWSAppSyncDeltaSyncWatcher implements M1.a {
        boolean canceled = false;
        long id;

        public AWSAppSyncDeltaSyncWatcher(long j) {
            this.id = j;
        }

        public void cancel() {
            if (this.canceled) {
                return;
            }
            AWSAppSyncDeltaSync.cancel(Long.valueOf(this.id));
            this.canceled = true;
        }

        public boolean isCanceled() {
            return this.canceled;
        }
    }

    public enum AuthMode {
        API_KEY("API_KEY"),
        AWS_IAM("AWS_IAM"),
        AMAZON_COGNITO_USER_POOLS("AMAZON_COGNITO_USER_POOLS"),
        OPENID_CONNECT("OPENID_CONNECT"),
        AWS_LAMBDA("AWS_LAMBDA");

        private final String name;

        AuthMode(String str) {
            this.name = str;
        }

        public static AuthMode fromName(String str) {
            for (AuthMode authMode : values()) {
                if (str.equals(authMode.getName())) {
                    return authMode;
                }
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

    public static class Builder {
        final Map customTypeAdapters;
        AWSLambdaAuthProvider mAWSLambdaAuthProvider;
        APIKeyAuthProvider mApiKey;
        AWSConfiguration mAwsConfiguration;
        y1.a mCacheHeaders;
        String mClientDatabasePrefix;
        CognitoUserPoolsAuthProvider mCognitoUserPoolsAuthProvider;
        ConflictResolverInterface mConflictResolver;
        Context mContext;
        AWSCredentialsProvider mCredentialsProvider;
        C1.a mDefaultResponseFetcher;
        Executor mDispatcher;
        long mMutationQueueExecutionTimeout;
        g mNormalizedCacheFactory;
        OidcAuthProvider mOidcAuthProvider;
        OkHttpClient mOkHttpClient;
        PersistentMutationsCallback mPersistentMutationsCallback;
        Regions mRegion;
        c mResolver;
        r mS3ObjectManager;
        String mServerUrl;
        boolean mSubscriptionsAutoReconnect;
        boolean mUseClientDatabasePrefix;

        public class 1 extends c {
            public 1() {
            }

            private b formatCacheKey(String str) {
                return (str == null || str.isEmpty()) ? b.b : b.a(str);
            }

            public b fromFieldArguments(k kVar, f.b bVar) {
                return formatCacheKey((String) kVar.j("id", bVar));
            }

            public b fromFieldRecordSet(k kVar, Map map) {
                return formatCacheKey((String) map.get("id"));
            }
        }

        private Builder() {
            this.mSubscriptionsAutoReconnect = true;
            this.mMutationQueueExecutionTimeout = 300000L;
            this.customTypeAdapters = new LinkedHashMap();
            this.mDefaultResponseFetcher = AppSyncResponseFetchers.CACHE_FIRST;
        }

        public Builder addCustomTypeAdapter(s sVar, u1.b bVar) {
            this.customTypeAdapters.put(sVar, bVar);
            return this;
        }

        public Builder apiKey(APIKeyAuthProvider aPIKeyAuthProvider) {
            this.mApiKey = aPIKeyAuthProvider;
            return this;
        }

        public Builder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.mAwsConfiguration = aWSConfiguration;
            return this;
        }

        public Builder awsLamdbaAuthProvider(AWSLambdaAuthProvider aWSLambdaAuthProvider) {
            this.mAWSLambdaAuthProvider = aWSLambdaAuthProvider;
            return this;
        }

        public AWSAppSyncClient build() {
            Object obj;
            AuthMode authMode;
            String str;
            String str2;
            if (this.mContext == null) {
                throw new RuntimeException("A valid Android Context is required.");
            }
            HashMap hashMap = new HashMap();
            APIKeyAuthProvider aPIKeyAuthProvider = this.mApiKey;
            AuthMode authMode2 = AuthMode.API_KEY;
            hashMap.put(aPIKeyAuthProvider, authMode2);
            hashMap.put(this.mCredentialsProvider, AuthMode.AWS_IAM);
            hashMap.put(this.mCognitoUserPoolsAuthProvider, AuthMode.AMAZON_COGNITO_USER_POOLS);
            hashMap.put(this.mOidcAuthProvider, AuthMode.OPENID_CONNECT);
            hashMap.put(this.mAWSLambdaAuthProvider, AuthMode.AWS_LAMBDA);
            hashMap.remove((Object) null);
            if (hashMap.size() > 1) {
                throw new RuntimeException("More than one AuthMode has been passed in to the builder. " + hashMap.values().toString() + ". Please pass in exactly one AuthMode into the builder.");
            }
            Iterator it = hashMap.keySet().iterator();
            if (it.hasNext()) {
                obj = it.next();
                authMode = (AuthMode) hashMap.get(obj);
            } else {
                obj = null;
                authMode = null;
            }
            AWSConfiguration aWSConfiguration = this.mAwsConfiguration;
            if (aWSConfiguration != null) {
                try {
                    JSONObject optJsonObject = aWSConfiguration.optJsonObject("AppSync");
                    if (optJsonObject == null) {
                        throw new RuntimeException("AppSync configuration is missing from awsconfiguration.json");
                    }
                    String str3 = this.mServerUrl;
                    if (str3 == null) {
                        str3 = optJsonObject.getString("ApiUrl");
                    }
                    this.mServerUrl = str3;
                    Regions regions = this.mRegion;
                    if (regions == null) {
                        regions = Regions.fromName(optJsonObject.getString("Region"));
                    }
                    this.mRegion = regions;
                    if (this.mUseClientDatabasePrefix && this.mClientDatabasePrefix == null) {
                        try {
                            this.mClientDatabasePrefix = optJsonObject.getString("ClientDatabasePrefix");
                        } catch (Exception unused) {
                            Log.e(AWSAppSyncClient.access$000(), "Error is reading the ClientDatabasePrefix from AppSync configuration in awsconfiguration.json.");
                            throw new RuntimeException("ClientDatabasePrefix is not present in AppSync configuration in awsconfiguration.json however .useClientDatabasePrefix(true) is passed in.");
                        }
                    }
                    AuthMode fromName = AuthMode.fromName(optJsonObject.getString("AuthMode"));
                    if (obj == null && fromName.equals(authMode2)) {
                        BasicAPIKeyAuthProvider basicAPIKeyAuthProvider = new BasicAPIKeyAuthProvider(optJsonObject.getString("ApiKey"));
                        this.mApiKey = basicAPIKeyAuthProvider;
                        hashMap.put(basicAPIKeyAuthProvider, authMode2);
                        authMode = fromName;
                    }
                    if (!fromName.equals(authMode)) {
                        throw new RuntimeException("Found conflicting AuthMode. Should be " + fromName.toString() + " but you selected " + authMode.toString());
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Please check the AppSync configuration in awsconfiguration.json.", e);
                }
            }
            if (hashMap.size() == 0) {
                throw new RuntimeException("No valid AuthMode object is passed in to the builder.");
            }
            if (this.mUseClientDatabasePrefix && ((str2 = this.mClientDatabasePrefix) == null || StringUtils.isBlank(str2))) {
                throw new RuntimeException("Please pass in a valid ClientDatabasePrefix when useClientDatabasePrefix is true.");
            }
            if (!this.mUseClientDatabasePrefix && (str = this.mClientDatabasePrefix) != null && !StringUtils.isBlank(str)) {
                Log.w(AWSAppSyncClient.access$000(), "A ClientDatabasePrefix is passed in however useClientDatabasePrefix is false.");
                this.mClientDatabasePrefix = null;
            }
            if (this.mUseClientDatabasePrefix) {
                if (this.mClientDatabasePrefix != null && !Pattern.compile("^[_a-zA-Z0-9]+$").matcher(this.mClientDatabasePrefix).matches()) {
                    throw new RuntimeException("ClientDatabasePrefix validation failed. Please pass in characters that matches the pattern: ^[_a-zA-Z0-9]+$");
                }
                String str4 = (String) AWSAppSyncClient.prefixMap.get(this.mClientDatabasePrefix);
                if (str4 != null) {
                    if (!str4.equals(this.mServerUrl + "_" + authMode)) {
                        throw new RuntimeException("ClientDatabasePrefix validation failed. The ClientDatabasePrefix " + this.mClientDatabasePrefix + " is already used by an other AWSAppSyncClient object with API Server Url: " + this.mServerUrl + " with authMode: " + authMode);
                    }
                } else {
                    AWSAppSyncClient.prefixMap.put(this.mClientDatabasePrefix, this.mServerUrl + "_" + authMode);
                }
            }
            if (this.mResolver == null) {
                this.mResolver = new 1();
            }
            return new AWSAppSyncClient(this, null);
        }

        public Builder clientDatabasePrefix(String str) {
            this.mClientDatabasePrefix = str;
            return this;
        }

        public Builder cognitoUserPoolsAuthProvider(CognitoUserPoolsAuthProvider cognitoUserPoolsAuthProvider) {
            this.mCognitoUserPoolsAuthProvider = cognitoUserPoolsAuthProvider;
            return this;
        }

        public Builder conflictResolver(ConflictResolverInterface conflictResolverInterface) {
            this.mConflictResolver = conflictResolverInterface;
            return this;
        }

        public Builder context(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder credentialsProvider(AWSCredentialsProvider aWSCredentialsProvider) {
            this.mCredentialsProvider = aWSCredentialsProvider;
            return this;
        }

        public Builder defaultCacheHeaders(y1.a aVar) {
            this.mCacheHeaders = aVar;
            return this;
        }

        public Builder defaultResponseFetcher(C1.a aVar) {
            this.mDefaultResponseFetcher = aVar;
            return this;
        }

        public Builder dispatcher(Executor executor) {
            this.mDispatcher = executor;
            return this;
        }

        public Builder mutationQueueExecutionTimeout(long j) {
            this.mMutationQueueExecutionTimeout = j;
            return this;
        }

        public Builder normalizedCache(g gVar) {
            this.mNormalizedCacheFactory = gVar;
            return this;
        }

        public Builder oidcAuthProvider(OidcAuthProvider oidcAuthProvider) {
            this.mOidcAuthProvider = oidcAuthProvider;
            return this;
        }

        public Builder okHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
        }

        public Builder persistentMutationsCallback(PersistentMutationsCallback persistentMutationsCallback) {
            this.mPersistentMutationsCallback = persistentMutationsCallback;
            return this;
        }

        public Builder region(Regions regions) {
            this.mRegion = regions;
            return this;
        }

        public Builder resolver(c cVar) {
            this.mResolver = cVar;
            return this;
        }

        public Builder s3ObjectManager(r rVar) {
            this.mS3ObjectManager = rVar;
            return this;
        }

        public Builder serverUrl(String str) {
            this.mServerUrl = str;
            return this;
        }

        public Builder subscriptionsAutoReconnect(boolean z) {
            this.mSubscriptionsAutoReconnect = z;
            return this;
        }

        public Builder useClientDatabasePrefix(boolean z) {
            this.mUseClientDatabasePrefix = z;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    private AWSAppSyncClient(Builder builder) {
        AppSyncSigV4SignerInterceptor appSyncSigV4SignerInterceptor;
        this.mAppSyncOfflineMutationManager = null;
        this.querySqlStoreName = "appsyncstore";
        this.mutationSqlStoreName = "appsyncstore_mutation";
        this.deltaSyncSqlStoreName = "appsync_deltasync_db";
        this.applicationContext = builder.mContext.getApplicationContext();
        String str = builder.mClientDatabasePrefix;
        if (str != null) {
            this.clientDatabasePrefix = str;
            this.querySqlStoreName = this.clientDatabasePrefix + "_appsyncstore";
            this.mutationSqlStoreName = this.clientDatabasePrefix + "_appsyncstore_mutation";
            this.deltaSyncSqlStoreName = this.clientDatabasePrefix + "_appsync_deltasync_db";
        }
        if (builder.mCredentialsProvider != null) {
            appSyncSigV4SignerInterceptor = new AppSyncSigV4SignerInterceptor(builder.mCredentialsProvider, builder.mRegion.getName());
        } else if (builder.mCognitoUserPoolsAuthProvider != null) {
            appSyncSigV4SignerInterceptor = new AppSyncSigV4SignerInterceptor(builder.mCognitoUserPoolsAuthProvider, builder.mRegion.getName());
        } else if (builder.mOidcAuthProvider != null) {
            appSyncSigV4SignerInterceptor = new AppSyncSigV4SignerInterceptor(builder.mOidcAuthProvider);
        } else if (builder.mAWSLambdaAuthProvider != null) {
            appSyncSigV4SignerInterceptor = new AppSyncSigV4SignerInterceptor(builder.mAWSLambdaAuthProvider);
        } else {
            if (builder.mApiKey == null) {
                throw new RuntimeException("Client requires credentials. Please use #apiKey() #credentialsProvider() or #cognitoUserPoolsAuthProvider() to set the credentials.");
            }
            appSyncSigV4SignerInterceptor = new AppSyncSigV4SignerInterceptor(builder.mApiKey, builder.mRegion.getName(), getClientSubscriptionUUID(builder.mApiKey.getAPIKey()));
        }
        OkHttpClient okHttpClient = builder.mOkHttpClient;
        OkHttpClient build = (okHttpClient == null ? new OkHttpClient.Builder() : okHttpClient.newBuilder()).addInterceptor(new RetryInterceptor()).addInterceptor(appSyncSigV4SignerInterceptor).build();
        if (builder.mNormalizedCacheFactory == null) {
            builder.mNormalizedCacheFactory = new A1.b(AppSyncSqlHelper.create(this.applicationContext, this.querySqlStoreName));
        }
        AppSyncMutationSqlCacheOperations appSyncMutationSqlCacheOperations = new AppSyncMutationSqlCacheOperations(new AppSyncMutationsSqlHelper(builder.mContext, this.mutationSqlStoreName));
        this.mutationsToRetryAfterConflictResolution = new HashMap();
        AppSyncOptimisticUpdateInterceptor appSyncOptimisticUpdateInterceptor = new AppSyncOptimisticUpdateInterceptor();
        this.mAppSyncOfflineMutationManager = new AppSyncOfflineMutationManager(builder.mContext, builder.customTypeAdapters, appSyncMutationSqlCacheOperations, new AppSyncCustomNetworkInvoker(HttpUrl.parse(builder.mServerUrl), build, new d(builder.customTypeAdapters), builder.mPersistentMutationsCallback, builder.mS3ObjectManager));
        a.b j = a.b().k(builder.mServerUrl).i(builder.mNormalizedCacheFactory, builder.mResolver).a(appSyncOptimisticUpdateInterceptor).a(new AppSyncOfflineMutationInterceptor(this.mAppSyncOfflineMutationManager, false, builder.mContext, this.mutationsToRetryAfterConflictResolution, this, builder.mConflictResolver, builder.mMutationQueueExecutionTimeout)).a(new AppSyncComplexObjectsInterceptor(builder.mS3ObjectManager)).j(build);
        for (s sVar : builder.customTypeAdapters.keySet()) {
            j.b(sVar, (u1.b) builder.customTypeAdapters.get(sVar));
        }
        Executor executor = builder.mDispatcher;
        if (executor != null) {
            j.h(executor);
        }
        y1.a aVar = builder.mCacheHeaders;
        if (aVar != null) {
            j.e(aVar);
        }
        C1.a aVar2 = builder.mDefaultResponseFetcher;
        if (aVar2 != null) {
            j.g(aVar2);
        }
        RealSubscriptionManager realSubscriptionManager = new RealSubscriptionManager(builder.mContext.getApplicationContext(), builder.mSubscriptionsAutoReconnect);
        j.l(realSubscriptionManager);
        a c = j.c();
        this.mApolloClient = c;
        realSubscriptionManager.setApolloClient(c);
        this.mSyncStore = new AppSyncStore(this.mApolloClient.a());
        appSyncOptimisticUpdateInterceptor.setStore(this.mApolloClient.a());
        realSubscriptionManager.setStore(this.mApolloClient.a());
        realSubscriptionManager.setScalarTypeAdapters(new d(builder.customTypeAdapters));
        this.mS3ObjectManager = builder.mS3ObjectManager;
        this.webSocketConnectionManager = new WebSocketConnectionManager(this.applicationContext, builder.mServerUrl, new SubscriptionAuthorizer(builder), new ApolloResponseBuilder(builder.customTypeAdapters, this.mApolloClient.a().j()), builder.mSubscriptionsAutoReconnect);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    private void clearDeltaSyncStore() {
        Log.d(TAG, "Clearing the delta sync store.");
        new AWSAppSyncDeltaSyncDBOperations(new AWSAppSyncDeltaSyncSqlHelper(this.applicationContext, this.deltaSyncSqlStoreName)).clearDeltaSyncStore();
    }

    private String getClientSubscriptionUUID(String str) {
        String str2 = null;
        try {
            SharedPreferences sharedPreferences = this.applicationContext.getSharedPreferences("com.amazonaws.mobileconnectors.appsync", 0);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            String hex = BinaryUtils.toHex(messageDigest.digest(str.getBytes()));
            String string = sharedPreferences.getString(hex, (String) null);
            if (string != null) {
                return string;
            }
            str2 = UUID.randomUUID().toString();
            sharedPreferences.edit().putString(hex, str2);
            return str2;
        } catch (NoSuchAlgorithmException e) {
            String str3 = TAG;
            Log.e(str3, "Error getting Subscription UUID " + e.getLocalizedMessage());
            Log.e(str3, "Proceeding without Subscription UUID");
            return str2;
        }
    }

    public void clearCaches() throws ClearCacheException {
        clearCaches(ClearCacheOptions.builder().clearQueries().clearMutations().clearSubscriptions().build());
    }

    @Deprecated
    public void clearMutationQueue() {
        this.mAppSyncOfflineMutationManager.clearMutationQueue();
    }

    public r getS3ObjectManager() {
        return this.mS3ObjectManager;
    }

    public AppSyncStore getStore() {
        return this.mSyncStore;
    }

    public boolean isMutationQueueEmpty() {
        AppSyncOfflineMutationManager appSyncOfflineMutationManager = this.mAppSyncOfflineMutationManager;
        if (appSyncOfflineMutationManager != null) {
            return appSyncOfflineMutationManager.mutationQueueEmpty();
        }
        return true;
    }

    public AppSyncMutationCall mutate(e eVar) {
        return mutate(eVar, false);
    }

    public AppSyncQueryCall query(h hVar) {
        return this.mApolloClient.query(hVar);
    }

    public AppSyncSubscriptionCall subscribe(t tVar) {
        return new AppSyncWebSocketSubscriptionCall(tVar, this.webSocketConnectionManager);
    }

    public M1.a sync(h hVar, c.a aVar, long j) {
        return sync(hVar, aVar, null, null, null, null, j);
    }

    public /* synthetic */ AWSAppSyncClient(Builder builder, 1 r2) {
        this(builder);
    }

    public void clearCaches(ClearCacheOptions clearCacheOptions) throws ClearCacheException {
        ClearCacheException clearCacheException = new ClearCacheException("Error in clearing the cache(s).");
        try {
            if (clearCacheOptions.isQueries()) {
                Log.d(TAG, "Clearing the query cache.");
                this.mSyncStore.clearAll().c();
            }
        } catch (Exception e) {
            clearCacheException.addException(e);
        }
        try {
            if (clearCacheOptions.isMutations()) {
                Log.d(TAG, "Clearing the mutations queue.");
                clearMutationQueue();
            }
        } catch (Exception e2) {
            clearCacheException.addException(e2);
        }
        try {
            if (clearCacheOptions.isSubscriptions()) {
                Log.d(TAG, "Clearing the delta sync subscriptions metadata cache.");
                clearDeltaSyncStore();
            }
        } catch (Exception e3) {
            clearCacheException.addException(e3);
        }
        if (clearCacheException.getExceptions() != null) {
            throw clearCacheException;
        }
    }

    public AppSyncMutationCall mutate(e eVar, f.a aVar) {
        return mutate(eVar, aVar, false);
    }

    public M1.a sync(h hVar, c.a aVar, h hVar2, c.a aVar2, long j) {
        return sync(hVar, aVar, null, null, hVar2, aVar2, j);
    }

    public AppSyncMutationCall mutate(e eVar, f.a aVar, boolean z) {
        if (z) {
            this.mutationsToRetryAfterConflictResolution.put(eVar, (Object) null);
        }
        return this.mApolloClient.mutate(eVar, aVar);
    }

    public M1.a sync(h hVar, c.a aVar, t tVar, AppSyncSubscriptionCall.Callback callback) {
        return sync(hVar, aVar, tVar, callback, null, null, 0L);
    }

    public AppSyncMutationCall mutate(e eVar, boolean z) {
        if (z) {
            this.mutationsToRetryAfterConflictResolution.put(eVar, (Object) null);
        }
        return this.mApolloClient.mutate(eVar);
    }

    public M1.a sync(h hVar, c.a aVar, t tVar, AppSyncSubscriptionCall.Callback callback, h hVar2, c.a aVar2, long j) {
        AWSAppSyncDeltaSync aWSAppSyncDeltaSync = new AWSAppSyncDeltaSync(hVar, this, this.applicationContext);
        aWSAppSyncDeltaSync.setBaseQueryCallback(aVar);
        aWSAppSyncDeltaSync.setSubscription(tVar);
        aWSAppSyncDeltaSync.setSubscriptionCallback(callback);
        if (hVar2 == null || aVar2 == null) {
            Log.d(TAG, "One of the following is null - Delta Query or Delta Query callback. Will switch to using the base query & callback");
            aWSAppSyncDeltaSync.setDeltaQuery(hVar);
            aWSAppSyncDeltaSync.setDeltaQueryCallback(aVar);
        } else {
            aWSAppSyncDeltaSync.setDeltaQuery(hVar2);
            aWSAppSyncDeltaSync.setDeltaQueryCallback(aVar2);
        }
        aWSAppSyncDeltaSync.setBaseRefreshIntervalInSeconds(j);
        return new AWSAppSyncDeltaSyncWatcher(aWSAppSyncDeltaSync.execute(false).longValue());
    }
}
