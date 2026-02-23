package com.amazonaws.mobileconnectors.appsync;

import android.content.Context;
import com.amazonaws.DefaultRequest;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.sigv4.APIKeyAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.AWSLambdaAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.AppSyncV4Signer;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicCognitoUserPoolsAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.CognitoUserPoolsAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.OidcAuthProvider;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.regions.Regions;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SubscriptionAuthorizer {
    private final AWSLambdaAuthProvider mAWSLambdaAuthProvider;
    private final APIKeyAuthProvider mApiKeyProvider;
    private final Context mApplicationContext;
    private final AWSConfiguration mAwsConfiguration;
    private final CognitoUserPoolsAuthProvider mCognitoUserPoolsAuthProvider;
    private final AWSCredentialsProvider mCredentialsProvider;
    private final OidcAuthProvider mOidcAuthProvider;
    private final String mServerUrl;

    public static final class ISO8601Timestamp {
        public static String now() {
            return new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.US).format(new Date());
        }
    }

    public SubscriptionAuthorizer(AWSAppSyncClient.Builder builder) {
        this.mAwsConfiguration = builder.mAwsConfiguration;
        this.mApplicationContext = builder.mContext;
        this.mOidcAuthProvider = builder.mOidcAuthProvider;
        this.mCredentialsProvider = builder.mCredentialsProvider;
        this.mCognitoUserPoolsAuthProvider = builder.mCognitoUserPoolsAuthProvider;
        this.mAWSLambdaAuthProvider = builder.mAWSLambdaAuthProvider;
        this.mServerUrl = builder.mServerUrl;
        this.mApiKeyProvider = builder.mApiKey;
    }

    private String getApiKey() throws JSONException {
        APIKeyAuthProvider aPIKeyAuthProvider = this.mApiKeyProvider;
        return aPIKeyAuthProvider != null ? aPIKeyAuthProvider.getAPIKey() : this.mAwsConfiguration.optJsonObject("AppSync").getString("ApiKey");
    }

    private String getApiRegion() throws JSONException {
        return this.mAwsConfiguration.optJsonObject("AppSync").getString("Region");
    }

    private JSONObject getAuthorizationDetailsForApiKey() {
        try {
            return new JSONObject().put("host", getHost(this.mServerUrl)).put("x-amz-date", ISO8601Timestamp.now()).put("x-api-key", getApiKey());
        } catch (MalformedURLException | JSONException e) {
            throw new RuntimeException("Error constructing the authorization json for Api key. ", e);
        }
    }

    private JSONObject getAuthorizationDetailsForAwsLambda() {
        try {
            return new JSONObject().put("host", getHost(this.mServerUrl)).put("Authorization", this.mAWSLambdaAuthProvider.getLatestAuthToken());
        } catch (MalformedURLException | JSONException e) {
            throw new RuntimeException("Error constructing authorization message json", e);
        }
    }

    private JSONObject getAuthorizationDetailsForIAM(boolean z, t tVar) throws JSONException {
        DefaultRequest defaultRequest = new DefaultRequest("appsync");
        try {
            String str = this.mServerUrl;
            if (z) {
                str = str + "/connect";
            }
            URI uri = new URI(str);
            defaultRequest.setEndpoint(uri);
            defaultRequest.addHeader("accept", "application/json, text/javascript");
            defaultRequest.addHeader("content-encoding", "amz-1.0");
            defaultRequest.addHeader("content-type", "application/json; charset=UTF-8");
            defaultRequest.setHttpMethod(HttpMethodName.valueOf("POST"));
            if (z) {
                defaultRequest.setContent(new ByteArrayInputStream("{}".getBytes()));
            } else {
                defaultRequest.setContent(new ByteArrayInputStream(getDataJson(tVar).getBytes()));
            }
            String str2 = uri.getAuthority().split("\\.")[2];
            if (DomainType.CUSTOM == DomainType.from(this.mServerUrl)) {
                str2 = getApiRegion();
            }
            (z ? new AppSyncV4Signer(str2, AppSyncV4Signer.ResourcePath.IAM_CONNECTION_RESOURCE_PATH) : new AppSyncV4Signer(str2)).sign(defaultRequest, getCredentialsProvider().getCredentials());
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry entry : defaultRequest.getHeaders().entrySet()) {
                    if (entry.getKey().equals("host")) {
                        jSONObject.put("host", getHost(this.mServerUrl));
                    } else {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                }
                return jSONObject;
            } catch (MalformedURLException e) {
                e = e;
                throw new RuntimeException("Error constructing authorization message json", e);
            } catch (JSONException e2) {
                e = e2;
                throw new RuntimeException("Error constructing authorization message json", e);
            }
        } catch (URISyntaxException e3) {
            throw new RuntimeException("Error constructing canonical URI for IAM request signature", e3);
        }
    }

    private JSONObject getAuthorizationDetailsForOidc() {
        try {
            return new JSONObject().put("host", getHost(this.mServerUrl)).put("Authorization", this.mOidcAuthProvider.getLatestAuthToken());
        } catch (MalformedURLException | JSONException e) {
            throw new RuntimeException("Error constructing authorization message json", e);
        }
    }

    private JSONObject getAuthorizationDetailsForUserpools() {
        try {
            return new JSONObject().put("host", getHost(this.mServerUrl)).put("Authorization", getCognitoUserPoolsAuthProvider().getLatestAuthToken());
        } catch (JSONException | MalformedURLException e) {
            throw new RuntimeException("Error constructing authorization message JSON.", e);
        }
    }

    private CognitoUserPoolsAuthProvider getCognitoUserPoolsAuthProvider() {
        CognitoUserPoolsAuthProvider cognitoUserPoolsAuthProvider = this.mCognitoUserPoolsAuthProvider;
        return cognitoUserPoolsAuthProvider != null ? cognitoUserPoolsAuthProvider : new BasicCognitoUserPoolsAuthProvider(new CognitoUserPool(this.mApplicationContext, this.mAwsConfiguration));
    }

    private AWSCredentialsProvider getCredentialsProvider() throws RuntimeException {
        AWSCredentialsProvider aWSCredentialsProvider = this.mCredentialsProvider;
        if (aWSCredentialsProvider != null) {
            return aWSCredentialsProvider;
        }
        try {
            String region = getRegion();
            return new CognitoCachingCredentialsProvider(this.mApplicationContext, getIdentityPoolId(), Regions.fromName(region));
        } catch (JSONException e) {
            throw new RuntimeException("Error reading identity pool information from AWSConfiguration", e);
        }
    }

    private static String getDataJson(t tVar) {
        try {
            return new JSONObject().put("query", tVar.queryDocument()).put("variables", new JSONObject(tVar.variables().valueMap())).toString();
        } catch (JSONException e) {
            throw new RuntimeException("Error constructing JSON object", e);
        }
    }

    private static String getHost(String str) throws MalformedURLException {
        return new URL(str).getHost();
    }

    private String getIdentityPoolId() throws JSONException {
        return this.mAwsConfiguration.optJsonObject("CredentialsProvider").getJSONObject("CognitoIdentity").getJSONObject(this.mAwsConfiguration.getConfiguration()).getString("PoolId");
    }

    private String getRegion() throws JSONException {
        return this.mAwsConfiguration.optJsonObject("CredentialsProvider").getJSONObject("CognitoIdentity").getJSONObject(this.mAwsConfiguration.getConfiguration()).getString("Region");
    }

    public JSONObject getAuthorizationDetails(boolean z, t tVar) throws JSONException {
        try {
            String string = this.mAwsConfiguration.optJsonObject("AppSync").getString("AuthMode");
            string.hashCode();
            switch (string) {
                case "AMAZON_COGNITO_USER_POOLS":
                    return getAuthorizationDetailsForUserpools();
                case "OPENID_CONNECT":
                    return getAuthorizationDetailsForOidc();
                case "API_KEY":
                    return getAuthorizationDetailsForApiKey();
                case "AWS_IAM":
                    return getAuthorizationDetailsForIAM(z, tVar);
                case "AWS_LAMBDA":
                    return getAuthorizationDetailsForAwsLambda();
                default:
                    throw new RuntimeException("Invalid AuthMode read from awsconfiguration.json.");
            }
        } catch (JSONException e) {
            throw new RuntimeException("Failed to read AuthMode from awsconfiguration.json", e);
        }
    }

    public JSONObject getConnectionAuthorizationDetails() throws JSONException {
        return getAuthorizationDetails(true, null);
    }
}
