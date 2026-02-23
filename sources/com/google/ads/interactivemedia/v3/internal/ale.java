package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ale implements hk {
    private final Context a;

    public ale(Context context) {
        this.a = context;
    }

    public final hh[] a(Handler handler, yi yiVar, jj jjVar) {
        Context context = this.a;
        rm rmVar = rm.b;
        re reVar = re.a;
        xr xrVar = new xr(context, reVar, rmVar, handler, yiVar);
        Context context2 = this.a;
        iy iyVar = iy.a;
        jb[] jbVarArr = new jb[0];
        ka kaVar = new ka();
        if (iyVar == null && iyVar == null) {
            throw new NullPointerException("Both parameters are null");
        }
        kaVar.c(iyVar);
        kaVar.e(new ui(jbVarArr));
        return new hh[]{xrVar, new kn(context2, reVar, rmVar, handler, jjVar, kaVar.b())};
    }
}
