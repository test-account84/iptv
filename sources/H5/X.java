package H5;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.firebase-auth-api.zzab;
import com.google.android.gms.internal.firebase-auth-api.zzxw;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class x {
    public static final A4.a a = new A4.a("JSONParser", new String[0]);

    public static List a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = c((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map b(String str) {
        com.google.android.gms.common.internal.r.g(str);
        List zza = zzab.zza('.').zza((CharSequence) str);
        if (zza.size() < 2) {
            a.c("Invalid idToken " + str, new Object[0]);
            return new HashMap();
        }
        try {
            Map d = d(new String(C4.c.b((String) zza.get(1)), "UTF-8"));
            return d == null ? new HashMap() : d;
        } catch (UnsupportedEncodingException e) {
            a.b("Unable to decode token", e, new Object[0]);
            return new HashMap();
        }
    }

    public static Map c(JSONObject jSONObject) {
        s.a aVar = new s.a();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = c((JSONObject) obj);
            }
            aVar.put(str, obj);
        }
        return aVar;
    }

    public static Map d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return c(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzxw(e);
        }
    }
}
