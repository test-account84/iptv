package P6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e extends i {
    public final String c;
    public final String d;

    public e(D6.a aVar, String str, String str2) {
        super(aVar);
        this.c = str2;
        this.d = str;
    }

    public String d() {
        if (c().l() != 84) {
            throw x6.k.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        j(sb, 48, 20);
        k(sb, 68);
        return sb.toString();
    }

    public void h(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.d);
        sb.append(i / 100000);
        sb.append(')');
    }

    public int i(int i) {
        return i % 100000;
    }

    public final void k(StringBuilder sb, int i) {
        int f = b().f(i, 16);
        if (f == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.c);
        sb.append(')');
        int i2 = f % 32;
        int i3 = f / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }
}
