package com.google.android.gms.internal.firebase-auth-api;

import android.os.Build;
import android.util.Log;
import com.amazonaws.internal.keyvaluestore.c;
import com.amazonaws.internal.keyvaluestore.e;
import com.amazonaws.internal.keyvaluestore.f;
import com.amazonaws.internal.keyvaluestore.g;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmd implements zzcc {
    private static final Object zza = new Object();
    private static final String zzb = "zzmd";
    private final String zzc;
    private KeyStore zzd;

    public static final class zza {
        KeyStore zza;
        private String zzb = null;

        public zza() {
            this.zza = null;
            if (!zzmd.zza()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zza = keyStore;
                keyStore.load((KeyStore.LoadStoreParameter) null);
            } catch (IOException | GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public zzmd() throws GeneralSecurityException {
        this(new zza());
    }

    public static boolean zzc(String str) throws GeneralSecurityException {
        zzmd zzmdVar = new zzmd();
        synchronized (zza) {
            try {
                if (zzmdVar.zzd(str)) {
                    return false;
                }
                String zza2 = zzxo.zza("android-keystore://", str);
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                g.a();
                keyGenerator.init(e.a(com.amazonaws.internal.keyvaluestore.b.a(com.amazonaws.internal.keyvaluestore.a.a(c.a(f.a(zza2, 3), 256), new String[]{"GCM"}), new String[]{"NoPadding"})));
                keyGenerator.generateKey();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final synchronized boolean zzd(String str) throws GeneralSecurityException {
        String zza2;
        zza2 = zzxo.zza("android-keystore://", str);
        try {
        } catch (NullPointerException unused) {
            Log.w(zzb, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            try {
                try {
                    Thread.sleep((int) (Math.random() * 40.0d));
                } catch (InterruptedException unused2) {
                }
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zzd = keyStore;
                keyStore.load((KeyStore.LoadStoreParameter) null);
                return this.zzd.containsAlias(zza2);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            }
        }
        return this.zzd.containsAlias(zza2);
    }

    public final synchronized zzbg zza(String str) throws GeneralSecurityException {
        zzmb zzmbVar;
        zzmbVar = new zzmb(zzxo.zza("android-keystore://", str), this.zzd);
        byte[] zza2 = zzou.zza(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(zza2, zzmbVar.zza(zzmbVar.zzb(zza2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzmbVar;
    }

    public final synchronized boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    private zzmd(zza zzaVar) {
        this.zzc = null;
        this.zzd = zzaVar.zza;
    }

    public static /* synthetic */ boolean zza() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
