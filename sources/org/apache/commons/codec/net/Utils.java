package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Utils {
    public static int digit16(byte b) throws DecoderException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + b);
    }
}
