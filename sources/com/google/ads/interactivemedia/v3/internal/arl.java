package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.Arrays;

@Hide
@VisibleForTesting
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class arl {

    @VisibleForTesting
    protected static final byte[] a = {61, 122, 18, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, 63, 50, 108, -113, -103, 74};

    @VisibleForTesting
    protected static final byte[] b = {-110, -13, -34, 70, -83, 43, 97, 21, -44, 16, -54, -125, -28, -57, -125, -127, -7, 17, 102, -69, 116, -121, -79, 43, -13, 120, 58, 55, -29, -108, 95, 83};
    private final byte[] c = b;
    private final byte[] d = a;

    public final boolean a(File file) throws GeneralSecurityException {
        try {
            Certificate[][] e = afe.e(file.getAbsolutePath());
            if (e.length != 1) {
                throw new GeneralSecurityException("APK has more than one signature.");
            }
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(e[0][0].getEncoded());
            if (Arrays.equals(this.d, digest)) {
                return true;
            }
            return !"user".equals(Build.TYPE) && Arrays.equals(this.c, digest);
        } catch (afb e2) {
            throw new GeneralSecurityException("Package is not signed", e2);
        } catch (RuntimeException e3) {
            e = e3;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        } catch (IOException e4) {
            e = e4;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        }
    }
}
