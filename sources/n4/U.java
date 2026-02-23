package n4;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class u extends y4.a {
    public static final Parcelable.Creator CREATOR = new x0();
    public final String f;
    public final String g;

    public u(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public static u c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new u(t4.a.c(jSONObject, "adTagUrl"), t4.a.c(jSONObject, "adsResponse"));
    }

    public String H() {
        return this.f;
    }

    public String I() {
        return this.g;
    }

    public final JSONObject J() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f;
            if (str != null) {
                jSONObject.put("adTagUrl", str);
            }
            String str2 = this.g;
            if (str2 != null) {
                jSONObject.put("adsResponse", str2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return t4.a.k(this.f, uVar.f) && t4.a.k(this.g, uVar.g);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, this.g);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 2, H(), false);
        y4.c.t(parcel, 3, I(), false);
        y4.c.b(parcel, a);
    }
}
