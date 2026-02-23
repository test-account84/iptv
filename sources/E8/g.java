package E8;

import java.util.ArrayList;
import java.util.Iterator;
import l8.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class g extends f {

    public static final class a extends kotlin.jvm.internal.m implements w8.l {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String line) {
            kotlin.jvm.internal.l.e(line, "line");
            return line;
        }
    }

    public static final class b extends kotlin.jvm.internal.m implements w8.l {
        public final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.a = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String line) {
            kotlin.jvm.internal.l.e(line, "line");
            return this.a + line;
        }
    }

    public static final w8.l b(String str) {
        return str.length() == 0 ? a.a : new b(str);
    }

    public static final int c(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!E8.a.c(str.charAt(i))) {
                break;
            }
            i++;
        }
        return i == -1 ? str.length() : i;
    }

    public static final String d(String str, String newIndent) {
        String str2;
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(newIndent, "newIndent");
        Iterable Z = o.Z(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : Z) {
            if (!n.q((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(l8.l.o(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer C = s.C(arrayList2);
        int i = 0;
        int intValue = C != null ? C.intValue() : 0;
        int length = str.length() + (newIndent.length() * Z.size());
        w8.l b2 = b(newIndent);
        int g = l8.k.g(Z);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : Z) {
            int i2 = i + 1;
            if (i < 0) {
                l8.k.n();
            }
            String str3 = (String) obj2;
            if ((i == 0 || i == g) && n.q(str3)) {
                str3 = null;
            } else {
                String E0 = q.E0(str3, intValue);
                if (E0 != null && (str2 = (String) b2.invoke(E0)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i = i2;
        }
        String sb = s.y(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null).toString();
        kotlin.jvm.internal.l.d(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static final String e(String str, String newIndent, String marginPrefix) {
        int i;
        String str2;
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(newIndent, "newIndent");
        kotlin.jvm.internal.l.e(marginPrefix, "marginPrefix");
        if (!(!n.q(marginPrefix))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        Iterable Z = o.Z(str);
        int length = str.length() + (newIndent.length() * Z.size());
        w8.l b2 = b(newIndent);
        int g = l8.k.g(Z);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : Z) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                l8.k.n();
            }
            String str3 = (String) obj;
            String str4 = null;
            if ((i2 == 0 || i2 == g) && n.q(str3)) {
                str3 = null;
            } else {
                int length2 = str3.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!E8.a.c(str3.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (n.A(str3, marginPrefix, i, false, 4, null)) {
                        int length3 = i5 + marginPrefix.length();
                        kotlin.jvm.internal.l.c(str3, "null cannot be cast to non-null type java.lang.String");
                        str4 = str3.substring(length3);
                        kotlin.jvm.internal.l.d(str4, "this as java.lang.String).substring(startIndex)");
                    }
                }
                if (str4 != null && (str2 = (String) b2.invoke(str4)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            i2 = i3;
        }
        String sb = s.y(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null).toString();
        kotlin.jvm.internal.l.d(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static String f(String str) {
        kotlin.jvm.internal.l.e(str, "<this>");
        return d(str, "");
    }

    public static final String g(String str, String marginPrefix) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(marginPrefix, "marginPrefix");
        return e(str, "", marginPrefix);
    }

    public static /* synthetic */ String h(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
