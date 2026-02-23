package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class oo implements ox {
    private static final int[] b = {8, 13, 11, 2, 0, 1, 7};

    private static void b(int i, List list) {
        int[] iArr = b;
        for (int i2 = 0; i2 < 7; i2++) {
            if (iArr[i2] == i) {
                Integer valueOf = Integer.valueOf(i);
                if (list.contains(valueOf)) {
                    return;
                }
                list.add(valueOf);
                return;
            }
        }
    }

    private static boolean c(zh zhVar, zi ziVar) throws IOException {
        try {
            boolean C = zhVar.C(ziVar);
            ziVar.h();
            return C;
        } catch (EOFException unused) {
            ziVar.h();
            return false;
        } catch (Throwable th) {
            ziVar.h();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.on a(android.net.Uri r18, com.google.ads.interactivemedia.v3.internal.s r19, java.util.List r20, com.google.ads.interactivemedia.v3.internal.co r21, java.util.Map r22, com.google.ads.interactivemedia.v3.internal.zi r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.oo.a(android.net.Uri, com.google.ads.interactivemedia.v3.internal.s, java.util.List, com.google.ads.interactivemedia.v3.internal.co, java.util.Map, com.google.ads.interactivemedia.v3.internal.zi):com.google.ads.interactivemedia.v3.internal.on");
    }
}
