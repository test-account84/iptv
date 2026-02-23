package com.google.android.gms.internal.firebase-auth-api;

import A5.f;
import H5.m;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.firebase.auth.FirebaseAuth;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaci extends AsyncTask {
    private static final A4.a zza = new A4.a("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference zzd;
    private final Uri.Builder zze;
    private final String zzf;
    private final f zzg;

    public zzaci(String str, String str2, Intent intent, f fVar, zzack zzackVar) {
        this.zzb = r.g(str);
        this.zzg = (f) r.m(fVar);
        r.g(str2);
        r.m(intent);
        String g = r.g(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder buildUpon = Uri.parse(zzackVar.zza(g)).buildUpon();
        buildUpon.appendPath("getProjectConfig").appendQueryParameter("key", g).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) r.m(str2));
        this.zzc = buildUpon.build().toString();
        this.zzd = new WeakReference(zzackVar);
        this.zze = zzackVar.zza(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzach doInBackground(Void... voidArr) {
        try {
            URL url = new URL(this.zzc);
            zzack zzackVar = (zzack) this.zzd.get();
            URLConnection zza2 = zzackVar.zza(url);
            zza2.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
            zza2.setConnectTimeout(60000);
            new zzact(zzackVar.zza(), this.zzg, zzacr.zza().zzb()).zza(zza2);
            int responseCode = zza2.getResponseCode();
            if (responseCode != 200) {
                String zza3 = zza((HttpURLConnection) zza2);
                zza.c(String.format("Error getting project config. Failed with %s %s", new Object[]{zza3, Integer.valueOf(responseCode)}), new Object[0]);
                return zzach.zzb(zza3);
            }
            zzafi zzafiVar = new zzafi();
            zzafiVar.zza(new String(zza(zza2.getInputStream(), 128)));
            if (!TextUtils.isEmpty(this.zzf)) {
                return !zzafiVar.zza().contains(this.zzf) ? zzach.zzb("UNAUTHORIZED_DOMAIN") : zzach.zza(this.zzf);
            }
            for (String str : zzafiVar.zza()) {
                if (zza(str)) {
                    return zzach.zza(str);
                }
            }
            return null;
        } catch (zzaaf e) {
            zza.c("ConversionException encountered: " + e.getMessage(), new Object[0]);
            return null;
        } catch (IOException e2) {
            zza.c("IOException occurred: " + e2.getMessage(), new Object[0]);
            return null;
        } catch (NullPointerException e3) {
            zza.c("Null pointer encountered: " + e3.getMessage(), new Object[0]);
            return null;
        }
    }

    public final /* synthetic */ void onCancelled(Object obj) {
        onPostExecute((zzach) null);
    }

    private static String zza(HttpURLConnection httpURLConnection) throws zzaaf {
        try {
            if (httpURLConnection.getResponseCode() < 400) {
                return null;
            }
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                return (String) zzacq.zza(new String(zza(errorStream, 128)), String.class);
            }
            return "WEB_INTERNAL_ERROR:Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again.";
        } catch (IOException e) {
            zza.g("Error parsing error message from response body in getErrorMessageFromBody. " + String.valueOf(e), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final void onPostExecute(zzach zzachVar) {
        String str;
        String str2;
        Uri.Builder builder;
        zzack zzackVar = (zzack) this.zzd.get();
        if (zzachVar != null) {
            str = zzachVar.zza();
            str2 = zzachVar.zzb();
        } else {
            str = null;
            str2 = null;
        }
        if (zzackVar == null) {
            zza.c("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (TextUtils.isEmpty(str) || (builder = this.zze) == null) {
            zzackVar.zza(this.zzb, m.a(str2));
        } else {
            builder.authority(str);
            zzackVar.zza(this.zze.build(), this.zzb, FirebaseAuth.getInstance(this.zzg).B());
        }
    }

    private static boolean zza(String str) {
        try {
            String host = new URI("https://" + str).getHost();
            if (host != null) {
                if (host.endsWith("firebaseapp.com")) {
                    return true;
                }
                if (host.endsWith("web.app")) {
                    return true;
                }
            }
        } catch (URISyntaxException e) {
            zza.c("Error parsing URL for auth domain check: " + str + ". " + e.getMessage(), new Object[0]);
        }
        return false;
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
