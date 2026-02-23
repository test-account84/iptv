package l3;

import d4.M;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class n {
    public static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(d3.j jVar) {
        return c(jVar, true, false);
    }

    public static boolean c(d3.j jVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        int i;
        long length = jVar.getLength();
        long j = 4096;
        long j2 = -1;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i2 != 0 && length <= 4096) {
            j = length;
        }
        int i3 = (int) j;
        M m = new M(64);
        boolean z5 = false;
        int i4 = 0;
        boolean z6 = false;
        while (i4 < i3) {
            m.Q(8);
            if (!jVar.d(m.e(), z5 ? 1 : 0, 8, true)) {
                break;
            }
            long J = m.J();
            int q = m.q();
            if (J == 1) {
                jVar.s(m.e(), 8, 8);
                m.T(16);
                J = m.A();
                i = 16;
            } else {
                if (J == 0) {
                    long length2 = jVar.getLength();
                    if (length2 != j2) {
                        J = (length2 - jVar.k()) + 8;
                    }
                }
                i = 8;
            }
            long j3 = i;
            if (J < j3) {
                return z5;
            }
            i4 += i;
            if (q == 1836019574) {
                i3 += (int) J;
                if (i2 != 0 && i3 > length) {
                    i3 = (int) length;
                }
                j2 = -1;
            } else {
                if (q == 1836019558 || q == 1836475768) {
                    z3 = true;
                    z4 = true;
                    break;
                }
                int i5 = i2;
                if ((i4 + J) - j3 >= i3) {
                    break;
                }
                int i6 = (int) (J - j3);
                i4 += i6;
                if (q == 1718909296) {
                    if (i6 < 8) {
                        return false;
                    }
                    m.Q(i6);
                    jVar.s(m.e(), 0, i6);
                    int i7 = i6 / 4;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= i7) {
                            break;
                        }
                        if (i8 == 1) {
                            m.V(4);
                        } else if (a(m.q(), z2)) {
                            z6 = true;
                            break;
                        }
                        i8++;
                    }
                    if (!z6) {
                        return false;
                    }
                } else if (i6 != 0) {
                    jVar.n(i6);
                }
                i2 = i5;
                j2 = -1;
                z5 = false;
            }
        }
        z3 = true;
        z4 = false;
        if (z6 && z == z4) {
            return z3;
        }
        return false;
    }

    public static boolean d(d3.j jVar, boolean z) {
        return c(jVar, false, z);
    }
}
