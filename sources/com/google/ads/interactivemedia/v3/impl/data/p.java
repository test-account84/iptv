package com.google.ads.interactivemedia.v3.impl.data;

import android.os.Build;
import com.google.ads.interactivemedia.v3.internal.bew;
import com.google.ads.interactivemedia.v3.internal.bjj;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class p {
    public static final bjj a(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '!' || charAt > '~') {
                throw new bew("Not a printable ASCII character: " + charAt);
            }
            bArr[i] = (byte) charAt;
        }
        return bjj.b(bArr);
    }

    public static Integer b() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
