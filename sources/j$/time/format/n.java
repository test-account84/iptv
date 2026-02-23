package j$.time.format;

import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class n {
    private static final a f = new a();
    private n a;
    private final n b;
    private final ArrayList c;
    private final boolean d;
    private int e;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', j$.time.temporal.a.ERA);
        hashMap.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        hashMap.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.r rVar = j$.time.temporal.j.a;
        hashMap.put('Q', rVar);
        hashMap.put('q', rVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        hashMap.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        hashMap.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        hashMap.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        hashMap.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        hashMap.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        hashMap.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', j$.time.temporal.a.NANO_OF_DAY);
        hashMap.put('g', j$.time.temporal.l.a);
    }

    public n() {
        this.a = this;
        this.c = new ArrayList();
        this.e = -1;
        this.b = null;
        this.d = false;
    }

    private n(n nVar) {
        this.a = this;
        this.c = new ArrayList();
        this.e = -1;
        this.b = nVar;
        this.d = true;
    }

    private int d(f fVar) {
        Objects.a(fVar, "pp");
        n nVar = this.a;
        nVar.getClass();
        nVar.c.add(fVar);
        this.a.e = -1;
        return r2.c.size() - 1;
    }

    private void j(i iVar) {
        i b;
        n nVar = this.a;
        int i = nVar.e;
        if (i < 0) {
            nVar.e = d(iVar);
            return;
        }
        i iVar2 = (i) nVar.c.get(i);
        int i2 = iVar.b;
        int i3 = iVar.c;
        if (i2 == i3 && i.a(iVar) == u.NOT_NEGATIVE) {
            b = iVar2.c(i3);
            d(iVar.b());
            this.a.e = i;
        } else {
            b = iVar2.b();
            this.a.e = d(iVar);
        }
        this.a.c.set(i, b);
    }

    private DateTimeFormatter u(Locale locale, t tVar, j$.time.chrono.n nVar) {
        Objects.a(locale, "locale");
        while (this.a.b != null) {
            n();
        }
        e eVar = new e((List) this.c, false);
        s sVar = s.a;
        return new DateTimeFormatter(eVar, locale, tVar, nVar);
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        d(dateTimeFormatter.f());
    }

    public final void b(j$.time.temporal.r rVar) {
        g gVar = new g(rVar, 0, 9, true, 0);
        Objects.a(rVar, "field");
        if (!rVar.i().g()) {
            throw new IllegalArgumentException(j$.time.d.a("Field must have a fixed set of values: ", rVar));
        }
        d(gVar);
    }

    public final void c() {
        d(new h());
    }

    public final void e(char c) {
        d(new d(c));
    }

    public final void f(String str) {
        if (str.isEmpty()) {
            return;
        }
        d(str.length() == 1 ? new d(str.charAt(0)) : new l(str, 0));
    }

    public final void g(String str, String str2) {
        d(new j(str, str2));
    }

    public final void h() {
        d(j.e);
    }

    public final void i(j$.time.temporal.r rVar, HashMap hashMap) {
        Objects.a(rVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(hashMap);
        v vVar = v.FULL;
        d(new m(rVar, vVar, new b(new r(Collections.singletonMap(vVar, linkedHashMap)))));
    }

    public final void k(j$.time.temporal.r rVar, int i) {
        Objects.a(rVar, "field");
        if (i >= 1 && i <= 19) {
            j(new i(rVar, i, i, u.NOT_NEGATIVE));
        } else {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i);
        }
    }

    public final void l(j$.time.temporal.r rVar, int i, int i2, u uVar) {
        if (i == i2 && uVar == u.NOT_NEGATIVE) {
            k(rVar, i2);
            return;
        }
        Objects.a(rVar, "field");
        Objects.a(uVar, "signStyle");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i);
        }
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i2);
        }
        if (i2 >= i) {
            j(new i(rVar, i, i2, uVar));
            return;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
    }

    public final void m() {
        d(new l(f, 1));
    }

    public final void n() {
        n nVar = this.a;
        if (nVar.b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (nVar.c.size() <= 0) {
            this.a = this.a.b;
            return;
        }
        n nVar2 = this.a;
        e eVar = new e((List) nVar2.c, nVar2.d);
        this.a = this.a.b;
        d(eVar);
    }

    public final void o() {
        n nVar = this.a;
        nVar.e = -1;
        this.a = new n(nVar);
    }

    public final void p() {
        d(k.INSENSITIVE);
    }

    public final void q() {
        d(k.SENSITIVE);
    }

    public final void r() {
        d(k.LENIENT);
    }

    public final void s() {
        d(k.STRICT);
    }

    final DateTimeFormatter t(t tVar, j$.time.chrono.n nVar) {
        return u(Locale.getDefault(), tVar, nVar);
    }

    public final void v() {
        u(Locale.getDefault(), t.SMART, null);
    }
}
