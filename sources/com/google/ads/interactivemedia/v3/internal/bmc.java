package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bmc extends boh {
    private static final Reader b = new bmb();
    private static final Object c = new Object();
    private Object[] d;
    private int e;
    private String[] f;
    private int[] g;

    public bmc(bjy bjyVar) {
        super(b);
        this.d = new Object[32];
        this.e = 0;
        this.f = new String[32];
        this.g = new int[32];
        A(bjyVar);
    }

    private final void A(Object obj) {
        int i = this.e;
        Object[] objArr = this.d;
        if (i == objArr.length) {
            int i2 = i + i;
            this.d = Arrays.copyOf(objArr, i2);
            this.g = Arrays.copyOf(this.g, i2);
            this.f = (String[]) Arrays.copyOf(this.f, i2);
        }
        Object[] objArr2 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        objArr2[i3] = obj;
    }

    private final void B(int i) throws IOException {
        if (r() == i) {
            return;
        }
        int r = r();
        throw new IllegalStateException("Expected " + boi.a(i) + " but was " + boi.a(r) + z());
    }

    private final Object w() {
        return this.d[this.e - 1];
    }

    private final Object x() {
        Object[] objArr = this.d;
        int i = this.e - 1;
        this.e = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private final String y(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (true) {
            int i2 = this.e;
            if (i >= i2) {
                return sb.toString();
            }
            Object[] objArr = this.d;
            Object obj = objArr[i];
            if (obj instanceof bjw) {
                i++;
                if (i < i2 && (objArr[i] instanceof Iterator)) {
                    int i3 = this.g[i];
                    if (z && i3 > 0 && (i == i2 - 1 || i == i2 - 2)) {
                        i3--;
                    }
                    sb.append('[');
                    sb.append(i3);
                    sb.append(']');
                }
            } else if ((obj instanceof bkb) && (i = i + 1) < i2 && (objArr[i] instanceof Iterator)) {
                sb.append('.');
                String str = this.f[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private final String z() {
        return " at path ".concat(String.valueOf(e()));
    }

    public final double a() throws IOException {
        int r = r();
        if (r != 7 && r != 6) {
            throw new IllegalStateException("Expected NUMBER but was " + boi.a(r) + z());
        }
        bkd bkdVar = (bkd) w();
        double doubleValue = bkdVar.e() ? bkdVar.a().doubleValue() : Double.parseDouble(bkdVar.b());
        if (!v() && (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue))) {
            throw new bok("JSON forbids NaN and infinities: " + doubleValue);
        }
        x();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return doubleValue;
    }

    public final int b() throws IOException {
        int r = r();
        if (r != 7 && r != 6) {
            throw new IllegalStateException("Expected NUMBER but was " + boi.a(r) + z());
        }
        bkd bkdVar = (bkd) w();
        int intValue = bkdVar.e() ? bkdVar.a().intValue() : Integer.parseInt(bkdVar.b());
        x();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return intValue;
    }

    public final long c() throws IOException {
        int r = r();
        if (r != 7 && r != 6) {
            throw new IllegalStateException("Expected NUMBER but was " + boi.a(r) + z());
        }
        bkd bkdVar = (bkd) w();
        long longValue = bkdVar.e() ? bkdVar.a().longValue() : Long.parseLong(bkdVar.b());
        x();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return longValue;
    }

    public final void close() throws IOException {
        this.d = new Object[]{c};
        this.e = 1;
    }

    public final bjy d() throws IOException {
        int r = r();
        if (r != 5 && r != 2 && r != 4 && r != 10) {
            bjy bjyVar = (bjy) w();
            o();
            return bjyVar;
        }
        throw new IllegalStateException("Unexpected " + boi.a(r) + " when reading a JsonElement.");
    }

    public final String e() {
        return y(false);
    }

    public final String f() {
        return y(true);
    }

    public final String g() throws IOException {
        B(5);
        Map.Entry entry = (Map.Entry) ((Iterator) w()).next();
        String str = (String) entry.getKey();
        this.f[this.e - 1] = str;
        A(entry.getValue());
        return str;
    }

    public final String h() throws IOException {
        int r = r();
        if (r == 6 || r == 7) {
            String b2 = ((bkd) x()).b();
            int i = this.e;
            if (i > 0) {
                int[] iArr = this.g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return b2;
        }
        throw new IllegalStateException("Expected STRING but was " + boi.a(r) + z());
    }

    public final void i() throws IOException {
        B(1);
        A(((bjw) w()).iterator());
        this.g[this.e - 1] = 0;
    }

    public final void j() throws IOException {
        B(3);
        A(((bkb) w()).a().iterator());
    }

    public final void k() throws IOException {
        B(2);
        x();
        x();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final void l() throws IOException {
        B(4);
        x();
        x();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final void m() throws IOException {
        B(9);
        x();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final void n() throws IOException {
        B(5);
        Map.Entry entry = (Map.Entry) ((Iterator) w()).next();
        A(entry.getValue());
        A(new bkd((String) entry.getKey()));
    }

    public final void o() throws IOException {
        if (r() == 5) {
            g();
            this.f[this.e - 2] = "null";
        } else {
            x();
            int i = this.e;
            if (i > 0) {
                this.f[i - 1] = "null";
            }
        }
        int i2 = this.e;
        if (i2 > 0) {
            int[] iArr = this.g;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final boolean p() throws IOException {
        int r = r();
        return (r == 4 || r == 2 || r == 10) ? false : true;
    }

    public final boolean q() throws IOException {
        B(8);
        boolean c2 = ((bkd) x()).c();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return c2;
    }

    public final int r() throws IOException {
        if (this.e == 0) {
            return 10;
        }
        Object w = w();
        if (w instanceof Iterator) {
            boolean z = this.d[this.e - 2] instanceof bkb;
            Iterator it = (Iterator) w;
            if (!it.hasNext()) {
                return z ? 4 : 2;
            }
            if (z) {
                return 5;
            }
            A(it.next());
            return r();
        }
        if (w instanceof bkb) {
            return 3;
        }
        if (w instanceof bjw) {
            return 1;
        }
        if (w instanceof bkd) {
            bkd bkdVar = (bkd) w;
            if (bkdVar.f()) {
                return 6;
            }
            if (bkdVar.d()) {
                return 8;
            }
            if (bkdVar.e()) {
                return 7;
            }
            throw new AssertionError();
        }
        if (w instanceof bka) {
            return 9;
        }
        if (w == c) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new bok("Custom JsonElement subclass " + w.getClass().getName() + " is not supported");
    }

    public final String toString() {
        return bmc.class.getSimpleName().concat(String.valueOf(z()));
    }
}
