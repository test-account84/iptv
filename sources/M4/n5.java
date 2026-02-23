package M4;

import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class n5 {
    public final String a;
    public final int b;
    public Boolean c;
    public Boolean d;
    public Long e;
    public Long f;

    public n5(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static Boolean d(String str, int i, boolean z, String str2, List list, String str3, z1 z1Var) {
        boolean startsWith;
        if (i == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (z1Var != null) {
                        z1Var.w().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                startsWith = str.startsWith(str2);
                break;
            case 3:
                startsWith = str.endsWith(str2);
                break;
            case 4:
                startsWith = str.contains(str2);
                break;
            case 5:
                startsWith = str.equals(str2);
                break;
            case 6:
                if (list != null) {
                    startsWith = list.contains(str);
                    break;
                } else {
                    return null;
                }
            default:
                return null;
        }
        return Boolean.valueOf(startsWith);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Boolean e(java.math.BigDecimal r8, com.google.android.gms.internal.measurement.zzer r9, double r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.n5.e(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzer, double):java.lang.Boolean");
    }

    public static Boolean f(String str, zzey zzeyVar, z1 z1Var) {
        List list;
        com.google.android.gms.common.internal.r.m(zzeyVar);
        if (str == null || !zzeyVar.zzi() || zzeyVar.zzj() == 1) {
            return null;
        }
        if (zzeyVar.zzj() == 7) {
            if (zzeyVar.zza() == 0) {
                return null;
            }
        } else if (!zzeyVar.zzh()) {
            return null;
        }
        int zzj = zzeyVar.zzj();
        boolean zzf = zzeyVar.zzf();
        String zzd = (zzf || zzj == 2 || zzj == 7) ? zzeyVar.zzd() : zzeyVar.zzd().toUpperCase(Locale.ENGLISH);
        if (zzeyVar.zza() == 0) {
            list = null;
        } else {
            List zze = zzeyVar.zze();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zze.size());
                Iterator it = zze.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                zze = Collections.unmodifiableList(arrayList);
            }
            list = zze;
        }
        return d(str, zzj, zzf, zzd, list, zzj == 2 ? zzd : null, z1Var);
    }

    public static Boolean g(double d, zzer zzerVar) {
        try {
            return e(new BigDecimal(d), zzerVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean h(long j, zzer zzerVar) {
        try {
            return e(new BigDecimal(j), zzerVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean i(String str, zzer zzerVar) {
        if (!U4.P(str)) {
            return null;
        }
        try {
            return e(new BigDecimal(str), zzerVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean j(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    public abstract int a();

    public abstract boolean b();

    public abstract boolean c();
}
