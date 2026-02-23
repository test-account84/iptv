package n4;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class j extends y4.a {
    public final long f;
    public final long g;
    public final boolean h;
    public final boolean i;
    public static final t4.b j = new t4.b("MediaLiveSeekableRange");
    public static final Parcelable.Creator CREATOR = new e0();

    public j(long j2, long j3, boolean z, boolean z2) {
        this.f = Math.max(j2, 0L);
        this.g = Math.max(j3, 0L);
        this.h = z;
        this.i = z2;
    }

    public static j L(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("start") && jSONObject.has("end")) {
            try {
                return new j(t4.a.d(jSONObject.getDouble("start")), t4.a.d(jSONObject.getDouble("end")), jSONObject.optBoolean("isMovingWindow"), jSONObject.optBoolean("isLiveDone"));
            } catch (JSONException unused) {
                j.c("Ignoring Malformed MediaLiveSeekableRange: ".concat(jSONObject.toString()), new Object[0]);
            }
        }
        return null;
    }

    public long H() {
        return this.g;
    }

    public long I() {
        return this.f;
    }

    public boolean J() {
        return this.i;
    }

    public boolean K() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f == jVar.f && this.g == jVar.g && this.h == jVar.h && this.i == jVar.i;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Long.valueOf(this.f), Long.valueOf(this.g), Boolean.valueOf(this.h), Boolean.valueOf(this.i));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.o(parcel, 2, I());
        y4.c.o(parcel, 3, H());
        y4.c.c(parcel, 4, K());
        y4.c.c(parcel, 5, J());
        y4.c.b(parcel, a);
    }
}
