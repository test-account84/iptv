package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.InetAddress;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnc extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() != 9) {
            return InetAddress.getByName(bohVar.h());
        }
        bohVar.m();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        InetAddress inetAddress = (InetAddress) obj;
        bojVar.l(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
