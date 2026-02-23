package androidx.activity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class i implements O.a {
    public final /* synthetic */ OnBackPressedDispatcher a;

    public /* synthetic */ i(OnBackPressedDispatcher onBackPressedDispatcher) {
        this.a = onBackPressedDispatcher;
    }

    public final void accept(Object obj) {
        OnBackPressedDispatcher.a(this.a, (Boolean) obj);
    }
}
