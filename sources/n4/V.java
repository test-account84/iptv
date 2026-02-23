package n4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v extends y4.a {
    public final int f;
    public final int g;
    public final int h;
    public static final t4.b i = new t4.b("VideoInfo");
    public static final Parcelable.Creator CREATOR = new y0();

    public v(int i2, int i3, int i4) {
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static n4.v I(org.json.JSONObject r8) {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            if (r8 != 0) goto L6
            return r2
        L6:
            java.lang.String r3 = "hdrType"
            java.lang.String r3 = r8.getString(r3)     // Catch: org.json.JSONException -> L64
            int r4 = r3.hashCode()     // Catch: org.json.JSONException -> L64
            r5 = 3218(0xc92, float:4.51E-42)
            r6 = 2
            r7 = 3
            if (r4 == r5) goto L44
            r5 = 103158(0x192f6, float:1.44555E-40)
            if (r4 == r5) goto L3a
            r5 = 113729(0x1bc41, float:1.59368E-40)
            if (r4 == r5) goto L30
            r5 = 99136405(0x5e8b395, float:2.1883143E-35)
            if (r4 == r5) goto L26
            goto L4e
        L26:
            java.lang.String r4 = "hdr10"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L4e
            r4 = 1
            goto L4f
        L30:
            java.lang.String r4 = "sdr"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L4e
            r4 = 3
            goto L4f
        L3a:
            java.lang.String r4 = "hdr"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L4e
            r4 = 2
            goto L4f
        L44:
            java.lang.String r4 = "dv"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L4e
            r4 = 0
            goto L4f
        L4e:
            r4 = -1
        L4f:
            if (r4 == 0) goto L6a
            if (r4 == r0) goto L68
            if (r4 == r6) goto L66
            if (r4 == r7) goto L6b
            t4.b r4 = n4.v.i     // Catch: org.json.JSONException -> L64
            java.lang.String r5 = "Unknown HDR type: %s"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: org.json.JSONException -> L64
            r0[r1] = r3     // Catch: org.json.JSONException -> L64
            r4.a(r5, r0)     // Catch: org.json.JSONException -> L64
            r0 = 0
            goto L6b
        L64:
            r8 = move-exception
            goto L7d
        L66:
            r0 = 4
            goto L6b
        L68:
            r0 = 2
            goto L6b
        L6a:
            r0 = 3
        L6b:
            n4.v r3 = new n4.v     // Catch: org.json.JSONException -> L64
            java.lang.String r4 = "width"
            int r4 = r8.getInt(r4)     // Catch: org.json.JSONException -> L64
            java.lang.String r5 = "height"
            int r8 = r8.getInt(r5)     // Catch: org.json.JSONException -> L64
            r3.<init>(r4, r8, r0)     // Catch: org.json.JSONException -> L64
            return r3
        L7d:
            t4.b r0 = n4.v.i
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "Error while creating a VideoInfo instance from JSON"
            r0.b(r8, r3, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.v.I(org.json.JSONObject):n4.v");
    }

    public int H() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.g == vVar.getHeight() && this.f == vVar.getWidth() && this.h == vVar.H();
    }

    public int getHeight() {
        return this.g;
    }

    public int getWidth() {
        return this.f;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.g), Integer.valueOf(this.f), Integer.valueOf(this.h));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 2, getWidth());
        y4.c.l(parcel, 3, getHeight());
        y4.c.l(parcel, 4, H());
        y4.c.b(parcel, a);
    }
}
