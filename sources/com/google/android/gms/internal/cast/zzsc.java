package com.google.android.gms.internal.cast;

/* JADX WARN: Enum visitor error
LL1ili1iI1iI.IIiLliI1l1li1: Init of enum field 'zza' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(Unknown Source:111)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(Unknown Source:90)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(Unknown Source:51)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(Unknown Source:47)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(Unknown Source:135)
	at jadx.core.dex.visitors.EnumVisitor.visit(Unknown Source:6)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsc {
    public static final zzsc zzA;
    public static final zzsc zzB;
    public static final zzsc zzC;
    public static final zzsc zzD;
    public static final zzsc zzE;
    public static final zzsc zzF;
    public static final zzsc zzG;
    public static final zzsc zzH;
    public static final zzsc zzI;
    public static final zzsc zzJ;
    public static final zzsc zzK;
    public static final zzsc zzL;
    public static final zzsc zzM;
    public static final zzsc zzN;
    public static final zzsc zzO;
    public static final zzsc zzP;
    public static final zzsc zzQ;
    public static final zzsc zzR;
    public static final zzsc zzS;
    public static final zzsc zzT;
    public static final zzsc zzU;
    public static final zzsc zzV;
    public static final zzsc zzW;
    public static final zzsc zzX;
    public static final zzsc zzY;
    private static final zzsc[] zzZ;
    public static final zzsc zza;
    private static final /* synthetic */ zzsc[] zzaa;
    public static final zzsc zzb;
    public static final zzsc zzc;
    public static final zzsc zzd;
    public static final zzsc zze;
    public static final zzsc zzf;
    public static final zzsc zzg;
    public static final zzsc zzh;
    public static final zzsc zzi;
    public static final zzsc zzj;
    public static final zzsc zzk;
    public static final zzsc zzl;
    public static final zzsc zzm;
    public static final zzsc zzn;
    public static final zzsc zzo;
    public static final zzsc zzp;
    public static final zzsc zzq;
    public static final zzsc zzr;
    public static final zzsc zzs;
    public static final zzsc zzt;
    public static final zzsc zzu;
    public static final zzsc zzv;
    public static final zzsc zzw;
    public static final zzsc zzx;
    public static final zzsc zzy;
    public static final zzsc zzz;
    private final zzst zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzst zzstVar = zzst.zze;
        zzsc zzscVar = new zzsc("DOUBLE", 0, 0, 1, zzstVar);
        zza = zzscVar;
        zzst zzstVar2 = zzst.zzd;
        zzsc zzscVar2 = new zzsc("FLOAT", 1, 1, 1, zzstVar2);
        zzb = zzscVar2;
        zzst zzstVar3 = zzst.zzc;
        zzsc zzscVar3 = new zzsc("INT64", 2, 2, 1, zzstVar3);
        zzc = zzscVar3;
        zzsc zzscVar4 = new zzsc("UINT64", 3, 3, 1, zzstVar3);
        zzd = zzscVar4;
        zzst zzstVar4 = zzst.zzb;
        zzsc zzscVar5 = new zzsc("INT32", 4, 4, 1, zzstVar4);
        zze = zzscVar5;
        zzsc zzscVar6 = new zzsc("FIXED64", 5, 5, 1, zzstVar3);
        zzf = zzscVar6;
        zzsc zzscVar7 = new zzsc("FIXED32", 6, 6, 1, zzstVar4);
        zzg = zzscVar7;
        zzst zzstVar5 = zzst.zzf;
        zzsc zzscVar8 = new zzsc("BOOL", 7, 7, 1, zzstVar5);
        zzh = zzscVar8;
        zzst zzstVar6 = zzst.zzg;
        zzsc zzscVar9 = new zzsc("STRING", 8, 8, 1, zzstVar6);
        zzi = zzscVar9;
        zzst zzstVar7 = zzst.zzj;
        zzsc zzscVar10 = new zzsc("MESSAGE", 9, 9, 1, zzstVar7);
        zzj = zzscVar10;
        zzst zzstVar8 = zzst.zzh;
        zzsc zzscVar11 = new zzsc("BYTES", 10, 10, 1, zzstVar8);
        zzk = zzscVar11;
        zzsc zzscVar12 = new zzsc("UINT32", 11, 11, 1, zzstVar4);
        zzl = zzscVar12;
        zzst zzstVar9 = zzst.zzi;
        zzsc zzscVar13 = new zzsc("ENUM", 12, 12, 1, zzstVar9);
        zzm = zzscVar13;
        zzsc zzscVar14 = new zzsc("SFIXED32", 13, 13, 1, zzstVar4);
        zzn = zzscVar14;
        zzsc zzscVar15 = new zzsc("SFIXED64", 14, 14, 1, zzstVar3);
        zzo = zzscVar15;
        zzsc zzscVar16 = new zzsc("SINT32", 15, 15, 1, zzstVar4);
        zzp = zzscVar16;
        zzsc zzscVar17 = new zzsc("SINT64", 16, 16, 1, zzstVar3);
        zzq = zzscVar17;
        zzsc zzscVar18 = new zzsc("GROUP", 17, 17, 1, zzstVar7);
        zzr = zzscVar18;
        zzsc zzscVar19 = new zzsc("DOUBLE_LIST", 18, 18, 2, zzstVar);
        zzs = zzscVar19;
        zzsc zzscVar20 = new zzsc("FLOAT_LIST", 19, 19, 2, zzstVar2);
        zzt = zzscVar20;
        zzsc zzscVar21 = new zzsc("INT64_LIST", 20, 20, 2, zzstVar3);
        zzu = zzscVar21;
        zzsc zzscVar22 = new zzsc("UINT64_LIST", 21, 21, 2, zzstVar3);
        zzv = zzscVar22;
        zzsc zzscVar23 = new zzsc("INT32_LIST", 22, 22, 2, zzstVar4);
        zzw = zzscVar23;
        zzsc zzscVar24 = new zzsc("FIXED64_LIST", 23, 23, 2, zzstVar3);
        zzx = zzscVar24;
        zzsc zzscVar25 = new zzsc("FIXED32_LIST", 24, 24, 2, zzstVar4);
        zzy = zzscVar25;
        zzsc zzscVar26 = new zzsc("BOOL_LIST", 25, 25, 2, zzstVar5);
        zzz = zzscVar26;
        zzsc zzscVar27 = new zzsc("STRING_LIST", 26, 26, 2, zzstVar6);
        zzA = zzscVar27;
        zzsc zzscVar28 = new zzsc("MESSAGE_LIST", 27, 27, 2, zzstVar7);
        zzB = zzscVar28;
        zzsc zzscVar29 = new zzsc("BYTES_LIST", 28, 28, 2, zzstVar8);
        zzC = zzscVar29;
        zzsc zzscVar30 = new zzsc("UINT32_LIST", 29, 29, 2, zzstVar4);
        zzD = zzscVar30;
        zzsc zzscVar31 = new zzsc("ENUM_LIST", 30, 30, 2, zzstVar9);
        zzE = zzscVar31;
        zzsc zzscVar32 = new zzsc("SFIXED32_LIST", 31, 31, 2, zzstVar4);
        zzF = zzscVar32;
        zzsc zzscVar33 = new zzsc("SFIXED64_LIST", 32, 32, 2, zzstVar3);
        zzG = zzscVar33;
        zzsc zzscVar34 = new zzsc("SINT32_LIST", 33, 33, 2, zzstVar4);
        zzH = zzscVar34;
        zzsc zzscVar35 = new zzsc("SINT64_LIST", 34, 34, 2, zzstVar3);
        zzI = zzscVar35;
        zzsc zzscVar36 = new zzsc("DOUBLE_LIST_PACKED", 35, 35, 3, zzstVar);
        zzJ = zzscVar36;
        zzsc zzscVar37 = new zzsc("FLOAT_LIST_PACKED", 36, 36, 3, zzstVar2);
        zzK = zzscVar37;
        zzsc zzscVar38 = new zzsc("INT64_LIST_PACKED", 37, 37, 3, zzstVar3);
        zzL = zzscVar38;
        zzsc zzscVar39 = new zzsc("UINT64_LIST_PACKED", 38, 38, 3, zzstVar3);
        zzM = zzscVar39;
        zzsc zzscVar40 = new zzsc("INT32_LIST_PACKED", 39, 39, 3, zzstVar4);
        zzN = zzscVar40;
        zzsc zzscVar41 = new zzsc("FIXED64_LIST_PACKED", 40, 40, 3, zzstVar3);
        zzO = zzscVar41;
        zzsc zzscVar42 = new zzsc("FIXED32_LIST_PACKED", 41, 41, 3, zzstVar4);
        zzP = zzscVar42;
        zzsc zzscVar43 = new zzsc("BOOL_LIST_PACKED", 42, 42, 3, zzstVar5);
        zzQ = zzscVar43;
        zzsc zzscVar44 = new zzsc("UINT32_LIST_PACKED", 43, 43, 3, zzstVar4);
        zzR = zzscVar44;
        zzsc zzscVar45 = new zzsc("ENUM_LIST_PACKED", 44, 44, 3, zzstVar9);
        zzS = zzscVar45;
        zzsc zzscVar46 = new zzsc("SFIXED32_LIST_PACKED", 45, 45, 3, zzstVar4);
        zzT = zzscVar46;
        zzsc zzscVar47 = new zzsc("SFIXED64_LIST_PACKED", 46, 46, 3, zzstVar3);
        zzU = zzscVar47;
        zzsc zzscVar48 = new zzsc("SINT32_LIST_PACKED", 47, 47, 3, zzstVar4);
        zzV = zzscVar48;
        zzsc zzscVar49 = new zzsc("SINT64_LIST_PACKED", 48, 48, 3, zzstVar3);
        zzW = zzscVar49;
        zzsc zzscVar50 = new zzsc("GROUP_LIST", 49, 49, 2, zzstVar7);
        zzX = zzscVar50;
        zzsc zzscVar51 = new zzsc("MAP", 50, 50, 4, zzst.zza);
        zzY = zzscVar51;
        zzaa = new zzsc[]{zzscVar, zzscVar2, zzscVar3, zzscVar4, zzscVar5, zzscVar6, zzscVar7, zzscVar8, zzscVar9, zzscVar10, zzscVar11, zzscVar12, zzscVar13, zzscVar14, zzscVar15, zzscVar16, zzscVar17, zzscVar18, zzscVar19, zzscVar20, zzscVar21, zzscVar22, zzscVar23, zzscVar24, zzscVar25, zzscVar26, zzscVar27, zzscVar28, zzscVar29, zzscVar30, zzscVar31, zzscVar32, zzscVar33, zzscVar34, zzscVar35, zzscVar36, zzscVar37, zzscVar38, zzscVar39, zzscVar40, zzscVar41, zzscVar42, zzscVar43, zzscVar44, zzscVar45, zzscVar46, zzscVar47, zzscVar48, zzscVar49, zzscVar50, zzscVar51};
        zzsc[] values = values();
        zzZ = new zzsc[values.length];
        for (zzsc zzscVar52 : values) {
            zzZ[zzscVar52.zzac] = zzscVar52;
        }
    }

    private zzsc(String str, int i, int i2, int i3, zzst zzstVar) {
        this.zzac = i2;
        this.zzab = zzstVar;
        zzst zzstVar2 = zzst.zza;
        int i4 = i3 - 1;
        this.zzad = (i4 == 1 || i4 == 3) ? zzstVar.zza() : null;
        if (i3 == 1) {
            zzstVar.ordinal();
        }
    }

    public static zzsc[] values() {
        return (zzsc[]) zzaa.clone();
    }

    public final int zza() {
        return this.zzac;
    }
}
