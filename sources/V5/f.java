package v5;

import java.math.RoundingMode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f {
    public static void a(boolean z, double d, RoundingMode roundingMode) {
        if (z) {
            return;
        }
        String valueOf = String.valueOf(roundingMode);
        StringBuilder sb = new StringBuilder(valueOf.length() + 83);
        sb.append("rounded value is out of range for input ");
        sb.append(d);
        sb.append(" and rounding mode ");
        sb.append(valueOf);
        throw new ArithmeticException(sb.toString());
    }

    public static void b(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
