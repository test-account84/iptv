package q1;

import android.net.TrafficStats;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public static OkHttpClient a = b();
    public static String b = null;

    public class a implements Interceptor {
        public final /* synthetic */ k1.a a;

        public a(k1.a aVar) {
            this.a = aVar;
        }

        public Response intercept(Interceptor.Chain chain) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new f(proceed.body(), this.a.s())).build();
        }
    }

    public class b implements Interceptor {
        public final /* synthetic */ k1.a a;

        public b(k1.a aVar) {
            this.a = aVar;
        }

        public Response intercept(Interceptor.Chain chain) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new f(proceed.body(), this.a.s())).build();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(okhttp3.Request.Builder r3, k1.a r4) {
        /*
            java.lang.String r0 = r4.F()
            java.lang.String r1 = "User-Agent"
            if (r0 == 0) goto L10
            java.lang.String r0 = r4.F()
        Lc:
            r3.addHeader(r1, r0)
            goto L1a
        L10:
            java.lang.String r0 = q1.c.b
            if (r0 == 0) goto L1a
            r4.M(r0)
            java.lang.String r0 = q1.c.b
            goto Lc
        L1a:
            okhttp3.Headers r0 = r4.u()
            if (r0 == 0) goto L3a
            r3.headers(r0)
            java.lang.String r2 = r4.F()
            if (r2 == 0) goto L3a
            java.util.Set r0 = r0.names()
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L3a
            java.lang.String r4 = r4.F()
            r3.addHeader(r1, r4)
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.c.a(okhttp3.Request$Builder, k1.a):void");
    }

    public static OkHttpClient b() {
        OkHttpClient okHttpClient = a;
        return okHttpClient == null ? c() : okHttpClient;
    }

    public static OkHttpClient c() {
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return newBuilder.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build();
    }

    public static Response d(k1.a aVar) {
        try {
            Request.Builder url = new Request.Builder().url(aVar.E());
            a(url, aVar);
            Request.Builder builder = url.get();
            if (aVar.p() != null) {
                builder.cacheControl(aVar.p());
            }
            aVar.I((aVar.x() != null ? aVar.x().newBuilder().cache(a.cache()).addNetworkInterceptor(new a(aVar)) : a.newBuilder().addNetworkInterceptor(new b(aVar))).build().newCall(builder.build()));
            long currentTimeMillis = System.currentTimeMillis();
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            Response execute = aVar.q().execute();
            s1.c.h(execute, aVar.r(), aVar.t());
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (execute.cacheResponse() == null) {
                long totalRxBytes2 = TrafficStats.getTotalRxBytes();
                k1.c.a().b((totalRxBytes == -1 || totalRxBytes2 == -1) ? execute.body().contentLength() : totalRxBytes2 - totalRxBytes, currentTimeMillis2);
                aVar.n();
                s1.c.i(null, currentTimeMillis2, -1L, execute.body().contentLength(), false);
            } else {
                aVar.n();
            }
            return execute;
        } catch (IOException e) {
            try {
                File file = new File(aVar.r() + File.separator + aVar.t());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new m1.a((Throwable) e);
        }
    }

    public static Response e(k1.a aVar) {
        try {
            Request.Builder url = new Request.Builder().url(aVar.E());
            a(url, aVar);
            RequestBody requestBody = null;
            switch (aVar.v()) {
                case 0:
                    url = url.get();
                    break;
                case 1:
                    requestBody = aVar.z();
                    url = url.post(requestBody);
                    break;
                case 2:
                    requestBody = aVar.z();
                    url = url.put(requestBody);
                    break;
                case 3:
                    requestBody = aVar.z();
                    url = url.delete(requestBody);
                    break;
                case 4:
                    url = url.head();
                    break;
                case 5:
                    requestBody = aVar.z();
                    url = url.patch(requestBody);
                    break;
                case 6:
                    url = url.method("OPTIONS", (RequestBody) null);
                    break;
            }
            if (aVar.p() != null) {
                url.cacheControl(aVar.p());
            }
            Request build = url.build();
            aVar.I(aVar.x() != null ? aVar.x().newBuilder().cache(a.cache()).build().newCall(build) : a.newCall(build));
            long currentTimeMillis = System.currentTimeMillis();
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            Response execute = aVar.q().execute();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (execute.cacheResponse() == null) {
                long totalRxBytes2 = TrafficStats.getTotalRxBytes();
                k1.c.a().b((totalRxBytes == -1 || totalRxBytes2 == -1) ? execute.body().contentLength() : totalRxBytes2 - totalRxBytes, currentTimeMillis2);
                aVar.n();
                s1.c.i(null, currentTimeMillis2, (requestBody == null || requestBody.contentLength() == 0) ? -1L : requestBody.contentLength(), execute.body().contentLength(), false);
            } else {
                aVar.n();
            }
            return execute;
        } catch (IOException e) {
            throw new m1.a((Throwable) e);
        }
    }

    public static Response f(k1.a aVar) {
        try {
            Request.Builder url = new Request.Builder().url(aVar.E());
            a(url, aVar);
            RequestBody w = aVar.w();
            w.contentLength();
            Request.Builder post = url.post(new e(w, aVar.D()));
            if (aVar.p() != null) {
                post.cacheControl(aVar.p());
            }
            Request build = post.build();
            aVar.I(aVar.x() != null ? aVar.x().newBuilder().cache(a.cache()).build().newCall(build) : a.newCall(build));
            System.currentTimeMillis();
            Response execute = aVar.q().execute();
            System.currentTimeMillis();
            aVar.n();
            return execute;
        } catch (IOException e) {
            throw new m1.a((Throwable) e);
        }
    }
}
