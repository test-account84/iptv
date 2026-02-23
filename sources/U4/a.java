package u4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Integer a(java.lang.String r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            int r1 = r6.hashCode()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1118317585: goto L2e;
                case -962896020: goto L24;
                case 1645938909: goto L1a;
                case 1645952171: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L38
        L10:
            java.lang.String r1 = "REPEAT_OFF"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L38
            r6 = 0
            goto L39
        L1a:
            java.lang.String r1 = "REPEAT_ALL"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L38
            r6 = 1
            goto L39
        L24:
            java.lang.String r1 = "REPEAT_SINGLE"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L38
            r6 = 2
            goto L39
        L2e:
            java.lang.String r1 = "REPEAT_ALL_AND_SHUFFLE"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L38
            r6 = 3
            goto L39
        L38:
            r6 = -1
        L39:
            if (r6 == 0) goto L51
            if (r6 == r5) goto L4c
            if (r6 == r4) goto L47
            if (r6 == r3) goto L42
            return r0
        L42:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            return r6
        L47:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            return r6
        L4c:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            return r6
        L51:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.a.a(java.lang.String):java.lang.Integer");
    }

    public static String b(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return "REPEAT_OFF";
        }
        if (intValue == 1) {
            return "REPEAT_ALL";
        }
        if (intValue == 2) {
            return "REPEAT_SINGLE";
        }
        if (intValue != 3) {
            return null;
        }
        return "REPEAT_ALL_AND_SHUFFLE";
    }
}
