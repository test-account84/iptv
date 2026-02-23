package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioAttributes;
import android.media.AudioFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ix {
    private static final AudioAttributes a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    public static int a(int i, int i2) {
        for (int i3 = 8; i3 > 0; i3--) {
            if (b1.a(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(cq.f(i3)).build(), a)) {
                return i3;
            }
        }
        return 0;
    }

    public static int[] b() {
        avk j = avo.j();
        axq e = iy.b().h().e();
        while (e.hasNext()) {
            Integer num = (Integer) e.next();
            if (b1.a(new AudioFormat.Builder().setChannelMask(12).setEncoding(num.intValue()).setSampleRate(48000).build(), a)) {
                j.g(num);
            }
        }
        j.g(2);
        return axy.c(j.f());
    }
}
