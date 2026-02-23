package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class atk {
    private final String a;
    private final atj b;
    private atj c;

    public /* synthetic */ atk(String str) {
        atj atjVar = new atj(null);
        this.b = atjVar;
        this.c = atjVar;
        atp.k(str);
        this.a = str;
    }

    public final atk a(Object obj) {
        atj atjVar = new atj(null);
        this.c.b = atjVar;
        this.c = atjVar;
        atjVar.a = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        atj atjVar = this.b.b;
        String str = "";
        while (atjVar != null) {
            Object obj = atjVar.a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append(Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            atjVar = atjVar.b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
