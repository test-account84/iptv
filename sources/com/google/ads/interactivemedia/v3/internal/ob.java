package com.google.ads.interactivemedia.v3.internal;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface ob {
    int a();

    ea b(byte[] bArr) throws MediaCryptoException;

    Map c(byte[] bArr);

    void d(byte[] bArr);

    void e(byte[] bArr) throws DeniedByServerException;

    void f();

    void g(byte[] bArr, byte[] bArr2);

    void h(oa oaVar);

    void i(byte[] bArr, iw iwVar);

    boolean j(byte[] bArr, String str);

    byte[] k() throws MediaDrmException;

    byte[] l(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    zo m();

    aeq n(byte[] bArr, List list, int i, HashMap hashMap) throws NotProvisionedException;
}
