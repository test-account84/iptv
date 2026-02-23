package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ans implements asy {
    private final arw a;
    private final asg b;
    private final aod c;
    private final anr d;
    private final anh e;
    private final aof f;
    private final anx g;

    public ans(arw arwVar, asg asgVar, aod aodVar, anr anrVar, anh anhVar, aof aofVar, anx anxVar) {
        this.a = arwVar;
        this.b = asgVar;
        this.c = aodVar;
        this.d = anrVar;
        this.e = anhVar;
        this.f = aofVar;
        this.g = anxVar;
    }

    private final Map e() {
        HashMap hashMap = new HashMap();
        agc b = this.b.b();
        hashMap.put("v", this.a.b());
        hashMap.put("gms", Boolean.valueOf(this.a.c()));
        hashMap.put("int", b.f());
        hashMap.put("up", Boolean.valueOf(this.d.a()));
        hashMap.put("t", new Throwable());
        anx anxVar = this.g;
        if (anxVar != null) {
            hashMap.put("tcq", Long.valueOf(anxVar.c()));
            hashMap.put("tpq", Long.valueOf(this.g.g()));
            hashMap.put("tcv", Long.valueOf(this.g.d()));
            hashMap.put("tpv", Long.valueOf(this.g.h()));
            hashMap.put("tchv", Long.valueOf(this.g.b()));
            hashMap.put("tphv", Long.valueOf(this.g.f()));
            hashMap.put("tcc", Long.valueOf(this.g.a()));
            hashMap.put("tpc", Long.valueOf(this.g.e()));
        }
        return hashMap;
    }

    public final Map a() {
        Map e = e();
        e.put("lts", Long.valueOf(this.c.a()));
        return e;
    }

    public final Map b() {
        Map e = e();
        agc a = this.b.a();
        e.put("gai", Boolean.valueOf(this.a.d()));
        e.put("did", a.e());
        e.put("dst", Integer.valueOf(aft.b(a.al())));
        e.put("doo", Boolean.valueOf(a.ai()));
        anh anhVar = this.e;
        if (anhVar != null) {
            e.put("nt", Long.valueOf(anhVar.a()));
        }
        aof aofVar = this.f;
        if (aofVar != null) {
            e.put("vs", Long.valueOf(aofVar.c()));
            e.put("vf", Long.valueOf(this.f.b()));
        }
        return e;
    }

    public final Map c() {
        return e();
    }

    public final void d(View view) {
        this.c.d(view);
    }
}
