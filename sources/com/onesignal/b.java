package com.onesignal;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class B {
    public final GoogleApiClient a;
    public final Class b;

    public B(GoogleApiClient googleApiClient) {
        this.a = googleApiClient;
        this.b = googleApiClient.getClass();
    }

    public void a() {
        try {
            this.b.getMethod("connect", (Class[]) null).invoke(this.a, (Object[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        try {
            this.b.getMethod("disconnect", (Class[]) null).invoke(this.a, (Object[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public GoogleApiClient c() {
        return this.a;
    }
}
