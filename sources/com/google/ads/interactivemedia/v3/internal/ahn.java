package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ahn {
    private static WindowManager b;
    private static final String[] c = {"x", "y", "width", "height"};
    static float a = Resources.getSystem().getDisplayMetrics().density;

    public static float a(int i) {
        return i / a;
    }

    public static JSONObject b(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(i));
            jSONObject.put("y", a(i2));
            jSONObject.put("width", a(i3));
            jSONObject.put("height", a(i4));
        } catch (JSONException e) {
            com.google.ads.interactivemedia.v3.impl.data.i.f("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    public static void c(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            com.google.ads.interactivemedia.v3.impl.data.i.f("Error with setting ad session id", e);
        }
    }

    public static void d(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void e(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e) {
            com.google.ads.interactivemedia.v3.impl.data.i.f("Error with setting not visible reason", e);
        }
    }

    public static void f(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            com.google.ads.interactivemedia.v3.impl.data.i.f("Error with setting not visible reason", e);
        }
    }

    public static void g(Context context) {
        if (context != null) {
            a = context.getResources().getDisplayMetrics().density;
            b = (WindowManager) context.getSystemService("window");
        }
    }

    public static void h(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException | NullPointerException e) {
            com.google.ads.interactivemedia.v3.impl.data.i.f("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    public static void i(JSONObject jSONObject) {
        float f;
        float f2;
        if (b != null) {
            Point point = new Point(0, 0);
            b.getDefaultDisplay().getRealSize(point);
            f = a(point.x);
            f2 = a(point.y);
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        ahm ahmVar = new ahm(f, f2);
        try {
            jSONObject.put("width", ahmVar.a);
            jSONObject.put("height", ahmVar.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean j(org.json.JSONObject r9, org.json.JSONObject r10) {
        /*
            r0 = 1
            if (r9 != 0) goto L7
            if (r10 == 0) goto L6
            goto L7
        L6:
            return r0
        L7:
            r1 = 0
            if (r9 == 0) goto Lab
            if (r10 != 0) goto Le
            goto Lab
        Le:
            java.lang.String[] r2 = com.google.ads.interactivemedia.v3.internal.ahn.c
            r3 = 0
        L11:
            r4 = 4
            if (r3 >= r4) goto L27
            r4 = r2[r3]
            double r5 = r9.optDouble(r4)
            double r7 = r10.optDouble(r4)
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 == 0) goto L24
            goto Lab
        L24:
            int r3 = r3 + 1
            goto L11
        L27:
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r9.optString(r2, r3)
            java.lang.String r2 = r10.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto Lab
            java.lang.String r2 = "hasWindowFocus"
            boolean r4 = r9.optBoolean(r2)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r2 = r10.optBoolean(r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto Lab
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r9.optJSONArray(r2)
            org.json.JSONArray r2 = r10.optJSONArray(r2)
            if (r4 != 0) goto L60
            if (r2 != 0) goto L60
            goto L7e
        L60:
            boolean r5 = l(r4, r2)
            if (r5 == 0) goto Lab
            r5 = 0
        L67:
            int r6 = r4.length()
            if (r5 >= r6) goto L7e
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto Lab
            int r5 = r5 + 1
            goto L67
        L7e:
            java.lang.String r2 = "childViews"
            org.json.JSONArray r9 = r9.optJSONArray(r2)
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            if (r9 != 0) goto L8c
            if (r10 == 0) goto Laa
        L8c:
            boolean r2 = l(r9, r10)
            if (r2 == 0) goto Lab
            r2 = 0
        L93:
            int r3 = r9.length()
            if (r2 >= r3) goto Laa
            org.json.JSONObject r3 = r9.optJSONObject(r2)
            org.json.JSONObject r4 = r10.optJSONObject(r2)
            boolean r3 = j(r3, r4)
            if (r3 == 0) goto Lab
            int r2 = r2 + 1
            goto L93
        Laa:
            return r0
        Lab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ahn.j(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    public static void k(JSONObject jSONObject, aeq aeqVar) {
        ly g = aeqVar.g();
        JSONArray jSONArray = new JSONArray();
        ArrayList e = aeqVar.e();
        int size = e.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put((String) e.get(i));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", g.h());
            jSONObject.put("friendlyObstructionPurpose", g.f());
            jSONObject.put("friendlyObstructionReason", g.g());
        } catch (JSONException e2) {
            com.google.ads.interactivemedia.v3.impl.data.i.f("Error with setting friendly obstruction", e2);
        }
    }

    private static boolean l(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
