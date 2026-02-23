package A2;

import B2.j;
import B2.k;
import B2.l;
import B2.m;
import B2.n;
import B2.o;
import B2.p;
import C2.h;
import C2.i;
import D2.f;
import D2.g;
import D2.m;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements m {
    public final c6.a a;
    public final ConnectivityManager b;
    public final Context c;
    public final URL d;
    public final M2.a e;
    public final M2.a f;
    public final int g;

    public static final class a {
        public final URL a;
        public final j b;
        public final String c;

        public a(URL url, j jVar, String str) {
            this.a = url;
            this.b = jVar;
            this.c = str;
        }

        public a a(URL url) {
            return new a(url, this.b, this.c);
        }
    }

    public static final class b {
        public final int a;
        public final URL b;
        public final long c;

        public b(int i, URL url, long j) {
            this.a = i;
            this.b = url;
            this.c = j;
        }
    }

    public d(Context context, M2.a aVar, M2.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }

    public static /* synthetic */ b c(d dVar, a aVar) {
        return dVar.e(aVar);
    }

    public static /* synthetic */ a d(a aVar, b bVar) {
        return l(aVar, bVar);
    }

    public static int f(NetworkInfo networkInfo) {
        o.b bVar;
        if (networkInfo == null) {
            bVar = o.b.UNKNOWN_MOBILE_SUBTYPE;
        } else {
            int subtype = networkInfo.getSubtype();
            if (subtype != -1) {
                if (o.b.forNumber(subtype) != null) {
                    return subtype;
                }
                return 0;
            }
            bVar = o.b.COMBINED;
        }
        return bVar.getValue();
    }

    public static int g(NetworkInfo networkInfo) {
        return networkInfo == null ? o.c.NONE.getValue() : networkInfo.getType();
    }

    public static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            G2.a.d("CctTransportBackend", "Unable to find version code for package", e);
            return -1;
        }
    }

    public static TelephonyManager j(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static long k() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    public static /* synthetic */ a l(a aVar, b bVar) {
        URL url = bVar.b;
        if (url == null) {
            return null;
        }
        G2.a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.b);
    }

    public static InputStream m(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    public i a(i iVar) {
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        return iVar.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.c).getSimOperator()).c("application_build", Integer.toString(h(this.c))).d();
    }

    public g b(f fVar) {
        j i = i(fVar);
        URL url = this.d;
        if (fVar.c() != null) {
            try {
                A2.a c = A2.a.c(fVar.c());
                r3 = c.d() != null ? c.d() : null;
                if (c.e() != null) {
                    url = n(c.e());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) H2.b.a(5, new a(url, i, r3), new A2.b(this), new c());
            int i2 = bVar.a;
            if (i2 == 200) {
                return g.e(bVar.c);
            }
            if (i2 < 500 && i2 != 404) {
                return i2 == 400 ? g.d() : g.a();
            }
            return g.f();
        } catch (IOException e) {
            G2.a.d("CctTransportBackend", "Could not make request to the backend", e);
            return g.f();
        }
    }

    public final b e(a aVar) {
        G2.a.f("CctTransportBackend", "Making request to: %s", aVar.a);
        HttpURLConnection openConnection = aVar.a.openConnection();
        openConnection.setConnectTimeout(30000);
        openConnection.setReadTimeout(this.g);
        openConnection.setDoOutput(true);
        openConnection.setInstanceFollowRedirects(false);
        openConnection.setRequestMethod("POST");
        openConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", new Object[]{"3.1.9"}));
        openConnection.setRequestProperty("Content-Encoding", "gzip");
        openConnection.setRequestProperty("Content-Type", "application/json");
        openConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.c;
        if (str != null) {
            openConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = openConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.a.a(aVar.b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = openConnection.getResponseCode();
                    G2.a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    G2.a.b("CctTransportBackend", "Content-Type: %s", openConnection.getHeaderField("Content-Type"));
                    G2.a.b("CctTransportBackend", "Content-Encoding: %s", openConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(openConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = openConnection.getInputStream();
                    try {
                        InputStream m = m(inputStream, openConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, n.b(new BufferedReader(new InputStreamReader(m))).c());
                            if (m != null) {
                                m.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } finally {
                        }
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (c6.c e) {
            e = e;
            G2.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e2) {
            e = e2;
            G2.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            G2.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e4) {
            e = e4;
            G2.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    public final j i(f fVar) {
        l.a j;
        HashMap hashMap = new HashMap();
        for (i iVar : fVar.b()) {
            String j2 = iVar.j();
            if (hashMap.containsKey(j2)) {
                ((List) hashMap.get(j2)).add(iVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                hashMap.put(j2, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            m.a b2 = B2.m.a().f(p.DEFAULT).g(this.f.a()).h(this.e.a()).b(k.a().c(k.b.ANDROID_FIREBASE).b(B2.a.a().m(Integer.valueOf(iVar2.g("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                b2.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b2.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h e = iVar3.e();
                z2.b b3 = e.b();
                if (b3.equals(z2.b.b("proto"))) {
                    j = l.j(e.a());
                } else if (b3.equals(z2.b.b("json"))) {
                    j = l.i(new String(e.a(), Charset.forName("UTF-8")));
                } else {
                    G2.a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b3);
                }
                j.c(iVar3.f()).d(iVar3.k()).h(iVar3.h("tz-offset")).e(o.a().c(o.c.forNumber(iVar3.g("net-type"))).b(o.b.forNumber(iVar3.g("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    j.b(iVar3.d());
                }
                arrayList3.add(j.a());
            }
            b2.c(arrayList3);
            arrayList2.add(b2.a());
        }
        return j.a(arrayList2);
    }

    public d(Context context, M2.a aVar, M2.a aVar2, int i) {
        this.a = j.b();
        this.c = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = n(A2.a.c);
        this.e = aVar2;
        this.f = aVar;
        this.g = i;
    }
}
