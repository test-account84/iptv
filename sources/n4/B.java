package n4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b extends y4.a {
    public static final Parcelable.Creator CREATOR = new F();
    public final long f;
    public final String g;
    public final long h;
    public final boolean i;
    public final String[] j;
    public final boolean k;
    public final boolean l;

    public b(long j, String str, long j2, boolean z, String[] strArr, boolean z2, boolean z3) {
        this.f = j;
        this.g = str;
        this.h = j2;
        this.i = z;
        this.j = strArr;
        this.k = z2;
        this.l = z3;
    }

    public String[] H() {
        return this.j;
    }

    public long I() {
        return this.h;
    }

    public String J() {
        return this.g;
    }

    public long K() {
        return this.f;
    }

    public boolean L() {
        return this.k;
    }

    public boolean M() {
        return this.l;
    }

    public boolean N() {
        return this.i;
    }

    public final JSONObject O() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.g);
            jSONObject.put("position", t4.a.b(this.f));
            jSONObject.put("isWatched", this.i);
            jSONObject.put("isEmbedded", this.k);
            jSONObject.put("duration", t4.a.b(this.h));
            jSONObject.put("expanded", this.l);
            if (this.j != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.j) {
                    jSONArray.put(str);
                }
                jSONObject.put("breakClipIds", jSONArray);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return t4.a.k(this.g, bVar.g) && this.f == bVar.f && this.h == bVar.h && this.i == bVar.i && Arrays.equals(this.j, bVar.j) && this.k == bVar.k && this.l == bVar.l;
    }

    public int hashCode() {
        return this.g.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.o(parcel, 2, K());
        y4.c.t(parcel, 3, J(), false);
        y4.c.o(parcel, 4, I());
        y4.c.c(parcel, 5, N());
        y4.c.u(parcel, 6, H(), false);
        y4.c.c(parcel, 7, L());
        y4.c.c(parcel, 8, M());
        y4.c.b(parcel, a);
    }
}
