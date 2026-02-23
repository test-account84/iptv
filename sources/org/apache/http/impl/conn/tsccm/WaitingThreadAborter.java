package org.apache.http.impl.conn.tsccm;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class WaitingThreadAborter {
    private boolean aborted;
    private WaitingThread waitingThread;

    public void abort() {
        this.aborted = true;
        WaitingThread waitingThread = this.waitingThread;
        if (waitingThread != null) {
            waitingThread.interrupt();
        }
    }

    public void setWaitingThread(WaitingThread waitingThread) {
        this.waitingThread = waitingThread;
        if (this.aborted) {
            waitingThread.interrupt();
        }
    }
}
