package com.google.android.gms.internal.firebase-auth-api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbj implements zzca {
    private final InputStream zza;

    private zzbj(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzca zza(byte[] bArr) {
        return new zzbj(new ByteArrayInputStream(bArr));
    }

    public final zzvg zzb() throws IOException {
        try {
            return zzvg.zza(this.zza, zzaio.zza());
        } finally {
            this.zza.close();
        }
    }

    public final zzua zza() throws IOException {
        try {
            return zzua.zza(this.zza, zzaio.zza());
        } finally {
            this.zza.close();
        }
    }
}
