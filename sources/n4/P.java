package n4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaInfo;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p extends y4.a {
    public static final Parcelable.Creator CREATOR = new q0();
    public MediaInfo f;
    public int g;
    public boolean h;
    public double i;
    public double j;
    public double k;
    public long[] l;
    public String m;
    public JSONObject n;
    public final b o;

    public static class a {
        public final p a;

        public a(MediaInfo mediaInfo) {
            this.a = new p(mediaInfo, (p0) null);
        }

        public p a() {
            this.a.S();
            return this.a;
        }

        public a b() {
            this.a.P().a(0);
            return this;
        }

        public a(p pVar) {
            this.a = new p(pVar, (p0) null);
        }

        public a(JSONObject jSONObject) {
            this.a = new p(jSONObject);
        }
    }

    public class b {
        public b() {
        }

        public void a(int i) {
            p.R(p.this, i);
        }
    }

    public p(MediaInfo mediaInfo, int i, boolean z, double d, double d2, double d3, long[] jArr, String str) {
        this.i = Double.NaN;
        this.o = new b();
        this.f = mediaInfo;
        this.g = i;
        this.h = z;
        this.i = d;
        this.j = d2;
        this.k = d3;
        this.l = jArr;
        this.m = str;
        if (str == null) {
            this.n = null;
            return;
        }
        try {
            this.n = new JSONObject(this.m);
        } catch (JSONException unused) {
            this.n = null;
            this.m = null;
        }
    }

    public static /* bridge */ /* synthetic */ void R(p pVar, int i) {
        pVar.g = i;
    }

    public long[] H() {
        return this.l;
    }

    public boolean I() {
        return this.h;
    }

    public JSONObject J() {
        return this.n;
    }

    public int K() {
        return this.g;
    }

    public MediaInfo L() {
        return this.f;
    }

    public double M() {
        return this.j;
    }

    public double N() {
        return this.k;
    }

    public double O() {
        return this.i;
    }

    public b P() {
        return this.o;
    }

    public JSONObject Q() {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.f;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.W());
            }
            int i = this.g;
            if (i != 0) {
                jSONObject.put("itemId", i);
            }
            jSONObject.put("autoplay", this.h);
            if (!Double.isNaN(this.i)) {
                jSONObject.put("startTime", this.i);
            }
            double d = this.j;
            if (d != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", d);
            }
            jSONObject.put("preloadTime", this.k);
            if (this.l != null) {
                JSONArray jSONArray = new JSONArray();
                for (long j : this.l) {
                    jSONArray.put(j);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            JSONObject jSONObject2 = this.n;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void S() {
        if (this.f == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (!Double.isNaN(this.i) && this.i < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(this.j)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(this.k) || this.k < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }

    public boolean c(JSONObject jSONObject) {
        boolean z;
        long[] jArr;
        boolean z2;
        int i;
        boolean z3 = false;
        if (jSONObject.has("media")) {
            this.f = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId") && this.g != (i = jSONObject.getInt("itemId"))) {
            this.g = i;
            z = true;
        }
        if (jSONObject.has("autoplay") && this.h != (z2 = jSONObject.getBoolean("autoplay"))) {
            this.h = z2;
            z = true;
        }
        double optDouble = jSONObject.optDouble("startTime");
        if (Double.isNaN(optDouble) != Double.isNaN(this.i) || (!Double.isNaN(optDouble) && Math.abs(optDouble - this.i) > 1.0E-7d)) {
            this.i = optDouble;
            z = true;
        }
        if (jSONObject.has("playbackDuration")) {
            double d = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d - this.j) > 1.0E-7d) {
                this.j = d;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d2 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d2 - this.k) > 1.0E-7d) {
                this.k = d2;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArray.getLong(i2);
            }
            long[] jArr2 = this.l;
            if (jArr2 == null || jArr2.length != length) {
                z3 = true;
                break;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (this.l[i3] != jArr[i3]) {
                    z3 = true;
                    break;
                }
            }
        } else {
            jArr = null;
        }
        if (z3) {
            this.l = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.n = jSONObject.getJSONObject("customData");
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        JSONObject jSONObject = this.n;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = pVar.n;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || C4.l.a(jSONObject, jSONObject2)) && t4.a.k(this.f, pVar.f) && this.g == pVar.g && this.h == pVar.h && ((Double.isNaN(this.i) && Double.isNaN(pVar.i)) || this.i == pVar.i) && this.j == pVar.j && this.k == pVar.k && Arrays.equals(this.l, pVar.l);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, Integer.valueOf(this.g), Boolean.valueOf(this.h), Double.valueOf(this.i), Double.valueOf(this.j), Double.valueOf(this.k), Integer.valueOf(Arrays.hashCode(this.l)), String.valueOf(this.n));
    }

    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.n;
        this.m = jSONObject == null ? null : jSONObject.toString();
        int a2 = y4.c.a(parcel);
        y4.c.r(parcel, 2, L(), i, false);
        y4.c.l(parcel, 3, K());
        y4.c.c(parcel, 4, I());
        y4.c.g(parcel, 5, O());
        y4.c.g(parcel, 6, M());
        y4.c.g(parcel, 7, N());
        y4.c.p(parcel, 8, H(), false);
        y4.c.t(parcel, 9, this.m, false);
        y4.c.b(parcel, a2);
    }

    public /* synthetic */ p(MediaInfo mediaInfo, p0 p0Var) {
        this(mediaInfo, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
    }

    public /* synthetic */ p(p pVar, p0 p0Var) {
        this(pVar.L(), pVar.K(), pVar.I(), pVar.O(), pVar.M(), pVar.N(), pVar.H(), null);
        if (this.f == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.n = pVar.J();
    }

    public p(JSONObject jSONObject) {
        this(null, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        c(jSONObject);
    }
}
