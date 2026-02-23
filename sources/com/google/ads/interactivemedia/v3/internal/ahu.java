package com.google.ads.interactivemedia.v3.internal;

import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ahu extends ahv {
    protected final HashSet a;
    protected final JSONObject b;
    protected final long c;

    public ahu(aly alyVar, HashSet hashSet, JSONObject jSONObject, long j, byte[] bArr) {
        super(alyVar, null);
        this.a = new HashSet(hashSet);
        this.b = jSONObject;
        this.c = j;
    }
}
