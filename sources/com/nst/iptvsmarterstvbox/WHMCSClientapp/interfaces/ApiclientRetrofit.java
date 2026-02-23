package com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApiclientRetrofit {
    public static Retrofit a;

    public static Retrofit a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(120L, timeUnit).writeTimeout(120L, timeUnit).readTimeout(120L, timeUnit).followRedirects(false).build();
        Retrofit retrofit = a;
        if (retrofit != null) {
            return retrofit;
        }
        Retrofit build2 = new Retrofit.Builder().baseUrl("https://cms.alldrama.tv/").addConverterFactory(GsonConverterFactory.create()).client(build).build();
        a = build2;
        return build2;
    }
}
