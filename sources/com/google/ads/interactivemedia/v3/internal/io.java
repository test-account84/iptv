package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class io {
    final /* synthetic */ ip a;
    private final String b;
    private int c;
    private long d;
    private te e;
    private boolean f;
    private boolean g;

    public io(ip ipVar, String str, int i, te teVar) {
        this.a = ipVar;
        this.b = str;
        this.c = i;
        this.d = teVar == null ? -1L : teVar.d;
        if (teVar == null || !teVar.b()) {
            return;
        }
        this.e = teVar;
    }

    public static /* bridge */ /* synthetic */ int a(io ioVar) {
        return ioVar.c;
    }

    public static /* bridge */ /* synthetic */ long b(io ioVar) {
        return ioVar.d;
    }

    public static /* bridge */ /* synthetic */ te c(io ioVar) {
        return ioVar.e;
    }

    public static /* bridge */ /* synthetic */ String d(io ioVar) {
        return ioVar.b;
    }

    public static /* bridge */ /* synthetic */ boolean f(io ioVar) {
        return ioVar.g;
    }

    public static /* bridge */ /* synthetic */ boolean g(io ioVar) {
        return ioVar.f;
    }

    public static /* bridge */ /* synthetic */ void k(io ioVar) {
        ioVar.g = true;
    }

    public static /* bridge */ /* synthetic */ void l(io ioVar) {
        ioVar.f = true;
    }

    public final void e(int i, te teVar) {
        if (this.d == -1 && i == this.c && teVar != null) {
            this.d = teVar.d;
        }
    }

    public final boolean h(int i, te teVar) {
        if (teVar == null) {
            return i == this.c;
        }
        te teVar2 = this.e;
        return teVar2 == null ? !teVar.b() && teVar.d == this.d : teVar.d == teVar2.d && teVar.b == teVar2.b && teVar.c == teVar2.c;
    }

    public final boolean i(hv hvVar) {
        long j = this.d;
        if (j == -1) {
            return false;
        }
        te teVar = hvVar.d;
        if (teVar == null) {
            return this.c != hvVar.c;
        }
        if (teVar.d > j) {
            return true;
        }
        if (this.e == null) {
            return false;
        }
        int a = hvVar.b.a(teVar.a);
        int a2 = hvVar.b.a(this.e.a);
        te teVar2 = hvVar.d;
        if (teVar2.d < this.e.d || a < a2) {
            return false;
        }
        if (a > a2) {
            return true;
        }
        boolean b = teVar2.b();
        te teVar3 = hvVar.d;
        if (!b) {
            int i = teVar3.e;
            return i == -1 || i > this.e.b;
        }
        int i2 = teVar3.b;
        int i3 = teVar3.c;
        te teVar4 = this.e;
        int i4 = teVar4.b;
        return i2 > i4 || (i2 == i4 && i3 > teVar4.c);
    }

    public final boolean j(be beVar, be beVar2) {
        int i = this.c;
        if (i < beVar.c()) {
            beVar.o(i, ip.b(this.a));
            for (int i2 = ip.b(this.a).o; i2 <= ip.b(this.a).p; i2++) {
                int a = beVar2.a(beVar.f(i2));
                if (a != -1) {
                    i = beVar2.m(a, ip.a(this.a)).c;
                    break;
                }
            }
            i = -1;
        } else if (i >= beVar2.c()) {
            i = -1;
        }
        this.c = i;
        if (i == -1) {
            return false;
        }
        te teVar = this.e;
        return teVar == null || beVar2.a(teVar.a) != -1;
    }
}
