package com.amplifyframework.storage.s3.service;

import android.content.Context;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.mobileconnectors.s3.transferutility.UploadOptions;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.StorageItem;
import com.amplifyframework.storage.s3.CognitoAuthProvider;
import com.amplifyframework.storage.s3.utils.S3Keys;
import com.amplifyframework.util.UserAgent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageService implements StorageService {
    private final String bucket;
    private final AmazonS3Client client;
    private final CognitoAuthProvider cognitoAuthProvider;
    private final Context context;
    private final TransferUtility transferUtility;

    public AWSS3StorageService(Context context, Region region, String str, CognitoAuthProvider cognitoAuthProvider, boolean z) {
        try {
            this.context = context;
            this.bucket = str;
            this.cognitoAuthProvider = cognitoAuthProvider;
            AmazonS3Client createS3Client = createS3Client(region);
            this.client = createS3Client;
            if (z) {
                createS3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());
            }
            this.transferUtility = TransferUtility.builder().context(context).s3Client(createS3Client).build();
        } catch (StorageException unused) {
            throw new IllegalStateException("AWSS3StoragePlugin depends on AWSCognitoAuthPlugin but it is currently missing.");
        }
    }

    private AmazonS3Client createS3Client(Region region) throws StorageException {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setUserAgent(UserAgent.string());
        return new AmazonS3Client(this.cognitoAuthProvider.getCredentialsProvider(), region, clientConfiguration);
    }

    private void startTransferService() {
        AmplifyTransferService.Companion.bind(this.context);
    }

    public void cancelTransfer(TransferObserver transferObserver) {
        this.transferUtility.cancel(transferObserver.getId());
    }

    public void deleteObject(String str) {
        this.client.deleteObject(this.bucket, str);
    }

    public TransferObserver downloadToFile(String str, File file) {
        startTransferService();
        return this.transferUtility.download(this.bucket, str, file);
    }

    public AmazonS3Client getClient() {
        return this.client;
    }

    public URL getPresignedUrl(String str, int i) {
        return this.client.generatePresignedUrl(this.bucket, str, new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(i)));
    }

    public List listFiles(String str, String str2) {
        ListObjectsV2Result listObjectsV2;
        ArrayList arrayList = new ArrayList();
        ListObjectsV2Request withPrefix = new ListObjectsV2Request().withBucketName(this.bucket).withPrefix(str);
        do {
            listObjectsV2 = this.client.listObjectsV2(withPrefix);
            for (S3ObjectSummary s3ObjectSummary : listObjectsV2.getObjectSummaries()) {
                arrayList.add(new StorageItem(S3Keys.extractAmplifyKey(s3ObjectSummary.getKey(), str2), s3ObjectSummary.getSize(), s3ObjectSummary.getLastModified(), s3ObjectSummary.getETag(), null));
            }
            withPrefix.setContinuationToken(listObjectsV2.getNextContinuationToken());
        } while (listObjectsV2.isTruncated());
        return arrayList;
    }

    public void pauseTransfer(TransferObserver transferObserver) {
        this.transferUtility.pause(transferObserver.getId());
    }

    public void resumeTransfer(TransferObserver transferObserver) {
        startTransferService();
        this.transferUtility.resume(transferObserver.getId());
    }

    public TransferObserver uploadFile(String str, File file, ObjectMetadata objectMetadata) {
        startTransferService();
        return this.transferUtility.upload(this.bucket, str, file, objectMetadata);
    }

    public TransferObserver uploadInputStream(String str, InputStream inputStream, ObjectMetadata objectMetadata) throws IOException {
        startTransferService();
        return this.transferUtility.upload(str, inputStream, UploadOptions.builder().bucket(this.bucket).objectMetadata(objectMetadata).build());
    }
}
