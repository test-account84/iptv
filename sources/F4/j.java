package f4;

import android.graphics.SurfaceTexture;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ l a;
    public final /* synthetic */ SurfaceTexture c;

    public /* synthetic */ j(l lVar, SurfaceTexture surfaceTexture) {
        this.a = lVar;
        this.c = surfaceTexture;
    }

    public final void run() {
        l.b(this.a, this.c);
    }
}
