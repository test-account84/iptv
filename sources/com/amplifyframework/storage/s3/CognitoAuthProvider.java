package com.amplifyframework.storage.s3;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amplifyframework.storage.StorageException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface CognitoAuthProvider {
    AWSCredentialsProvider getCredentialsProvider() throws StorageException;

    String getIdentityId() throws StorageException;
}
