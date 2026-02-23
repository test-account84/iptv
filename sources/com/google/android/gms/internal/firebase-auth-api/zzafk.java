package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzafk implements zzacs {
    private static final String zza = "zzafk";
    private String zzb;
    private zzap zzc;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzafk zza(String str) throws zzaaf {
        zzap zza2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = o.a(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    zza2 = zzap.zza((Collection) new ArrayList());
                } else {
                    zzao zzg = zzap.zzg();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        zzg.zza(jSONObject2 == null ? zzafu.zza(null, null) : zzafu.zza(o.a(jSONObject2.optString("provider")), o.a(jSONObject2.optString("enforcementState"))));
                    }
                    zza2 = zzg.zza();
                }
                this.zzc = zza2;
            }
            return this;
        } catch (NullPointerException e) {
            e = e;
            throw zzahc.zza((Exception) e, zza, str);
        } catch (JSONException e2) {
            e = e2;
            throw zzahc.zza((Exception) e, zza, str);
        }
    }

    public final boolean zzb(String str) {
        zzap zzapVar = this.zzc;
        if (zzapVar != null && !zzapVar.isEmpty()) {
            zzap zzapVar2 = this.zzc;
            int size = zzapVar2.size();
            int i = 0;
            while (i < size) {
                Object obj = zzapVar2.get(i);
                i++;
                zzafu zzafuVar = (zzafu) obj;
                String zza2 = zzafuVar.zza();
                String zzb = zzafuVar.zzb();
                if (zza2 != null && zzb != null && (zza2.equals("ENFORCE") || zza2.equals("AUDIT"))) {
                    if (zzb.equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final String zza() {
        return this.zzb;
    }
}
