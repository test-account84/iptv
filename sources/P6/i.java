package P6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class i extends h {
    public i(D6.a aVar) {
        super(aVar);
    }

    public abstract void h(StringBuilder sb, int i);

    public abstract int i(int i);

    public final void j(StringBuilder sb, int i, int i2) {
        int f = b().f(i, i2);
        h(sb, f);
        int i3 = i(f);
        int i4 = 100000;
        for (int i5 = 0; i5 < 5; i5++) {
            if (i3 / i4 == 0) {
                sb.append('0');
            }
            i4 /= 10;
        }
        sb.append(i3);
    }
}
