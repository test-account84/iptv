package F3;

import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n {
    public final String[] a;
    public final int[] b;
    public final String[] c;
    public final int d;

    public n(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.a = strArr;
        this.b = iArr;
        this.c = strArr2;
        this.d = i;
    }

    public static n b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new n(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(java.lang.String r12, java.lang.String[] r13, int[] r14, java.lang.String[] r15) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.n.c(java.lang.String, java.lang.String[], int[], java.lang.String[]):int");
    }

    public String a(String str, long j, int i, long j2) {
        String format;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = this.d;
            if (i2 >= i3) {
                sb.append(this.a[i3]);
                return sb.toString();
            }
            sb.append(this.a[i2]);
            int i4 = this.b[i2];
            if (i4 == 1) {
                sb.append(str);
            } else {
                if (i4 == 2) {
                    format = String.format(Locale.US, this.c[i2], new Object[]{Long.valueOf(j)});
                } else if (i4 == 3) {
                    format = String.format(Locale.US, this.c[i2], new Object[]{Integer.valueOf(i)});
                } else if (i4 == 4) {
                    format = String.format(Locale.US, this.c[i2], new Object[]{Long.valueOf(j2)});
                }
                sb.append(format);
            }
            i2++;
        }
    }
}
