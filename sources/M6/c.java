package m6;

import C4.j;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Tasks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import k6.i;
import m6.d;
import m6.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c {
    public static final Pattern d = Pattern.compile("[0-9]+s");
    public static final Charset e = Charset.forName("UTF-8");
    public final Context a;
    public final j6.b b;
    public final e c = new e();

    public c(Context context, j6.b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public static String a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            str4 = "";
        } else {
            str4 = ", " + str;
        }
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", new Object[]{str2, str3, str4});
    }

    public static JSONObject b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:17.1.3");
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:17.1.3");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static byte[] h(JSONObject jSONObject) {
        return jSONObject.toString().getBytes("UTF-8");
    }

    public static boolean i(int i) {
        return i >= 200 && i < 300;
    }

    public static void j() {
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    public static void k(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        String o = o(httpURLConnection);
        if (TextUtils.isEmpty(o)) {
            return;
        }
        Log.w("Firebase-Installations", o);
        Log.w("Firebase-Installations", a(str, str2, str3));
    }

    public static long m(String str) {
        r.b(d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    public static String o(HttpURLConnection httpURLConnection) {
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, e));
        try {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                String format = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", new Object[]{Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb});
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return format;
            } catch (IOException unused2) {
                return null;
            }
        } catch (IOException unused3) {
            bufferedReader.close();
            return null;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused4) {
            }
            throw th;
        }
    }

    public static void s(URLConnection uRLConnection, byte[] bArr) {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public d d(String str, String str2, String str3, String str4, String str5) {
        int responseCode;
        d n;
        if (!this.c.b()) {
            throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
        }
        URL g = g(String.format("projects/%s/installations", new Object[]{str3}));
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection l = l(g, str);
            try {
                try {
                    l.setRequestMethod("POST");
                    l.setDoOutput(true);
                    if (str5 != null) {
                        l.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                    }
                    q(l, str2, str4);
                    responseCode = l.getResponseCode();
                    this.c.f(responseCode);
                } catch (AssertionError | IOException unused) {
                }
                if (i(responseCode)) {
                    n = n(l);
                } else {
                    k(l, str4, str, str3);
                    if (responseCode == 429) {
                        throw new i("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", i.a.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        j();
                        n = d.a().e(d.b.BAD_CONFIG).a();
                    }
                    l.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
                l.disconnect();
                TrafficStats.clearThreadStatsTag();
                return n;
            } catch (Throwable th) {
                l.disconnect();
                TrafficStats.clearThreadStatsTag();
                throw th;
            }
        }
        throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
    }

    public f e(String str, String str2, String str3, String str4) {
        int responseCode;
        f p;
        f.a b;
        if (!this.c.b()) {
            throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
        }
        URL g = g(String.format("projects/%s/installations/%s/authTokens:generate", new Object[]{str3, str2}));
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection l = l(g, str);
            try {
                try {
                    l.setRequestMethod("POST");
                    l.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    l.setDoOutput(true);
                    r(l);
                    responseCode = l.getResponseCode();
                    this.c.f(responseCode);
                } finally {
                    l.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (AssertionError | IOException unused) {
            }
            if (i(responseCode)) {
                p = p(l);
            } else {
                k(l, null, str, str3);
                if (responseCode == 401 || responseCode == 404) {
                    b = f.a().b(f.b.AUTH_ERROR);
                } else {
                    if (responseCode == 429) {
                        throw new i("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", i.a.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        j();
                        b = f.a().b(f.b.BAD_CONFIG);
                    }
                }
                p = b.a();
            }
            return p;
        }
        throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
    }

    public final String f() {
        try {
            Context context = this.a;
            byte[] a = C4.a.a(context, context.getPackageName());
            if (a != null) {
                return j.c(a, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("ContentValues", "No such package: " + this.a.getPackageName(), e2);
            return null;
        }
    }

    public final URL g(String str) {
        try {
            return new URL(String.format("https://%s/%s/%s", new Object[]{"firebaseinstallations.googleapis.com", "v1", str}));
        } catch (MalformedURLException e2) {
            throw new i(e2.getMessage(), i.a.UNAVAILABLE);
        }
    }

    public final HttpURLConnection l(URL url, String str) {
        try {
            HttpURLConnection openConnection = url.openConnection();
            openConnection.setConnectTimeout(10000);
            openConnection.setUseCaches(false);
            openConnection.setReadTimeout(10000);
            openConnection.addRequestProperty("Content-Type", "application/json");
            openConnection.addRequestProperty("Accept", "application/json");
            openConnection.addRequestProperty("Content-Encoding", "gzip");
            openConnection.addRequestProperty("Cache-Control", "no-cache");
            openConnection.addRequestProperty("X-Android-Package", this.a.getPackageName());
            h6.i iVar = (h6.i) this.b.get();
            if (iVar != null) {
                try {
                    openConnection.addRequestProperty("x-firebase-client", (String) Tasks.await(iVar.a()));
                } catch (InterruptedException e2) {
                    e = e2;
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e);
                    openConnection.addRequestProperty("X-Android-Cert", f());
                    openConnection.addRequestProperty("x-goog-api-key", str);
                    return openConnection;
                } catch (ExecutionException e3) {
                    e = e3;
                    Log.w("ContentValues", "Failed to get heartbeats header", e);
                    openConnection.addRequestProperty("X-Android-Cert", f());
                    openConnection.addRequestProperty("x-goog-api-key", str);
                    return openConnection;
                }
            }
            openConnection.addRequestProperty("X-Android-Cert", f());
            openConnection.addRequestProperty("x-goog-api-key", str);
            return openConnection;
        } catch (IOException unused) {
            throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
        }
    }

    public final d n(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, e));
        f.a a = f.a();
        d.a a2 = d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                a2.f(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                a2.c(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                a2.d(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals("token")) {
                        a.c(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        a.d(m(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                a2.b(a.a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return a2.e(d.b.OK).a();
    }

    public final f p(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, e));
        f.a a = f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
                a.c(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                a.d(m(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return a.b(f.b.OK).a();
    }

    public final void q(HttpURLConnection httpURLConnection, String str, String str2) {
        s(httpURLConnection, h(b(str, str2)));
    }

    public final void r(HttpURLConnection httpURLConnection) {
        s(httpURLConnection, h(c()));
    }
}
