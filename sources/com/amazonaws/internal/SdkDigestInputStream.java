package com.amazonaws.internal;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SdkDigestInputStream extends DigestInputStream implements MetricAware {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SKIP_BUF_SIZE = 2048;

    public SdkDigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream, messageDigest);
    }

    @Deprecated
    public final boolean isMetricActivated() {
        if (((DigestInputStream) this).in instanceof MetricAware) {
            return ((DigestInputStream) this).in.isMetricActivated();
        }
        return false;
    }

    public final long skip(long j) throws IOException {
        if (j <= 0) {
            return j;
        }
        int min = (int) Math.min(2048L, j);
        byte[] bArr = new byte[min];
        long j2 = j;
        while (j2 > 0) {
            int read = read(bArr, 0, (int) Math.min(j2, min));
            if (read == -1) {
                if (j2 == j) {
                    return -1L;
                }
                return j - j2;
            }
            j2 -= read;
        }
        return j;
    }
}
