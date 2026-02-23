package s4;

import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements i.b {
    public final /* synthetic */ a a;

    public /* synthetic */ q(a aVar, p pVar) {
        this.a = aVar;
    }

    public final void a() {
        a.C1(this.a);
    }

    public final void b() {
        a.B1(this.a);
    }

    public final void d() {
        a aVar = this.a;
        a.x1(aVar).setText(aVar.getResources().getString(o4.t.g));
    }

    public final void f() {
        p4.i y1 = a.y1(this.a);
        if (y1 == null || !y1.q()) {
            a aVar = this.a;
            if (aVar.P) {
                return;
            }
            aVar.finish();
            return;
        }
        a aVar2 = this.a;
        aVar2.P = false;
        a.A1(aVar2);
        a.C1(this.a);
    }

    public final void c() {
    }

    public final void e() {
    }
}
