package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ad {
    public final Uri a;
    public final aa c;
    public final List e;
    public final avo g;
    public final Object h;
    public final String b = null;
    public final u d = null;
    public final String f = null;

    public /* synthetic */ ad(Uri uri, aa aaVar, List list, avo avoVar) {
        this.a = uri;
        this.c = aaVar;
        this.e = list;
        this.g = avoVar;
        avk j = avo.j();
        if (avoVar.size() > 0) {
            throw null;
        }
        j.f();
        this.h = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return this.a.equals(adVar.a) && cq.V(null, null) && cq.V(this.c, adVar.c) && cq.V(null, null) && this.e.equals(adVar.e) && cq.V(null, null) && this.g.equals(adVar.g) && cq.V(null, null);
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode() * 961;
        aa aaVar = this.c;
        return (((((hashCode + (aaVar == null ? 0 : aaVar.hashCode())) * 961) + this.e.hashCode()) * 961) + this.g.hashCode()) * 31;
    }
}
