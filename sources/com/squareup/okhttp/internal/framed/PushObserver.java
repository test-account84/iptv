package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new 1();

    public static class 1 implements PushObserver {
        public boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip(i2);
            return true;
        }

        public boolean onHeaders(int i, List list, boolean z) {
            return true;
        }

        public boolean onRequest(int i, List list) {
            return true;
        }

        public void onReset(int i, ErrorCode errorCode) {
        }
    }

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List list, boolean z);

    boolean onRequest(int i, List list);

    void onReset(int i, ErrorCode errorCode);
}
