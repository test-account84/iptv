package J1;

import java.io.IOException;
import okio.BufferedSink;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class g extends h {
    public static final String[] m = new String[128];
    public final BufferedSink j;
    public String k = ":";
    public String l;

    static {
        for (int i = 0; i <= 31; i++) {
            m[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public g(BufferedSink bufferedSink) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        }
        this.j = bufferedSink;
        k(6);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void T(okio.BufferedSink r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = J1.g.m
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.g.T(okio.BufferedSink, java.lang.String):void");
    }

    public final void V() {
        if (this.l != null) {
            r();
            T(this.j, this.l);
            this.l = null;
        }
    }

    public h a() {
        V();
        return w(1, "[");
    }

    public h c() {
        V();
        return w(3, "{");
    }

    public void close() {
        this.j.close();
        int i = this.a;
        if (i > 1 || (i == 1 && this.c[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.a = 0;
    }

    public h d() {
        return t(1, 2, "]");
    }

    public h e() {
        this.i = false;
        return t(3, 5, "}");
    }

    public void flush() {
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j.flush();
    }

    public h g(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        int i = this.a;
        if (i == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        if (this.l != null) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.l = str;
        this.d[i - 1] = str;
        this.i = false;
        return this;
    }

    public h h() {
        if (this.l != null) {
            if (!this.h) {
                this.l = null;
                return this;
            }
            V();
        }
        s();
        this.j.writeUtf8("null");
        int[] iArr = this.e;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public h n(Boolean bool) {
        return bool == null ? h() : q(bool.booleanValue());
    }

    public h o(Number number) {
        if (number == null) {
            return h();
        }
        String obj = number.toString();
        if (!this.g && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        if (this.i) {
            return g(obj);
        }
        V();
        s();
        this.j.writeUtf8(obj);
        int[] iArr = this.e;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public h p(String str) {
        if (str == null) {
            return h();
        }
        if (this.i) {
            return g(str);
        }
        V();
        s();
        T(this.j, str);
        int[] iArr = this.e;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public h q(boolean z) {
        V();
        s();
        this.j.writeUtf8(z ? "true" : "false");
        int[] iArr = this.e;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public final void r() {
        int j = j();
        if (j == 5) {
            this.j.writeByte(44);
        } else if (j != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        v();
        l(4);
    }

    public final void s() {
        int j = j();
        if (j == 1) {
            l(2);
        } else {
            if (j != 2) {
                if (j == 4) {
                    this.j.writeUtf8(this.k);
                    l(5);
                    return;
                }
                if (j != 6) {
                    if (j != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    }
                    if (!this.g) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                l(7);
                return;
            }
            this.j.writeByte(44);
        }
        v();
    }

    public final h t(int i, int i2, String str) {
        int j = j();
        if (j != i2 && j != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.l != null) {
            throw new IllegalStateException("Dangling name: " + this.l);
        }
        int i3 = this.a;
        int i4 = i3 - 1;
        this.a = i4;
        this.d[i4] = null;
        int[] iArr = this.e;
        int i5 = i3 - 2;
        iArr[i5] = iArr[i5] + 1;
        if (j == i2) {
            v();
        }
        this.j.writeUtf8(str);
        return this;
    }

    public final void v() {
        if (this.f == null) {
            return;
        }
        this.j.writeByte(10);
        int i = this.a;
        for (int i2 = 1; i2 < i; i2++) {
            this.j.writeUtf8(this.f);
        }
    }

    public final h w(int i, String str) {
        s();
        k(i);
        this.e[this.a - 1] = 0;
        this.j.writeUtf8(str);
        return this;
    }
}
