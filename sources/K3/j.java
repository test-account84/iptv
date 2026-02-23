package K3;

import com.google.android.exoplayer2.source.rtsp.d;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ d.c a;
    public final /* synthetic */ List c;

    public /* synthetic */ j(d.c cVar, List list) {
        this.a = cVar;
        this.c = list;
    }

    public final void run() {
        d.c.d(this.a, this.c);
    }
}
