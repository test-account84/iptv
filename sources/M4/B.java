package M4;

import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends E4 {
    public String d;
    public Set e;
    public Map f;
    public Long g;
    public Long h;

    public b(S4 s4) {
        super(s4);
    }

    public final boolean l() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0a30, code lost:
    
        if (r13 != false) goto L485;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0931  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x072f A[PHI: r0 r5 r22 r27 r28
      0x072f: PHI (r0v90 java.util.Map) = (r0v92 java.util.Map), (r0v98 java.util.Map) binds: [B:252:0x0764, B:262:0x072b] A[DONT_GENERATE, DONT_INLINE]
      0x072f: PHI (r5v29 android.database.Cursor) = (r5v30 android.database.Cursor), (r5v31 android.database.Cursor) binds: [B:252:0x0764, B:262:0x072b] A[DONT_GENERATE, DONT_INLINE]
      0x072f: PHI (r22v10 M4.r) = (r22v11 M4.r), (r22v15 M4.r) binds: [B:252:0x0764, B:262:0x072b] A[DONT_GENERATE, DONT_INLINE]
      0x072f: PHI (r27v7 java.lang.String) = (r27v8 java.lang.String), (r27v11 java.lang.String) binds: [B:252:0x0764, B:262:0x072b] A[DONT_GENERATE, DONT_INLINE]
      0x072f: PHI (r28v8 java.lang.String) = (r28v9 java.lang.String), (r28v11 java.lang.String) binds: [B:252:0x0764, B:262:0x072b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ac A[Catch: all -> 0x01ba, SQLiteException -> 0x01bd, TRY_LEAVE, TryCatch #18 {all -> 0x01ba, blocks: (B:40:0x01a6, B:42:0x01ac, B:455:0x01c4, B:456:0x01c9, B:458:0x01d3, B:459:0x01e3, B:460:0x020f, B:473:0x01f2, B:476:0x0202, B:479:0x0208, B:467:0x0235), top: B:39:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x01c4 A[Catch: all -> 0x01ba, SQLiteException -> 0x01bd, TRY_ENTER, TryCatch #18 {all -> 0x01ba, blocks: (B:40:0x01a6, B:42:0x01ac, B:455:0x01c4, B:456:0x01c9, B:458:0x01d3, B:459:0x01e3, B:460:0x020f, B:473:0x01f2, B:476:0x0202, B:479:0x0208, B:467:0x0235), top: B:39:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:469:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0a55  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x081d  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List m(java.lang.String r64, java.util.List r65, java.util.List r66, java.lang.Long r67, java.lang.Long r68) {
        /*
            Method dump skipped, instructions count: 2790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.b.m(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    public final j5 n(Integer num) {
        if (this.f.containsKey(num)) {
            return (j5) this.f.get(num);
        }
        j5 j5Var = new j5(this, this.d, null);
        this.f.put(num, j5Var);
        return j5Var;
    }

    public final boolean o(int i, int i2) {
        j5 j5Var = (j5) this.f.get(Integer.valueOf(i));
        if (j5Var == null) {
            return false;
        }
        return j5.b(j5Var).get(i2);
    }
}
