package com.amazonaws.services.s3;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.PartCreationEvent;
import com.amazonaws.services.s3.internal.S3DirectSpi;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UploadObjectObserver {
    private ExecutorService es;
    private final List futures = new ArrayList();
    private UploadObjectRequest req;
    private AmazonS3 s3;
    private S3DirectSpi s3direct;
    private String uploadId;

    public class 1 implements Callable {
        final /* synthetic */ OnFileDelete val$fileDeleteObserver;
        final /* synthetic */ File val$part;
        final /* synthetic */ UploadPartRequest val$reqUploadPart;

        public 1(UploadPartRequest uploadPartRequest, File file, OnFileDelete onFileDelete) {
            this.val$reqUploadPart = uploadPartRequest;
            this.val$part = file;
            this.val$fileDeleteObserver = onFileDelete;
        }

        public UploadPartResult call() {
            try {
                UploadPartResult uploadPart = UploadObjectObserver.this.uploadPart(this.val$reqUploadPart);
                if (this.val$part.delete()) {
                    OnFileDelete onFileDelete = this.val$fileDeleteObserver;
                    if (onFileDelete != null) {
                        onFileDelete.onFileDelete(null);
                    }
                } else {
                    LogFactory.getLog(getClass()).debug("Ignoring failure to delete file " + this.val$part + " which has already been uploaded");
                }
                return uploadPart;
            } catch (Throwable th) {
                if (this.val$part.delete()) {
                    OnFileDelete onFileDelete2 = this.val$fileDeleteObserver;
                    if (onFileDelete2 != null) {
                        onFileDelete2.onFileDelete(null);
                    }
                } else {
                    LogFactory.getLog(getClass()).debug("Ignoring failure to delete file " + this.val$part + " which has already been uploaded");
                }
                throw th;
            }
        }
    }

    public AmazonWebServiceRequest appendUserAgent(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        amazonWebServiceRequest.getRequestClientOptions().appendUserAgent(str);
        return amazonWebServiceRequest;
    }

    public AmazonS3 getAmazonS3() {
        return this.s3;
    }

    public ExecutorService getExecutorService() {
        return this.es;
    }

    public List getFutures() {
        return this.futures;
    }

    public UploadObjectRequest getRequest() {
        return this.req;
    }

    public S3DirectSpi getS3DirectSpi() {
        return this.s3direct;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public UploadObjectObserver init(UploadObjectRequest uploadObjectRequest, S3DirectSpi s3DirectSpi, AmazonS3 amazonS3, ExecutorService executorService) {
        this.req = uploadObjectRequest;
        this.s3direct = s3DirectSpi;
        this.s3 = amazonS3;
        this.es = executorService;
        return this;
    }

    public InitiateMultipartUploadRequest newInitiateMultipartUploadRequest(UploadObjectRequest uploadObjectRequest) {
        return (InitiateMultipartUploadRequest) new EncryptedInitiateMultipartUploadRequest(uploadObjectRequest.getBucketName(), uploadObjectRequest.getKey(), uploadObjectRequest.getMetadata()).withMaterialsDescription(uploadObjectRequest.getMaterialsDescription()).withRedirectLocation(uploadObjectRequest.getRedirectLocation()).withSSEAwsKeyManagementParams(uploadObjectRequest.getSSEAwsKeyManagementParams()).withSSECustomerKey(uploadObjectRequest.getSSECustomerKey()).withStorageClass(uploadObjectRequest.getStorageClass()).withAccessControlList(uploadObjectRequest.getAccessControlList()).withCannedACL(uploadObjectRequest.getCannedAcl()).withGeneralProgressListener(uploadObjectRequest.getGeneralProgressListener()).withRequestMetricCollector(uploadObjectRequest.getRequestMetricCollector());
    }

    public UploadPartRequest newUploadPartRequest(PartCreationEvent partCreationEvent, File file) {
        return new UploadPartRequest().withBucketName(this.req.getBucketName()).withFile(file).withKey(this.req.getKey()).withPartNumber(partCreationEvent.getPartNumber()).withPartSize(file.length()).withLastPart(partCreationEvent.isLastPart()).withUploadId(this.uploadId).withObjectMetadata(this.req.getUploadPartMetadata());
    }

    public void onAbort() {
        Iterator it = getFutures().iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        if (this.uploadId != null) {
            try {
                this.s3.abortMultipartUpload(new AbortMultipartUploadRequest(this.req.getBucketName(), this.req.getKey(), this.uploadId));
            } catch (Exception e) {
                LogFactory.getLog(getClass()).debug("Failed to abort multi-part upload: " + this.uploadId, e);
            }
        }
    }

    public CompleteMultipartUploadResult onCompletion(List list) {
        return this.s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.req.getBucketName(), this.req.getKey(), this.uploadId, list));
    }

    public void onPartCreate(PartCreationEvent partCreationEvent) {
        File part = partCreationEvent.getPart();
        UploadPartRequest newUploadPartRequest = newUploadPartRequest(partCreationEvent, part);
        OnFileDelete fileDeleteObserver = partCreationEvent.getFileDeleteObserver();
        appendUserAgent(newUploadPartRequest, AmazonS3EncryptionClient.USER_AGENT);
        this.futures.add(this.es.submit(new 1(newUploadPartRequest, part, fileDeleteObserver)));
    }

    public String onUploadInitiation(UploadObjectRequest uploadObjectRequest) {
        String uploadId = this.s3.initiateMultipartUpload(newInitiateMultipartUploadRequest(uploadObjectRequest)).getUploadId();
        this.uploadId = uploadId;
        return uploadId;
    }

    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) {
        return this.s3direct.uploadPart(uploadPartRequest);
    }
}
