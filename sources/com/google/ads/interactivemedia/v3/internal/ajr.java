package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.UiElement;
import java.net.MalformedURLException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ajr {
    private static final bjt a;
    private final ajp b;
    private final Object c;
    private final String d;
    private final ajq e;

    static {
        bju bjuVar = new bju();
        bjuVar.b(UiElement.class, com.google.ads.interactivemedia.v3.impl.data.cb.GSON_TYPE_ADAPTER);
        bjuVar.b(CompanionAdSlot.class, new ajo());
        bjuVar.c(new atg());
        a = bjuVar.a();
    }

    public ajr(ajp ajpVar, ajq ajqVar, String str) {
        this(ajpVar, ajqVar, str, null);
    }

    public static ajr c(String str) throws MalformedURLException {
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        if (path == null) {
            throw new MalformedURLException("URL must have message.");
        }
        String substring = path.substring(1);
        if (parse.getQueryParameter("sid") != null) {
            return new ajr(ajp.a(substring), ajq.a(parse.getQueryParameter("type")), parse.getQueryParameter("sid"), a.f(parse.getQueryParameter("data"), com.google.ads.interactivemedia.v3.impl.data.bm.class));
        }
        throw new MalformedURLException("Session id must be provided in message.");
    }

    public static ajr d(String str) {
        bjt bjtVar = a;
        com.google.ads.interactivemedia.v3.impl.data.bn bnVar = (com.google.ads.interactivemedia.v3.impl.data.bn) bjtVar.f(str, com.google.ads.interactivemedia.v3.impl.data.bn.class);
        if (bnVar.sid != null) {
            return new ajr(ajp.a(bnVar.name), ajq.a(bnVar.type), bnVar.sid, bjtVar.f(bnVar.data, com.google.ads.interactivemedia.v3.impl.data.bm.class));
        }
        throw new NullPointerException("Session id must be provided in message.");
    }

    public final ajp a() {
        return this.b;
    }

    public final ajq b() {
        return this.e;
    }

    public final Object e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ajr)) {
            return false;
        }
        ajr ajrVar = (ajr) obj;
        return this.b == ajrVar.b && com.google.ads.interactivemedia.v3.impl.data.k.c(this.c, ajrVar.c) && com.google.ads.interactivemedia.v3.impl.data.k.c(this.d, ajrVar.d) && this.e == ajrVar.e;
    }

    public final String f() {
        return this.d;
    }

    public final String g() {
        avq avqVar = new avq();
        avqVar.a("type", this.e);
        avq a2 = avqVar.a("sid", this.d);
        Object obj = this.c;
        if (obj != null) {
            a2.a("data", obj);
        }
        return String.format("%s('%s', %s);", new Object[]{"javascript:adsense.mobileads.afmanotify.receiveMessage", this.b, a.g(a2.b())});
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.e});
    }

    public final String toString() {
        return String.format("JavaScriptMessage [command=%s, type=%s, sid=%s, data=%s]", new Object[]{this.b, this.e, this.d, this.c});
    }

    public ajr(ajp ajpVar, ajq ajqVar, String str, Object obj) {
        this.b = ajpVar;
        this.e = ajqVar;
        this.d = str;
        this.c = obj;
    }
}
