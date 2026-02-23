package n4;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c extends y4.a {
    public final long f;
    public final long g;
    public final String h;
    public final String i;
    public final long j;
    public static final t4.b k = new t4.b("AdBreakStatus");
    public static final Parcelable.Creator CREATOR = new f0();

    public c(long j, long j2, String str, String str2, long j3) {
        this.f = j;
        this.g = j2;
        this.h = str;
        this.i = str2;
        this.j = j3;
    }

    public static c M(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("currentBreakTime") && jSONObject.has("currentBreakClipTime")) {
            try {
                long e = t4.a.e(jSONObject.getLong("currentBreakTime"));
                long e2 = t4.a.e(jSONObject.getLong("currentBreakClipTime"));
                String c = t4.a.c(jSONObject, "breakId");
                String c2 = t4.a.c(jSONObject, "breakClipId");
                long optLong = jSONObject.optLong("whenSkippable", -1L);
                return new c(e, e2, c, c2, optLong != -1 ? t4.a.e(optLong) : optLong);
            } catch (JSONException e3) {
                k.d(e3, "Error while creating an AdBreakClipInfo from JSON", new Object[0]);
            }
        }
        return null;
    }

    public String H() {
        return this.i;
    }

    public String I() {
        return this.h;
    }

    public long J() {
        return this.g;
    }

    public long K() {
        return this.f;
    }

    public long L() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f == cVar.f && this.g == cVar.g && t4.a.k(this.h, cVar.h) && t4.a.k(this.i, cVar.i) && this.j == cVar.j;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Long.valueOf(this.f), Long.valueOf(this.g), this.h, this.i, Long.valueOf(this.j));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.o(parcel, 2, K());
        y4.c.o(parcel, 3, J());
        y4.c.t(parcel, 4, I(), false);
        y4.c.t(parcel, 5, H(), false);
        y4.c.o(parcel, 6, L());
        y4.c.b(parcel, a);
    }
}
