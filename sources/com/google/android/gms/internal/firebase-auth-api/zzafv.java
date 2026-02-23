package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafv {
    private List zza;

    public zzafv() {
        this.zza = new ArrayList();
    }

    public static zzafv zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzafv(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(jSONObject == null ? new zzafs() : new zzafs(o.a(jSONObject.optString("federatedId", (String) null)), o.a(jSONObject.optString("displayName", (String) null)), o.a(jSONObject.optString("photoUrl", (String) null)), o.a(jSONObject.optString("providerId", (String) null)), null, o.a(jSONObject.optString("phoneNumber", (String) null)), o.a(jSONObject.optString("email", (String) null))));
        }
        return new zzafv(arrayList);
    }

    private zzafv(List list) {
        this.zza = !list.isEmpty() ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public final List zza() {
        return this.zza;
    }
}
