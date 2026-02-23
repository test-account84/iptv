package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfe {
    private Object a;
    private Object b;
    private Object c;

    private bfe() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public final bff a() throws GeneralSecurityException {
        bjj b;
        Object obj = this.a;
        if (obj == null || this.b == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (((bfm) obj).g() != ((vk) this.b).d()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (((bfm) this.a).j() && this.c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with format with ID requirement");
        }
        if (!((bfm) this.a).j() && this.c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with format without ID requirement");
        }
        if (((bfm) this.a).i() == bfl.d) {
            b = bjj.b(new byte[0]);
        } else if (((bfm) this.a).i() == bfl.c || ((bfm) this.a).i() == bfl.b) {
            b = bjj.b(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.c).intValue()).array());
        } else {
            if (((bfm) this.a).i() != bfl.a) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(((bfm) this.a).i())));
            }
            b = bjj.b(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.c).intValue()).array());
        }
        return new bff((bfm) this.a, b);
    }

    public final void b(Integer num) {
        this.c = num;
    }

    public final void c(bfm bfmVar) {
        this.a = bfmVar;
    }

    public final bfc d() throws GeneralSecurityException {
        Object obj = this.b;
        if (obj == null || this.a == null) {
            throw new GeneralSecurityException("Key size and/or tag size not set");
        }
        return new bfc(((Integer) obj).intValue(), ((Integer) this.a).intValue(), (bfb) this.c);
    }

    public final void e(int i) throws GeneralSecurityException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i * 8)}));
        }
        this.b = Integer.valueOf(i);
    }

    public final void f(int i) throws GeneralSecurityException {
        if (i >= 10 && i <= 16) {
            this.a = Integer.valueOf(i);
            return;
        }
        throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
    }

    public final void g(bfb bfbVar) {
        this.c = bfbVar;
    }

    public final bex h() throws GeneralSecurityException {
        bjj b;
        Object obj = this.c;
        if (obj == null || this.b == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (((bfc) obj).g() != ((vk) this.b).d()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (((bfc) this.c).j() && this.a == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with format with ID requirement");
        }
        if (!((bfc) this.c).j() && this.a != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with format without ID requirement");
        }
        if (((bfc) this.c).i() == bfb.d) {
            b = bjj.b(new byte[0]);
        } else if (((bfc) this.c).i() == bfb.c || ((bfc) this.c).i() == bfb.b) {
            b = bjj.b(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.a).intValue()).array());
        } else {
            if (((bfc) this.c).i() != bfb.a) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(((bfc) this.c).i())));
            }
            b = bjj.b(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.a).intValue()).array());
        }
        return new bex((bfc) this.c, b);
    }

    public final void i(Integer num) {
        this.a = num;
    }

    public final void j(bfc bfcVar) {
        this.c = bfcVar;
    }

    public final void k(vk vkVar) {
        this.b = vkVar;
    }

    public final void l(vk vkVar) throws GeneralSecurityException {
        this.b = vkVar;
    }

    public /* synthetic */ bfe(byte[] bArr) {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public /* synthetic */ bfe(byte[] bArr, byte[] bArr2) {
        this.b = null;
        this.a = null;
        this.c = bfb.d;
    }

    public /* synthetic */ bfe(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.c = null;
        this.b = null;
        this.a = null;
    }
}
