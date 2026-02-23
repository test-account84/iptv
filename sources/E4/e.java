package e4;

import d4.M;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e {
    public final int a;
    public final int b;
    public final String c;

    public e(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public static e a(M m) {
        String str;
        m.V(2);
        int H = m.H();
        int i = H >> 1;
        int H2 = ((m.H() >> 3) & 31) | ((H & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(H2 >= 10 ? "." : ".0");
        sb.append(H2);
        return new e(i, H2, sb.toString());
    }
}
