package com.google.ads.interactivemedia.v3.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class boj implements Closeable, Flushable {
    private static final Pattern a = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] b = new String[128];
    private static final String[] c;
    private final Writer d;
    private int[] e = new int[32];
    private int f = 0;
    private final String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            b[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = b;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        c = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public boj(Writer writer) {
        u(6);
        this.g = ":";
        this.k = true;
        bpd.v(writer, "out == null");
        this.d = writer;
    }

    private final int a() {
        int i = this.f;
        if (i != 0) {
            return this.e[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private final void t() throws IOException {
        int a2 = a();
        if (a2 == 1) {
            v(2);
            return;
        }
        if (a2 == 2) {
            this.d.append(',');
            return;
        }
        if (a2 == 4) {
            this.d.append(this.g);
            v(5);
            return;
        }
        if (a2 != 6) {
            if (a2 != 7) {
                throw new IllegalStateException("Nesting problem.");
            }
            if (!this.h) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        }
        v(7);
    }

    private final void u(int i) {
        int i2 = this.f;
        int[] iArr = this.e;
        if (i2 == iArr.length) {
            this.e = Arrays.copyOf(iArr, i2 + i2);
        }
        int[] iArr2 = this.e;
        int i3 = this.f;
        this.f = i3 + 1;
        iArr2[i3] = i;
    }

    private final void v(int i) {
        this.e[this.f - 1] = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void w(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.ads.interactivemedia.v3.internal.boj.c
            goto L9
        L7:
            java.lang.String[] r0 = com.google.ads.interactivemedia.v3.internal.boj.b
        L9:
            java.io.Writer r1 = r8.d
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.d
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.d
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.d
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.d
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.boj.w(java.lang.String):void");
    }

    private final void x() throws IOException {
        if (this.j != null) {
            int a2 = a();
            if (a2 == 5) {
                this.d.write(44);
            } else if (a2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            v(4);
            w(this.j);
            this.j = null;
        }
    }

    private final void y(int i, int i2, char c2) throws IOException {
        int a2 = a();
        if (a2 != i2 && a2 != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        String str = this.j;
        if (str != null) {
            throw new IllegalStateException("Dangling name: ".concat(str));
        }
        this.f--;
        this.d.write(c2);
    }

    private final void z(int i, char c2) throws IOException {
        t();
        u(i);
        this.d.write(c2);
    }

    public void b() throws IOException {
        x();
        z(1, '[');
    }

    public void c() throws IOException {
        x();
        z(3, '{');
    }

    public void close() throws IOException {
        this.d.close();
        int i = this.f;
        if (i > 1 || (i == 1 && this.e[0] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f = 0;
    }

    public void d() throws IOException {
        y(1, 2, ']');
    }

    public void e() throws IOException {
        y(3, 5, '}');
    }

    public void f(String str) throws IOException {
        bpd.v(str, "name == null");
        if (this.j != null) {
            throw new IllegalStateException();
        }
        if (this.f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j = str;
    }

    public void flush() throws IOException {
        if (this.f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.d.flush();
    }

    public void g() throws IOException {
        if (this.j != null) {
            if (!this.k) {
                this.j = null;
                return;
            }
            x();
        }
        t();
        this.d.write("null");
    }

    public void h(double d) throws IOException {
        x();
        if (this.h || !(Double.isNaN(d) || Double.isInfinite(d))) {
            t();
            this.d.append(Double.toString(d));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
    }

    public void i(long j) throws IOException {
        x();
        t();
        this.d.write(Long.toString(j));
    }

    public void j(Boolean bool) throws IOException {
        if (bool == null) {
            g();
            return;
        }
        x();
        t();
        this.d.write(true != bool.booleanValue() ? "false" : "true");
    }

    public void k(Number number) throws IOException {
        if (number == null) {
            g();
            return;
        }
        x();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class cls = number.getClass();
            if (cls != Integer.class && cls != Long.class && cls != Double.class && cls != Float.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class && !a.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + String.valueOf(cls) + " is not a valid JSON number: " + obj);
            }
        } else if (!this.h) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(obj));
        }
        t();
        this.d.append(obj);
    }

    public void l(String str) throws IOException {
        if (str == null) {
            g();
            return;
        }
        x();
        t();
        w(str);
    }

    public void m(boolean z) throws IOException {
        x();
        t();
        this.d.write(true != z ? "false" : "true");
    }

    public final void n(boolean z) {
        this.i = z;
    }

    public final void o(boolean z) {
        this.h = z;
    }

    public final void p(boolean z) {
        this.k = z;
    }

    public final boolean q() {
        return this.k;
    }

    public final boolean r() {
        return this.i;
    }

    public final boolean s() {
        return this.h;
    }
}
