package com.onesignal;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class z0 {
    public String a;
    public String b;
    public a c;
    public String d;
    public String e;
    public List f = new ArrayList();
    public List g = new ArrayList();
    public N0 h;
    public boolean i;
    public boolean j;

    public enum a {
        IN_APP_WEBVIEW("webview"),
        BROWSER("browser"),
        REPLACE_CONTENT("replacement");

        private String text;

        a(String str) {
            this.text = str;
        }

        public static a fromString(String str) {
            for (a aVar : values()) {
                if (aVar.text.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return null;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url_type", this.text);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return this.text;
        }
    }

    public z0(JSONObject jSONObject) {
        this.a = jSONObject.optString("id", (String) null);
        this.b = jSONObject.optString("name", (String) null);
        this.d = jSONObject.optString("url", (String) null);
        this.e = jSONObject.optString("pageId", (String) null);
        a fromString = a.fromString(jSONObject.optString("url_target", (String) null));
        this.c = fromString;
        if (fromString == null) {
            this.c = a.IN_APP_WEBVIEW;
        }
        this.j = jSONObject.optBoolean("close", true);
        if (jSONObject.has("outcomes")) {
            h(jSONObject);
        }
        if (jSONObject.has("tags")) {
            this.h = new N0(jSONObject.getJSONObject("tags"));
        }
        if (jSONObject.has("prompts")) {
            i(jSONObject);
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.d;
    }

    public List c() {
        return this.f;
    }

    public List d() {
        return this.g;
    }

    public N0 e() {
        return this.h;
    }

    public a f() {
        return this.c;
    }

    public boolean g() {
        return this.i;
    }

    public final void h(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("outcomes");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f.add(new F0((JSONObject) jSONArray.get(i)));
        }
    }

    public final void i(JSONObject jSONObject) {
        List list;
        Object k0;
        JSONArray jSONArray = jSONObject.getJSONArray("prompts");
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            string.hashCode();
            if (string.equals("push")) {
                list = this.g;
                k0 = new K0();
            } else if (string.equals("location")) {
                list = this.g;
                k0 = new E0();
            }
            list.add(k0);
        }
    }

    public void j(boolean z) {
        this.i = z;
    }
}
