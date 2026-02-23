package V5;

import O5.t;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g {
    public final t a;

    public g(t tVar) {
        this.a = tVar;
    }

    public static h a(int i) {
        if (i == 3) {
            return new l();
        }
        L5.f.f().d("Could not determine SettingsJsonTransform for settings version " + i + ". Using default settings values.");
        return new b();
    }

    public d b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.a, jSONObject);
    }
}
