package M4;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class K1 {
    public final String a;
    public final Bundle b;
    public Bundle c;
    public final /* synthetic */ P1 d;

    public K1(P1 p1, String str, Bundle bundle) {
        this.d = p1;
        com.google.android.gms.common.internal.r.g("default_event_parameters");
        this.a = "default_event_parameters";
        this.b = new Bundle();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[Catch: JSONException | NumberFormatException -> 0x00a3, JSONException | NumberFormatException -> 0x00a3, TRY_LEAVE, TryCatch #0 {JSONException | NumberFormatException -> 0x00a3, blocks: (B:13:0x0027, B:27:0x0071, B:27:0x0071, B:30:0x0083, B:30:0x0083, B:32:0x008f, B:32:0x008f, B:34:0x009b, B:34:0x009b), top: B:12:0x0027, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle a() {
        /*
            r11 = this;
            android.os.Bundle r0 = r11.c
            if (r0 == 0) goto L6
            goto Ld4
        L6:
            M4.P1 r0 = r11.d
            android.content.SharedPreferences r0 = r0.o()
            java.lang.String r1 = r11.a
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 == 0) goto Lcc
            android.os.Bundle r1 = new android.os.Bundle     // Catch: org.json.JSONException -> Lbb
            r1.<init>()     // Catch: org.json.JSONException -> Lbb
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> Lbb
            r2.<init>(r0)     // Catch: org.json.JSONException -> Lbb
            r0 = 0
            r3 = 0
        L21:
            int r4 = r2.length()     // Catch: org.json.JSONException -> Lbb
            if (r3 >= r4) goto Lb8
            org.json.JSONObject r4 = r2.getJSONObject(r3)     // Catch: java.lang.Throwable -> La3
            java.lang.String r5 = "n"
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> La3
            java.lang.String r6 = "t"
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> La3
            int r7 = r6.hashCode()     // Catch: java.lang.Throwable -> La3
            r8 = 100
            r9 = 2
            r10 = 1
            if (r7 == r8) goto L5e
            r8 = 108(0x6c, float:1.51E-43)
            if (r7 == r8) goto L54
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L4a
            goto L68
        L4a:
            java.lang.String r7 = "s"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L68
            r7 = 0
            goto L69
        L54:
            java.lang.String r7 = "l"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L68
            r7 = 2
            goto L69
        L5e:
            java.lang.String r7 = "d"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L68
            r7 = 1
            goto L69
        L68:
            r7 = -1
        L69:
            java.lang.String r8 = "v"
            if (r7 == 0) goto L9b
            if (r7 == r10) goto L8f
            if (r7 == r9) goto L83
            M4.P1 r4 = r11.d     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            M4.l2 r4 = r4.a     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            M4.z1 r4 = r4.d()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            M4.x1 r4 = r4.r()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            java.lang.String r5 = "Unrecognized persisted bundle type. Type"
            r4.b(r5, r6)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            goto Lb4
        L83:
            java.lang.String r4 = r4.getString(r8)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            long r6 = java.lang.Long.parseLong(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            r1.putLong(r5, r6)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            goto Lb4
        L8f:
            java.lang.String r4 = r4.getString(r8)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            double r6 = java.lang.Double.parseDouble(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            r1.putDouble(r5, r6)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            goto Lb4
        L9b:
            java.lang.String r4 = r4.getString(r8)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            r1.putString(r5, r4)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La3
            goto Lb4
        La3:
            M4.P1 r4 = r11.d     // Catch: org.json.JSONException -> Lbb
            M4.l2 r4 = r4.a     // Catch: org.json.JSONException -> Lbb
            M4.z1 r4 = r4.d()     // Catch: org.json.JSONException -> Lbb
            M4.x1 r4 = r4.r()     // Catch: org.json.JSONException -> Lbb
            java.lang.String r5 = "Error reading value from SharedPreferences. Value dropped"
            r4.a(r5)     // Catch: org.json.JSONException -> Lbb
        Lb4:
            int r3 = r3 + 1
            goto L21
        Lb8:
            r11.c = r1     // Catch: org.json.JSONException -> Lbb
            goto Lcc
        Lbb:
            M4.P1 r0 = r11.d
            M4.l2 r0 = r0.a
            M4.z1 r0 = r0.d()
            M4.x1 r0 = r0.r()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.a(r1)
        Lcc:
            android.os.Bundle r0 = r11.c
            if (r0 != 0) goto Ld4
            android.os.Bundle r0 = r11.b
            r11.c = r0
        Ld4:
            android.os.Bundle r0 = r11.c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.K1.a():android.os.Bundle");
    }

    public final void b(Bundle bundle) {
        String str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.d.o().edit();
        if (bundle.size() == 0) {
            edit.remove(this.a);
        } else {
            String str2 = this.a;
            JSONArray jSONArray = new JSONArray();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str3);
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            str = "s";
                        } else if (obj instanceof Long) {
                            str = "l";
                        } else if (obj instanceof Double) {
                            str = "d";
                        } else {
                            this.d.a.d().r().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONObject.put("t", str);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        this.d.a.d().r().b("Cannot serialize bundle value to SharedPreferences", e);
                    }
                }
            }
            edit.putString(str2, jSONArray.toString());
        }
        edit.apply();
        this.c = bundle;
    }
}
