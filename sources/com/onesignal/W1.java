package com.onesignal;

import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class w1 {
    public String a;
    public a b;
    public String c;
    public b d;
    public Object e;

    public enum a {
        TIME_SINCE_LAST_IN_APP("min_time_since"),
        SESSION_TIME("session_time"),
        CUSTOM("custom"),
        UNKNOWN("unknown");

        private String value;

        a(String str) {
            this.value = str;
        }

        public static a fromString(String str) {
            for (a aVar : values()) {
                if (aVar.value.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }

        public String toString() {
            return this.value;
        }
    }

    public enum b {
        GREATER_THAN("greater"),
        LESS_THAN("less"),
        EQUAL_TO("equal"),
        NOT_EQUAL_TO("not_equal"),
        LESS_THAN_OR_EQUAL_TO("less_or_equal"),
        GREATER_THAN_OR_EQUAL_TO("greater_or_equal"),
        EXISTS("exists"),
        NOT_EXISTS("not_exists"),
        CONTAINS("in");

        private String text;

        b(String str) {
            this.text = str;
        }

        public static b fromString(String str) {
            for (b bVar : values()) {
                if (bVar.text.equalsIgnoreCase(str)) {
                    return bVar;
                }
            }
            return EQUAL_TO;
        }

        public boolean checksEquality() {
            return this == EQUAL_TO || this == NOT_EQUAL_TO;
        }

        public String toString() {
            return this.text;
        }
    }

    public w1(JSONObject jSONObject) {
        this.a = jSONObject.getString("id");
        this.b = a.fromString(jSONObject.getString("kind"));
        this.c = jSONObject.optString("property", (String) null);
        this.d = b.fromString(jSONObject.getString("operator"));
        this.e = jSONObject.opt("value");
    }

    public String toString() {
        return "OSTrigger{triggerId='" + this.a + "', kind=" + this.b + ", property='" + this.c + "', operatorType=" + this.d + ", value=" + this.e + '}';
    }
}
