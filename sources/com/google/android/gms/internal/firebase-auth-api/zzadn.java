package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzadn {
    public static void zza(String str, zzacp zzacpVar, zzadk zzadkVar, Type type, zzact zzactVar) {
        String str2;
        try {
            r.m(zzacpVar);
            HttpURLConnection openConnection = new URL(str).openConnection();
            openConnection.setDoOutput(true);
            byte[] bytes = zzacpVar.zza().getBytes(Charset.defaultCharset());
            openConnection.setFixedLengthStreamingMode(bytes.length);
            openConnection.setRequestProperty("Content-Type", "application/json");
            openConnection.setConnectTimeout(60000);
            zzactVar.zza((URLConnection) openConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(openConnection.getOutputStream(), bytes.length);
            try {
                bufferedOutputStream.write(bytes, 0, bytes.length);
                bufferedOutputStream.close();
                zza(openConnection, zzadkVar, type);
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    zzadm.zza(th, th2);
                }
                throw th;
            }
        } catch (UnknownHostException unused) {
            str2 = "<<Network Error>>";
            zzadkVar.zza(str2);
        } catch (NullPointerException e) {
            e = e;
            str2 = e.getMessage();
            zzadkVar.zza(str2);
        } catch (IOException e2) {
            e = e2;
            str2 = e.getMessage();
            zzadkVar.zza(str2);
        } catch (SocketTimeoutException unused2) {
            str2 = "TIMEOUT";
            zzadkVar.zza(str2);
        } catch (JSONException e3) {
            e = e3;
            str2 = e.getMessage();
            zzadkVar.zza(str2);
        }
    }

    public static void zza(String str, zzadk zzadkVar, Type type, zzact zzactVar) {
        String str2;
        try {
            HttpURLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(60000);
            zzactVar.zza((URLConnection) openConnection);
            zza(openConnection, zzadkVar, type);
        } catch (UnknownHostException unused) {
            str2 = "<<Network Error>>";
            zzadkVar.zza(str2);
        } catch (IOException e) {
            str2 = e.getMessage();
            zzadkVar.zza(str2);
        } catch (SocketTimeoutException unused2) {
            str2 = "TIMEOUT";
            zzadkVar.zza(str2);
        }
    }

    private static void zza(HttpURLConnection httpURLConnection, zzadk zzadkVar, Type type) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InputStream inputStream = zza(responseCode) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else {
                            sb.append(readLine);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            zzadm.zza(th, th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                if (zza(responseCode)) {
                    zzadkVar.zza((zzacs) zzacq.zza(sb2, type));
                } else {
                    zzadkVar.zza((String) zzacq.zza(sb2, String.class));
                }
                httpURLConnection.disconnect();
            } catch (zzaaf e) {
                e = e;
                zzadkVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            } catch (SocketTimeoutException unused) {
                zzadkVar.zza("TIMEOUT");
                httpURLConnection.disconnect();
            } catch (IOException e2) {
                e = e2;
                zzadkVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    private static final boolean zza(int i) {
        return i >= 200 && i < 300;
    }
}
