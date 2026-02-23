package com.google.android.recaptcha.internal;

/* JADX WARN: Enum visitor error
LL1ili1iI1iI.IIiLliI1l1li1: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(Unknown Source:111)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(Unknown Source:90)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(Unknown Source:51)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(Unknown Source:47)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(Unknown Source:135)
	at jadx.core.dex.visitors.EnumVisitor.visit(Unknown Source:6)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzgz {
    public static final zzgz zza;
    public static final zzgz zzb;
    public static final zzgz zzc;
    public static final zzgz zzd;
    public static final zzgz zze;
    public static final zzgz zzf;
    public static final zzgz zzg;
    public static final zzgz zzh;
    public static final zzgz zzi;
    public static final zzgz zzj;
    private static final /* synthetic */ zzgz[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzgz zzgzVar = new zzgz("VOID", 0, Void.class, Void.class, null);
        zza = zzgzVar;
        Class cls = Integer.TYPE;
        zzgz zzgzVar2 = new zzgz("INT", 1, cls, Integer.class, 0);
        zzb = zzgzVar2;
        zzgz zzgzVar3 = new zzgz("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzgzVar3;
        zzgz zzgzVar4 = new zzgz("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzgzVar4;
        zzgz zzgzVar5 = new zzgz("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzgzVar5;
        zzgz zzgzVar6 = new zzgz("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzgzVar6;
        zzgz zzgzVar7 = new zzgz("STRING", 6, String.class, String.class, "");
        zzg = zzgzVar7;
        zzgz zzgzVar8 = new zzgz("BYTE_STRING", 7, zzez.class, zzez.class, zzez.zzb);
        zzh = zzgzVar8;
        zzgz zzgzVar9 = new zzgz("ENUM", 8, cls, Integer.class, null);
        zzi = zzgzVar9;
        zzgz zzgzVar10 = new zzgz("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzgzVar10;
        zzk = new zzgz[]{zzgzVar, zzgzVar2, zzgzVar3, zzgzVar4, zzgzVar5, zzgzVar6, zzgzVar7, zzgzVar8, zzgzVar9, zzgzVar10};
    }

    private zzgz(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzgz[] values() {
        return (zzgz[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
