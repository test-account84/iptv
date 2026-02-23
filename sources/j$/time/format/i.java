package j$.time.format;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
class i implements f {
    static final long[] f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};
    final j$.time.temporal.r a;
    final int b;
    final int c;
    private final u d;
    final int e;

    i(j$.time.temporal.r rVar, int i, int i2, u uVar) {
        this.a = rVar;
        this.b = i;
        this.c = i2;
        this.d = uVar;
        this.e = 0;
    }

    protected i(j$.time.temporal.r rVar, int i, int i2, u uVar, int i3) {
        this.a = rVar;
        this.b = i;
        this.c = i2;
        this.d = uVar;
        this.e = i3;
    }

    static /* bridge */ /* synthetic */ u a(i iVar) {
        return iVar.d;
    }

    i b() {
        if (this.e == -1) {
            return this;
        }
        return new i(this.a, this.b, this.c, this.d, -1);
    }

    i c(int i) {
        int i2 = this.e + i;
        return new i(this.a, this.b, this.c, this.d, i2);
    }

    public boolean i(p pVar, StringBuilder sb) {
        j$.time.temporal.r rVar = this.a;
        Long e = pVar.e(rVar);
        if (e == null) {
            return false;
        }
        long longValue = e.longValue();
        s b = pVar.b();
        String l = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        int length = l.length();
        int i = this.c;
        if (length > i) {
            throw new j$.time.c("Field " + rVar + " cannot be printed as the value " + longValue + " exceeds the maximum print width of " + i);
        }
        b.getClass();
        int i2 = this.b;
        u uVar = this.d;
        if (longValue >= 0) {
            int i3 = c.a[uVar.ordinal()];
            if (i3 == 1 ? !(i2 >= 19 || longValue < f[i2]) : i3 == 2) {
                sb.append('+');
            }
        } else {
            int i4 = c.a[uVar.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                sb.append('-');
            } else if (i4 == 4) {
                throw new j$.time.c("Field " + rVar + " cannot be printed as the value " + longValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i5 = 0; i5 < i2 - l.length(); i5++) {
            sb.append('0');
        }
        sb.append(l);
        return true;
    }

    public String toString() {
        int i = this.c;
        j$.time.temporal.r rVar = this.a;
        u uVar = this.d;
        int i2 = this.b;
        if (i2 == 1 && i == 19 && uVar == u.NORMAL) {
            return "Value(" + rVar + ")";
        }
        if (i2 == i && uVar == u.NOT_NEGATIVE) {
            return "Value(" + rVar + "," + i2 + ")";
        }
        return "Value(" + rVar + "," + i2 + "," + i + "," + uVar + ")";
    }
}
