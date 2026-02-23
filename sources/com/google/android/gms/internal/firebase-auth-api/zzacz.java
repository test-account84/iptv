package com.google.android.gms.internal.firebase-auth-api;

import G5.F;
import G5.g;
import H5.m;
import H5.s;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzacz implements zzace {
    final /* synthetic */ zzacx zza;

    public zzacz(zzacx zzacxVar) {
        this.zza = zzacxVar;
    }

    public final void zza() throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 5, "Unexpected response type " + i);
        zzacx.zza(this.zza);
    }

    public final void zzb() throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 6, "Unexpected response type " + i);
        zzacx.zza(this.zza);
    }

    public final void zzc() throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 9, "Unexpected response type " + i);
        zzacx.zza(this.zza);
    }

    public final void zza(F f) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 8, "Unexpected response type " + i);
        zzacx.zza(this.zza, true);
        this.zza.zzx = true;
        zza(new zzadb(this, f));
    }

    public final void zzb(String str) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 8, "Unexpected response type " + i);
        this.zza.zzo = str;
        zza(new zzacy(this, str));
    }

    public final void zzc(String str) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 7, "Unexpected response type " + i);
        zzacx zzacxVar = this.zza;
        zzacxVar.zzn = str;
        zzacx.zza(zzacxVar);
    }

    public final void zza(Status status) throws RemoteException {
        String J = status.J();
        if (J != null) {
            if (J.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (J.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (J.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (J.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (J.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (J.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (J.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (J.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (J.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (J.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzacx zzacxVar = this.zza;
        if (zzacxVar.zza != 8) {
            zzacx.zza(zzacxVar, status);
            this.zza.zza(status);
        } else {
            zzacx.zza(zzacxVar, true);
            this.zza.zzx = false;
            zza(new zzadd(this, status));
        }
    }

    private final void zza(Status status, g gVar, String str, String str2) {
        zzacx.zza(this.zza, status);
        zzacx zzacxVar = this.zza;
        zzacxVar.zzp = gVar;
        zzacxVar.zzq = str;
        zzacxVar.zzr = str2;
        s sVar = zzacxVar.zzf;
        if (sVar != null) {
            sVar.zza(status);
        }
        this.zza.zza(status);
    }

    public final void zza(Status status, F f) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 2, "Unexpected response type " + i);
        zza(status, f, null, null);
    }

    private final void zza(zzadf zzadfVar) {
        this.zza.zzi.execute(new zzadc(this, zzadfVar));
    }

    public final void zza(zzaen zzaenVar) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 3, "Unexpected response type " + i);
        zzacx zzacxVar = this.zza;
        zzacxVar.zzl = zzaenVar;
        zzacx.zza(zzacxVar);
    }

    public final void zza(zzafj zzafjVar) throws RemoteException {
        zzacx zzacxVar = this.zza;
        zzacxVar.zzu = zzafjVar;
        zzacx.zza(zzacxVar);
    }

    public final void zza(zzafk zzafkVar) throws RemoteException {
        zzacx zzacxVar = this.zza;
        zzacxVar.zzt = zzafkVar;
        zzacx.zza(zzacxVar);
    }

    public final void zza(zzafn zzafnVar) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 1, "Unexpected response type: " + i);
        zzacx zzacxVar = this.zza;
        zzacxVar.zzj = zzafnVar;
        zzacx.zza(zzacxVar);
    }

    public final void zza(zzafn zzafnVar, zzafc zzafcVar) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 2, "Unexpected response type: " + i);
        zzacx zzacxVar = this.zza;
        zzacxVar.zzj = zzafnVar;
        zzacxVar.zzk = zzafcVar;
        zzacx.zza(zzacxVar);
    }

    public final void zza(zzafw zzafwVar) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 4, "Unexpected response type " + i);
        zzacx zzacxVar = this.zza;
        zzacxVar.zzm = zzafwVar;
        zzacx.zza(zzacxVar);
    }

    public final void zza(zzagb zzagbVar) throws RemoteException {
        zzacx zzacxVar = this.zza;
        zzacxVar.zzw = zzagbVar;
        zzacx.zza(zzacxVar);
    }

    public final void zza(zzagj zzagjVar) throws RemoteException {
        zzacx zzacxVar = this.zza;
        zzacxVar.zzv = zzagjVar;
        zzacx.zza(zzacxVar);
    }

    public final void zza(zzyh zzyhVar) {
        zza(zzyhVar.zza(), zzyhVar.zzb(), zzyhVar.zzc(), zzyhVar.zzd());
    }

    public final void zza(zzyk zzykVar) {
        zzacx zzacxVar = this.zza;
        zzacxVar.zzs = zzykVar;
        zzacxVar.zza(m.a("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    public final void zza(String str) throws RemoteException {
        int i = this.zza.zza;
        r.q(i == 8, "Unexpected response type " + i);
        zzacx zzacxVar = this.zza;
        zzacxVar.zzo = str;
        zzacx.zza(zzacxVar, true);
        this.zza.zzx = true;
        zza(new zzada(this, str));
    }
}
