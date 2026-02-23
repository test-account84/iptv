package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzma {
    private static final Object zza = new Object();
    private static final String zzb = "zzma";
    private final zzcd zzc;
    private final zzbg zzd;
    private zzcb zze;

    public static final class zza {
        private Context zza = null;
        private String zzb = null;
        private String zzc = null;
        private String zzd = null;
        private zzbg zze = null;
        private boolean zzf = true;
        private zzbu zzg = null;
        private zzvb zzh = null;
        private zzcb zzi;

        public static /* bridge */ /* synthetic */ Context zza(zza zzaVar) {
            return zzaVar.zza;
        }

        private final zzbg zzb() throws GeneralSecurityException {
            if (!zzma.zzd()) {
                Log.w(zzma.zzc(), "Android Keystore requires at least Android M");
                return null;
            }
            zzmd zzmdVar = new zzmd();
            try {
                boolean zzc = zzmd.zzc(this.zzd);
                try {
                    return zzmdVar.zza(this.zzd);
                } catch (ProviderException | GeneralSecurityException e) {
                    if (!zzc) {
                        throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.zzd}), e);
                    }
                    Log.w(zzma.zzc(), "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            } catch (ProviderException | GeneralSecurityException e2) {
                Log.w(zzma.zzc(), "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        public static /* bridge */ /* synthetic */ zzcb zzc(zza zzaVar) {
            return zzaVar.zzi;
        }

        public static /* bridge */ /* synthetic */ String zzd(zza zzaVar) {
            return zzaVar.zzb;
        }

        public static /* bridge */ /* synthetic */ String zze(zza zzaVar) {
            return zzaVar.zzc;
        }

        private static zzcb zza(byte[] bArr) throws GeneralSecurityException, IOException {
            return zzcb.zza(zzbl.zza(zzbj.zza(bArr)));
        }

        public static /* bridge */ /* synthetic */ zzbg zzb(zza zzaVar) {
            return zzaVar.zze;
        }

        private final zzcb zzb(byte[] bArr) throws GeneralSecurityException, IOException {
            try {
                this.zze = new zzmd().zza(this.zzd);
                try {
                    return zzcb.zza(zzbx.zza(zzbj.zza(bArr), this.zze));
                } catch (GeneralSecurityException | IOException e) {
                    try {
                        return zza(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (ProviderException | GeneralSecurityException e2) {
                try {
                    zzcb zza = zza(bArr);
                    Log.w(zzma.zzc(), "cannot use Android Keystore, it'll be disabled", e2);
                    return zza;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }

        public final zza zza(Context context, String str, String str2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            this.zza = context;
            this.zzb = str;
            this.zzc = str2;
            return this;
        }

        private static byte[] zzb(Context context, String str, String str2) throws IOException {
            if (str == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            Context applicationContext = context.getApplicationContext();
            try {
                String string = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).getString(str, (String) null);
                if (string == null) {
                    return null;
                }
                if (string.length() % 2 != 0) {
                    throw new IllegalArgumentException("Expected a string of even length");
                }
                int length = string.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    int digit = Character.digit(string.charAt(i2), 16);
                    int digit2 = Character.digit(string.charAt(i2 + 1), 16);
                    if (digit == -1 || digit2 == -1) {
                        throw new IllegalArgumentException("input is not hexadecimal");
                    }
                    bArr[i] = (byte) ((digit << 4) + digit2);
                }
                return bArr;
            } catch (ClassCastException | IllegalArgumentException unused) {
                throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{str}));
            }
        }

        public final zza zza(zzvb zzvbVar) {
            this.zzh = zzvbVar;
            return this;
        }

        public final zza zza(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.zzf) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.zzd = str;
            return this;
        }

        public final synchronized zzma zza() throws GeneralSecurityException, IOException {
            zzcb zza;
            zzma zzmaVar;
            try {
                if (this.zzb == null) {
                    throw new IllegalArgumentException("keysetName cannot be null");
                }
                zzvb zzvbVar = this.zzh;
                if (zzvbVar != null && this.zzg == null) {
                    this.zzg = zzbu.zza(zzcu.zza(zzvbVar.zzj()));
                }
                synchronized (zzma.zzb()) {
                    try {
                        byte[] zzb = zzb(this.zza, this.zzb, this.zzc);
                        if (zzb == null) {
                            if (this.zzd != null) {
                                this.zze = zzb();
                            }
                            if (this.zzg == null) {
                                throw new GeneralSecurityException("cannot read or generate keyset");
                            }
                            zzcb zza2 = zzcb.zzb().zza(this.zzg);
                            zza = zza2.zza(zza2.zza().zzc().zza(0).zza());
                            zzma.zza(zza.zza(), new zzmf(this.zza, this.zzb, this.zzc), this.zze);
                        } else {
                            zza = (this.zzd == null || !zzma.zzd()) ? zza(zzb) : zzb(zzb);
                        }
                        this.zzi = zza;
                        zzmaVar = new zzma(this, null);
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
            return zzmaVar;
        }
    }

    private zzma(zza zzaVar) {
        this.zzc = new zzmf(zza.zza(zzaVar), zza.zzd(zzaVar), zza.zze(zzaVar));
        this.zzd = zza.zzb(zzaVar);
        this.zze = zza.zzc(zzaVar);
    }

    public static /* bridge */ /* synthetic */ Object zzb() {
        return zza;
    }

    public static /* bridge */ /* synthetic */ String zzc() {
        return zzb;
    }

    public static /* synthetic */ boolean zzd() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public final synchronized zzbx zza() throws GeneralSecurityException {
        return this.zze.zza();
    }

    public /* synthetic */ zzma(zza zzaVar, zzmc zzmcVar) {
        this(zzaVar);
    }

    public static /* synthetic */ void zza(zzbx zzbxVar, zzcd zzcdVar, zzbg zzbgVar) {
        try {
            if (zzbgVar != null) {
                zzbxVar.zza(zzcdVar, zzbgVar);
            } else {
                zzbl.zza(zzbxVar, zzcdVar);
            }
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }
}
