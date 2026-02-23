package w7;

import java.io.File;
import java.io.RandomAccessFile;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a implements IMediaDataSource {
    public RandomAccessFile a;
    public long b;

    public a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.a = randomAccessFile;
        this.b = randomAccessFile.length();
    }

    public static String a() {
        return "SVBUViBTbWFydGVycyBQcm8=";
    }

    public void close() {
        this.b = 0L;
        this.a.close();
        this.a = null;
    }

    public long getSize() {
        return this.b;
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (this.a.getFilePointer() != j) {
            this.a.seek(j);
        }
        if (i2 == 0) {
            return 0;
        }
        return this.a.read(bArr, 0, i2);
    }
}
