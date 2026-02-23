package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class UploadTask implements Callable {
    private static final String OBJECT_TAGS_DELIMITER = "&";
    private static final String OBJECT_TAG_KEY_VALUE_SEPARATOR = "=";
    private static final String REQUESTER_PAYS = "requester";
    private final TransferDBUtil dbUtil;
    private List requestList;
    private final AmazonS3 s3;
    private final TransferStatusUpdater updater;
    private final TransferRecord upload;
    Map uploadPartTasks = new HashMap();
    private static final Log LOGGER = LogFactory.getLog(UploadTask.class);
    private static final Map CANNED_ACL_MAP = new HashMap();

    public class UploadPartTaskMetadata {
        long bytesTransferredSoFar;
        TransferState state;
        UploadPartRequest uploadPartRequest;
        Future uploadPartTask;

        public UploadPartTaskMetadata() {
        }
    }

    public class UploadTaskProgressListener implements ProgressListener {
        private final long bytesAlreadyTransferred;
        private long prevTotalBytesTransferredOfAllParts;

        public UploadTaskProgressListener(long j) {
            this.prevTotalBytesTransferredOfAllParts = j;
            this.bytesAlreadyTransferred = j;
        }

        public synchronized void onProgressChanged(int i, long j) {
            UploadPartTaskMetadata uploadPartTaskMetadata = (UploadPartTaskMetadata) UploadTask.this.uploadPartTasks.get(Integer.valueOf(i));
            if (uploadPartTaskMetadata == null) {
                UploadTask.access$000().info("Update received for unknown part. Ignoring.");
                return;
            }
            uploadPartTaskMetadata.bytesTransferredSoFar = j;
            long j2 = this.bytesAlreadyTransferred;
            Iterator it = UploadTask.this.uploadPartTasks.entrySet().iterator();
            while (it.hasNext()) {
                j2 += ((UploadPartTaskMetadata) ((Map.Entry) it.next()).getValue()).bytesTransferredSoFar;
            }
            if (j2 > this.prevTotalBytesTransferredOfAllParts && j2 <= UploadTask.access$100(UploadTask.this).bytesTotal) {
                UploadTask.access$200(UploadTask.this).updateProgress(UploadTask.access$100(UploadTask.this).id, j2, UploadTask.access$100(UploadTask.this).bytesTotal, true);
                this.prevTotalBytesTransferredOfAllParts = j2;
            }
        }

        public void progressChanged(ProgressEvent progressEvent) {
        }
    }

    static {
        for (CannedAccessControlList cannedAccessControlList : CannedAccessControlList.values()) {
            CANNED_ACL_MAP.put(cannedAccessControlList.toString(), cannedAccessControlList);
        }
    }

    public UploadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater) {
        this.upload = transferRecord;
        this.s3 = amazonS3;
        this.dbUtil = transferDBUtil;
        this.updater = transferStatusUpdater;
    }

    private void abortMultiPartUpload(int i, String str, String str2, String str3) {
        Log log = LOGGER;
        log.info("Aborting the multipart since complete multipart failed.");
        try {
            this.s3.abortMultipartUpload(new AbortMultipartUploadRequest(str, str2, str3));
            log.debug("Successfully aborted multipart upload: " + i);
        } catch (AmazonClientException e) {
            LOGGER.debug("Failed to abort the multipart upload: " + i, e);
        }
    }

    public static /* synthetic */ Log access$000() {
        return LOGGER;
    }

    public static /* synthetic */ TransferRecord access$100(UploadTask uploadTask) {
        return uploadTask.upload;
    }

    public static /* synthetic */ TransferStatusUpdater access$200(UploadTask uploadTask) {
        return uploadTask.updater;
    }

    private void completeMultiPartUpload(int i, String str, String str2, String str3) throws AmazonClientException, AmazonServiceException {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, this.dbUtil.queryPartETagsOfUpload(i));
        TransferUtility.appendMultipartTransferServiceUserAgentString(completeMultipartUploadRequest);
        this.s3.completeMultipartUpload(completeMultipartUploadRequest);
    }

    private PutObjectRequest createPutObjectRequest(TransferRecord transferRecord) {
        File file = new File(transferRecord.file);
        PutObjectRequest putObjectRequest = new PutObjectRequest(transferRecord.bucketName, transferRecord.key, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.length());
        String str = transferRecord.headerCacheControl;
        if (str != null) {
            objectMetadata.setCacheControl(str);
        }
        String str2 = transferRecord.headerContentDisposition;
        if (str2 != null) {
            objectMetadata.setContentDisposition(str2);
        }
        String str3 = transferRecord.headerContentEncoding;
        if (str3 != null) {
            objectMetadata.setContentEncoding(str3);
        }
        String str4 = transferRecord.headerContentType;
        if (str4 != null) {
            objectMetadata.setContentType(str4);
        } else {
            objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
        }
        String str5 = transferRecord.headerStorageClass;
        if (str5 != null) {
            putObjectRequest.setStorageClass(str5);
        }
        String str6 = transferRecord.expirationTimeRuleId;
        if (str6 != null) {
            objectMetadata.setExpirationTimeRuleId(str6);
        }
        if (transferRecord.httpExpires != null) {
            objectMetadata.setHttpExpiresDate(new Date(Long.valueOf(transferRecord.httpExpires).longValue()));
        }
        String str7 = transferRecord.sseAlgorithm;
        if (str7 != null) {
            objectMetadata.setSSEAlgorithm(str7);
        }
        Map map = transferRecord.userMetadata;
        if (map != null) {
            objectMetadata.setUserMetadata(map);
            String str8 = (String) transferRecord.userMetadata.get("x-amz-tagging");
            if (str8 != null) {
                try {
                    String[] split = str8.split("&");
                    ArrayList arrayList = new ArrayList();
                    for (String str9 : split) {
                        String[] split2 = str9.split("=");
                        arrayList.add(new Tag(split2[0], split2[1]));
                    }
                    putObjectRequest.setTagging(new ObjectTagging(arrayList));
                } catch (Exception e) {
                    LOGGER.error("Error in passing the object tags as request headers.", e);
                }
            }
            String str10 = (String) transferRecord.userMetadata.get("x-amz-website-redirect-location");
            if (str10 != null) {
                putObjectRequest.setRedirectLocation(str10);
            }
            String str11 = (String) transferRecord.userMetadata.get("x-amz-request-payer");
            if (str11 != null) {
                putObjectRequest.setRequesterPays("requester".equals(str11));
            }
        }
        String str12 = transferRecord.md5;
        if (str12 != null) {
            objectMetadata.setContentMD5(str12);
        }
        String str13 = transferRecord.sseKMSKey;
        if (str13 != null) {
            putObjectRequest.setSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(str13));
        }
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setCannedAcl(getCannedAclFromString(transferRecord.cannedAcl));
        return putObjectRequest;
    }

    private static CannedAccessControlList getCannedAclFromString(String str) {
        if (str == null) {
            return null;
        }
        return (CannedAccessControlList) CANNED_ACL_MAP.get(str);
    }

    private String initiateMultipartUpload(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest withTagging = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata()).withSSEAwsKeyManagementParams(putObjectRequest.getSSEAwsKeyManagementParams()).withTagging(putObjectRequest.getTagging());
        TransferUtility.appendMultipartTransferServiceUserAgentString(withTagging);
        return this.s3.initiateMultipartUpload(withTagging).getUploadId();
    }

    private Boolean uploadMultipartAndWaitForCompletion() throws ExecutionException {
        long j;
        TransferState transferState;
        Log log;
        StringBuilder sb;
        String str = this.upload.multipartId;
        if (str == null || str.isEmpty()) {
            PutObjectRequest createPutObjectRequest = createPutObjectRequest(this.upload);
            TransferUtility.appendMultipartTransferServiceUserAgentString(createPutObjectRequest);
            try {
                this.upload.multipartId = initiateMultipartUpload(createPutObjectRequest);
                TransferDBUtil transferDBUtil = this.dbUtil;
                TransferRecord transferRecord = this.upload;
                transferDBUtil.updateMultipartId(transferRecord.id, transferRecord.multipartId);
                j = 0;
            } catch (AmazonClientException e) {
                e = e;
                LOGGER.error("Error initiating multipart upload: " + this.upload.id + " due to " + e.getMessage(), e);
                this.updater.throwError(this.upload.id, e);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } else {
            long queryBytesTransferredByMainUploadId = this.dbUtil.queryBytesTransferredByMainUploadId(this.upload.id);
            if (queryBytesTransferredByMainUploadId > 0) {
                LOGGER.info(String.format("Resume transfer %d from %d bytes", new Object[]{Integer.valueOf(this.upload.id), Long.valueOf(queryBytesTransferredByMainUploadId)}));
            }
            j = queryBytesTransferredByMainUploadId;
        }
        UploadTaskProgressListener uploadTaskProgressListener = new UploadTaskProgressListener(j);
        TransferStatusUpdater transferStatusUpdater = this.updater;
        TransferRecord transferRecord2 = this.upload;
        transferStatusUpdater.updateProgress(transferRecord2.id, j, transferRecord2.bytesTotal, false);
        TransferDBUtil transferDBUtil2 = this.dbUtil;
        TransferRecord transferRecord3 = this.upload;
        this.requestList = transferDBUtil2.getNonCompletedPartRequestsFromDB(transferRecord3.id, transferRecord3.multipartId);
        LOGGER.info("Multipart upload " + this.upload.id + " in " + this.requestList.size() + " parts.");
        for (UploadPartRequest uploadPartRequest : this.requestList) {
            TransferUtility.appendMultipartTransferServiceUserAgentString(uploadPartRequest);
            UploadPartTaskMetadata uploadPartTaskMetadata = new UploadPartTaskMetadata();
            uploadPartTaskMetadata.uploadPartRequest = uploadPartRequest;
            uploadPartTaskMetadata.bytesTransferredSoFar = 0L;
            uploadPartTaskMetadata.state = TransferState.WAITING;
            this.uploadPartTasks.put(Integer.valueOf(uploadPartRequest.getPartNumber()), uploadPartTaskMetadata);
            uploadPartTaskMetadata.uploadPartTask = TransferThreadPool.submitTask(new UploadPartTask(uploadPartTaskMetadata, uploadTaskProgressListener, uploadPartRequest, this.s3, this.dbUtil));
        }
        try {
            Iterator it = this.uploadPartTasks.values().iterator();
            boolean z = true;
            while (it.hasNext()) {
                z &= ((Boolean) ((UploadPartTaskMetadata) it.next()).uploadPartTask.get()).booleanValue();
            }
            if (!z) {
                try {
                    if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                        LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e2) {
                    LOGGER.error("TransferUtilityException: [" + e2 + "]");
                }
            }
            LOGGER.info("Completing the multi-part upload transfer for " + this.upload.id);
            try {
                TransferRecord transferRecord4 = this.upload;
                completeMultiPartUpload(transferRecord4.id, transferRecord4.bucketName, transferRecord4.key, transferRecord4.multipartId);
                TransferStatusUpdater transferStatusUpdater2 = this.updater;
                TransferRecord transferRecord5 = this.upload;
                int i = transferRecord5.id;
                long j2 = transferRecord5.bytesTotal;
                transferStatusUpdater2.updateProgress(i, j2, j2, true);
                this.updater.updateState(this.upload.id, TransferState.COMPLETED);
                return Boolean.TRUE;
            } catch (AmazonClientException e3) {
                e = e3;
                LOGGER.error("Failed to complete multipart: " + this.upload.id + " due to " + e.getMessage(), e);
                TransferRecord transferRecord6 = this.upload;
                abortMultiPartUpload(transferRecord6.id, transferRecord6.bucketName, transferRecord6.key, transferRecord6.multipartId);
                this.updater.throwError(this.upload.id, e);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } catch (Exception e4) {
            LOGGER.error("Upload resulted in an exception. " + e4);
            Iterator it2 = this.uploadPartTasks.values().iterator();
            while (it2.hasNext()) {
                ((UploadPartTaskMetadata) it2.next()).uploadPartTask.cancel(true);
            }
            if (TransferState.PENDING_CANCEL.equals(this.upload.state)) {
                TransferStatusUpdater transferStatusUpdater3 = this.updater;
                int i2 = this.upload.id;
                transferState = TransferState.CANCELED;
                transferStatusUpdater3.updateState(i2, transferState);
                log = LOGGER;
                sb = new StringBuilder();
            } else {
                if (!TransferState.PENDING_PAUSE.equals(this.upload.state)) {
                    for (UploadPartTaskMetadata uploadPartTaskMetadata2 : this.uploadPartTasks.values()) {
                        TransferState transferState2 = TransferState.WAITING_FOR_NETWORK;
                        if (transferState2.equals(uploadPartTaskMetadata2.state)) {
                            LOGGER.info("Individual part is WAITING_FOR_NETWORK.");
                            this.updater.updateState(this.upload.id, transferState2);
                            break;
                        }
                    }
                    try {
                        if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                            LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                            this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                            return Boolean.FALSE;
                        }
                    } catch (TransferUtilityException e5) {
                        LOGGER.error("TransferUtilityException: [" + e5 + "]");
                    }
                    if (RetryUtils.isInterrupted(e4)) {
                        LOGGER.info("Transfer is interrupted. " + e4);
                    } else {
                        LOGGER.error("Error encountered during multi-part upload: " + this.upload.id + " due to " + e4.getMessage(), e4);
                        this.updater.throwError(this.upload.id, e4);
                    }
                    this.updater.updateState(this.upload.id, TransferState.FAILED);
                    return Boolean.FALSE;
                }
                TransferStatusUpdater transferStatusUpdater4 = this.updater;
                int i3 = this.upload.id;
                transferState = TransferState.PAUSED;
                transferStatusUpdater4.updateState(i3, transferState);
                log = LOGGER;
                sb = new StringBuilder();
            }
            sb.append("Transfer is ");
            sb.append(transferState);
            log.info(sb.toString());
            return Boolean.FALSE;
        }
    }

    private Boolean uploadSinglePartAndWaitForCompletion() {
        PutObjectRequest createPutObjectRequest = createPutObjectRequest(this.upload);
        ProgressListener newProgressListener = this.updater.newProgressListener(this.upload.id);
        long length = createPutObjectRequest.getFile().length();
        TransferUtility.appendTransferServiceUserAgentString(createPutObjectRequest);
        createPutObjectRequest.setGeneralProgressListener(newProgressListener);
        try {
            this.s3.putObject(createPutObjectRequest);
            this.updater.updateProgress(this.upload.id, length, length, true);
            this.updater.updateState(this.upload.id, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e) {
            if (TransferState.PENDING_CANCEL.equals(this.upload.state)) {
                TransferStatusUpdater transferStatusUpdater = this.updater;
                int i = this.upload.id;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.updateState(i, transferState);
                LOGGER.info("Transfer is " + transferState);
            } else if (TransferState.PENDING_PAUSE.equals(this.upload.state)) {
                TransferStatusUpdater transferStatusUpdater2 = this.updater;
                int i2 = this.upload.id;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.updateState(i2, transferState2);
                LOGGER.info("Transfer is " + transferState2);
                new ProgressEvent(0L).setEventCode(32);
                newProgressListener.progressChanged(new ProgressEvent(0L));
            } else {
                try {
                    if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                        Log log = LOGGER;
                        log.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                        this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                        log.debug("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                        new ProgressEvent(0L).setEventCode(32);
                        newProgressListener.progressChanged(new ProgressEvent(0L));
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e2) {
                    LOGGER.error("TransferUtilityException: [" + e2 + "]");
                }
                if (RetryUtils.isInterrupted(e)) {
                    LOGGER.info("Transfer is interrupted. " + e);
                } else {
                    LOGGER.debug("Failed to upload: " + this.upload.id + " due to " + e.getMessage());
                    this.updater.throwError(this.upload.id, e);
                }
                this.updater.updateState(this.upload.id, TransferState.FAILED);
            }
            return Boolean.FALSE;
        }
    }

    public Boolean call() throws Exception {
        try {
            if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e) {
            LOGGER.error("TransferUtilityException: [" + e + "]");
        }
        this.updater.updateState(this.upload.id, TransferState.IN_PROGRESS);
        TransferRecord transferRecord = this.upload;
        int i = transferRecord.isMultipart;
        return (i == 1 && transferRecord.partNumber == 0) ? uploadMultipartAndWaitForCompletion() : i == 0 ? uploadSinglePartAndWaitForCompletion() : Boolean.FALSE;
    }
}
