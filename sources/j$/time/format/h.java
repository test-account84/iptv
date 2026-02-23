package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class h implements f {
    public final boolean i(p pVar, StringBuilder sb) {
        Long e = pVar.e(j$.time.temporal.a.INSTANT_SECONDS);
        j$.time.temporal.o d = pVar.d();
        j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
        Long valueOf = d.f(aVar) ? Long.valueOf(pVar.d().q(aVar)) : null;
        int i = 0;
        if (e == null) {
            return false;
        }
        long longValue = e.longValue();
        int y = aVar.y(valueOf != null ? valueOf.longValue() : 0L);
        if (longValue >= -62167219200L) {
            long j = longValue - 253402300800L;
            long n = j$.com.android.tools.r8.a.n(j, 315569520000L) + 1;
            LocalDateTime L = LocalDateTime.L(j$.com.android.tools.r8.a.m(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (n > 0) {
                sb.append('+');
                sb.append(n);
            }
            sb.append(L);
            if (L.F() == 0) {
                sb.append(":00");
            }
        } else {
            long j2 = longValue + 62167219200L;
            long j3 = j2 / 315569520000L;
            long j4 = j2 % 315569520000L;
            LocalDateTime L2 = LocalDateTime.L(j4 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb.length();
            sb.append(L2);
            if (L2.F() == 0) {
                sb.append(":00");
            }
            if (j3 < 0) {
                if (L2.G() == -10000) {
                    sb.replace(length, length + 2, Long.toString(j3 - 1));
                } else if (j4 == 0) {
                    sb.insert(length, j3);
                } else {
                    sb.insert(length + 1, Math.abs(j3));
                }
            }
        }
        if (y > 0) {
            sb.append('.');
            int i2 = 100000000;
            while (true) {
                if (y <= 0 && i % 3 == 0 && i >= -2) {
                    break;
                }
                int i3 = y / i2;
                sb.append((char) (i3 + 48));
                y -= i3 * i2;
                i2 /= 10;
                i++;
            }
        }
        sb.append('Z');
        return true;
    }

    public final String toString() {
        return "Instant()";
    }
}
