package s4;

import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ CastSeekBar a;

    public /* synthetic */ b(CastSeekBar castSeekBar) {
        this.a = castSeekBar;
    }

    public final void run() {
        this.a.sendAccessibilityEvent(4);
    }
}
