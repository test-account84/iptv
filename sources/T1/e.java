package t1;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final String a;
    public final String c;
    public final d d = a();

    public static class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public e(Parcel parcel) {
        this.a = parcel.readString();
        this.c = parcel.readString();
    }

    public d a() {
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            d dVar = new d();
            dVar.a = jSONObject.optString("orderId");
            dVar.c = jSONObject.optString("packageName");
            dVar.d = jSONObject.optString("productId");
            long optLong = jSONObject.optLong("purchaseTime", 0L);
            dVar.e = optLong != 0 ? new Date(optLong) : null;
            dVar.f = f.values()[jSONObject.optInt("purchaseState", 1)];
            dVar.g = jSONObject.optString("developerPayload");
            dVar.h = jSONObject.getString("purchaseToken");
            dVar.i = jSONObject.optBoolean("autoRenewing");
            return dVar;
        } catch (JSONException e) {
            Log.e("iabv3.purchaseInfo", "Failed to parse response data", e);
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a.equals(eVar.a) && this.c.equals(eVar.c) && this.d.h.equals(eVar.d.h) && this.d.e.equals(eVar.d.e);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
    }

    public e(String str, String str2) {
        this.a = str;
        this.c = str2;
    }
}
