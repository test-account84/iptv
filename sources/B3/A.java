package b3;

import O2.w0;
import android.net.Uri;
import b4.g;
import b4.s;
import d4.k0;
import io.antmedia.rtmp_client.RtmpClient;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends g {
    public static final /* synthetic */ int g = 0;
    public RtmpClient e;
    public Uri f;

    static {
        w0.a("goog.exo.rtmp");
    }

    public a() {
        super(true);
    }

    public long a(s sVar) {
        v(sVar);
        RtmpClient rtmpClient = new RtmpClient();
        this.e = rtmpClient;
        rtmpClient.b(sVar.a.toString(), false);
        this.f = sVar.a;
        w(sVar);
        return -1L;
    }

    public void close() {
        if (this.f != null) {
            this.f = null;
            u();
        }
        RtmpClient rtmpClient = this.e;
        if (rtmpClient != null) {
            rtmpClient.a();
            this.e = null;
        }
    }

    public Uri getUri() {
        return this.f;
    }

    public int read(byte[] bArr, int i, int i2) {
        int c = ((RtmpClient) k0.j(this.e)).c(bArr, i, i2);
        if (c == -1) {
            return -1;
        }
        t(c);
        return c;
    }
}
