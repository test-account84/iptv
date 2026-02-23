package e4;

import android.view.Surface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h extends p3.n {
    public final int d;
    public final boolean e;

    public h(Throwable th, p3.t tVar, Surface surface) {
        super(th, tVar);
        this.d = System.identityHashCode(surface);
        this.e = surface == null || surface.isValid();
    }
}
