package com.google.android.gms.internal.firebase-auth-api;

import A5.f;
import G5.H;
import G5.g;
import G5.u;
import H5.s;
import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzacx implements zzadj {
    protected final int zza;
    private Object zzaa;
    private Status zzab;
    protected f zzc;
    protected u zzd;
    protected Object zze;
    protected s zzf;
    protected zzacv zzg;
    protected Executor zzi;
    protected zzafn zzj;
    protected zzafc zzk;
    protected zzaen zzl;
    protected zzafw zzm;
    protected String zzn;
    protected String zzo;
    protected g zzp;
    protected String zzq;
    protected String zzr;
    protected zzyk zzs;
    protected zzafk zzt;
    protected zzafj zzu;
    protected zzagj zzv;
    protected zzagb zzw;
    boolean zzx;
    private boolean zzz;
    protected final zzacz zzb = new zzacz(this);
    protected final List zzh = new ArrayList();
    private boolean zzy = true;

    public static class zza extends LifecycleCallback {
        private final List zza;

        private zza(j jVar, List list) {
            super(jVar);
            this.mLifecycleFragment.f("PhoneAuthActivityStopCallback", this);
            this.zza = list;
        }

        public static void zza(Activity activity, List list) {
            j fragment = LifecycleCallback.getFragment(activity);
            if (((zza) fragment.g("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        public void onStop() {
            synchronized (this.zza) {
                this.zza.clear();
            }
        }
    }

    public zzacx(int i) {
        this.zza = i;
    }

    public final zzacx zza(f fVar) {
        this.zzc = (f) r.n(fVar, "firebaseApp cannot be null");
        return this;
    }

    public abstract void zzb();

    public final void zzb(Object obj) {
        this.zzz = true;
        this.zzx = true;
        this.zzaa = obj;
        this.zzg.zza(obj, null);
    }

    public final zzacx zza(u uVar) {
        this.zzd = (u) r.n(uVar, "firebaseUser cannot be null");
        return this;
    }

    public final zzacx zza(H h, Activity activity, Executor executor, String str) {
        H zza2 = zzadt.zza(str, h, this);
        synchronized (this.zzh) {
            this.zzh.add((H) r.m(zza2));
        }
        if (activity != null) {
            zza.zza(activity, this.zzh);
        }
        this.zzi = (Executor) r.m(executor);
        return this;
    }

    public final zzacx zza(s sVar) {
        this.zzf = (s) r.n(sVar, "external failure callback cannot be null");
        return this;
    }

    public final zzacx zza(Object obj) {
        this.zze = r.n(obj, "external callback cannot be null");
        return this;
    }

    public final void zza(Status status) {
        this.zzz = true;
        this.zzx = false;
        this.zzab = status;
        this.zzg.zza(null, status);
    }

    public static /* synthetic */ void zza(zzacx zzacxVar) {
        zzacxVar.zzb();
        r.q(zzacxVar.zzz, "no success or failure set on method implementation");
    }

    public static /* synthetic */ void zza(zzacx zzacxVar, Status status) {
        s sVar = zzacxVar.zzf;
        if (sVar != null) {
            sVar.zza(status);
        }
    }

    public static /* bridge */ /* synthetic */ void zza(zzacx zzacxVar, boolean z) {
        zzacxVar.zzz = true;
    }
}
