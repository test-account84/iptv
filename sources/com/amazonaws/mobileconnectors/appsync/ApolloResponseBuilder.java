package com.amazonaws.mobileconnectors.appsync;

import F1.h;
import K1.a;
import K1.d;
import android.util.Log;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import v1.i;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ApolloResponseBuilder {
    private static final String CONTENT_TYPE = "application/json";
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json");
    private static final String TAG = "ApolloResponseBuilder";
    private final Map customTypeAdapters;
    private final h mapResponseNormalizer;

    public ApolloResponseBuilder(Map map, h hVar) {
        this.customTypeAdapters = map;
        this.mapResponseNormalizer = hVar;
    }

    public i buildResponse(String str, t tVar) {
        ResponseBody create = ResponseBody.create(str, MEDIA_TYPE);
        try {
            i f = new a(tVar, tVar.responseFieldMapper(), new d(this.customTypeAdapters), this.mapResponseNormalizer).f(create.source());
            if (f.e()) {
                Log.w(TAG, "Errors detected in parsed subscription message");
            }
            return f;
        } catch (IOException e) {
            throw new RuntimeException("Error constructing JSON object", e);
        }
    }
}
