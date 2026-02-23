package com.google.android.gms.cast;

import C4.l;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.cast.zzfe;
import com.google.android.gms.internal.cast.zzfh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n4.d0;
import n4.m;
import n4.t;
import n4.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class MediaInfo extends y4.a implements ReflectedParcelable {
    public String f;
    public int g;
    public String h;
    public m i;
    public long j;
    public List k;
    public t l;
    public String m;
    public List n;
    public List o;
    public String p;
    public u q;
    public long r;
    public String s;
    public String t;
    public String u;
    public String v;
    public JSONObject w;
    public final b x;
    public static final long y = t4.a.e(-1);
    public static final Parcelable.Creator CREATOR = new d0();

    public static class a {
        public String a;
        public String c;
        public m d;
        public List f;
        public t g;
        public String h;
        public List i;
        public List j;
        public String k;
        public u l;
        public String m;
        public String n;
        public String o;
        public String p;
        public int b = -1;
        public long e = -1;

        public a(String str) {
            this.a = str;
        }

        public MediaInfo a() {
            return new MediaInfo(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, -1L, this.m, this.n, this.o, this.p);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(JSONObject jSONObject) {
            this.h = jSONObject == null ? null : jSONObject.toString();
            return this;
        }

        public a d(m mVar) {
            this.d = mVar;
            return this;
        }

        public a e(int i) {
            if (i < -1 || i > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            this.b = i;
            return this;
        }
    }

    public class b {
        public b() {
        }
    }

    public MediaInfo(String str, int i, String str2, m mVar, long j, List list, t tVar, String str3, List list2, List list3, String str4, u uVar, long j2, String str5, String str6, String str7, String str8) {
        this.x = new b();
        this.f = str;
        this.g = i;
        this.h = str2;
        this.i = mVar;
        this.j = j;
        this.k = list;
        this.l = tVar;
        this.m = str3;
        if (str3 != null) {
            try {
                this.w = new JSONObject(this.m);
            } catch (JSONException unused) {
                this.w = null;
                this.m = null;
            }
        } else {
            this.w = null;
        }
        this.n = list2;
        this.o = list3;
        this.p = str4;
        this.q = uVar;
        this.r = j2;
        this.s = str5;
        this.t = str6;
        this.u = str7;
        this.v = str8;
        if (this.f == null && str6 == null && str4 == null) {
            throw new IllegalArgumentException("Either contentID or contentUrl or entity should be set");
        }
    }

    public List H() {
        List list = this.o;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public List I() {
        List list = this.n;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String J() {
        String str = this.f;
        return str == null ? "" : str;
    }

    public String K() {
        return this.h;
    }

    public String L() {
        return this.t;
    }

    public String M() {
        return this.p;
    }

    public String N() {
        return this.u;
    }

    public String O() {
        return this.v;
    }

    public List P() {
        return this.k;
    }

    public m Q() {
        return this.i;
    }

    public long R() {
        return this.r;
    }

    public long S() {
        return this.j;
    }

    public int T() {
        return this.g;
    }

    public t U() {
        return this.l;
    }

    public u V() {
        return this.q;
    }

    public final JSONObject W() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.f);
            jSONObject.putOpt("contentUrl", this.t);
            int i = this.g;
            jSONObject.put("streamType", i != 1 ? i != 2 ? "NONE" : "LIVE" : "BUFFERED");
            String str = this.h;
            if (str != null) {
                jSONObject.put("contentType", str);
            }
            m mVar = this.i;
            if (mVar != null) {
                jSONObject.put("metadata", mVar.O());
            }
            long j = this.j;
            if (j <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", t4.a.b(j));
            }
            if (this.k != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.k.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaTrack) it.next()).P());
                }
                jSONObject.put("tracks", jSONArray);
            }
            t tVar = this.l;
            if (tVar != null) {
                jSONObject.put("textTrackStyle", tVar.S());
            }
            JSONObject jSONObject2 = this.w;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str2 = this.p;
            if (str2 != null) {
                jSONObject.put("entity", str2);
            }
            if (this.n != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = this.n.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(((n4.b) it2.next()).O());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.o != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = this.o.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((n4.a) it3.next()).S());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            u uVar = this.q;
            if (uVar != null) {
                jSONObject.put("vmapAdsRequest", uVar.J());
            }
            long j2 = this.r;
            if (j2 != -1) {
                jSONObject.put("startAbsoluteTime", t4.a.b(j2));
            }
            jSONObject.putOpt("atvEntity", this.s);
            String str3 = this.u;
            if (str3 != null) {
                jSONObject.put("hlsSegmentFormat", str3);
            }
            String str4 = this.v;
            if (str4 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str4);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00aa A[LOOP:0: B:4:0x0022->B:10:0x00aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0188 A[LOOP:2: B:35:0x00d0->B:41:0x0188, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void X(org.json.JSONObject r40) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaInfo.X(org.json.JSONObject):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.w;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = mediaInfo.w;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || l.a(jSONObject, jSONObject2)) && t4.a.k(this.f, mediaInfo.f) && this.g == mediaInfo.g && t4.a.k(this.h, mediaInfo.h) && t4.a.k(this.i, mediaInfo.i) && this.j == mediaInfo.j && t4.a.k(this.k, mediaInfo.k) && t4.a.k(this.l, mediaInfo.l) && t4.a.k(this.n, mediaInfo.n) && t4.a.k(this.o, mediaInfo.o) && t4.a.k(this.p, mediaInfo.p) && t4.a.k(this.q, mediaInfo.q) && this.r == mediaInfo.r && t4.a.k(this.s, mediaInfo.s) && t4.a.k(this.t, mediaInfo.t) && t4.a.k(this.u, mediaInfo.u) && t4.a.k(this.v, mediaInfo.v);
    }

    public int hashCode() {
        return q.c(this.f, Integer.valueOf(this.g), this.h, this.i, Long.valueOf(this.j), String.valueOf(this.w), this.k, this.l, this.n, this.o, this.p, this.q, Long.valueOf(this.r), this.s, this.u, this.v);
    }

    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.w;
        this.m = jSONObject == null ? null : jSONObject.toString();
        int a2 = c.a(parcel);
        c.t(parcel, 2, J(), false);
        c.l(parcel, 3, T());
        c.t(parcel, 4, K(), false);
        c.r(parcel, 5, Q(), i, false);
        c.o(parcel, 6, S());
        c.x(parcel, 7, P(), false);
        c.r(parcel, 8, U(), i, false);
        c.t(parcel, 9, this.m, false);
        c.x(parcel, 10, I(), false);
        c.x(parcel, 11, H(), false);
        c.t(parcel, 12, M(), false);
        c.r(parcel, 13, V(), i, false);
        c.o(parcel, 14, R());
        c.t(parcel, 15, this.s, false);
        c.t(parcel, 16, L(), false);
        c.t(parcel, 17, N(), false);
        c.t(parcel, 18, O(), false);
        c.b(parcel, a2);
    }

    public MediaInfo(JSONObject jSONObject) {
        MediaInfo mediaInfo;
        int i;
        zzfh zzfhVar;
        this(jSONObject.optString("contentId"), -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        String optString = jSONObject.optString("streamType", "NONE");
        if ("NONE".equals(optString)) {
            mediaInfo = this;
            mediaInfo.g = 0;
        } else {
            mediaInfo = this;
            if ("BUFFERED".equals(optString)) {
                mediaInfo.g = 1;
            } else if ("LIVE".equals(optString)) {
                mediaInfo.g = 2;
            } else {
                mediaInfo.g = -1;
            }
        }
        mediaInfo.h = t4.a.c(jSONObject, "contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            m mVar = new m(jSONObject2.getInt("metadataType"));
            mediaInfo.i = mVar;
            mVar.P(jSONObject2);
        }
        mediaInfo.j = -1L;
        if (mediaInfo.g != 2 && jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble) && optDouble >= 0.0d) {
                mediaInfo.j = t4.a.d(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                Parcelable.Creator creator = MediaTrack.CREATOR;
                long j = jSONObject3.getLong("trackId");
                String optString2 = jSONObject3.optString("type");
                int i3 = "TEXT".equals(optString2) ? 1 : "AUDIO".equals(optString2) ? 2 : "VIDEO".equals(optString2) ? 3 : 0;
                String c = t4.a.c(jSONObject3, "trackContentId");
                String c2 = t4.a.c(jSONObject3, "trackContentType");
                String c3 = t4.a.c(jSONObject3, "name");
                String c4 = t4.a.c(jSONObject3, "language");
                if (jSONObject3.has("subtype")) {
                    String string = jSONObject3.getString("subtype");
                    i = "SUBTITLES".equals(string) ? 1 : "CAPTIONS".equals(string) ? 2 : "DESCRIPTIONS".equals(string) ? 3 : "CHAPTERS".equals(string) ? 4 : "METADATA".equals(string) ? 5 : -1;
                } else {
                    i = 0;
                }
                if (jSONObject3.has("roles")) {
                    zzfe zzfeVar = new zzfe();
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("roles");
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        zzfeVar.zzb(jSONArray2.optString(i4));
                    }
                    zzfhVar = zzfeVar.zzc();
                } else {
                    zzfhVar = null;
                }
                arrayList.add(new MediaTrack(j, i3, c, c2, c3, c4, i, zzfhVar, jSONObject3.optJSONObject("customData")));
            }
            mediaInfo.k = new ArrayList(arrayList);
        } else {
            mediaInfo.k = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("textTrackStyle");
            t tVar = new t();
            tVar.c(jSONObject4);
            mediaInfo.l = tVar;
        } else {
            mediaInfo.l = null;
        }
        X(jSONObject);
        mediaInfo.w = jSONObject.optJSONObject("customData");
        mediaInfo.p = t4.a.c(jSONObject, "entity");
        mediaInfo.s = t4.a.c(jSONObject, "atvEntity");
        mediaInfo.q = u.c(jSONObject.optJSONObject("vmapAdsRequest"));
        if (jSONObject.has("startAbsoluteTime") && !jSONObject.isNull("startAbsoluteTime")) {
            double optDouble2 = jSONObject.optDouble("startAbsoluteTime");
            if (!Double.isNaN(optDouble2) && !Double.isInfinite(optDouble2) && optDouble2 >= 0.0d) {
                mediaInfo.r = t4.a.d(optDouble2);
            }
        }
        if (jSONObject.has("contentUrl")) {
            mediaInfo.t = jSONObject.optString("contentUrl");
        }
        mediaInfo.u = t4.a.c(jSONObject, "hlsSegmentFormat");
        mediaInfo.v = t4.a.c(jSONObject, "hlsVideoSegmentFormat");
    }
}
