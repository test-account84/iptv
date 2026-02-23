package com.google.android.gms.internal.firebase-auth-api;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzafi implements zzacs {
    private static final String zza = "zzafi";
    private List zzb;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzafi zza(String str) throws zzaaf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.zzb.add(optJSONArray.getString(i));
                }
            }
            return this;
        } catch (JSONException e) {
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final List zza() {
        return this.zzb;
    }
}
