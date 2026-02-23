package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzww implements zzwy {
    private final zzxb zza;

    private zzww(zzxb zzxbVar) {
        this.zza = zzxbVar;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        Iterator it = zzwt.zza("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
        Throwable th = null;
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, (Provider) it.next());
            } catch (Exception e) {
                if (th == null) {
                    th = e;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", th);
    }

    public /* synthetic */ zzww(zzxb zzxbVar, zzwz zzwzVar) {
        this(zzxbVar);
    }
}
