package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aem {
    private boolean d;
    private boolean e;
    private boolean f;
    private final int a = 112800;
    private final co b = new co(0);
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private long i = -9223372036854775807L;
    private final cj c = new cj();

    public aem(int i) {
    }

    private final void e(zi ziVar) {
        this.c.C(cq.f);
        this.d = true;
        ziVar.h();
    }

    public final int a(zi ziVar, zy zyVar, int i) throws IOException {
        if (i <= 0) {
            e(ziVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.f) {
            long b = ziVar.b();
            int min = (int) Math.min(112800L, b);
            long j2 = b - min;
            if (ziVar.d() != j2) {
                zyVar.a = j2;
                return 1;
            }
            this.c.B(min);
            ziVar.h();
            ziVar.f(this.c.H(), 0, min);
            cj cjVar = this.c;
            int c = cjVar.c();
            int d = cjVar.d();
            int i2 = d - 188;
            while (true) {
                if (i2 < c) {
                    break;
                }
                byte[] H = cjVar.H();
                int i3 = -4;
                int i4 = 0;
                while (true) {
                    if (i3 > 4) {
                        break;
                    }
                    int i5 = (i3 * 188) + i2;
                    if (i5 < c || i5 >= d || H[i5] != 71) {
                        i4 = 0;
                    } else {
                        i4++;
                        if (i4 == 5) {
                            long g = afe.g(cjVar, i2, i);
                            if (g != -9223372036854775807L) {
                                j = g;
                                break;
                            }
                        }
                    }
                    i3++;
                }
                i2--;
            }
            this.h = j;
            this.f = true;
            return 0;
        }
        if (this.h == -9223372036854775807L) {
            e(ziVar);
            return 0;
        }
        if (this.e) {
            long j3 = this.g;
            if (j3 == -9223372036854775807L) {
                e(ziVar);
                return 0;
            }
            long b2 = this.b.b(this.h) - this.b.b(j3);
            this.i = b2;
            if (b2 < 0) {
                cd.e("TsDurationReader", "Invalid duration: " + b2 + ". Using TIME_UNSET instead.");
                this.i = -9223372036854775807L;
            }
            e(ziVar);
            return 0;
        }
        int min2 = (int) Math.min(112800L, ziVar.b());
        if (ziVar.d() != 0) {
            zyVar.a = 0L;
            return 1;
        }
        this.c.B(min2);
        ziVar.h();
        ziVar.f(this.c.H(), 0, min2);
        cj cjVar2 = this.c;
        int c2 = cjVar2.c();
        int d2 = cjVar2.d();
        while (true) {
            if (c2 >= d2) {
                break;
            }
            if (cjVar2.H()[c2] == 71) {
                long g2 = afe.g(cjVar2, c2, i);
                if (g2 != -9223372036854775807L) {
                    j = g2;
                    break;
                }
            }
            c2++;
        }
        this.g = j;
        this.e = true;
        return 0;
    }

    public final long b() {
        return this.i;
    }

    public final co c() {
        return this.b;
    }

    public final boolean d() {
        return this.d;
    }
}
