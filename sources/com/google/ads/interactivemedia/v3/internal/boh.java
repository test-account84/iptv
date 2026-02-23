package com.google.ads.interactivemedia.v3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class boh implements Closeable {
    private final Reader b;
    private long i;
    private int j;
    private String k;
    private int[] l;
    private String[] n;
    private int[] o;
    private boolean c = false;
    private final char[] d = new char[1024];
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    int a = 0;
    private int m = 1;

    static {
        bla.a = new bog();
    }

    public boh(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.b = reader;
    }

    private final void A() throws IOException {
        if (!this.c) {
            throw w("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private final void B(int i) {
        int i2 = this.m;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            int i3 = i2 + i2;
            this.l = Arrays.copyOf(iArr, i3);
            this.o = Arrays.copyOf(this.o, i3);
            this.n = (String[]) Arrays.copyOf(this.n, i3);
        }
        int[] iArr2 = this.l;
        int i4 = this.m;
        this.m = i4 + 1;
        iArr2[i4] = i;
    }

    private final void C(char c) throws IOException {
        char[] cArr = this.d;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.e = i3;
                        return;
                    }
                    if (c2 == '\\') {
                        this.e = i3;
                        d();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.g++;
                            this.h = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.e = i;
                    if (!E(1)) {
                        throw w("Unterminated string");
                    }
                }
            }
        }
    }

    private final void D() throws IOException {
        char c;
        do {
            if (this.e >= this.f && !E(1)) {
                return;
            }
            char[] cArr = this.d;
            int i = this.e;
            int i2 = i + 1;
            this.e = i2;
            c = cArr[i];
            if (c == '\n') {
                this.g++;
                this.h = i2;
                return;
            }
        } while (c != '\r');
    }

    private final boolean E(int i) throws IOException {
        int i2;
        char[] cArr = this.d;
        int i3 = this.h;
        int i4 = this.e;
        this.h = i3 - i4;
        int i5 = this.f;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.f = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            Reader reader = this.b;
            int i7 = this.f;
            int read = reader.read(cArr, i7, 1024 - i7);
            if (read == -1) {
                return false;
            }
            i2 = this.f + read;
            this.f = i2;
            if (this.g == 0 && this.h == 0 && i2 > 0 && cArr[0] == 65279) {
                this.e++;
                this.h = 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private final boolean F(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        A();
        return false;
    }

    private final char d() throws IOException {
        int i;
        if (this.e == this.f && !E(1)) {
            throw w("Unterminated escape sequence");
        }
        char[] cArr = this.d;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        char c = cArr[i2];
        if (c == '\n') {
            this.g++;
            this.h = i3;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c == 'b') {
                return '\b';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return '\r';
            }
            if (c == 't') {
                return '\t';
            }
            if (c != 'u') {
                throw w("Invalid escape sequence");
            }
            if (i2 + 5 > this.f && !E(4)) {
                throw w("Unterminated escape sequence");
            }
            int i4 = this.e;
            int i5 = i4 + 4;
            char c2 = 0;
            while (i4 < i5) {
                char[] cArr2 = this.d;
                char c3 = cArr2[i4];
                char c4 = (char) (c2 << 4);
                if (c3 >= '0' && c3 <= '9') {
                    i = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i = c3 - 'W';
                } else {
                    if (c3 < 'A' || c3 > 'F') {
                        throw new NumberFormatException("\\u".concat(new String(cArr2, this.e, 4)));
                    }
                    i = c3 - '7';
                }
                c2 = (char) (c4 + i);
                i4++;
            }
            this.e += 4;
            return c2;
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        if (r5 != '/') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        r8.e = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
    
        if (r4 != r2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        r8.e = r1;
        r1 = E(2);
        r8.e++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        if (r1 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        return 47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
    
        A();
        r1 = r8.e;
        r2 = r0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        if (r2 == '*') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007c, code lost:
    
        r8.e = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
    
        if ((r8.e + 2) <= r8.f) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
    
        if (E(2) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0092, code lost:
    
        throw w("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
    
        r1 = r8.d;
        r2 = r8.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r1[r2] != '\n') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r8.g++;
        r8.h = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ba, code lost:
    
        r1 = r8.e + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a5, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a6, code lost:
    
        if (r1 >= 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b5, code lost:
    
        if (r8.d[r8.e + r1] != "*\/".charAt(r1)) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b7, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x006f, code lost:
    
        if (r2 == '/') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0072, code lost:
    
        r8.e = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0071, code lost:
    
        return 47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c3, code lost:
    
        r8.e = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c7, code lost:
    
        if (r5 != '#') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c9, code lost:
    
        A();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00cd, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int n(boolean r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.boh.n(boolean):int");
    }

    private final IOException w(String str) throws IOException {
        throw new bok(str.concat(String.valueOf(t())));
    }

    private String x(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (true) {
            int i2 = this.m;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.l[i];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.o[i];
                if (z && i4 > 0 && i == i2 - 1) {
                    i4--;
                }
                sb.append('[');
                sb.append(i4);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.n[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private final String y(char c) throws IOException {
        char[] cArr = this.d;
        StringBuilder sb = null;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.e = i3;
                        int i4 = (i3 - i) - 1;
                        if (sb == null) {
                            return new String(cArr, i, i4);
                        }
                        sb.append(cArr, i, i4);
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        this.e = i3;
                        int i5 = i3 - i;
                        int i6 = i5 - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max(i5 + i5, 16));
                        }
                        sb.append(cArr, i, i6);
                        sb.append(d());
                    } else {
                        if (c2 == '\n') {
                            this.g++;
                            this.h = i3;
                        }
                        i = i3;
                    }
                } else {
                    if (sb == null) {
                        int i7 = i - i;
                        sb = new StringBuilder(Math.max(i7 + i7, 16));
                    }
                    sb.append(cArr, i, i - i);
                    this.e = i;
                    if (!E(1)) {
                        throw w("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0048, code lost:
    
        A();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String z() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r5.e
            int r3 = r3 + r2
            int r4 = r5.f
            if (r3 >= r4) goto L4c
            char[] r4 = r5.d
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.A()
            goto L58
        L4c:
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r5.E(r3)
            if (r3 != 0) goto L3
        L58:
            r1 = r2
            goto L7a
        L5a:
            if (r0 != 0) goto L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L67:
            char[] r3 = r5.d
            int r4 = r5.e
            r0.append(r3, r4, r2)
            int r3 = r5.e
            int r3 = r3 + r2
            r5.e = r3
            r2 = 1
            boolean r2 = r5.E(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L86
            java.lang.String r0 = new java.lang.String
            char[] r2 = r5.d
            int r3 = r5.e
            r0.<init>(r2, r3, r1)
            goto L91
        L86:
            char[] r2 = r5.d
            int r3 = r5.e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L91:
            int r2 = r5.e
            int r2 = r2 + r1
            r5.e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.boh.z():java.lang.String");
    }

    public double a() throws IOException {
        String y;
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            this.a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            char[] cArr = this.d;
            int i3 = this.e;
            int i4 = this.j;
            this.k = new String(cArr, i3, i4);
            this.e = i3 + i4;
        } else {
            if (i == 8 || i == 9) {
                y = y(i == 8 ? '\'' : '\"');
            } else if (i == 10) {
                y = z();
            } else if (i != 11) {
                int r = r();
                throw new IllegalStateException("Expected a double but was " + boi.a(r) + t());
            }
            this.k = y;
        }
        this.a = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (this.c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.k = null;
            this.a = 0;
            int[] iArr2 = this.o;
            int i5 = this.m - 1;
            iArr2[i5] = iArr2[i5] + 1;
            return parseDouble;
        }
        throw new bok("JSON forbids NaN and infinities: " + parseDouble + t());
    }

    public int b() throws IOException {
        String y;
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            long j = this.i;
            int i2 = (int) j;
            if (j == i2) {
                this.a = 0;
                int[] iArr = this.o;
                int i3 = this.m - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + j + t());
        }
        if (i == 16) {
            char[] cArr = this.d;
            int i4 = this.e;
            int i5 = this.j;
            this.k = new String(cArr, i4, i5);
            this.e = i4 + i5;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                int r = r();
                throw new IllegalStateException("Expected an int but was " + boi.a(r) + t());
            }
            if (i == 10) {
                y = z();
            } else {
                y = y(i == 8 ? '\'' : '\"');
            }
            this.k = y;
            try {
                int parseInt = Integer.parseInt(this.k);
                this.a = 0;
                int[] iArr2 = this.o;
                int i6 = this.m - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.a = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i7 = (int) parseDouble;
        if (i7 == parseDouble) {
            this.k = null;
            this.a = 0;
            int[] iArr3 = this.o;
            int i8 = this.m - 1;
            iArr3[i8] = iArr3[i8] + 1;
            return i7;
        }
        throw new NumberFormatException("Expected an int but was " + this.k + t());
    }

    public long c() throws IOException {
        String y;
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            this.a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            char[] cArr = this.d;
            int i3 = this.e;
            int i4 = this.j;
            this.k = new String(cArr, i3, i4);
            this.e = i3 + i4;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                int r = r();
                throw new IllegalStateException("Expected a long but was " + boi.a(r) + t());
            }
            if (i == 10) {
                y = z();
            } else {
                y = y(i == 8 ? '\'' : '\"');
            }
            this.k = y;
            try {
                long parseLong = Long.parseLong(this.k);
                this.a = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.a = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.k = null;
            this.a = 0;
            int[] iArr3 = this.o;
            int i6 = this.m - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.k + t());
    }

    public void close() throws IOException {
        this.a = 0;
        this.l[0] = 8;
        this.m = 1;
        this.b.close();
    }

    public String e() {
        return x(false);
    }

    public String f() {
        return x(true);
    }

    public String g() throws IOException {
        char c;
        String y;
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 14) {
            y = z();
        } else {
            if (i == 12) {
                c = '\'';
            } else {
                if (i != 13) {
                    int r = r();
                    throw new IllegalStateException("Expected a name but was " + boi.a(r) + t());
                }
                c = '\"';
            }
            y = y(c);
        }
        this.a = 0;
        this.n[this.m - 1] = y;
        return y;
    }

    public String h() throws IOException {
        String str;
        char c;
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 10) {
            str = z();
        } else {
            if (i == 8) {
                c = '\'';
            } else if (i == 9) {
                c = '\"';
            } else if (i == 11) {
                str = this.k;
                this.k = null;
            } else if (i == 15) {
                str = Long.toString(this.i);
            } else {
                if (i != 16) {
                    int r = r();
                    throw new IllegalStateException("Expected a string but was " + boi.a(r) + t());
                }
                str = new String(this.d, this.e, this.j);
                this.e += this.j;
            }
            str = y(c);
        }
        this.a = 0;
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public void i() throws IOException {
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 3) {
            B(1);
            this.o[this.m - 1] = 0;
            this.a = 0;
        } else {
            int r = r();
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + boi.a(r) + t());
        }
    }

    public void j() throws IOException {
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 1) {
            B(3);
            this.a = 0;
            return;
        }
        int r = r();
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + boi.a(r) + t());
    }

    public void k() throws IOException {
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 4) {
            int i2 = this.m;
            this.m = i2 - 1;
            int[] iArr = this.o;
            int i3 = i2 - 2;
            iArr[i3] = iArr[i3] + 1;
            this.a = 0;
            return;
        }
        int r = r();
        throw new IllegalStateException("Expected END_ARRAY but was " + boi.a(r) + t());
    }

    public void l() throws IOException {
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i != 2) {
            int r = r();
            throw new IllegalStateException("Expected END_OBJECT but was " + boi.a(r) + t());
        }
        int i2 = this.m;
        int i3 = i2 - 1;
        this.m = i3;
        this.n[i3] = null;
        int[] iArr = this.o;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.a = 0;
    }

    public void m() throws IOException {
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 7) {
            this.a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        int r = r();
        throw new IllegalStateException("Expected null but was " + boi.a(r) + t());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:64:0x0094. Please report as an issue. */
    public void o() throws IOException {
        char c;
        int i = 0;
        do {
            int i2 = this.a;
            if (i2 == 0) {
                i2 = s();
            }
            if (i2 == 3) {
                B(1);
            } else if (i2 == 1) {
                B(3);
            } else {
                if (i2 == 4 || i2 == 2) {
                    this.m--;
                    i--;
                } else if (i2 == 14 || i2 == 10) {
                    do {
                        int i3 = 0;
                        while (true) {
                            int i4 = this.e + i3;
                            if (i4 < this.f) {
                                char c2 = this.d[i4];
                                if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                                    if (c2 != '#') {
                                        if (c2 != ',') {
                                            if (c2 != '/' && c2 != '=') {
                                                if (c2 != '{' && c2 != '}' && c2 != ':') {
                                                    if (c2 != ';') {
                                                        switch (c2) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i3++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.e = i4;
                            }
                        }
                        A();
                        this.e += i3;
                    } while (E(1));
                } else {
                    if (i2 == 8 || i2 == 12) {
                        c = '\'';
                    } else if (i2 == 9 || i2 == 13) {
                        c = '\"';
                    } else if (i2 == 16) {
                        this.e += this.j;
                    }
                    C(c);
                }
                this.a = 0;
            }
            i++;
            this.a = 0;
        } while (i != 0);
        int[] iArr = this.o;
        int i5 = this.m - 1;
        iArr[i5] = iArr[i5] + 1;
        this.n[i5] = "null";
    }

    public boolean p() throws IOException {
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        return (i == 2 || i == 4 || i == 17) ? false : true;
    }

    public boolean q() throws IOException {
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        if (i == 5) {
            this.a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i == 6) {
            this.a = 0;
            int[] iArr2 = this.o;
            int i3 = this.m - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        int r = r();
        throw new IllegalStateException("Expected a boolean but was " + boi.a(r) + t());
    }

    public int r() throws IOException {
        int i = this.a;
        if (i == 0) {
            i = s();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0212, code lost:
    
        if (F(r1) == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01a2, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0215, code lost:
    
        if (r6 != 2) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0217, code lost:
    
        if (r15 == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x021d, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x021f, code lost:
    
        if (r16 == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x022c, code lost:
    
        if (r11 != 0) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x022e, code lost:
    
        if (r14 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0230, code lost:
    
        if (r14 == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0233, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0234, code lost:
    
        r19.i = r11;
        r19.e += r10;
        r14 = 15;
        r19.a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0227, code lost:
    
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0224, code lost:
    
        r1 = 2;
        r6 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0240, code lost:
    
        if (r6 == r1) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0243, code lost:
    
        if (r6 == 4) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0246, code lost:
    
        if (r6 != 7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0248, code lost:
    
        r19.j = r10;
        r19.a = 16;
        r14 = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0293 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0278 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int s() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 801
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.boh.s():int");
    }

    public String t() {
        int i = this.g;
        int i2 = this.e;
        int i3 = this.h;
        return " at line " + (i + 1) + " column " + ((i2 - i3) + 1) + " path " + e();
    }

    public String toString() {
        return getClass().getSimpleName().concat(String.valueOf(t()));
    }

    public final void u(boolean z) {
        this.c = z;
    }

    public final boolean v() {
        return this.c;
    }
}
