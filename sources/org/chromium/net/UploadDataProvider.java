package org.chromium.net;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class UploadDataProvider implements Closeable {
    public void close() throws IOException {
    }

    public abstract long getLength() throws IOException;

    public abstract void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException;

    public abstract void rewind(UploadDataSink uploadDataSink) throws IOException;
}
