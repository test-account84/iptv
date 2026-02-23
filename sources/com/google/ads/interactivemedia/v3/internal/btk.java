package com.google.ads.interactivemedia.v3.internal;

/* JADX WARN: Enum visitor error
LL1ili1iI1iI.IIiLliI1l1li1: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(Unknown Source:111)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(Unknown Source:90)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(Unknown Source:51)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(Unknown Source:47)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(Unknown Source:135)
	at jadx.core.dex.visitors.EnumVisitor.visit(Unknown Source:6)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class btk {
    public static final btk a;
    public static final btk b;
    public static final btk c;
    public static final btk d;
    public static final btk e;
    public static final btk f;
    public static final btk g;
    public static final btk h;
    public static final btk i;
    public static final btk j;
    public static final btk k;
    public static final btk l;
    public static final btk m;
    public static final btk n;
    public static final btk o;
    public static final btk p;
    public static final btk q;
    public static final btk r;
    private static final /* synthetic */ btk[] s;
    private final btl t;
    private final int u;

    static {
        btk btkVar = new btk("DOUBLE", 0, btl.d, 1);
        a = btkVar;
        btk btkVar2 = new btk("FLOAT", 1, btl.c, 5);
        b = btkVar2;
        btl btlVar = btl.b;
        btk btkVar3 = new btk("INT64", 2, btlVar, 0);
        c = btkVar3;
        btk btkVar4 = new btk("UINT64", 3, btlVar, 0);
        d = btkVar4;
        btl btlVar2 = btl.a;
        btk btkVar5 = new btk("INT32", 4, btlVar2, 0);
        e = btkVar5;
        btk btkVar6 = new btk("FIXED64", 5, btlVar, 1);
        f = btkVar6;
        btk btkVar7 = new btk("FIXED32", 6, btlVar2, 5);
        g = btkVar7;
        btk btkVar8 = new btk("BOOL", 7, btl.e, 0);
        h = btkVar8;
        btk btkVar9 = new btk("STRING", 8, btl.f, 2);
        i = btkVar9;
        btl btlVar3 = btl.i;
        btk btkVar10 = new btk("GROUP", 9, btlVar3, 3);
        j = btkVar10;
        btk btkVar11 = new btk("MESSAGE", 10, btlVar3, 2);
        k = btkVar11;
        btk btkVar12 = new btk("BYTES", 11, btl.g, 2);
        l = btkVar12;
        btk btkVar13 = new btk("UINT32", 12, btlVar2, 0);
        m = btkVar13;
        btk btkVar14 = new btk("ENUM", 13, btl.h, 0);
        n = btkVar14;
        btk btkVar15 = new btk("SFIXED32", 14, btlVar2, 5);
        o = btkVar15;
        btk btkVar16 = new btk("SFIXED64", 15, btlVar, 1);
        p = btkVar16;
        btk btkVar17 = new btk("SINT32", 16, btlVar2, 0);
        q = btkVar17;
        btk btkVar18 = new btk("SINT64", 17, btlVar, 0);
        r = btkVar18;
        s = new btk[]{btkVar, btkVar2, btkVar3, btkVar4, btkVar5, btkVar6, btkVar7, btkVar8, btkVar9, btkVar10, btkVar11, btkVar12, btkVar13, btkVar14, btkVar15, btkVar16, btkVar17, btkVar18};
    }

    private btk(String str, int i2, btl btlVar, int i3) {
        this.t = btlVar;
        this.u = i3;
    }

    public static btk[] values() {
        return (btk[]) s.clone();
    }

    public final btl a() {
        return this.t;
    }
}
