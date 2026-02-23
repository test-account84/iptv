package j$.time.format;

import j$.time.temporal.w;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class g extends i {
    private final boolean g;

    g(j$.time.temporal.r rVar, int i, int i2, boolean z, int i3) {
        super(rVar, i, i2, u.NOT_NEGATIVE, i3);
        this.g = z;
    }

    final i b() {
        if (this.e == -1) {
            return this;
        }
        return new g(this.a, this.b, this.c, this.g, -1);
    }

    final i c(int i) {
        return new g(this.a, this.b, this.c, this.g, this.e + i);
    }

    public final boolean i(p pVar, StringBuilder sb) {
        j$.time.temporal.r rVar = this.a;
        Long e = pVar.e(rVar);
        if (e == null) {
            return false;
        }
        s b = pVar.b();
        long longValue = e.longValue();
        w i = rVar.i();
        i.b(longValue, rVar);
        BigDecimal valueOf = BigDecimal.valueOf(i.e());
        BigDecimal add = BigDecimal.valueOf(i.d()).subtract(valueOf).add(BigDecimal.ONE);
        BigDecimal subtract = BigDecimal.valueOf(longValue).subtract(valueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal divide = subtract.divide(add, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (divide.compareTo(bigDecimal) != 0) {
            bigDecimal = divide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : divide.stripTrailingZeros();
        }
        int scale = bigDecimal.scale();
        boolean z = this.g;
        int i2 = this.b;
        if (scale != 0) {
            String substring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i2), this.c), roundingMode).toPlainString().substring(2);
            b.getClass();
            if (z) {
                sb.append('.');
            }
            sb.append(substring);
            return true;
        }
        if (i2 <= 0) {
            return true;
        }
        if (z) {
            b.getClass();
            sb.append('.');
        }
        for (int i3 = 0; i3 < i2; i3++) {
            b.getClass();
            sb.append('0');
        }
        return true;
    }

    public final String toString() {
        return "Fraction(" + this.a + "," + this.b + "," + this.c + (this.g ? ",DecimalPoint" : "") + ")";
    }
}
