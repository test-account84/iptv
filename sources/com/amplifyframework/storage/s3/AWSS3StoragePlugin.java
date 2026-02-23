package com.amplifyframework.storage.s3;

import android.content.Context;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.NoOpConsumer;
import com.amplifyframework.storage.StorageAccessLevel;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.StoragePlugin;
import com.amplifyframework.storage.operation.StorageDownloadFileOperation;
import com.amplifyframework.storage.operation.StorageGetUrlOperation;
import com.amplifyframework.storage.operation.StorageListOperation;
import com.amplifyframework.storage.operation.StorageRemoveOperation;
import com.amplifyframework.storage.operation.StorageUploadFileOperation;
import com.amplifyframework.storage.operation.StorageUploadInputStreamOperation;
import com.amplifyframework.storage.options.StorageDownloadFileOptions;
import com.amplifyframework.storage.options.StorageGetUrlOptions;
import com.amplifyframework.storage.options.StorageListOptions;
import com.amplifyframework.storage.options.StorageRemoveOptions;
import com.amplifyframework.storage.options.StorageUploadFileOptions;
import com.amplifyframework.storage.options.StorageUploadInputStreamOptions;
import com.amplifyframework.storage.s3.configuration.AWSS3StoragePluginConfiguration;
import com.amplifyframework.storage.s3.operation.AWSS3StorageDownloadFileOperation;
import com.amplifyframework.storage.s3.operation.AWSS3StorageGetPresignedUrlOperation;
import com.amplifyframework.storage.s3.operation.AWSS3StorageListOperation;
import com.amplifyframework.storage.s3.operation.AWSS3StorageRemoveOperation;
import com.amplifyframework.storage.s3.operation.AWSS3StorageUploadFileOperation;
import com.amplifyframework.storage.s3.operation.AWSS3StorageUploadInputStreamOperation;
import com.amplifyframework.storage.s3.options.AWSS3StorageUploadFileOptions;
import com.amplifyframework.storage.s3.options.AWSS3StorageUploadInputStreamOptions;
import com.amplifyframework.storage.s3.request.AWSS3StorageDownloadFileRequest;
import com.amplifyframework.storage.s3.request.AWSS3StorageGetPresignedUrlRequest;
import com.amplifyframework.storage.s3.request.AWSS3StorageListRequest;
import com.amplifyframework.storage.s3.request.AWSS3StorageRemoveRequest;
import com.amplifyframework.storage.s3.request.AWSS3StorageUploadRequest;
import com.amplifyframework.storage.s3.service.AWSS3StorageService;
import com.amplifyframework.storage.s3.service.StorageService;
import f1.a;
import f1.b;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StoragePlugin extends StoragePlugin {
    private static final String AWS_S3_STORAGE_PLUGIN_KEY = "awsS3StoragePlugin";
    private final AWSS3StoragePluginConfiguration awsS3StoragePluginConfiguration;
    private final CognitoAuthProvider cognitoAuthProvider;
    private StorageAccessLevel defaultAccessLevel;
    private int defaultUrlExpiration;
    private final ExecutorService executorService;
    private StorageService storageService;
    private final StorageService.Factory storageServiceFactory;

    public enum JsonKeys {
        BUCKET("bucket"),
        REGION("region");

        private final String configurationKey;

        JsonKeys(String str) {
            this.configurationKey = str;
        }

        public String getConfigurationKey() {
            return this.configurationKey;
        }
    }

    public AWSS3StoragePlugin() {
        this(new AWSMobileClientAuthProvider());
    }

    public static /* synthetic */ StorageService a(CognitoAuthProvider cognitoAuthProvider, Context context, Region region, String str) {
        return lambda$new$0(cognitoAuthProvider, context, region, str);
    }

    public static /* synthetic */ StorageService b(CognitoAuthProvider cognitoAuthProvider, Context context, Region region, String str) {
        return lambda$new$1(cognitoAuthProvider, context, region, str);
    }

    private static /* synthetic */ StorageService lambda$new$0(CognitoAuthProvider cognitoAuthProvider, Context context, Region region, String str) {
        return new AWSS3StorageService(context, region, str, cognitoAuthProvider, false);
    }

    private static /* synthetic */ StorageService lambda$new$1(CognitoAuthProvider cognitoAuthProvider, Context context, Region region, String str) {
        return new AWSS3StorageService(context, region, str, cognitoAuthProvider, false);
    }

    public void configure(JSONObject jSONObject, Context context) throws StorageException {
        try {
            Region region = Region.getRegion(jSONObject.getString(JsonKeys.REGION.getConfigurationKey()));
            if (region == null) {
                throw new StorageException("Invalid region provided", "Make sure the region you have configured for the AWS S3 Storage plugin is a value we support.");
            }
            try {
                try {
                    this.storageService = this.storageServiceFactory.create(context, region, jSONObject.getString(JsonKeys.BUCKET.getConfigurationKey()));
                    this.defaultAccessLevel = StorageAccessLevel.PUBLIC;
                    this.defaultUrlExpiration = (int) TimeUnit.DAYS.toSeconds(7L);
                } catch (RuntimeException e) {
                    throw new StorageException("Failed to create storage service.", e, "Did you make sure to add AWSCognitoAuthPlugin to Amplify? Check the attached exception for more details.");
                }
            } catch (JSONException e2) {
                throw new StorageException("Missing or malformed value for bucket in awsS3StoragePluginconfiguration.", e2, "Check the attached error to see where the parsing issue took place.");
            }
        } catch (JSONException e3) {
            throw new StorageException("Missing or malformed value for Region in awsS3StoragePluginconfiguration.", e3, "Check the attached error to see where the parsing issue took place.");
        } catch (NullPointerException unused) {
            throw new StorageException("Missing configuration for awsS3StoragePlugin", "Check amplifyconfiguration.json to make sure that there is a section for awsS3StoragePlugin under the storage category.");
        }
    }

    public StorageDownloadFileOperation downloadFile(String str, File file, Consumer consumer, Consumer consumer2) {
        return downloadFile(str, file, StorageDownloadFileOptions.defaultInstance(), NoOpConsumer.create(), consumer, consumer2);
    }

    public AmazonS3Client getEscapeHatch() {
        return ((AWSS3StorageService) this.storageService).getClient();
    }

    public String getPluginKey() {
        return "awsS3StoragePlugin";
    }

    public StorageGetUrlOperation getUrl(String str, Consumer consumer, Consumer consumer2) {
        return getUrl(str, StorageGetUrlOptions.defaultInstance(), consumer, consumer2);
    }

    public String getVersion() {
        return "1.37.10";
    }

    public StorageListOperation list(String str, Consumer consumer, Consumer consumer2) {
        return list(str, StorageListOptions.defaultInstance(), consumer, consumer2);
    }

    public StorageRemoveOperation remove(String str, Consumer consumer, Consumer consumer2) {
        return remove(str, StorageRemoveOptions.defaultInstance(), consumer, consumer2);
    }

    public StorageUploadFileOperation uploadFile(String str, File file, Consumer consumer, Consumer consumer2) {
        return uploadFile(str, file, StorageUploadFileOptions.defaultInstance(), NoOpConsumer.create(), consumer, consumer2);
    }

    public StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, Consumer consumer, Consumer consumer2) {
        return uploadInputStream(str, inputStream, StorageUploadInputStreamOptions.defaultInstance(), NoOpConsumer.create(), consumer, consumer2);
    }

    public AWSS3StoragePlugin(CognitoAuthProvider cognitoAuthProvider) {
        this(new b(cognitoAuthProvider), cognitoAuthProvider, new AWSS3StoragePluginConfiguration.Builder().build());
    }

    public StorageDownloadFileOperation downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, Consumer consumer, Consumer consumer2) {
        return downloadFile(str, file, storageDownloadFileOptions, NoOpConsumer.create(), consumer, consumer2);
    }

    public StorageGetUrlOperation getUrl(String str, StorageGetUrlOptions storageGetUrlOptions, Consumer consumer, Consumer consumer2) {
        AWSS3StorageGetPresignedUrlOperation aWSS3StorageGetPresignedUrlOperation = new AWSS3StorageGetPresignedUrlOperation(this.storageService, this.executorService, this.cognitoAuthProvider, new AWSS3StorageGetPresignedUrlRequest(str, storageGetUrlOptions.getAccessLevel() != null ? storageGetUrlOptions.getAccessLevel() : this.defaultAccessLevel, storageGetUrlOptions.getTargetIdentityId(), storageGetUrlOptions.getExpires() != 0 ? storageGetUrlOptions.getExpires() : this.defaultUrlExpiration), this.awsS3StoragePluginConfiguration, consumer, consumer2);
        aWSS3StorageGetPresignedUrlOperation.start();
        return aWSS3StorageGetPresignedUrlOperation;
    }

    public StorageListOperation list(String str, StorageListOptions storageListOptions, Consumer consumer, Consumer consumer2) {
        AWSS3StorageListOperation aWSS3StorageListOperation = new AWSS3StorageListOperation(this.storageService, this.executorService, this.cognitoAuthProvider, new AWSS3StorageListRequest(str, storageListOptions.getAccessLevel() != null ? storageListOptions.getAccessLevel() : this.defaultAccessLevel, storageListOptions.getTargetIdentityId()), this.awsS3StoragePluginConfiguration, consumer, consumer2);
        aWSS3StorageListOperation.start();
        return aWSS3StorageListOperation;
    }

    public StorageRemoveOperation remove(String str, StorageRemoveOptions storageRemoveOptions, Consumer consumer, Consumer consumer2) {
        AWSS3StorageRemoveOperation aWSS3StorageRemoveOperation = new AWSS3StorageRemoveOperation(this.storageService, this.executorService, this.cognitoAuthProvider, new AWSS3StorageRemoveRequest(str, storageRemoveOptions.getAccessLevel() != null ? storageRemoveOptions.getAccessLevel() : this.defaultAccessLevel, storageRemoveOptions.getTargetIdentityId()), this.awsS3StoragePluginConfiguration, consumer, consumer2);
        aWSS3StorageRemoveOperation.start();
        return aWSS3StorageRemoveOperation;
    }

    public StorageUploadFileOperation uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions, Consumer consumer, Consumer consumer2) {
        return uploadFile(str, file, storageUploadFileOptions, NoOpConsumer.create(), consumer, consumer2);
    }

    public StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, Consumer consumer, Consumer consumer2) {
        return uploadInputStream(str, inputStream, storageUploadInputStreamOptions, NoOpConsumer.create(), consumer, consumer2);
    }

    public AWSS3StoragePlugin(CognitoAuthProvider cognitoAuthProvider, AWSS3StoragePluginConfiguration aWSS3StoragePluginConfiguration) {
        this(new a(cognitoAuthProvider), cognitoAuthProvider, aWSS3StoragePluginConfiguration);
    }

    public StorageDownloadFileOperation downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, Consumer consumer, Consumer consumer2, Consumer consumer3) {
        AWSS3StorageDownloadFileOperation aWSS3StorageDownloadFileOperation = new AWSS3StorageDownloadFileOperation(this.storageService, this.cognitoAuthProvider, new AWSS3StorageDownloadFileRequest(str, file, storageDownloadFileOptions.getAccessLevel() != null ? storageDownloadFileOptions.getAccessLevel() : this.defaultAccessLevel, storageDownloadFileOptions.getTargetIdentityId()), this.awsS3StoragePluginConfiguration, consumer, consumer2, consumer3);
        aWSS3StorageDownloadFileOperation.start();
        return aWSS3StorageDownloadFileOperation;
    }

    public StorageUploadFileOperation uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions, Consumer consumer, Consumer consumer2, Consumer consumer3) {
        AWSS3StorageUploadFileOperation aWSS3StorageUploadFileOperation = new AWSS3StorageUploadFileOperation(this.storageService, this.cognitoAuthProvider, new AWSS3StorageUploadRequest(str, file, storageUploadFileOptions.getAccessLevel() != null ? storageUploadFileOptions.getAccessLevel() : this.defaultAccessLevel, storageUploadFileOptions.getTargetIdentityId(), storageUploadFileOptions.getContentType(), storageUploadFileOptions instanceof AWSS3StorageUploadFileOptions ? ((AWSS3StorageUploadFileOptions) storageUploadFileOptions).getServerSideEncryption() : ServerSideEncryption.NONE, storageUploadFileOptions.getMetadata()), this.awsS3StoragePluginConfiguration, consumer, consumer2, consumer3);
        aWSS3StorageUploadFileOperation.start();
        return aWSS3StorageUploadFileOperation;
    }

    public StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, Consumer consumer, Consumer consumer2, Consumer consumer3) {
        AWSS3StorageUploadInputStreamOperation aWSS3StorageUploadInputStreamOperation = new AWSS3StorageUploadInputStreamOperation(this.storageService, this.cognitoAuthProvider, new AWSS3StorageUploadRequest(str, inputStream, storageUploadInputStreamOptions.getAccessLevel() != null ? storageUploadInputStreamOptions.getAccessLevel() : this.defaultAccessLevel, storageUploadInputStreamOptions.getTargetIdentityId(), storageUploadInputStreamOptions.getContentType(), storageUploadInputStreamOptions instanceof AWSS3StorageUploadInputStreamOptions ? ((AWSS3StorageUploadInputStreamOptions) storageUploadInputStreamOptions).getServerSideEncryption() : ServerSideEncryption.NONE, storageUploadInputStreamOptions.getMetadata()), this.awsS3StoragePluginConfiguration, consumer, consumer2, consumer3);
        aWSS3StorageUploadInputStreamOperation.start();
        return aWSS3StorageUploadInputStreamOperation;
    }

    public AWSS3StoragePlugin(AWSS3StoragePluginConfiguration aWSS3StoragePluginConfiguration) {
        this(new AWSMobileClientAuthProvider(), aWSS3StoragePluginConfiguration);
    }

    public AWSS3StoragePlugin(StorageService.Factory factory, CognitoAuthProvider cognitoAuthProvider, AWSS3StoragePluginConfiguration aWSS3StoragePluginConfiguration) {
        this.storageServiceFactory = factory;
        this.executorService = Executors.newCachedThreadPool();
        this.cognitoAuthProvider = cognitoAuthProvider;
        this.awsS3StoragePluginConfiguration = aWSS3StoragePluginConfiguration;
    }
}
