package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bej {
    private static final bej a = new bej();
    private final AtomicReference b = new AtomicReference(new bev().f());

    public static bej b() {
        return a;
    }

    public final azu a(beq beqVar, bap bapVar) {
        try {
            try {
                return ((bev) this.b.get()).a(beqVar, bapVar);
            } catch (GeneralSecurityException e) {
                throw new bew((Throwable) e);
            }
        } catch (GeneralSecurityException unused) {
            return new bee(beqVar);
        }
    }

    public final synchronized void c(bdw bdwVar) throws GeneralSecurityException {
        bev bevVar = new bev((bev) this.b.get());
        bevVar.g(bdwVar);
        this.b.set(bevVar.f());
    }

    public final synchronized void d(bdy bdyVar) throws GeneralSecurityException {
        bev bevVar = new bev((bev) this.b.get());
        bevVar.h(bdyVar);
        this.b.set(bevVar.f());
    }

    public final synchronized void e(bel belVar) throws GeneralSecurityException {
        bev bevVar = new bev((bev) this.b.get());
        bevVar.i(belVar);
        this.b.set(bevVar.f());
    }

    public final synchronized void f(ben benVar) throws GeneralSecurityException {
        bev bevVar = new bev((bev) this.b.get());
        bevVar.j(benVar);
        this.b.set(bevVar.f());
    }
}
