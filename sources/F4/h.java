package f4;

import android.graphics.SurfaceTexture;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class h implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ i a;

    public /* synthetic */ h(i iVar) {
        this.a = iVar;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        i.d(this.a, surfaceTexture);
    }
}
