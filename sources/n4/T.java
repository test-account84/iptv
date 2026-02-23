package n4;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t extends y4.a {
    public static final Parcelable.Creator CREATOR = new w0();
    public float f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public int o;
    public int p;
    public String q;
    public JSONObject r;

    public t() {
        this(1.0f, 0, 0, -1, 0, -1, 0, 0, null, -1, -1, null);
    }

    public static final int T(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public static final String U(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    public int H() {
        return this.h;
    }

    public int I() {
        return this.j;
    }

    public int J() {
        return this.i;
    }

    public String K() {
        return this.n;
    }

    public int L() {
        return this.o;
    }

    public float M() {
        return this.f;
    }

    public int N() {
        return this.p;
    }

    public int O() {
        return this.g;
    }

    public int P() {
        return this.l;
    }

    public int Q() {
        return this.m;
    }

    public int R() {
        return this.k;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d6 A[Catch: JSONException -> 0x00db, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00db, blocks: (B:3:0x0005, B:5:0x0011, B:6:0x001a, B:8:0x001e, B:9:0x0027, B:18:0x003e, B:19:0x004e, B:21:0x0052, B:22:0x005b, B:27:0x0068, B:28:0x0075, B:30:0x0079, B:31:0x0082, B:33:0x0086, B:34:0x008d, B:36:0x0091, B:37:0x0096, B:41:0x00a0, B:48:0x00b6, B:55:0x00c5, B:56:0x00d2, B:58:0x00d6, B:64:0x00cf, B:65:0x006e, B:66:0x0072, B:70:0x004b), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cf A[Catch: JSONException -> 0x00db, TryCatch #0 {JSONException -> 0x00db, blocks: (B:3:0x0005, B:5:0x0011, B:6:0x001a, B:8:0x001e, B:9:0x0027, B:18:0x003e, B:19:0x004e, B:21:0x0052, B:22:0x005b, B:27:0x0068, B:28:0x0075, B:30:0x0079, B:31:0x0082, B:33:0x0086, B:34:0x008d, B:36:0x0091, B:37:0x0096, B:41:0x00a0, B:48:0x00b6, B:55:0x00c5, B:56:0x00d2, B:58:0x00d6, B:64:0x00cf, B:65:0x006e, B:66:0x0072, B:70:0x004b), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject S() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.t.S():org.json.JSONObject");
    }

    public void c(JSONObject jSONObject) {
        int i;
        this.f = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.g = T(jSONObject.optString("foregroundColor"));
        this.h = T(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.i = 0;
            } else if ("OUTLINE".equals(string)) {
                this.i = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.i = 2;
            } else if ("RAISED".equals(string)) {
                this.i = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.i = 4;
            }
        }
        this.j = T(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.k = 0;
            } else if ("NORMAL".equals(string2)) {
                this.k = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.k = 2;
            }
        }
        this.l = T(jSONObject.optString("windowColor"));
        if (this.k == 2) {
            this.m = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.n = t4.a.c(jSONObject, "fontFamily");
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.o = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.o = 1;
            } else if ("SERIF".equals(string3)) {
                this.o = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.o = 3;
            } else if ("CASUAL".equals(string3)) {
                this.o = 4;
            } else {
                if (!"CURSIVE".equals(string3)) {
                    i = "SMALL_CAPITALS".equals(string3) ? 6 : 5;
                }
                this.o = i;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.p = 0;
            } else if ("BOLD".equals(string4)) {
                this.p = 1;
            } else if ("ITALIC".equals(string4)) {
                this.p = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.p = 3;
            }
        }
        this.r = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        JSONObject jSONObject = this.r;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = tVar.r;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || C4.l.a(jSONObject, jSONObject2)) && this.f == tVar.f && this.g == tVar.g && this.h == tVar.h && this.i == tVar.i && this.j == tVar.j && this.k == tVar.k && this.l == tVar.l && this.m == tVar.m && t4.a.k(this.n, tVar.n) && this.o == tVar.o && this.p == tVar.p;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Float.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.m), this.n, Integer.valueOf(this.o), Integer.valueOf(this.p), String.valueOf(this.r));
    }

    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.r;
        this.q = jSONObject == null ? null : jSONObject.toString();
        int a = y4.c.a(parcel);
        y4.c.i(parcel, 2, M());
        y4.c.l(parcel, 3, O());
        y4.c.l(parcel, 4, H());
        y4.c.l(parcel, 5, J());
        y4.c.l(parcel, 6, I());
        y4.c.l(parcel, 7, R());
        y4.c.l(parcel, 8, P());
        y4.c.l(parcel, 9, Q());
        y4.c.t(parcel, 10, K(), false);
        y4.c.l(parcel, 11, L());
        y4.c.l(parcel, 12, N());
        y4.c.t(parcel, 13, this.q, false);
        y4.c.b(parcel, a);
    }

    public t(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, int i9, String str2) {
        this.f = f;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        this.l = i6;
        this.m = i7;
        this.n = str;
        this.o = i8;
        this.p = i9;
        this.q = str2;
        if (str2 == null) {
            this.r = null;
            return;
        }
        try {
            this.r = new JSONObject(this.q);
        } catch (JSONException unused) {
            this.r = null;
            this.q = null;
        }
    }
}
