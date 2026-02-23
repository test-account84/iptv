package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class om implements cy {
    private final cy a;
    private final byte[] b;
    private final byte[] c;
    private CipherInputStream d;

    public om(cy cyVar, byte[] bArr, byte[] bArr2) {
        this.a = cyVar;
        this.b = bArr;
        this.c = bArr2;
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        af.s(this.d);
        int read = this.d.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    public final long b(dc dcVar) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(this.c));
                da daVar = new da(this.a, dcVar);
                this.d = new CipherInputStream(daVar, cipher);
                daVar.a();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final Uri c() {
        return this.a.c();
    }

    public final void d() throws IOException {
        if (this.d != null) {
            this.d = null;
            this.a.d();
        }
    }

    public final Map e() {
        return this.a.e();
    }

    public final void f(dw dwVar) {
        af.s(dwVar);
        this.a.f(dwVar);
    }
}
