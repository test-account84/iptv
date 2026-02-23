package y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h extends m {
    public h(x.e eVar) {
        super(eVar);
        eVar.e.f();
        eVar.f.f();
        this.f = ((x.g) eVar).G0();
    }

    public void a(d dVar) {
        f fVar = this.h;
        if (fVar.c && !fVar.j) {
            this.h.d((int) ((((f) fVar.l.get(0)).g * ((x.g) this.b).J0()) + 0.5f));
        }
    }

    public void d() {
        f fVar;
        m mVar;
        f fVar2;
        x.g gVar = (x.g) this.b;
        int H0 = gVar.H0();
        int I0 = gVar.I0();
        gVar.J0();
        if (gVar.G0() == 1) {
            f fVar3 = this.h;
            if (H0 != -1) {
                fVar3.l.add(this.b.N.e.h);
                this.b.N.e.h.k.add(this.h);
                fVar2 = this.h;
            } else if (I0 != -1) {
                fVar3.l.add(this.b.N.e.i);
                this.b.N.e.i.k.add(this.h);
                fVar2 = this.h;
                H0 = -I0;
            } else {
                fVar3.b = true;
                fVar3.l.add(this.b.N.e.i);
                this.b.N.e.i.k.add(this.h);
                q(this.b.e.h);
                mVar = this.b.e;
            }
            fVar2.f = H0;
            q(this.b.e.h);
            mVar = this.b.e;
        } else {
            f fVar4 = this.h;
            if (H0 != -1) {
                fVar4.l.add(this.b.N.f.h);
                this.b.N.f.h.k.add(this.h);
                fVar = this.h;
            } else if (I0 != -1) {
                fVar4.l.add(this.b.N.f.i);
                this.b.N.f.i.k.add(this.h);
                fVar = this.h;
                H0 = -I0;
            } else {
                fVar4.b = true;
                fVar4.l.add(this.b.N.f.i);
                this.b.N.f.i.k.add(this.h);
                q(this.b.f.h);
                mVar = this.b.f;
            }
            fVar.f = H0;
            q(this.b.f.h);
            mVar = this.b.f;
        }
        q(mVar.i);
    }

    public void e() {
        if (((x.g) this.b).G0() == 1) {
            this.b.B0(this.h.g);
        } else {
            this.b.C0(this.h.g);
        }
    }

    public void f() {
        this.h.c();
    }

    public boolean m() {
        return false;
    }

    public final void q(f fVar) {
        this.h.k.add(fVar);
        fVar.l.add(this.h);
    }
}
