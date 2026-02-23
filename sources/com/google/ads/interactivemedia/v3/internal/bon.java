package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bon implements brs {
    protected int b = 0;

    public int at(bsi bsiVar) {
        throw null;
    }

    public final bpb au() {
        try {
            int ax = ax();
            bpb bpbVar = bpb.b;
            byte[] bArr = new byte[ax];
            bpk X = bpk.X(bArr);
            br(bpd.b(X));
            return bpd.a(X, bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] av() {
        try {
            byte[] bArr = new byte[ax()];
            bpk X = bpk.X(bArr);
            br(X);
            X.Y();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
