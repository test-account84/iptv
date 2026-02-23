package y;

import java.util.Iterator;
import y.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i extends m {
    public i(x.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.h.k.add(fVar);
        fVar.l.add(this.h);
    }

    public void a(d dVar) {
        x.a aVar = (x.a) this.b;
        int H0 = aVar.H0();
        Iterator it = this.h.l.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            int i3 = ((f) it.next()).g;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (H0 == 0 || H0 == 2) {
            this.h.d(i2 + aVar.I0());
        } else {
            this.h.d(i + aVar.I0());
        }
    }

    public void d() {
        m mVar;
        x.e eVar = this.b;
        if (eVar instanceof x.a) {
            this.h.b = true;
            x.a aVar = (x.a) eVar;
            int H0 = aVar.H0();
            boolean G0 = aVar.G0();
            int i = 0;
            if (H0 == 0) {
                this.h.e = f.a.LEFT;
                while (i < aVar.x0) {
                    x.e eVar2 = aVar.w0[i];
                    if (G0 || eVar2.M() != 8) {
                        f fVar = eVar2.e.h;
                        fVar.k.add(this.h);
                        this.h.l.add(fVar);
                    }
                    i++;
                }
            } else {
                if (H0 != 1) {
                    if (H0 == 2) {
                        this.h.e = f.a.TOP;
                        while (i < aVar.x0) {
                            x.e eVar3 = aVar.w0[i];
                            if (G0 || eVar3.M() != 8) {
                                f fVar2 = eVar3.f.h;
                                fVar2.k.add(this.h);
                                this.h.l.add(fVar2);
                            }
                            i++;
                        }
                    } else {
                        if (H0 != 3) {
                            return;
                        }
                        this.h.e = f.a.BOTTOM;
                        while (i < aVar.x0) {
                            x.e eVar4 = aVar.w0[i];
                            if (G0 || eVar4.M() != 8) {
                                f fVar3 = eVar4.f.i;
                                fVar3.k.add(this.h);
                                this.h.l.add(fVar3);
                            }
                            i++;
                        }
                    }
                    q(this.b.f.h);
                    mVar = this.b.f;
                    q(mVar.i);
                }
                this.h.e = f.a.RIGHT;
                while (i < aVar.x0) {
                    x.e eVar5 = aVar.w0[i];
                    if (G0 || eVar5.M() != 8) {
                        f fVar4 = eVar5.e.i;
                        fVar4.k.add(this.h);
                        this.h.l.add(fVar4);
                    }
                    i++;
                }
            }
            q(this.b.e.h);
            mVar = this.b.e;
            q(mVar.i);
        }
    }

    public void e() {
        x.e eVar = this.b;
        if (eVar instanceof x.a) {
            int H0 = ((x.a) eVar).H0();
            if (H0 == 0 || H0 == 1) {
                this.b.B0(this.h.g);
            } else {
                this.b.C0(this.h.g);
            }
        }
    }

    public void f() {
        this.c = null;
        this.h.c();
    }

    public boolean m() {
        return false;
    }
}
