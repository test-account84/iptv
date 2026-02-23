package X2;

import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends UploadDataProvider {
    public final byte[] a;
    public int c;

    public a(byte[] bArr) {
        this.a = bArr;
    }

    public long getLength() {
        return this.a.length;
    }

    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        int min = Math.min(byteBuffer.remaining(), this.a.length - this.c);
        byteBuffer.put(this.a, this.c, min);
        this.c += min;
        uploadDataSink.onReadSucceeded(false);
    }

    public void rewind(UploadDataSink uploadDataSink) {
        this.c = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
