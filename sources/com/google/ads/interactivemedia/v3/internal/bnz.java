package com.google.ads.interactivemedia.v3.internal;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnz implements bkm {
    private final /* synthetic */ int a;

    public bnz(int i) {
        this.a = i;
    }

    public final bkl a(bjt bjtVar, bof bofVar) {
        int i = this.a;
        if (i == 0) {
            if (bofVar.c() == Time.class) {
                return new boa(null);
            }
            return null;
        }
        if (i != 1) {
            if (bofVar.c() == Timestamp.class) {
                return new bob(bjtVar.b(Date.class));
            }
            return null;
        }
        if (bofVar.c() == java.sql.Date.class) {
            return new bny(null);
        }
        return null;
    }
}
