package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class oh implements oj {
    private final cx a;
    private final String b;
    private final Map c;

    public oh(String str, cx cxVar) {
        af.u(true);
        this.a = cxVar;
        this.b = null;
        this.c = new HashMap();
    }

    private static byte[] d(cx cxVar, String str, byte[] bArr, Map map) throws ok {
        Map map2;
        List list;
        dv dvVar = new dv(((dg) cxVar).a());
        db dbVar = new db();
        dbVar.j(str);
        dbVar.e(map);
        dbVar.d();
        dbVar.c(bArr);
        dbVar.b(1);
        dc a = dbVar.a();
        int i = 0;
        dc dcVar = a;
        int i2 = 0;
        while (true) {
            try {
                da daVar = new da(dvVar, dcVar);
                try {
                    return cq.ae(daVar);
                } catch (dq e) {
                    int i3 = e.c;
                    String str2 = null;
                    if ((i3 == 307 || i3 == 308) && i2 < 5 && (map2 = e.d) != null && (list = (List) map2.get("Location")) != null && !list.isEmpty()) {
                        str2 = (String) list.get(i);
                    }
                    if (str2 == null) {
                        throw e;
                    }
                    i2++;
                    db a2 = dcVar.a();
                    a2.j(str2);
                    dcVar = a2.a();
                } finally {
                    cq.S(daVar);
                }
            } catch (Exception e2) {
                Uri h = dvVar.h();
                af.s(h);
                throw new ok(a, h, dvVar.e(), dvVar.g(), e2);
            }
        }
    }

    public final void a(String str, String str2) {
        af.s(str);
        af.s(str2);
        synchronized (this.c) {
            this.c.put(str, str2);
        }
    }

    public final byte[] b(zo zoVar) throws ok {
        return d(this.a, zoVar.d() + "&signedRequest=" + cq.I(zoVar.e()), null, Collections.emptyMap());
    }

    public final byte[] c(UUID uuid, aeq aeqVar) throws ok {
        CharSequence h = aeqVar.h();
        if (TextUtils.isEmpty(h)) {
            h = null;
        }
        if (TextUtils.isEmpty(h)) {
            db dbVar = new db();
            Uri uri = Uri.EMPTY;
            dbVar.i(uri);
            throw new ok(dbVar.a(), uri, avs.d(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = i.e;
        hashMap.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : i.c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.c) {
            hashMap.putAll(this.c);
        }
        return d(this.a, h, aeqVar.i(), hashMap);
    }
}
