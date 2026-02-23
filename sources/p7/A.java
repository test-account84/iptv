package P7;

import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class a {
    public c a;
    public b b;
    public JSONArray c;

    public a(b influenceChannel, c influenceType, JSONArray jSONArray) {
        l.e(influenceChannel, "influenceChannel");
        l.e(influenceType, "influenceType");
        this.b = influenceChannel;
        this.a = influenceType;
        this.c = jSONArray;
    }

    public final a a() {
        return new a(this.b, this.a, this.c);
    }

    public final JSONArray b() {
        return this.c;
    }

    public final b c() {
        return this.b;
    }

    public final c d() {
        return this.a;
    }

    public final void e(JSONArray jSONArray) {
        this.c = jSONArray;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !l.a(a.class, obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && this.a == aVar.a;
    }

    public final void f(c cVar) {
        l.e(cVar, "<set-?>");
        this.a = cVar;
    }

    public final String g() {
        JSONObject put = new JSONObject().put("influence_channel", this.b.toString()).put("influence_type", this.a.toString());
        JSONArray jSONArray = this.c;
        String jSONObject = put.put("influence_ids", jSONArray != null ? String.valueOf(jSONArray) : "").toString();
        l.d(jSONObject, "JSONObject()\n        .pu…e \"\")\n        .toString()");
        return jSONObject;
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        return "SessionInfluence{influenceChannel=" + this.b + ", influenceType=" + this.a + ", ids=" + this.c + '}';
    }

    public a(String jsonString) {
        l.e(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        String string = jSONObject.getString("influence_channel");
        String string2 = jSONObject.getString("influence_type");
        String ids = jSONObject.getString("influence_ids");
        this.b = b.Companion.a(string);
        this.a = c.Companion.a(string2);
        l.d(ids, "ids");
        this.c = ids.length() == 0 ? null : new JSONArray(ids);
    }
}
