package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzafd implements zzacs {
    private static final String zza = "zzafd";
    private zzaff zzb;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzafd zza(String str) throws zzaaf {
        zzaff zzaffVar;
        int i;
        zzafc zzafcVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("users")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    zzaffVar = new zzaff(new ArrayList());
                } else {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    boolean z = false;
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        if (jSONObject2 == null) {
                            zzafcVar = new zzafc();
                            i = i2;
                        } else {
                            i = i2;
                            zzafcVar = new zzafc(o.a(jSONObject2.optString("localId", (String) null)), o.a(jSONObject2.optString("email", (String) null)), jSONObject2.optBoolean("emailVerified", z), o.a(jSONObject2.optString("displayName", (String) null)), o.a(jSONObject2.optString("photoUrl", (String) null)), zzafv.zza(jSONObject2.optJSONArray("providerUserInfo")), o.a(jSONObject2.optString("rawPassword", (String) null)), o.a(jSONObject2.optString("phoneNumber", (String) null)), jSONObject2.optLong("createdAt", 0L), jSONObject2.optLong("lastLoginAt", 0L), false, null, zzafr.zza(jSONObject2.optJSONArray("mfaInfo")), zzafq.zza(jSONObject2.optJSONArray("passkeyInfo")));
                        }
                        arrayList.add(zzafcVar);
                        i2 = i + 1;
                        z = false;
                    }
                    zzaffVar = new zzaff(arrayList);
                }
            } else {
                zzaffVar = new zzaff();
            }
            this.zzb = zzaffVar;
            return this;
        } catch (JSONException e) {
            e = e;
            throw zzahc.zza((Exception) e, zza, str);
        } catch (NullPointerException e2) {
            e = e2;
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final List zza() {
        return this.zzb.zza();
    }
}
