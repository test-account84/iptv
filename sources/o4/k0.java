package o4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k0 extends s0 {
    public final /* synthetic */ e a;

    public /* synthetic */ k0(e eVar, j0 j0Var) {
        this.a = eVar;
    }

    public final void A0(String str, n4.i iVar) {
        e eVar = this.a;
        if (e.v(eVar) == null || !e.v(eVar).zzl()) {
            return;
        }
        n4.Y y = (n4.Y) e.v(this.a);
        y.doWrite(com.google.android.gms.common.api.internal.t.a().b(new n4.E(y, str, iVar)).e(8406).a()).addOnCompleteListener(new h0(this));
    }

    public final void J0(String str, String str2) {
        e eVar = this.a;
        if (e.v(eVar) == null || !e.v(eVar).zzl()) {
            return;
        }
        n4.Y y = (n4.Y) e.v(this.a);
        y.doWrite(com.google.android.gms.common.api.internal.t.a().b(new n4.L(y, str, str2, null)).e(8407).a()).addOnCompleteListener(new i0(this));
    }

    public final void p0(String str) {
        e eVar = this.a;
        if (e.v(eVar) == null || !e.v(eVar).zzl()) {
            return;
        }
        n4.Y y = (n4.Y) e.v(this.a);
        y.doWrite(com.google.android.gms.common.api.internal.t.a().b(new n4.I(y, str)).e(8409).a());
    }

    public final void zzb(int i) {
        e.A(this.a, i);
    }
}
