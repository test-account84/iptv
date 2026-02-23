package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.json.JsonUtils;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class TransferDBUtil {
    private static final String QUERY_PLACE_HOLDER_STRING = ",?";
    private static TransferDBBase transferDBBase;
    private Gson gson = new Gson();
    private static final Log LOGGER = LogFactory.getLog(TransferDBUtil.class);
    private static final Object LOCK = new Object();

    public TransferDBUtil(Context context) {
        synchronized (LOCK) {
            try {
                if (transferDBBase == null) {
                    transferDBBase = new TransferDBBase(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private String createPlaceholders(int i) {
        if (i <= 0) {
            LOGGER.error("Cannot create a string of 0 or less placeholders.");
            return null;
        }
        StringBuilder sb = new StringBuilder((i * 2) - 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    private ContentValues generateContentValuesForObjectMetadata(ObjectMetadata objectMetadata) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_metadata", JsonUtils.mapToString(objectMetadata.getUserMetadata()));
        contentValues.put("header_content_type", objectMetadata.getContentType());
        contentValues.put("header_content_encoding", objectMetadata.getContentEncoding());
        contentValues.put("header_cache_control", objectMetadata.getCacheControl());
        contentValues.put("content_md5", objectMetadata.getContentMD5());
        contentValues.put("header_content_disposition", objectMetadata.getContentDisposition());
        contentValues.put("sse_algorithm", objectMetadata.getSSEAlgorithm());
        contentValues.put("kms_key", objectMetadata.getSSEAwsKmsKeyId());
        contentValues.put("expiration_time_rule_id", objectMetadata.getExpirationTimeRuleId());
        if (objectMetadata.getHttpExpiresDate() != null) {
            contentValues.put("http_expires_date", String.valueOf(objectMetadata.getHttpExpiresDate().getTime()));
        }
        if (objectMetadata.getStorageClass() != null) {
            contentValues.put("header_storage_class", objectMetadata.getStorageClass());
        }
        return contentValues;
    }

    private ContentValues generateContentValuesForSinglePartTransfer(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", transferType.toString());
        contentValues.put("state", TransferState.WAITING.toString());
        contentValues.put("bucket_name", str);
        contentValues.put("key", str2);
        contentValues.put("file", file.getAbsolutePath());
        contentValues.put("bytes_current", 0L);
        if (transferType.equals(TransferType.UPLOAD)) {
            contentValues.put("bytes_total", Long.valueOf(file.length()));
        }
        contentValues.put("is_multipart", 0);
        contentValues.put("part_num", 0);
        contentValues.put("is_encrypted", 0);
        contentValues.putAll(generateContentValuesForObjectMetadata(objectMetadata));
        if (cannedAccessControlList != null) {
            contentValues.put("canned_acl", cannedAccessControlList.toString());
        }
        if (transferUtilityOptions != null) {
            contentValues.put("transfer_utility_options", this.gson.toJson(transferUtilityOptions));
        }
        return contentValues;
    }

    public static TransferDBBase getTransferDBBase(Context context) {
        TransferDBBase transferDBBase2;
        synchronized (LOCK) {
            try {
                if (transferDBBase == null) {
                    transferDBBase = new TransferDBBase(context);
                }
                transferDBBase2 = transferDBBase;
            } catch (Throwable th) {
                throw th;
            }
        }
        return transferDBBase2;
    }

    public int bulkInsertTransferRecords(ContentValues[] contentValuesArr) {
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.bulkInsert(transferDBBase2.getContentUri(), contentValuesArr);
    }

    public int cancelAllWithType(TransferType transferType) {
        String str;
        String[] strArr;
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.PENDING_CANCEL.toString());
        if (transferType == TransferType.ANY) {
            strArr = new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString(), TransferState.PAUSED.toString(), TransferState.WAITING_FOR_NETWORK.toString()};
            str = "state in (?,?,?,?,?)";
        } else {
            str = "state in (?,?,?,?,?) and type=?";
            strArr = new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString(), TransferState.PAUSED.toString(), TransferState.WAITING_FOR_NETWORK.toString(), transferType.toString()};
        }
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, str, strArr);
    }

    public boolean checkWaitingForNetworkPartRequestsFromDB(int i) {
        Cursor cursor = null;
        try {
            cursor = transferDBBase.query(getPartUri(i), null, "state=?", new String[]{TransferState.WAITING_FOR_NETWORK.toString()}, null);
            boolean moveToNext = cursor.moveToNext();
            cursor.close();
            return moveToNext;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void closeDB() {
        synchronized (LOCK) {
            try {
                TransferDBBase transferDBBase2 = transferDBBase;
                if (transferDBBase2 != null) {
                    transferDBBase2.closeDBHelper();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int deleteTransferRecords(int i) {
        return transferDBBase.delete(getRecordUri(i), null, null);
    }

    public ContentValues generateContentValuesForMultiPartUpload(String str, String str2, File file, long j, int i, String str3, long j2, int i2, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", TransferType.UPLOAD.toString());
        contentValues.put("state", TransferState.WAITING.toString());
        contentValues.put("bucket_name", str);
        contentValues.put("key", str2);
        contentValues.put("file", file.getAbsolutePath());
        contentValues.put("bytes_current", 0L);
        contentValues.put("bytes_total", Long.valueOf(j2));
        contentValues.put("is_multipart", 1);
        contentValues.put("part_num", Integer.valueOf(i));
        contentValues.put("file_offset", Long.valueOf(j));
        contentValues.put("multipart_id", str3);
        contentValues.put("is_last_part", Integer.valueOf(i2));
        contentValues.put("is_encrypted", 0);
        contentValues.putAll(generateContentValuesForObjectMetadata(objectMetadata));
        if (cannedAccessControlList != null) {
            contentValues.put("canned_acl", cannedAccessControlList.toString());
        }
        if (transferUtilityOptions != null) {
            contentValues.put("transfer_utility_options", this.gson.toJson(transferUtilityOptions));
        }
        return contentValues;
    }

    public Uri getContentUri() {
        return transferDBBase.getContentUri();
    }

    public List getNonCompletedPartRequestsFromDB(int i, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = transferDBBase.query(getPartUri(i), null, null, null, null);
            while (cursor.moveToNext()) {
                if (!TransferState.PART_COMPLETED.equals(TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state"))))) {
                    UploadPartRequest withPartSize = new UploadPartRequest().withId(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))).withMainUploadId(cursor.getInt(cursor.getColumnIndexOrThrow("main_upload_id"))).withBucketName(cursor.getString(cursor.getColumnIndexOrThrow("bucket_name"))).withKey(cursor.getString(cursor.getColumnIndexOrThrow("key"))).withUploadId(str).withFile(new File(cursor.getString(cursor.getColumnIndexOrThrow("file")))).withFileOffset(cursor.getLong(cursor.getColumnIndexOrThrow("file_offset"))).withPartNumber(cursor.getInt(cursor.getColumnIndexOrThrow("part_num"))).withPartSize(cursor.getLong(cursor.getColumnIndexOrThrow("bytes_total")));
                    boolean z = true;
                    if (1 != cursor.getInt(cursor.getColumnIndexOrThrow("is_last_part"))) {
                        z = false;
                    }
                    arrayList.add(withPartSize.withLastPart(z));
                }
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public Uri getPartUri(int i) {
        return Uri.parse(transferDBBase.getContentUri() + "/part/" + i);
    }

    public Uri getRecordUri(int i) {
        return Uri.parse(transferDBBase.getContentUri() + "/" + i);
    }

    public Uri getStateUri(TransferState transferState) {
        return Uri.parse(transferDBBase.getContentUri() + "/state/" + transferState.toString());
    }

    public TransferRecord getTransferById(int i) {
        TransferRecord transferRecord = null;
        try {
            TransferRecord queryTransferById = queryTransferById(i);
            try {
                if (queryTransferById.moveToFirst()) {
                    transferRecord = new TransferRecord(i);
                    transferRecord.updateFromDB(queryTransferById);
                }
                queryTransferById.close();
                return transferRecord;
            } catch (Throwable th) {
                th = th;
                transferRecord = queryTransferById;
                if (transferRecord != null) {
                    transferRecord.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Uri insertMultipartUploadRecord(String str, String str2, File file, long j, int i, String str3, long j2, int i2, TransferUtilityOptions transferUtilityOptions) {
        ContentValues generateContentValuesForMultiPartUpload = generateContentValuesForMultiPartUpload(str, str2, file, j, i, str3, j2, i2, new ObjectMetadata(), null, transferUtilityOptions);
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.insert(transferDBBase2.getContentUri(), generateContentValuesForMultiPartUpload);
    }

    public Uri insertSingleTransferRecord(TransferType transferType, String str, String str2, File file, TransferUtilityOptions transferUtilityOptions) {
        return insertSingleTransferRecord(transferType, str, str2, file, new ObjectMetadata(), transferUtilityOptions);
    }

    public int pauseAllWithType(TransferType transferType) {
        String str;
        String[] strArr;
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.PENDING_PAUSE.toString());
        if (transferType == TransferType.ANY) {
            strArr = new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString()};
            str = "state in (?,?,?)";
        } else {
            str = "state in (?,?,?) and type=?";
            strArr = new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString(), transferType.toString()};
        }
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, str, strArr);
    }

    public Cursor queryAllTransfersWithType(TransferType transferType) {
        if (transferType == TransferType.ANY) {
            TransferDBBase transferDBBase2 = transferDBBase;
            return transferDBBase2.query(transferDBBase2.getContentUri(), null, null, null, null);
        }
        TransferDBBase transferDBBase3 = transferDBBase;
        return transferDBBase3.query(transferDBBase3.getContentUri(), null, "type=?", new String[]{transferType.toString()}, null);
    }

    public long queryBytesTransferredByMainUploadId(int i) {
        Cursor cursor = null;
        try {
            cursor = transferDBBase.query(getPartUri(i), null, null, null, null);
            long j = 0;
            while (cursor.moveToNext()) {
                if (TransferState.PART_COMPLETED.equals(TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state"))))) {
                    j += cursor.getLong(cursor.getColumnIndexOrThrow("bytes_total"));
                }
            }
            cursor.close();
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        r8 = r0.getLong(r0.getColumnIndexOrThrow("bytes_current"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long queryBytesTransferredOfPartNum(int r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            com.amazonaws.mobileconnectors.s3.transferutility.TransferDBBase r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil.transferDBBase     // Catch: java.lang.Throwable -> L42
            android.net.Uri r2 = r7.getPartUri(r8)     // Catch: java.lang.Throwable -> L42
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L42
        Lf:
            boolean r8 = r0.moveToNext()     // Catch: java.lang.Throwable -> L42
            if (r8 == 0) goto L44
            java.lang.String r8 = "part_num"
            int r8 = r0.getColumnIndexOrThrow(r8)     // Catch: java.lang.Throwable -> L42
            int r8 = r0.getInt(r8)     // Catch: java.lang.Throwable -> L42
            java.lang.String r1 = "state"
            int r1 = r0.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L42
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L42
            if (r8 != r9) goto Lf
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r8 = com.amazonaws.mobileconnectors.s3.transferutility.TransferState.PART_COMPLETED     // Catch: java.lang.Throwable -> L42
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferState.getState(r1)     // Catch: java.lang.Throwable -> L42
            boolean r8 = r8.equals(r1)     // Catch: java.lang.Throwable -> L42
            if (r8 != 0) goto Lf
            java.lang.String r8 = "bytes_current"
            int r8 = r0.getColumnIndexOrThrow(r8)     // Catch: java.lang.Throwable -> L42
            long r8 = r0.getLong(r8)     // Catch: java.lang.Throwable -> L42
            goto L46
        L42:
            r8 = move-exception
            goto L4a
        L44:
            r8 = 0
        L46:
            r0.close()
            return r8
        L4a:
            if (r0 == 0) goto L4f
            r0.close()
        L4f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil.queryBytesTransferredOfPartNum(int, int):long");
    }

    public List queryPartETagsOfUpload(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = transferDBBase.query(getPartUri(i), null, null, null, null);
            while (cursor.moveToNext()) {
                arrayList.add(new PartETag(cursor.getInt(cursor.getColumnIndexOrThrow("part_num")), cursor.getString(cursor.getColumnIndexOrThrow("etag"))));
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public Cursor queryTransferById(int i) {
        return transferDBBase.query(getRecordUri(i), null, null, null, null);
    }

    public Cursor queryTransfersWithTypeAndState(TransferType transferType, TransferState transferState) {
        return transferType == TransferType.ANY ? transferDBBase.query(getStateUri(transferState), null, null, null, null) : transferDBBase.query(getStateUri(transferState), null, "type=?", new String[]{transferType.toString()}, null);
    }

    public Cursor queryTransfersWithTypeAndStates(TransferType transferType, TransferState[] transferStateArr) {
        String str;
        String[] strArr;
        int length = transferStateArr.length;
        String createPlaceholders = createPlaceholders(length);
        int i = 0;
        if (transferType == TransferType.ANY) {
            String str2 = "state in (" + createPlaceholders + ")";
            String[] strArr2 = new String[length];
            while (i < length) {
                strArr2[i] = transferStateArr[i].toString();
                i++;
            }
            str = str2;
            strArr = strArr2;
        } else {
            String str3 = "state in (" + createPlaceholders + ") and type=?";
            String[] strArr3 = new String[length + 1];
            while (i < length) {
                strArr3[i] = transferStateArr[i].toString();
                i++;
            }
            strArr3[i] = transferType.toString();
            str = str3;
            strArr = strArr3;
        }
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.query(transferDBBase2.getContentUri(), null, str, strArr, null);
    }

    public int setAllRunningRecordsToPausedBeforeShutdownService() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.PAUSED.toString());
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, "state in (?,?,?,?)", new String[]{TransferState.IN_PROGRESS.toString(), TransferState.PENDING_PAUSE.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString()});
    }

    public int updateBytesTotalForDownload(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bytes_total", Long.valueOf(j));
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateBytesTransferred(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bytes_current", Long.valueOf(j));
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateETag(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("etag", str);
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateMultipartId(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("multipart_id", str);
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateNetworkConnected() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.RESUMED_WAITING.toString());
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, "state in (?,?)", new String[]{TransferState.PENDING_NETWORK_DISCONNECT.toString(), TransferState.WAITING_FOR_NETWORK.toString()});
    }

    public int updateNetworkDisconnected() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.PENDING_NETWORK_DISCONNECT.toString());
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, "state in (?,?,?)", new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString()});
    }

    public int updateState(int i, TransferState transferState) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", transferState.toString());
        return TransferState.FAILED.equals(transferState) ? transferDBBase.update(getRecordUri(i), contentValues, "state not in (?,?,?,?,?) ", new String[]{TransferState.COMPLETED.toString(), TransferState.PENDING_NETWORK_DISCONNECT.toString(), TransferState.PAUSED.toString(), TransferState.CANCELED.toString(), TransferState.WAITING_FOR_NETWORK.toString()}) : transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateStateAndNotifyUpdate(int i, TransferState transferState) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", transferState.toString());
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, "_id=" + i, null);
    }

    public int updateTransferRecord(TransferRecord transferRecord) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(transferRecord.id));
        contentValues.put("state", transferRecord.state.toString());
        contentValues.put("bytes_total", Long.valueOf(transferRecord.bytesTotal));
        contentValues.put("bytes_current", Long.valueOf(transferRecord.bytesCurrent));
        return transferDBBase.update(getRecordUri(transferRecord.id), contentValues, null, null);
    }

    public Uri insertSingleTransferRecord(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, TransferUtilityOptions transferUtilityOptions) {
        return insertSingleTransferRecord(transferType, str, str2, file, objectMetadata, null, transferUtilityOptions);
    }

    public Uri insertSingleTransferRecord(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues generateContentValuesForSinglePartTransfer = generateContentValuesForSinglePartTransfer(transferType, str, str2, file, objectMetadata, cannedAccessControlList, transferUtilityOptions);
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.insert(transferDBBase2.getContentUri(), generateContentValuesForSinglePartTransfer);
    }
}
