package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class any {
    static azt a;

    public static void a(anw anwVar) throws IllegalAccessException, InvocationTargetException {
        Method i;
        if (a != null) {
            return;
        }
        String str = (String) aqo.t.f();
        if (str == null || str.length() == 0) {
            str = null;
            if (anwVar != null && (i = anwVar.i("JUzcgAa7QiZMDmYjeHwtF22qOBbojTFP/5L28xsdeCx9uYvsAo6FDNhapuA6bStH", "U55JZyt+fru+djXeCzNGPL143KELIHwp5RNEO07WiP4=")) != null) {
                str = (String) i.invoke((Object) null, (Object[]) null);
            }
            if (str == null) {
                return;
            }
        }
        try {
            bad a2 = bah.a(com.google.ads.interactivemedia.v3.impl.data.aq.b(str, true));
            for (bhu bhuVar : bcu.a.c()) {
                if (bhuVar.e().isEmpty()) {
                    throw new GeneralSecurityException("Missing type_url.");
                }
                if (bhuVar.d().isEmpty()) {
                    throw new GeneralSecurityException("Missing primitive_name.");
                }
                if (bhuVar.c().isEmpty()) {
                    throw new GeneralSecurityException("Missing catalogue_name.");
                }
                if (!bhuVar.c().equals("TinkAead") && !bhuVar.c().equals("TinkMac") && !bhuVar.c().equals("TinkHybridDecrypt") && !bhuVar.c().equals("TinkHybridEncrypt") && !bhuVar.c().equals("TinkPublicKeySign") && !bhuVar.c().equals("TinkPublicKeyVerify") && !bhuVar.c().equals("TinkStreamingAead") && !bhuVar.c().equals("TinkDeterministicAead")) {
                    azp a3 = bao.a(bhuVar.c());
                    bao.l(a3.a());
                    bhuVar.e();
                    bhuVar.d();
                    bhuVar.a();
                    bao.k(a3.b(), bhuVar.f());
                }
            }
            a = bcx.a(a2);
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
    }
}
