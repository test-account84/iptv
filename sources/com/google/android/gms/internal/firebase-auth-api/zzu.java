package com.google.android.gms.internal.firebase-auth-api;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzu extends zzs implements Serializable {
    private final Pattern zza;

    public zzu(Pattern pattern) {
        this.zza = (Pattern) zzy.zza(pattern);
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final zzp zza(CharSequence charSequence) {
        return new zzt(this.zza.matcher(charSequence));
    }
}
