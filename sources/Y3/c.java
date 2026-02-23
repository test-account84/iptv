package Y3;

import android.text.TextUtils;
import d4.B;
import d4.M;
import d4.k0;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public static final Pattern c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    public static final Pattern d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    public final M a = new M();
    public final StringBuilder b = new StringBuilder();

    public static boolean b(M m) {
        int f = m.f();
        int g = m.g();
        byte[] e = m.e();
        if (f + 2 > g) {
            return false;
        }
        int i = f + 1;
        if (e[f] != 47) {
            return false;
        }
        int i2 = f + 2;
        if (e[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= g) {
                m.V(g - m.f());
                return true;
            }
            if (((char) e[i2]) == '*' && ((char) e[i3]) == '/') {
                i2 += 2;
                g = i2;
            } else {
                i2 = i3;
            }
        }
    }

    public static boolean c(M m) {
        char k = k(m, m.f());
        if (k != '\t' && k != '\n' && k != '\f' && k != '\r' && k != ' ') {
            return false;
        }
        m.V(1);
        return true;
    }

    public static void e(String str, d dVar) {
        Matcher matcher = d.matcher(r5.b.e(str));
        if (!matcher.matches()) {
            B.j("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) d4.a.e(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                dVar.t(3);
                break;
            case "em":
                dVar.t(2);
                break;
            case "px":
                dVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        dVar.s(Float.parseFloat((String) d4.a.e(matcher.group(1))));
    }

    public static String f(M m, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int f = m.f();
        int g = m.g();
        while (f < g && !z) {
            char c2 = (char) m.e()[f];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                f++;
                sb.append(c2);
            }
        }
        m.V(f - m.f());
        return sb.toString();
    }

    public static String g(M m, StringBuilder sb) {
        n(m);
        if (m.a() == 0) {
            return null;
        }
        String f = f(m, sb);
        if (!"".equals(f)) {
            return f;
        }
        return "" + ((char) m.H());
    }

    public static String h(M m, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int f = m.f();
            String g = g(m, sb);
            if (g == null) {
                return null;
            }
            if ("}".equals(g) || ";".equals(g)) {
                m.U(f);
                z = true;
            } else {
                sb2.append(g);
            }
        }
        return sb2.toString();
    }

    public static String i(M m, StringBuilder sb) {
        n(m);
        if (m.a() < 5 || !"::cue".equals(m.E(5))) {
            return null;
        }
        int f = m.f();
        String g = g(m, sb);
        if (g == null) {
            return null;
        }
        if ("{".equals(g)) {
            m.U(f);
            return "";
        }
        String l = "(".equals(g) ? l(m) : null;
        if (")".equals(g(m, sb))) {
            return l;
        }
        return null;
    }

    public static void j(M m, d dVar, StringBuilder sb) {
        n(m);
        String f = f(m, sb);
        if (!"".equals(f) && ":".equals(g(m, sb))) {
            n(m);
            String h = h(m, sb);
            if (h == null || "".equals(h)) {
                return;
            }
            int f2 = m.f();
            String g = g(m, sb);
            if (!";".equals(g)) {
                if (!"}".equals(g)) {
                    return;
                } else {
                    m.U(f2);
                }
            }
            if ("color".equals(f)) {
                dVar.q(d4.g.b(h));
                return;
            }
            if ("background-color".equals(f)) {
                dVar.n(d4.g.b(h));
                return;
            }
            boolean z = true;
            if ("ruby-position".equals(f)) {
                if ("over".equals(h)) {
                    dVar.v(1);
                    return;
                } else {
                    if ("under".equals(h)) {
                        dVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(f)) {
                if (!"all".equals(h) && !h.startsWith("digits")) {
                    z = false;
                }
                dVar.p(z);
                return;
            }
            if ("text-decoration".equals(f)) {
                if ("underline".equals(h)) {
                    dVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(f)) {
                dVar.r(h);
                return;
            }
            if ("font-weight".equals(f)) {
                if ("bold".equals(h)) {
                    dVar.o(true);
                }
            } else if ("font-style".equals(f)) {
                if ("italic".equals(h)) {
                    dVar.u(true);
                }
            } else if ("font-size".equals(f)) {
                e(h, dVar);
            }
        }
    }

    public static char k(M m, int i) {
        return (char) m.e()[i];
    }

    public static String l(M m) {
        int f = m.f();
        int g = m.g();
        boolean z = false;
        while (f < g && !z) {
            int i = f + 1;
            z = ((char) m.e()[f]) == ')';
            f = i;
        }
        return m.E((f - 1) - m.f()).trim();
    }

    public static void m(M m) {
        while (!TextUtils.isEmpty(m.s())) {
        }
    }

    public static void n(M m) {
        while (true) {
            for (boolean z = true; m.a() > 0 && z; z = false) {
                if (!c(m) && !b(m)) {
                }
            }
            return;
        }
    }

    public final void a(d dVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                dVar.z((String) d4.a.e(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        String[] i1 = k0.i1(str, "\\.");
        String str2 = i1[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            dVar.y(str2.substring(0, indexOf2));
            dVar.x(str2.substring(indexOf2 + 1));
        } else {
            dVar.y(str2);
        }
        if (i1.length > 1) {
            dVar.w((String[]) k0.V0(i1, 1, i1.length));
        }
    }

    public List d(M m) {
        this.b.setLength(0);
        int f = m.f();
        m(m);
        this.a.S(m.e(), m.f());
        this.a.U(f);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i = i(this.a, this.b);
            if (i == null) {
                return arrayList;
            }
            if (!"{".equals(g(this.a, this.b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, i);
            String str = null;
            boolean z = false;
            while (!z) {
                int f2 = this.a.f();
                String g = g(this.a, this.b);
                boolean z2 = g == null || "}".equals(g);
                if (!z2) {
                    this.a.U(f2);
                    j(this.a, dVar, this.b);
                }
                str = g;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
