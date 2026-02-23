package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlr extends zzgo implements zzhz {
    private static final zzlr zzb;
    private zzlp zzd;
    private zzlp zze;

    static {
        zzlr zzlrVar = new zzlr();
        zzb = zzlrVar;
        zzgo.zzC(zzlr.class, zzlrVar);
    }

    private zzlr() {
    }

    public static /* synthetic */ zzlr zzi() {
        return zzb;
    }

    public static zzlr zzj(InputStream inputStream) throws IOException {
        return (zzlr) zzgo.zzt(zzb, inputStream);
    }

    public final zzlp zzf() {
        zzlp zzlpVar = this.zzd;
        return zzlpVar == null ? zzlp.zzg() : zzlpVar;
    }

    public final zzlp zzg() {
        zzlp zzlpVar = this.zze;
        return zzlpVar == null ? zzlp.zzg() : zzlpVar;
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzlr();
        }
        if (i2 == 4) {
            return new zzlq(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
