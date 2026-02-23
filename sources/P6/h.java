package P6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h extends j {
    public h(D6.a aVar) {
        super(aVar);
    }

    public static void e(StringBuilder sb, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3 + i) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        sb.append(i4 != 10 ? i4 : 0);
    }

    public final void f(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        g(sb, i, length);
    }

    public final void g(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int f = b().f((i3 * 10) + i, 10);
            if (f / 100 == 0) {
                sb.append('0');
            }
            if (f / 10 == 0) {
                sb.append('0');
            }
            sb.append(f);
        }
        e(sb, i2);
    }
}
