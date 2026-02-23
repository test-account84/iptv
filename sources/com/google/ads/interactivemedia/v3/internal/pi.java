package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class pi {
    public pi(qg qgVar) {
        int i = px.a;
        new qg(qgVar.t, qgVar.u, qgVar.c, qgVar.d, qgVar.e, qgVar.f, qgVar.g, qgVar.h, qgVar.i, qgVar.v, qgVar.j, qgVar.k);
    }

    public static Pair a(nm nmVar) {
        Map d = nmVar.d();
        if (d == null) {
            return null;
        }
        return new Pair(Long.valueOf(f(d, "LicenseDurationRemaining")), Long.valueOf(f(d, "PlaybackDurationRemaining")));
    }

    public static /* synthetic */ void b(AtomicReference atomicReference, Object obj) {
        while (!z1.a(atomicReference, null, obj) && atomicReference.get() == null) {
        }
    }

    public static void c(nm nmVar, nm nmVar2) {
        if (nmVar == nmVar2) {
            return;
        }
        if (nmVar2 != null) {
            nmVar2.h(null);
        }
        if (nmVar != null) {
            nmVar.m(null);
        }
    }

    public static byte[] d(byte[] bArr) {
        if (cq.a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(cq.I(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(g(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(g(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return cq.ad(sb.toString());
        } catch (JSONException e) {
            cd.c("ClearKeyUtil", "Failed to adjust response data: ".concat(cq.I(bArr)), e);
            return bArr;
        }
    }

    public static dc e(me meVar, String str, mb mbVar, int i) {
        db dbVar = new db();
        dbVar.i(mbVar.a(str));
        dbVar.h(mbVar.a);
        dbVar.g(mbVar.b);
        meVar.m();
        dbVar.f(mbVar.a(((lt) meVar.c.get(0)).a).toString());
        dbVar.b(i);
        return dbVar.a();
    }

    private static long f(Map map, String str) {
        try {
            String str2 = (String) map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    private static String g(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
