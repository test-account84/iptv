package com.onesignal;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class H {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(org.json.JSONArray r6, org.json.JSONArray r7) {
        /*
            r0 = 1
            if (r6 != 0) goto L6
            if (r7 != 0) goto L6
            return r0
        L6:
            r1 = 0
            if (r6 == 0) goto L48
            if (r7 != 0) goto Lc
            goto L48
        Lc:
            int r2 = r6.length()
            int r3 = r7.length()
            if (r2 == r3) goto L17
            return r1
        L17:
            r2 = 0
        L18:
            int r3 = r6.length()     // Catch: org.json.JSONException -> L41
            if (r2 >= r3) goto L44
            r3 = 0
        L1f:
            int r4 = r7.length()     // Catch: org.json.JSONException -> L41
            if (r3 >= r4) goto L43
            java.lang.Object r4 = r6.get(r2)     // Catch: org.json.JSONException -> L41
            java.lang.Object r4 = e(r4)     // Catch: org.json.JSONException -> L41
            java.lang.Object r5 = r7.get(r3)     // Catch: org.json.JSONException -> L41
            java.lang.Object r5 = e(r5)     // Catch: org.json.JSONException -> L41
            boolean r4 = r4.equals(r5)     // Catch: org.json.JSONException -> L41
            if (r4 == 0) goto L3e
            int r2 = r2 + 1
            goto L18
        L3e:
            int r3 = r3 + 1
            goto L1f
        L41:
            r6 = move-exception
            goto L45
        L43:
            return r1
        L44:
            return r0
        L45:
            r6.printStackTrace()
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.H.a(org.json.JSONArray, org.json.JSONArray):boolean");
    }

    public static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set set) {
        JSONObject jSONObject4;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject2 == null) {
            return jSONObject3;
        }
        Iterator keys = jSONObject2.keys();
        JSONObject jSONObject5 = jSONObject3 != null ? jSONObject3 : new JSONObject();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                Object obj = jSONObject2.get(str);
                if (jSONObject.has(str)) {
                    if (obj instanceof JSONObject) {
                        String jSONObject6 = b(jSONObject.getJSONObject(str), (JSONObject) obj, (jSONObject3 == null || !jSONObject3.has(str)) ? null : jSONObject3.getJSONObject(str), set).toString();
                        if (!jSONObject6.equals("{}")) {
                            jSONObject4 = new JSONObject(jSONObject6);
                            jSONObject5.put(str, jSONObject4);
                        }
                    } else if (obj instanceof JSONArray) {
                        d(str, (JSONArray) obj, jSONObject.getJSONArray(str), jSONObject5);
                    } else {
                        if (set == null || !set.contains(str)) {
                            Object obj2 = jSONObject.get(str);
                            if (!obj.equals(obj2) && (!(obj2 instanceof Number) || !(obj instanceof Number) || ((Number) obj2).doubleValue() != ((Number) obj).doubleValue())) {
                            }
                        }
                        jSONObject5.put(str, obj);
                    }
                } else if (obj instanceof JSONObject) {
                    jSONObject4 = new JSONObject(obj.toString());
                    jSONObject5.put(str, jSONObject4);
                } else if (obj instanceof JSONArray) {
                    d(str, (JSONArray) obj, null, jSONObject5);
                } else {
                    jSONObject5.put(str, obj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject5;
    }

    public static JSONObject c(E e, String str) {
        if (!e.a(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject e2 = e.e(str);
        Iterator keys = e2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            try {
                Object obj = e2.get(str2);
                if (!"".equals(obj)) {
                    jSONObject.put(str2, obj);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static void d(String str, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) {
        if (str.endsWith("_a") || str.endsWith("_d")) {
            jSONObject.put(str, jSONArray);
            return;
        }
        String f = f(jSONArray);
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        String f2 = jSONArray2 == null ? null : f(jSONArray2);
        for (int i = 0; i < jSONArray.length(); i++) {
            String str2 = (String) jSONArray.get(i);
            if (jSONArray2 == null || !f2.contains(str2)) {
                jSONArray3.put(str2);
            }
        }
        if (jSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                String string = jSONArray2.getString(i2);
                if (!f.contains(string)) {
                    jSONArray4.put(string);
                }
            }
        }
        if (!jSONArray3.toString().equals("[]")) {
            jSONObject.put(str + "_a", jSONArray3);
        }
        if (jSONArray4.toString().equals("[]")) {
            return;
        }
        jSONObject.put(str + "_d", jSONArray4);
    }

    public static Object e(Object obj) {
        Class cls = obj.getClass();
        return cls.equals(Integer.class) ? Long.valueOf(((Integer) obj).intValue()) : cls.equals(Float.class) ? Double.valueOf(((Float) obj).floatValue()) : obj;
    }

    public static String f(JSONArray jSONArray) {
        String str = "[";
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                str = str + "\"" + jSONArray.getString(i) + "\"";
            } catch (JSONException unused) {
            }
        }
        return str + "]";
    }

    public static String g(JSONObject jSONObject) {
        String group;
        String jSONObject2 = jSONObject.toString();
        if (!jSONObject.has("external_user_id")) {
            return jSONObject2;
        }
        Matcher matcher = Pattern.compile("(?<=\"external_user_id\":\").*?(?=\")").matcher(jSONObject2);
        return (!matcher.find() || (group = matcher.group(0)) == null) ? jSONObject2 : matcher.replaceAll(Matcher.quoteReplacement(group.replace("\\/", "/")));
    }
}
