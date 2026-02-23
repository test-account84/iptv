package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzeh implements zzhx {
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract zzeh clone();

    public abstract zzeh zzb(zzei zzeiVar);

    public final /* bridge */ /* synthetic */ zzhx zzc(zzhy zzhyVar) {
        if (zzX().getClass().isInstance(zzhyVar)) {
            return zzb((zzei) zzhyVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
