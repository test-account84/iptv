package androidx.activity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ OnBackPressedDispatcher a;

    public /* synthetic */ j(OnBackPressedDispatcher onBackPressedDispatcher) {
        this.a = onBackPressedDispatcher;
    }

    public final void run() {
        this.a.f();
    }
}
