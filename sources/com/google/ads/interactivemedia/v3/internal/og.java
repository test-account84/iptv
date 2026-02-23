package com.google.ads.interactivemedia.v3.internal;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import java.util.Map;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class og implements ob {
    public static final od a = od.a;
    private final UUID b;
    private final MediaDrm c;
    private int d;

    private og(UUID uuid) throws UnsupportedSchemeException {
        af.s(uuid);
        af.v(!i.b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.b = uuid;
        MediaDrm mediaDrm = new MediaDrm(p(uuid));
        this.c = mediaDrm;
        this.d = 1;
        if (i.d.equals(uuid) && "ASUS_Z00AD".equals(cq.d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    public static og o(UUID uuid) throws ol {
        try {
            return new og(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new ol(e);
        } catch (Exception e2) {
            throw new ol(e2);
        }
    }

    private static UUID p(UUID uuid) {
        return (cq.a >= 27 || !i.c.equals(uuid)) ? uuid : i.b;
    }

    public final int a() {
        return 2;
    }

    public final /* bridge */ /* synthetic */ ea b(byte[] bArr) throws MediaCryptoException {
        boolean z = false;
        if (cq.a < 21 && i.d.equals(this.b) && "L3".equals(this.c.getPropertyString("securityLevel"))) {
            z = true;
        }
        return new oc(p(this.b), bArr, z);
    }

    public final Map c(byte[] bArr) {
        return this.c.queryKeyStatus(bArr);
    }

    public final void d(byte[] bArr) {
        this.c.closeSession(bArr);
    }

    public final void e(byte[] bArr) throws DeniedByServerException {
        this.c.provideProvisionResponse(bArr);
    }

    public final synchronized void f() {
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            this.c.release();
        }
    }

    public final void g(byte[] bArr, byte[] bArr2) {
        this.c.restoreKeys(bArr, bArr2);
    }

    public final void h(oa oaVar) {
        this.c.setOnEventListener(new oe(this, oaVar));
    }

    public final void i(byte[] bArr, iw iwVar) {
        if (cq.a >= 31) {
            try {
                of.a(this.c, bArr, iwVar);
            } catch (UnsupportedOperationException unused) {
                cd.e("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    public final boolean j(byte[] bArr, String str) {
        if (cq.a >= 31) {
            return of.b(this.c, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.b, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    public final byte[] k() throws MediaDrmException {
        return this.c.openSession();
    }

    public final byte[] l(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (i.c.equals(this.b)) {
            bArr2 = pi.d(bArr2);
        }
        return this.c.provideKeyResponse(bArr, bArr2);
    }

    public final zo m() {
        MediaDrm.ProvisionRequest provisionRequest = this.c.getProvisionRequest();
        return new zo(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00c5  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.aeq n(byte[] r16, java.util.List r17, int r18, java.util.HashMap r19) throws android.media.NotProvisionedException {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.og.n(byte[], java.util.List, int, java.util.HashMap):com.google.ads.interactivemedia.v3.internal.aeq");
    }
}
