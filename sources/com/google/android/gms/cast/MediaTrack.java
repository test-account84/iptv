package com.google.android.gms.cast;

import C4.l;
import C4.m;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import java.util.List;
import java.util.Locale;
import n4.t0;
import org.json.JSONObject;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class MediaTrack extends y4.a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new t0();
    public final long f;
    public final int g;
    public String h;
    public String i;
    public final String j;
    public final String k;
    public final int l;
    public final List m;
    public String n;
    public final JSONObject o;

    public static class a {
        public final long a;
        public final int b;
        public String c;
        public String d;
        public String e;
        public String f;
        public int g = 0;
        public List h;
        public JSONObject i;

        public a(long j, int i) {
            this.a = j;
            this.b = i;
        }

        public MediaTrack a() {
            return new MediaTrack(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(int i) {
            if (i < -1 || i > 5) {
                throw new IllegalArgumentException("invalid subtype " + i);
            }
            if (i != 0 && this.b != 1) {
                throw new IllegalArgumentException("subtypes are only valid for text tracks");
            }
            this.g = i;
            return this;
        }
    }

    public MediaTrack(long j, int i, String str, String str2, String str3, String str4, int i2, List list, JSONObject jSONObject) {
        this.f = j;
        this.g = i;
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.k = str4;
        this.l = i2;
        this.m = list;
        this.o = jSONObject;
    }

    public String H() {
        return this.h;
    }

    public String I() {
        return this.i;
    }

    public long J() {
        return this.f;
    }

    public String K() {
        return this.k;
    }

    public Locale L() {
        if (TextUtils.isEmpty(this.k)) {
            return null;
        }
        if (m.f()) {
            return Locale.forLanguageTag(this.k);
        }
        String[] split = this.k.split("-", -1);
        return split.length == 1 ? new Locale(split[0]) : new Locale(split[0], split[1]);
    }

    public List M() {
        return this.m;
    }

    public int N() {
        return this.l;
    }

    public int O() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[Catch: JSONException -> 0x008c, TryCatch #0 {JSONException -> 0x008c, blocks: (B:3:0x0005, B:9:0x001c, B:10:0x0026, B:12:0x002a, B:13:0x002f, B:15:0x0033, B:16:0x0038, B:18:0x003c, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:32:0x0063, B:33:0x0073, B:35:0x0077, B:36:0x0083, B:38:0x0087), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033 A[Catch: JSONException -> 0x008c, TryCatch #0 {JSONException -> 0x008c, blocks: (B:3:0x0005, B:9:0x001c, B:10:0x0026, B:12:0x002a, B:13:0x002f, B:15:0x0033, B:16:0x0038, B:18:0x003c, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:32:0x0063, B:33:0x0073, B:35:0x0077, B:36:0x0083, B:38:0x0087), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: JSONException -> 0x008c, TryCatch #0 {JSONException -> 0x008c, blocks: (B:3:0x0005, B:9:0x001c, B:10:0x0026, B:12:0x002a, B:13:0x002f, B:15:0x0033, B:16:0x0038, B:18:0x003c, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:32:0x0063, B:33:0x0073, B:35:0x0077, B:36:0x0083, B:38:0x0087), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[Catch: JSONException -> 0x008c, TryCatch #0 {JSONException -> 0x008c, blocks: (B:3:0x0005, B:9:0x001c, B:10:0x0026, B:12:0x002a, B:13:0x002f, B:15:0x0033, B:16:0x0038, B:18:0x003c, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:32:0x0063, B:33:0x0073, B:35:0x0077, B:36:0x0083, B:38:0x0087), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077 A[Catch: JSONException -> 0x008c, TryCatch #0 {JSONException -> 0x008c, blocks: (B:3:0x0005, B:9:0x001c, B:10:0x0026, B:12:0x002a, B:13:0x002f, B:15:0x0033, B:16:0x0038, B:18:0x003c, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:32:0x0063, B:33:0x0073, B:35:0x0077, B:36:0x0083, B:38:0x0087), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087 A[Catch: JSONException -> 0x008c, TRY_LEAVE, TryCatch #0 {JSONException -> 0x008c, blocks: (B:3:0x0005, B:9:0x001c, B:10:0x0026, B:12:0x002a, B:13:0x002f, B:15:0x0033, B:16:0x0038, B:18:0x003c, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:32:0x0063, B:33:0x0073, B:35:0x0077, B:36:0x0083, B:38:0x0087), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject P() {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "trackId"
            long r2 = r6.f     // Catch: org.json.JSONException -> L8c
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L8c
            int r1 = r6.g     // Catch: org.json.JSONException -> L8c
            r2 = 3
            r3 = 2
            r4 = 1
            java.lang.String r5 = "type"
            if (r1 == r4) goto L23
            if (r1 == r3) goto L20
            if (r1 == r2) goto L1a
            goto L26
        L1a:
            java.lang.String r1 = "VIDEO"
        L1c:
            r0.put(r5, r1)     // Catch: org.json.JSONException -> L8c
            goto L26
        L20:
            java.lang.String r1 = "AUDIO"
            goto L1c
        L23:
            java.lang.String r1 = "TEXT"
            goto L1c
        L26:
            java.lang.String r1 = r6.h     // Catch: org.json.JSONException -> L8c
            if (r1 == 0) goto L2f
            java.lang.String r5 = "trackContentId"
            r0.put(r5, r1)     // Catch: org.json.JSONException -> L8c
        L2f:
            java.lang.String r1 = r6.i     // Catch: org.json.JSONException -> L8c
            if (r1 == 0) goto L38
            java.lang.String r5 = "trackContentType"
            r0.put(r5, r1)     // Catch: org.json.JSONException -> L8c
        L38:
            java.lang.String r1 = r6.j     // Catch: org.json.JSONException -> L8c
            if (r1 == 0) goto L41
            java.lang.String r5 = "name"
            r0.put(r5, r1)     // Catch: org.json.JSONException -> L8c
        L41:
            java.lang.String r1 = r6.k     // Catch: org.json.JSONException -> L8c
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> L8c
            if (r1 != 0) goto L50
            java.lang.String r1 = "language"
            java.lang.String r5 = r6.k     // Catch: org.json.JSONException -> L8c
            r0.put(r1, r5)     // Catch: org.json.JSONException -> L8c
        L50:
            int r1 = r6.l     // Catch: org.json.JSONException -> L8c
            java.lang.String r5 = "subtype"
            if (r1 == r4) goto L70
            if (r1 == r3) goto L6d
            if (r1 == r2) goto L6a
            r2 = 4
            if (r1 == r2) goto L67
            r2 = 5
            if (r1 == r2) goto L61
            goto L73
        L61:
            java.lang.String r1 = "METADATA"
        L63:
            r0.put(r5, r1)     // Catch: org.json.JSONException -> L8c
            goto L73
        L67:
            java.lang.String r1 = "CHAPTERS"
            goto L63
        L6a:
            java.lang.String r1 = "DESCRIPTIONS"
            goto L63
        L6d:
            java.lang.String r1 = "CAPTIONS"
            goto L63
        L70:
            java.lang.String r1 = "SUBTITLES"
            goto L63
        L73:
            java.util.List r1 = r6.m     // Catch: org.json.JSONException -> L8c
            if (r1 == 0) goto L83
            java.lang.String r1 = "roles"
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L8c
            java.util.List r3 = r6.m     // Catch: org.json.JSONException -> L8c
            r2.<init>(r3)     // Catch: org.json.JSONException -> L8c
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L8c
        L83:
            org.json.JSONObject r1 = r6.o     // Catch: org.json.JSONException -> L8c
            if (r1 == 0) goto L8c
            java.lang.String r2 = "customData"
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L8c
        L8c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaTrack.P():org.json.JSONObject");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        JSONObject jSONObject = this.o;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = mediaTrack.o;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || l.a(jSONObject, jSONObject2)) && this.f == mediaTrack.f && this.g == mediaTrack.g && t4.a.k(this.h, mediaTrack.h) && t4.a.k(this.i, mediaTrack.i) && t4.a.k(this.j, mediaTrack.j) && t4.a.k(this.k, mediaTrack.k) && this.l == mediaTrack.l && t4.a.k(this.m, mediaTrack.m);
    }

    public String getName() {
        return this.j;
    }

    public int hashCode() {
        return q.c(Long.valueOf(this.f), Integer.valueOf(this.g), this.h, this.i, this.j, this.k, Integer.valueOf(this.l), this.m, String.valueOf(this.o));
    }

    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.o;
        this.n = jSONObject == null ? null : jSONObject.toString();
        int a2 = c.a(parcel);
        c.o(parcel, 2, J());
        c.l(parcel, 3, O());
        c.t(parcel, 4, H(), false);
        c.t(parcel, 5, I(), false);
        c.t(parcel, 6, getName(), false);
        c.t(parcel, 7, K(), false);
        c.l(parcel, 8, N());
        c.v(parcel, 9, M(), false);
        c.t(parcel, 10, this.n, false);
        c.b(parcel, a2);
    }
}
