package d2;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class s implements d2.a {
    public static final a c = new a();
    public a a;
    public int b;

    public static class a {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public s() {
        this(c, -1);
    }

    public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, V1.b bVar, int i, int i2, S1.a aVar) {
        MediaMetadataRetriever a2 = this.a.a();
        a2.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i3 = this.b;
        Bitmap frameAtTime = i3 >= 0 ? a2.getFrameAtTime(i3) : a2.getFrameAtTime();
        a2.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public s(a aVar, int i) {
        this.a = aVar;
        this.b = i;
    }
}
