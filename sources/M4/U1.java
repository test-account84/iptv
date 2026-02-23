package M4;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u1 {
    public static final AtomicReference b = new AtomicReference();
    public static final AtomicReference c = new AtomicReference();
    public static final AtomicReference d = new AtomicReference();
    public final t1 a;

    public u1(t1 t1Var) {
        this.a = t1Var;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        com.google.android.gms.common.internal.r.m(strArr);
        com.google.android.gms.common.internal.r.m(strArr2);
        com.google.android.gms.common.internal.r.m(atomicReference);
        com.google.android.gms.common.internal.r.a(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            String str3 = strArr[i];
            if (str == str3 || str.equals(str3)) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i];
                        if (str2 == null) {
                            str2 = strArr2[i] + "(" + strArr[i] + ")";
                            strArr3[i] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            String b2 = obj instanceof Bundle ? b((Bundle) obj) : String.valueOf(obj);
            if (b2 != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(b2);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final String b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(e(str));
            sb.append("=");
            Object obj = bundle.get(str);
            sb.append(obj instanceof Bundle ? a(new Object[]{obj}) : obj instanceof Object[] ? a((Object[]) obj) : obj instanceof ArrayList ? a(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb.append("}]");
        return sb.toString();
    }

    public final String c(v vVar) {
        if (!this.a.zza()) {
            return vVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(vVar.h);
        sb.append(",name=");
        sb.append(d(vVar.f));
        sb.append(",params=");
        t tVar = vVar.g;
        sb.append(tVar == null ? null : !this.a.zza() ? tVar.toString() : b(tVar.J()));
        return sb.toString();
    }

    public final String d(String str) {
        if (str == null) {
            return null;
        }
        return !this.a.zza() ? str : g(str, L2.c, L2.a, b);
    }

    public final String e(String str) {
        if (str == null) {
            return null;
        }
        return !this.a.zza() ? str : g(str, M2.b, M2.a, c);
    }

    public final String f(String str) {
        if (str == null) {
            return null;
        }
        if (!this.a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, N2.b, N2.a, d);
        }
        return "experiment_id(" + str + ")";
    }
}
