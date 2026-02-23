package com.google.android.gms.flags.impl;

import H4.b;
import I4.a;
import I4.c;
import I4.d;
import I4.f;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.flags.zzd;

@DynamiteApi
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FlagProviderImpl extends b {
    public boolean a = false;
    public SharedPreferences c;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        if (!this.a) {
            return z;
        }
        SharedPreferences sharedPreferences = this.c;
        Boolean valueOf = Boolean.valueOf(z);
        try {
            valueOf = (Boolean) zzd.zza(new a(sharedPreferences, str, valueOf));
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", valueOf2.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf2) : new String("Flag value not available, returning default: "));
        }
        return valueOf.booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        if (!this.a) {
            return i;
        }
        SharedPreferences sharedPreferences = this.c;
        Integer valueOf = Integer.valueOf(i);
        try {
            valueOf = (Integer) zzd.zza(new I4.b(sharedPreferences, str, valueOf));
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", valueOf2.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf2) : new String("Flag value not available, returning default: "));
        }
        return valueOf.intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        if (!this.a) {
            return j;
        }
        SharedPreferences sharedPreferences = this.c;
        Long valueOf = Long.valueOf(j);
        try {
            valueOf = (Long) zzd.zza(new c(sharedPreferences, str, valueOf));
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", valueOf2.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf2) : new String("Flag value not available, returning default: "));
        }
        return valueOf.longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        if (!this.a) {
            return str2;
        }
        try {
            return (String) zzd.zza(new d(this.c, str, str2));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }

    public void init(F4.a aVar) {
        Context context = (Context) F4.b.E(aVar);
        if (this.a) {
            return;
        }
        try {
            this.c = f.a(context.createPackageContext("com.google.android.gms", 0));
            this.a = true;
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FlagProviderImpl", valueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
