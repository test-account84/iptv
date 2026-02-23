package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class RFC1522Codec {
    protected static final String POSTFIX = "?=";
    protected static final String PREFIX = "=?";
    protected static final char SEP = '?';

    public String decodeText(String str) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith("=?") || !str.endsWith("?=")) {
            throw new DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int indexOf = str.indexOf(63, 2);
        if (indexOf == length) {
            throw new DecoderException("RFC 1522 violation: charset token not found");
        }
        String substring = str.substring(2, indexOf);
        if (substring.equals("")) {
            throw new DecoderException("RFC 1522 violation: charset not specified");
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(63, i);
        if (indexOf2 == length) {
            throw new DecoderException("RFC 1522 violation: encoding token not found");
        }
        String substring2 = str.substring(i, indexOf2);
        if (getEncoding().equalsIgnoreCase(substring2)) {
            int i2 = indexOf2 + 1;
            return new String(doDecoding(StringUtils.getBytesUsAscii(str.substring(i2, str.indexOf(63, i2)))), substring);
        }
        throw new DecoderException("This codec cannot decode " + substring2 + " encoded content");
    }

    public abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    public abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    public String encodeText(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return encodeText(str, Charset.forName(str2));
    }

    public abstract String getEncoding();

    public String encodeText(String str, Charset charset) throws EncoderException {
        if (str == null) {
            return null;
        }
        return "=?" + charset + '?' + getEncoding() + '?' + StringUtils.newStringUsAscii(doEncoding(str.getBytes(charset))) + "?=";
    }
}
