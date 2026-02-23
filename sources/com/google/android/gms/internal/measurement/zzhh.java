package com.google.android.gms.internal.measurement;

import android.net.Uri;
import s.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzhh {
    private final i zza;

    public zzhh(i iVar) {
        this.zza = iVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        i iVar;
        if (uri != null) {
            iVar = (i) this.zza.get(uri.toString());
        } else {
            iVar = null;
        }
        if (iVar == null) {
            return null;
        }
        return (String) iVar.get("".concat(str3));
    }
}
