package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class bto {
    public bto() {
    }

    public static /* synthetic */ void A(Object obj, btn btnVar) throws IOException {
        ((bsx) obj).k(btnVar);
    }

    public static String B(bpb bpbVar) {
        String str;
        bsv bsvVar = new bsv(bpbVar);
        StringBuilder sb = new StringBuilder(bsvVar.a());
        for (int i = 0; i < bsvVar.a(); i++) {
            int a = bsvVar.a.a(i);
            if (a == 34) {
                str = "\\\"";
            } else if (a == 39) {
                str = "\\'";
            } else if (a != 92) {
                switch (a) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a < 32 || a > 126) {
                            sb.append('\\');
                            sb.append((char) (((a >>> 6) & 3) + 48));
                            sb.append((char) (((a >>> 3) & 7) + 48));
                            a = (a & 7) + 48;
                        }
                        sb.append((char) a);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static /* synthetic */ boolean C(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    public static boolean D(Object[] objArr, Object obj) {
        if (objArr != null) {
            if (obj == null) {
                for (Object obj2 : objArr) {
                    if (obj2 == null) {
                        return true;
                    }
                }
            } else {
                for (Object obj3 : objArr) {
                    if (obj.equals(obj3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int E(byte b) {
        return b & 63;
    }

    private static boolean F(byte b) {
        return b > -65;
    }

    public static /* bridge */ /* synthetic */ void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (F(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || F(b3) || F(b4)) {
            throw bqw.d();
        }
        int E = ((b & 7) << 18) | (E(b2) << 12) | (E(b3) << 6) | E(b4);
        cArr[i] = (char) ((E >>> 10) + 55232);
        cArr[i + 1] = (char) ((E & 1023) + 56320);
    }

    public static /* bridge */ /* synthetic */ void b(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    public static /* bridge */ /* synthetic */ void c(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (!F(b2)) {
            if (b != -32) {
                if ((b == -19 || b2 < -96) && !F(b3)) {
                    cArr[i] = (char) (((b & 15) << 12) | (E(b2) << 6) | E(b3));
                    return;
                }
            } else if (b2 >= -96) {
                b = -32;
                if (b == -19) {
                    cArr[i] = (char) (((b & 15) << 12) | (E(b2) << 6) | E(b3));
                    return;
                } else {
                    cArr[i] = (char) (((b & 15) << 12) | (E(b2) << 6) | E(b3));
                    return;
                }
            }
        }
        throw bqw.d();
    }

    public static /* bridge */ /* synthetic */ void d(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || F(b2)) {
            throw bqw.d();
        }
        cArr[i] = (char) (((b & 31) << 6) | E(b2));
    }

    public static /* bridge */ /* synthetic */ boolean e(byte b) {
        return b >= 0;
    }

    public static /* bridge */ /* synthetic */ boolean f(byte b) {
        return b < -16;
    }

    public static /* bridge */ /* synthetic */ boolean g(byte b) {
        return b < -32;
    }

    public static /* bridge */ /* synthetic */ void n(Object obj, int i, int i2) {
        ((bsx) obj).i(btm.c(i, 5), Integer.valueOf(i2));
    }

    public static /* bridge */ /* synthetic */ void o(Object obj, int i, long j) {
        ((bsx) obj).i(btm.c(i, 1), Long.valueOf(j));
    }

    public static /* bridge */ /* synthetic */ void p(Object obj, int i, Object obj2) {
        ((bsx) obj).i(btm.c(i, 3), obj2);
    }

    public static /* bridge */ /* synthetic */ void q(Object obj, int i, bpb bpbVar) {
        ((bsx) obj).i(btm.c(i, 2), bpbVar);
    }

    public static /* bridge */ /* synthetic */ void r(Object obj, int i, long j) {
        ((bsx) obj).i(btm.c(i, 0), Long.valueOf(j));
    }

    public static bsx s(Object obj) {
        return ((bqn) obj).c;
    }

    public static /* synthetic */ int t(Object obj) {
        return ((bsx) obj).a();
    }

    public static /* synthetic */ int u(Object obj) {
        return ((bsx) obj).b();
    }

    public static /* bridge */ /* synthetic */ Object v(Object obj, Object obj2) {
        if (bsx.c().equals(obj2)) {
            return obj;
        }
        bsx bsxVar = (bsx) obj2;
        if (bsx.c().equals(obj)) {
            return bsx.d((bsx) obj, bsxVar);
        }
        ((bsx) obj).l(bsxVar);
        return obj;
    }

    public static /* synthetic */ Object w() {
        return bsx.e();
    }

    public static void x(Object obj, bsx bsxVar) {
        ((bqn) obj).c = bsxVar;
    }

    public static /* synthetic */ Object y(Object obj) {
        ((bsx) obj).g();
        return obj;
    }

    public static /* synthetic */ void z(Object obj, btn btnVar) throws IOException {
        ((bsx) obj).j(btnVar);
    }

    public final boolean h(Object obj, bsd bsdVar) throws IOException {
        int d = bsdVar.d();
        int a = btm.a(d);
        int b = btm.b(d);
        if (b == 0) {
            r(obj, a, bsdVar.l());
            return true;
        }
        if (b == 1) {
            o(obj, a, bsdVar.k());
            return true;
        }
        if (b == 2) {
            q(obj, a, bsdVar.p());
            return true;
        }
        if (b != 3) {
            if (b == 4) {
                return false;
            }
            if (b != 5) {
                throw bqw.a();
            }
            n(obj, a, bsdVar.f());
            return true;
        }
        int c = btm.c(a, 4);
        Object w = w();
        while (bsdVar.c() != Integer.MAX_VALUE && h(w, bsdVar)) {
        }
        if (c != bsdVar.d()) {
            throw bqw.b();
        }
        p(obj, a, y(w));
        return true;
    }

    public final /* bridge */ /* synthetic */ Object i(Object obj) {
        bsx s = s(obj);
        if (s != bsx.c()) {
            return s;
        }
        bsx e = bsx.e();
        x(obj, e);
        return e;
    }

    public final /* bridge */ /* synthetic */ Object j(Object obj) {
        return s(obj);
    }

    public final void k(Object obj) {
        s(obj).g();
    }

    public final /* synthetic */ void l(Object obj, Object obj2) {
        x(obj, (bsx) obj2);
    }

    public final /* bridge */ /* synthetic */ void m(Object obj, Object obj2) {
        x(obj, (bsx) obj2);
    }

    public bto(byte[] bArr) {
        this();
    }
}
