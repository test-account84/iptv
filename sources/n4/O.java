package n4;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class o extends y4.a {
    public static final Parcelable.Creator CREATOR = new o0();
    public String f;
    public String g;
    public int h;
    public String i;
    public n j;
    public int k;
    public List l;
    public int m;
    public long n;
    public boolean o;

    public static class a {
        public final o a = new o(null);

        public o a() {
            return new o(this.a, null);
        }

        public final a b(JSONObject jSONObject) {
            o.Q(this.a, jSONObject);
            return this;
        }
    }

    public o(String str, String str2, int i, String str3, n nVar, int i2, List list, int i3, long j, boolean z) {
        this.f = str;
        this.g = str2;
        this.h = i;
        this.i = str3;
        this.j = nVar;
        this.k = i2;
        this.l = list;
        this.m = i3;
        this.n = j;
        this.o = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* bridge */ /* synthetic */ void Q(n4.o r11, org.json.JSONObject r12) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.o.Q(n4.o, org.json.JSONObject):void");
    }

    public n H() {
        return this.j;
    }

    public String I() {
        return this.g;
    }

    public List J() {
        List list = this.l;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String K() {
        return this.f;
    }

    public int L() {
        return this.h;
    }

    public int M() {
        return this.k;
    }

    public int N() {
        return this.m;
    }

    public long O() {
        return this.n;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0027. Please report as an issue. */
    public final JSONObject P() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f)) {
                jSONObject.put("id", this.f);
            }
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put("entity", this.g);
            }
            switch (this.h) {
                case 1:
                    str = "ALBUM";
                    jSONObject.put("queueType", str);
                    break;
                case 2:
                    str = "PLAYLIST";
                    jSONObject.put("queueType", str);
                    break;
                case 3:
                    str = "AUDIOBOOK";
                    jSONObject.put("queueType", str);
                    break;
                case 4:
                    str = "RADIO_STATION";
                    jSONObject.put("queueType", str);
                    break;
                case 5:
                    str = "PODCAST_SERIES";
                    jSONObject.put("queueType", str);
                    break;
                case 6:
                    str = "TV_SERIES";
                    jSONObject.put("queueType", str);
                    break;
                case 7:
                    str = "VIDEO_PLAYLIST";
                    jSONObject.put("queueType", str);
                    break;
                case 8:
                    str = "LIVE_TV";
                    jSONObject.put("queueType", str);
                    break;
                case 9:
                    str = "MOVIE";
                    jSONObject.put("queueType", str);
                    break;
            }
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put("name", this.i);
            }
            n nVar = this.j;
            if (nVar != null) {
                jSONObject.put("containerMetadata", nVar.M());
            }
            String b = u4.a.b(Integer.valueOf(this.k));
            if (b != null) {
                jSONObject.put("repeatMode", b);
            }
            List list = this.l;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((p) it.next()).Q());
                }
                jSONObject.put("items", jSONArray);
            }
            jSONObject.put("startIndex", this.m);
            long j = this.n;
            if (j != -1) {
                jSONObject.put("startTime", t4.a.b(j));
            }
            jSONObject.put("shuffle", this.o);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean R() {
        return this.o;
    }

    public final void S() {
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = null;
        this.k = 0;
        this.l = null;
        this.m = 0;
        this.n = -1L;
        this.o = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return TextUtils.equals(this.f, oVar.f) && TextUtils.equals(this.g, oVar.g) && this.h == oVar.h && TextUtils.equals(this.i, oVar.i) && com.google.android.gms.common.internal.q.b(this.j, oVar.j) && this.k == oVar.k && com.google.android.gms.common.internal.q.b(this.l, oVar.l) && this.m == oVar.m && this.n == oVar.n && this.o == oVar.o;
    }

    public String getName() {
        return this.i;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, this.g, Integer.valueOf(this.h), this.i, this.j, Integer.valueOf(this.k), this.l, Integer.valueOf(this.m), Long.valueOf(this.n), Boolean.valueOf(this.o));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = y4.c.a(parcel);
        y4.c.t(parcel, 2, K(), false);
        y4.c.t(parcel, 3, I(), false);
        y4.c.l(parcel, 4, L());
        y4.c.t(parcel, 5, getName(), false);
        y4.c.r(parcel, 6, H(), i, false);
        y4.c.l(parcel, 7, M());
        y4.c.x(parcel, 8, J(), false);
        y4.c.l(parcel, 9, N());
        y4.c.o(parcel, 10, O());
        y4.c.c(parcel, 11, this.o);
        y4.c.b(parcel, a2);
    }

    public /* synthetic */ o(o oVar, n0 n0Var) {
        this.f = oVar.f;
        this.g = oVar.g;
        this.h = oVar.h;
        this.i = oVar.i;
        this.j = oVar.j;
        this.k = oVar.k;
        this.l = oVar.l;
        this.m = oVar.m;
        this.n = oVar.n;
        this.o = oVar.o;
    }

    public /* synthetic */ o(n0 n0Var) {
        S();
    }
}
