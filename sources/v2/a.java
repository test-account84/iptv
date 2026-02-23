package V2;

import d4.k0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    public static byte[] a(byte[] bArr) {
        return k0.a >= 27 ? bArr : k0.s0(c(k0.E(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (k0.a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(k0.E(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return k0.s0(sb.toString());
        } catch (JSONException e) {
            d4.B.e("ClearKeyUtil", "Failed to adjust response data: " + k0.E(bArr), e);
            return bArr;
        }
    }

    public static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    public static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
