package n4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaInfo;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class l extends y4.a {
    public final MediaInfo f;
    public final o g;
    public final Boolean h;
    public final long i;
    public final double j;
    public final long[] k;
    public String l;
    public final JSONObject m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public long r;
    public static final t4.b s = new t4.b("MediaLoadRequestData");
    public static final Parcelable.Creator CREATOR = new i0();

    public static class a {
        public MediaInfo a;
        public o b;
        public Boolean c = Boolean.TRUE;
        public long d = -1;
        public double e = 1.0d;
        public long[] f;
        public JSONObject g;
        public String h;
        public String i;
        public String j;
        public String k;
        public long l;

        public l a() {
            return new l(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null);
        }

        public a b(long[] jArr) {
            this.f = jArr;
            return this;
        }

        public a c(Boolean bool) {
            this.c = bool;
            return this;
        }

        public a d(String str) {
            this.h = str;
            return this;
        }

        public a e(String str) {
            this.i = str;
            return this;
        }

        public a f(long j) {
            this.d = j;
            return this;
        }

        public a g(JSONObject jSONObject) {
            this.g = jSONObject;
            return this;
        }

        public a h(MediaInfo mediaInfo) {
            this.a = mediaInfo;
            return this;
        }

        public a i(double d) {
            if (Double.compare(d, 2.0d) > 0 || Double.compare(d, 0.5d) < 0) {
                throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
            }
            this.e = d;
            return this;
        }

        public a j(o oVar) {
            this.b = oVar;
            return this;
        }
    }

    public l(MediaInfo mediaInfo, o oVar, Boolean bool, long j, double d, long[] jArr, String str, String str2, String str3, String str4, String str5, long j2) {
        this(mediaInfo, oVar, bool, j, d, jArr, t4.a.a(str), str2, str3, str4, str5, j2);
    }

    public long[] H() {
        return this.k;
    }

    public Boolean I() {
        return this.h;
    }

    public String J() {
        return this.n;
    }

    public String K() {
        return this.o;
    }

    public long L() {
        return this.i;
    }

    public MediaInfo M() {
        return this.f;
    }

    public double N() {
        return this.j;
    }

    public o O() {
        return this.g;
    }

    public long P() {
        return this.r;
    }

    public JSONObject Q() {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.f;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.W());
            }
            o oVar = this.g;
            if (oVar != null) {
                jSONObject.put("queueData", oVar.P());
            }
            jSONObject.putOpt("autoplay", this.h);
            long j = this.i;
            if (j != -1) {
                jSONObject.put("currentTime", t4.a.b(j));
            }
            jSONObject.put("playbackRate", this.j);
            jSONObject.putOpt("credentials", this.n);
            jSONObject.putOpt("credentialsType", this.o);
            jSONObject.putOpt("atvCredentials", this.p);
            jSONObject.putOpt("atvCredentialsType", this.q);
            if (this.k != null) {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                while (true) {
                    long[] jArr = this.k;
                    if (i >= jArr.length) {
                        break;
                    }
                    jSONArray.put(i, jArr[i]);
                    i++;
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            jSONObject.putOpt("customData", this.m);
            jSONObject.put("requestId", this.r);
            return jSONObject;
        } catch (JSONException e) {
            s.c("Error transforming MediaLoadRequestData into JSONObject", e);
            return new JSONObject();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return C4.l.a(this.m, lVar.m) && com.google.android.gms.common.internal.q.b(this.f, lVar.f) && com.google.android.gms.common.internal.q.b(this.g, lVar.g) && com.google.android.gms.common.internal.q.b(this.h, lVar.h) && this.i == lVar.i && this.j == lVar.j && Arrays.equals(this.k, lVar.k) && com.google.android.gms.common.internal.q.b(this.n, lVar.n) && com.google.android.gms.common.internal.q.b(this.o, lVar.o) && com.google.android.gms.common.internal.q.b(this.p, lVar.p) && com.google.android.gms.common.internal.q.b(this.q, lVar.q) && this.r == lVar.r;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, this.g, this.h, Long.valueOf(this.i), Double.valueOf(this.j), this.k, String.valueOf(this.m), this.n, this.o, this.p, this.q, Long.valueOf(this.r));
    }

    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.m;
        this.l = jSONObject == null ? null : jSONObject.toString();
        int a2 = y4.c.a(parcel);
        y4.c.r(parcel, 2, M(), i, false);
        y4.c.r(parcel, 3, O(), i, false);
        y4.c.d(parcel, 4, I(), false);
        y4.c.o(parcel, 5, L());
        y4.c.g(parcel, 6, N());
        y4.c.p(parcel, 7, H(), false);
        y4.c.t(parcel, 8, this.l, false);
        y4.c.t(parcel, 9, J(), false);
        y4.c.t(parcel, 10, K(), false);
        y4.c.t(parcel, 11, this.p, false);
        y4.c.t(parcel, 12, this.q, false);
        y4.c.o(parcel, 13, P());
        y4.c.b(parcel, a2);
    }

    public l(MediaInfo mediaInfo, o oVar, Boolean bool, long j, double d, long[] jArr, JSONObject jSONObject, String str, String str2, String str3, String str4, long j2) {
        this.f = mediaInfo;
        this.g = oVar;
        this.h = bool;
        this.i = j;
        this.j = d;
        this.k = jArr;
        this.m = jSONObject;
        this.n = str;
        this.o = str2;
        this.p = str3;
        this.q = str4;
        this.r = j2;
    }

    public /* synthetic */ l(MediaInfo mediaInfo, o oVar, Boolean bool, long j, double d, long[] jArr, JSONObject jSONObject, String str, String str2, String str3, String str4, long j2, h0 h0Var) {
        this(mediaInfo, oVar, bool, j, d, jArr, jSONObject, str, str2, str3, str4, j2);
    }
}
