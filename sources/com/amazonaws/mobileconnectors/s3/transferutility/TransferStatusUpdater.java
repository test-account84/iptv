package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class TransferStatusUpdater {
    static final String TEMP_FILE_PREFIX = "aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002";
    private static TransferDBUtil dbUtil;
    private static TransferStatusUpdater transferStatusUpdater;
    private Context context;
    private final Handler mainHandler;
    private final Map transfers;
    private static final Log LOGGER = LogFactory.getLog(TransferStatusUpdater.class);
    private static final HashSet STATES_NOT_TO_NOTIFY = new HashSet(Arrays.asList(new TransferState[]{TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT}));
    static final Map LISTENERS = new 1();

    public static class 1 extends ConcurrentHashMap {
    }

    public class 2 implements Runnable {
        final /* synthetic */ int val$id;
        final /* synthetic */ TransferListener val$l;
        final /* synthetic */ TransferState val$newState;

        public 2(TransferListener transferListener, int i, TransferState transferState) {
            this.val$l = transferListener;
            this.val$id = i;
            this.val$newState = transferState;
        }

        public void run() {
            this.val$l.onStateChanged(this.val$id, this.val$newState);
        }
    }

    public class 3 implements Runnable {
        final /* synthetic */ long val$bytesCurrent;
        final /* synthetic */ long val$bytesTotal;
        final /* synthetic */ int val$id;
        final /* synthetic */ TransferListener val$l;

        public 3(TransferListener transferListener, int i, long j, long j2) {
            this.val$l = transferListener;
            this.val$id = i;
            this.val$bytesCurrent = j;
            this.val$bytesTotal = j2;
        }

        public void run() {
            this.val$l.onProgressChanged(this.val$id, this.val$bytesCurrent, this.val$bytesTotal);
        }
    }

    public class 4 implements Runnable {
        final /* synthetic */ Exception val$e;
        final /* synthetic */ int val$id;
        final /* synthetic */ TransferListener val$l;

        public 4(TransferListener transferListener, int i, Exception exc) {
            this.val$l = transferListener;
            this.val$id = i;
            this.val$e = exc;
        }

        public void run() {
            this.val$l.onError(this.val$id, this.val$e);
        }
    }

    public class TransferProgressListener implements ProgressListener {
        private long bytesTransferredSoFar;
        private final TransferRecord transfer;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.transfer = transferRecord;
        }

        public synchronized void progressChanged(ProgressEvent progressEvent) {
            try {
                if (32 == progressEvent.getEventCode()) {
                    TransferStatusUpdater.access$000().info("Reset Event triggered. Resetting the bytesCurrent to 0.");
                    this.bytesTransferredSoFar = 0L;
                } else {
                    long bytesTransferred = this.bytesTransferredSoFar + progressEvent.getBytesTransferred();
                    this.bytesTransferredSoFar = bytesTransferred;
                    TransferRecord transferRecord = this.transfer;
                    if (bytesTransferred > transferRecord.bytesCurrent) {
                        transferRecord.bytesCurrent = bytesTransferred;
                        TransferStatusUpdater.this.updateProgress(transferRecord.id, bytesTransferred, transferRecord.bytesTotal, true);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public TransferStatusUpdater(TransferDBUtil transferDBUtil, Context context) {
        dbUtil = transferDBUtil;
        this.context = context;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.transfers = new ConcurrentHashMap();
    }

    public static /* synthetic */ Log access$000() {
        return LOGGER;
    }

    public static synchronized TransferStatusUpdater getInstance(Context context) {
        TransferStatusUpdater transferStatusUpdater2;
        synchronized (TransferStatusUpdater.class) {
            try {
                if (transferStatusUpdater == null) {
                    TransferDBUtil transferDBUtil = new TransferDBUtil(context);
                    dbUtil = transferDBUtil;
                    transferStatusUpdater = new TransferStatusUpdater(transferDBUtil, context);
                }
                transferStatusUpdater2 = transferStatusUpdater;
            } catch (Throwable th) {
                throw th;
            }
        }
        return transferStatusUpdater2;
    }

    public static void registerListener(int i, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map map = LISTENERS;
        synchronized (map) {
            try {
                List list = (List) map.get(Integer.valueOf(i));
                if (list == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(transferListener);
                    map.put(Integer.valueOf(i), copyOnWriteArrayList);
                } else if (!list.contains(transferListener)) {
                    list.add(transferListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void unregisterListener(int i, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map map = LISTENERS;
        synchronized (map) {
            try {
                List list = (List) map.get(Integer.valueOf(i));
                if (list != null && !list.isEmpty()) {
                    list.remove(transferListener);
                }
            } finally {
            }
        }
    }

    public synchronized void addTransfer(TransferRecord transferRecord) {
        this.transfers.put(Integer.valueOf(transferRecord.id), transferRecord);
    }

    public synchronized void clear() {
        Map map = LISTENERS;
        synchronized (map) {
            map.clear();
        }
        this.transfers.clear();
    }

    public synchronized TransferRecord getTransfer(int i) {
        return (TransferRecord) this.transfers.get(Integer.valueOf(i));
    }

    public synchronized Map getTransfers() {
        return Collections.unmodifiableMap(this.transfers);
    }

    public synchronized ProgressListener newProgressListener(int i) {
        TransferRecord transfer;
        transfer = getTransfer(i);
        if (transfer == null) {
            LOGGER.info("TransferStatusUpdater doesn't track the transfer: " + i);
            throw new IllegalArgumentException("transfer " + i + " doesn't exist");
        }
        LOGGER.info("Creating a new progress listener for transfer: " + i);
        return new TransferProgressListener(transfer);
    }

    public synchronized void removeTransfer(int i) {
        Map map = LISTENERS;
        synchronized (map) {
            map.remove(Integer.valueOf(i));
        }
        this.transfers.remove(Integer.valueOf(i));
    }

    public synchronized void removeTransferRecordFromDB(int i) {
        try {
            TransferRecord transferById = dbUtil.getTransferById(i);
            if (transferById != null) {
                String str = transferById.file;
                if (new File(str).getName().startsWith("aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002")) {
                    new File(str).delete();
                }
            }
            S3ClientReference.remove(Integer.valueOf(i));
            dbUtil.deleteTransferRecords(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void throwError(int i, Exception exc) {
        Map map = LISTENERS;
        synchronized (map) {
            try {
                List list = (List) map.get(Integer.valueOf(i));
                if (list != null && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        this.mainHandler.post(new 4((TransferListener) it.next(), i, exc));
                    }
                }
            } finally {
            }
        }
    }

    public synchronized void updateProgress(int i, long j, long j2, boolean z) {
        try {
            TransferRecord transferRecord = (TransferRecord) this.transfers.get(Integer.valueOf(i));
            if (transferRecord != null) {
                transferRecord.bytesCurrent = j;
                transferRecord.bytesTotal = j2;
            }
            dbUtil.updateBytesTransferred(i, j);
            if (z) {
                Map map = LISTENERS;
                synchronized (map) {
                    try {
                        List list = (List) map.get(Integer.valueOf(i));
                        if (list != null && !list.isEmpty()) {
                            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                                this.mainHandler.post(new 3((TransferListener) it.next(), i, j, j2));
                            }
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void updateState(int i, TransferState transferState) {
        Log log;
        String str;
        try {
            boolean contains = STATES_NOT_TO_NOTIFY.contains(transferState);
            TransferRecord transferRecord = (TransferRecord) this.transfers.get(Integer.valueOf(i));
            if (transferRecord != null) {
                contains |= transferState.equals(transferRecord.state);
                transferRecord.state = transferState;
                if (dbUtil.updateTransferRecord(transferRecord) == 0) {
                    log = LOGGER;
                    str = "Failed to update the status of transfer " + i;
                    log.warn(str);
                }
            } else if (dbUtil.updateState(i, transferState) == 0) {
                log = LOGGER;
                str = "Failed to update the status of transfer " + i;
                log.warn(str);
            }
            if (contains) {
                return;
            }
            if (TransferState.COMPLETED.equals(transferState)) {
                removeTransferRecordFromDB(i);
            }
            Map map = LISTENERS;
            synchronized (map) {
                try {
                    List<TransferListener> list = (List) map.get(Integer.valueOf(i));
                    if (list != null && !list.isEmpty()) {
                        for (TransferListener transferListener : list) {
                            if (transferListener instanceof TransferObserver.TransferStatusListener) {
                                transferListener.onStateChanged(i, transferState);
                            } else {
                                this.mainHandler.post(new 2(transferListener, i, transferState));
                            }
                        }
                        if (TransferState.isFinalState(transferState)) {
                            list.clear();
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
