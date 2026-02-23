package androidx.activity;

import android.window.OnBackInvokedCallback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class k implements OnBackInvokedCallback {
    public final /* synthetic */ Runnable a;

    public /* synthetic */ k(Runnable runnable) {
        this.a = runnable;
    }

    public final void onBackInvoked() {
        this.a.run();
    }
}
