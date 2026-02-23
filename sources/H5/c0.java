package H5;

import com.google.android.gms.internal.firebase-auth-api.zzafw;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 {
    public final int a;
    public final String b;
    public final String c;
    public final G5.b d;

    public c0(zzafw zzafwVar) {
        int i = 5;
        this.b = zzafwVar.zzg() ? zzafwVar.zzc() : zzafwVar.zzb();
        this.c = zzafwVar.zzb();
        G5.b bVar = null;
        if (!zzafwVar.zzh()) {
            this.a = 3;
            this.d = null;
            return;
        }
        String zzd = zzafwVar.zzd();
        zzd.hashCode();
        switch (zzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i = 6;
                break;
            case "PASSWORD_RESET":
                i = 0;
                break;
            case "VERIFY_EMAIL":
                i = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i = 4;
                break;
            case "RECOVER_EMAIL":
                i = 2;
                break;
            default:
                i = 3;
                break;
        }
        this.a = i;
        if (i == 4 || i == 3) {
            this.d = null;
            return;
        }
        if (zzafwVar.zzf()) {
            bVar = new Z(zzafwVar.zzb(), w.a(zzafwVar.zza()));
        } else if (zzafwVar.zzg()) {
            bVar = new X(zzafwVar.zzc(), zzafwVar.zzb());
        } else if (zzafwVar.zze()) {
            bVar = new a0(zzafwVar.zzb());
        }
        this.d = bVar;
    }

    public final int a() {
        return this.a;
    }
}
