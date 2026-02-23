package n4;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.cast.MediaInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class r extends y4.a {
    public o A;
    public boolean B;
    public final SparseArray C;
    public final a D;
    public MediaInfo f;
    public long g;
    public int h;
    public double i;
    public int j;
    public int k;
    public long l;
    public long m;
    public double n;
    public boolean o;
    public long[] p;
    public int q;
    public int r;
    public String s;
    public JSONObject t;
    public int u;
    public final List v;
    public boolean w;
    public c x;
    public v y;
    public j z;
    public static final t4.b E = new t4.b("MediaStatus");
    public static final Parcelable.Creator CREATOR = new s0();

    public class a {
        public a() {
        }
    }

    public r(MediaInfo mediaInfo, long j, int i, double d, int i2, int i3, long j2, long j3, double d2, boolean z, long[] jArr, int i4, int i5, String str, int i6, List list, boolean z2, c cVar, v vVar, j jVar, o oVar) {
        this.v = new ArrayList();
        this.C = new SparseArray();
        this.D = new a();
        this.f = mediaInfo;
        this.g = j;
        this.h = i;
        this.i = d;
        this.j = i2;
        this.k = i3;
        this.l = j2;
        this.m = j3;
        this.n = d2;
        this.o = z;
        this.p = jArr;
        this.q = i4;
        this.r = i5;
        this.s = str;
        if (str != null) {
            try {
                this.t = new JSONObject(this.s);
            } catch (JSONException unused) {
                this.t = null;
                this.s = null;
            }
        } else {
            this.t = null;
        }
        this.u = i6;
        if (list != null && !list.isEmpty()) {
            k0(list);
        }
        this.w = z2;
        this.x = cVar;
        this.y = vVar;
        this.z = jVar;
        this.A = oVar;
        boolean z3 = false;
        if (oVar != null && oVar.R()) {
            z3 = true;
        }
        this.B = z3;
    }

    public static final boolean l0(int i, int i2, int i3, int i4) {
        if (i != 1) {
            return false;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return i4 != 2;
            }
            if (i2 != 3) {
                return true;
            }
        }
        return i3 == 0;
    }

    public long[] H() {
        return this.p;
    }

    public c I() {
        return this.x;
    }

    public n4.a J() {
        MediaInfo mediaInfo;
        List<n4.a> H;
        c cVar = this.x;
        if (cVar == null) {
            return null;
        }
        String H2 = cVar.H();
        if (!TextUtils.isEmpty(H2) && (mediaInfo = this.f) != null && (H = mediaInfo.H()) != null && !H.isEmpty()) {
            for (n4.a aVar : H) {
                if (H2.equals(aVar.M())) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public int K() {
        return this.h;
    }

    public JSONObject L() {
        return this.t;
    }

    public int M() {
        return this.k;
    }

    public Integer N(int i) {
        return (Integer) this.C.get(i);
    }

    public p O(int i) {
        Integer num = (Integer) this.C.get(i);
        if (num == null) {
            return null;
        }
        return (p) this.v.get(num.intValue());
    }

    public p P(int i) {
        if (i < 0 || i >= this.v.size()) {
            return null;
        }
        return (p) this.v.get(i);
    }

    public j Q() {
        return this.z;
    }

    public int R() {
        return this.q;
    }

    public MediaInfo S() {
        return this.f;
    }

    public double T() {
        return this.i;
    }

    public int U() {
        return this.j;
    }

    public int V() {
        return this.r;
    }

    public o W() {
        return this.A;
    }

    public p X(int i) {
        return P(i);
    }

    public p Y(int i) {
        return O(i);
    }

    public int Z() {
        return this.v.size();
    }

    public List a0() {
        return this.v;
    }

    public int b0() {
        return this.u;
    }

    public long c0() {
        return this.l;
    }

    public double d0() {
        return this.n;
    }

    public v e0() {
        return this.y;
    }

    public boolean equals(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return (this.t == null) == (rVar.t == null) && this.g == rVar.g && this.h == rVar.h && this.i == rVar.i && this.j == rVar.j && this.k == rVar.k && this.l == rVar.l && this.n == rVar.n && this.o == rVar.o && this.q == rVar.q && this.r == rVar.r && this.u == rVar.u && Arrays.equals(this.p, rVar.p) && t4.a.k(Long.valueOf(this.m), Long.valueOf(rVar.m)) && t4.a.k(this.v, rVar.v) && t4.a.k(this.f, rVar.f) && ((jSONObject = this.t) == null || (jSONObject2 = rVar.t) == null || C4.l.a(jSONObject, jSONObject2)) && this.w == rVar.h0() && t4.a.k(this.x, rVar.x) && t4.a.k(this.y, rVar.y) && t4.a.k(this.z, rVar.z) && com.google.android.gms.common.internal.q.b(this.A, rVar.A) && this.B == rVar.B;
    }

    public boolean f0(long j) {
        return (j & this.m) != 0;
    }

    public boolean g0() {
        return this.o;
    }

    public boolean h0() {
        return this.w;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, Long.valueOf(this.g), Integer.valueOf(this.h), Double.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k), Long.valueOf(this.l), Long.valueOf(this.m), Double.valueOf(this.n), Boolean.valueOf(this.o), Integer.valueOf(Arrays.hashCode(this.p)), Integer.valueOf(this.q), Integer.valueOf(this.r), String.valueOf(this.t), Integer.valueOf(this.u), this.v, Boolean.valueOf(this.w), this.x, this.y, this.z, this.A);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x018c A[EDGE_INSN: B:200:0x018c->B:86:0x0190 BREAK  A[LOOP:0: B:79:0x017a->B:83:0x0187]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int i0(org.json.JSONObject r14, int r15) {
        /*
            Method dump skipped, instructions count: 909
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.r.i0(org.json.JSONObject, int):int");
    }

    public final boolean j0() {
        MediaInfo mediaInfo = this.f;
        return l0(this.j, this.k, this.q, mediaInfo == null ? -1 : mediaInfo.T());
    }

    public final void k0(List list) {
        this.v.clear();
        this.C.clear();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                p pVar = (p) list.get(i);
                this.v.add(pVar);
                this.C.put(pVar.K(), Integer.valueOf(i));
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.t;
        this.s = jSONObject == null ? null : jSONObject.toString();
        int a2 = y4.c.a(parcel);
        y4.c.r(parcel, 2, S(), i, false);
        y4.c.o(parcel, 3, this.g);
        y4.c.l(parcel, 4, K());
        y4.c.g(parcel, 5, T());
        y4.c.l(parcel, 6, U());
        y4.c.l(parcel, 7, M());
        y4.c.o(parcel, 8, c0());
        y4.c.o(parcel, 9, this.m);
        y4.c.g(parcel, 10, d0());
        y4.c.c(parcel, 11, g0());
        y4.c.p(parcel, 12, H(), false);
        y4.c.l(parcel, 13, R());
        y4.c.l(parcel, 14, V());
        y4.c.t(parcel, 15, this.s, false);
        y4.c.l(parcel, 16, this.u);
        y4.c.x(parcel, 17, this.v, false);
        y4.c.c(parcel, 18, h0());
        y4.c.r(parcel, 19, I(), i, false);
        y4.c.r(parcel, 20, e0(), i, false);
        y4.c.r(parcel, 21, Q(), i, false);
        y4.c.r(parcel, 22, W(), i, false);
        y4.c.b(parcel, a2);
    }

    public final long zzb() {
        return this.g;
    }

    public r(JSONObject jSONObject) {
        this(null, 0L, 0, 0.0d, 0, 0, 0L, 0L, 0.0d, false, null, 0, 0, null, 0, null, false, null, null, null, null);
        i0(jSONObject, 0);
    }
}
