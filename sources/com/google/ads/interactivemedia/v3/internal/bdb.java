package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdb implements bir {
    private final String a;
    private final int b;
    private bgp c;
    private bgh d;
    private int e;
    private bgt f;

    public bdb(bht bhtVar) throws GeneralSecurityException {
        String e = bhtVar.e();
        this.a = e;
        if (e.equals(bar.b)) {
            try {
                bgq c = bgq.c(bhtVar.d(), bqb.a());
                this.c = (bgp) bao.c(bhtVar);
                this.b = c.a();
                return;
            } catch (bqw e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
        if (e.equals(bar.a)) {
            try {
                bgi b = bgi.b(bhtVar.d(), bqb.a());
                this.d = (bgh) bao.c(bhtVar);
                this.e = b.c().a();
                this.b = this.e + b.d().a();
                return;
            } catch (bqw e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        }
        if (!e.equals(bcm.a)) {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(String.valueOf(e)));
        }
        try {
            bgu c2 = bgu.c(bhtVar.d(), bqb.a());
            this.f = (bgt) bao.c(bhtVar);
            this.b = c2.a();
        } catch (bqw e4) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e4);
        }
    }

    public final int a() {
        return this.b;
    }

    public final bdy b(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.a.equals(bar.b)) {
            bif g = bgp.g();
            g.be(this.c);
            g.ah(bpb.u(bArr, 0, this.b));
            return new bdy((azo) bao.g(this.a, (bgp) g.aY(), azo.class));
        }
        if (!this.a.equals(bar.a)) {
            if (!this.a.equals(bcm.a)) {
                throw new GeneralSecurityException("unknown DEM key type");
            }
            bif g2 = bgt.g();
            g2.be(this.f);
            g2.ab(bpb.u(bArr, 0, this.b));
            return new bdy((azr) bao.g(this.a, (bgt) g2.aY(), azr.class));
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.e);
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.e, this.b);
        bif k = bgj.k();
        k.be(this.d.d());
        k.as(bpb.t(copyOfRange));
        bgj bgjVar = (bgj) k.aY();
        bif k2 = bhg.k();
        k2.be(this.d.e());
        k2.G(bpb.t(copyOfRange2));
        bhg bhgVar = (bhg) k2.aY();
        bif j = bgh.j();
        j.az(this.d.a());
        j.ax(bgjVar);
        j.ay(bhgVar);
        return new bdy((azo) bao.g(this.a, (bgh) j.aY(), azo.class));
    }
}
