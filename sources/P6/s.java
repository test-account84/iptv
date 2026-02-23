package P6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class s {
    public final D6.a a;
    public final m b = new m();
    public final StringBuilder c = new StringBuilder();

    public s(D6.a aVar) {
        this.a = aVar;
    }

    public static int g(D6.a aVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.h(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String a(StringBuilder sb, int i) {
        String str = null;
        while (true) {
            o c = c(i, str);
            String a = r.a(c.b());
            if (a != null) {
                sb.append(a);
            }
            String valueOf = c.d() ? String.valueOf(c.c()) : null;
            if (i == c.a()) {
                return sb.toString();
            }
            i = c.a();
            str = valueOf;
        }
    }

    public final n b(int i) {
        char c;
        int f = f(i, 5);
        if (f == 15) {
            return new n(i + 5, '$');
        }
        if (f >= 5 && f < 15) {
            return new n(i + 5, (char) (f + 43));
        }
        int f2 = f(i, 6);
        if (f2 >= 32 && f2 < 58) {
            return new n(i + 6, (char) (f2 + 33));
        }
        switch (f2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(f2)));
        }
        return new n(i + 6, c);
    }

    public o c(int i, String str) {
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.b.h(i);
        o o = o();
        return (o == null || !o.d()) ? new o(this.b.a(), this.c.toString()) : new o(this.b.a(), this.c.toString(), o.c());
    }

    public final n d(int i) {
        int f = f(i, 5);
        if (f == 15) {
            return new n(i + 5, '$');
        }
        char c = '+';
        if (f >= 5 && f < 15) {
            return new n(i + 5, (char) (f + 43));
        }
        int f2 = f(i, 7);
        if (f2 >= 64 && f2 < 90) {
            return new n(i + 7, (char) (f2 + 1));
        }
        if (f2 >= 90 && f2 < 116) {
            return new n(i + 7, (char) (f2 + 7));
        }
        switch (f(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw x6.g.a();
        }
        return new n(i + 8, c);
    }

    public final p e(int i) {
        int i2 = i + 7;
        if (i2 > this.a.l()) {
            int f = f(i, 4);
            return f == 0 ? new p(this.a.l(), 10, 10) : new p(this.a.l(), f - 1, 10);
        }
        int f2 = f(i, 7) - 8;
        return new p(i2, f2 / 11, f2 % 11);
    }

    public int f(int i, int i2) {
        return g(this.a, i, i2);
    }

    public final boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.a.l()) {
            return false;
        }
        while (i < i2) {
            if (this.a.h(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean i(int i) {
        int i2;
        if (i + 1 > this.a.l()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.a.l(); i3++) {
            if (i3 == 2) {
                if (!this.a.h(i + 2)) {
                    return false;
                }
            } else if (this.a.h(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i) {
        int i2;
        if (i + 1 > this.a.l()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.a.l(); i3++) {
            if (this.a.h(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i) {
        int f;
        if (i + 5 > this.a.l()) {
            return false;
        }
        int f2 = f(i, 5);
        if (f2 < 5 || f2 >= 16) {
            return i + 6 <= this.a.l() && (f = f(i, 6)) >= 16 && f < 63;
        }
        return true;
    }

    public final boolean l(int i) {
        int f;
        if (i + 5 > this.a.l()) {
            return false;
        }
        int f2 = f(i, 5);
        if (f2 >= 5 && f2 < 16) {
            return true;
        }
        if (i + 7 > this.a.l()) {
            return false;
        }
        int f3 = f(i, 7);
        if (f3 < 64 || f3 >= 116) {
            return i + 8 <= this.a.l() && (f = f(i, 8)) >= 232 && f < 253;
        }
        return true;
    }

    public final boolean m(int i) {
        if (i + 7 > this.a.l()) {
            return i + 4 <= this.a.l();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.a.h(i3);
            }
            if (this.a.h(i2)) {
                return true;
            }
            i2++;
        }
    }

    public final l n() {
        while (k(this.b.a())) {
            n b = b(this.b.a());
            this.b.h(b.a());
            if (b.c()) {
                return new l(new o(this.b.a(), this.c.toString()), true);
            }
            this.c.append(b.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.l()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.l());
            }
            this.b.f();
        }
        return new l(false);
    }

    public final o o() {
        l n;
        boolean b;
        do {
            int a = this.b.a();
            n = this.b.c() ? n() : this.b.d() ? p() : q();
            b = n.b();
            if (a == this.b.a() && !b) {
                break;
            }
        } while (!b);
        return n.a();
    }

    public final l p() {
        while (l(this.b.a())) {
            n d = d(this.b.a());
            this.b.h(d.a());
            if (d.c()) {
                return new l(new o(this.b.a(), this.c.toString()), true);
            }
            this.c.append(d.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.l()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.l());
            }
            this.b.e();
        }
        return new l(false);
    }

    public final l q() {
        while (m(this.b.a())) {
            p e = e(this.b.a());
            this.b.h(e.a());
            if (e.d()) {
                return new l(e.e() ? new o(this.b.a(), this.c.toString()) : new o(this.b.a(), this.c.toString(), e.c()), true);
            }
            this.c.append(e.b());
            if (e.e()) {
                return new l(new o(this.b.a(), this.c.toString()), true);
            }
            this.c.append(e.c());
        }
        if (j(this.b.a())) {
            this.b.e();
            this.b.b(4);
        }
        return new l(false);
    }
}
