package androidx.activity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ ComponentActivity a;

    public /* synthetic */ b(ComponentActivity componentActivity) {
        this.a = componentActivity;
    }

    public final void run() {
        this.a.invalidateMenu();
    }
}
