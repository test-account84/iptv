package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzft extends zzfk {
    static final zzfk zza = new zzft(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzft(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /*  JADX ERROR: Types fix failed
        LL1ili1iI1iI.IIiLliI1l1li1: Several immutable types in one variable: [short[], byte[]], vars: [r5v3 ??, r5v10 ??, r5v6 short[], r5v11 byte[]]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(Unknown Source:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(Unknown Source:21)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(SourceFile:12)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(Unknown Source:53)
        	at jadx.core.dex.visitors.InitCodeVariables.rerun(Unknown Source:24)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(Unknown Source:61)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.IIiLliI1l1li1(Unknown Source:0)
        	at jadx.core.dex.visitors.typeinference.iLLIliliLl1.apply(Unknown Source:4)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(Unknown Source:31)
        */
    public static com.google.android.gms.internal.cast.zzft zzh(int r17, java.lang.Object[] r18, com.google.android.gms.internal.cast.zzfj r19) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzft.zzh(int, java.lang.Object[], com.google.android.gms.internal.cast.zzfj):com.google.android.gms.internal.cast.zzft");
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x0009 A[EDGE_INSN: B:24:0x0009->B:3:0x0009 BREAK  A[LOOP:0: B:17:0x0038->B:21:0x004e], EDGE_INSN: B:35:0x0009->B:3:0x0009 BREAK  A[LOOP:1: B:28:0x0063->B:32:0x007a], EDGE_INSN: B:44:0x0009->B:3:0x0009 BREAK  A[LOOP:2: B:37:0x0089->B:41:0x00a0]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto Lc
        L9:
            r10 = r3
            goto L9c
        Lc:
            r4 = 1
            if (r2 != r4) goto L22
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L9
            r10 = r1[r4]
            r10.getClass()
            goto L9c
        L22:
            if (r0 != 0) goto L25
            goto L9
        L25:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L51
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + (-1)
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.cast.zzfa.zza(r0)
        L38:
            r0 = r0 & r6
            r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L9
        L41:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L4e:
            int r0 = r0 + 1
            goto L38
        L51:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L7d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + (-1)
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.cast.zzfa.zza(r0)
        L63:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L9
        L6d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L7a:
            int r0 = r0 + 1
            goto L63
        L7d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.cast.zzfa.zza(r6)
        L89:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L90
            goto L9
        L90:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r3
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzft.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    public final zzfd zza() {
        return new zzfs(this.zzb, 1, this.zzd);
    }

    public final zzfl zze() {
        return new zzfq(this, this.zzb, 0, this.zzd);
    }

    public final zzfl zzf() {
        return new zzfr(this, new zzfs(this.zzb, 0, this.zzd));
    }
}
