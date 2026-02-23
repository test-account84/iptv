package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.squareup.picasso.j;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class r extends y {
    public final j a;
    public final A b;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public r(j jVar, A a2) {
        this.a = jVar;
        this.b = a2;
    }

    public boolean c(w wVar) {
        String scheme = wVar.d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    public int e() {
        return 2;
    }

    public y.a f(w wVar, int i) {
        j.a a2 = this.a.a(wVar.d, wVar.c);
        if (a2 == null) {
            return null;
        }
        t.e eVar = a2.c ? t.e.DISK : t.e.NETWORK;
        Bitmap a3 = a2.a();
        if (a3 != null) {
            return new y.a(a3, eVar);
        }
        InputStream c = a2.c();
        if (c == null) {
            return null;
        }
        if (eVar == t.e.DISK && a2.b() == 0) {
            G.e(c);
            throw new a("Received response with 0 content-length header.");
        }
        if (eVar == t.e.NETWORK && a2.b() > 0) {
            this.b.f(a2.b());
        }
        return new y.a(c, eVar);
    }

    public boolean h(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    public boolean i() {
        return true;
    }
}
