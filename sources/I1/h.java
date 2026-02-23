package i1;

import h1.n;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h extends i1.a {
    public final SSLSocketFactory a;

    public static class a extends FilterInputStream {
        public final HttpURLConnection a;

        public a(HttpURLConnection httpURLConnection) {
            super(h.b(httpURLConnection));
            this.a = httpURLConnection;
        }

        public void close() {
            super.close();
            this.a.disconnect();
        }
    }

    public interface b {
    }

    public h() {
        this(null);
    }

    public static /* synthetic */ InputStream b(HttpURLConnection httpURLConnection) {
        return j(httpURLConnection);
    }

    public static List e(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new h1.g((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public static boolean i(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    public static InputStream j(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public f a(n nVar, Map map) {
        String F = nVar.F();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(nVar.u());
        HttpURLConnection k = k(new URL(F), nVar);
        try {
            for (String str : hashMap.keySet()) {
                k.setRequestProperty(str, (String) hashMap.get(str));
            }
            l(k, nVar);
            int responseCode = k.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (i(nVar.v(), responseCode)) {
                return new f(responseCode, e(k.getHeaderFields()), k.getContentLength(), g(nVar, k));
            }
            f fVar = new f(responseCode, e(k.getHeaderFields()));
            k.disconnect();
            return fVar;
        } catch (Throwable th) {
            if (0 == 0) {
                k.disconnect();
            }
            throw th;
        }
    }

    public final void c(HttpURLConnection httpURLConnection, n nVar, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", nVar.r());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(h(nVar, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public final void d(HttpURLConnection httpURLConnection, n nVar) {
        byte[] q = nVar.q();
        if (q != null) {
            c(httpURLConnection, nVar, q);
        }
    }

    public HttpURLConnection f(URL url) {
        HttpURLConnection openConnection = url.openConnection();
        openConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return openConnection;
    }

    public InputStream g(n nVar, HttpURLConnection httpURLConnection) {
        return new a(httpURLConnection);
    }

    public OutputStream h(n nVar, HttpURLConnection httpURLConnection, int i) {
        return httpURLConnection.getOutputStream();
    }

    public final HttpURLConnection k(URL url, n nVar) {
        SSLSocketFactory sSLSocketFactory;
        HttpsURLConnection f = f(url);
        int D = nVar.D();
        f.setConnectTimeout(D);
        f.setReadTimeout(D);
        f.setUseCaches(false);
        f.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.a) != null) {
            f.setSSLSocketFactory(sSLSocketFactory);
        }
        return f;
    }

    public void l(HttpURLConnection httpURLConnection, n nVar) {
        String str;
        String str2;
        switch (nVar.v()) {
            case -1:
                byte[] y = nVar.y();
                if (y != null) {
                    httpURLConnection.setRequestMethod("POST");
                    c(httpURLConnection, nVar, y);
                    return;
                }
                return;
            case 0:
                str = "GET";
                httpURLConnection.setRequestMethod(str);
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                d(httpURLConnection, nVar);
                return;
            case 2:
                str2 = "PUT";
                httpURLConnection.setRequestMethod(str2);
                d(httpURLConnection, nVar);
                return;
            case 3:
                str = "DELETE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 4:
                str = "HEAD";
                httpURLConnection.setRequestMethod(str);
                return;
            case 5:
                str = "OPTIONS";
                httpURLConnection.setRequestMethod(str);
                return;
            case 6:
                str = "TRACE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 7:
                str2 = "PATCH";
                httpURLConnection.setRequestMethod(str2);
                d(httpURLConnection, nVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public h(b bVar) {
        this(bVar, null);
    }

    public h(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }
}
