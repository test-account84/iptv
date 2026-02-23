package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class bqk extends bqj implements brt {
    public bqk(bql bqlVar) {
        super(bqlVar);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final bql aZ() {
        bqn aZ;
        if (((bql) this.a).aO()) {
            ((bql) this.a).a.i();
            aZ = super.aZ();
        } else {
            aZ = this.a;
        }
        return (bql) aZ;
    }

    public final void bc() {
        super.bc();
        if (((bql) this.a).a != bqe.e()) {
            bql bqlVar = (bql) this.a;
            bqlVar.a = bqlVar.a.clone();
        }
    }
}
