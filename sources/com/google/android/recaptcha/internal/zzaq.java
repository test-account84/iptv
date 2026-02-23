package com.google.android.recaptcha.internal;

import android.net.TrafficStats;
import android.webkit.URLUtil;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.l;
import l8.k;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaq implements zzap {

    @NotNull
    private final String zza;

    public zzaq(@NotNull String str) {
        this.zza = str;
    }

    private static final void zzb(byte[] bArr) {
        for (zzkx zzkxVar : zzla.zzi(bArr).zzj()) {
            if (k.h(new String[]{"INIT_TOTAL", "EXECUTE_TOTAL"}).contains(zzkxVar.zzj().name()) && zzkxVar.zzS()) {
                zzkxVar.zzH();
                zzkxVar.zzI();
                zzkxVar.zzj().name();
                zzkxVar.zzg().zzk();
                zzkxVar.zzg().zzf();
            } else {
                zzkxVar.zzH();
                zzkxVar.zzI();
                zzkxVar.zzj().name();
            }
            zzkxVar.zzT();
        }
    }

    public final boolean zza(@NotNull byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            zzb(bArr);
            if (URLUtil.isHttpUrl(this.zza)) {
                URLConnection openConnection = new URL(this.zza).openConnection();
                l.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) openConnection;
            } else {
                if (!URLUtil.isHttpsUrl(this.zza)) {
                    throw new MalformedURLException("Recaptcha server url only allows using Http or Https.");
                }
                HttpURLConnection openConnection2 = new URL(this.zza).openConnection();
                l.c(openConnection2, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpURLConnection = (HttpsURLConnection) openConnection2;
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuffer");
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(bArr);
            return httpURLConnection.getResponseCode() == 200;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
