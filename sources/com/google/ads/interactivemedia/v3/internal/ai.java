package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ai {
    public final String a;
    public final ad b;
    public final ac c;
    public final al d;
    public final x e;
    public final ag f;

    static {
        new v().a();
    }

    public /* synthetic */ ai(String str, y yVar, ae aeVar, ac acVar, al alVar, ag agVar) {
        this.a = str;
        this.b = aeVar;
        this.c = acVar;
        this.d = alVar;
        this.e = yVar;
        this.f = agVar;
    }

    public static ai a(Uri uri) {
        v vVar = new v();
        vVar.c(uri);
        return vVar.a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ai)) {
            return false;
        }
        ai aiVar = (ai) obj;
        return cq.V(this.a, aiVar.a) && this.e.equals(aiVar.e) && cq.V(this.b, aiVar.b) && cq.V(this.c, aiVar.c) && cq.V(this.d, aiVar.d) && cq.V(this.f, aiVar.f);
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        ad adVar = this.b;
        return (((((((hashCode + (adVar != null ? adVar.hashCode() : 0)) * 31) + this.c.hashCode()) * 31) + this.e.hashCode()) * 31) + this.d.hashCode()) * 31;
    }
}
