package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class baz extends beb {
    public baz() {
        super(bgj.class, new bax(biz.class));
    }

    public static /* bridge */ /* synthetic */ void g(baz bazVar, bgl bglVar) {
        m(bglVar);
    }

    private static final void m(bgl bglVar) throws GeneralSecurityException {
        if (bglVar.a() < 12 || bglVar.a() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final bea a() {
        return new bay(this, bgk.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bgj.d(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void e(bgj bgjVar) throws GeneralSecurityException {
        bjg.b(bgjVar.a());
        bjg.a(bgjVar.f().d());
        m(bgjVar.e());
    }
}
