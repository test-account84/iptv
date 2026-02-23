package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.BitSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bni extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        BitSet bitSet = new BitSet();
        bohVar.i();
        int r = bohVar.r();
        int i = 0;
        while (r != 2) {
            int i2 = r - 1;
            if (i2 == 5 || i2 == 6) {
                int b = bohVar.b();
                if (b != 0) {
                    if (b != 1) {
                        throw new bkf("Invalid bitset value " + b + ", expected 0 or 1; at path " + bohVar.f());
                    }
                    bitSet.set(i);
                } else {
                    continue;
                }
            } else {
                if (i2 != 7) {
                    throw new bkf("Invalid bitset value type: " + boi.a(r) + "; at path " + bohVar.e());
                }
                if (bohVar.q()) {
                    bitSet.set(i);
                }
            }
            i++;
            r = bohVar.r();
        }
        bohVar.k();
        return bitSet;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        bojVar.b();
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            bojVar.i(bitSet.get(i) ? 1L : 0L);
        }
        bojVar.d();
    }
}
