package com.amazonaws.auth;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazonaws.services.securitytoken.model.Credentials;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoCredentialsProvider implements AWSCredentialsProvider {
    public static final int DEFAULT_DURATION_SECONDS = 3600;
    public static final int DEFAULT_THRESHOLD_SECONDS = 500;
    private static final Log log = LogFactory.getLog(AWSCredentialsProviderChain.class);
    protected String authRoleArn;
    private AmazonCognitoIdentity cib;
    protected final ReentrantReadWriteLock credentialsLock;
    protected String customRoleArn;
    private final AWSCognitoIdentityProvider identityProvider;
    protected int refreshThreshold;
    private final String region;
    protected AWSSecurityTokenService securityTokenService;
    protected AWSSessionCredentials sessionCredentials;
    protected Date sessionCredentialsExpiration;
    protected int sessionDuration;
    protected String token;
    protected String unauthRoleArn;
    protected final boolean useEnhancedFlow;

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions) {
        this(aWSCognitoIdentityProvider, regions, new ClientConfiguration());
    }

    private void appendUserAgent(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        amazonWebServiceRequest.getRequestClientOptions().appendUserAgent(str);
    }

    private static AmazonCognitoIdentityClient createIdentityClient(ClientConfiguration clientConfiguration, Regions regions) {
        AmazonCognitoIdentityClient amazonCognitoIdentityClient = new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration);
        amazonCognitoIdentityClient.setRegion(Region.getRegion(regions));
        return amazonCognitoIdentityClient;
    }

    private static ClientConfiguration getClientConfiguration(AWSConfiguration aWSConfiguration) {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setUserAgent(aWSConfiguration.getUserAgent());
        return clientConfiguration;
    }

    private static Regions getRegions(AWSConfiguration aWSConfiguration) {
        try {
            return Regions.fromName(aWSConfiguration.optJsonObject("CredentialsProvider").optJSONObject("CognitoIdentity").getJSONObject(aWSConfiguration.getConfiguration()).getString("Region"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to read CognitoIdentity please check your setup or awsconfiguration.json file", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void populateCredentialsWithCognito(java.lang.String r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L15
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L15
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = r5.getLoginsKey()
            r0.put(r1, r6)
            goto L19
        L15:
            java.util.Map r0 = r5.getLogins()
        L19:
            com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest r6 = new com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest
            r6.<init>()
            java.lang.String r1 = r5.getIdentityId()
            com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest r6 = r6.withIdentityId(r1)
            com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest r6 = r6.withLogins(r0)
            java.lang.String r0 = r5.customRoleArn
            com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest r6 = r6.withCustomRoleArn(r0)
            com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity r0 = r5.cib     // Catch: com.amazonaws.AmazonServiceException -> L37 com.amazonaws.services.cognitoidentity.model.ResourceNotFoundException -> L44
            com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult r6 = r0.getCredentialsForIdentity(r6)     // Catch: com.amazonaws.AmazonServiceException -> L37 com.amazonaws.services.cognitoidentity.model.ResourceNotFoundException -> L44
            goto L4a
        L37:
            r6 = move-exception
            java.lang.String r0 = r6.getErrorCode()
            java.lang.String r1 = "ValidationException"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L49
        L44:
            com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult r6 = r5.retryGetCredentialsForIdentity()
            goto L4a
        L49:
            throw r6
        L4a:
            com.amazonaws.services.cognitoidentity.model.Credentials r0 = r6.getCredentials()
            com.amazonaws.auth.BasicSessionCredentials r1 = new com.amazonaws.auth.BasicSessionCredentials
            java.lang.String r2 = r0.getAccessKeyId()
            java.lang.String r3 = r0.getSecretKey()
            java.lang.String r4 = r0.getSessionToken()
            r1.<init>(r2, r3, r4)
            r5.sessionCredentials = r1
            java.util.Date r0 = r0.getExpiration()
            r5.setSessionCredentialsExpiration(r0)
            java.lang.String r0 = r6.getIdentityId()
            java.lang.String r1 = r5.getIdentityId()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7d
            java.lang.String r6 = r6.getIdentityId()
            r5.setIdentityId(r6)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.auth.CognitoCredentialsProvider.populateCredentialsWithCognito(java.lang.String):void");
    }

    private void populateCredentialsWithSts(String str) {
        AssumeRoleWithWebIdentityRequest withDurationSeconds = new AssumeRoleWithWebIdentityRequest().withWebIdentityToken(str).withRoleArn(this.identityProvider.isAuthenticated() ? this.authRoleArn : this.unauthRoleArn).withRoleSessionName("ProviderSession").withDurationSeconds(Integer.valueOf(this.sessionDuration));
        appendUserAgent(withDurationSeconds, getUserAgent());
        Credentials credentials = this.securityTokenService.assumeRoleWithWebIdentity(withDurationSeconds).getCredentials();
        this.sessionCredentials = new BasicSessionCredentials(credentials.getAccessKeyId(), credentials.getSecretAccessKey(), credentials.getSessionToken());
        setSessionCredentialsExpiration(credentials.getExpiration());
    }

    private GetCredentialsForIdentityResult retryGetCredentialsForIdentity() {
        HashMap logins;
        String retryRefresh = retryRefresh();
        this.token = retryRefresh;
        if (retryRefresh == null || retryRefresh.isEmpty()) {
            logins = getLogins();
        } else {
            logins = new HashMap();
            logins.put(getLoginsKey(), this.token);
        }
        return this.cib.getCredentialsForIdentity(new GetCredentialsForIdentityRequest().withIdentityId(getIdentityId()).withLogins(logins).withCustomRoleArn(this.customRoleArn));
    }

    private String retryRefresh() {
        setIdentityId(null);
        String refresh = this.identityProvider.refresh();
        this.token = refresh;
        return refresh;
    }

    public void clear() {
        this.credentialsLock.writeLock().lock();
        try {
            clearCredentials();
            setIdentityId(null);
            this.identityProvider.setLogins(new HashMap());
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public void clearCredentials() {
        this.credentialsLock.writeLock().lock();
        try {
            this.sessionCredentials = null;
            this.sessionCredentialsExpiration = null;
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public String getCustomRoleArn() {
        return this.customRoleArn;
    }

    public String getIdentityId() {
        return this.identityProvider.getIdentityId();
    }

    public String getIdentityPoolId() {
        return this.identityProvider.getIdentityPoolId();
    }

    public AWSIdentityProvider getIdentityProvider() {
        return this.identityProvider;
    }

    public Map getLogins() {
        return this.identityProvider.getLogins();
    }

    public String getLoginsKey() {
        return Regions.CN_NORTH_1.getName().equals(this.region) ? "cognito-identity.cn-north-1.amazonaws.com.cn" : "cognito-identity.amazonaws.com";
    }

    public int getRefreshThreshold() {
        return this.refreshThreshold;
    }

    public Date getSessionCredentialsExpiration() {
        this.credentialsLock.readLock().lock();
        try {
            return this.sessionCredentialsExpiration;
        } finally {
            this.credentialsLock.readLock().unlock();
        }
    }

    @Deprecated
    public Date getSessionCredentitalsExpiration() {
        return getSessionCredentialsExpiration();
    }

    public int getSessionDuration() {
        return this.sessionDuration;
    }

    public String getToken() {
        return this.identityProvider.getToken();
    }

    public String getUserAgent() {
        return "";
    }

    public boolean needsNewSession() {
        if (this.sessionCredentials == null) {
            return true;
        }
        return this.sessionCredentialsExpiration.getTime() - (System.currentTimeMillis() - (SDKGlobalConfiguration.getGlobalTimeOffset() * 1000)) < ((long) (this.refreshThreshold * 1000));
    }

    public void refresh() {
        this.credentialsLock.writeLock().lock();
        try {
            startSession();
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public void registerIdentityChangedListener(IdentityChangedListener identityChangedListener) {
        this.identityProvider.registerIdentityChangedListener(identityChangedListener);
    }

    public void setCustomRoleArn(String str) {
        this.customRoleArn = str;
    }

    public void setIdentityId(String str) {
        this.identityProvider.identityChanged(str);
    }

    public void setLogins(Map map) {
        this.credentialsLock.writeLock().lock();
        try {
            this.identityProvider.setLogins(map);
            clearCredentials();
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public void setRefreshThreshold(int i) {
        this.refreshThreshold = i;
    }

    public void setSessionCredentialsExpiration(Date date) {
        this.credentialsLock.writeLock().lock();
        try {
            this.sessionCredentialsExpiration = date;
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public void setSessionDuration(int i) {
        this.sessionDuration = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startSession() {
        /*
            r3 = this;
            com.amazonaws.auth.AWSCognitoIdentityProvider r0 = r3.identityProvider     // Catch: com.amazonaws.AmazonServiceException -> L9 com.amazonaws.services.cognitoidentity.model.ResourceNotFoundException -> L16
            java.lang.String r0 = r0.refresh()     // Catch: com.amazonaws.AmazonServiceException -> L9 com.amazonaws.services.cognitoidentity.model.ResourceNotFoundException -> L16
            r3.token = r0     // Catch: com.amazonaws.AmazonServiceException -> L9 com.amazonaws.services.cognitoidentity.model.ResourceNotFoundException -> L16
            goto L1e
        L9:
            r0 = move-exception
            java.lang.String r1 = r0.getErrorCode()
            java.lang.String r2 = "ValidationException"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L1d
        L16:
            java.lang.String r0 = r3.retryRefresh()
            r3.token = r0
            goto L1e
        L1d:
            throw r0
        L1e:
            boolean r0 = r3.useEnhancedFlow
            if (r0 == 0) goto L28
            java.lang.String r0 = r3.token
            r3.populateCredentialsWithCognito(r0)
            goto L2d
        L28:
            java.lang.String r0 = r3.token
            r3.populateCredentialsWithSts(r0)
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.auth.CognitoCredentialsProvider.startSession():void");
    }

    public void unregisterIdentityChangedListener(IdentityChangedListener identityChangedListener) {
        this.identityProvider.unregisterIdentityChangedListener(identityChangedListener);
    }

    public AWSCredentialsProvider withLogins(Map map) {
        setLogins(map);
        return this;
    }

    public CognitoCredentialsProvider withRefreshThreshold(int i) {
        setRefreshThreshold(i);
        return this;
    }

    public CognitoCredentialsProvider withSessionDuration(int i) {
        setSessionDuration(i);
        return this;
    }

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions, ClientConfiguration clientConfiguration) {
        this(aWSCognitoIdentityProvider, createIdentityClient(clientConfiguration, regions));
    }

    private static String getIdentityPoolId(AWSConfiguration aWSConfiguration) {
        try {
            return aWSConfiguration.optJsonObject("CredentialsProvider").optJSONObject("CognitoIdentity").getJSONObject(aWSConfiguration.getConfiguration()).getString("PoolId");
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to read CognitoIdentity please check your setup or awsconfiguration.json file", e);
        }
    }

    public AWSSessionCredentials getCredentials() {
        this.credentialsLock.writeLock().lock();
        try {
            if (needsNewSession()) {
                startSession();
            }
            AWSSessionCredentials aWSSessionCredentials = this.sessionCredentials;
            this.credentialsLock.writeLock().unlock();
            return aWSSessionCredentials;
        } catch (Throwable th) {
            this.credentialsLock.writeLock().unlock();
            throw th;
        }
    }

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, AmazonCognitoIdentityClient amazonCognitoIdentityClient) {
        this.cib = amazonCognitoIdentityClient;
        this.region = amazonCognitoIdentityClient.getRegions().getName();
        this.identityProvider = aWSCognitoIdentityProvider;
        this.unauthRoleArn = null;
        this.authRoleArn = null;
        this.securityTokenService = null;
        this.sessionDuration = 3600;
        this.refreshThreshold = 500;
        this.useEnhancedFlow = true;
        this.credentialsLock = new ReentrantReadWriteLock(true);
    }

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2) {
        this(aWSCognitoIdentityProvider, str, str2, new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials(), new ClientConfiguration()));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CognitoCredentialsProvider(com.amazonaws.auth.AWSCognitoIdentityProvider r3, java.lang.String r4, java.lang.String r5, com.amazonaws.services.securitytoken.AWSSecurityTokenService r6) {
        /*
            r2 = this;
            r2.<init>()
            r2.identityProvider = r3
            boolean r0 = r3 instanceof com.amazonaws.auth.AWSAbstractCognitoIdentityProvider
            if (r0 == 0) goto L28
            com.amazonaws.auth.AWSAbstractCognitoIdentityProvider r3 = (com.amazonaws.auth.AWSAbstractCognitoIdentityProvider) r3
            com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity r0 = r3.cib
            boolean r1 = r0 instanceof com.amazonaws.AmazonWebServiceClient
            if (r1 == 0) goto L28
            com.amazonaws.AmazonWebServiceClient r0 = (com.amazonaws.AmazonWebServiceClient) r0
            com.amazonaws.regions.Regions r0 = r0.getRegions()
            if (r0 == 0) goto L28
            com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity r3 = r3.cib
            com.amazonaws.AmazonWebServiceClient r3 = (com.amazonaws.AmazonWebServiceClient) r3
            com.amazonaws.regions.Regions r3 = r3.getRegions()
        L21:
            java.lang.String r3 = r3.getName()
            r2.region = r3
            goto L32
        L28:
            com.amazonaws.logging.Log r3 = com.amazonaws.auth.CognitoCredentialsProvider.log
            java.lang.String r0 = "Could not determine region of the Cognito Identity client, using default us-east-1"
            r3.warn(r0)
            com.amazonaws.regions.Regions r3 = com.amazonaws.regions.Regions.US_EAST_1
            goto L21
        L32:
            r2.unauthRoleArn = r4
            r2.authRoleArn = r5
            r2.securityTokenService = r6
            r3 = 3600(0xe10, float:5.045E-42)
            r2.sessionDuration = r3
            r3 = 500(0x1f4, float:7.0E-43)
            r2.refreshThreshold = r3
            r3 = 0
            r2.useEnhancedFlow = r3
            java.util.concurrent.locks.ReentrantReadWriteLock r3 = new java.util.concurrent.locks.ReentrantReadWriteLock
            r4 = 1
            r3.<init>(r4)
            r2.credentialsLock = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.auth.CognitoCredentialsProvider.<init>(com.amazonaws.auth.AWSCognitoIdentityProvider, java.lang.String, java.lang.String, com.amazonaws.services.securitytoken.AWSSecurityTokenService):void");
    }

    public CognitoCredentialsProvider(AWSConfiguration aWSConfiguration) {
        this((String) null, getIdentityPoolId(aWSConfiguration), (String) null, (String) null, getRegions(aWSConfiguration), getClientConfiguration(aWSConfiguration));
    }

    public CognitoCredentialsProvider(String str, Regions regions) {
        this((String) null, str, (String) null, (String) null, regions, new ClientConfiguration());
    }

    public CognitoCredentialsProvider(String str, Regions regions, ClientConfiguration clientConfiguration) {
        this((String) null, str, (String) null, (String) null, regions, clientConfiguration);
    }

    public CognitoCredentialsProvider(String str, String str2, String str3, String str4, Regions regions) {
        this(str, str2, str3, str4, regions, new ClientConfiguration());
    }

    public CognitoCredentialsProvider(String str, String str2, String str3, String str4, Regions regions, ClientConfiguration clientConfiguration) {
        this(str, str2, str3, str4, createIdentityClient(clientConfiguration, regions), (str3 == null && str4 == null) ? null : new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials(), clientConfiguration));
    }

    public CognitoCredentialsProvider(String str, String str2, String str3, String str4, AmazonCognitoIdentityClient amazonCognitoIdentityClient, AWSSecurityTokenService aWSSecurityTokenService) {
        this.cib = amazonCognitoIdentityClient;
        this.region = amazonCognitoIdentityClient.getRegions().getName();
        this.securityTokenService = aWSSecurityTokenService;
        this.unauthRoleArn = str3;
        this.authRoleArn = str4;
        this.sessionDuration = 3600;
        this.refreshThreshold = 500;
        boolean z = str3 == null && str4 == null;
        this.useEnhancedFlow = z;
        this.identityProvider = z ? new AWSEnhancedCognitoIdentityProvider(str, str2, amazonCognitoIdentityClient) : new AWSBasicCognitoIdentityProvider(str, str2, amazonCognitoIdentityClient);
        this.credentialsLock = new ReentrantReadWriteLock(true);
    }
}
