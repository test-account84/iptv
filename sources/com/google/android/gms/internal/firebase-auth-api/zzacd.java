package com.google.android.gms.internal.firebase-auth-api;

import G5.F;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzacd {
    private final zzace zza;
    private final A4.a zzb;

    public zzacd(zzacd zzacdVar) {
        this(zzacdVar.zza, zzacdVar.zzb);
    }

    public final void zza() {
        try {
            this.zza.zza();
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public zzacd(zzace zzaceVar, A4.a aVar) {
        this.zza = (zzace) r.m(zzaceVar);
        this.zzb = (A4.a) r.m(aVar);
    }

    public final void zza(F f) {
        try {
            this.zza.zza(f);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending verification completed response.", e, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending send verification code response.", e, new Object[0]);
        }
    }

    public final void zzc(String str) {
        try {
            this.zza.zzc(str);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }

    public void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zza(Status status, F f) {
        try {
            this.zza.zza(status, f);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zza(zzaen zzaenVar) {
        try {
            this.zza.zza(zzaenVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zza(zzafj zzafjVar) {
        try {
            this.zza.zza(zzafjVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending Play Integrity Producer project response.", e, new Object[0]);
        }
    }

    public final void zza(zzafk zzafkVar) {
        try {
            this.zza.zza(zzafkVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending get recaptcha config response.", e, new Object[0]);
        }
    }

    public final void zza(zzafn zzafnVar) {
        try {
            this.zza.zza(zzafnVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zza(zzafn zzafnVar, zzafc zzafcVar) {
        try {
            this.zza.zza(zzafnVar, zzafcVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zza(zzafw zzafwVar) {
        try {
            this.zza.zza(zzafwVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zza(zzagb zzagbVar) {
        try {
            this.zza.zza(zzagbVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending revoke token response.", e, new Object[0]);
        }
    }

    public final void zza(zzagj zzagjVar) {
        try {
            this.zza.zza(zzagjVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending start mfa enrollment response.", e, new Object[0]);
        }
    }

    public final void zza(zzyh zzyhVar) {
        try {
            this.zza.zza(zzyhVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending failure result with credential", e, new Object[0]);
        }
    }

    public final void zza(zzyk zzykVar) {
        try {
            this.zza.zza(zzykVar);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending failure result for mfa", e, new Object[0]);
        }
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e) {
            this.zzb.b("RemoteException when sending auto retrieval timeout response.", e, new Object[0]);
        }
    }
}
