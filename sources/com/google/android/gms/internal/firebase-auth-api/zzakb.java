package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzakb implements zzale {
    private static final zzakk zza = new zzaka();
    private final zzakk zzb;

    public zzakb() {
        this(new zzakc(zzaja.zza(), zza()));
    }

    private static zzakk zza() {
        try {
            return (zzakk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            return zza;
        }
    }

    private zzakb(zzakk zzakkVar) {
        this.zzb = (zzakk) zzajf.zza(zzakkVar, "messageInfoFactory");
    }

    public final zzalf zza(Class cls) {
        zzalh.zza(cls);
        zzakl zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzajc.class.isAssignableFrom(cls) ? zzakt.zza(zzalh.zzb(), zzais.zzb(), zza2.zza()) : zzakt.zza(zzalh.zza(), zzais.zza(), zza2.zza());
        }
        if (zzajc.class.isAssignableFrom(cls)) {
            boolean zza3 = zza(zza2);
            zzakv zzb = zzakx.zzb();
            zzajs zzb2 = zzajs.zzb();
            zzame zzb3 = zzalh.zzb();
            return zza3 ? zzakr.zza(cls, zza2, zzb, zzb2, zzb3, zzais.zzb(), zzaki.zzb()) : zzakr.zza(cls, zza2, zzb, zzb2, zzb3, (zzaiq) null, zzaki.zzb());
        }
        boolean zza4 = zza(zza2);
        zzakv zza5 = zzakx.zza();
        zzajs zza6 = zzajs.zza();
        zzame zza7 = zzalh.zza();
        return zza4 ? zzakr.zza(cls, zza2, zza5, zza6, zza7, zzais.zza(), zzaki.zza()) : zzakr.zza(cls, zza2, zza5, zza6, zza7, (zzaiq) null, zzaki.zza());
    }

    private static boolean zza(zzakl zzaklVar) {
        return zzakd.zza[zzaklVar.zzb().ordinal()] != 1;
    }
}
