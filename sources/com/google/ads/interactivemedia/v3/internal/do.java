package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class do extends cz {
    public final int b;

    public do() {
        super(b(2008, 1));
        this.b = 1;
    }

    public static do a(IOException iOException, dc dcVar, int i) {
        String message = iOException.getMessage();
        int i2 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !com.google.ads.interactivemedia.v3.impl.data.k.d(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i2 == 2007 ? new dn(iOException, dcVar) : new do(iOException, i2, i);
    }

    private static int b(int i, int i2) {
        return i == 2000 ? i2 != 1 ? 2000 : 2001 : i;
    }

    public do(IOException iOException, int i, int i2) {
        super(iOException, b(i, i2));
        this.b = i2;
    }

    public do(String str, IOException iOException, int i) {
        super(str, iOException, b(i, 1));
        this.b = 1;
    }
}
