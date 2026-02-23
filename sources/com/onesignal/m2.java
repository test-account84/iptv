package com.onesignal;

import com.onesignal.O;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class m2 {
    public static final Object d = new Object();
    public static final String[] e;
    public static final Set f;
    public String a;
    public JSONObject b;
    public JSONObject c;

    static {
        String[] strArr = {"lat", "long", "loc_acc", "loc_type", "loc_bg", "loc_time_stamp"};
        e = strArr;
        f = new HashSet(Arrays.asList(strArr));
    }

    public m2(String str, boolean z) {
        this.a = str;
        if (z) {
            n();
        } else {
            this.b = new JSONObject();
            this.c = new JSONObject();
        }
    }

    public static JSONObject e(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set set) {
        JSONObject b;
        synchronized (d) {
            b = H.b(jSONObject, jSONObject2, jSONObject3, set);
        }
        return b;
    }

    public abstract void a();

    public void b() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("lat", (Object) null);
            hashMap.put("long", (Object) null);
            hashMap.put("loc_acc", (Object) null);
            hashMap.put("loc_type", (Object) null);
            hashMap.put("loc_bg", (Object) null);
            hashMap.put("loc_time_stamp", (Object) null);
            u(this.c, hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("loc_bg", (Object) null);
            hashMap2.put("loc_time_stamp", (Object) null);
            u(this.b, hashMap2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public m2 c(String str) {
        m2 p = p(str);
        try {
            p.b = j();
            p.c = m();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return p;
    }

    public JSONObject d(m2 m2Var, boolean z) {
        a();
        m2Var.a();
        JSONObject e2 = e(this.c, m2Var.c, null, k(m2Var));
        if (!z && e2.toString().equals("{}")) {
            return null;
        }
        try {
            if (!e2.has("app_id")) {
                e2.put("app_id", this.c.optString("app_id"));
            }
            if (this.c.has("email_auth_hash")) {
                e2.put("email_auth_hash", this.c.optString("email_auth_hash"));
            }
            if (this.c.has("sms_auth_hash")) {
                e2.put("sms_auth_hash", this.c.optString("sms_auth_hash"));
            }
            if (this.c.has("external_user_id_auth_hash") && !e2.has("external_user_id_auth_hash")) {
                e2.put("external_user_id_auth_hash", this.c.optString("external_user_id_auth_hash"));
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return e2;
    }

    public JSONObject f(m2 m2Var, Set set) {
        JSONObject b;
        synchronized (d) {
            b = H.b(this.b, m2Var.b, null, set);
        }
        return b;
    }

    public JSONObject g(JSONObject jSONObject, Set set) {
        JSONObject b;
        synchronized (d) {
            JSONObject jSONObject2 = this.b;
            b = H.b(jSONObject2, jSONObject, jSONObject2, set);
        }
        return b;
    }

    public JSONObject h(JSONObject jSONObject, Set set) {
        JSONObject b;
        synchronized (d) {
            JSONObject jSONObject2 = this.c;
            b = H.b(jSONObject2, jSONObject, jSONObject2, set);
        }
        return b;
    }

    public E i() {
        try {
            return new E(j());
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new E();
        }
    }

    public JSONObject j() {
        JSONObject jSONObject;
        synchronized (d) {
            jSONObject = new JSONObject(this.b.toString());
        }
        return jSONObject;
    }

    public final Set k(m2 m2Var) {
        try {
            if (this.b.optLong("loc_time_stamp") == m2Var.b.getLong("loc_time_stamp")) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("loc_bg", m2Var.b.opt("loc_bg"));
            hashMap.put("loc_time_stamp", m2Var.b.opt("loc_time_stamp"));
            u(m2Var.c, hashMap);
            return f;
        } catch (Throwable unused) {
            return null;
        }
    }

    public E l() {
        try {
            return new E(m());
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new E();
        }
    }

    public JSONObject m() {
        JSONObject jSONObject;
        synchronized (d) {
            jSONObject = new JSONObject(this.c.toString());
        }
        return jSONObject;
    }

    public final void n() {
        boolean z;
        String str = R1.a;
        String f2 = R1.f(str, "ONESIGNAL_USERSTATE_DEPENDVALYES_" + this.a, null);
        if (f2 == null) {
            x(new JSONObject());
            try {
                int i = 1;
                int c = R1.c(str, this.a.equals("CURRENT_STATE") ? "ONESIGNAL_SUBSCRIPTION" : "ONESIGNAL_SYNCED_SUBSCRIPTION", 1);
                if (c == -2) {
                    z = false;
                } else {
                    i = c;
                    z = true;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("subscribableStatus", Integer.valueOf(i));
                hashMap.put("userSubscribePref", Boolean.valueOf(z));
                u(this.b, hashMap);
            } catch (JSONException unused) {
            }
        } else {
            try {
                x(new JSONObject(f2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String str2 = R1.a;
        String f3 = R1.f(str2, "ONESIGNAL_USERSTATE_SYNCVALYES_" + this.a, null);
        JSONObject jSONObject = new JSONObject();
        try {
            if (f3 == null) {
                jSONObject.put("identifier", R1.f(str2, "GT_REGISTRATION_ID", null));
            } else {
                jSONObject = new JSONObject(f3);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        z(jSONObject);
    }

    public void o(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        if (jSONObject.has("tags")) {
            try {
                JSONObject m = m();
                if (m.has("tags")) {
                    try {
                        jSONObject3 = new JSONObject(m.optString("tags"));
                    } catch (JSONException unused) {
                        jSONObject3 = new JSONObject();
                    }
                } else {
                    jSONObject3 = new JSONObject();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("tags");
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if ("".equals(optJSONObject.optString(str))) {
                        jSONObject3.remove(str);
                    } else if (jSONObject2 == null || !jSONObject2.has(str)) {
                        jSONObject3.put(str, optJSONObject.optString(str));
                    }
                }
                synchronized (d) {
                    try {
                        if (jSONObject3.toString().equals("{}")) {
                            this.c.remove("tags");
                        } else {
                            this.c.put("tags", jSONObject3);
                        }
                    } finally {
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public abstract m2 p(String str);

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[Catch: all -> 0x0028, JSONException -> 0x002a, TRY_LEAVE, TryCatch #1 {JSONException -> 0x002a, blocks: (B:4:0x0003, B:6:0x000d, B:8:0x0017, B:11:0x0036, B:13:0x002c), top: B:3:0x0003, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q() {
        /*
            r4 = this;
            java.lang.Object r0 = com.onesignal.m2.d
            monitor-enter(r0)
            org.json.JSONObject r1 = r4.c     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            java.lang.String r2 = "external_user_id_auth_hash"
            boolean r1 = r1.has(r2)     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            if (r1 == 0) goto L41
            org.json.JSONObject r1 = r4.c     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            java.lang.String r2 = "external_user_id"
            boolean r1 = r1.has(r2)     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            if (r1 == 0) goto L2c
            org.json.JSONObject r1 = r4.c     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            java.lang.String r2 = "external_user_id"
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            java.lang.String r2 = ""
            if (r1 == r2) goto L36
            goto L2c
        L28:
            r1 = move-exception
            goto L7d
        L2a:
            r1 = move-exception
            goto L3e
        L2c:
            org.json.JSONObject r1 = r4.c     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            java.lang.String r2 = "external_user_id"
            boolean r1 = r1.has(r2)     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            if (r1 != 0) goto L41
        L36:
            org.json.JSONObject r1 = r4.c     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            java.lang.String r2 = "external_user_id_auth_hash"
            r1.remove(r2)     // Catch: java.lang.Throwable -> L28 org.json.JSONException -> L2a
            goto L41
        L3e:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L28
        L41:
            java.lang.String r1 = com.onesignal.R1.a     // Catch: java.lang.Throwable -> L28
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
            r2.<init>()     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = "ONESIGNAL_USERSTATE_SYNCVALYES_"
            r2.append(r3)     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = r4.a     // Catch: java.lang.Throwable -> L28
            r2.append(r3)     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L28
            org.json.JSONObject r3 = r4.c     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L28
            com.onesignal.R1.m(r1, r2, r3)     // Catch: java.lang.Throwable -> L28
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
            r2.<init>()     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = "ONESIGNAL_USERSTATE_DEPENDVALYES_"
            r2.append(r3)     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = r4.a     // Catch: java.lang.Throwable -> L28
            r2.append(r3)     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L28
            org.json.JSONObject r3 = r4.b     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L28
            com.onesignal.R1.m(r1, r2, r3)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L28
            return
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L28
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.m2.q():void");
    }

    public void r(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            JSONObject jSONObject3 = this.b;
            e(jSONObject3, jSONObject, jSONObject3, null);
        }
        if (jSONObject2 != null) {
            JSONObject jSONObject4 = this.c;
            e(jSONObject4, jSONObject2, jSONObject4, null);
            o(jSONObject2, null);
        }
        if (jSONObject == null && jSONObject2 == null) {
            return;
        }
        q();
    }

    public void s(String str, Object obj) {
        synchronized (d) {
            this.b.put(str, obj);
        }
    }

    public void t(String str, Object obj) {
        synchronized (d) {
            this.c.put(str, obj);
        }
    }

    public String toString() {
        return "UserState{persistKey='" + this.a + "', dependValues=" + this.b + ", syncValues=" + this.c + '}';
    }

    public final void u(JSONObject jSONObject, HashMap hashMap) {
        synchronized (d) {
            try {
                for (Map.Entry entry : hashMap.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v(String str) {
        synchronized (d) {
            this.b.remove(str);
        }
    }

    public void w(String str) {
        synchronized (d) {
            this.c.remove(str);
        }
    }

    public void x(JSONObject jSONObject) {
        synchronized (d) {
            this.b = jSONObject;
        }
    }

    public void y(O.d dVar) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("lat", dVar.a);
            hashMap.put("long", dVar.b);
            hashMap.put("loc_acc", dVar.c);
            hashMap.put("loc_type", dVar.d);
            u(this.c, hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("loc_bg", dVar.e);
            hashMap2.put("loc_time_stamp", dVar.f);
            u(this.b, hashMap2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void z(JSONObject jSONObject) {
        synchronized (d) {
            this.c = jSONObject;
        }
    }
}
