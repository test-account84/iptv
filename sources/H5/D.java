package H5;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements G5.v {
    public static final Parcelable.Creator CREATOR = new g();
    public long a;
    public long c;

    public d(long j, long j2) {
        this.a = j;
        this.c = j2;
    }

    public static d d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new d(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final long a() {
        return this.c;
    }

    public final long c() {
        return this.a;
    }

    public final int describeContents() {
        return 0;
    }

    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.a);
            jSONObject.put("creationTimestamp", this.c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.o(parcel, 1, c());
        y4.c.o(parcel, 2, a());
        y4.c.b(parcel, a);
    }
}
