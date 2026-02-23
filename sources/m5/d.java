package M5;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d implements b, N5.b {
    public N5.a a;

    public static String b(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    public void a(N5.a aVar) {
        this.a = aVar;
        L5.f.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    public void onEvent(String str, Bundle bundle) {
        N5.a aVar = this.a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                L5.f.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
