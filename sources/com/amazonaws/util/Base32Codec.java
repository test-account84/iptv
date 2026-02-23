package com.amazonaws.util;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class Base32Codec extends AbstractBase32Codec {
    private static final int OFFSET = 26;
    private static final int OFFSET_OF_2 = 24;

    public static class LazyHolder {
        private static final byte[] DECODED = decodeTable();

        private LazyHolder() {
        }

        public static /* synthetic */ byte[] access$000() {
            return DECODED;
        }

        private static byte[] decodeTable() {
            byte[] bArr = new byte[123];
            for (int i = 0; i <= 122; i++) {
                if (i >= 65 && i <= 90) {
                    bArr[i] = (byte) (i - 65);
                } else if (i >= 50 && i <= 55) {
                    bArr[i] = (byte) (i - 24);
                } else if (i < 97 || i > 122) {
                    bArr[i] = -1;
                } else {
                    bArr[i] = (byte) (i - 97);
                }
            }
            return bArr;
        }
    }

    public Base32Codec() {
        super(alphabets());
    }

    private static byte[] alphabets() {
        return CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
    }

    public int pos(byte b) {
        byte b2 = LazyHolder.access$000()[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 32 character: '" + ((char) b) + "'");
    }
}
