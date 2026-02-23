package com.amazonaws.util;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class EncodingSchemeEnum implements EncodingScheme {
    private static final /* synthetic */ EncodingSchemeEnum[] $VALUES;
    public static final EncodingSchemeEnum BASE16;
    public static final EncodingSchemeEnum BASE32;
    public static final EncodingSchemeEnum BASE64;

    public enum 1 extends EncodingSchemeEnum {
        public 1(String str, int i) {
            super(str, i, null);
        }

        public byte[] decode(String str) {
            return Base16.decode(str);
        }

        public String encodeAsString(byte[] bArr) {
            return Base16.encodeAsString(bArr);
        }
    }

    public enum 2 extends EncodingSchemeEnum {
        public 2(String str, int i) {
            super(str, i, null);
        }

        public byte[] decode(String str) {
            return Base32.decode(str);
        }

        public String encodeAsString(byte[] bArr) {
            return Base32.encodeAsString(bArr);
        }
    }

    public enum 3 extends EncodingSchemeEnum {
        public 3(String str, int i) {
            super(str, i, null);
        }

        public byte[] decode(String str) {
            return Base64.decode(str);
        }

        public String encodeAsString(byte[] bArr) {
            return Base64.encodeAsString(bArr);
        }
    }

    static {
        1 r0 = new 1("BASE16", 0);
        BASE16 = r0;
        2 r1 = new 2("BASE32", 1);
        BASE32 = r1;
        3 r3 = new 3("BASE64", 2);
        BASE64 = r3;
        $VALUES = new EncodingSchemeEnum[]{r0, r1, r3};
    }

    private EncodingSchemeEnum(String str, int i) {
    }

    public static EncodingSchemeEnum valueOf(String str) {
        return (EncodingSchemeEnum) Enum.valueOf(EncodingSchemeEnum.class, str);
    }

    public static EncodingSchemeEnum[] values() {
        return (EncodingSchemeEnum[]) $VALUES.clone();
    }

    public abstract String encodeAsString(byte[] bArr);

    public /* synthetic */ EncodingSchemeEnum(String str, int i, 1 r3) {
        this(str, i);
    }
}
