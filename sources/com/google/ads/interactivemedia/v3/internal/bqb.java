package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class bqb {
    static final bqb a = new bqb(null);
    public static final /* synthetic */ int b = 0;
    private static volatile boolean c = false;
    private static volatile bqb d;
    private final Map e;

    public bqb() {
        this.e = new HashMap();
    }

    public static bqb a() {
        return a;
    }

    public static bqb b() {
        bqb bqbVar = d;
        if (bqbVar != null) {
            return bqbVar;
        }
        synchronized (bqb.class) {
            try {
                bqb bqbVar2 = d;
                if (bqbVar2 != null) {
                    return bqbVar2;
                }
                bqb b2 = bqi.b(bqb.class);
                d = b2;
                return b2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public bpz c(brs brsVar, int i) {
        return (bpz) this.e.get(new bqa(brsVar, i));
    }

    public bqb(byte[] bArr) {
        this.e = Collections.emptyMap();
    }
}
