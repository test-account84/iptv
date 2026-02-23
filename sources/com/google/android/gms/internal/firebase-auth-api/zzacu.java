package com.google.android.gms.internal.firebase-auth-api;

import A5.f;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzacu extends zzadi implements zzaef {
    private zzaco zza;
    private zzacn zzb;
    private zzadq zzc;
    private final zzacr zzd;
    private final f zze;
    private String zzf;
    private zzact zzg;

    public zzacu(f fVar, zzacr zzacrVar) {
        this(fVar, zzacrVar, null, null, null);
    }

    private final zzact zzb() {
        if (this.zzg == null) {
            this.zzg = new zzact(this.zze, this.zzd.zzb());
        }
        return this.zzg;
    }

    public final void zza() {
        zza(null, null, null);
    }

    private zzacu(f fVar, zzacr zzacrVar, zzadq zzadqVar, zzaco zzacoVar, zzacn zzacnVar) {
        this.zze = fVar;
        this.zzf = fVar.p().b();
        this.zzd = (zzacr) r.m(zzacrVar);
        zza(null, null, null);
        zzaed.zza(this.zzf, this);
    }

    private final void zza(zzadq zzadqVar, zzaco zzacoVar, zzacn zzacnVar) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        String zza = zzaea.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza)) {
            zza = zzaed.zzd(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + zza);
        }
        if (this.zzc == null) {
            this.zzc = new zzadq(zza, zzb());
        }
        String zza2 = zzaea.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzaed.zzb(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + zza2);
        }
        if (this.zza == null) {
            this.zza = new zzaco(zza2, zzb());
        }
        String zza3 = zzaea.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzaed.zzc(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + zza3);
        }
        if (this.zzb == null) {
            this.zzb = new zzacn(zza3, zzb());
        }
    }

    public final void zza(zzaek zzaekVar, zzadk zzadkVar) {
        r.m(zzaekVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/createAuthUri", this.zzf), zzaekVar, zzadkVar, zzaen.class, zzacoVar.zza);
    }

    public final void zza(zzaem zzaemVar, zzadk zzadkVar) {
        r.m(zzaemVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/deleteAccount", this.zzf), zzaemVar, zzadkVar, Void.class, zzacoVar.zza);
    }

    public final void zza(zzaep zzaepVar, zzadk zzadkVar) {
        r.m(zzaepVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/emailLinkSignin", this.zzf), zzaepVar, zzadkVar, zzaeo.class, zzacoVar.zza);
    }

    public final void zza(zzaer zzaerVar, zzadk zzadkVar) {
        r.m(zzaerVar);
        r.m(zzadkVar);
        zzacn zzacnVar = this.zzb;
        zzadn.zza(zzacnVar.zza("/accounts/mfaEnrollment:finalize", this.zzf), zzaerVar, zzadkVar, zzaeq.class, zzacnVar.zza);
    }

    public final void zza(zzaet zzaetVar, zzadk zzadkVar) {
        r.m(zzaetVar);
        r.m(zzadkVar);
        zzacn zzacnVar = this.zzb;
        zzadn.zza(zzacnVar.zza("/accounts/mfaSignIn:finalize", this.zzf), zzaetVar, zzadkVar, zzaes.class, zzacnVar.zza);
    }

    public final void zza(zzafa zzafaVar, zzadk zzadkVar) {
        r.m(zzafaVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/getAccountInfo", this.zzf), zzafaVar, zzadkVar, zzafd.class, zzacoVar.zza);
    }

    public final void zza(zzafb zzafbVar, zzadk zzadkVar) {
        r.m(zzafbVar);
        r.m(zzadkVar);
        zzadq zzadqVar = this.zzc;
        zzadn.zza(zzadqVar.zza("/token", this.zzf), zzafbVar, zzadkVar, zzafn.class, zzadqVar.zza);
    }

    public final void zza(zzafe zzafeVar, zzadk zzadkVar) {
        r.m(zzafeVar);
        r.m(zzadkVar);
        if (zzafeVar.zzb() != null) {
            zzb().zzb(zzafeVar.zzb().zze());
        }
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/getOobConfirmationCode", this.zzf), zzafeVar, zzadkVar, zzafh.class, zzacoVar.zza);
    }

    public final void zza(zzafg zzafgVar, zzadk zzadkVar) {
        r.m(zzafgVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/getRecaptchaParam", this.zzf), zzadkVar, zzafj.class, zzacoVar.zza);
    }

    public final void zza(zzafl zzaflVar, zzadk zzadkVar) {
        r.m(zzaflVar);
        r.m(zzadkVar);
        zzacn zzacnVar = this.zzb;
        zzadn.zza(zzacnVar.zza("/recaptchaConfig", this.zzf) + "&clientType=" + zzaflVar.zzb() + "&version=" + zzaflVar.zzc(), zzadkVar, zzafk.class, zzacnVar.zza);
    }

    public final void zza(zzafx zzafxVar, zzadk zzadkVar) {
        r.m(zzafxVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/resetPassword", this.zzf), zzafxVar, zzadkVar, zzafw.class, zzacoVar.zza);
    }

    public final void zza(zzafz zzafzVar, zzadk zzadkVar) {
        r.m(zzafzVar);
        r.m(zzadkVar);
        zzacn zzacnVar = this.zzb;
        zzadn.zza(zzacnVar.zza("/accounts:revokeToken", this.zzf), zzafzVar, zzadkVar, zzagb.class, zzacnVar.zza);
    }

    public final void zza(zzaga zzagaVar, zzadk zzadkVar) {
        r.m(zzagaVar);
        r.m(zzadkVar);
        if (!TextUtils.isEmpty(zzagaVar.zzc())) {
            zzb().zzb(zzagaVar.zzc());
        }
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/sendVerificationCode", this.zzf), zzagaVar, zzadkVar, zzagd.class, zzacoVar.zza);
    }

    public final void zza(zzagc zzagcVar, zzadk zzadkVar) {
        r.m(zzagcVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/setAccountInfo", this.zzf), zzagcVar, zzadkVar, zzagf.class, zzacoVar.zza);
    }

    public final void zza(zzage zzageVar, zzadk zzadkVar) {
        r.m(zzageVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/signupNewUser", this.zzf), zzageVar, zzadkVar, zzagh.class, zzacoVar.zza);
    }

    public final void zza(zzagg zzaggVar, zzadk zzadkVar) {
        r.m(zzaggVar);
        r.m(zzadkVar);
        if (zzaggVar instanceof zzagk) {
            zzagk zzagkVar = (zzagk) zzaggVar;
            if (!TextUtils.isEmpty(zzagkVar.zzb())) {
                zzb().zzb(zzagkVar.zzb());
            }
        }
        zzacn zzacnVar = this.zzb;
        zzadn.zza(zzacnVar.zza("/accounts/mfaEnrollment:start", this.zzf), zzaggVar, zzadkVar, zzagj.class, zzacnVar.zza);
    }

    public final void zza(zzagi zzagiVar, zzadk zzadkVar) {
        r.m(zzagiVar);
        r.m(zzadkVar);
        if (!TextUtils.isEmpty(zzagiVar.zzb())) {
            zzb().zzb(zzagiVar.zzb());
        }
        zzacn zzacnVar = this.zzb;
        zzadn.zza(zzacnVar.zza("/accounts/mfaSignIn:start", this.zzf), zzagiVar, zzadkVar, zzagl.class, zzacnVar.zza);
    }

    public final void zza(zzagt zzagtVar, zzadk zzadkVar) {
        r.m(zzagtVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/verifyAssertion", this.zzf), zzagtVar, zzadkVar, zzagv.class, zzacoVar.zza);
    }

    public final void zza(zzagu zzaguVar, zzadk zzadkVar) {
        r.m(zzaguVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/verifyCustomToken", this.zzf), zzaguVar, zzadkVar, zzagx.class, zzacoVar.zza);
    }

    public final void zza(zzagw zzagwVar, zzadk zzadkVar) {
        r.m(zzagwVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/verifyPassword", this.zzf), zzagwVar, zzadkVar, zzagz.class, zzacoVar.zza);
    }

    public final void zza(zzagy zzagyVar, zzadk zzadkVar) {
        r.m(zzagyVar);
        r.m(zzadkVar);
        zzaco zzacoVar = this.zza;
        zzadn.zza(zzacoVar.zza("/verifyPhoneNumber", this.zzf), zzagyVar, zzadkVar, zzahb.class, zzacoVar.zza);
    }

    public final void zza(zzaha zzahaVar, zzadk zzadkVar) {
        r.m(zzahaVar);
        r.m(zzadkVar);
        zzacn zzacnVar = this.zzb;
        zzadn.zza(zzacnVar.zza("/accounts/mfaEnrollment:withdraw", this.zzf), zzahaVar, zzadkVar, zzahd.class, zzacnVar.zza);
    }

    public final void zza(String str, zzadk zzadkVar) {
        r.m(zzadkVar);
        zzb().zza(str);
        zzadkVar.zza((Object) null);
    }
}
