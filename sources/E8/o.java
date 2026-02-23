package E8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import l8.x;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class o extends n {

    public static final class a extends kotlin.jvm.internal.m implements w8.p {
        public final /* synthetic */ char[] a;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(char[] cArr, boolean z) {
            super(2);
            this.a = cArr;
            this.c = z;
        }

        public final k8.i a(CharSequence $receiver, int i) {
            kotlin.jvm.internal.l.e($receiver, "$this$$receiver");
            int S = o.S($receiver, this.a, i, this.c);
            if (S < 0) {
                return null;
            }
            return k8.m.a(Integer.valueOf(S), 1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    public static final class b extends kotlin.jvm.internal.m implements w8.p {
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, boolean z) {
            super(2);
            this.a = list;
            this.c = z;
        }

        public final k8.i a(CharSequence $receiver, int i) {
            kotlin.jvm.internal.l.e($receiver, "$this$$receiver");
            k8.i C = o.C($receiver, this.a, i, this.c, false);
            if (C != null) {
                return k8.m.a(C.c(), Integer.valueOf(((String) C.d()).length()));
            }
            return null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    public static final class c extends kotlin.jvm.internal.m implements w8.l {
        public final /* synthetic */ CharSequence a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence) {
            super(1);
            this.a = charSequence;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(B8.c it) {
            kotlin.jvm.internal.l.e(it, "it");
            return o.w0(this.a, it);
        }
    }

    public static /* synthetic */ String A0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return y0(str, str2, str3);
    }

    public static String B0(String str, char c2, String missingDelimiterValue) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(missingDelimiterValue, "missingDelimiterValue");
        int V = V(str, c2, 0, false, 6, null);
        if (V == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(V + 1, str.length());
        kotlin.jvm.internal.l.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final /* synthetic */ k8.i C(CharSequence charSequence, Collection collection, int i, boolean z, boolean z2) {
        return J(charSequence, collection, i, z, z2);
    }

    public static /* synthetic */ String C0(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return B0(str, c2, str2);
    }

    public static final boolean D(CharSequence charSequence, char c2, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        return Q(charSequence, c2, 0, z, 2, null) >= 0;
    }

    public static CharSequence D0(CharSequence charSequence) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean c2 = E8.a.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!c2) {
                    break;
                }
                length--;
            } else if (c2) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final boolean E(CharSequence charSequence, CharSequence other, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(other, "other");
        if (other instanceof String) {
            if (R(charSequence, (String) other, 0, z, 2, null) < 0) {
                return false;
            }
        } else if (P(charSequence, other, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean F(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return D(charSequence, c2, z);
    }

    public static /* synthetic */ boolean G(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return E(charSequence, charSequence2, z);
    }

    public static final boolean H(CharSequence charSequence, CharSequence suffix, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(suffix, "suffix");
        return (!z && (charSequence instanceof String) && (suffix instanceof String)) ? n.n((String) charSequence, (String) suffix, false, 2, null) : j0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static /* synthetic */ boolean I(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return H(charSequence, charSequence2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0096, code lost:
    
        return k8.m.a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final k8.i J(java.lang.CharSequence r10, java.util.Collection r11, int r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r13 != 0) goto L2f
            int r1 = r11.size()
            r2 = 1
            if (r1 != r2) goto L2f
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r11 = l8.s.F(r11)
            java.lang.String r11 = (java.lang.String) r11
            r5 = 4
            r6 = 0
            r4 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            if (r14 != 0) goto L1f
            int r10 = R(r1, r2, r3, r4, r5, r6)
            goto L23
        L1f:
            int r10 = W(r1, r2, r3, r4, r5, r6)
        L23:
            if (r10 >= 0) goto L26
            goto L2e
        L26:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            k8.i r0 = k8.m.a(r10, r11)
        L2e:
            return r0
        L2f:
            r1 = 0
            if (r14 != 0) goto L40
            B8.c r14 = new B8.c
            int r12 = B8.h.c(r12, r1)
            int r1 = r10.length()
            r14.<init>(r12, r1)
            goto L4c
        L40:
            int r14 = L(r10)
            int r12 = B8.h.e(r12, r14)
            B8.a r14 = B8.h.j(r12, r1)
        L4c:
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L9b
            int r12 = r14.d()
            int r1 = r14.f()
            int r14 = r14.g()
            if (r14 <= 0) goto L60
            if (r12 <= r1) goto L64
        L60:
            if (r14 >= 0) goto Ldc
            if (r1 > r12) goto Ldc
        L64:
            r2 = r11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
        L6b:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L89
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r2.length()
            r3 = 0
            r5 = r12
            r7 = r13
            boolean r2 = E8.n.r(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L6b
            goto L8a
        L89:
            r9 = r0
        L8a:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L97
        L8e:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            k8.i r10 = k8.m.a(r10, r9)
            return r10
        L97:
            if (r12 == r1) goto Ldc
            int r12 = r12 + r14
            goto L64
        L9b:
            int r12 = r14.d()
            int r1 = r14.f()
            int r14 = r14.g()
            if (r14 <= 0) goto Lab
            if (r12 <= r1) goto Laf
        Lab:
            if (r14 >= 0) goto Ldc
            if (r1 > r12) goto Ldc
        Laf:
            r2 = r11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
        Lb6:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Ld2
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            int r6 = r2.length()
            r4 = r10
            r5 = r12
            r7 = r13
            boolean r2 = j0(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto Lb6
            goto Ld3
        Ld2:
            r9 = r0
        Ld3:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto Ld8
            goto L8e
        Ld8:
            if (r12 == r1) goto Ldc
            int r12 = r12 + r14
            goto Laf
        Ldc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: E8.o.J(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):k8.i");
    }

    public static final B8.c K(CharSequence charSequence) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        return new B8.c(0, charSequence.length() - 1);
    }

    public static final int L(CharSequence charSequence) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int M(CharSequence charSequence, char c2, int i, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? S(charSequence, new char[]{c2}, i, z) : ((String) charSequence).indexOf(c2, i);
    }

    public static final int N(CharSequence charSequence, String string, int i, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(string, "string");
        return (z || !(charSequence instanceof String)) ? P(charSequence, string, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(string, i);
    }

    public static final int O(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        B8.a cVar = !z2 ? new B8.c(B8.h.c(i, 0), B8.h.e(i2, charSequence.length())) : B8.h.j(B8.h.e(i, L(charSequence)), B8.h.c(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int d = cVar.d();
            int f = cVar.f();
            int g = cVar.g();
            if ((g <= 0 || d > f) && (g >= 0 || f > d)) {
                return -1;
            }
            while (!n.r((String) charSequence2, 0, (String) charSequence, d, charSequence2.length(), z)) {
                if (d == f) {
                    return -1;
                }
                d += g;
            }
            return d;
        }
        int d2 = cVar.d();
        int f2 = cVar.f();
        int g2 = cVar.g();
        if ((g2 <= 0 || d2 > f2) && (g2 >= 0 || f2 > d2)) {
            return -1;
        }
        while (!j0(charSequence2, 0, charSequence, d2, charSequence2.length(), z)) {
            if (d2 == f2) {
                return -1;
            }
            d2 += g2;
        }
        return d2;
    }

    public static /* synthetic */ int P(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return O(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int Q(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return M(charSequence, c2, i, z);
    }

    public static /* synthetic */ int R(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return N(charSequence, str, i, z);
    }

    public static final int S(CharSequence charSequence, char[] chars, int i, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(l8.h.L(chars), i);
        }
        x it = new B8.c(B8.h.c(i, 0), L(charSequence)).iterator();
        while (it.hasNext()) {
            int b2 = it.b();
            char charAt = charSequence.charAt(b2);
            for (char c2 : chars) {
                if (E8.b.d(c2, charAt, z)) {
                    return b2;
                }
            }
        }
        return -1;
    }

    public static final int T(CharSequence charSequence, char c2, int i, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? X(charSequence, new char[]{c2}, i, z) : ((String) charSequence).lastIndexOf(c2, i);
    }

    public static final int U(CharSequence charSequence, String string, int i, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(string, "string");
        return (z || !(charSequence instanceof String)) ? O(charSequence, string, i, 0, z, true) : ((String) charSequence).lastIndexOf(string, i);
    }

    public static /* synthetic */ int V(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = L(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return T(charSequence, c2, i, z);
    }

    public static /* synthetic */ int W(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = L(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return U(charSequence, str, i, z);
    }

    public static final int X(CharSequence charSequence, char[] chars, int i, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(l8.h.L(chars), i);
        }
        for (int e = B8.h.e(i, L(charSequence)); -1 < e; e--) {
            char charAt = charSequence.charAt(e);
            for (char c2 : chars) {
                if (E8.b.d(c2, charAt, z)) {
                    return e;
                }
            }
        }
        return -1;
    }

    public static final D8.d Y(CharSequence charSequence) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        return t0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List Z(CharSequence charSequence) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        return D8.k.l(Y(charSequence));
    }

    public static final CharSequence a0(CharSequence charSequence, int i, char c2) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(charSequence);
        x it = new B8.c(1, i - charSequence.length()).iterator();
        while (it.hasNext()) {
            it.b();
            sb.append(c2);
        }
        return sb;
    }

    public static final String b0(String str, int i, char c2) {
        kotlin.jvm.internal.l.e(str, "<this>");
        return a0(str, i, c2).toString();
    }

    public static /* synthetic */ String c0(String str, int i, char c2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c2 = ' ';
        }
        return b0(str, i, c2);
    }

    public static final CharSequence d0(CharSequence charSequence, int i, char c2) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        x it = new B8.c(1, i - charSequence.length()).iterator();
        while (it.hasNext()) {
            it.b();
            sb.append(c2);
        }
        sb.append(charSequence);
        return sb;
    }

    public static String e0(String str, int i, char c2) {
        kotlin.jvm.internal.l.e(str, "<this>");
        return d0(str, i, c2).toString();
    }

    public static final D8.d f0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        o0(i2);
        return new d(charSequence, i, i2, new a(cArr, z));
    }

    public static final D8.d g0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        o0(i2);
        return new d(charSequence, i, i2, new b(l8.g.b(strArr), z));
    }

    public static /* synthetic */ D8.d h0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return f0(charSequence, cArr, i, z, i2);
    }

    public static /* synthetic */ D8.d i0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return g0(charSequence, strArr, i, z, i2);
    }

    public static final boolean j0(CharSequence charSequence, int i, CharSequence other, int i2, int i3, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(other, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!E8.b.d(charSequence.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String k0(String str, CharSequence prefix) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        if (!v0(str, prefix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length());
        kotlin.jvm.internal.l.d(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String l0(String str, CharSequence suffix) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(suffix, "suffix");
        if (!I(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.l.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String m0(String str, CharSequence delimiter) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(delimiter, "delimiter");
        return n0(str, delimiter, delimiter);
    }

    public static final String n0(String str, CharSequence prefix, CharSequence suffix) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        kotlin.jvm.internal.l.e(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !v0(str, prefix, false, 2, null) || !I(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length(), str.length() - suffix.length());
        kotlin.jvm.internal.l.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final void o0(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final List p0(CharSequence charSequence, char[] delimiters, boolean z, int i) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return q0(charSequence, String.valueOf(delimiters[0]), z, i);
        }
        Iterable e = D8.k.e(h0(charSequence, delimiters, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(l8.l.o(e, 10));
        Iterator it = e.iterator();
        while (it.hasNext()) {
            arrayList.add(w0(charSequence, (B8.c) it.next()));
        }
        return arrayList;
    }

    public static final List q0(CharSequence charSequence, String str, boolean z, int i) {
        o0(i);
        int i2 = 0;
        int N = N(charSequence, str, 0, z);
        if (N == -1 || i == 1) {
            return l8.j.b(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? B8.h.e(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, N).toString());
            i2 = str.length() + N;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            N = N(charSequence, str, i2, z);
        } while (N != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List r0(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return p0(charSequence, cArr, z, i);
    }

    public static final D8.d s0(CharSequence charSequence, String[] delimiters, boolean z, int i) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(delimiters, "delimiters");
        return D8.k.j(i0(charSequence, delimiters, 0, z, i, 2, null), new c(charSequence));
    }

    public static /* synthetic */ D8.d t0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return s0(charSequence, strArr, z, i);
    }

    public static final boolean u0(CharSequence charSequence, CharSequence prefix, boolean z) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        return (!z && (charSequence instanceof String) && (prefix instanceof String)) ? n.B((String) charSequence, (String) prefix, false, 2, null) : j0(charSequence, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean v0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return u0(charSequence, charSequence2, z);
    }

    public static final String w0(CharSequence charSequence, B8.c range) {
        kotlin.jvm.internal.l.e(charSequence, "<this>");
        kotlin.jvm.internal.l.e(range, "range");
        return charSequence.subSequence(range.o().intValue(), range.n().intValue() + 1).toString();
    }

    public static final String x0(String str, char c2, String missingDelimiterValue) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(missingDelimiterValue, "missingDelimiterValue");
        int Q = Q(str, c2, 0, false, 6, null);
        if (Q == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(Q + 1, str.length());
        kotlin.jvm.internal.l.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String y0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.l.e(str, "<this>");
        kotlin.jvm.internal.l.e(delimiter, "delimiter");
        kotlin.jvm.internal.l.e(missingDelimiterValue, "missingDelimiterValue");
        int R = R(str, delimiter, 0, false, 6, null);
        if (R == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(R + delimiter.length(), str.length());
        kotlin.jvm.internal.l.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String z0(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return x0(str, c2, str2);
    }
}
