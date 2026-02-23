package com.google.android.gms.internal.firebase-auth-api;

/* JADX WARN: Enum visitor error
LL1ili1iI1iI.IIiLliI1l1li1: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(Unknown Source:111)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(Unknown Source:90)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(Unknown Source:51)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(Unknown Source:47)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(Unknown Source:135)
	at jadx.core.dex.visitors.EnumVisitor.visit(Unknown Source:6)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzamr {
    public static final zzamr zza;
    public static final zzamr zzb;
    public static final zzamr zzc;
    public static final zzamr zzd;
    public static final zzamr zze;
    public static final zzamr zzf;
    public static final zzamr zzg;
    public static final zzamr zzh;
    public static final zzamr zzi;
    public static final zzamr zzj;
    public static final zzamr zzk;
    public static final zzamr zzl;
    public static final zzamr zzm;
    public static final zzamr zzn;
    public static final zzamr zzo;
    public static final zzamr zzp;
    public static final zzamr zzq;
    public static final zzamr zzr;
    private static final /* synthetic */ zzamr[] zzs;
    private final zzanb zzt;
    private final int zzu;

    static {
        zzamr zzamrVar = new zzamr("DOUBLE", 0, zzanb.zzd, 1);
        zza = zzamrVar;
        zzamr zzamrVar2 = new zzamr("FLOAT", 1, zzanb.zzc, 5);
        zzb = zzamrVar2;
        zzanb zzanbVar = zzanb.zzb;
        zzamr zzamrVar3 = new zzamr("INT64", 2, zzanbVar, 0);
        zzc = zzamrVar3;
        zzamr zzamrVar4 = new zzamr("UINT64", 3, zzanbVar, 0);
        zzd = zzamrVar4;
        zzanb zzanbVar2 = zzanb.zza;
        zzamr zzamrVar5 = new zzamr("INT32", 4, zzanbVar2, 0);
        zze = zzamrVar5;
        zzamr zzamrVar6 = new zzamr("FIXED64", 5, zzanbVar, 1);
        zzf = zzamrVar6;
        zzamr zzamrVar7 = new zzamr("FIXED32", 6, zzanbVar2, 5);
        zzg = zzamrVar7;
        zzamr zzamrVar8 = new zzamr("BOOL", 7, zzanb.zze, 0);
        zzh = zzamrVar8;
        zzamq zzamqVar = new zzamq("STRING", 8, zzanb.zzf, 2, null);
        zzi = zzamqVar;
        zzanb zzanbVar3 = zzanb.zzi;
        zzams zzamsVar = new zzams("GROUP", 9, zzanbVar3, 3, null);
        zzj = zzamsVar;
        zzamu zzamuVar = new zzamu("MESSAGE", 10, zzanbVar3, 2, null);
        zzk = zzamuVar;
        zzamw zzamwVar = new zzamw("BYTES", 11, zzanb.zzg, 2, null);
        zzl = zzamwVar;
        zzamr zzamrVar9 = new zzamr("UINT32", 12, zzanbVar2, 0);
        zzm = zzamrVar9;
        zzamr zzamrVar10 = new zzamr("ENUM", 13, zzanb.zzh, 0);
        zzn = zzamrVar10;
        zzamr zzamrVar11 = new zzamr("SFIXED32", 14, zzanbVar2, 5);
        zzo = zzamrVar11;
        zzamr zzamrVar12 = new zzamr("SFIXED64", 15, zzanbVar, 1);
        zzp = zzamrVar12;
        zzamr zzamrVar13 = new zzamr("SINT32", 16, zzanbVar2, 0);
        zzq = zzamrVar13;
        zzamr zzamrVar14 = new zzamr("SINT64", 17, zzanbVar, 0);
        zzr = zzamrVar14;
        zzs = new zzamr[]{zzamrVar, zzamrVar2, zzamrVar3, zzamrVar4, zzamrVar5, zzamrVar6, zzamrVar7, zzamrVar8, zzamqVar, zzamsVar, zzamuVar, zzamwVar, zzamrVar9, zzamrVar10, zzamrVar11, zzamrVar12, zzamrVar13, zzamrVar14};
    }

    private zzamr(String str, int i, zzanb zzanbVar, int i2) {
        this.zzt = zzanbVar;
        this.zzu = i2;
    }

    public static zzamr[] values() {
        return (zzamr[]) zzs.clone();
    }

    public final int zza() {
        return this.zzu;
    }

    public final zzanb zzb() {
        return this.zzt;
    }

    public /* synthetic */ zzamr(String str, int i, zzanb zzanbVar, int i2, zzamy zzamyVar) {
        this(str, i, zzanbVar, i2);
    }
}
