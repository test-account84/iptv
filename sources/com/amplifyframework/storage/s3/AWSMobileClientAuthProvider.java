package com.amplifyframework.storage.s3;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amplifyframework.auth.AuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.storage.StorageException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSMobileClientAuthProvider implements CognitoAuthProvider {
    private static final String AUTH_DEPENDENCY_PLUGIN_KEY = "awsCognitoAuthPlugin";

    private AWSMobileClient getMobileClient() throws StorageException {
        try {
            return (AWSMobileClient) ((AuthPlugin) Amplify.Auth.getPlugin("awsCognitoAuthPlugin")).getEscapeHatch();
        } catch (IllegalStateException e) {
            throw new StorageException("AWSS3StoragePlugin depends on AWSCognitoAuthPlugin but it is currently missing", e, "Before configuring Amplify, be sure to add AWSCognitoAuthPlugin same as you added AWSS3StoragePlugin.");
        }
    }

    public AWSCredentialsProvider getCredentialsProvider() throws StorageException {
        return getMobileClient();
    }

    public String getIdentityId() throws StorageException {
        try {
            return getMobileClient().getIdentityId();
        } catch (RuntimeException e) {
            throw new StorageException("Failed to get user's identity ID", e, "Please check that you are logged in and that Auth is setup to support identity pools.");
        }
    }
}
