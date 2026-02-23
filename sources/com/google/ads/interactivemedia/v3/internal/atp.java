package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class atp {
    public static String a(String str) {
        if (atl.a(str)) {
            return null;
        }
        return str;
    }

    public static String b(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e) {
                    String str3 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), e);
                    str2 = "<" + str3 + " threw " + e.getClass().getName() + ">";
                }
            }
            objArr[i2] = str2;
            i2++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (indexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb.append(str, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append(str, i3, str.length());
        if (i < length2) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static boolean c(String str) {
        return atl.a(str);
    }

    public static atm d(atm atmVar, atm atmVar2) {
        k(atmVar);
        k(atmVar2);
        return new atn(Arrays.asList(new atm[]{atmVar, atmVar2}));
    }

    public static void e(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void f(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void g(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(b(str, obj));
        }
    }

    public static void h(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? o(i, i3, "start index") : (i2 < 0 || i2 > i3) ? o(i2, i3, "end index") : b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static void i(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    public static void j(int i, int i2) {
        String b;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                b = b("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    throw new IllegalArgumentException("negative size: " + i2);
                }
                b = b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(b);
        }
    }

    public static void k(Object obj) {
        obj.getClass();
    }

    public static void l(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException((String) obj2);
        }
    }

    public static void m(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(o(i, i2, "index"));
        }
    }

    public static atk n(Object obj) {
        return new atk(obj.getClass().getSimpleName());
    }

    private static String o(int i, int i2, String str) {
        if (i < 0) {
            return b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
