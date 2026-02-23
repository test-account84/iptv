package K3;

import com.google.android.exoplayer2.source.rtsp.g;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ g.g a;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ List d;

    public /* synthetic */ q(g.g gVar, byte[] bArr, List list) {
        this.a = gVar;
        this.c = bArr;
        this.d = list;
    }

    public final void run() {
        g.g.a(this.a, this.c, this.d);
    }
}
