package androidx.datastore.preferences.protobuf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class r0 {
    public static final int a = c(1, 3);
    public static final int b = c(1, 4);
    public static final int c = c(2, 0);
    public static final int d = c(3, 2);

    /* JADX WARN: Enum visitor error
    LL1ili1iI1iI.IIiLliI1l1li1: Init of enum field 'INT64' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(Unknown Source:111)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(Unknown Source:90)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(Unknown Source:51)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(Unknown Source:47)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(Unknown Source:135)
    	at jadx.core.dex.visitors.EnumVisitor.visit(Unknown Source:6)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class b {
        private static final /* synthetic */ b[] $VALUES;
        public static final b BOOL;
        public static final b BYTES;
        public static final b DOUBLE;
        public static final b ENUM;
        public static final b FIXED32;
        public static final b FIXED64;
        public static final b FLOAT;
        public static final b GROUP;
        public static final b INT32;
        public static final b INT64;
        public static final b MESSAGE;
        public static final b SFIXED32;
        public static final b SFIXED64;
        public static final b SINT32;
        public static final b SINT64;
        public static final b STRING;
        public static final b UINT32;
        public static final b UINT64;
        private final c javaType;
        private final int wireType;

        public enum a extends b {
            public a(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            public boolean isPackable() {
                return false;
            }
        }

        public enum b extends b {
            public b(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            public boolean isPackable() {
                return false;
            }
        }

        public enum c extends b {
            public c(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            public boolean isPackable() {
                return false;
            }
        }

        public enum d extends b {
            public d(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            public boolean isPackable() {
                return false;
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            DOUBLE = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            FLOAT = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            INT64 = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            UINT64 = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            INT32 = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            FIXED64 = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            FIXED32 = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            BOOL = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            STRING = aVar;
            c cVar3 = c.MESSAGE;
            b bVar9 = new b("GROUP", 9, cVar3, 3);
            GROUP = bVar9;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            MESSAGE = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            BYTES = dVar;
            b bVar10 = new b("UINT32", 12, cVar2, 0);
            UINT32 = bVar10;
            b bVar11 = new b("ENUM", 13, c.ENUM, 0);
            ENUM = bVar11;
            b bVar12 = new b("SFIXED32", 14, cVar2, 5);
            SFIXED32 = bVar12;
            b bVar13 = new b("SFIXED64", 15, cVar, 1);
            SFIXED64 = bVar13;
            b bVar14 = new b("SINT32", 16, cVar2, 0);
            SINT32 = bVar14;
            b bVar15 = new b("SINT64", 17, cVar, 0);
            SINT64 = bVar15;
            $VALUES = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, bVar9, cVar4, dVar, bVar10, bVar11, bVar12, bVar13, bVar14, bVar15};
        }

        private b(String str, int i, c cVar, int i2) {
            this.javaType = cVar;
            this.wireType = i2;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) $VALUES.clone();
        }

        public c getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        public /* synthetic */ b(String str, int i, c cVar, int i2, a aVar) {
            this(str, i, cVar, i2);
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(g.c),
        ENUM(null),
        MESSAGE(null);

        private final Object defaultDefault;

        c(Object obj) {
            this.defaultDefault = obj;
        }

        public Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    public static int a(int i) {
        return i >>> 3;
    }

    public static int b(int i) {
        return i & 7;
    }

    public static int c(int i, int i2) {
        return (i << 3) | i2;
    }
}
