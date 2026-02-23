package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class beq implements bes {
    private final String a;
    private final bjj b;
    private final bpb c;
    private final bhq d;
    private final bid e;
    private final Integer f;

    private beq(String str, bpb bpbVar, bhq bhqVar, bid bidVar, Integer num) {
        this.a = str;
        this.b = com.google.ads.interactivemedia.v3.impl.data.p.a(str);
        this.c = bpbVar;
        this.d = bhqVar;
        this.e = bidVar;
        this.f = num;
    }

    public static beq a(String str, bpb bpbVar, bhq bhqVar, bid bidVar, Integer num) throws GeneralSecurityException {
        if (bidVar == bid.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new beq(str, bpbVar, bhqVar, bidVar, num);
    }

    public final bhq b() {
        return this.d;
    }

    public final bid c() {
        return this.e;
    }

    public final bjj d() {
        return this.b;
    }

    public final bpb e() {
        return this.c;
    }

    public final Integer f() {
        return this.f;
    }

    public final String g() {
        return this.a;
    }
}
