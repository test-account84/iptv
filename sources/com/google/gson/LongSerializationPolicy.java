package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class LongSerializationPolicy {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES;
    public static final LongSerializationPolicy DEFAULT;
    public static final LongSerializationPolicy STRING;

    public enum 1 extends LongSerializationPolicy {
        public 1(String str, int i) {
            super(str, i, null);
        }

        public JsonElement serialize(Long l) {
            return l == null ? JsonNull.INSTANCE : new JsonPrimitive((Number) l);
        }
    }

    public enum 2 extends LongSerializationPolicy {
        public 2(String str, int i) {
            super(str, i, null);
        }

        public JsonElement serialize(Long l) {
            return l == null ? JsonNull.INSTANCE : new JsonPrimitive(l.toString());
        }
    }

    static {
        1 r0 = new 1("DEFAULT", 0);
        DEFAULT = r0;
        2 r1 = new 2("STRING", 1);
        STRING = r1;
        $VALUES = new LongSerializationPolicy[]{r0, r1};
    }

    private LongSerializationPolicy(String str, int i) {
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    public abstract JsonElement serialize(Long l);

    public /* synthetic */ LongSerializationPolicy(String str, int i, 1 r3) {
        this(str, i);
    }
}
