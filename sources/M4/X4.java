package M4;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzph;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x4 {
    public long a;
    public long b;
    public final o c;
    public final /* synthetic */ z4 d;

    public x4(z4 z4Var) {
        this.d = z4Var;
        this.c = new w4(this, z4Var.a);
        long b = z4Var.a.a().b();
        this.a = b;
        this.b = b;
    }

    public final void a() {
        this.c.b();
        this.a = 0L;
        this.b = 0L;
    }

    public final void b(long j) {
        this.c.b();
    }

    public final void c(long j) {
        this.d.h();
        this.c.b();
        this.a = j;
        this.b = j;
    }

    public final boolean d(boolean z, boolean z2, long j) {
        this.d.h();
        this.d.i();
        zzph.zzc();
        if (!this.d.a.z().B(null, m1.h0) || this.d.a.o()) {
            this.d.a.F().o.b(this.d.a.a().a());
        }
        long j2 = j - this.a;
        if (!z && j2 < 1000) {
            this.d.a.d().v().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
            return false;
        }
        if (!z2) {
            j2 = j - this.b;
            this.b = j;
        }
        this.d.a.d().v().b("Recording user engagement, ms", Long.valueOf(j2));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        a5.y(this.d.a.K().s(!this.d.a.z().D()), bundle, true);
        if (!z2) {
            this.d.a.I().u("auto", "_e", bundle);
        }
        this.a = j;
        this.c.b();
        this.c.d(3600000L);
        return true;
    }
}
