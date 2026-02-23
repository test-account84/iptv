package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import n4.c0;
import org.json.JSONObject;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MediaError extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new c0();
    public String f;
    public long g;
    public final Integer h;
    public final String i;
    public String j;
    public final JSONObject k;

    public MediaError(String str, long j, Integer num, String str2, JSONObject jSONObject) {
        this.f = str;
        this.g = j;
        this.h = num;
        this.i = str2;
        this.k = jSONObject;
    }

    public static MediaError L(JSONObject jSONObject) {
        return new MediaError(jSONObject.optString("type", "ERROR"), jSONObject.optLong("requestId"), jSONObject.has("detailedErrorCode") ? Integer.valueOf(jSONObject.optInt("detailedErrorCode")) : null, t4.a.c(jSONObject, "reason"), jSONObject.has("customData") ? jSONObject.optJSONObject("customData") : null);
    }

    public Integer H() {
        return this.h;
    }

    public String I() {
        return this.i;
    }

    public long J() {
        return this.g;
    }

    public String K() {
        return this.f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.k;
        this.j = jSONObject == null ? null : jSONObject.toString();
        int a = c.a(parcel);
        c.t(parcel, 2, K(), false);
        c.o(parcel, 3, J());
        c.n(parcel, 4, H(), false);
        c.t(parcel, 5, I(), false);
        c.t(parcel, 6, this.j, false);
        c.b(parcel, a);
    }
}
