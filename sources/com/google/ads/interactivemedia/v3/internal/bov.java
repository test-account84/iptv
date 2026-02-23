package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bov extends boz {
    private static final long serialVersionUID = 1;
    private final int c;
    private final int d;

    public bov(byte[] bArr, int i, int i2) {
        super(bArr);
        bpb.q(i, i + i2, bArr.length);
        this.c = i;
        this.d = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    public final byte a(int i) {
        bpb.z(i, this.d);
        return this.a[this.c + i];
    }

    public final byte b(int i) {
        return this.a[this.c + i];
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final void e(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, this.c + i, bArr, i2, i3);
    }

    public Object writeReplace() {
        return bpb.x(B());
    }
}
