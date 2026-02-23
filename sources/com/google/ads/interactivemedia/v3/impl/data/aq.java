package com.google.ads.interactivemedia.v3.impl.data;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.google.ads.interactivemedia.v3.internal.apl;
import com.google.ads.interactivemedia.v3.internal.aru;
import com.google.ads.interactivemedia.v3.internal.ato;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class aq {
    public static String a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, true != z ? 2 : 11);
    }

    public static byte[] b(String str, boolean z) throws IllegalArgumentException {
        byte[] decode = Base64.decode(str, true != z ? 2 : 11);
        if (decode.length != 0 || str.length() <= 0) {
            return decode;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }

    public static boolean c(int i) {
        int i2 = i - 1;
        int i3 = apl.a;
        if (i != 0) {
            return i2 == 2 || i2 == 4 || i2 == 5 || i2 == 6;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int d(android.content.Context r8, com.google.ads.interactivemedia.v3.internal.aru r9) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.impl.data.aq.d(android.content.Context, com.google.ads.interactivemedia.v3.internal.aru):int");
    }

    private static final String e(aru aruVar) {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String a = ato.u.a();
        if (!TextUtils.isEmpty(a) && hashSet.contains(a)) {
            return a;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            aruVar.c(2024, 0L, e);
        }
        String str = Build.CPU_ABI;
        return str != null ? str : Build.CPU_ABI2;
    }

    private static final void f(byte[] bArr, String str, aru aruVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(ato.u.a());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (NoSuchFieldException | IllegalAccessException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        aruVar.b(4007, sb.toString());
    }
}
