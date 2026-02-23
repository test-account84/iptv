package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bev {
    private final Map a;
    private final Map b;
    private final Map c;
    private final Map d;

    public bev() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
    }

    public static /* bridge */ /* synthetic */ Map b(bev bevVar) {
        return bevVar.b;
    }

    public static /* bridge */ /* synthetic */ Map c(bev bevVar) {
        return bevVar.a;
    }

    public static /* bridge */ /* synthetic */ Map d(bev bevVar) {
        return bevVar.d;
    }

    public static /* bridge */ /* synthetic */ Map e(bev bevVar) {
        return bevVar.c;
    }

    public static /* bridge */ /* synthetic */ Map k(bev bevVar) {
        return bevVar.b;
    }

    public static /* bridge */ /* synthetic */ Map l(bev bevVar) {
        return bevVar.a;
    }

    public static /* bridge */ /* synthetic */ Map m(bev bevVar) {
        return bevVar.d;
    }

    public static /* bridge */ /* synthetic */ Map n(bev bevVar) {
        return bevVar.c;
    }

    public final azu a(bes besVar, bap bapVar) throws GeneralSecurityException {
        bet betVar = new bet(besVar.getClass(), besVar.d());
        if (this.b.containsKey(betVar)) {
            return ((bdw) this.b.get(betVar)).d(besVar, bapVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + betVar.toString() + " available");
    }

    public final bev f() {
        return new bev(this, null);
    }

    public final void g(bdw bdwVar) throws GeneralSecurityException {
        bet betVar = new bet(bdwVar.c(), bdwVar.b());
        if (!this.b.containsKey(betVar)) {
            this.b.put(betVar, bdwVar);
            return;
        }
        bdw bdwVar2 = (bdw) this.b.get(betVar);
        if (!bdwVar2.equals(bdwVar) || !bdwVar.equals(bdwVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(betVar.toString()));
        }
    }

    public final void h(bdy bdyVar) throws GeneralSecurityException {
        beu beuVar = new beu(bdyVar.b(), bdyVar.c());
        if (!this.a.containsKey(beuVar)) {
            this.a.put(beuVar, bdyVar);
            return;
        }
        bdy bdyVar2 = (bdy) this.a.get(beuVar);
        if (!bdyVar2.equals(bdyVar) || !bdyVar.equals(bdyVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(beuVar.toString()));
        }
    }

    public final void i(bel belVar) throws GeneralSecurityException {
        bet betVar = new bet(belVar.c(), belVar.b());
        if (!this.d.containsKey(betVar)) {
            this.d.put(betVar, belVar);
            return;
        }
        bel belVar2 = (bel) this.d.get(betVar);
        if (!belVar2.equals(belVar) || !belVar.equals(belVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(betVar.toString()));
        }
    }

    public final void j(ben benVar) throws GeneralSecurityException {
        beu beuVar = new beu(benVar.b(), benVar.c());
        if (!this.c.containsKey(beuVar)) {
            this.c.put(beuVar, benVar);
            return;
        }
        ben benVar2 = (ben) this.c.get(beuVar);
        if (!benVar2.equals(benVar) || !benVar.equals(benVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(beuVar.toString()));
        }
    }

    public bev(bev bevVar) {
        this.a = new HashMap(c(bevVar));
        this.b = new HashMap(b(bevVar));
        this.c = new HashMap(e(bevVar));
        this.d = new HashMap(d(bevVar));
    }

    public /* synthetic */ bev(bev bevVar, byte[] bArr) {
        this.a = new HashMap(l(bevVar));
        this.b = new HashMap(k(bevVar));
        this.c = new HashMap(n(bevVar));
        this.d = new HashMap(m(bevVar));
    }
}
