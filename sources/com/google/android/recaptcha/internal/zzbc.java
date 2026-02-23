package com.google.android.recaptcha.internal;

import G8.L;
import G8.N;
import G8.i;
import android.webkit.WebView;
import o8.g;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbc {

    @NotNull
    private final WebView zza;

    @NotNull
    private final L zzb;

    public zzbc(@NotNull WebView webView, @NotNull L l) {
        this.zza = webView;
        this.zzb = l;
    }

    public static final /* synthetic */ WebView zza(zzbc zzbcVar) {
        return zzbcVar.zza;
    }

    public final void zzb(@NotNull String str, @NotNull String... strArr) {
        i.d(this.zzb, (g) null, (N) null, new zzbb(strArr, this, str, null), 3, (Object) null);
    }
}
