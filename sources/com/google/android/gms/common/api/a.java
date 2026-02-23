package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a {
    public final a a;
    public final g b;
    public final String c;

    public static abstract class a extends e {
        @Deprecated
        public f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, Object obj, GoogleApiClient.b bVar, GoogleApiClient.c cVar) {
            return buildClient(context, looper, eVar, obj, (com.google.android.gms.common.api.internal.f) bVar, (com.google.android.gms.common.api.internal.n) cVar);
        }

        public f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, Object obj, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.n nVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c {
    }

    public interface d {
        public static final a a = new a(null);

        public static final class a implements d {
            public /* synthetic */ a(m mVar) {
            }
        }
    }

    public static abstract class e {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public List getImpliedScopes(Object obj) {
            return Collections.emptyList();
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface f extends b {
        void connect(c.c cVar);

        void disconnect();

        void disconnect(String str);

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        w4.d[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(com.google.android.gms.common.internal.k kVar, Set set);

        Set getScopesForConnectionlessNonSignIn();

        Intent getSignInIntent();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(c.e eVar);

        boolean providesSignIn();

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public static final class g extends c {
    }

    public a(String str, a aVar, g gVar) {
        r.n(aVar, "Cannot construct an Api with a null ClientBuilder");
        r.n(gVar, "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.a = aVar;
        this.b = gVar;
    }

    public final a a() {
        return this.a;
    }

    public final c b() {
        return this.b;
    }

    public final e c() {
        return this.a;
    }

    public final String d() {
        return this.c;
    }
}
