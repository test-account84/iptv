package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzafw implements zzacs {
    private static final String zza = "zzafw";
    private String zzb;
    private String zzc;
    private String zzd;
    private zzafr zze;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0095  */
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.firebase-auth-api.zzafw zza(java.lang.String r17) throws com.google.android.gms.internal.firebase-auth-api.zzaaf {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "mfaInfo"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            r3.<init>(r2)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            java.lang.String r4 = "email"
            java.lang.String r4 = r3.optString(r4)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            java.lang.String r4 = C4.o.a(r4)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            r1.zzb = r4     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            java.lang.String r4 = "newEmail"
            java.lang.String r4 = r3.optString(r4)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            java.lang.String r4 = C4.o.a(r4)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            r1.zzc = r4     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            java.lang.String r4 = "reqType"
            int r4 = r3.optInt(r4)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            java.lang.String r5 = "PASSWORD_RESET"
            java.lang.String r6 = "VERIFY_EMAIL"
            java.lang.String r7 = "RECOVER_EMAIL"
            java.lang.String r8 = "EMAIL_SIGNIN"
            java.lang.String r9 = "VERIFY_AND_CHANGE_EMAIL"
            java.lang.String r10 = "REVERT_SECOND_FACTOR_ADDITION"
            r12 = 1
            if (r4 == r12) goto L47
            switch(r4) {
                case 4: goto L45;
                case 5: goto L43;
                case 6: goto L41;
                case 7: goto L3f;
                case 8: goto L3d;
                default: goto L3b;
            }
        L3b:
            r4 = 0
            goto L48
        L3d:
            r4 = r10
            goto L48
        L3f:
            r4 = r9
            goto L48
        L41:
            r4 = r8
            goto L48
        L43:
            r4 = r7
            goto L48
        L45:
            r4 = r6
            goto L48
        L47:
            r4 = r5
        L48:
            r1.zzd = r4     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            if (r4 == 0) goto La8
            java.lang.String r4 = "requestType"
            java.lang.String r4 = r3.optString(r4)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            int r13 = r4.hashCode()     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            r15 = 3
            r11 = 2
            r14 = 4
            switch(r13) {
                case -1874510116: goto L8d;
                case -1452371317: goto L85;
                case -1341836234: goto L7d;
                case -1099157829: goto L75;
                case 870738373: goto L6d;
                case 970484929: goto L61;
                default: goto L60;
            }     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
        L60:
            goto L95
        L61:
            boolean r5 = r4.equals(r7)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            if (r5 == 0) goto L95
            r5 = 4
            goto L96
        L69:
            r0 = move-exception
            goto Lb9
        L6b:
            r0 = move-exception
            goto Lb9
        L6d:
            boolean r5 = r4.equals(r8)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            if (r5 == 0) goto L95
            r5 = 2
            goto L96
        L75:
            boolean r5 = r4.equals(r9)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            if (r5 == 0) goto L95
            r5 = 3
            goto L96
        L7d:
            boolean r5 = r4.equals(r6)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            if (r5 == 0) goto L95
            r5 = 0
            goto L96
        L85:
            boolean r5 = r4.equals(r5)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            if (r5 == 0) goto L95
            r5 = 1
            goto L96
        L8d:
            boolean r5 = r4.equals(r10)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            if (r5 == 0) goto L95
            r5 = 5
            goto L96
        L95:
            r5 = -1
        L96:
            if (r5 == 0) goto La5
            if (r5 == r12) goto La5
            if (r5 == r11) goto La5
            if (r5 == r15) goto La5
            if (r5 == r14) goto La5
            r6 = 5
            if (r5 == r6) goto La5
            r11 = 0
            goto La6
        La5:
            r11 = r4
        La6:
            r1.zzd = r11     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
        La8:
            boolean r4 = r3.has(r0)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            if (r4 == 0) goto Lb8
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            com.google.android.gms.internal.firebase-auth-api.zzafr r0 = com.google.android.gms.internal.firebase-auth-api.zzafr.zza(r0)     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
            r1.zze = r0     // Catch: java.lang.NullPointerException -> L69 org.json.JSONException -> L6b
        Lb8:
            return r1
        Lb9:
            java.lang.String r3 = com.google.android.gms.internal.firebase-auth-api.zzafw.zza
            com.google.android.gms.internal.firebase-auth-api.zzaaf r0 = com.google.android.gms.internal.firebase-auth-api.zzahc.zza(r0, r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzafw.zza(java.lang.String):com.google.android.gms.internal.firebase-auth-api.zzafw");
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zzb != null;
    }

    public final boolean zzf() {
        return this.zze != null;
    }

    public final boolean zzg() {
        return this.zzc != null;
    }

    public final boolean zzh() {
        return this.zzd != null;
    }

    public final zzafr zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzb;
    }
}
