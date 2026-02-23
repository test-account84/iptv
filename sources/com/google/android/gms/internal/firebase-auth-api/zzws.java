package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzws implements zzwy {
    private final zzxb zza;

    private zzws(zzxb zzxbVar) {
        this.zza = zzxbVar;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        Iterator it = zzwt.zza("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, (Provider) it.next());
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        return this.zza.zza(str, null);
    }

    public /* synthetic */ zzws(zzxb zzxbVar, zzwv zzwvVar) {
        this(zzxbVar);
    }
}
