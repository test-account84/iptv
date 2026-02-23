package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import b4.S;
import b4.T;
import b4.n;
import b4.s;
import com.google.android.exoplayer2.source.rtsp.g;
import d4.k0;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l implements a {
    public final T a;
    public l b;

    public l(long j) {
        this.a = new T(2000, w5.f.d(j));
    }

    public long a(s sVar) {
        return this.a.a(sVar);
    }

    public String c() {
        int localPort = getLocalPort();
        d4.a.g(localPort != -1);
        return k0.D("RTP/AVP;unicast;client_port=%d-%d", Integer.valueOf(localPort), Integer.valueOf(localPort + 1));
    }

    public void close() {
        this.a.close();
        l lVar = this.b;
        if (lVar != null) {
            lVar.close();
        }
    }

    public /* synthetic */ Map e() {
        return n.a(this);
    }

    public void g(S s) {
        this.a.g(s);
    }

    public int getLocalPort() {
        int localPort = this.a.getLocalPort();
        if (localPort == -1) {
            return -1;
        }
        return localPort;
    }

    public Uri getUri() {
        return this.a.getUri();
    }

    public boolean i() {
        return true;
    }

    public void j(l lVar) {
        d4.a.a(this != lVar);
        this.b = lVar;
    }

    public g.b l() {
        return null;
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.a.read(bArr, i, i2);
        } catch (T.a e) {
            if (e.a == 2002) {
                return -1;
            }
            throw e;
        }
    }
}
