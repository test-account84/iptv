package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbi implements zzcd {
    private final OutputStream zza;

    private zzbi(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzcd zza(OutputStream outputStream) {
        return new zzbi(outputStream);
    }

    public final void zza(zzua zzuaVar) throws IOException {
        try {
            zzuaVar.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    public final void zza(zzvg zzvgVar) throws IOException {
        try {
            zzvgVar.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
