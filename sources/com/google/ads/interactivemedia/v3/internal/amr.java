package com.google.ads.interactivemedia.v3.internal;

import java.io.File;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class amr implements asu {
    final /* synthetic */ arl a;

    public amr(arl arlVar) {
        this.a = arlVar;
    }

    public final boolean a(File file) {
        try {
            return this.a.a(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
