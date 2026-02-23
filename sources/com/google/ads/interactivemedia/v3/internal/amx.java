package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import h4.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class amx extends anb {
    private a.a w;

    public amx(Context context) {
        super(context);
    }

    public static amx j(Context context) {
        anb.v(context, true);
        return new amx(context);
    }

    public final agl c(Context context, View view, Activity activity) {
        return null;
    }

    public final agl i(Context context, View view, Activity activity) {
        return null;
    }

    public final String m(String str, String str2) {
        byte[] e = amc.e(str, str2);
        return e != null ? com.google.ads.interactivemedia.v3.impl.data.aq.a(e, true) : Integer.toString(7);
    }

    public final void o(a.a aVar) {
        this.w = aVar;
    }

    public final List p(anw anwVar, Context context, agl aglVar, afm afmVar) {
        ArrayList arrayList = new ArrayList();
        if (anwVar.j() == null) {
            return arrayList;
        }
        arrayList.add(new aoo(anwVar, aglVar, anwVar.a(), null, null, null));
        return arrayList;
    }

    public final void r(anw anwVar, Context context, agl aglVar, afm afmVar) {
        if (!anwVar.b) {
            anb.w(p(anwVar, context, aglVar, afmVar));
            return;
        }
        a.a aVar = this.w;
        if (aVar != null) {
            String a = aVar.a();
            if (!TextUtils.isEmpty(a)) {
                aglVar.ab(aoa.d(a));
                aglVar.aL(aft.f);
                aglVar.aa(this.w.b());
            }
            this.w = null;
        }
    }
}
