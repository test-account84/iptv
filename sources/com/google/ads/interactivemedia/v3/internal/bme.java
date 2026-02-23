package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bme extends boj {
    private static final Writer a = new bmd();
    private static final bkd b = new bkd("closed");
    private final List c;
    private String d;
    private bjy e;

    public bme() {
        super(a);
        this.c = new ArrayList();
        this.e = bka.a;
    }

    private final bjy t() {
        return (bjy) this.c.get(r0.size() - 1);
    }

    private final void u(bjy bjyVar) {
        if (this.d != null) {
            if (!(bjyVar instanceof bka) || q()) {
                ((bkb) t()).b(this.d, bjyVar);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = bjyVar;
            return;
        }
        bjy t = t();
        if (!(t instanceof bjw)) {
            throw new IllegalStateException();
        }
        ((bjw) t).a(bjyVar);
    }

    public final bjy a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was ".concat(this.c.toString()));
    }

    public final void b() throws IOException {
        bjw bjwVar = new bjw();
        u(bjwVar);
        this.c.add(bjwVar);
    }

    public final void c() throws IOException {
        bkb bkbVar = new bkb();
        u(bkbVar);
        this.c.add(bkbVar);
    }

    public final void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(b);
    }

    public final void d() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (!(t() instanceof bjw)) {
            throw new IllegalStateException();
        }
        this.c.remove(r0.size() - 1);
    }

    public final void e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (!(t() instanceof bkb)) {
            throw new IllegalStateException();
        }
        this.c.remove(r0.size() - 1);
    }

    public final void f(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (!(t() instanceof bkb)) {
            throw new IllegalStateException();
        }
        this.d = str;
    }

    public final void flush() throws IOException {
    }

    public final void g() throws IOException {
        u(bka.a);
    }

    public final void h(double d) throws IOException {
        if (s() || !(Double.isNaN(d) || Double.isInfinite(d))) {
            u(new bkd((Number) Double.valueOf(d)));
            return;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    public final void i(long j) throws IOException {
        u(new bkd((Number) Long.valueOf(j)));
    }

    public final void j(Boolean bool) throws IOException {
        if (bool == null) {
            g();
        } else {
            u(new bkd(bool));
        }
    }

    public final void k(Number number) throws IOException {
        if (number == null) {
            g();
            return;
        }
        if (!s()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(number.toString()));
            }
        }
        u(new bkd(number));
    }

    public final void l(String str) throws IOException {
        if (str == null) {
            g();
        } else {
            u(new bkd(str));
        }
    }

    public final void m(boolean z) throws IOException {
        u(new bkd(Boolean.valueOf(z)));
    }
}
