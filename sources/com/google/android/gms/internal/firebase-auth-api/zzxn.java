package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzxn extends ThreadLocal {
    private final /* synthetic */ zzxk zza;

    public zzxn(zzxk zzxkVar) {
        this.zza = zzxkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            Mac mac = (Mac) zzwt.zzb.zza(zzxk.zza(this.zza));
            mac.init(zzxk.zzb(this.zza));
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
