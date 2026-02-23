package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcs extends WebViewClient {
    final /* synthetic */ zzda zza;

    public zzcs(zzda zzdaVar) {
        this.zza = zzdaVar;
    }

    public final void onLoadResource(@NotNull WebView webView, @NotNull String str) {
        System.currentTimeMillis();
    }

    public final void onPageFinished(@NotNull WebView webView, @NotNull String str) {
        zzai zzaiVar = zzai.zza;
        zzai.zzc(new zzaf(zzkw.INIT_NETWORK, zzda.zzh(this.zza), zzda.zzi(this.zza), zzda.zzi(this.zza), null), zzda.zza(this.zza), zzda.zzc(this.zza));
        long zza = zzda.zze(this.zza).zza(TimeUnit.MICROSECONDS);
        zzj zzjVar = zzj.zza;
        zzj.zza(zzl.zzl.zza(), zza);
    }

    public final void onReceivedError(@NotNull WebView webView, int i, @NotNull String str, @NotNull String str2) {
        super.onReceivedError(webView, i, str, str2);
        zzf zzfVar = zzf.zze;
        zzd zzdVar = (zzd) zzda.zzk(this.zza).get(Integer.valueOf(i));
        if (zzdVar == null) {
            zzdVar = zzd.zzb;
        }
        zzh zzhVar = new zzh(zzfVar, zzdVar);
        this.zza.zzm().hashCode();
        zzhVar.getMessage();
        this.zza.zzm().n(zzhVar);
    }

    @Nullable
    public final WebResourceResponse shouldInterceptRequest(@NotNull WebView webView, @NotNull String str) {
        zzdb zzdbVar = zzdb.zza;
        if (zzdb.zza(Uri.parse(str))) {
            return super.shouldInterceptRequest(webView, str);
        }
        Uri parse = Uri.parse(str);
        zzh zzhVar = new zzh(zzf.zzc, zzd.zzu);
        this.zza.zzm().hashCode();
        parse.toString();
        this.zza.zzm().n(zzhVar);
        return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
    }
}
