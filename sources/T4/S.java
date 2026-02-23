package t4;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s extends z {
    public static final String C;
    public final x A;
    public final x B;
    public long e;
    public n4.r f;
    public Long g;
    public p h;
    public int i;
    public final x j;
    public final x k;
    public final x l;
    public final x m;
    public final x n;
    public final x o;
    public final x p;
    public final x q;
    public final x r;
    public final x s;
    public final x t;
    public final x u;
    public final x v;
    public final x w;
    public final x x;
    public final x y;
    public final x z;

    static {
        Pattern pattern = a.a;
        C = "urn:x-cast:com.google.cast.media";
    }

    public s(String str) {
        super(C, "MediaControlChannel", null);
        this.i = -1;
        x xVar = new x(86400000L);
        this.j = xVar;
        x xVar2 = new x(86400000L);
        this.k = xVar2;
        x xVar3 = new x(86400000L);
        this.l = xVar3;
        x xVar4 = new x(86400000L);
        this.m = xVar4;
        x xVar5 = new x(10000L);
        this.n = xVar5;
        x xVar6 = new x(86400000L);
        this.o = xVar6;
        x xVar7 = new x(86400000L);
        this.p = xVar7;
        x xVar8 = new x(86400000L);
        this.q = xVar8;
        x xVar9 = new x(86400000L);
        this.r = xVar9;
        x xVar10 = new x(86400000L);
        this.s = xVar10;
        x xVar11 = new x(86400000L);
        this.t = xVar11;
        x xVar12 = new x(86400000L);
        this.u = xVar12;
        x xVar13 = new x(86400000L);
        this.v = xVar13;
        x xVar14 = new x(86400000L);
        this.w = xVar14;
        x xVar15 = new x(86400000L);
        this.x = xVar15;
        x xVar16 = new x(86400000L);
        this.z = xVar16;
        this.y = new x(86400000L);
        x xVar17 = new x(86400000L);
        this.A = xVar17;
        x xVar18 = new x(86400000L);
        this.B = xVar18;
        h(xVar);
        h(xVar2);
        h(xVar3);
        h(xVar4);
        h(xVar5);
        h(xVar6);
        h(xVar7);
        h(xVar8);
        h(xVar9);
        h(xVar10);
        h(xVar11);
        h(xVar12);
        h(xVar13);
        h(xVar14);
        h(xVar15);
        h(xVar16);
        h(xVar16);
        h(xVar17);
        h(xVar18);
        w();
    }

    public static int[] D(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            iArr[i] = jSONArray.getInt(i);
        }
        return iArr;
    }

    public static /* bridge */ /* synthetic */ int E(s sVar) {
        return sVar.i;
    }

    public static /* bridge */ /* synthetic */ p p(s sVar) {
        return sVar.h;
    }

    public static /* bridge */ /* synthetic */ void q(s sVar, Long l) {
        sVar.g = null;
    }

    public static r v(JSONObject jSONObject) {
        MediaError L = MediaError.L(jSONObject);
        r rVar = new r();
        Pattern pattern = a.a;
        rVar.a = jSONObject.has("customData") ? jSONObject.optJSONObject("customData") : null;
        rVar.b = L;
        return rVar;
    }

    public final void A() {
        p pVar = this.h;
        if (pVar != null) {
            pVar.zzk();
        }
    }

    public final void B() {
        p pVar = this.h;
        if (pVar != null) {
            pVar.zzm();
        }
    }

    public final boolean C() {
        return this.i != -1;
    }

    public final long F() {
        n4.r rVar;
        n4.c I;
        if (this.e == 0 || (rVar = this.f) == null || (I = rVar.I()) == null) {
            return 0L;
        }
        double T = rVar.T();
        if (T == 0.0d) {
            T = 1.0d;
        }
        return u(rVar.U() != 2 ? 0.0d : T, I.J(), 0L);
    }

    public final long G() {
        n4.j Q;
        n4.r rVar = this.f;
        if (rVar == null || (Q = rVar.Q()) == null) {
            return 0L;
        }
        long H = Q.H();
        return !Q.J() ? u(1.0d, H, -1L) : H;
    }

    public final long H() {
        n4.j Q;
        n4.r rVar = this.f;
        if (rVar == null || (Q = rVar.Q()) == null) {
            return 0L;
        }
        long I = Q.I();
        if (Q.K()) {
            I = u(1.0d, I, -1L);
        }
        return Q.J() ? Math.min(I, Q.H()) : I;
    }

    public final long I() {
        n4.r rVar;
        MediaInfo n = n();
        if (n == null || (rVar = this.f) == null) {
            return 0L;
        }
        Long l = this.g;
        if (l == null) {
            if (this.e == 0) {
                return 0L;
            }
            double T = rVar.T();
            long c0 = rVar.c0();
            return (T == 0.0d || rVar.U() != 2) ? c0 : u(T, c0, n.S());
        }
        if (l.equals(4294967296000L)) {
            if (this.f.Q() != null) {
                return Math.min(l.longValue(), G());
            }
            if (K() >= 0) {
                return Math.min(l.longValue(), K());
            }
        }
        return l.longValue();
    }

    public final long J() {
        n4.r rVar = this.f;
        if (rVar != null) {
            return rVar.zzb();
        }
        throw new q();
    }

    public final long K() {
        MediaInfo n = n();
        if (n != null) {
            return n.S();
        }
        return 0L;
    }

    public final long L(v vVar, n4.l lVar) {
        if (lVar.M() == null && lVar.O() == null) {
            throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
        }
        JSONObject Q = lVar.Q();
        if (Q == null) {
            throw new IllegalArgumentException("Failed to jsonify the load request due to malformed request");
        }
        long a = a();
        try {
            Q.put("requestId", a);
            Q.put("type", "LOAD");
        } catch (JSONException unused) {
        }
        d(Q.toString(), a, null);
        this.j.b(a, vVar);
        return a;
    }

    public final long M(v vVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long a = a();
        try {
            jSONObject2.put("requestId", a);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", J());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        d(jSONObject2.toString(), a, null);
        this.k.b(a, vVar);
        return a;
    }

    public final long N(v vVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long a = a();
        try {
            jSONObject2.put("requestId", a);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", J());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        d(jSONObject2.toString(), a, null);
        this.l.b(a, vVar);
        return a;
    }

    public final long O(v vVar) {
        JSONObject jSONObject = new JSONObject();
        long a = a();
        try {
            jSONObject.put("requestId", a);
            jSONObject.put("type", "QUEUE_GET_ITEM_IDS");
            jSONObject.put("mediaSessionId", J());
        } catch (JSONException unused) {
        }
        d(jSONObject.toString(), a, null);
        this.x.b(a, vVar);
        return a;
    }

    public final long P(v vVar, int[] iArr) {
        JSONObject jSONObject = new JSONObject();
        long a = a();
        try {
            jSONObject.put("requestId", a);
            jSONObject.put("type", "QUEUE_GET_ITEMS");
            jSONObject.put("mediaSessionId", J());
            JSONArray jSONArray = new JSONArray();
            for (int i : iArr) {
                jSONArray.put(i);
            }
            jSONObject.put("itemIds", jSONArray);
        } catch (JSONException unused) {
        }
        d(jSONObject.toString(), a, null);
        this.y.b(a, vVar);
        return a;
    }

    public final long Q(v vVar, n4.p[] pVarArr, int i, int i2, long j, JSONObject jSONObject) {
        int length;
        String b;
        if (pVarArr == null || (length = pVarArr.length) == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        }
        if (i < 0 || i >= length) {
            throw new IllegalArgumentException("Invalid startIndex: " + i);
        }
        if (j != -1 && j < 0) {
            throw new IllegalArgumentException("playPosition can not be negative: " + j);
        }
        JSONObject jSONObject2 = new JSONObject();
        long a = a();
        this.j.b(a, vVar);
        try {
            jSONObject2.put("requestId", a);
            jSONObject2.put("type", "QUEUE_LOAD");
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < pVarArr.length; i3++) {
                jSONArray.put(i3, pVarArr[i3].Q());
            }
            jSONObject2.put("items", jSONArray);
            b = u4.a.b(Integer.valueOf(i2));
        } catch (JSONException unused) {
        }
        if (b == null) {
            throw new IllegalArgumentException("Invalid repeat mode: " + i2);
        }
        jSONObject2.put("repeatMode", b);
        jSONObject2.put("startIndex", i);
        if (j != -1) {
            jSONObject2.put("currentTime", a.b(j));
        }
        if (jSONObject != null) {
            jSONObject2.put("customData", jSONObject);
        }
        if (C()) {
            jSONObject2.put("sequenceNumber", this.i);
        }
        d(jSONObject2.toString(), a, null);
        return a;
    }

    public final long R(v vVar, int[] iArr, JSONObject jSONObject) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long a = a();
        try {
            jSONObject2.put("requestId", a);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", J());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iArr.length; i++) {
                jSONArray.put(i, iArr[i]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (C()) {
                jSONObject2.put("sequenceNumber", this.i);
            }
        } catch (JSONException unused) {
        }
        d(jSONObject2.toString(), a, null);
        this.v.b(a, new o(this, vVar));
        return a;
    }

    public final long S(v vVar, int[] iArr, int i, JSONObject jSONObject) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long a = a();
        try {
            jSONObject2.put("requestId", a);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", J());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (C()) {
                jSONObject2.put("sequenceNumber", this.i);
            }
        } catch (JSONException unused) {
        }
        d(jSONObject2.toString(), a, null);
        this.w.b(a, new o(this, vVar));
        return a;
    }

    public final void c() {
        g();
        w();
    }

    public final long i(v vVar, int i, long j, n4.p[] pVarArr, int i2, Boolean bool, Integer num, JSONObject jSONObject) {
        if (j != -1 && j < 0) {
            throw new IllegalArgumentException("playPosition cannot be negative: " + j);
        }
        JSONObject jSONObject2 = new JSONObject();
        long a = a();
        try {
            jSONObject2.put("requestId", a);
            jSONObject2.put("type", "QUEUE_UPDATE");
            jSONObject2.put("mediaSessionId", J());
            if (i != 0) {
                jSONObject2.put("currentItemId", i);
            }
            if (i2 != 0) {
                jSONObject2.put("jump", i2);
            }
            if (pVarArr != null && pVarArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < pVarArr.length; i3++) {
                    jSONArray.put(i3, pVarArr[i3].Q());
                }
                jSONObject2.put("items", jSONArray);
            }
            if (bool != null) {
                jSONObject2.put("shuffle", bool);
            }
            String b = u4.a.b(num);
            if (b != null) {
                jSONObject2.put("repeatMode", b);
            }
            if (j != -1) {
                jSONObject2.put("currentTime", a.b(j));
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (C()) {
                jSONObject2.put("sequenceNumber", this.i);
            }
        } catch (JSONException unused) {
        }
        d(jSONObject2.toString(), a, null);
        this.u.b(a, new o(this, vVar));
        return a;
    }

    public final long j(v vVar) {
        JSONObject jSONObject = new JSONObject();
        long a = a();
        try {
            jSONObject.put("requestId", a);
            jSONObject.put("type", "GET_STATUS");
            n4.r rVar = this.f;
            if (rVar != null) {
                jSONObject.put("mediaSessionId", rVar.zzb());
            }
        } catch (JSONException unused) {
        }
        d(jSONObject.toString(), a, null);
        this.q.b(a, vVar);
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056 A[Catch: JSONException -> 0x005f, TRY_LEAVE, TryCatch #0 {JSONException -> 0x005f, blocks: (B:5:0x0019, B:9:0x0042, B:10:0x0050, B:12:0x0056, B:17:0x0046), top: B:4:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long k(t4.v r9, n4.q r10) {
        /*
            r8 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            long r1 = r8.a()
            boolean r3 = r10.d()
            if (r3 == 0) goto L15
            r3 = 4294967296000(0x3e800000000, double:2.1219957909653E-311)
            goto L19
        L15:
            long r3 = r10.b()
        L19:
            java.lang.String r5 = "requestId"
            r0.put(r5, r1)     // Catch: org.json.JSONException -> L5f
            java.lang.String r5 = "type"
            java.lang.String r6 = "SEEK"
            r0.put(r5, r6)     // Catch: org.json.JSONException -> L5f
            java.lang.String r5 = "mediaSessionId"
            long r6 = r8.J()     // Catch: org.json.JSONException -> L5f
            r0.put(r5, r6)     // Catch: org.json.JSONException -> L5f
            java.lang.String r5 = "currentTime"
            double r6 = t4.a.b(r3)     // Catch: org.json.JSONException -> L5f
            r0.put(r5, r6)     // Catch: org.json.JSONException -> L5f
            int r5 = r10.c()     // Catch: org.json.JSONException -> L5f
            r6 = 1
            java.lang.String r7 = "resumeState"
            if (r5 != r6) goto L46
            java.lang.String r5 = "PLAYBACK_START"
        L42:
            r0.put(r7, r5)     // Catch: org.json.JSONException -> L5f
            goto L50
        L46:
            int r5 = r10.c()     // Catch: org.json.JSONException -> L5f
            r6 = 2
            if (r5 != r6) goto L50
            java.lang.String r5 = "PLAYBACK_PAUSE"
            goto L42
        L50:
            org.json.JSONObject r5 = r10.a()     // Catch: org.json.JSONException -> L5f
            if (r5 == 0) goto L5f
            java.lang.String r5 = "customData"
            org.json.JSONObject r10 = r10.a()     // Catch: org.json.JSONException -> L5f
            r0.put(r5, r10)     // Catch: org.json.JSONException -> L5f
        L5f:
            java.lang.String r10 = r0.toString()
            r0 = 0
            r8.d(r10, r1, r0)
            java.lang.Long r10 = java.lang.Long.valueOf(r3)
            r8.g = r10
            t4.x r10 = r8.n
            t4.n r0 = new t4.n
            r0.<init>(r8, r9)
            r10.b(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.s.k(t4.v, n4.q):long");
    }

    public final long l(v vVar, long[] jArr) {
        if (jArr == null) {
            throw new IllegalArgumentException("trackIds cannot be null");
        }
        JSONObject jSONObject = new JSONObject();
        long a = a();
        try {
            jSONObject.put("requestId", a);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", J());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException unused) {
        }
        d(jSONObject.toString(), a, null);
        this.r.b(a, vVar);
        return a;
    }

    public final long m(v vVar) {
        JSONObject jSONObject = new JSONObject();
        long a = a();
        try {
            jSONObject.put("requestId", a);
            jSONObject.put("type", "SKIP_AD");
            jSONObject.put("mediaSessionId", J());
        } catch (JSONException e) {
            this.a.f(String.format(Locale.ROOT, "Error creating SkipAd message: %s", new Object[]{e.getMessage()}), new Object[0]);
        }
        d(jSONObject.toString(), a, null);
        this.B.b(a, vVar);
        return a;
    }

    public final MediaInfo n() {
        n4.r rVar = this.f;
        if (rVar == null) {
            return null;
        }
        return rVar.S();
    }

    public final n4.r o() {
        return this.f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x025e A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027b A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x028b A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0298 A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02a2 A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02aa A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b1 A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b8 A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02c9 A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0268 A[Catch: JSONException -> 0x00c4, TryCatch #0 {JSONException -> 0x00c4, blocks: (B:3:0x0014, B:11:0x0094, B:13:0x00a0, B:14:0x00ad, B:16:0x00b3, B:18:0x00c7, B:22:0x00cd, B:24:0x00d9, B:26:0x00ed, B:35:0x0128, B:37:0x013d, B:39:0x0159, B:42:0x015f, B:44:0x0165, B:46:0x016b, B:60:0x0171, B:62:0x017d, B:64:0x0187, B:68:0x018d, B:69:0x0195, B:71:0x019b, B:73:0x01ab, B:77:0x01b1, B:79:0x01bb, B:80:0x01cc, B:82:0x01d2, B:85:0x01e2, B:87:0x01ee, B:89:0x01fa, B:90:0x020b, B:92:0x0211, B:95:0x0221, B:97:0x022d, B:99:0x023f, B:104:0x025e, B:107:0x0263, B:108:0x0277, B:110:0x027b, B:111:0x0287, B:113:0x028b, B:114:0x0294, B:116:0x0298, B:117:0x029e, B:119:0x02a2, B:120:0x02a5, B:122:0x02aa, B:123:0x02ad, B:125:0x02b1, B:126:0x02b4, B:128:0x02b8, B:130:0x02c2, B:131:0x02c5, B:133:0x02c9, B:134:0x02e1, B:135:0x02e9, B:137:0x02ef, B:140:0x0268, B:141:0x024a, B:143:0x0252, B:147:0x02d3), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.s.r(java.lang.String):void");
    }

    public final void s(long j, int i) {
        Iterator it = f().iterator();
        while (it.hasNext()) {
            ((x) it.next()).d(j, i, null);
        }
    }

    public final void t(p pVar) {
        this.h = pVar;
    }

    public final long u(double d, long j, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.e;
        if (elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        if (elapsedRealtime == 0) {
            return j;
        }
        long j3 = j + ((long) (elapsedRealtime * d));
        if (j2 > 0 && j3 > j2) {
            return j2;
        }
        if (j3 >= 0) {
            return j3;
        }
        return 0L;
    }

    public final void w() {
        this.e = 0L;
        this.f = null;
        Iterator it = f().iterator();
        while (it.hasNext()) {
            ((x) it.next()).c(2002);
        }
    }

    public final void x(JSONObject jSONObject, String str) {
        if (jSONObject.has("sequenceNumber")) {
            this.i = jSONObject.optInt("sequenceNumber", -1);
        } else {
            this.a.f(str.concat(" message is missing a sequence number."), new Object[0]);
        }
    }

    public final void y() {
        p pVar = this.h;
        if (pVar != null) {
            pVar.zzc();
        }
    }

    public final void z() {
        p pVar = this.h;
        if (pVar != null) {
            pVar.zzd();
        }
    }
}
