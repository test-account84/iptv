package B6;

import android.content.Intent;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {
    public static final Pattern a = Pattern.compile(",");
    public static final Set b;
    public static final Set c;
    public static final Set d;
    public static final Set e;
    public static final Set f;
    public static final Set g;
    public static final Set h;
    public static final Map i;

    static {
        EnumSet of = EnumSet.of(x6.a.QR_CODE);
        e = of;
        EnumSet of2 = EnumSet.of(x6.a.DATA_MATRIX);
        f = of2;
        EnumSet of3 = EnumSet.of(x6.a.AZTEC);
        g = of3;
        EnumSet of4 = EnumSet.of(x6.a.PDF_417);
        h = of4;
        EnumSet of5 = EnumSet.of(x6.a.UPC_A, new x6.a[]{x6.a.UPC_E, x6.a.EAN_13, x6.a.EAN_8, x6.a.RSS_14, x6.a.RSS_EXPANDED});
        b = of5;
        EnumSet of6 = EnumSet.of(x6.a.CODE_39, x6.a.CODE_93, x6.a.CODE_128, x6.a.ITF, x6.a.CODABAR);
        c = of6;
        EnumSet copyOf = EnumSet.copyOf(of5);
        d = copyOf;
        copyOf.addAll(of6);
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("PRODUCT_MODE", of5);
        hashMap.put("QR_CODE_MODE", of);
        hashMap.put("DATA_MATRIX_MODE", of2);
        hashMap.put("AZTEC_MODE", of3);
        hashMap.put("PDF417_MODE", of4);
    }

    public static Set a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return b(stringExtra != null ? Arrays.asList(a.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    public static Set b(Iterable iterable, String str) {
        if (iterable != null) {
            EnumSet noneOf = EnumSet.noneOf(x6.a.class);
            try {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    noneOf.add(x6.a.valueOf((String) it.next()));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return (Set) i.get(str);
        }
        return null;
    }
}
