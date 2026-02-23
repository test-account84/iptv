package com.amazonaws.mobileconnectors.appsync.sigv4;

import android.util.Log;
import com.amazonaws.DefaultRequest;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.mobileconnectors.appsync.utils.StringUtils;
import com.amazonaws.util.VersionInfoUtils;
import java.io.IOException;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppSyncSigV4SignerInterceptor implements Interceptor {
    private static final String AUTHORIZATION = "authorization";
    private static final String CONTENT_TYPE = "application/json";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");
    private static final String SERVICE_NAME = "appsync";
    private static final String TAG = "AppSyncSigV4SignerInterceptor";
    private static final String X_AMZ_SUBSCRIBER_ID = "x-amz-subscriber-id";
    private static final String X_API_KEY = "x-api-key";
    private final APIKeyAuthProvider apiKey;
    private final AuthMode authMode;
    private final AWSLambdaAuthProvider awsLambdaAuthProvider;
    private final String awsRegion;
    private final CognitoUserPoolsAuthProvider cognitoUserPoolsAuthProvider;
    private final AWSCredentialsProvider credentialsProvider;
    private final OidcAuthProvider oidcAuthProvider;
    private final String subscriberUUID;

    public enum AuthMode {
        API_KEY,
        IAM,
        OIDC_AUTHORIZATION_TOKEN,
        USERPOOLS_AUTHORIZATION_TOKEN,
        AWS_LAMBDA_AUTHORIZATION_TOKEN
    }

    public AppSyncSigV4SignerInterceptor(AWSCredentialsProvider aWSCredentialsProvider, String str) {
        this.credentialsProvider = aWSCredentialsProvider;
        this.awsRegion = str;
        this.apiKey = null;
        this.cognitoUserPoolsAuthProvider = null;
        this.oidcAuthProvider = null;
        this.awsLambdaAuthProvider = null;
        this.authMode = AuthMode.IAM;
        this.subscriberUUID = null;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Log.d(TAG, "Signer Interceptor called");
        Request request = chain.request();
        DefaultRequest defaultRequest = new DefaultRequest("appsync");
        defaultRequest.setEndpoint(request.url().uri());
        for (String str : request.headers().names()) {
            defaultRequest.addHeader(str, request.header(str));
        }
        defaultRequest.setHttpMethod(HttpMethodName.valueOf(request.method()));
        defaultRequest.addHeader("User-Agent", StringUtils.toHumanReadableAscii(VersionInfoUtils.getUserAgent()));
        Buffer buffer = new Buffer();
        request.body().writeTo(buffer);
        defaultRequest.setContent(buffer.inputStream());
        Buffer clone = buffer.clone();
        if (AuthMode.IAM.equals(this.authMode)) {
            try {
                new AppSyncV4Signer(this.awsRegion).sign(defaultRequest, this.credentialsProvider.getCredentials());
            } catch (Exception e) {
                throw new IOException("Failed to read credentials to sign the request.", e);
            }
        } else if (AuthMode.API_KEY.equals(this.authMode)) {
            defaultRequest.addHeader("x-api-key", this.apiKey.getAPIKey());
            if (this.subscriberUUID != null) {
                Log.d(TAG, "Subscriber ID is " + this.subscriberUUID);
                defaultRequest.addHeader("x-amz-subscriber-id", this.subscriberUUID);
            }
        } else if (AuthMode.USERPOOLS_AUTHORIZATION_TOKEN.equals(this.authMode)) {
            try {
                defaultRequest.addHeader("authorization", this.cognitoUserPoolsAuthProvider.getLatestAuthToken());
            } catch (Exception e2) {
                throw new IOException("Failed to retrieve Cognito User Pools token.", e2);
            }
        } else if (AuthMode.OIDC_AUTHORIZATION_TOKEN.equals(this.authMode)) {
            try {
                defaultRequest.addHeader("authorization", this.oidcAuthProvider.getLatestAuthToken());
            } catch (Exception e3) {
                throw new IOException("Failed to retrieve OIDC token.", e3);
            }
        } else if (AuthMode.AWS_LAMBDA_AUTHORIZATION_TOKEN.equals(this.authMode)) {
            try {
                defaultRequest.addHeader("authorization", this.awsLambdaAuthProvider.getLatestAuthToken());
            } catch (Exception e4) {
                throw new IOException("Failed to retrieve AWS Lambda authorization token.", e4);
            }
        }
        Request.Builder builder = new Request.Builder();
        for (Map.Entry entry : defaultRequest.getHeaders().entrySet()) {
            builder.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        builder.url(request.url());
        builder.method(request.method(), RequestBody.create(JSON_MEDIA_TYPE, clone.readByteArray()));
        return chain.proceed(builder.build());
    }

    public AppSyncSigV4SignerInterceptor(APIKeyAuthProvider aPIKeyAuthProvider, String str, String str2) {
        this.apiKey = aPIKeyAuthProvider;
        this.awsRegion = str;
        this.credentialsProvider = null;
        this.cognitoUserPoolsAuthProvider = null;
        this.oidcAuthProvider = null;
        this.awsLambdaAuthProvider = null;
        this.authMode = AuthMode.API_KEY;
        this.subscriberUUID = str2;
    }

    public AppSyncSigV4SignerInterceptor(AWSLambdaAuthProvider aWSLambdaAuthProvider) {
        this.credentialsProvider = null;
        this.awsRegion = null;
        this.apiKey = null;
        this.cognitoUserPoolsAuthProvider = null;
        this.oidcAuthProvider = null;
        this.awsLambdaAuthProvider = aWSLambdaAuthProvider;
        this.authMode = AuthMode.AWS_LAMBDA_AUTHORIZATION_TOKEN;
        this.subscriberUUID = null;
    }

    public AppSyncSigV4SignerInterceptor(CognitoUserPoolsAuthProvider cognitoUserPoolsAuthProvider, String str) {
        this.credentialsProvider = null;
        this.awsRegion = str;
        this.apiKey = null;
        this.cognitoUserPoolsAuthProvider = cognitoUserPoolsAuthProvider;
        this.oidcAuthProvider = null;
        this.awsLambdaAuthProvider = null;
        this.authMode = AuthMode.USERPOOLS_AUTHORIZATION_TOKEN;
        this.subscriberUUID = null;
    }

    public AppSyncSigV4SignerInterceptor(OidcAuthProvider oidcAuthProvider) {
        this.credentialsProvider = null;
        this.awsRegion = null;
        this.apiKey = null;
        this.cognitoUserPoolsAuthProvider = null;
        this.oidcAuthProvider = oidcAuthProvider;
        this.awsLambdaAuthProvider = null;
        this.authMode = AuthMode.OIDC_AUTHORIZATION_TOKEN;
        this.subscriberUUID = null;
    }
}
