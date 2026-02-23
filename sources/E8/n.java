package E8;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import l8.x;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class n extends m {
    public static /* synthetic */ boolean A(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return y(str, str2, i, z);
    }

    public static /* synthetic */ boolean B(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return z(str, str2, z);
    }

    public static final boolean m(String str, String suffix, boolean z) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(suffix, "suffix");
        return !z ? str.endsWith(suffix) : r(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean n(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m(str, str2, z);
    }

    public static boolean o(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static Comparator p(E e) {
        kotlin.jvm.internal.l.e(e, "<this>");
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.l.d(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static final boolean q(CharSequence charSequence) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Collection K = o.K(charSequence);
            if (!(K instanceof Collection) || !K.isEmpty()) {
                Iterator it = K.iterator();
                while (it.hasNext()) {
                    if (!a.c(charSequence.charAt(((x) it).b()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean r(String str, int i, String other, int i2, int i3, boolean z) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(other, "other");
        return !z ? str.regionMatches(i, other, i2, i3) : str.regionMatches(z, i, other, i2, i3);
    }

    public static /* synthetic */ boolean s(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        return r(str, i, str2, i2, i3, (i4 & 16) != 0 ? false : z);
    }

    public static String t(CharSequence charSequence, int i) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return "";
        }
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = charAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        x it = new B8.c(1, i).iterator();
        while (it.hasNext()) {
            it.b();
            sb.append(charSequence);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.l.d(sb2, "{\n                    va…tring()\n                }");
        return sb2;
    }

    public static final String u(String str, char c, char c2, boolean z) {
        String sb;
        String str2;
        kotlin.jvm.internal.l.e(str, "<this>");
        if (z) {
            StringBuilder sb2 = new StringBuilder(str.length());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (b.d(charAt, c, z)) {
                    charAt = c2;
                }
                sb2.append(charAt);
            }
            sb = sb2.toString();
            str2 = "StringBuilder(capacity).…builderAction).toString()";
        } else {
            sb = str.replace(c, c2);
            str2 = "this as java.lang.String…replace(oldChar, newChar)";
        }
        kotlin.jvm.internal.l.d(sb, str2);
        return sb;
    }

    public static final String v(String str, String oldValue, String newValue, boolean z) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(oldValue, "oldValue");
        kotlin.jvm.internal.l.e(newValue, "newValue");
        int i = 0;
        int N = o.N(str, oldValue, 0, z);
        if (N < 0) {
            return str;
        }
        int length = oldValue.length();
        int c = B8.h.c(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append(str, i, N);
            sb.append(newValue);
            i = N + length;
            if (N >= str.length()) {
                break;
            }
            N = o.N(str, oldValue, N + c, z);
        } while (N > 0);
        sb.append(str, i, str.length());
        String sb2 = sb.toString();
        kotlin.jvm.internal.l.d(sb2, "stringBuilder.append(this, i, length).toString()");
        return sb2;
    }

    public static /* synthetic */ String w(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return u(str, c, c2, z);
    }

    public static /* synthetic */ String x(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return v(str, str2, str3, z);
    }

    public static boolean y(String str, String prefix, int i, boolean z) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        return !z ? str.startsWith(prefix, i) : r(str, i, prefix, 0, prefix.length(), z);
    }

    public static boolean z(String str, String prefix, boolean z) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        return !z ? str.startsWith(prefix) : r(str, 0, prefix, 0, prefix.length(), z);
    }
}
