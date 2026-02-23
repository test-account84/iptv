package com.google.ads.interactivemedia.v3.internal;

/* JADX WARN: Enum visitor error
LL1ili1iI1iI.IIiLliI1l1li1: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(Unknown Source:111)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(Unknown Source:90)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(Unknown Source:51)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(Unknown Source:47)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(Unknown Source:135)
	at jadx.core.dex.visitors.EnumVisitor.visit(Unknown Source:6)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bqg {
    public static final bqg A;
    public static final bqg B;
    public static final bqg C;
    public static final bqg D;
    public static final bqg E;
    public static final bqg F;
    public static final bqg G;
    public static final bqg H;
    public static final bqg I;
    public static final bqg J;
    public static final bqg K;
    public static final bqg L;
    public static final bqg M;
    public static final bqg N;
    public static final bqg O;
    public static final bqg P;
    public static final bqg Q;
    public static final bqg R;
    public static final bqg S;
    public static final bqg T;
    public static final bqg U;
    public static final bqg V;
    public static final bqg W;
    public static final bqg X;
    public static final bqg Y;
    private static final bqg[] Z;
    public static final bqg a;
    private static final /* synthetic */ bqg[] aa;
    public static final bqg b;
    public static final bqg c;
    public static final bqg d;
    public static final bqg e;
    public static final bqg f;
    public static final bqg g;
    public static final bqg h;
    public static final bqg i;
    public static final bqg j;
    public static final bqg k;
    public static final bqg l;
    public static final bqg m;
    public static final bqg n;
    public static final bqg o;
    public static final bqg p;
    public static final bqg q;
    public static final bqg r;
    public static final bqg s;
    public static final bqg t;
    public static final bqg u;
    public static final bqg v;
    public static final bqg w;
    public static final bqg x;
    public static final bqg y;
    public static final bqg z;
    private final int ab;
    private final bqf ac;

    static {
        bqf bqfVar = bqf.SCALAR;
        bqy bqyVar = bqy.e;
        bqg bqgVar = new bqg("DOUBLE", 0, 0, bqfVar, bqyVar);
        a = bqgVar;
        bqy bqyVar2 = bqy.d;
        bqg bqgVar2 = new bqg("FLOAT", 1, 1, bqfVar, bqyVar2);
        b = bqgVar2;
        bqy bqyVar3 = bqy.c;
        bqg bqgVar3 = new bqg("INT64", 2, 2, bqfVar, bqyVar3);
        c = bqgVar3;
        bqg bqgVar4 = new bqg("UINT64", 3, 3, bqfVar, bqyVar3);
        d = bqgVar4;
        bqy bqyVar4 = bqy.b;
        bqg bqgVar5 = new bqg("INT32", 4, 4, bqfVar, bqyVar4);
        e = bqgVar5;
        bqg bqgVar6 = new bqg("FIXED64", 5, 5, bqfVar, bqyVar3);
        f = bqgVar6;
        bqg bqgVar7 = new bqg("FIXED32", 6, 6, bqfVar, bqyVar4);
        g = bqgVar7;
        bqy bqyVar5 = bqy.f;
        bqg bqgVar8 = new bqg("BOOL", 7, 7, bqfVar, bqyVar5);
        h = bqgVar8;
        bqy bqyVar6 = bqy.g;
        bqg bqgVar9 = new bqg("STRING", 8, 8, bqfVar, bqyVar6);
        i = bqgVar9;
        bqy bqyVar7 = bqy.j;
        bqg bqgVar10 = new bqg("MESSAGE", 9, 9, bqfVar, bqyVar7);
        j = bqgVar10;
        bqy bqyVar8 = bqy.h;
        bqg bqgVar11 = new bqg("BYTES", 10, 10, bqfVar, bqyVar8);
        k = bqgVar11;
        bqg bqgVar12 = new bqg("UINT32", 11, 11, bqfVar, bqyVar4);
        l = bqgVar12;
        bqy bqyVar9 = bqy.i;
        bqg bqgVar13 = new bqg("ENUM", 12, 12, bqfVar, bqyVar9);
        m = bqgVar13;
        bqg bqgVar14 = new bqg("SFIXED32", 13, 13, bqfVar, bqyVar4);
        n = bqgVar14;
        bqg bqgVar15 = new bqg("SFIXED64", 14, 14, bqfVar, bqyVar3);
        o = bqgVar15;
        bqg bqgVar16 = new bqg("SINT32", 15, 15, bqfVar, bqyVar4);
        p = bqgVar16;
        bqg bqgVar17 = new bqg("SINT64", 16, 16, bqfVar, bqyVar3);
        q = bqgVar17;
        bqg bqgVar18 = new bqg("GROUP", 17, 17, bqfVar, bqyVar7);
        r = bqgVar18;
        bqf bqfVar2 = bqf.VECTOR;
        bqg bqgVar19 = new bqg("DOUBLE_LIST", 18, 18, bqfVar2, bqyVar);
        s = bqgVar19;
        bqg bqgVar20 = new bqg("FLOAT_LIST", 19, 19, bqfVar2, bqyVar2);
        t = bqgVar20;
        bqg bqgVar21 = new bqg("INT64_LIST", 20, 20, bqfVar2, bqyVar3);
        u = bqgVar21;
        bqg bqgVar22 = new bqg("UINT64_LIST", 21, 21, bqfVar2, bqyVar3);
        v = bqgVar22;
        bqg bqgVar23 = new bqg("INT32_LIST", 22, 22, bqfVar2, bqyVar4);
        w = bqgVar23;
        bqg bqgVar24 = new bqg("FIXED64_LIST", 23, 23, bqfVar2, bqyVar3);
        x = bqgVar24;
        bqg bqgVar25 = new bqg("FIXED32_LIST", 24, 24, bqfVar2, bqyVar4);
        y = bqgVar25;
        bqg bqgVar26 = new bqg("BOOL_LIST", 25, 25, bqfVar2, bqyVar5);
        z = bqgVar26;
        bqg bqgVar27 = new bqg("STRING_LIST", 26, 26, bqfVar2, bqyVar6);
        A = bqgVar27;
        bqg bqgVar28 = new bqg("MESSAGE_LIST", 27, 27, bqfVar2, bqyVar7);
        B = bqgVar28;
        bqg bqgVar29 = new bqg("BYTES_LIST", 28, 28, bqfVar2, bqyVar8);
        C = bqgVar29;
        bqg bqgVar30 = new bqg("UINT32_LIST", 29, 29, bqfVar2, bqyVar4);
        D = bqgVar30;
        bqg bqgVar31 = new bqg("ENUM_LIST", 30, 30, bqfVar2, bqyVar9);
        E = bqgVar31;
        bqg bqgVar32 = new bqg("SFIXED32_LIST", 31, 31, bqfVar2, bqyVar4);
        F = bqgVar32;
        bqg bqgVar33 = new bqg("SFIXED64_LIST", 32, 32, bqfVar2, bqyVar3);
        G = bqgVar33;
        bqg bqgVar34 = new bqg("SINT32_LIST", 33, 33, bqfVar2, bqyVar4);
        H = bqgVar34;
        bqg bqgVar35 = new bqg("SINT64_LIST", 34, 34, bqfVar2, bqyVar3);
        I = bqgVar35;
        bqf bqfVar3 = bqf.PACKED_VECTOR;
        bqg bqgVar36 = new bqg("DOUBLE_LIST_PACKED", 35, 35, bqfVar3, bqyVar);
        J = bqgVar36;
        bqg bqgVar37 = new bqg("FLOAT_LIST_PACKED", 36, 36, bqfVar3, bqyVar2);
        K = bqgVar37;
        bqg bqgVar38 = new bqg("INT64_LIST_PACKED", 37, 37, bqfVar3, bqyVar3);
        L = bqgVar38;
        bqg bqgVar39 = new bqg("UINT64_LIST_PACKED", 38, 38, bqfVar3, bqyVar3);
        M = bqgVar39;
        bqg bqgVar40 = new bqg("INT32_LIST_PACKED", 39, 39, bqfVar3, bqyVar4);
        N = bqgVar40;
        bqg bqgVar41 = new bqg("FIXED64_LIST_PACKED", 40, 40, bqfVar3, bqyVar3);
        O = bqgVar41;
        bqg bqgVar42 = new bqg("FIXED32_LIST_PACKED", 41, 41, bqfVar3, bqyVar4);
        P = bqgVar42;
        bqg bqgVar43 = new bqg("BOOL_LIST_PACKED", 42, 42, bqfVar3, bqyVar5);
        Q = bqgVar43;
        bqg bqgVar44 = new bqg("UINT32_LIST_PACKED", 43, 43, bqfVar3, bqyVar4);
        R = bqgVar44;
        bqg bqgVar45 = new bqg("ENUM_LIST_PACKED", 44, 44, bqfVar3, bqyVar9);
        S = bqgVar45;
        bqg bqgVar46 = new bqg("SFIXED32_LIST_PACKED", 45, 45, bqfVar3, bqyVar4);
        T = bqgVar46;
        bqg bqgVar47 = new bqg("SFIXED64_LIST_PACKED", 46, 46, bqfVar3, bqyVar3);
        U = bqgVar47;
        bqg bqgVar48 = new bqg("SINT32_LIST_PACKED", 47, 47, bqfVar3, bqyVar4);
        V = bqgVar48;
        bqg bqgVar49 = new bqg("SINT64_LIST_PACKED", 48, 48, bqfVar3, bqyVar3);
        W = bqgVar49;
        bqg bqgVar50 = new bqg("GROUP_LIST", 49, 49, bqfVar2, bqyVar7);
        X = bqgVar50;
        bqg bqgVar51 = new bqg("MAP", 50, 50, bqf.MAP, bqy.a);
        Y = bqgVar51;
        aa = new bqg[]{bqgVar, bqgVar2, bqgVar3, bqgVar4, bqgVar5, bqgVar6, bqgVar7, bqgVar8, bqgVar9, bqgVar10, bqgVar11, bqgVar12, bqgVar13, bqgVar14, bqgVar15, bqgVar16, bqgVar17, bqgVar18, bqgVar19, bqgVar20, bqgVar21, bqgVar22, bqgVar23, bqgVar24, bqgVar25, bqgVar26, bqgVar27, bqgVar28, bqgVar29, bqgVar30, bqgVar31, bqgVar32, bqgVar33, bqgVar34, bqgVar35, bqgVar36, bqgVar37, bqgVar38, bqgVar39, bqgVar40, bqgVar41, bqgVar42, bqgVar43, bqgVar44, bqgVar45, bqgVar46, bqgVar47, bqgVar48, bqgVar49, bqgVar50, bqgVar51};
        bqg[] values = values();
        Z = new bqg[values.length];
        for (bqg bqgVar52 : values) {
            Z[bqgVar52.ab] = bqgVar52;
        }
    }

    private bqg(String str, int i2, int i3, bqf bqfVar, bqy bqyVar) {
        this.ab = i3;
        this.ac = bqfVar;
        bqy bqyVar2 = bqy.a;
        bqf bqfVar2 = bqf.SCALAR;
        int ordinal = bqfVar.ordinal();
        if (ordinal == 1 || ordinal == 3) {
            bqyVar.a();
        }
        if (bqfVar == bqf.SCALAR) {
            bqyVar.ordinal();
        }
    }

    public static bqg[] values() {
        return (bqg[]) aa.clone();
    }

    public final int a() {
        return this.ab;
    }
}
