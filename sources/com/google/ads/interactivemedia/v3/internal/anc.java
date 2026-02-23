package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class anc extends anb {
    public anc(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static anc j(String str, Context context, boolean z) {
        anb.v(context, z);
        return new anc(context, str, z);
    }

    public final List p(anw anwVar, Context context, agl aglVar, afm afmVar) {
        if (anwVar.j() == null || !((anb) this).t) {
            return super.p(anwVar, context, aglVar, afmVar);
        }
        int a = anwVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.p(anwVar, context, aglVar, afmVar));
        arrayList.add(new aoo(anwVar, aglVar, a, null, null, null));
        return arrayList;
    }
}
