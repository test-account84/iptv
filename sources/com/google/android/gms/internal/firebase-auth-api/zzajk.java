package com.google.android.gms.internal.firebase-auth-api;

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
public final class zzajk {
    public static final zzajk zza;
    public static final zzajk zzb;
    public static final zzajk zzc;
    public static final zzajk zzd;
    public static final zzajk zze;
    public static final zzajk zzf;
    public static final zzajk zzg;
    public static final zzajk zzh;
    public static final zzajk zzi;
    public static final zzajk zzj;
    private static final /* synthetic */ zzajk[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzajk zzajkVar = new zzajk("VOID", 0, Void.class, Void.class, null);
        zza = zzajkVar;
        Class cls = Integer.TYPE;
        zzajk zzajkVar2 = new zzajk("INT", 1, cls, Integer.class, 0);
        zzb = zzajkVar2;
        zzajk zzajkVar3 = new zzajk("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzajkVar3;
        zzajk zzajkVar4 = new zzajk("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzajkVar4;
        zzajk zzajkVar5 = new zzajk("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzajkVar5;
        zzajk zzajkVar6 = new zzajk("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzajkVar6;
        zzajk zzajkVar7 = new zzajk("STRING", 6, String.class, String.class, "");
        zzg = zzajkVar7;
        zzajk zzajkVar8 = new zzajk("BYTE_STRING", 7, zzahp.class, zzahp.class, zzahp.zza);
        zzh = zzajkVar8;
        zzajk zzajkVar9 = new zzajk("ENUM", 8, cls, Integer.class, null);
        zzi = zzajkVar9;
        zzajk zzajkVar10 = new zzajk("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzajkVar10;
        zzk = new zzajk[]{zzajkVar, zzajkVar2, zzajkVar3, zzajkVar4, zzajkVar5, zzajkVar6, zzajkVar7, zzajkVar8, zzajkVar9, zzajkVar10};
    }

    private zzajk(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzajk[] values() {
        return (zzajk[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
