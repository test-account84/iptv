package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfj {
    private Integer a;
    private Integer b;
    private bfk c;
    private bfl d;

    private bfj() {
        this.a = null;
        this.b = null;
        this.c = null;
        throw null;
    }

    public final bfm a() throws GeneralSecurityException {
        Integer num = this.a;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.b == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.c == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", new Object[]{this.a}));
        }
        Integer num2 = this.b;
        int intValue = num2.intValue();
        bfk bfkVar = this.c;
        if (intValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{num2}));
        }
        if (bfkVar == bfk.a) {
            if (intValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{num2}));
            }
        } else if (bfkVar == bfk.b) {
            if (intValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{num2}));
            }
        } else if (bfkVar == bfk.c) {
            if (intValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{num2}));
            }
        } else if (bfkVar == bfk.d) {
            if (intValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{num2}));
            }
        } else {
            if (bfkVar != bfk.e) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (intValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{num2}));
            }
        }
        return new bfm(this.a.intValue(), this.b.intValue(), this.d, this.c);
    }

    public final void b(bfk bfkVar) {
        this.c = bfkVar;
    }

    public final void c(int i) throws GeneralSecurityException {
        this.a = Integer.valueOf(i);
    }

    public final void d(int i) throws GeneralSecurityException {
        this.b = Integer.valueOf(i);
    }

    public final void e(bfl bflVar) {
        this.d = bflVar;
    }

    public /* synthetic */ bfj(byte[] bArr) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = bfl.d;
    }
}
