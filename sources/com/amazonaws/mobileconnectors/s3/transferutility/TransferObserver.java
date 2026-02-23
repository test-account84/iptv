package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TransferObserver {
    private String bucket;
    private long bytesTotal;
    private long bytesTransferred;
    private final TransferDBUtil dbUtil;
    private String filePath;
    private final int id;
    private String key;
    private TransferStatusListener statusListener;
    private TransferListener transferListener;
    private TransferState transferState;

    public class TransferStatusListener implements TransferListener {
        public TransferStatusListener() {
        }

        public void onError(int i, Exception exc) {
        }

        public void onProgressChanged(int i, long j, long j2) {
            TransferObserver.access$102(TransferObserver.this, j);
            TransferObserver.access$202(TransferObserver.this, j2);
        }

        public void onStateChanged(int i, TransferState transferState) {
            TransferObserver.access$002(TransferObserver.this, transferState);
        }
    }

    public TransferObserver(int i, TransferDBUtil transferDBUtil) {
        this.id = i;
        this.dbUtil = transferDBUtil;
    }

    public static /* synthetic */ TransferState access$002(TransferObserver transferObserver, TransferState transferState) {
        transferObserver.transferState = transferState;
        return transferState;
    }

    public static /* synthetic */ long access$102(TransferObserver transferObserver, long j) {
        transferObserver.bytesTransferred = j;
        return j;
    }

    public static /* synthetic */ long access$202(TransferObserver transferObserver, long j) {
        transferObserver.bytesTotal = j;
        return j;
    }

    public void cleanTransferListener() {
        synchronized (this) {
            try {
                TransferListener transferListener = this.transferListener;
                if (transferListener != null) {
                    TransferStatusUpdater.unregisterListener(this.id, transferListener);
                    this.transferListener = null;
                }
                TransferStatusListener transferStatusListener = this.statusListener;
                if (transferStatusListener != null) {
                    TransferStatusUpdater.unregisterListener(this.id, transferStatusListener);
                    this.statusListener = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getAbsoluteFilePath() {
        return this.filePath;
    }

    public String getBucket() {
        return this.bucket;
    }

    public long getBytesTotal() {
        return this.bytesTotal;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public int getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public TransferState getState() {
        return this.transferState;
    }

    public void refresh() {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryTransferById(this.id);
            if (cursor.moveToFirst()) {
                updateFromDB(cursor);
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void setTransferListener(TransferListener transferListener) {
        synchronized (this) {
            try {
                cleanTransferListener();
                if (this.statusListener == null) {
                    TransferStatusListener transferStatusListener = new TransferStatusListener();
                    this.statusListener = transferStatusListener;
                    TransferStatusUpdater.registerListener(this.id, transferStatusListener);
                }
                if (transferListener != null) {
                    this.transferListener = transferListener;
                    transferListener.onStateChanged(this.id, this.transferState);
                    TransferStatusUpdater.registerListener(this.id, this.transferListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "TransferObserver{id=" + this.id + ", bucket='" + this.bucket + "', key='" + this.key + "', bytesTotal=" + this.bytesTotal + ", bytesTransferred=" + this.bytesTransferred + ", transferState=" + this.transferState + ", filePath='" + this.filePath + "'}";
    }

    public void updateFromDB(Cursor cursor) {
        this.bucket = cursor.getString(cursor.getColumnIndexOrThrow("bucket_name"));
        this.key = cursor.getString(cursor.getColumnIndexOrThrow("key"));
        this.bytesTotal = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_total"));
        this.bytesTransferred = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_current"));
        this.transferState = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
        this.filePath = cursor.getString(cursor.getColumnIndexOrThrow("file"));
    }

    public TransferObserver(int i, TransferDBUtil transferDBUtil, String str, String str2, File file) {
        this.id = i;
        this.dbUtil = transferDBUtil;
        this.bucket = str;
        this.key = str2;
        this.filePath = file.getAbsolutePath();
        this.bytesTotal = file.length();
        this.transferState = TransferState.WAITING;
    }

    public TransferObserver(int i, TransferDBUtil transferDBUtil, String str, String str2, File file, TransferListener transferListener) {
        this(i, transferDBUtil, str, str2, file);
        setTransferListener(transferListener);
    }
}
