package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bjb extends ThreadLocal {
    final /* synthetic */ bjc a;

    public bjb(bjc bjcVar) {
        this.a = bjcVar;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            Mac mac = (Mac) biv.b.a(bjc.b(this.a));
            mac.init(bjc.c(this.a));
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
