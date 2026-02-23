package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.j;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class s implements j {
    public final OkHttpClient a;

    public s(Context context) {
        this(G.f(context));
    }

    public static OkHttpClient b() {
        OkHttpClient okHttpClient = new OkHttpClient();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClient.setConnectTimeout(15000L, timeUnit);
        okHttpClient.setReadTimeout(20000L, timeUnit);
        okHttpClient.setWriteTimeout(20000L, timeUnit);
        return okHttpClient;
    }

    public j.a a(Uri uri, int i) {
        CacheControl cacheControl;
        if (i == 0) {
            cacheControl = null;
        } else if (q.isOfflineOnly(i)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!q.shouldReadFromDiskCache(i)) {
                builder.noCache();
            }
            if (!q.shouldWriteToDiskCache(i)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response execute = this.a.newCall(url.build()).execute();
        int code = execute.code();
        if (code < 300) {
            boolean z = execute.cacheResponse() != null;
            ResponseBody body = execute.body();
            return new j.a(body.byteStream(), z, body.contentLength());
        }
        execute.body().close();
        throw new j.b(code + " " + execute.message(), i, code);
    }

    public s(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    public s(File file) {
        this(file, G.a(file));
    }

    public s(File file, long j) {
        this(b());
        try {
            this.a.setCache(new Cache(file, j));
        } catch (IOException unused) {
        }
    }
}
