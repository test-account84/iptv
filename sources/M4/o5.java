package M4;

import com.google.android.gms.internal.measurement.zzem;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzoy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o5 extends n5 {
    public final zzet g;
    public final /* synthetic */ b h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o5(b bVar, String str, int i, zzet zzetVar) {
        super(str, i);
        this.h = bVar;
        this.g = zzetVar;
    }

    public final int a() {
        return this.g.zza();
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return true;
    }

    public final boolean k(Long l, Long l2, zzgm zzgmVar, boolean z) {
        x1 w;
        String f;
        String str;
        Boolean f2;
        zzoy.zzc();
        boolean B = this.h.a.z().B(this.a, m1.Y);
        boolean zzg = this.g.zzg();
        boolean zzh = this.g.zzh();
        boolean zzi = this.g.zzi();
        boolean z2 = zzg || zzh || zzi;
        if (z && !z2) {
            this.h.a.d().v().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.b), this.g.zzj() ? Integer.valueOf(this.g.zza()) : null);
            return true;
        }
        zzem zzb = this.g.zzb();
        boolean zzg2 = zzb.zzg();
        if (zzgmVar.zzr()) {
            if (zzb.zzi()) {
                f2 = n5.h(zzgmVar.zzb(), zzb.zzc());
                r2 = n5.j(f2, zzg2);
            } else {
                w = this.h.a.d().w();
                f = this.h.a.D().f(zzgmVar.zzf());
                str = "No number filter for long property. property";
                w.b(str, f);
            }
        } else if (!zzgmVar.zzq()) {
            if (zzgmVar.zzt()) {
                if (zzb.zzk()) {
                    f2 = n5.f(zzgmVar.zzg(), zzb.zzd(), this.h.a.d());
                } else if (!zzb.zzi()) {
                    w = this.h.a.d().w();
                    f = this.h.a.D().f(zzgmVar.zzf());
                    str = "No string or number filter defined. property";
                } else if (U4.P(zzgmVar.zzg())) {
                    f2 = n5.i(zzgmVar.zzg(), zzb.zzc());
                } else {
                    this.h.a.d().w().c("Invalid user property value for Numeric number filter. property, value", this.h.a.D().f(zzgmVar.zzf()), zzgmVar.zzg());
                }
                r2 = n5.j(f2, zzg2);
            } else {
                w = this.h.a.d().w();
                f = this.h.a.D().f(zzgmVar.zzf());
                str = "User property has no value, property";
            }
            w.b(str, f);
        } else if (zzb.zzi()) {
            f2 = n5.g(zzgmVar.zza(), zzb.zzc());
            r2 = n5.j(f2, zzg2);
        } else {
            w = this.h.a.d().w();
            f = this.h.a.D().f(zzgmVar.zzf());
            str = "No number filter for double property. property";
            w.b(str, f);
        }
        this.h.a.d().v().b("Property filter result", r2 == null ? "null" : r2);
        if (r2 == null) {
            return false;
        }
        this.c = Boolean.TRUE;
        if (zzi && !r2.booleanValue()) {
            return true;
        }
        if (!z || this.g.zzg()) {
            this.d = r2;
        }
        if (r2.booleanValue() && z2 && zzgmVar.zzs()) {
            long zzc = zzgmVar.zzc();
            if (l != null) {
                zzc = l.longValue();
            }
            if (B && this.g.zzg() && !this.g.zzh() && l2 != null) {
                zzc = l2.longValue();
            }
            if (this.g.zzh()) {
                this.f = Long.valueOf(zzc);
            } else {
                this.e = Long.valueOf(zzc);
            }
        }
        return true;
    }
}
