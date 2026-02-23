package E3;

import com.google.android.exoplayer2.source.dash.DashMediaSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ DashMediaSource a;

    public /* synthetic */ d(DashMediaSource dashMediaSource) {
        this.a = dashMediaSource;
    }

    public final void run() {
        DashMediaSource.p0(this.a);
    }
}
