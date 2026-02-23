package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ahz extends ahu {
    public ahz(aly alyVar, HashSet hashSet, JSONObject jSONObject, long j, byte[] bArr) {
        super(alyVar, hashSet, jSONObject, j, null);
    }

    public final void a(String str) {
        agz a;
        if (!TextUtils.isEmpty(str) && (a = agz.a()) != null) {
            for (agt agtVar : a.c()) {
                if (((ahu) this).a.contains(agtVar.i())) {
                    agtVar.h().e(str, this.c);
                }
            }
        }
        super.onPostExecute(str);
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (ahn.j(this.b, this.d.c())) {
            return null;
        }
        this.d.g(this.b);
        return this.b.toString();
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }
}
